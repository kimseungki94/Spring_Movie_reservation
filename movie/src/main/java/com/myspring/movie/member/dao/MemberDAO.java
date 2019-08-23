package com.myspring.movie.member.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.myspring.movie.member.vo.MemberVO;

public interface MemberDAO {
	public List<MemberVO> AllMemberList() throws DataAccessException;
	public int insertMember(MemberVO memberVO) throws DataAccessException;
	public MemberVO selectMemberInfo(String id) throws DataAccessException;

}
