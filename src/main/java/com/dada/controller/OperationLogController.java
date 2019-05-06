/**
 * Copyright 2019 TPRI. All Rights Reserved.
 */
package com.dada.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dada.common.ServerResponse;
import com.dada.service.IOperationLogService;

/**
 * <B>系统名称：</B><BR>
 * <B>模块名称：</B><BR>
 * <B>中文类名：</B><BR>
 * <B>概要说明：</B><BR>
 * 
 * @author（WuTengda） @since 2019年4月19日
 */

@Controller
public class OperationLogController {

	@Autowired
	private IOperationLogService operationLogService;
	
	@RequestMapping(value="selectLoginfo.do",method=RequestMethod.GET)
	@ResponseBody
	public ServerResponse selectLoginfo() {
		//System.out.println("aaa");
		ServerResponse serverResponse = null;
		List<Map<String, Object>> loginfo = operationLogService.selectLoginfo();
		if(loginfo.size()>0) {
			serverResponse = ServerResponse.createBySuccess("success", loginfo);
		}else {
			serverResponse = ServerResponse.createByErrorMessage("无法获取数据");
		}
		return serverResponse;
	}
}
