package com.dada.dao;

import org.apache.ibatis.annotations.Mapper;

import com.dada.entity.SysCounty;

@Mapper
public interface SysCountyMapper {
    int insert(SysCounty record);

    int insertSelective(SysCounty record);
}