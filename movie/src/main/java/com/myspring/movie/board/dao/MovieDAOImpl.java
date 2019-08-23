package com.myspring.movie.board.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.myspring.movie.board.vo.MovieVO;

@Repository("movieDAO")
public class MovieDAOImpl implements MovieDAO {
	
	
		@Autowired
		private SqlSession sqlSession;
		
		@Override
		public List selectAllArticlesList() throws DataAccessException {
			List list=sqlSession.selectList("mapper.movie.selectAllArticlesList");
			System.out.println(list.size());
			return list;
		}

		@Override
		public MovieVO selectArticle() throws DataAccessException {
		   return sqlSession.selectOne("mapper.movie.selectArticle");
		}
}
