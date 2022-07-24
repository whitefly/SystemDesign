package com.whitefly.sd.demo.controller;


import com.whitefly.sd.common.web.response.ApiResponse;
import com.whitefly.sd.common.web.util.ResponseUtil;
import com.whitefly.sd.dal.dataobject.demo.DemoUserDO;
import com.whitefly.sd.demo.service.api.PersonService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author zhouang
 * @date 2022年07月19日
 */
@Slf4j
@RestController
@RequestMapping(value = "/api/demo")
public class HelloController {

    @Autowired
    private PersonService personService;


    @GetMapping(value = "hi")
    public ApiResponse<String> hi() {
        return ResponseUtil.packSuccess("hi");
    }

    @GetMapping(value = "/user/add")
    public ApiResponse<Long> addUser(DemoUserDO demoUserDO) {
        log.info("{}", demoUserDO);
        return ResponseUtil.packSuccess(personService.addUser(demoUserDO));
    }

    @GetMapping(value = "/user/list")
    public ApiResponse<List<DemoUserDO>> listUser() {
        return ResponseUtil.packSuccess(personService.userList());
    }

}
