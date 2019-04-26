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

import java.util.List;

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
			serverResponse = ServerResponse.createBySuccess("success");
			logger.info("工号: " + member_no + "登录成功...");
		} else {
			serverResponse = ServerResponse.createByErrorMessage("登录失败,请检查工号、密码是否错误");
			logger.info("工号: " + member_no + "登录失败...");
		}
		return serverResponse;
	}

	/**
	 * 
	 * <B>方法名称：解锁</B><BR>
	 * 
	 * @param member_no
	 *            :工号
	 * @param password
	 *            :密码
	 * @return
	 */
	@RequestMapping(value = "/unlock.do", method = { RequestMethod.GET })
	@ResponseBody
	public ServerResponse unlock(String member_no, String password) {
		ServerResponse serverResponse = null;
		if (memberService.unlock(member_no, password)) {
			serverResponse = ServerResponse.createBySuccess("success");
			logger.info("工号: " + member_no + "解锁成功...");
		} else {
			serverResponse = ServerResponse.createByErrorMessage("确定密码是否正确");
			logger.info("工号: " + member_no + "解锁失败...");
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
			serverResponse = ServerResponse.createBySuccess("success", member);
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
			serverResponse = ServerResponse.createBySuccess("success", member);
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
	 * <B>概要说明：验证原密码是否正确</B><BR>
	 * 
	 * @param member
	 * @param password
	 * @return
	 */
	@RequestMapping(value = "/inspectionOldPwd.do", method = { RequestMethod.GET })
	@ResponseBody
	public ServerResponse inspectionOldPwd(Member member, String password) {
		ServerResponse serverResponse = null;
		if (memberService.inspectionOldPwd(member.getMemberNo(), password)) {
			logger.info("工号: " + member.getMemberNo() + "原密码正确...");
			serverResponse = ServerResponse.createBySuccess("success", "");
		} else {
			logger.info("工号: " + member.getMemberNo() + "原密码错误...");
			serverResponse = ServerResponse.createByErrorMessage("原密码密码错误!");
		}
		return serverResponse;
	}

	/**
	 * 
	 * <B>方法名称：修改密码</B><BR>
	 * 
	 * @param member
	 * @return
	 */
	@RequestMapping(value = "/updatePassword.do", method = { RequestMethod.POST })
	@ResponseBody
	public ServerResponse updatePassword(Member member) {
		ServerResponse serverResponse = null;
		if (memberService.updatePassword(member)) {
			logger.info("工号: " + member.getMemberNo() + "修改个人密码 成功...");
			serverResponse = ServerResponse.createBySuccess("修改密码成功!", "");
		} else {
			logger.info("工号: " + member.getMemberNo() + "修改个人密码 失败...");
			serverResponse = ServerResponse.createByErrorMessage("修改密码失败!");
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

	/**
	 * <B>概要说明：分页条件查询</B><BR>
	 * 
	 * @param member
	 * @param page
	 * @return
	 */
	@RequestMapping(value = "/selectConditionsAllMamber.do", method = { RequestMethod.GET })
	@ResponseBody
	public ServerResponse selectConditionsAllMamber(Member member, String page, String limit) {
		ServerResponse serverResponse = null;
		int count = memberService.selectConditionsAllMamberNumber(member);// 获取数据所有条数
		if (count > 0) {
			List<Member> listMember = memberService.selectConditionsAllMamber(member, page, limit);
			serverResponse = ServerResponse.createByPageSuccess("success", count + "", listMember);
			logger.info("员工信息查询成功...");
		} else {
			serverResponse = serverResponse.createByErrorMessage("failure");
			logger.info("员工信息为空...");
		}
		return serverResponse;
	}

	/**
	 * <B>概要说明：添加员工</B><BR>
	 * 
	 * @param member
	 * @return
	 */
	@RequestMapping(value = "/addMember.do", method = { RequestMethod.POST })
	@ResponseBody
	public ServerResponse addMember(Member member) {
		ServerResponse serverResponse = null;
		Member info = memberService.addMember(member);
		if (info != null) {
			serverResponse = ServerResponse.createBySuccess("success", info);
		} else {
			serverResponse = ServerResponse.createByErrorMessage("添加失败");
		}
		return serverResponse;
	}
}
