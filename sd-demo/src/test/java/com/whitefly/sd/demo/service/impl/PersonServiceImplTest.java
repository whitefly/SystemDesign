package com.whitefly.sd.demo.service.impl;

import com.whitefly.sd.dal.dataobject.demo.DemoUserDO;
import com.whitefly.sd.dal.mapper.demo.DemoUserDOMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class PersonServiceImplTest {

    @Mock
    private DemoUserDOMapper mockDemoUserMapper;
    @Mock
    private PersonServiceImpl mockPersonService;

    @InjectMocks
    private PersonServiceImpl personServiceImplUnderTest;

    @Test
    public void testAddUser() {
        // Setup
        final DemoUserDO demoUserDO = new DemoUserDO();
        demoUserDO.setId(0L);
        demoUserDO.setName("name");
        demoUserDO.setHobby("hobby");
        demoUserDO.setEmail("email");
        demoUserDO.setMobilePhone(0L);

        when(mockDemoUserMapper.insert(any(DemoUserDO.class))).thenReturn(0);

        // Run the test
        final Long result = personServiceImplUnderTest.addUser(demoUserDO);

        Long expected = 0L;

        // Verify the results
        assertEquals(expected, result);
    }

    @Test
    public void testUserList() {
        // Setup
        // Configure DemoUserDOMapper.query(...).
        final DemoUserDO demoUserDO = new DemoUserDO();
        demoUserDO.setId(0L);
        demoUserDO.setName("name");
        demoUserDO.setHobby("hobby");
        demoUserDO.setEmail("email");
        demoUserDO.setMobilePhone(0L);
        final List<DemoUserDO> demoUserDOS = Arrays.asList(demoUserDO);
        when(mockDemoUserMapper.query(any(DemoUserDO.class))).thenReturn(demoUserDOS);

        // Run the test
        final List<DemoUserDO> result = personServiceImplUnderTest.userList();

        // Verify the results
    }

    @Test
    public void testUserList_DemoUserDOMapperReturnsNoItems() {
        // Setup
        when(mockDemoUserMapper.query(any(DemoUserDO.class))).thenReturn(Collections.emptyList());

        // Run the test
        final List<DemoUserDO> result = personServiceImplUnderTest.userList();

        // Verify the results
        assertEquals(Collections.emptyList(), result);
    }

    @Test
    public void testRandomAdd() {
        // Setup
        // Configure PersonServiceImpl.test(...).
        final DemoUserDO demoUserDO = new DemoUserDO();
        demoUserDO.setId(0L);
        demoUserDO.setName("name");
        demoUserDO.setHobby("hobby");
        demoUserDO.setEmail("email");
        demoUserDO.setMobilePhone(0L);
        final List<DemoUserDO> demoUserDOS = Arrays.asList(demoUserDO);
        when(mockPersonService.test()).thenReturn(demoUserDOS);

        // Run the test
        final List<DemoUserDO> result = personServiceImplUnderTest.randomAdd();

        // Verify the results
    }

    @Test
    public void testRandomAdd_PersonServiceImplReturnsNoItems() {
        // Setup
        when(mockPersonService.test()).thenReturn(Collections.emptyList());

        // Run the test
        final List<DemoUserDO> result = personServiceImplUnderTest.randomAdd();

        // Verify the results
        assertEquals(Collections.emptyList(), result);
    }

    @Test
    public void testHandle() {
        // Setup
        // Configure DemoUserDOMapper.query(...).
        final DemoUserDO demoUserDO = new DemoUserDO();
        demoUserDO.setId(0L);
        demoUserDO.setName("name");
        demoUserDO.setHobby("hobby");
        demoUserDO.setEmail("email");
        demoUserDO.setMobilePhone(0L);
        final List<DemoUserDO> demoUserDOS = Arrays.asList(demoUserDO);
        when(mockDemoUserMapper.query(any(DemoUserDO.class))).thenReturn(demoUserDOS);

        // Run the test
        personServiceImplUnderTest.handle();

        // Verify the results
    }

    @Test
    public void testHandle_DemoUserDOMapperReturnsNoItems() {
        // Setup
        when(mockDemoUserMapper.query(any(DemoUserDO.class))).thenReturn(Collections.emptyList());

        // Run the test
        personServiceImplUnderTest.handle();

        // Verify the results
    }

    @Test
    public void testTest() {
        // Setup
        when(mockDemoUserMapper.insert(any(DemoUserDO.class))).thenReturn(0);

        // Run the test
        final List<DemoUserDO> result = personServiceImplUnderTest.test();

        // Verify the results
        verify(mockPersonService).test1();
    }

    @Test
    public void testTest1() {
        // Setup
        when(mockDemoUserMapper.insert(any(DemoUserDO.class))).thenReturn(0);

        // Run the test
        personServiceImplUnderTest.test1();

        // Verify the results
    }
}
