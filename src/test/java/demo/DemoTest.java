/**
 * Copyright 2019 TPRI. All Rights Reserved.
 */
package demo;

import org.junit.Test;

import com.dada.utils.MemberUtils;

/**
 * <B>系统名称：</B><BR>
 * <B>模块名称：</B><BR>
 * <B>中文类名：</B><BR>
 * <B>概要说明：</B><BR>
 * @author（WuTengda）
 * @since 2019年4月27日
 */
public class DemoTest {
	
	@Test
	public void MemberNo(){
		String str = String.format("%4d", 10000000).replace(" ", "0");  
		System.out.println(str);
	}
}
