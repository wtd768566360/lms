package com.dada.dao;

import org.apache.ibatis.annotations.Mapper;

import com.dada.entity.OperationLog;

@Mapper
public interface OperationLogMapper {
    int insert(OperationLog record);

    int insertSelective(OperationLog record);
}