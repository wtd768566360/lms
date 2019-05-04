package com.dada.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.dada.entity.SysLine;

@Mapper
public interface SysLineMapper {
    int insert(SysLine record);

    int insertSelective(SysLine record);

	List<SysLine> findPage(SysLine sysLine);

	int findPageByCount(SysLine sysLine);

	int remove(SysLine sysLine);
}