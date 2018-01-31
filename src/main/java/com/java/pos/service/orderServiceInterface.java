package com.java.pos.service;

import java.util.HashMap;

public interface orderServiceInterface {
	
	public HashMap<String, Object> addOrder1(HashMap<String, Object> param);
	public HashMap<String, Object> addOrder2(HashMap<String, Object> param);
	public HashMap<String, Object> orderDetail(HashMap<String, Object> param);
	public HashMap<String, Object> orderDetail2(HashMap<String, Object> param);
	public HashMap<String, Object> orderList(HashMap<String, Object> param);
	public HashMap<String, Object> orderDetailList(HashMap<String, Object> param);
	public HashMap<String, Object> orderDetailDel(HashMap<String, Object> param);
	public HashMap<String, Object> orderDetailUp(HashMap<String, Object> param);
	public HashMap<String, Object> orderDetailList2(HashMap<String, Object> param);
	public HashMap<String, Object> forOrderList(HashMap<String, Object> param);
	public HashMap<String, Object> forOrderDetail(HashMap<String, Object> param);
	public HashMap<String, Object> listUpdating(HashMap<String, Object> param);
	public HashMap<String, Object> orderListforOrderWay(HashMap<String, Object> param);
	
}

