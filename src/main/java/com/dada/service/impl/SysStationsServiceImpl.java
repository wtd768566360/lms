/**
 * Copyright 2019 TPRI. All Rights Reserved.
 */
package com.dada.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dada.dao.SysStationsMapper;
import com.dada.entity.Member;
import com.dada.entity.SysStations;
import com.dada.service.IMemberService;
import com.dada.service.ISysStationsService;
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
public class SysStationsServiceImpl implements ISysStationsService {

	@Autowired
	private SysStationsMapper sysStationsMapper;
	@Autowired
	private IMemberService memberService;

	@Override
	public boolean insert(SysStations sysStations) {
		Member member = memberService.selectMember();
		sysStations.setId(UUIDUtils.getUUID());
		sysStations.setCreatorId(member.getId());
		sysStations.setModifierId(member.getId());
		sysStations.setIsDeleted(false);
		sysStations.setCreateTime(new Date());
		sysStations.setModifyTime(new Date());
		return this.sysStationsMapper.insert(sysStations) > 0;
	}

	@Override
	public boolean remove(String stationId, String userId) {
		Member member = memberService.selectMember();
		SysStations sysStations = new SysStations();
		sysStations.setId(stationId);
		sysStations.setModifierId(member.getId());
		sysStations.setModifyTime(new Date());
		return this.sysStationsMapper.remove(sysStations) > 0;
	}

	@Override
	public boolean edit(SysStations sysStations) {
		sysStations.setModifyTime(new Date());
		return this.sysStationsMapper.update(sysStations) > 0;
	}

	@Override
	public List<SysStations> list(String stationName) {
		return this.sysStationsMapper.list(stationName);
	}

	@Override
	public Map<String, Object> findPage(SysStations sysStations, int currentPage, int pageSize) {
		Map<String, Object> map = new HashMap<>(2);
		List<SysStations> list = this.sysStationsMapper.findPage(sysStations);
		// 从第几条数据开始
		int firstIndex = (currentPage - 1) * (pageSize);
		// 到第几条数据结束
		int lastIndex = 0;
		if (list.size() > currentPage * pageSize) {
			lastIndex = currentPage * pageSize;
		} else {
			lastIndex = list.size();
		}
		int count = this.sysStationsMapper.findPageByCount(sysStations);
		map.put("list", list.subList(firstIndex, lastIndex));
		map.put("totalCount", count);
		return map;
	}
}
