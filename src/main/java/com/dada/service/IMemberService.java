/**
 * Copyright 2019 TPRI. All Rights Reserved.
 */
package com.dada.service;

import com.dada.entity.Member;

/**
 * @author （WuTengda）
 * @since 2019年4月19日
 */
public interface IMemberService {

	boolean login(String member_no, String pass);

	Member selectMember();

	boolean updateInfo(Member member);

	boolean updatePassword(Member member);

	boolean removeMemberExit(String memberNo, String realname);

}
