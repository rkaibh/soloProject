package com.java.pos.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.java.pos.service.sellServiceInterface;
import com.java.pos.util.HttpUtil;

@Controller
public class sellController {

	@Autowired
	sellServiceInterface ssi;
	
	@RequestMapping(value="/addsell1", method=RequestMethod.POST)
	public ModelAndView addsell1(HttpServletRequest req, HttpSession session) {
//		HashMap<String, Object> user = (HashMap<String, Object>) session.getAttribute("logonUser");
		return HttpUtil.returnJson(ssi.addsell1(HttpUtil.paramMap(req)));
	}
	
	@RequestMapping(value="/addsell2", method=RequestMethod.POST)
	public ModelAndView addsell2(HttpServletRequest req, HttpSession session) {
//		HashMap<String, Object> user = (HashMap<String, Object>) session.getAttribute("logonUser");
		return HttpUtil.returnJson(ssi.addsell2(HttpUtil.paramMap(req)));
	}
	
	@RequestMapping(value="/sellDetail1", method=RequestMethod.POST)
	public ModelAndView sellDetail1(HttpServletRequest req, HttpSession session) {
//		HashMap<String, Object> user = (HashMap<String, Object>) session.getAttribute("logonUser");
		return HttpUtil.returnJson(ssi.sellDetail1(HttpUtil.paramMap(req)));
	}
	
	@RequestMapping(value="/sellDetail2", method=RequestMethod.POST)
	public ModelAndView sellDetail2(HttpServletRequest req, HttpSession session) {
//		HashMap<String, Object> user = (HashMap<String, Object>) session.getAttribute("logonUser");
		return HttpUtil.returnJson(ssi.sellDetail2(HttpUtil.paramMap(req)));
	}
	
	@RequestMapping(value="/takeBack", method=RequestMethod.POST)
	public ModelAndView takeBack(HttpServletRequest req, HttpSession session) {
//		HashMap<String, Object> user = (HashMap<String, Object>) session.getAttribute("logonUser");
		return HttpUtil.returnJson(ssi.takeBack(HttpUtil.paramMap(req)));
	}
	
	@RequestMapping(value="/sellList", method=RequestMethod.POST)
	public ModelAndView sellList(HttpServletRequest req, HttpSession session) {
//		HashMap<String, Object> user = (HashMap<String, Object>) session.getAttribute("logonUser");
		return HttpUtil.returnJson(ssi.sellList(HttpUtil.paramMap(req)));
	}
	
	@RequestMapping(value="/sellList3", method=RequestMethod.POST)
	public ModelAndView sellList3(HttpServletRequest req, HttpSession session) {
//		HashMap<String, Object> user = (HashMap<String, Object>) session.getAttribute("logonUser");
		return HttpUtil.returnJson(ssi.sellList3(HttpUtil.paramMap(req)));
	}
	
	@RequestMapping(value="/sellDetailList", method=RequestMethod.POST)
	public ModelAndView sellDetailList(HttpServletRequest req, HttpSession session) {
//		HashMap<String, Object> user = (HashMap<String, Object>) session.getAttribute("logonUser");
		return HttpUtil.returnJson(ssi.sellDetailList(HttpUtil.paramMap(req)));
	}
	
	@RequestMapping(value="/forSellOrder", method=RequestMethod.POST)
	public ModelAndView forSellOrder(HttpServletRequest req, HttpSession session) {
//		HashMap<String, Object> user = (HashMap<String, Object>) session.getAttribute("logonUser");
		return HttpUtil.returnJson(ssi.forSellOrder(HttpUtil.paramMap(req)));
	}
	
	@RequestMapping(value="/sellforList", method=RequestMethod.POST)
	public ModelAndView sellforList(HttpServletRequest req, HttpSession session) {
//		HashMap<String, Object> user = (HashMap<String, Object>) session.getAttribute("logonUser");
		return HttpUtil.returnJson(ssi.sellforList(HttpUtil.paramMap(req)));
	}
	
	@RequestMapping(value="/sellboard", method=RequestMethod.POST)
	public ModelAndView sellboard(HttpServletRequest req, HttpSession session) {
//		HashMap<String, Object> user = (HashMap<String, Object>) session.getAttribute("logonUser");
		return HttpUtil.returnJson(ssi.sellboard(HttpUtil.paramMap(req)));
	}
	
	@RequestMapping(value="/Finish", method=RequestMethod.POST)
	public ModelAndView Finish(HttpServletRequest req, HttpSession session) {
//		HashMap<String, Object> user = (HashMap<String, Object>) session.getAttribute("logonUser");
		return HttpUtil.returnJson(ssi.Finish(HttpUtil.paramMap(req)));
	}
	
	@RequestMapping(value="/forResult", method=RequestMethod.POST)
	public ModelAndView forResult(HttpServletRequest req, HttpSession session) {
//		HashMap<String, Object> user = (HashMap<String, Object>) session.getAttribute("logonUser");
		return HttpUtil.returnJson(ssi.forResult(HttpUtil.paramMap(req)));
	}
	
}
