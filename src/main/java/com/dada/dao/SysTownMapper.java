package com.dada.dao;

import org.apache.ibatis.annotations.Mapper;

import com.dada.entity.SysTown;

@Mapper
public interface SysTownMapper {
    int insert(SysTown record);

    int insertSelective(SysTown record);
}