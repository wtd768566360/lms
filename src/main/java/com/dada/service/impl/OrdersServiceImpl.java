/**
 * Copyright 2019 TPRI. All Rights Reserved.
 */
package com.dada.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dada.dao.OrdersMapper;
import com.dada.entity.Member;
import com.dada.entity.Orders;
import com.dada.service.IMemberService;
import com.dada.service.IOrdersService;

/**
 * <B>系统名称：</B><BR>
 * <B>模块名称：</B><BR>
 * <B>中文类名：</B><BR>
 * <B>概要说明：</B><BR>
 * 
 * @author（WuTengda） @since 2019年4月19日
 */
@Service
public class OrdersServiceImpl implements IOrdersService {

	@Resource
	private OrdersMapper ordersMapper;

	@Autowired
	private IMemberService memberService;

	/**
	 * <B>概要说明：分页</B><BR>
	 * 
	 * @see com.dada.service.IOrdersService#findPage(com.dada.entity.Orders,
	 *      int, int)
	 */
	@Override
	public Map<String, Object> findPage(Orders orders, int page, int limit, String token, String memberNo) {
		// TODO Auto-generated method stub
		if (!token.equals("0")) {
			orders.setCreatorId(memberNo);
		}
		Map<String, Object> map = new HashMap<>(2);
		List<Orders> list = this.ordersMapper.findPage(orders);
		// 从第几条数据开始
		int firstIndex = (page - 1) * (limit);
		// 到第几条数据结束
		int lastIndex = 0;
		if (list.size() > page * limit) {

			lastIndex = page * limit;
		} else {
			lastIndex = list.size();
		}
		int count = this.ordersMapper.findPageByCount(orders);
		map.put("list", list.subList(firstIndex, lastIndex));
		map.put("totalCount", count);
		return map;
	}

	/**
	 * <B>方法名称：</B><BR>
	 * <B>概要说明：</B><BR>
	 * 
	 * @see com.dada.service.IOrdersService#updateStatus(com.dada.entity.Orders)
	 */
	@Override
	public boolean updateStatus(Orders orders) {
		// TODO Auto-generated method stub
		if (orders.getStatus() == 2) {
			orders.setReceiptTime(new Date());
		} else {
			orders.setDeliveryTime(new Date());
		}
		Member member = memberService.selectMember();
		orders.setModifierId(member.getId());
		orders.setModifyTime(new Date());
		if (ordersMapper.updateStatus(orders) > 0) {
			return true;
		} else {
			return false;
		}
	}
}
