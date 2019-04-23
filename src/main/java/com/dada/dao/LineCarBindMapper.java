package com.dada.dao;

import org.apache.ibatis.annotations.Mapper;

import com.dada.entity.LineCarBind;

@Mapper
public interface LineCarBindMapper {
    int insert(LineCarBind record);

    int insertSelective(LineCarBind record);
}