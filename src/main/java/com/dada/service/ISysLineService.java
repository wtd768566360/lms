/**
 * Copyright 2019 TPRI. All Rights Reserved.
 */
package com.dada.service;

import java.util.Map;

import com.dada.entity.SysLine;
import com.dada.entity.SysStations;

/**
 * <B>系统名称：</B><BR>
 * <B>模块名称：</B><BR>
 * <B>中文类名：</B><BR>
 * <B>概要说明：</B><BR>
 * 
 * @author （WuTengda）
 * @since 2019年4月19日
 */
public interface ISysLineService {

	boolean add(SysLine sysLine);

	Map<String, Object> findPage(SysLine sysLine, int page, int limit);

	boolean remove(String id, String userId);

}
