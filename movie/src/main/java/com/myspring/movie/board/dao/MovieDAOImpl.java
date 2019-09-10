package com.myspring.movie.board.dao;

import java.util.List;
import java.util.Map;

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
		public int insertNewArticle(Map articleMap) throws DataAccessException {
			int movieNO = selectNewArticleNO();
			articleMap.put("movieNO", movieNO);
			sqlSession.insert("mapper.movie.insertNewArticle", movieNO);
			return movieNO;
		}

		private int selectNewArticleNO() {
			return sqlSession.selectOne("mapper.movie.selectNewArticleNO");
		}

		@Override
		public MovieVO selectArticle(int articleNO) throws DataAccessException {
			return sqlSession.selectOne("mapper.movie.selectArticle", articleNO);
		}

		@Override
		public void updateArticle(Map articleMap) throws DataAccessException {
	      sqlSession.update("mapper.movie.updateArticle", articleMap);
		}

		@Override
		public void deleteArticle(int articleNO) throws DataAccessException {
			sqlSession.delete("mapper.movie.deleteArticle",articleNO);
		}

		@Override
		public List selectImageFileList(int articleNO) throws DataAccessException {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public int insertNewReply(Map<String, Object> articleMap) throws DataAccessException {
			int articleNO = selectNewArticleNO();
			articleMap.put("articleNO", articleNO);
			sqlSession.insert("mapper.board.insertReply",articleMap);
			return articleNO;
		}
}
