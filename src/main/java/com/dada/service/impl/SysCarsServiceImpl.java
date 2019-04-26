/**
 * Copyright 2019 TPRI. All Rights Reserved.
 */
package com.dada.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.dada.dao.SysCarsMapper;
import com.dada.entity.Member;
import com.dada.entity.OperationLog;
import com.dada.entity.SysCars;
import com.dada.service.IOperationLogService;
import com.dada.service.ISysCarsService;
import com.dada.utils.IPUtils;
import com.dada.utils.UUIDUtils;

/**
 * <B>系统名称：</B><BR>
 * <B>模块名称：</B><BR>
 * <B>中文类名：</B><BR>
 * <B>概要说明：</B><BR>
 * @author（WuTengda）
 * @since 2019年4月19日
 */
@Service
public class SysCarsServiceImpl implements ISysCarsService {

	@Resource
	private SysCarsMapper syscarsMapper;
	
	@Autowired
	private IOperationLogService operationLogService;
	
	/**
	 * <B>方法名称：获取HttpServletRequest</B><BR>
	 * <B>概要说明：</B><BR>
	 * 
	 * @see com.dada.service.IMemberService#login(java.lang.String,
	 *      java.lang.String)
	 */
	public HttpServletRequest getRequest() {
		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes())
				.getRequest();
		return request;
	}
	
	/**
	 * <B>方法名称：获取到session中的值</B><BR>
	 * 
	 * @see com.dada.service.IMemberService#selectMember()
	 */
	
	public Member selectMember() {
		// TODO Auto-generated method stub
		HttpSession session = getRequest().getSession();
		return (Member) session.getAttribute("member");
	}
	
	/**
	 * <B>方法名称：增加车辆信息</B><BR>
	 * 
	 * @see com.dada.service.ISysCarsService#insertSelective(SysCars);
	 */
	@Override
	public boolean insertSelective(SysCars cars) {
		boolean bool=syscarsMapper.insertSelective(cars);
		if(bool) {
			operationLogService.addOperationLog(new OperationLog(UUIDUtils.getUUID(), selectMember().getMemberNo(),
					selectMember().getRealname(), IPUtils.getIpAddr(getRequest()), getRequest().getRequestURI(), "增加车辆", "增加",
					"增加车辆成功", new Date()));
		}else {
			operationLogService.addOperationLog(new OperationLog(UUIDUtils.getUUID(), selectMember().getMemberNo(),
					selectMember().getRealname(), IPUtils.getIpAddr(getRequest()), getRequest().getRequestURI(), "增加车辆", "增加",
					"增加车辆失败", new Date()));
		}
		return bool;
	}

	/**
	 * <B>方法名称：查询车辆信息</B><BR>
	 * 
	 * @see com.dada.service.ISysCarsService#selectAllInfo(SysCars);
	 */
	@Override
	public List<Map<String, Object>> selectAllInfo(SysCars record) {
		return syscarsMapper.selectAllInfo(record);
	}

	/**
	 * <B>方法名称：查询单辆信息</B><BR>
	 * 
	 * @see com.dada.service.ISysCarsService#selectInfo(SysCars);
	 */
	@Override
	public Map<String, Object> selectInfo(SysCars record) {
		return syscarsMapper.selectAllInfo(record).get(0);
	}

	/**
	 * <B>方法名称：修改车辆信息</B><BR>
	 * 
	 * @see com.dada.service.ISysCarsService#updateInfo(SysCars);
	 */
	@Override
	public boolean updateInfo(SysCars record) {
		boolean bool=syscarsMapper.updateInfo(record);
		if(bool) {
			operationLogService.addOperationLog(new OperationLog(UUIDUtils.getUUID(), selectMember().getMemberNo(),
					selectMember().getRealname(), IPUtils.getIpAddr(getRequest()), getRequest().getRequestURI(), "修改车辆信息", "修改",
					"修改车辆成功", new Date()));
		}else {
			operationLogService.addOperationLog(new OperationLog(UUIDUtils.getUUID(), selectMember().getMemberNo(),
					selectMember().getRealname(), IPUtils.getIpAddr(getRequest()), getRequest().getRequestURI(), "修改车辆信息", "修改",
					"修改车辆失败", new Date()));
		}
		return bool;
	}

}
