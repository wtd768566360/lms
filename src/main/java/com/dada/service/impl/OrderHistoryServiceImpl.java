/**
 * Copyright 2019 TPRI. All Rights Reserved.
 */
package com.dada.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dada.dao.OrderHistoryMapper;
import com.dada.entity.OrderHistory;
import com.dada.service.IOrderHistoryService;

/**
 * <B>系统名称：</B><BR>
 * <B>模块名称：</B><BR>
 * <B>中文类名：</B><BR>
 * <B>概要说明：</B><BR>
 * @author（WuTengda）
 * @since 2019年4月19日
 */
@Service
public class OrderHistoryServiceImpl implements IOrderHistoryService {

	@Autowired
	private OrderHistoryMapper orderHistoryMapper;
	
	
	@Override
	public List<OrderHistory> selectHistorys(OrderHistory his) {
		
		return orderHistoryMapper.selectHistorys(his);
	}

}
