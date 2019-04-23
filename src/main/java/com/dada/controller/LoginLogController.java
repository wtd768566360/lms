/**
 * Copyright 2019 TPRI. All Rights Reserved.
 */
package com.dada.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dada.service.ILoginLogService;

/**
 * <B>系统名称：</B><BR>
 * <B>模块名称：</B><BR>
 * <B>中文类名：</B><BR>
 * <B>概要说明：</B><BR>
 * 
 * @author（WuTengda） @since 2019年4月19日
 */

@Controller
public class LoginLogController {

	@Autowired
	ILoginLogService loginLogService;

	/**
	 * <B>方法名称：查询登录登出日志</B><BR>
	 * 
	 * @return
	 */
	@RequestMapping(value = "/selectLoginLog.do", method = { RequestMethod.GET })
	@ResponseBody
	public String selectLoginLog(String startDate,String endDate) {
		boolean bool = loginLogService.selectDateLoginLog(startDate,endDate);
		return null;
	}
}
