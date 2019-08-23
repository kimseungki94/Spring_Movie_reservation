package com.myspring.movie.board.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.myspring.movie.board.vo.MovieVO;

public interface MovieDAO {
	public List selectAllArticlesList() throws DataAccessException;

	public MovieVO selectArticle() throws DataAccessException;
}
