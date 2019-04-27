/**
 * Copyright 2019 TPRI. All Rights Reserved.
 */
package com.dada.utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.dada.entity.Member;

/**
 * <B>模块名称：工号处理</B><BR>
 * 
 * @author（WuTengda） @since 2019年4月27日
 */
public class MemberUtils {

	public static String getMenberNo(List<Member> memberList) {
		List<Integer> mberNo = new ArrayList<>();
		for (Member info : memberList) {
			mberNo.add(Integer.valueOf(info.getMemberNo().substring(1)));
		}
		Collections.sort(mberNo);
		int newNo = (mberNo.get(mberNo.size() - 1)) + 1;
		String str = "N" + String.format("%4d", newNo).replace(" ", "0");//位数不够  前面补零
		return str;
	}
}
