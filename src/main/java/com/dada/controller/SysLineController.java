/**
 * Copyright 2019 TPRI. All Rights Reserved.
 */
package com.dada.controller;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dada.common.ServerResponse;
import com.dada.entity.SysLine;
import com.dada.entity.SysStations;
import com.dada.service.ISysLineService;

/**
 * <B>系统名称：</B><BR>
 * <B>模块名称：</B><BR>
 * <B>中文类名：</B><BR>
 * <B>概要说明：</B><BR>
 * 
 * @author（WuTengda） @since 2019年4月19日
 */

@Controller
@RequestMapping(value = "/line")
public class SysLineController {

	private final Logger logger = LoggerFactory.getLogger(SysLineController.class);
	@Autowired
	private ISysLineService sysLinwService;

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	@ResponseBody
	public ServerResponse add(SysLine sysLine) {
		if (sysLinwService.add(sysLine)) {
			logger.info("添加线路成功...");
			return ServerResponse.createBySuccess();
		} else {
			logger.info("添加线路失败...");
			return ServerResponse.createByErrorMessage("添加失败");
		}
	}

	@RequestMapping(value = "/page.do", method = RequestMethod.GET)
	@ResponseBody
	public ServerResponse getPage(int page, int limit, SysLine sysLine) {
		Map<String, Object> map = this.sysLinwService.findPage(sysLine, page, limit);
		if (map != null && !map.isEmpty()) {
			this.logger.info("获取线路列表成功...");
			return ServerResponse.createByPageSuccess("获取线路列表成功", String.valueOf(map.get("totalCount")),
					map.get("list"));
		}
		this.logger.info("获取线路列表失败...");
		return ServerResponse.createByErrorMessage("获取线路列表失败");
	}

	@RequestMapping(value = "/delete.do", method = RequestMethod.POST)
	@ResponseBody
	public ServerResponse delete(String id) {
		String userId = "";
		if (this.sysLinwService.remove(id, userId)) {
			this.logger.info("删除路线成功...");
			return ServerResponse.createBySuccess("success", null);
		}
		this.logger.info("删除路线失败...");
		return ServerResponse.createByErrorMessage("删除路线失败");
	}
}
