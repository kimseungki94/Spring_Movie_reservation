package com.myspring.movie.board.dao;

import java.util.List;
import java.util.Map;

import org.springframework.dao.DataAccessException;

import com.myspring.movie.board.vo.MovieVO;

public interface MovieDAO {
	public List selectAllArticlesList() throws DataAccessException;
	public int insertNewArticle(Map articleMap) throws DataAccessException;
	public MovieVO selectArticle(int articleNO) throws DataAccessException;
	public void updateArticle(Map articleNO) throws DataAccessException;
	public void deleteArticle(int articleNO) throws DataAccessException;
	public List selectImageFileList(int articleNO) throws DataAccessException;
	public int insertNewReply(Map<String, Object> articleMap)  throws DataAccessException;
}
