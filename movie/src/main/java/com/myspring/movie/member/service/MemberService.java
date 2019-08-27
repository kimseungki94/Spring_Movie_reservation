package com.myspring.movie.member.service;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.myspring.movie.member.vo.MemberVO;

public interface MemberService {
	public List<MemberVO> memberList() throws Exception;
	public int addMember(MemberVO memberVO) throws DataAccessException;
	public MemberVO getMemberInfo(String id) throws DataAccessException;
	public int removeMember(String id) throws DataAccessException;
	public int updateMember(MemberVO memberVO) throws DataAccessException;
	public String getMemberDBPwd(MemberVO memberVO) throws DataAccessException;
	public MemberVO login(MemberVO member) throws DataAccessException;
}
