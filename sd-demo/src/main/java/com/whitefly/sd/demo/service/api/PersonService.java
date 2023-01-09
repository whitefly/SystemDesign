package com.whitefly.sd.demo.service.api;

import com.whitefly.sd.dal.dataobject.demo.DemoUserDO;

import java.util.List;

public interface PersonService {

    Long addUser(DemoUserDO demoUserDO);

    List<DemoUserDO> userList();

    List<DemoUserDO> randomAdd();

    void handle();
}
