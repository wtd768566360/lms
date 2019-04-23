package com.dada.dao;

import org.apache.ibatis.annotations.Mapper;

import com.dada.entity.SysStations;

@Mapper
public interface SysStationsMapper {
    int insert(SysStations record);

    int insertSelective(SysStations record);
}