package com.myspring.movie.member.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.myspring.movie.member.vo.MemberVO;

@Repository("memberDAO")
public class MemberDAOImpl implements MemberDAO {

	@Autowired
	private SqlSession sqlSession;
	//원래 List<MemberVO>였지만... 전 다르게 바꾸렵니다...
	@Override
	public List<MemberVO> AllMemberList() throws DataAccessException {
		System.out.println("다오 작동");
		System.out.println("다오list 준비중");
		List<MemberVO> list= sqlSession.selectList("mapper.member.listAllMembers");
		//selecton selectionlist 중점적으로 확인이 필요
		System.out.println("다오list->"+list);
		return list;
	}
	@Override
	public int insertMember(MemberVO memberVO) throws DataAccessException {
		return sqlSession.insert("mapper.member.insertMember", memberVO);
	}
	@Override
	public MemberVO selectMemberInfo(String id) throws DataAccessException {
		System.out.println("id가 모야->"+id);
		return (MemberVO) sqlSession.selectOne("mapper.member.selectMemberInfo", id);
	}
}
