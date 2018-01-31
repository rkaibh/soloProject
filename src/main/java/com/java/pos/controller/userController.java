package com.java.pos.controller;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.java.pos.service.userServiceInterface;
import com.java.pos.util.HttpUtil;


@Controller
public class userController {

	@Autowired
	userServiceInterface usi;
	
	@RequestMapping(value="/logon", method=RequestMethod.POST)
	public ModelAndView logon(HttpServletRequest req, HttpSession session) {
		HashMap<String, Object> log = new HashMap<String, Object>();
		log.put("log", usi.logon(HttpUtil.paramMap(req)));
		session.setAttribute("logonUser", log.get("log"));
		return HttpUtil.returnJson(usi.logon(HttpUtil.paramMap(req)));
	}
	
	@RequestMapping(value="/addAdmin", method=RequestMethod.POST)
	public ModelAndView addAdmin(HttpServletRequest req, HttpSession session) {
//		HashMap<String, Object> user = (HashMap<String, Object>) session.getAttribute("logonUser");
		return HttpUtil.returnJson(usi.addAdmin(HttpUtil.paramMap(req)));
	}
	
	@RequestMapping(value="/addUser", method=RequestMethod.POST)
	public ModelAndView addUser(HttpServletRequest req, HttpSession session) {
//		HashMap<String, Object> user = (HashMap<String, Object>) session.getAttribute("logonUser");
		return HttpUtil.returnJson(usi.addUser(HttpUtil.paramMap(req)));
	}
	
	@RequestMapping(value="/userList", method=RequestMethod.POST)
	public ModelAndView userList(HttpServletRequest req, HttpSession session) {
//		HashMap<String, Object> user = (HashMap<String, Object>) session.getAttribute("logonUser");
		return HttpUtil.returnJson(usi.userList(HttpUtil.paramMap(req)));
	}
	
	@RequestMapping(value="/userDel", method=RequestMethod.POST)
	public ModelAndView userDel(HttpServletRequest req, HttpSession session) {
//		HashMap<String, Object> user = (HashMap<String, Object>) session.getAttribute("logonUser");
		return HttpUtil.returnJson(usi.userDel(HttpUtil.paramMap(req)));
	}
	
	@RequestMapping("/logout")
	public ModelAndView logout(HttpSession session) {
		session.invalidate();
		HashMap<String, Object> logout = new HashMap<String, Object>();
		logout.put("stat", 0);
		return HttpUtil.returnJson(logout);
	}
	
	@RequestMapping(value="/IDList", method=RequestMethod.POST)
	public ModelAndView IDList(HttpServletRequest req, HttpSession session) {
//		HashMap<String, Object> user = (HashMap<String, Object>) session.getAttribute("logonUser");
		return HttpUtil.returnJson(usi.IDList(HttpUtil.paramMap(req)));
	}
	
}

