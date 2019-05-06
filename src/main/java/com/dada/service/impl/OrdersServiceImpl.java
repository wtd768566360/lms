/**
 * Copyright 2019 TPRI. All Rights Reserved.
 */
package com.dada.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dada.dao.OrderHistoryMapper;
import com.dada.dao.OrdersMapper;
import com.dada.entity.Member;
import com.dada.entity.OperationLog;
import com.dada.entity.OrderHistory;
import com.dada.entity.Orders;
import com.dada.entity.SysStations;
import com.dada.service.IMemberService;
import com.dada.service.IOperationLogService;
import com.dada.service.IOrdersService;
import com.dada.service.ISysStationsService;
import com.dada.utils.IPUtils;
import com.dada.utils.UUIDUtils;

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

	@Resource
	private OrderHistoryMapper orderhistorymapper;
	@Autowired
	private ISysStationsService sysStationsService;
	@Autowired
	private IOperationLogService operationLogService;
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

	@Override
	public boolean insertOrder(Orders order) {
		order.setId(UUIDUtils.getUUID());
		order.setOrderNo(UUIDUtils.getNo());
		Member member = memberService.selectMember();
		List<SysStations> sysStas = sysStationsService.selectSysStaMemberNo(member);
		order.setStartSite(sysStas.get(0).getAddress());
		order.setDeliveryTime(new Date());
		order.setStatus(0);
		order.setCreatorId(member.getId());
		order.setCreateTime(new Date());
		int res=ordersMapper.insertSelective(order);
		if(res>0) {
			operationLogService.addOperationLog(new OperationLog(UUIDUtils.getUUID(), member.getMemberNo(),
					member.getRealname(), IPUtils.getIpAddr(MemberServiceImpl.getRequest()), MemberServiceImpl.getRequest().getRequestURI(), "增加订单",
					"增加", "增加订单成功", new Date()));
			for(OrderHistory h:order.getOrderhistorys()) {
				h.setId(UUIDUtils.getUUID());
				//订单id
				h.setOrderId(order.getId());
				h.setInTime(new Date());
				h.setStatus(0);
				h.setCreatorId(member.getId());
				h.setCreateTime(new Date());
				int s=orderhistorymapper.insertSelective(h);
				if(s>0) {
					operationLogService.addOperationLog(new OperationLog(UUIDUtils.getUUID(), member.getMemberNo(),
							member.getRealname(), IPUtils.getIpAddr(MemberServiceImpl.getRequest()), MemberServiceImpl.getRequest().getRequestURI(), "增加订单信息",
							"增加", "增加订单信息成功", new Date()));
				}else {
					operationLogService.addOperationLog(new OperationLog(UUIDUtils.getUUID(), member.getMemberNo(),
							member.getRealname(), IPUtils.getIpAddr(MemberServiceImpl.getRequest()), MemberServiceImpl.getRequest().getRequestURI(), "增加订单信息",
							"增加", "增加订单信息失败", new Date()));
				}
			}
		}else {
			operationLogService.addOperationLog(new OperationLog(UUIDUtils.getUUID(), member.getMemberNo(),
					member.getRealname(), IPUtils.getIpAddr(MemberServiceImpl.getRequest()), MemberServiceImpl.getRequest().getRequestURI(), "增加订单",
					"增加", "增加订单失败", new Date()));
		}
		
		return true;
	}

	
	@Override
	public List<Map<String, Object>> selectCount(String year,String item) {
		Map<String, Object> map=new HashMap<String, Object>();
		List<Map<String, Object>> m=new ArrayList<Map<String,Object>>();
		map.put("year", year);
		int start=0;
		int end=0;
		if(item.equals("0")) {
			start=1;
			end=6;
		}else if(item.equals("6")) {
			start=7;
			end=12;
		}else if(item.equals("12")) {
			start=1;
			end=12;
		}
		
		int i=0;
		int count=0;
		for(i=start;i<=end;i++) {
			map.put("month", i);
			count=ordersMapper.selectCount(map);
			Map<String, Object> ret=new HashMap<String, Object>();
			ret.put("month", i);
			ret.put("data", count);
			m.add(ret);
		}
		return m;
	}
}
