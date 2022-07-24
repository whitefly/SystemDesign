package com.whitefly.sd.demo.service.impl;

import com.whitefly.sd.dal.dataobject.demo.DemoUserDO;
import com.whitefly.sd.dal.mapper.demo.DemoUserDOMapper;
import com.whitefly.sd.demo.service.api.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PersonServiceImpl implements PersonService {

    @Autowired
    private DemoUserDOMapper demoUserMapper;


    @Override
    public Long addUser(DemoUserDO demoUserDO) {
        int insert = demoUserMapper.insert(demoUserDO);
        return (long) insert;
    }

    @Override
    public List<DemoUserDO> userList() {
        DemoUserDO demoUserDO = new DemoUserDO();
        return demoUserMapper.query(demoUserDO);
    }
}
