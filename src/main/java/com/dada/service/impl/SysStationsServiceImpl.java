/**
 * Copyright 2019 TPRI. All Rights Reserved.
 */
package com.dada.service.impl;

import com.dada.dao.SysStationsMapper;
import com.dada.entity.SysStations;
import com.dada.service.ISysStationsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <B>系统名称：</B><BR>
 * <B>模块名称：</B><BR>
 * <B>中文类名：</B><BR>
 * <B>概要说明：</B><BR>
 * @author（WuTengda）
 * @since 2019年4月19日
 */
@Service
public class SysStationsServiceImpl implements ISysStationsService{

    @Autowired
    private SysStationsMapper sysStationsMapper;

    @Override
    public boolean insert(SysStations sysStations) {
        sysStations.setCreateTime(new Date());
        sysStations.setModifyTime(new Date());
        return this.sysStationsMapper.insert(sysStations) > 0;
    }

    @Override
    public boolean remove(String stationId, String userId) {
        SysStations sysStations = new SysStations();
        sysStations.setId(stationId);
        sysStations.setModifierId(userId);
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
    public Map<String, Object> findPage(String stationName, int currentPage, int pageSize) {
        Map<String, Object> map = new HashMap<>(2);
        List<SysStations> list = this.sysStationsMapper.findPage(stationName, currentPage, pageSize);
        int count = this.sysStationsMapper.findPageByCount(stationName, currentPage, pageSize);
        map.put("list", list);
        map.put("totalCount", count);
        return map;
    }
}
