/**
 * Copyright 2019 TPRI. All Rights Reserved.
 */
package com.dada.service.impl;

import java.util.Date;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dada.dao.LineCarBindMapper;
import com.dada.entity.LineCarBind;
import com.dada.entity.Member;
import com.dada.entity.Orders;
import com.dada.service.ILineCarBindService;
import com.dada.service.IMemberService;
import com.dada.service.IOrdersService;
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
public class LineCarBindServiceImpl implements ILineCarBindService {

	@Resource
	private LineCarBindMapper lineCarBindMapper;

	@Autowired
	private IMemberService memberService;

	@Autowired
	private IOrdersService ordersService;

	/**
	 * <B>概要说明：添加</B><BR>
	 * 
	 * @see com.dada.service.ILineCarBindService#addCarAndLine(java.lang.String,
	 *      java.lang.String, java.lang.String)
	 */
	@Override
	public boolean addCarAndLine(String orderid, String carid, String lineid) {
		// TODO Auto-generated method stub
		Member member = memberService.selectMember();
		LineCarBind lineCarBind = new LineCarBind();
		lineCarBind.setId(UUIDUtils.getUUID());
		lineCarBind.setCarId(carid);
		lineCarBind.setLineId(lineid);
		lineCarBind.setIsDeleted(false);
		lineCarBind.setCreatorId(member.getId());
		lineCarBind.setModifierId(member.getId());
		lineCarBind.setCreateTime(new Date());
		lineCarBind.setModifyTime(new Date());
		if (lineCarBindMapper.insertSelective(lineCarBind) > 0) {
			Orders orders = new Orders();
			orders.setId(orderid);
			orders.setStatus(1);
			orders.setCarId(lineCarBind.getId());
			if (ordersService.updateStatus(orders)) {
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}
}
