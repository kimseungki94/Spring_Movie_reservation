package com.myspring.movie.member.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.ModelAndView;

import com.myspring.movie.member.vo.MemberVO;

public interface MemberController {
	public ModelAndView ListMember
	(HttpServletRequest request,HttpServletResponse response)
	throws Exception;
	public ModelAndView addMember(@ModelAttribute("info") MemberVO memberVO,HttpServletRequest request, HttpServletResponse response) throws Exception;
}
