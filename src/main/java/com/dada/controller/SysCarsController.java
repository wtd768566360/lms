/**
 * Copyright 2019 TPRI. All Rights Reserved.
 */
package com.dada.controller;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dada.common.ServerResponse;
import com.dada.entity.SysCars;
import com.dada.service.ISysCarsService;

/**
 * <B>系统名称：</B><BR>
 * <B>模块名称：</B><BR>
 * <B>中文类名：</B><BR>
 * <B>概要说明：</B><BR>
 * 
 * @author（WuTengda） @since 2019年4月19日
 */

@Controller
public class SysCarsController {

	private final Logger logger = LoggerFactory.getLogger(SysCarsController.class);
	
	@Autowired
	private ISysCarsService sysCarsService;
	/**
	 * <B>方法名称：获取车辆信息</B><BR>
	 * @param cars
	 * @return
	 */
	@RequestMapping(value="selectAllSysCars.do",method= {RequestMethod.GET})
	@ResponseBody
	public ServerResponse selectAllSysCars(SysCars cars){
		ServerResponse serverresponse=null;
		List<Map<String, Object>> selectAllInfo = sysCarsService.selectAllInfo(cars);
		if(!StringUtils.isEmpty(selectAllInfo)) {
			logger.info("成功获取车辆信息");
			serverresponse=ServerResponse.createBySuccess("ok", selectAllInfo);
		}else {
			logger.info("获取车辆信息失败");
			serverresponse=ServerResponse.createByErrorMessage("获取车辆信息失败");
		}
		return serverresponse;
	}
	/**
	 * <B>方法名称：增加车辆信息</B><BR>
	 * @param cars
	 * @return
	 */
	@RequestMapping(value="inserSysCars.do",method= {RequestMethod.POST})
	@ResponseBody
	public ServerResponse insertSelective(SysCars cars){
		ServerResponse serverresponse=null;
		boolean bool=sysCarsService.insertSelective(cars);
		if(bool) {
			logger.info("增加车辆信息成功");
			serverresponse=ServerResponse.createBySuccessMessage("增加车辆信息成功");
		}else {
			logger.info("增加车辆信息失败");
			serverresponse=ServerResponse.createByErrorMessage("增加车辆信息成功");
		}
		return serverresponse;
	}
	/**
	 * <B>方法名称：查询单辆汽车信息</B><BR>
	 * @param cars
	 * @return
	 */
	@RequestMapping(value="SysCarsInfo.do",method= {RequestMethod.GET})
	@ResponseBody
	public ServerResponse selectInfo(SysCars cars) {
		ServerResponse serverresponse=null;
		Map<String, Object> info = sysCarsService.selectInfo(cars);
		if(!StringUtils.isEmpty(info)) {
			logger.info("单辆汽车查询成功");
			serverresponse=ServerResponse.createBySuccess("单辆汽车查询成功",info);
		}else {
			logger.info("单辆汽车查询失败");
			serverresponse=ServerResponse.createBySuccess("单辆汽车查询失败",info);
		}
		return serverresponse;
	}
	/**
	 * <B>方法名称：修改汽车信息</B><BR>
	 * @param cars
	 * @return
	 */
	@RequestMapping(value="updateInfoSysCars.do",method= {RequestMethod.POST})
	@ResponseBody
	public ServerResponse updateInfo(SysCars cars) {
		ServerResponse serverresponse=null;
		boolean bool = sysCarsService.updateInfo(cars);
		if(bool) {
			logger.info("修改车辆信息成功");
			serverresponse=ServerResponse.createBySuccessMessage("修改车辆信息成功");
		}else {
			logger.info("修改车辆信息失败");
			serverresponse=ServerResponse.createByErrorMessage("修改车辆信息成功");
		}
		return serverresponse;
	}
}
