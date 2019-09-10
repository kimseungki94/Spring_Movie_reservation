package com.myspring.movie.board.service;

import java.util.List;
import java.util.Map;

import com.myspring.movie.board.vo.MovieVO;


public interface MovieService {

	public MovieVO getArticle(int articleNO) throws Exception;
	public List<MovieVO> listArticles() throws Exception;
	public int addNewArticle(Map articleMap) throws Exception;
	public MovieVO viewArticle(int articleNO) throws Exception;
	public void modArticle(Map articleMap) throws Exception;
	public void removeArticle(int articleNO) throws Exception;
	public int addReply(Map<String, Object> articleMap) throws Exception;
}
