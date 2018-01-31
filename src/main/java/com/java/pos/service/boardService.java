package com.java.pos.service;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.pos.dao.DaoBean;
import com.java.pos.daobean.DaoInterface;

@Service
public class boardService implements boardServiceInterface {

	
	@Autowired
	DaoInterface di;
	
	private final String ns = "board";
	private HashMap<String, Object> result;
	private DaoBean bean;
	
	
	@Override
	public HashMap<String, Object> first(HashMap<String, Object> param) {
		bean = new DaoBean("Insert", ns + ".first", param);
		result = new HashMap<String, Object>();
		result.put("stat", di.dao(bean));
		return result;
	}

	@Override
	public HashMap<String, Object> adminAdd(HashMap<String, Object> param) {
		bean = new DaoBean("Insert", ns + ".adminAdd", param);
		result = new HashMap<String, Object>();
		result.put("stat", di.dao(bean));
		return result;
	}

	@Override
	public HashMap<String, Object> boardList(HashMap<String, Object> param) {
		bean = new DaoBean("SelectList", ns + ".boardList", param);
		result = new HashMap<String, Object>(); 
		result.put("list", di.dao(bean));
		return result;
	}

	@SuppressWarnings("unchecked")
	@Override
	public HashMap<String, Object> boardDetail(HashMap<String, Object> param) {
		bean = new DaoBean("SelectOne", ns + ".boardDetail", param);
		result = (HashMap<String, Object>) di.dao(bean);
		return result;
	}
	

}
