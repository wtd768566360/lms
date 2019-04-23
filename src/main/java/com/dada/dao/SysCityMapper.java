package com.dada.dao;

import org.apache.ibatis.annotations.Mapper;

import com.dada.entity.SysCity;

@Mapper
public interface SysCityMapper {
    int insert(SysCity record);

    int insertSelective(SysCity record);
}