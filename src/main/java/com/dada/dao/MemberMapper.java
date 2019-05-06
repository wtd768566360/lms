package com.dada.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.dada.entity.Member;

@Mapper
public interface MemberMapper {
	int insert(Member record);

	int insertSelective(Member record);

	List<Member> login(String member_no);

	boolean updateInfo(Member member);

	boolean updatePassword(Member member);

	List<Member> selectAllInfo(Member member);

	List<Member> selectLikeInfo(Member member);

	boolean isDeleteMember(Member member);

	String getMemberName(String id);

	boolean updateLastTime(Member updateMember);

	int updateInfoHandlr(Member member);

	int memberCount();
}