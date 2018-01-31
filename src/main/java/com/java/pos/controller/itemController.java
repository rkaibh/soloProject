package com.java.pos.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.java.pos.service.itemServiceInterface;
import com.java.pos.util.HttpUtil;

@Controller
public class itemController {

	@Autowired
	itemServiceInterface isi;
	
	@RequestMapping(value="/addItem", method=RequestMethod.POST)
	public ModelAndView addItem(HttpServletRequest req, HttpSession session) {
//		HashMap<String, Object> user = (HashMap<String, Object>) session.getAttribute("logonUser");
		return HttpUtil.returnJson(isi.addItem(HttpUtil.paramMap(req)));
	}
	
	@RequestMapping(value="/addInven", method=RequestMethod.POST)
	public ModelAndView addInven(HttpServletRequest req, HttpSession session) {
//		HashMap<String, Object> user = (HashMap<String, Object>) session.getAttribute("logonUser");
		return HttpUtil.returnJson(isi.addInven(HttpUtil.paramMap(req)));
	}
	
	@RequestMapping(value="/itemList", method=RequestMethod.POST)
	public ModelAndView itemList(HttpServletRequest req, HttpSession session) {
//		HashMap<String, Object> user = (HashMap<String, Object>) session.getAttribute("logonUser");
		return HttpUtil.returnJson(isi.itemList(HttpUtil.paramMap(req)));
	}
	
	@RequestMapping(value="/invenList", method=RequestMethod.POST)
	public ModelAndView invenList(HttpServletRequest req, HttpSession session) {
//		HashMap<String, Object> user = (HashMap<String, Object>) session.getAttribute("logonUser");
		return HttpUtil.returnJson(isi.invenList(HttpUtil.paramMap(req)));
	}
	
	@RequestMapping(value="/itemDel", method=RequestMethod.POST)
	public ModelAndView itemDel(HttpServletRequest req, HttpSession session) {
//		HashMap<String, Object> user = (HashMap<String, Object>) session.getAttribute("logonUser");
		return HttpUtil.returnJson(isi.itemDel(HttpUtil.paramMap(req)));
	}
	
	@RequestMapping(value="/invenDel", method=RequestMethod.POST)
	public ModelAndView invenDel(HttpServletRequest req, HttpSession session) {
//		HashMap<String, Object> user = (HashMap<String, Object>) session.getAttribute("logonUser");
		return HttpUtil.returnJson(isi.invenDel(HttpUtil.paramMap(req)));
	}
	
	@RequestMapping(value="/itemPrice", method=RequestMethod.POST)
	public ModelAndView itemPrice(HttpServletRequest req, HttpSession session) {
//		HashMap<String, Object> user = (HashMap<String, Object>) session.getAttribute("logonUser");
		return HttpUtil.returnJson(isi.itemPrice(HttpUtil.paramMap(req)));
	}
	
	@RequestMapping(value="/invenPrice", method=RequestMethod.POST)
	public ModelAndView invenPrice(HttpServletRequest req, HttpSession session) {
//		HashMap<String, Object> user = (HashMap<String, Object>) session.getAttribute("logonUser");
		return HttpUtil.returnJson(isi.invenPrice(HttpUtil.paramMap(req)));
	}
	
	@RequestMapping(value="/invenReserv", method=RequestMethod.POST)
	public ModelAndView invenReserv(HttpServletRequest req, HttpSession session) {
//		HashMap<String, Object> user = (HashMap<String, Object>) session.getAttribute("logonUser");
		return HttpUtil.returnJson(isi.invenReserv(HttpUtil.paramMap(req)));
	}
	
	@RequestMapping(value="/itemManage", method=RequestMethod.POST)
	public ModelAndView itemManage(HttpServletRequest req, HttpSession session) {
//		HashMap<String, Object> user = (HashMap<String, Object>) session.getAttribute("logonUser");
		return HttpUtil.returnJson(isi.itemManage(HttpUtil.paramMap(req)));
	}
	
	@RequestMapping(value="/cateList", method=RequestMethod.POST)
	public ModelAndView cateList(HttpServletRequest req, HttpSession session) {
//		HashMap<String, Object> user = (HashMap<String, Object>) session.getAttribute("logonUser");
		return HttpUtil.returnJson(isi.cateList(HttpUtil.paramMap(req)));
	}

	@RequestMapping(value="/itemincate", method=RequestMethod.POST)
	public ModelAndView itemincate(HttpServletRequest req, HttpSession session) {
//		HashMap<String, Object> user = (HashMap<String, Object>) session.getAttribute("logonUser");
		return HttpUtil.returnJson(isi.itemincate(HttpUtil.paramMap(req)));
	}
	
	@RequestMapping(value="/chkItem", method=RequestMethod.POST)
	public ModelAndView chkItem(HttpServletRequest req, HttpSession session) {
//		HashMap<String, Object> user = (HashMap<String, Object>) session.getAttribute("logonUser");
		return HttpUtil.returnJson(isi.chkItem(HttpUtil.paramMap(req)));
	}
	
	@RequestMapping(value="/itemSearch", method=RequestMethod.POST)
	public ModelAndView itemSearch(HttpServletRequest req, HttpSession session) {
//		HashMap<String, Object> user = (HashMap<String, Object>) session.getAttribute("logonUser");
		return HttpUtil.returnJson(isi.itemSearch(HttpUtil.paramMap(req)));
	}

	@RequestMapping(value="/forCreate", method=RequestMethod.POST)
	public ModelAndView forCreate(HttpServletRequest req, HttpSession session) {
//		HashMap<String, Object> user = (HashMap<String, Object>) session.getAttribute("logonUser");
		return HttpUtil.returnJson(isi.forCreate(HttpUtil.paramMap(req)));
	}
	
}
