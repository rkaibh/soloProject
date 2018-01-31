package com.java.pos.service;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.pos.dao.DaoBean;
import com.java.pos.daobean.DaoInterface;

@Service
public class reservService implements reservServiceInterface {

	@Autowired
	DaoInterface di;
	
	private final String ns = "reserv";
	private HashMap<String, Object> result;
	private DaoBean bean;
	
	@Override
	public HashMap<String, Object> reservItem(HashMap<String, Object> param) {
		bean = new DaoBean("Insert", ns + ".reservItem", param);
		result = new HashMap<String, Object>();
		result.put("order", di.dao(bean));
		
		HashMap<String, Object> fundSub = new HashMap<String, Object>();
		fundSub.put("user_ID", param.get("user_ID"));
		bean = new DaoBean("Update", ns + ".fundSub", fundSub);
		result.put("fund", di.dao(bean));
		
		HashMap<String, Object> amountAdd = new HashMap<String, Object>();
		amountAdd.put("user_ID", param.get("user_ID"));
		amountAdd.put("item_No", param.get("item_No"));
		bean = new DaoBean("Update", ns + ".amountAdd", amountAdd);
		result.put("amount", di.dao(bean));

		return result;
	}

	@Override
	public HashMap<String, Object> reservList(HashMap<String, Object> param) {
		bean = new DaoBean("SelectList", ns + ".reservList", param);
		result = new HashMap<String, Object>();
		result.put("list", di.dao(bean));
		return result;
	}

}
