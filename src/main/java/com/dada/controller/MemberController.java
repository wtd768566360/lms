/**
 * Copyright 2019 TPRI. All Rights Reserved.
 */
package com.dada.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dada.common.ServerResponse;
import com.dada.entity.Member;
import com.dada.service.IMemberService;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

/**
 * <B>系统名称：</B><BR>
 * <B>模块名称：</B><BR>
 * <B>中文类名：</B><BR>
 * <B>概要说明：</B><BR>
 * 
 * @author（WuTengda） @since 2019年4月19日
 */

@Controller
public class MemberController {

	private final Logger logger = LoggerFactory.getLogger(MemberController.class);

	@Autowired
	private IMemberService memberService;

	/**
	 * 
	 * <B>方法名称：登录</B><BR>
	 * <B>概要说明：</B><BR>
	 * 
	 * @param member_no
	 *            :工号
	 * @param password
	 *            :密码
	 * @return
	 */
	@RequestMapping(value = "/login.do", method = { RequestMethod.GET })
	@ResponseBody
	public ServerResponse login(String member_no, String password) {
		ServerResponse serverResponse = null;
		if (memberService.login(member_no, password)) {
			serverResponse = ServerResponse.createBySuccess("ok");
			logger.info("工号: " + member_no + "登录成功...");
		} else {
			serverResponse = ServerResponse.createByErrorMessage("登录失败,请检查工号、密码是否错误");
			logger.info("工号: " + member_no + "登录失败...");
		}
		return serverResponse;
	}

	/**
	 * <B>方法名称：获取session中的数据</B><BR>
	 * <B>概要说明：</B><BR>
	 * 
	 * @return
	 */
	@RequestMapping(value = "/selectMember.do", method = { RequestMethod.GET })
	@ResponseBody
	public ServerResponse selectMember() {
		ServerResponse serverResponse = null;
		Member member = memberService.selectMember();
		if (!StringUtils.isEmpty(member)) {
			logger.info("从session中获取到信息: 工号: " + member.getMemberNo() + " 成功...");
			serverResponse = ServerResponse.createBySuccess("ok", member);
		} else {
			logger.info("当前用户从session中获取到个人信息 失败...");
			serverResponse = ServerResponse.createByErrorMessage("无法获取到session中的数据");
		}
		return serverResponse;
	}

	/**
	 * <B>方法名称：获取个人信息</B><BR>
	 * 
	 * @return
	 */
	@RequestMapping(value = "/selectInfo.do", method = { RequestMethod.GET })
	@ResponseBody
	public ServerResponse selectInfo() {
		ServerResponse serverResponse = null;
		Member member = memberService.selectMember();
		if (!StringUtils.isEmpty(member)) {
			logger.info("从session中获取到个人信息: 工号: " + member.getMemberNo() + " 成功...");
			serverResponse = ServerResponse.createBySuccess("ok", member);
		} else {
			logger.info("当前用户从session中获取到个人信息  失败...");
			serverResponse = ServerResponse.createByErrorMessage("获取个人信息失败");
		}
		return serverResponse;
	}

	/**
	 * 
	 * <B>方法名称：修改个人信息</B><BR>
	 * 
	 * @param member
	 * @return
	 */
	@RequestMapping(value = "/updateInfo.do", method = { RequestMethod.POST })
	@ResponseBody
	public ServerResponse updateInfo(Member member) {
		ServerResponse serverResponse = null;
		boolean bool = memberService.updateInfo(member);
		if (bool) {
			logger.info("工号: " + member.getMemberNo() + "修改个人信息 成功...");
			serverResponse = ServerResponse.createBySuccess("修改个人信息成功", member);
		} else {
			logger.info("工号: " + member.getMemberNo() + "修改个人信息 失败...");
			serverResponse = ServerResponse.createByErrorMessage("修改个人信息失败!");
		}
		return serverResponse;
	}

	/**
	 * 
	 * <B>方法名称：修改个人信息</B><BR>
	 * 
	 * @param member
	 * @return
	 */
	@RequestMapping(value = "/updatePassword.do", method = { RequestMethod.POST })
	@ResponseBody
	public ServerResponse updatePassword(Member member, String password1) {
		ServerResponse serverResponse = null;
		if (memberService.login(member.getMemberNo(), password1)) {
			if (memberService.updatePassword(member)) {
				logger.info("工号: " + member.getMemberNo() + "修改个人密码 成功...");
				serverResponse = ServerResponse.createBySuccess("修改密码成功!", "");
			} else {
				logger.info("工号: " + member.getMemberNo() + "修改个人密码 失败...");
				serverResponse = ServerResponse.createByErrorMessage("修改密码失败!");
			}
		} else {
			logger.info("工号: " + member.getMemberNo() + "修改个人密码 失败  原密码错误...");
			serverResponse = ServerResponse.createByErrorMessage("原密码密码错误,修改失败!");
		}
		return serverResponse;
	}

	/**
	 * <B>概要说明：注销</B><BR>
	 * 
	 * @param realname
	 * @param memberNo
	 * @return
	 */
	@RequestMapping(value = "/memberExit.do", method = { RequestMethod.GET })
	@ResponseBody
	public ServerResponse memberExit(String realname, String memberNo) {
		ServerResponse serverResponse = null;
		if (memberService.removeMemberExit(memberNo, realname)) {
			logger.info("工号: " + memberNo + "注销 成功...");
			serverResponse = ServerResponse.createBySuccess("注销成功", "");
		} else {
			logger.info("工号: " + memberNo + "注销 失败...");
			serverResponse = ServerResponse.createByErrorMessage("注销失败");
		}
		return serverResponse;
	}
}
