package com.myspring.movie.member.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.myspring.movie.board.vo.MovieVO;
import com.myspring.movie.member.service.MemberService;
import com.myspring.movie.member.vo.MemberVO;

@Controller("memberController")
public class MemberControllerImpl implements MemberController {

	@Autowired
	private MemberService memberService;
	@Autowired
	MemberVO memberVO;

	@Override
	@RequestMapping(value = "/member/listMembers.do", method = { RequestMethod.GET, RequestMethod.POST })

	public ModelAndView ListMember(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("controller작동");
		String viewName = getViewName(request);
		List<MemberVO> memberList = memberService.memberList();
		/* MovieVO result = memberService.getArticle(); */
		ModelAndView mav = new ModelAndView(viewName);
		mav.addObject("memberList", memberList);
		/* mav.addObject("result", result.toString()); */
		/*
		 * System.out.println(memberList.get(0).toString());
		 * System.out.println(memberList.size());
		 */
		System.out.println(viewName);
		return mav;
	}

	@Override
	@RequestMapping(value = "/member/addMember.do", method = RequestMethod.POST)
	public ModelAndView addMember(@ModelAttribute("member") MemberVO memberVO, HttpServletRequest request,
			
			//memberVO member=new Member();
			//member.setId(request.getparater("id"));
			HttpServletResponse response) throws Exception {
		System.out.println("회원가입컨트롤러 실행");
		System.out.println(memberVO);
		memberService.addMember(memberVO);
		ModelAndView mav = new ModelAndView("redirect:/member/listMembers.do");
		return mav;
	}

	private String getViewName(HttpServletRequest request) throws Exception {
		String contextPath = request.getContextPath();
		String uri = (String) request.getAttribute("javax.servlet.include.request_uri");
		if (uri == null || uri.trim().equals("")) {
			uri = request.getRequestURI();
		}

		int begin = 0;
		if (!((contextPath == null) || ("".equals(contextPath)))) {
			begin = contextPath.length();
		}

		int end;
		if (uri.indexOf(";") != -1) {
			end = uri.indexOf(";");
		} else if (uri.indexOf("?") != -1) {
			end = uri.indexOf("?");
		} else {
			end = uri.length();
		}

		String viewName = uri.substring(begin, end);
		if (viewName.indexOf(".") != -1) {
			viewName = viewName.substring(0, viewName.lastIndexOf("."));
		}
		if (viewName.lastIndexOf("/") != -1) {
			viewName = viewName.substring(viewName.lastIndexOf("/", 1), viewName.length());
		}
		return viewName;
	}

	@RequestMapping(value = { "/member/*Form.do" }, method = RequestMethod.GET)
	public ModelAndView form(@RequestParam(value = "action", required = false) String action,
			@RequestParam(value = "result", required = false) String result, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		/* String viewName = getViewName(request); */
		String viewName = (String) request.getAttribute("viewName");
		ModelAndView mav = new ModelAndView(viewName);

		if (action != null) {
			if (action.equals("update")) {
				String id = request.getParameter("id");
				MemberVO memberVO = memberService.getMemberInfo(id);
				mav.addObject("member", memberVO);
				return mav;
			} else {
				HttpSession session = request.getSession();
				session.setAttribute("action", action);// action의 값이 update가 아닐때
				mav.addObject("result", result);
				mav.setViewName(viewName);
				System.out.println("action=" + session.getAttribute("action"));
				return mav;
			}
		} else if (action == null) {
			mav.addObject("result", result);
			System.out.println("result가 뭐지 ->"+result);
			return mav;
		}

		return null;
	}

}
