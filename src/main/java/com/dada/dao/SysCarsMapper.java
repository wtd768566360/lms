package com.dada.dao;

import org.apache.ibatis.annotations.Mapper;

import com.dada.entity.SysCars;

@Mapper
public interface SysCarsMapper {
    int insert(SysCars record);

    int insertSelective(SysCars record);
}