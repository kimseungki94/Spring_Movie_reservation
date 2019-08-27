package com.myspring.movie.member.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.myspring.movie.board.vo.MovieVO;
import com.myspring.movie.member.dao.MemberDAO;
import com.myspring.movie.member.vo.MemberVO;

@Service("memberService")
@Transactional(propagation = Propagation.REQUIRED)
public class MemberServiceImpl implements MemberService {

	@Autowired
	MemberDAO memberDAO;
	@Autowired
	MovieVO movieVO;
	
	@Override  
	public List<MemberVO> memberList() throws Exception {
		System.out.println("서비스작동");
		List<MemberVO> list =memberDAO.AllMemberList();
		return list;
	}
	@Override
	public int addMember(MemberVO memberVO) throws DataAccessException {
		return memberDAO.insertMember(memberVO);
	} 
	@Override
	public int removeMember(String id) throws DataAccessException {
		return memberDAO.deleteMember(id);
	}
	
	@Override
	public MemberVO getMemberInfo(String id) throws DataAccessException {
		return memberDAO.selectMemberInfo(id);
	}
	@Override
	public int updateMember(MemberVO memberVO) throws DataAccessException {
		return memberDAO.updateMember(memberVO);
	}

	@Override
	public String getMemberDBPwd(MemberVO memberVO) throws DataAccessException {
		return memberDAO.selectMemberDBPwd(memberVO);
	}

	@Override
	public MemberVO login(MemberVO member) throws DataAccessException {
		return memberDAO.selectMemberInfo( member);
	}

}
