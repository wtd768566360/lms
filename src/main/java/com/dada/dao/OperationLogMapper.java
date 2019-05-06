package com.dada.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.dada.entity.OperationLog;

@Mapper
public interface OperationLogMapper {
    int insert(OperationLog record);

    int insertSelective(OperationLog record);
    
    List<Map<String, Object>>    selectLoginfo();
}