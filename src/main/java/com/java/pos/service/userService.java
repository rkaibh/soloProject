package com.java.pos.service;

import java.util.HashMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.java.pos.dao.DaoBean;
import com.java.pos.daobean.DaoInterface;

@Service
public class userService implements userServiceInterface {

	
	@Autowired
	DaoInterface di;
	
	private final String ns = "user";
	private HashMap<String, Object> result;
	private DaoBean bean;
	
	@Override
	public HashMap<String, Object> addAdmin(HashMap<String, Object> param) {
		bean = new DaoBean("Insert", ns + ".addAdmin", param);
		result = new HashMap<String, Object>();
		result.put("stat", di.dao(bean));
		return result;
	}

	@Override
	public HashMap<String, Object> addUser(HashMap<String, Object> param) {
		bean = new DaoBean("Insert", ns + ".addUser", param);
		result = new HashMap<String, Object>();
		result.put("stat", di.dao(bean));
		return result;
	}

	@Override
	public HashMap<String, Object> userList(HashMap<String, Object> param) {
		bean = new DaoBean("SelectList", ns + ".userList", param);
		result = new HashMap<String, Object>();
		result.put("list", di.dao(bean));
		if(result.get("list") != null) {
			result.put("stat", 1);
		} else {
			result.put("stat", 0);
		}
		return result;
	}

	@Override
	public HashMap<String, Object> userDel(HashMap<String, Object> param) {
		bean = new DaoBean("Update", ns + ".userDel", param);
		result = new HashMap<String, Object>();
		result.put("stat", di.dao(bean));
		return result;
	}

	@Override
	public HashMap<String, Object> logon(HashMap<String, Object> param) {
		bean = new DaoBean("SelectOne", ns + ".logon", param);
		result = new HashMap<String, Object>();
		result.put("logonUser", di.dao(bean));
		if(result.get("logonUser") == null) {
			result.put("search", 0);
		}
		return result;
	}
	
	@Override
	public HashMap<String, Object> IDList(HashMap<String, Object> param) {
		bean = new DaoBean("SelectOne", ns + ".IDList", param);
		result = new HashMap<String, Object>();
		result.put("search", di.dao(bean));
		return result;
	}
	
}
