package com.whitefly.sd.demo.controller;


import com.whitefly.sd.common.web.response.ApiResponse;
import com.whitefly.sd.common.web.util.ResponseUtil;
import com.whitefly.sd.dal.dataobject.demo.DemoUserDO;
import com.whitefly.sd.demo.service.api.PersonService;
import com.whitefly.sd.demo.service.impl.PersonServiceFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
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
    @Qualifier("personServiceImpl")
    private PersonService personService;
    @Autowired
    private PersonServiceFactory personServiceFactory;


    @GetMapping(value = "hi")
    public ApiResponse<String> hi() {
        return ResponseUtil.packSuccess("hi");
    }

    @GetMapping(value = "show")
    public String show() {
        return "<!DOCTYPE html>\n" +
                "<html lang='en'>\n" +
                "<head>\n" +
                "    <meta charset='UTF-8'>\n" +
                "    <title>Title</title>\n" +
                "</head>\n" +
                "<body>\n" +
                "我是小oo\n" +
                "<img src='https://t7.baidu.com/it/u=3676218341,3686214618&fm=193&f=GIF'>\n" +
                "</body>\n" +
                "</html>";
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

    @GetMapping(value = "/user/test")
    public ApiResponse<List<DemoUserDO>> test() {
        return ResponseUtil.packSuccess(personService.randomAdd());
    }


    @GetMapping(value = "/user/test1")
    public ApiResponse<String> test1() {
        PersonService fuck = personServiceFactory.getService("fuck");
        return ResponseUtil.packSuccess("fuck");
    }
}
