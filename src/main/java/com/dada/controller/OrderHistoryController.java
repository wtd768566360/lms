/**
 * Copyright 2019 TPRI. All Rights Reserved.
 */
package com.dada.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dada.common.ServerResponse;
import com.dada.entity.OrderHistory;
import com.dada.service.IOrderHistoryService;

/**
 * <B>系统名称：</B><BR>
 * <B>模块名称：</B><BR>
 * <B>中文类名：</B><BR>
 * <B>概要说明：</B><BR>
 * 
 * @author（WuTengda） @since 2019年4月19日
 */

@Controller
public class OrderHistoryController {

	private final Logger logger = LoggerFactory.getLogger(OrderHistoryController.class);
	@Autowired
	private IOrderHistoryService orderHistoryService;
	
	@RequestMapping(value="selectHistorysOrderid.do",method= {RequestMethod.POST})
	@ResponseBody
	public ServerResponse selectHistorys(OrderHistory his) {
		List<OrderHistory> ors = orderHistoryService.selectHistorys(his);
		if(ors.size()>0) {
			logger.info("获取订单信息成功");
			return ServerResponse.createBySuccess("seccess", ors);
		}else {
			logger.info("获取订单信息失败");
			return ServerResponse.createByErrorMessage("获取车辆信息失败");
		}
	}
}
