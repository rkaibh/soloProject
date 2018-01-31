package com.java.pos.service;

import java.util.HashMap;

public interface itemServiceInterface {

	public HashMap<String, Object> addItem(HashMap<String, Object> param);
	public HashMap<String, Object> addInven(HashMap<String, Object> param);
	public HashMap<String, Object> itemList(HashMap<String, Object> param);
	public HashMap<String, Object> invenList(HashMap<String, Object> param);
	public HashMap<String, Object> itemDel(HashMap<String, Object> param);
	public HashMap<String, Object> invenDel(HashMap<String, Object> param);
	public HashMap<String, Object> invenPrice(HashMap<String, Object> param);
	public HashMap<String, Object> itemPrice(HashMap<String, Object> param);
	public HashMap<String, Object> invenReserv(HashMap<String, Object> param);
	public HashMap<String, Object> itemManage(HashMap<String, Object> param);
	public HashMap<String, Object> cateList(HashMap<String, Object> param);
	public HashMap<String, Object> itemincate(HashMap<String, Object> param);
	public HashMap<String, Object> chkItem(HashMap<String, Object> param);
	public HashMap<String, Object> itemSearch(HashMap<String, Object> param);
	public HashMap<String, Object> forCreate(HashMap<String, Object> param);
	
	
}