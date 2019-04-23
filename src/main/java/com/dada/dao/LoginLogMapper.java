package com.dada.dao;

import org.apache.ibatis.annotations.Mapper;

import com.dada.entity.LoginLog;

@Mapper
public interface LoginLogMapper {
    int insert(LoginLog record);

    int insertSelective(LoginLog record);
}