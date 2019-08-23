package com.myspring.movie.board.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.myspring.movie.board.dao.MovieDAO;
import com.myspring.movie.board.vo.MovieVO;

@Service("movieService")
@Transactional(propagation = Propagation.REQUIRED)
public class MovieServiceImpl implements MovieService {
	@Autowired
	MovieDAO movieDAO;
	@Autowired
	MovieVO movieVO;

	@Override
	public List listArticles() throws Exception {
		List list =movieDAO.selectAllArticlesList();
		System.out.println(list.size());
		return list;
	}

	@Override
	public MovieVO getArticle() throws Exception {
		return movieDAO.selectArticle();
	}
}
