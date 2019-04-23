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

	Member selectAllInfo(Member member);
}