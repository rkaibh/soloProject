package com.java.pos.service;

import java.util.HashMap;

public interface userServiceInterface {

	public HashMap<String, Object> logon(HashMap<String, Object> param);
	public HashMap<String, Object> addAdmin(HashMap<String, Object> param);
	public HashMap<String, Object> addUser(HashMap<String, Object> param);
	public HashMap<String, Object> userList(HashMap<String, Object> param);
	public HashMap<String, Object> userDel(HashMap<String, Object> param);
	public HashMap<String, Object> IDList(HashMap<String, Object> param);
	
}
