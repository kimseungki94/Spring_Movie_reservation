package com.myspring.movie.board.service;

import java.util.List;
import java.util.Map;

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
	public List<MovieVO> listArticles() throws Exception {
		List list =movieDAO.selectAllArticlesList();
		System.out.println(list.size());
		return list;
	}

	@Override
	public int addNewArticle(Map articleMap) throws Exception {
		return movieDAO.insertNewArticle(articleMap);
	}

	@Override
	public MovieVO viewArticle(int articleNO) throws Exception {
		return movieDAO.selectArticle(articleNO);
	}
 
	@Override
	public void modArticle(Map articleMap) throws Exception {
		movieDAO.updateArticle(articleMap);
	}

	@Override
	public void removeArticle(int articleNO) throws Exception {
		movieDAO.deleteArticle(articleNO);
	}

	@Override
	public int addReply(Map<String, Object> articleMap) throws Exception {
		return movieDAO.insertNewReply(articleMap);
	}
 
	@Override
	public MovieVO getArticle(int articleNO) throws Exception {
		return movieDAO.selectArticle(articleNO);
	}
}
