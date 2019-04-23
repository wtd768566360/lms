package com.dada.dao;

import org.apache.ibatis.annotations.Mapper;

import com.dada.entity.Orders;

@Mapper
public interface OrdersMapper {
    int insert(Orders record);

    int insertSelective(Orders record);
}