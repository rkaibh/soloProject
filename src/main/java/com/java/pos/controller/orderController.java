package com.java.pos.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.java.pos.service.orderServiceInterface;
import com.java.pos.util.HttpUtil;

@Controller
public class orderController {

	@Autowired
	orderServiceInterface osi;
	
	
	@RequestMapping(value="/addOrder1", method=RequestMethod.POST)
	public ModelAndView addOrder(HttpServletRequest req, HttpSession session) {
//		HashMap<String, Object> user = (HashMap<String, Object>) session.getAttribute("logonUser");
		return HttpUtil.returnJson(osi.addOrder1(HttpUtil.paramMap(req)));
	}
	
	@RequestMapping(value="/addOrder2", method=RequestMethod.POST)
	public ModelAndView addOrder2(HttpServletRequest req, HttpSession session) {
//		HashMap<String, Object> user = (HashMap<String, Object>) session.getAttribute("logonUser");
		return HttpUtil.returnJson(osi.addOrder2(HttpUtil.paramMap(req)));
	}
	
	@RequestMapping(value="/orderDetail", method=RequestMethod.POST)
	public ModelAndView orderDetail(HttpServletRequest req, HttpSession session) {
//		HashMap<String, Object> user = (HashMap<String, Object>) session.getAttribute("logonUser");
//		if(req == null) {
//			return HttpUtil.returnJson(osi.orderDetail(user));
//		}
		return HttpUtil.returnJson(osi.orderDetail(HttpUtil.paramMap(req)));
	}
	
	@RequestMapping(value="/orderDetail2", method=RequestMethod.POST)
	public ModelAndView orderDetail2(HttpServletRequest req, HttpSession session) {
//		HashMap<String, Object> user = (HashMap<String, Object>) session.getAttribute("logonUser");
		return HttpUtil.returnJson(osi.orderDetail2(HttpUtil.paramMap(req)));
	}
	
	@RequestMapping(value="/orderDetailList", method=RequestMethod.POST)
	public ModelAndView orderDetailList(HttpServletRequest req, HttpSession session) {
//		HashMap<String, Object> user = (HashMap<String, Object>) session.getAttribute("logonUser");
		return HttpUtil.returnJson(osi.orderDetailList(HttpUtil.paramMap(req)));
	}
	
	@RequestMapping(value="/orderDetailList2", method=RequestMethod.POST)
	public ModelAndView orderDetailList2(HttpServletRequest req, HttpSession session) {
//		HashMap<String, Object> user = (HashMap<String, Object>) session.getAttribute("logonUser");
		return HttpUtil.returnJson(osi.orderDetailList2(HttpUtil.paramMap(req)));
	}
	
	@RequestMapping(value="/orderDetailDel", method=RequestMethod.POST)
	public ModelAndView orderDetailDel(HttpServletRequest req, HttpSession session) {
//		HashMap<String, Object> user = (HashMap<String, Object>) session.getAttribute("logonUser");
		return HttpUtil.returnJson(osi.orderDetailDel(HttpUtil.paramMap(req)));
	}
	
	@RequestMapping(value="/orderList", method=RequestMethod.POST)
	public ModelAndView orderList(HttpServletRequest req, HttpSession session) {
//		HashMap<String, Object> user = (HashMap<String, Object>) session.getAttribute("logonUser");
		return HttpUtil.returnJson(osi.orderList(HttpUtil.paramMap(req)));
	}
	
	@RequestMapping(value="/orderDetailUp", method=RequestMethod.POST)
	public ModelAndView orderDetailUp(HttpServletRequest req, HttpSession session) {
//		HashMap<String, Object> user = (HashMap<String, Object>) session.getAttribute("logonUser");
		return HttpUtil.returnJson(osi.orderDetailUp(HttpUtil.paramMap(req)));
	}
	
	@RequestMapping(value="/forOrderList", method=RequestMethod.POST)
	public ModelAndView forOrderList(HttpServletRequest req, HttpSession session) {
//		HashMap<String, Object> user = (HashMap<String, Object>) session.getAttribute("logonUser");
		return HttpUtil.returnJson(osi.forOrderList(HttpUtil.paramMap(req)));
	}
	
	@RequestMapping(value="/forOrderDetail", method=RequestMethod.POST)
	public ModelAndView forOrderDetail(HttpServletRequest req, HttpSession session) {
//		HashMap<String, Object> user = (HashMap<String, Object>) session.getAttribute("logonUser");
		return HttpUtil.returnJson(osi.forOrderDetail(HttpUtil.paramMap(req)));
	}
	
	@RequestMapping(value="/listUpdating", method=RequestMethod.POST)
	public ModelAndView listUpdating(HttpServletRequest req, HttpSession session) {
//		HashMap<String, Object> user = (HashMap<String, Object>) session.getAttribute("logonUser");
		return HttpUtil.returnJson(osi.listUpdating(HttpUtil.paramMap(req)));
	}
	
	@RequestMapping(value="/orderListforOrderWay", method=RequestMethod.POST)
	public ModelAndView orderListforOrderWay(HttpServletRequest req, HttpSession session) {
//		HashMap<String, Object> user = (HashMap<String, Object>) session.getAttribute("logonUser");
		return HttpUtil.returnJson(osi.orderListforOrderWay(HttpUtil.paramMap(req)));
	}
	
	
}
