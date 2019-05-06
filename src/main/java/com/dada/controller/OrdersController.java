/**
 * Copyright 2019 TPRI. All Rights Reserved.
 */
package com.dada.controller;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.dada.common.ServerResponse;
import com.dada.entity.OrderHistory;
import com.dada.entity.Orders;
import com.dada.model.OrderModel;
import com.dada.service.ILineCarBindService;
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

	@Autowired
	private ILineCarBindService lineCarBindService;

	@RequestMapping(value = "/page.do", method = RequestMethod.GET)
	@ResponseBody
	public ServerResponse page(Orders orders, int page, int limit, String token, String memberNo1) {
		Map<String, Object> map = this.ordersService.findPage(orders, page, limit, token, memberNo1);
		if (map != null && !map.isEmpty()) {
			this.logger.info(token + "获取订单列表成功...");
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
		if (ordersService.updateStatus(orders)) {
			this.logger.info("修改订单状态成功...");
			return ServerResponse.createBySuccess();
		} else {
			this.logger.info("修改订单状态失败...");
			return ServerResponse.createByErrorMessage("修改订单状态失败");
		}
	}


	@RequestMapping(value = "/confirmGoods.do", method = RequestMethod.POST)
	@ResponseBody
	public ServerResponse confirmGoods(String orderid, String carid, String lineid) {

		if (lineCarBindService.addCarAndLine(orderid, carid, lineid)) {
			this.logger.info("修改订单状态成功...");
			return ServerResponse.createBySuccess();
		} else {
			this.logger.info("修改订单状态失败...");
			return ServerResponse.createByErrorMessage("修改订单状态失败");
		}
	}

	
	@RequestMapping(value = "inserOrders.do", method = { RequestMethod.POST })
	@ResponseBody
	public ServerResponse insertOrders1(@RequestBody String o) {
		o=o.substring(1, o.length()-1);
		Orders order = JSON.parseObject(o, Orders.class);
		ServerResponse serverresponse = null;
		boolean bool=ordersService.insertOrder(order);
		if(bool) {
			logger.info("增加订单信息成功");
			serverresponse = ServerResponse.createBySuccessMessage("增加订单信息成功");
		}else {
			logger.info("增加车辆信息失败");
			serverresponse = ServerResponse.createBySuccessMessage("增加车辆信息失败");
		}
		return serverresponse;
	}
	
	@RequestMapping(value="selectCount.do",method=RequestMethod.GET)
	@ResponseBody
	public ServerResponse selectCount(String year) {
		String[] s = year.split("-");
		ServerResponse serverresponse=null;
		List<Map<String, Object>> orders=ordersService.selectCount(s[0], s[1]);
		//System.out.println(orders);
		if(orders.size()>0) {
			logger.info("统计查询成功");
			serverresponse = ServerResponse.createBySuccess("统计查询成功",orders);
		}else {
			logger.info("统计查询失败");
			serverresponse = ServerResponse.createByErrorMessage("统计查询失败");
		}
		return serverresponse;
	}
}
