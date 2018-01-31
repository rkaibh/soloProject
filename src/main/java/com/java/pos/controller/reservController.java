package com.java.pos.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.java.pos.service.reservServiceInterface;
import com.java.pos.util.HttpUtil;

@Controller
public class reservController {

	@Autowired
	reservServiceInterface rsi;
	
	@RequestMapping(value="/reservItem", method=RequestMethod.POST)
	public ModelAndView reservItem(HttpServletRequest req, HttpSession session) {
//		HashMap<String, Object> user = (HashMap<String, Object>) session.getAttribute("logonUser");
		return HttpUtil.returnJson(rsi.reservItem(HttpUtil.paramMap(req)));
	}
	
	@RequestMapping(value="/reservList", method=RequestMethod.POST)
	public ModelAndView reservList(HttpServletRequest req, HttpSession session) {
//		HashMap<String, Object> user = (HashMap<String, Object>) session.getAttribute("logonUser");
		return HttpUtil.returnJson(rsi.reservList(HttpUtil.paramMap(req)));
	}
	
}
