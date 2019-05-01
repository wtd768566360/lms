/**
 * Copyright 2019 TPRI. All Rights Reserved.
 */
package com.dada.service;

import com.dada.entity.SysStations;

import java.util.List;
import java.util.Map;

/**
 * <B>系统名称：</B><BR>
 * <B>模块名称：</B><BR>
 * <B>中文类名：</B><BR>
 * <B>概要说明：</B><BR>
 * @author （WuTengda）
 * @since 2019年4月19日
 */
public interface ISysStationsService {

    /**
     * 新增数据
     * @param sysStations
     * @return
     */
    boolean insert(SysStations sysStations);

    /**
     * 删除数据
     * @param stationId
     * @param userId
     * @return
     */
    boolean remove(String stationId, String userId);

    /**
     * 更新数据
     * @param sysStations
     * @return
     */
    boolean edit(SysStations sysStations);

    /**
     * 列表查询
     * @param stationName
     * @return
     */
    List<SysStations> list(String stationName);

    /**
     * 分页查询
     * @param stationName
     * @param currentPage
     * @param pageSize
     * @return
     */
    Map<String, Object> findPage(SysStations sysStations, int currentPage, int pageSize);
}
