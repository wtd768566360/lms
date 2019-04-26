package com.dada.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.dada.entity.SysCars;

@Mapper
public interface SysCarsMapper {
	boolean insert(SysCars record);

	boolean insertSelective(SysCars record);
    
    
    List<Map<String, Object>> selectAllInfo(SysCars record);
    
    boolean updateInfo(SysCars record);
    
}