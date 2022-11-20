package com.briup.user.dao;

import com.briup.user.bean.Log;

public interface LogMapper {
    int deleteByPrimaryKey(Long logId);

    int insert(Log record);

    int insertSelective(Log record);

    Log selectByPrimaryKey(Long logId);

    int updateByPrimaryKeySelective(Log record);

    int updateByPrimaryKey(Log record);
}