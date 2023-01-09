package com.whitefly.sd.demo.controller;

import com.whitefly.sd.common.web.SdAbstractController;
import com.whitefly.sd.common.web.response.ApiResponse;
import com.whitefly.sd.common.web.util.ResponseUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.util.Random;


@Slf4j
@RestController
@RequestMapping("/log")
public class LogController extends SdAbstractController {
    static Random random = new Random();

    @RequestMapping("show1")
    public ApiResponse<String> show1(String name, Integer num) {
        Cookie[] cookies = httpServletRequest.getCookies();
//        log.info("cookie: {}", Arrays.toString(cookies));
//        httpServletResponse.addCookie(new Cookie("fuck", random.nextInt(1000) + ""));
        return ResponseUtil.packSuccess(name);
    }

    @RequestMapping("show2")
    public ApiResponse<Integer> show(Integer num) {
        return ResponseUtil.packSuccess(num);
    }

    @RequestMapping("show3")
    public ApiResponse<String> show(HttpServletRequest httpServletRequest) {
        return ResponseUtil.packSuccess("fuck");
    }

}

