/**
 * Copyright 2019 TPRI. All Rights Reserved.
 */
package com.dada.service;

import java.util.List;
import java.util.Map;

import com.dada.entity.SysCars;

/**
 * <B>系统名称：</B><BR>
 * <B>模块名称：</B><BR>
 * <B>中文类名：</B><BR>
 * <B>概要说明：</B><BR>
 * @author （WuTengda）
 * @since 2019年4月19日
 */
public interface ISysCarsService {
	/**
	 * 汽车增加
	 * @param cars
	 * @return
	 */
	boolean insertSelective(SysCars cars);
	
	/**
	 * 查询
	 * @param record 
	 * @return 返回集合
	 */
	List<Map<String, Object>> selectAllInfo(SysCars record);
	/**
	 * 单条查询
	 * @param record
	 * @return 返回一个集合
	 */
	Map<String, Object> selectInfo(SysCars record);
	/**
	 * 修改
	 * @param record
	 * @return
	 */
    boolean updateInfo(SysCars record);
	
}
