/**
 * Copyright 2019 TPRI. All Rights Reserved.
 */
package com.dada.service;

import java.util.Map;

import com.dada.entity.Orders;

/**
 * <B>系统名称：</B><BR>
 * <B>模块名称：</B><BR>
 * <B>中文类名：</B><BR>
 * <B>概要说明：</B><BR>
 * @author （WuTengda）
 * @since 2019年4月19日
 */
public interface IOrdersService {

	Map<String, Object> findPage(Orders orders, int page, int limit);

	boolean updateStatus(Orders orders);
	
	boolean insertOrder(Orders order);

}
