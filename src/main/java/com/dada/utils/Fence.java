/**
 * Copyright 2019 TPRI. All Rights Reserved.
 */
package com.dada.utils;

/**
 * <B>系统名称：</B><BR>
 * <B>模块名称：</B><BR>
 * <B>中文类名：</B><BR>
 * <B>概要说明：</B><BR>
 * 
 * @author（WuTengda） @since 2019年4月20日
 */
/* 栅栏解密解密类 */
public class Fence {
	/* 加密部分 */
	public String encryption(String password) {
		String p = new String();
		String p1 = new String();
		String p2 = new String();
		for (int i = 0; i < password.length(); i++) {
			if (i % 2 == 0)
				p1 += p.valueOf(password.charAt(i));
			else
				p2 += p.valueOf(password.charAt(i));
		}
		return p1 + p2;
	}

	/* 解密部分 */
	public String decode(String FencePassword) {
		String password = new String();
		String p = new String();
		String p1 = FencePassword.substring(0, FencePassword.length() / 2);
		String p2 = FencePassword.substring(FencePassword.length() / 2);
		int i;
		for (i = 0; i < p1.length(); i++) {
			password += p.valueOf(p1.charAt(i)) + p.valueOf(p2.charAt(i));
		}
		if (FencePassword.length() % 2 != 0)
			password += p.valueOf(p2.charAt(i));
		return password;
	}
}
