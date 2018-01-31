package com.java.pos.controller;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.java.pos.service.accountServiceInterface;
import com.java.pos.util.HttpUtil;

@Controller
public class accountController {

	
	@Autowired
	accountServiceInterface asi;
	
	@RequestMapping(value="/daySert", method=RequestMethod.POST)
	public ModelAndView daySert(HttpSession session, HttpServletRequest req) {
		HashMap<String, Object> user = (HashMap<String, Object>) session.getAttribute("logonUser");
		System.out.println("컨트롤 : " + user.get("logonUser"));
		return HttpUtil.returnJson(asi.daySert((HashMap<String, Object>) user.get("logonUser")));
	}
	
	@RequestMapping(value="/itemSert", method=RequestMethod.POST)
	public ModelAndView itemSert(HttpSession session, HttpServletRequest req) {
//		HashMap<String, Object> user = (HashMap<String, Object>) session.getAttribute("logonUser");
		return HttpUtil.returnJson(asi.itemSert(HttpUtil.paramMap(req)));
	}
	
}
