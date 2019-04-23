/**
 * Copyright 2019 TPRI. All Rights Reserved.
 */
package com.dada.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.dada.dao.OperationLogMapper;
import com.dada.entity.OperationLog;
import com.dada.service.IOperationLogService;

/**
 * <B>系统名称：</B><BR>
 * <B>模块名称：</B><BR>
 * <B>中文类名：</B><BR>
 * <B>概要说明：</B><BR>
 * 
 * @author（WuTengda） @since 2019年4月19日
 */
@Service
public class OperationLogServiceImpl implements IOperationLogService {

	@Resource
	private OperationLogMapper operationLogMapper;

	/**
	 * <B>方法名称：时间节点查询日志</B><BR>
	 * 
	 * @see com.dada.service.ILoginLogService#selectLoginLog(java.lang.String,
	 *      java.lang.String)
	 */
	@Override
	public boolean selectDateLperationLog(String startDate, String endDate) {
		// TODO Auto-generated method stub
		return false;
	}
	
	/**
	 * <B>概要说明：添加操作日志</B><BR>
	 * 
	 * @see com.dada.service.IOperationLogService#insertSelective()
	 */
	@Override
	public int addOperationLog(OperationLog operationLog) {
		// TODO Auto-generated method stub
		return operationLogMapper.insertSelective(operationLog);
	}

}
