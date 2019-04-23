/**
 * Copyright 2019 TPRI. All Rights Reserved.
 */
package com.dada.service.impl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.dada.dao.MemberMapper;
import com.dada.entity.LoginLog;
import com.dada.entity.Member;
import com.dada.entity.OperationLog;
import com.dada.service.ILoginLogService;
import com.dada.service.IMemberService;
import com.dada.service.IOperationLogService;
import com.dada.utils.DateUtils;
import com.dada.utils.IPUtils;
import com.dada.utils.UUIDUtils;

/**
 * <B>系统名称：</B><BR>
 * <B>模块名称：</B><BR>
 * <B>中文类名：</B><BR>
 * <B>概要说明：</B><BR>
 * 
 * @author（WuTengda） @since 2019年4月19日
 */
@Service
public class MemberServiceImpl implements IMemberService {

	@Resource
	private MemberMapper memberMapper;
	@Autowired
	private ILoginLogService loginLogService;
	@Autowired
	private IOperationLogService operationLogService;

	/**
	 * <B>方法名称：获取HttpServletRequest</B><BR>
	 * <B>概要说明：</B><BR>
	 * 
	 * @see com.dada.service.IMemberService#login(java.lang.String,
	 *      java.lang.String)
	 */
	public static HttpServletRequest getRequest() {
		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes())
				.getRequest();
		return request;
	}

	/**
	 * <B>方法名称：登录</B><BR>
	 * 
	 * @see com.dada.service.IMemberService#login(java.lang.String,
	 *      java.lang.String)
	 */
	@Override
	public boolean login(String member_no, String password) {
		// TODO Auto-generated method stub
		HttpSession session = getRequest().getSession();
		List<Member> memberList = memberMapper.login(member_no);
		// 判断是否有此账号
		if (memberList.size() > 0) {
			// 判断密码是否正确
			Member member = memberList.get(0);
			if (member.getPassword().equals(password)) {
				session.setAttribute("member", member);
				loginLogService.addLoginLog(new LoginLog(UUIDUtils.getUUID(), IPUtils.getIpAddr(getRequest()),
						member.getMemberNo(), member.getRealname(), new Date(), getRequest().getRequestURI(), "登录",
						"查询", "登录成功", "登录成功"));
				return true;
			} else {
				loginLogService.addLoginLog(new LoginLog(UUIDUtils.getUUID(), IPUtils.getIpAddr(getRequest()),
						member.getMemberNo(), member.getRealname(), new Date(), getRequest().getRequestURI(), "登录",
						"查询", "登录失败", "密码错误"));
			}
		} else {
			loginLogService.addLoginLog(new LoginLog(UUIDUtils.getUUID(), IPUtils.getIpAddr(getRequest()), null, null,
					new Date(), getRequest().getRequestURI(), "登录", "查询", "登录失败", "没有此账号"));
		}
		return false;
	}

	/**
	 * <B>方法名称：获取到session中的值</B><BR>
	 * 
	 * @see com.dada.service.IMemberService#selectMember()
	 */
	@Override
	public Member selectMember() {
		// TODO Auto-generated method stub
		HttpSession session = getRequest().getSession();
		return (Member) session.getAttribute("member");
	}

	/**
	 * <B>方法名称：修改用户信息</B><BR>
	 * 
	 * @see com.dada.service.IMemberService#updInfo(com.dada.entity.Member)
	 */
	@Override
	public boolean updateInfo(Member member) {
		// TODO Auto-generated method stub
		boolean bool = memberMapper.updateInfo(member);
		Member info = memberMapper.selectAllInfo(new Member(member.getId(), null, null, null, null, null, null, null,
				null, null, null, null, null, null, null, null, null, null));
		if (bool) {
			operationLogService.addOperationLog(new OperationLog(UUIDUtils.getUUID(), info.getMemberNo(),
					info.getRealname(), IPUtils.getIpAddr(getRequest()), getRequest().getRequestURI(), "修改个人信息", "修改",
					"修改个人信息成功", new Date()));
		} else {
			operationLogService.addOperationLog(new OperationLog(UUIDUtils.getUUID(), info.getMemberNo(),
					info.getRealname(), IPUtils.getIpAddr(getRequest()), getRequest().getRequestURI(), "修改个人信息", "修改",
					"修改个人信息失败", new Date()));
		}
		return bool;
	}

	/**
	 * <B>方法名称：修改个人密码</B><BR>
	 * 
	 * @see com.dada.service.IMemberService#updatePassword(java.lang.String,
	 *      java.lang.String)
	 */
	@Override
	public boolean updatePassword(Member member) {
		// TODO Auto-generated method stub
		boolean bool = memberMapper.updatePassword(member);
		Member info = memberMapper.selectAllInfo(new Member(null, member.getMemberNo(), null, null, null,
				null, null, null, null, null, null, null, null, null, null, null, null, null));
		if (bool) {
			operationLogService.addOperationLog(new OperationLog(UUIDUtils.getUUID(), info.getMemberNo(),
					info.getRealname(), IPUtils.getIpAddr(getRequest()), getRequest().getRequestURI(), "修改个人信息", "修改",
					"修改个人密码成功", new Date()));
		} else {
			operationLogService.addOperationLog(new OperationLog(UUIDUtils.getUUID(), info.getMemberNo(),
					info.getRealname(), IPUtils.getIpAddr(getRequest()), getRequest().getRequestURI(), "修改个人信息", "修改",
					"修改个人密码失败", new Date()));
		}
		return bool;
	}

	/**
	 * <B>方法名称：</B><BR>
	 * <B>概要说明：</B><BR>
	 * 
	 * @see com.dada.service.IMemberService#memberExit(java.lang.String,
	 *      java.lang.String)
	 */
	@Override
	public boolean removeMemberExit(String memberNo, String realname) {
		// TODO Auto-generated method stub
		HttpSession session = getRequest().getSession();
		if (session.getAttribute("member") != null) {
			session.removeAttribute("member");
		}
		loginLogService.addLoginLog(new LoginLog(UUIDUtils.getUUID(), IPUtils.getIpAddr(getRequest()), memberNo,
				realname, new Date(), getRequest().getRequestURI(), "注销", "删除", "注销成功", "注销成功"));
		return true;
	}
}
