/**
 * Copyright 2019 TPRI. All Rights Reserved.
 */
package com.dada.service;

import java.util.List;

import com.dada.entity.OrderHistory;

/**
 * <B>系统名称：</B><BR>
 * <B>模块名称：</B><BR>
 * <B>中文类名：</B><BR>
 * <B>概要说明：</B><BR>
 * @author （WuTengda）
 * @since 2019年4月19日
 */
public interface IOrderHistoryService {
	List<OrderHistory> selectHistorys(OrderHistory his);
}
