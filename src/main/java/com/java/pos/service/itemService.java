package com.java.pos.service;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.pos.dao.DaoBean;
import com.java.pos.daobean.DaoInterface;

@Service
public class itemService implements itemServiceInterface {
	
	@Autowired
	DaoInterface di;
	
	private final String ns = "item";
	private HashMap<String, Object> result;
	private DaoBean bean;

	@Override
	public HashMap<String, Object> addItem(HashMap<String, Object> param) {
		result = new HashMap<String, Object>();
		
		bean = new DaoBean("Insert", ns + ".addItem", param);
		result.put("ItemStat", di.dao(bean));
		
		bean = new DaoBean("Insert", ns + ".addInven", param);
		result.put("InvenStat", di.dao(bean));
		
		return result;
	}

	@Override
	public HashMap<String, Object> addInven(HashMap<String, Object> param) {
		bean = new DaoBean("Insert", ns + ".addInven", param);
		result = new HashMap<String, Object>();
		result.put("stat", di.dao(bean));
		return result;
	}

	@Override
	public HashMap<String, Object> itemList(HashMap<String, Object> param) {
		bean = new DaoBean("SelectList", ns + ".itemList", param);
		result = new HashMap<String, Object>();
		result.put("list", di.dao(bean));
		return result;
	}

	@Override
	public HashMap<String, Object> invenList(HashMap<String, Object> param) {
		bean = new DaoBean("SelectList", ns + ".invenList", param);
		result = new HashMap<String, Object>();
		result.put("list", di.dao(bean));
		return result;
	}

	@Override
	public HashMap<String, Object> itemDel(HashMap<String, Object> param) {
		bean = new DaoBean("Update", ns + ".itemDel", param);
		result = new HashMap<String, Object>();
		result.put("stat", di.dao(bean));
		return result;
	}

	@Override
	public HashMap<String, Object> invenDel(HashMap<String, Object> param) {
		bean = new DaoBean("Update", ns + ".invenDel", param);
		result = new HashMap<String, Object>();
		result.put("stat", di.dao(bean));
		return result;
	}
	
	@Override
	public HashMap<String, Object> invenPrice(HashMap<String, Object> param) {
		bean = new DaoBean("Update", ns + ".invenDel", param);
		result = new HashMap<String, Object>();
		result.put("stat", di.dao(bean));
		return result;
	}
	
	@Override
	public HashMap<String, Object> itemPrice(HashMap<String, Object> param) {
		bean = new DaoBean("Update", ns + ".invenDel", param);
		result = new HashMap<String, Object>();
		result.put("stat", di.dao(bean));
		return result;
	}
	
	@Override
	public HashMap<String, Object> invenReserv(HashMap<String, Object> param) {
		bean = new DaoBean("Update", ns + ".invenReserv", param);
		result = new HashMap<String, Object>();
		result.put("stat", di.dao(bean));
		return result;
	}

	@Override
	public HashMap<String, Object> itemManage(HashMap<String, Object> param) {
		bean = new DaoBean("SelectList", ns + ".itemManage", param);
		result = new HashMap<String, Object>();
		result.put("list", di.dao(bean));
		return result;
	}

	@Override
	public HashMap<String, Object> cateList(HashMap<String, Object> param) {
		bean = new DaoBean("SelectList", ns + ".cateList", param);
		result = new HashMap<String, Object>();
		result.put("list", di.dao(bean));
		return result;
	}

	@Override
	public HashMap<String, Object> itemincate(HashMap<String, Object> param) {
		bean = new DaoBean("SelectList", ns + ".itemincate", param);
		result = new HashMap<String, Object>();
		result.put("list", di.dao(bean));
		return result;
	}

	@SuppressWarnings("unchecked")
	@Override
	public HashMap<String, Object> chkItem(HashMap<String, Object> param) {
		bean = new DaoBean("SelectOne", ns + ".chkItem", param);
		result = (HashMap<String, Object>) di.dao(bean);
		return result;
	}

	@Override
	public HashMap<String, Object> itemSearch(HashMap<String, Object> param) {
		bean = new DaoBean("SelectOne", ns + ".itemSearch", param);
		result = new HashMap<String, Object>();
		result.put("item_Name", di.dao(bean));
		if(result.get("item_Name") == null) {
			result.put("stat", 0);
		} else {
			result.put("stat", 1);
		}
		return result;
	}

	@Override
	public HashMap<String, Object> forCreate(HashMap<String, Object> param) {
		bean = new DaoBean("SelectList", ns + ".forCreate", param);
		result = new HashMap<String, Object>();
		result.put("list", di.dao(bean));
		return result;
	}

}
