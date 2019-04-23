/**
 * Copyright 2019 TPRI. All Rights Reserved.
 */
package com.dada.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.dada.dao.LoginLogMapper;
import com.dada.entity.LoginLog;
import com.dada.service.ILoginLogService;

/**
 * <B>系统名称：</B><BR>
 * <B>模块名称：</B><BR>
 * <B>中文类名：</B><BR>
 * <B>概要说明：</B><BR>
 * 
 * @author（WuTengda） @since 2019年4月19日
 */
@Service
public class LoginLogServiceImpl implements ILoginLogService {

	@Resource
	private LoginLogMapper loginLogMapper;

	/**
	 * <B>方法名称：时间节点查询日志</B><BR>
	 * 
	 * @see com.dada.service.ILoginLogService#selectLoginLog(java.lang.String,
	 *      java.lang.String)
	 */
	@Override
	public boolean selectDateLoginLog(String startDate, String endDate) {
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * <B>方法名称：登录登出日志数据持久化</B><BR>
	 * 
	 * @see com.dada.service.ILoginLogService#addLoginLog()
	 */
	@Override
	public boolean addLoginLog(LoginLog loginLog) {
		// TODO Auto-generated method stub
		int i = loginLogMapper.insertSelective(loginLog);
		return i > 0 ? true : false;
	}
}
