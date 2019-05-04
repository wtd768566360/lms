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

import com.dada.dao.SysLineMapper;
import com.dada.entity.Member;
import com.dada.entity.SysLine;
import com.dada.entity.SysStations;
import com.dada.service.IMemberService;
import com.dada.service.ISysLineService;
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
public class SysLineServiceImpl implements ISysLineService {

	@Resource
	private SysLineMapper sysLineMapper;

	@Autowired
	private IMemberService memberService;

	/**
	 * <B>概要说明：添加路线</B><BR>
	 * 
	 * @see com.dada.service.ISysLineService#add(com.dada.entity.SysLine)
	 */
	@Override
	public boolean add(SysLine sysLine) {
		// TODO Auto-generated method stub
		Member member = memberService.selectMember();
		sysLine.setId(UUIDUtils.getUUID());
		sysLine.setCreatorId(member.getId());
		sysLine.setCreateTime(new Date());
		sysLine.setModifierId(member.getId());
		sysLine.setModifyTime(new Date());
		sysLine.setIsDeleted(false);
		if (sysLineMapper.insertSelective(sysLine) > 0) {
			return true;
		}
		return false;
	}

	/**
	 * <B>概要说明：分页</B><BR>
	 * 
	 * @see com.dada.service.ISysLineService#findPage(com.dada.entity.SysStations,
	 *      int, int)
	 */
	@Override
	public Map<String, Object> findPage(SysLine sysLine, int page, int limit) {
		Map<String, Object> map = new HashMap<>(2);
		List<SysLine> list = this.sysLineMapper.findPage(sysLine);
		// 从第几条数据开始
		int firstIndex = (page - 1) * (limit);
		// 到第几条数据结束
		int lastIndex = 0;
		if (list.size() > page * limit) {
			lastIndex = page * limit;
		} else {
			lastIndex = list.size();
		}
		int count = this.sysLineMapper.findPageByCount(sysLine);
		map.put("list", list.subList(firstIndex, lastIndex));
		map.put("totalCount", count);
		return map;
	}

	/**
	 * <B>概要说明：删除线路</B><BR>
	 * 
	 * @see com.dada.service.ISysLineService#remove(java.lang.String,
	 *      java.lang.String)
	 */
	@Override
	public boolean remove(String id, String userId) {
		// TODO Auto-generated method stub
		Member member = memberService.selectMember();
		SysLine sysLine = new SysLine();
		sysLine.setModifierId(member.getId());
		sysLine.setCreateTime(new Date());
		sysLine.setIsDeleted(true);
		sysLine.setId(id);
		return sysLineMapper.remove(sysLine) > 0;
	}

}
