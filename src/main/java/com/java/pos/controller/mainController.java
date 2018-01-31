package com.java.pos.controller;

import java.util.HashMap;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.java.pos.service.userServiceInterface;
import com.java.pos.util.HttpUtil;

@Controller
public class mainController {

	@Resource
	userServiceInterface usi;
	
	@RequestMapping("/")
	public ModelAndView main(HttpSession session, ModelAndView mav) {
//		HashMap<String, Object> user = (HashMap<String, Object>) session.getAttribute("logonUser");
		mav.setViewName("main");
		return mav;
	}
	
	@RequestMapping(value="/keepUser", method=RequestMethod.POST)
	public ModelAndView keepUser(HttpServletRequest req, HttpSession session) {
		@SuppressWarnings("unchecked")
		HashMap<String, Object> user = (HashMap<String, Object>) session.getAttribute("logonUser");
		if(user == null) {
			HashMap<String, Object> logout = new HashMap<String, Object>();
			logout.put("stat", 0);
			return HttpUtil.returnJson(logout);
		}else {
			return HttpUtil.returnJson(user);
		}
	}

}
