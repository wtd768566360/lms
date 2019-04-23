package com.dada.dao;

import org.apache.ibatis.annotations.Mapper;

import com.dada.entity.OrderHistory;

@Mapper
public interface OrderHistoryMapper {
    int insert(OrderHistory record);

    int insertSelective(OrderHistory record);
}