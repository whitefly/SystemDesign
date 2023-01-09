package com.whitefly.sd.demo.service.impl;

import com.whitefly.sd.dal.dataobject.demo.DemoUserDO;
import com.whitefly.sd.demo.service.api.PersonService;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PersonServiceImpl1 implements PersonService {
    @Override
    public Long addUser(DemoUserDO demoUserDO) {
        return null;
    }

    @Override
    public List<DemoUserDO> userList() {
        return null;
    }

    @Override
    public List<DemoUserDO> randomAdd() {
        return null;
    }

    @Override
    public void handle() {
        return;
    }
}
