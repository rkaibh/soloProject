package com.java.pos.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.java.pos.service.boardServiceInterface;
import com.java.pos.util.HttpUtil;

@Controller
public class boardController {

	@Autowired
	boardServiceInterface bsi;
	
	@RequestMapping(value="/first", method=RequestMethod.POST)
	public ModelAndView first(HttpServletRequest req, HttpSession session) {
//		HashMap<String, Object> user = (HashMap<String, Object>) session.getAttribute("logonUser");
		return HttpUtil.returnJson(bsi.first(HttpUtil.paramMap(req)));
	}
	
	@RequestMapping(value="/adminAdd", method=RequestMethod.POST)
	public ModelAndView adminAdd(HttpServletRequest req, HttpSession session) {
//		HashMap<String, Object> user = (HashMap<String, Object>) session.getAttribute("logonUser");
		return HttpUtil.returnJson(bsi.adminAdd(HttpUtil.paramMap(req)));
	}
	
	@RequestMapping(value="/boardList", method=RequestMethod.POST)
	public ModelAndView boardList(HttpServletRequest req, HttpSession session) {
//		HashMap<String, Object> user = (HashMap<String, Object>) session.getAttribute("logonUser");
		return HttpUtil.returnJson(bsi.boardList(HttpUtil.paramMap(req)));
	}
	
	@RequestMapping(value="/boardDetail", method=RequestMethod.POST)
	public ModelAndView boardDetail(HttpServletRequest req, HttpSession session) {
//		HashMap<String, Object> user = (HashMap<String, Object>) session.getAttribute("logonUser");
		return HttpUtil.returnJson(bsi.boardDetail(HttpUtil.paramMap(req)));
	}
	
}
