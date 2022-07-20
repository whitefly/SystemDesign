package com.whitefly.sd.dal.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author zhouang
 * @date 2022年07月19日
 */
@Controller
@RequestMapping(value = "/api")
public class HelloController {

    @PostMapping("/hello")
    public String hello() {
        return "hi";
    }
}
