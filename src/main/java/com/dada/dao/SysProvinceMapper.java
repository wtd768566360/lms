package com.dada.dao;

import org.apache.ibatis.annotations.Mapper;

import com.dada.entity.SysProvince;

@Mapper
public interface SysProvinceMapper {
    int insert(SysProvince record);

    int insertSelective(SysProvince record);
}