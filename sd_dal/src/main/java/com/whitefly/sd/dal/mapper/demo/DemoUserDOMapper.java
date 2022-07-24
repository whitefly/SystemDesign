package com.whitefly.sd.dal.mapper.demo;

import com.whitefly.sd.dal.dataobject.demo.DemoUserDO;

import java.util.List;

public interface DemoUserDOMapper {
    int deleteByPrimaryKey(Long id);

    int insert(DemoUserDO record);

    List<DemoUserDO> query(DemoUserDO record);

    int insertSelective(DemoUserDO record);

    DemoUserDO selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(DemoUserDO record);

    int updateByPrimaryKey(DemoUserDO record);
}