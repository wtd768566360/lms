package com.dada.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.dada.entity.Orders;

@Mapper
public interface OrdersMapper {
	int insert(Orders record);

	int insertSelective(Orders record);

	List<Orders> findPage(Orders orders);

	int findPageByCount(Orders orders);

	int updateStatus(Orders orders);
	
	Integer selectCount(Map<String, Object> map);
}