/**
 * Copyright 2019 TPRI. All Rights Reserved.
 */
package com.dada.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.multipart.MultipartFile;

import com.dada.common.ServerResponse;
import com.dada.entity.Member;
import com.dada.service.IMemberService;

import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;

import org.apache.tomcat.jni.Directory;
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
		Member member = memberService.login(member_no, password);
		if (member != null) {
			serverResponse = ServerResponse.createBySuccess("success", member);
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
	 * <B>概要说明：获取下一个工号</B><BR>
	 * 
	 * @param member
	 * @param page
	 * @return
	 */
	@RequestMapping(value = "/getMemberNo.do", method = { RequestMethod.GET })
	@ResponseBody
	public ServerResponse getMemberNo() {
		String memberNo = memberService.getMemberNo();
		logger.info("成功获取工号信息 " + memberNo + " ...");
		return ServerResponse.createBySuccess("success", memberNo);
	}

	/**
	 * <B>概要说明：根据id获取工号</B><BR>
	 * 
	 * @param member
	 * @param page
	 * @return
	 */
	@RequestMapping(value = "/getMemberName.do", method = { RequestMethod.GET })
	@ResponseBody
	public ServerResponse getMemberName(String id) {
		String memberName = memberService.getMemberName(id);
		logger.info("成功获取姓名信息 " + memberName + " ...");
		return ServerResponse.createBySuccess("success", memberName);
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
		boolean bool = memberService.addMember(member);
		if (bool) {
			serverResponse = ServerResponse.createBySuccess("success");
			logger.info("员工信息添加成功...");
		} else {
			serverResponse = ServerResponse.createByErrorMessage("添加失败");
			logger.info("员工信息添加失败...");
		}
		return serverResponse;
	}

	/**
	 * <B>概要说明：删除员工</B><BR>
	 * 
	 * @param member
	 * @return
	 */
	@RequestMapping(value = "/deleteMember.do", method = { RequestMethod.POST })
	@ResponseBody
	public ServerResponse deleteMember(Member member) {
		ServerResponse serverResponse = null;
		if (memberService.deleteMember(member)) {
			serverResponse = ServerResponse.createBySuccess("success");
			logger.info("员工信息删除成功...");
		} else {
			serverResponse = ServerResponse.createByErrorMessage("删除失败");
			logger.info("员工信息删除失败...");
		}
		return serverResponse;
	}

	/**
	 * <B>概要说明：获取上次登录时间</B><BR>
	 * 
	 * @param member
	 * @return
	 */
	@RequestMapping(value = "/getLastTime.do", method = { RequestMethod.GET })
	@ResponseBody
	public ServerResponse getLastTime() {
		Date lastTime = memberService.getLastTime();
		logger.info("成功获取用户上次登录信息 " + lastTime + " ...");
		return ServerResponse.createBySuccess("success", lastTime);
	}

	/**
	 * <B>概要说明：头像上传</B><BR>
	 * 
	 * @param member
	 * @return
	 */
	@RequestMapping(value = "/memberPicture.do", method = { RequestMethod.POST })
	@ResponseBody
	public ServerResponse memberPicture(@RequestParam("file") MultipartFile multipartFile,String id) {
		String path = memberService.memberPicture(multipartFile);
		memberService.updateHandUrl(path,id);
		if (path != null) {
			logger.info("用户更新了头像...成功 ");
			return ServerResponse.createBySuccess("success", path);
		} else {
			logger.info("用户更新了头像...失败 ");
			return ServerResponse.createByErrorMessage("更新头像失败");
		}
	}

	/**
	 * <B>概要说明：查询员工所有</B><BR>
	 * 
	 * @param member
	 * @return
	 */
	@RequestMapping(value = "selectAllMemberinfo.do", method = { RequestMethod.GET })
	@ResponseBody
	public ServerResponse selectAllMemberinfo(Member member) {
		ServerResponse serverResponse = null;
		List<Member> MemberAll = memberService.selectConditionsAllMamber(member);
		if (!StringUtils.isEmpty(MemberAll)) {
			serverResponse = ServerResponse.createBySuccess("success", MemberAll);
			logger.info("员工信息查询成功...");
		} else {
			serverResponse = ServerResponse.createByErrorMessage("查询失败");
			logger.info("员工信息查询失败");
		}
		return serverResponse;
	}

}
