package com.dada.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.dada.entity.OrderHistory;

@Mapper
public interface OrderHistoryMapper {
    int insert(OrderHistory record);

    int insertSelective(OrderHistory record);
    
    List<OrderHistory> selectHistorys(OrderHistory his);
}