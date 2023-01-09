package com.whitefly.sd.demo.service.impl;

import com.whitefly.sd.dal.dataobject.demo.DemoUserDO;
import com.whitefly.sd.dal.mapper.demo.DemoUserDOMapper;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;


@RunWith(MockitoJUnitRunner.class)
public class PersonServiceImplTest {
    @Mock
    private DemoUserDOMapper demoUserMapper;

    @InjectMocks
    private PersonServiceImpl personServiceUnderMock;


    @Test
    public void addUserCase1() {
        when(demoUserMapper.insert(any())).thenReturn(0);

        long actual = personServiceUnderMock.addUser(new DemoUserDO());

        Assert.assertEquals(0L, actual);
    }

    @Test
    public void handle() {
        personServiceUnderMock.handle();
        verify(demoUserMapper, times(1)).query(any());
    }
}