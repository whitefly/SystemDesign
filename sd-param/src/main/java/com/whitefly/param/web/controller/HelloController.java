package com.whitefly.param.web.controller;

import com.whitefly.common.web.response.ApiResponse;
import com.whitefly.common.web.util.ResponseUtil;
import com.whitefly.param.web.vo.PersonVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/param")
@Slf4j
public class HelloController {


    @RequestMapping("/query")
    public ApiResponse<String> query(@RequestBody PersonVO vo) {
        log.info("query !  param : {}", vo);
        return ResponseUtil.packSuccess("hi");
    }


    @RequestMapping("/delete")
    public ApiResponse<Boolean> deletePerson(@RequestBody Map<String, String> params) {
        log.info("deletePerson !  param : {}", params);
        try {
            int id = Integer.parseInt(params.get("id"));
            log.info("id: {} ", id);
            return ResponseUtil.packSuccess(Boolean.TRUE);
        } catch (Exception e) {
            return ResponseUtil.packFail("id format error");
        }

    }

}

