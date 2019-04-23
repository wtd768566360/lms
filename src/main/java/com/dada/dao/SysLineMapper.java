package com.dada.dao;

import org.apache.ibatis.annotations.Mapper;

import com.dada.entity.SysLine;

@Mapper
public interface SysLineMapper {
    int insert(SysLine record);

    int insertSelective(SysLine record);
}