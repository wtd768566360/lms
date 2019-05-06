/**
 * Copyright 2019 TPRI. All Rights Reserved.
 */
package com.dada.service.impl;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.multipart.MultipartFile;

import com.dada.dao.MemberMapper;
import com.dada.entity.LoginLog;
import com.dada.entity.Member;
import com.dada.entity.OperationLog;
import com.dada.service.ILoginLogService;
import com.dada.service.IMemberService;
import com.dada.service.IOperationLogService;
import com.dada.utils.IPUtils;
import com.dada.utils.MemberUtils;
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
	@Autowired
	private IMemberService memberService;

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

	@Override
	public boolean inspectionOldPwd(String member_no, String password) {
		List<Member> memberList = memberMapper.selectAllInfo(new Member(null, member_no, null, null, null, null, null,
				null, null, null, null, null, null, null, null, null, null, null));
		// 判断是否有此账号
		if (memberList.size() > 0) {
			// 判断密码是否正确
			Member member = memberList.get(0);
			if (member.getPassword().equals(password)) {
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}

	/**
	 * <B>方法名称：登录</B><BR>
	 * 
	 * @see com.dada.service.IMemberService#login(java.lang.String,
	 *      java.lang.String)
	 */
	@Override
	public Member login(String member_no, String password) {
		// TODO Auto-generated method stub
		HttpSession session = getRequest().getSession();
		List<Member> memberList = memberMapper.selectAllInfo(new Member(null, member_no, null, null, null, null, null,
				null, null, null, null, null, null, null, null, null, null, null));
		// 判断是否有此账号
		if (memberList.size() > 0) {
			// 判断密码是否正确
			Member member = memberList.get(0);
			if (member.getPassword().equals(password)) {
				session.setAttribute("member", member);
				Member updateMember = new Member(null, member_no, null, null, null, null, null, null, null,
						IPUtils.getIpAddr(getRequest()), new Date(), null, null, null, null, null, null, null);
				memberMapper.updateLastTime(updateMember);
				loginLogService.addLoginLog(new LoginLog(UUIDUtils.getUUID(), IPUtils.getIpAddr(getRequest()),
						member.getMemberNo(), member.getRealname(), new Date(), getRequest().getRequestURI(), "登录",
						"查询", "登录成功", "登录成功"));
				return member;
			} else {
				loginLogService.addLoginLog(new LoginLog(UUIDUtils.getUUID(), IPUtils.getIpAddr(getRequest()),
						member.getMemberNo(), member.getRealname(), new Date(), getRequest().getRequestURI(), "登录",
						"查询", "登录失败", "密码错误"));
			}
		} else {
			loginLogService.addLoginLog(new LoginLog(UUIDUtils.getUUID(), IPUtils.getIpAddr(getRequest()), null, null,
					new Date(), getRequest().getRequestURI(), "登录", "查询", "登录失败", "没有此账号"));
		}
		return null;
	}

	/**
	 * <B>方法名称：解锁</B><BR>
	 * 
	 * @see com.dada.service.IMemberService#login(java.lang.String,
	 *      java.lang.String)
	 */
	@Override
	public boolean unlock(String member_no, String password) {
		// TODO Auto-generated method stub
		HttpSession session = getRequest().getSession();
		List<Member> memberList = memberMapper.selectAllInfo(new Member(null, member_no, null, null, null, null, null,
				null, null, null, null, null, null, null, null, null, null, null));
		// 判断是否有此账号
		if (memberList.size() > 0) {
			// 判断密码是否正确
			Member member = memberList.get(0);
			if (member.getPassword().equals(password)) {
				session.setAttribute("member", member); // 重新填入session,防止用户锁定长时间未解锁导致session失效
				return true;
			}
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
		HttpSession session = getRequest().getSession();
		boolean bool = memberMapper.updateInfo(member);
		List<Member> info = memberMapper.selectAllInfo(new Member(member.getId(), null, null, null, null, null, null,
				null, null, null, null, null, null, null, null, null, null, null));
		Member sessionMember = (Member) session.getAttribute("member");
		if (bool) {
			operationLogService.addOperationLog(new OperationLog(UUIDUtils.getUUID(), sessionMember.getMemberNo(),
					sessionMember.getRealname(), IPUtils.getIpAddr(getRequest()), getRequest().getRequestURI(),
					"修改个人信息", "修改", "修改" + member.getMemberNo() + "信息成功", new Date()));
			session.setAttribute("member", info.get(0));
		} else {
			operationLogService.addOperationLog(new OperationLog(UUIDUtils.getUUID(), sessionMember.getMemberNo(),
					sessionMember.getRealname(), IPUtils.getIpAddr(getRequest()), getRequest().getRequestURI(),
					"修改个人信息", "修改", "修改" + member.getMemberNo() + "信息失败", new Date()));
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
		HttpSession session = getRequest().getSession();
		boolean bool = memberMapper.updatePassword(member);
		List<Member> info = memberMapper.selectAllInfo(new Member(null, member.getMemberNo(), null, null, null, null,
				null, null, null, null, null, null, null, null, null, null, null, null));
		if (bool) {
			operationLogService.addOperationLog(new OperationLog(UUIDUtils.getUUID(), info.get(0).getMemberNo(),
					info.get(0).getRealname(), IPUtils.getIpAddr(getRequest()), getRequest().getRequestURI(), "修改个人信息",
					"修改", "修改个人密码成功", new Date()));
			session.setAttribute("member", info.get(0));
		} else {
			operationLogService.addOperationLog(new OperationLog(UUIDUtils.getUUID(), info.get(0).getMemberNo(),
					info.get(0).getRealname(), IPUtils.getIpAddr(getRequest()), getRequest().getRequestURI(), "修改个人信息",
					"修改", "修改个人密码失败", new Date()));
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

	/**
	 * <B>方法名称：根据条件查询员工信息</B><BR>
	 * 
	 * @see com.dada.service.IMemberService#selectConditionsAllMamber(com.dada.entity.Member,
	 *      java.lang.String)
	 */
	@Override
	public List<Member> selectConditionsAllMamber(Member member, String page, String limit) {
		// TODO Auto-generated method stub
		member.setIsDeleted(false);
		List<Member> listMember = memberMapper.selectLikeInfo(member);
		// 从第几条数据开始
		int firstIndex = (Integer.valueOf(page) - 1) * (Integer.valueOf(limit));
		// 到第几条数据结束
		int lastIndex = 0;
		if (listMember.size() > Integer.valueOf(page) * (Integer.valueOf(limit))) {
			lastIndex = Integer.valueOf(page) * (Integer.valueOf(limit));
		} else {
			lastIndex = listMember.size();
		}
		return listMember.subList(firstIndex, lastIndex);
	}

	/**
	 * <B>概要说明：查询所有条数</B><BR>
	 * 
	 * @see com.dada.service.IMemberService#selectConditionsAllMamberNumber(com.dada.entity.Member)
	 */
	@Override
	public int selectConditionsAllMamberNumber(Member member) {
		// TODO Auto-generated method stub
		member.setIsDeleted(false);
		List<Member> listMember = memberMapper.selectLikeInfo(member);
		return listMember.size();
	}

	/**
	 * <B>概要说明：添加员工</B><BR>
	 * 
	 * @see com.dada.service.IMemberService#addMember(com.dada.entity.Member)
	 */
	@Override
	public boolean addMember(Member member) {
		// TODO Auto-generated method stub
		HttpSession session = getRequest().getSession();
		Member sessionMember = (Member) session.getAttribute("member");
		member.setId(UUIDUtils.getUUID());
		member.setCreateTime(new Date());// 创建时间
		member.setCreatorId(sessionMember.getId());// 创建者id
		member.setPassword("123456");
		if (memberMapper.insertSelective(member) > 0) {
			List<Member> info = memberMapper.selectAllInfo(new Member(member.getId(), null, null, null, null, null,
					null, null, null, null, null, null, null, null, null, null, null, null));
			operationLogService.addOperationLog(new OperationLog(UUIDUtils.getUUID(), sessionMember.getMemberNo(),
					sessionMember.getRealname(), IPUtils.getIpAddr(getRequest()), getRequest().getRequestURI(), "添加用户",
					"添加", "添加用户 工号:" + info.get(0).getMemberNo() + " 姓名:" + info.get(0).getRealname(), new Date()));
			return true;
		} else {
			operationLogService.addOperationLog(new OperationLog(UUIDUtils.getUUID(), sessionMember.getMemberNo(),
					sessionMember.getRealname(), IPUtils.getIpAddr(getRequest()), getRequest().getRequestURI(), "添加用户",
					"添加", "添加用户失败", new Date()));
			return false;
		}

	}

	/**
	 * <B>概要说明：获取下一个工号</B><BR>
	 * 
	 * @see com.dada.service.IMemberService#getMemberNo()
	 */
	@Override
	public String getMemberNo() {
		// TODO Auto-generated method stub
		// 计算工号
		List<Member> memberList = memberMapper.selectAllInfo(null);
		return MemberUtils.getMenberNo(memberList);

	}

	/**
	 * <B>概要说明：删除</B><BR>
	 * 
	 * @see com.dada.service.IMemberService#deleteMember(java.lang.String)
	 */
	@Override
	public boolean deleteMember(Member member) {
		// TODO Auto-generated method stub
		HttpSession session = getRequest().getSession();
		Member sessionMember = (Member) session.getAttribute("member");
		if (memberMapper.isDeleteMember(member)) {
			operationLogService.addOperationLog(new OperationLog(UUIDUtils.getUUID(), sessionMember.getMemberNo(),
					sessionMember.getRealname(), IPUtils.getIpAddr(getRequest()), getRequest().getRequestURI(), "删除用户",
					"删除", "删除用户成功  工号:" + member.getMemberNo() + " 姓名:" + member.getRealname(), new Date()));
			return true;
		} else {
			operationLogService.addOperationLog(new OperationLog(UUIDUtils.getUUID(), sessionMember.getMemberNo(),
					sessionMember.getRealname(), IPUtils.getIpAddr(getRequest()), getRequest().getRequestURI(), "删除用户",
					"删除", "删除用户失败  工号:" + member.getMemberNo() + " 姓名:" + member.getRealname(), new Date()));
			return false;
		}
	}

	/**
	 * <B>方法名称：</B><BR>
	 * <B>概要说明：</B><BR>
	 * 
	 * @see com.dada.service.IMemberService#getMemberName(java.lang.String)
	 */
	@Override
	public String getMemberName(String id) {
		// TODO Auto-generated method stub
		String memberName = memberMapper.getMemberName(id);
		return memberName;
	}

	/**
	 * <B>概要说明：获取最后登录时间</B><BR>
	 * 
	 * @see com.dada.service.IMemberService#getLastTime()
	 */
	@Override
	public Date getLastTime() {
		HttpSession session = getRequest().getSession();
		Member member = (Member) session.getAttribute("member");
		return member.getLastTime();
	}

	/**
	 * <B>概要说明：文件上传</B><BR>
	 * 
	 * @see com.dada.service.IMemberService#memberPicture(org.springframework.web.multipart.MultipartFile,
	 *      org.springframework.ui.Model)
	 */
	@Override
	public String memberPicture(MultipartFile multipartFile) {
		// TODO Auto-generated method stub
		// 0，判断是否为空
		if (multipartFile != null && !multipartFile.isEmpty()) {
			/**
			 * 对文件名进行操作防止文件重名
			 */
			// 1，获取原始文件名
			String originalFilename = multipartFile.getOriginalFilename();
			// 2,截取源文件的文件名前缀,不带后缀
			String fileNamePrefix = originalFilename.substring(0, originalFilename.lastIndexOf("."));
			// 3,加工处理文件名，原文件加上时间戳
			String newFileNamePrefix = fileNamePrefix + System.currentTimeMillis();
			// 4,得到新文件名
			String newFileName = newFileNamePrefix + originalFilename.substring(originalFilename.lastIndexOf("."));
			// 5,构建文件对象
			// 获取服务器相路径
			String url = getRequest().getServletContext().getRealPath("/upload");
			File file = new File(url);
			if (!file.exists()) {
				file.mkdirs();
			}
			File newfile = new File(url + File.separator + newFileName);
			// 6,执行上传操作
			try {
				multipartFile.transferTo(newfile);
			} catch (IOException e) {
				e.printStackTrace();
			}
			return "upload" + File.separator + newFileName;
		} else {
			return null;
		}

	}

	/**
	 * <B>概要说明：更新数据库头像地址</B><BR>
	 * 
	 * @see com.dada.service.IMemberService#updateHandUrl(java.lang.String)
	 */
	@Override
	public boolean updateHandUrl(String path, String id) {
		// TODO Auto-generated method stub
		Member member = new Member();
		member.setId(id);
		member.setHeadUrl(path);
		return memberMapper.updateInfoHandlr(member) > 0;
	}

	/**
	 * 查询所有员工
	 */
	@Override
	public List<Member> selectConditionsAllMamber(Member member) {
		return memberMapper.selectAllInfo(member);
	}

	/**
	 * <B>方法名称：</B><BR>
	 * <B>概要说明：</B><BR>
	 * @see com.dada.service.IMemberService#memberCount()
	 */
	@Override
	public int memberCount() {
		// TODO Auto-generated method stub
		return memberMapper.memberCount();
	}
}
