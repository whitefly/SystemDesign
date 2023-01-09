package com.whitefly.sd.demo.service.impl;

import com.whitefly.sd.dal.dataobject.demo.DemoUserDO;
import com.whitefly.sd.dal.mapper.demo.DemoUserDOMapper;
import com.whitefly.sd.demo.service.api.PersonService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Slf4j
@Component
public class PersonServiceImpl implements PersonService {

    @Autowired
    private DemoUserDOMapper demoUserMapper;

    @Autowired
    private PersonServiceImpl personService;


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

    @Override
    public List<DemoUserDO> randomAdd() {
        try {
            return personService.test();
        } catch (Exception e) {
            log.info("插入异常 {}", "randomAdd", e);
            return Collections.emptyList();
        }
    }

    @Transactional
    public List<DemoUserDO> test() {
        List<DemoUserDO> result = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            personService.test1();
            DemoUserDO demoUserDO = new DemoUserDO();
            demoUserDO.setEmail("fuck");
            demoUserDO.setName("zhouang" + i);
            int insert = demoUserMapper.insert(demoUserDO);
            log.info("{}", insert);
            log.info("{}", demoUserDO);
            if (i == 2) {
                throw new RuntimeException("插入失败");
            }
        }

        return result;
    }

    public void test1() {
        DemoUserDO demoUserDO = new DemoUserDO();
        demoUserDO.setEmail("fuck");
        demoUserDO.setName("zhouang" + "other");
        int insert = demoUserMapper.insert(demoUserDO);
        log.info("{}", demoUserDO);
    }


}
