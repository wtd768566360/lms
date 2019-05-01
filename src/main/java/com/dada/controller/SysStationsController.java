/**
 * Copyright 2019 TPRI. All Rights Reserved.
 */
package com.dada.controller;

import com.dada.common.ServerResponse;
import com.dada.entity.SysStations;
import com.dada.service.ISysStationsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * <B>系统名称：</B><BR>
 * <B>模块名称：</B><BR>
 * <B>中文类名：</B><BR>
 * <B>概要说明：</B><BR>
 * 
 * @author（WuTengda） @since 2019年4月19日
 */

@Controller
@RequestMapping(value = "/station")
public class SysStationsController {

	private final Logger logger = LoggerFactory.getLogger(SysStationsController.class);

	@Autowired
	private ISysStationsService sysStationsService;

	@RequestMapping(value = "/add.do", method = RequestMethod.POST)
	@ResponseBody
	public ServerResponse add(@RequestBody SysStations dto) {
		if (this.sysStationsService.insert(dto)) {
			this.logger.info("添加站点成功...");
			return ServerResponse.createByErrorMessage("添加站点成功");
		}
		this.logger.info("添加站点失败...");
		return ServerResponse.createByErrorMessage("添加站点失败");
	}

	@RequestMapping(value = "/delete.do", method = RequestMethod.GET)
	@ResponseBody
	public ServerResponse delete(String id) {
		String userId = "";
		if (this.sysStationsService.remove(id, userId)) {
			this.logger.info("删除站点成功...");
			return ServerResponse.createByErrorMessage("删除站点成功");
		}
		this.logger.info("删除站点失败...");
		return ServerResponse.createByErrorMessage("删除站点失败");
	}

	@RequestMapping(value = "/edit.do", method = RequestMethod.POST)
	@ResponseBody
	public ServerResponse update(@RequestBody SysStations dto) {
		if (this.sysStationsService.edit(dto)) {
			this.logger.info("修改站点成功...");
			return ServerResponse.createByErrorMessage("修改站点成功");
		}
		this.logger.info("修改站点失败...");
		return ServerResponse.createByErrorMessage("修改站点失败");
	}

	@RequestMapping(value = "/list.do", method = RequestMethod.POST)
	@ResponseBody
	public ServerResponse list(String stationName) {
		List<SysStations> list = this.sysStationsService.list(stationName);
		if (list != null && !list.isEmpty()) {
			this.logger.info("获取站点列表成功...");
			return ServerResponse.createBySuccess("获取站点列表成功", list);
		}
		this.logger.info("获取站点列表失败...");
		return ServerResponse.createByErrorMessage("获取站点列表失败");
	}

	@RequestMapping(value = "/page.do", method = RequestMethod.GET)
	@ResponseBody
	public ServerResponse getPage(int page,int limit,SysStations SysStations) {
		Map<String, Object> map = this.sysStationsService.findPage(SysStations, page, limit);
		if (map != null && !map.isEmpty()) {
			this.logger.info("获取站点列表成功...");
			return ServerResponse.createByPageSuccess("获取站点列表成功", String.valueOf(map.get("totalCount")), map.get("list"));
		}
		this.logger.info("获取站点列表失败...");
		return ServerResponse.createByErrorMessage("获取站点列表失败");
	}
}
