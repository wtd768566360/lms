/**
 * Copyright 2019 TPRI. All Rights Reserved.
 */
package com.dada.controller;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dada.common.ServerResponse;
import com.dada.entity.Orders;
import com.dada.model.OrderModel;
import com.dada.service.IOrdersService;

/**
 * <B>系统名称：</B><BR>
 * <B>模块名称：</B><BR>
 * <B>中文类名：</B><BR>
 * <B>概要说明：</B><BR>
 * 
 * @author（WuTengda） @since 2019年4月19日
 */

@Controller
@RequestMapping("/order")
public class OrdersController {

	private final Logger logger = LoggerFactory.getLogger(SysLineController.class);

	@Autowired
	private IOrdersService ordersService;

	@RequestMapping(value = "/page.do", method = RequestMethod.GET)
	@ResponseBody
	public ServerResponse page(Orders orders, int page, int limit) {
		Map<String, Object> map = this.ordersService.findPage(orders, page, limit);
		if (map != null && !map.isEmpty()) {
			this.logger.info("获取订单列表成功...");
			return ServerResponse.createByPageSuccess("获取订单列表成功", String.valueOf(map.get("totalCount")),
					map.get("list"));
		}
		this.logger.info("获取订单列表失败...");
		return ServerResponse.createByErrorMessage("获取订单列表失败");
	}

	@RequestMapping(value = "/add.do", method = RequestMethod.GET)
	@ResponseBody
	public ServerResponse add(OrderModel orderModel) {
		
		return ServerResponse.createByErrorMessage("获取线路列表失败");
	}

	@RequestMapping(value = "/update.do", method = RequestMethod.POST)
	@ResponseBody
	public ServerResponse updateStatus(Orders orders) {
		if(ordersService.updateStatus(orders)){
			this.logger.info("修改订单状态失败...");
			return ServerResponse.createBySuccess();
		}else{
			this.logger.info("修改订单状态失败...");
			return ServerResponse.createByErrorMessage("修改订单状态失败");
		}
	}
}
