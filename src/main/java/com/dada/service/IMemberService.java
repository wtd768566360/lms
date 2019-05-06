/**
 * Copyright 2019 TPRI. All Rights Reserved.
 */
package com.dada.service;

import java.util.Date;
import java.util.List;

import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartFile;

import com.dada.entity.Member;

/**
 * @author （WuTengda）
 * @since 2019年4月19日
 */
public interface IMemberService {

	Member login(String member_no, String pass);

	Member selectMember();

	boolean updateInfo(Member member);

	boolean updatePassword(Member member);

	boolean removeMemberExit(String memberNo, String realname);

	boolean addMember(Member member);

	List<Member> selectConditionsAllMamber(Member member, String page, String limit);

	int selectConditionsAllMamberNumber(Member member);

	boolean inspectionOldPwd(String member_no, String password);

	boolean unlock(String member_no, String password);

	String getMemberNo();

	boolean deleteMember(Member member);

	String getMemberName(String id);

	Date getLastTime();

	String memberPicture(MultipartFile multipartFile);

	boolean updateHandUrl(String path,String id);

	List<Member> selectConditionsAllMamber(Member member);

	int memberCount();
}
