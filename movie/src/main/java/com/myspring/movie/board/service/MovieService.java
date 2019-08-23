package com.myspring.movie.board.service;

import java.util.List;

import com.myspring.movie.board.vo.MovieVO;


public interface MovieService {
	public List listArticles() throws Exception;

	public MovieVO getArticle() throws Exception;
}
