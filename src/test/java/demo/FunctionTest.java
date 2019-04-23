/**
 * Copyright 2019 TPRI. All Rights Reserved.
 */
package demo;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;

import com.dada.common.ServerResponse;
import com.dada.entity.Member;
import com.dada.service.IMemberService;

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

	@Test
	public void sessionTest() {

		if(memberService.login("N0001", "123456")){
			Member member = memberService.selectMember();
			System.out.println(member.getMemberNo());
		}
	}
}
