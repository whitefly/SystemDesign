package com.whitefly.sd.demo.service.impl;

import com.whitefly.sd.demo.service.api.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Map;

@Component
public class PersonServiceFactory {

    @Autowired
    private ApplicationContext applicationContext;

    private Map<String, PersonService> personServiceMap;


    @PostConstruct
    void init() {
        personServiceMap = applicationContext.getBeansOfType(PersonService.class);
    }

    public PersonService getService(String beanName) {
        return personServiceMap.get(beanName);
    }
}
