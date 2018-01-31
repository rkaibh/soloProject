package com.java.pos.service;

import java.util.HashMap;

public interface boardServiceInterface {

	public HashMap<String, Object> first(HashMap<String, Object> param);
	public HashMap<String, Object> adminAdd(HashMap<String, Object> param);
	public HashMap<String, Object> boardList(HashMap<String, Object> param);
	public HashMap<String, Object> boardDetail(HashMap<String, Object> param);
	
}
