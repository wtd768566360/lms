/**
 * Copyright 2019 TPRI. All Rights Reserved.
 */
package demo;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;

import com.dada.common.ServerResponse;
import com.dada.dao.MemberMapper;
import com.dada.entity.Member;
import com.dada.service.IMemberService;
import com.dada.utils.MemberUtils;

/**
 * <B>系统名称：</B><BR>
 * <B>模块名称：</B><BR>
 * <B>中文类名：</B><BR>
 * <B>概要说明：</B><BR>
 * 
 * @author（WuTengda） @since 2019年4月21日
 */
public class FunctionTest extends BaseTest {

	@Autowired
	private IMemberService memberService;
	@Resource
	private MemberMapper memberMapper;

	@Test
	public void getMemberNo() {
		List<Member> memberList = memberMapper.selectAllInfo(null);
		String str = MemberUtils.getMenberNo(memberList);
		System.out.println(str);
	}

	@Test
	public void sessionTest() {

	}
}
