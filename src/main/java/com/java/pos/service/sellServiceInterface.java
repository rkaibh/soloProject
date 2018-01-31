package com.java.pos.service;

import java.util.HashMap;

public interface sellServiceInterface {

	public HashMap<String, Object> addsell1(HashMap<String, Object> param);
	public HashMap<String, Object> addsell2(HashMap<String, Object> param);
	public HashMap<String, Object> sellDetail1(HashMap<String, Object> param);
	public HashMap<String, Object> sellDetail2(HashMap<String, Object> param);
	public HashMap<String, Object> takeBack(HashMap<String, Object> param);
	public HashMap<String, Object> sellList(HashMap<String, Object> param);
	public HashMap<String, Object> sellDetailList(HashMap<String, Object> param);
	public HashMap<String, Object> forSellOrder(HashMap<String, Object> param);
	public HashMap<String, Object> sellforList(HashMap<String, Object> param);
	public HashMap<String, Object> sellboard(HashMap<String, Object> param);
	public HashMap<String, Object> Finish(HashMap<String, Object> param);
	public HashMap<String, Object> forResult(HashMap<String, Object> param);
	public HashMap<String, Object> sellList3(HashMap<String, Object> param);
	
}
