package com.myspring.movie.board.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.ModelAndView;

import com.myspring.movie.member.vo.MemberVO;

public interface MovieController {
	public ModelAndView Samplearticle(HttpServletRequest request, 
		     HttpServletResponse response) throws Exception;
}
