package com.java.pos.service;

import java.util.HashMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.java.pos.dao.DaoBean;
import com.java.pos.daobean.DaoInterface;

@Service
public class accountService implements accountServiceInterface {


	@Autowired
	DaoInterface di;
	
	private final String ns = "account";
	private HashMap<String, Object> result;
	private DaoBean bean;
	
	@Override
	public HashMap<String, Object> daySert(HashMap<String, Object> param) {
		result = new HashMap<String, Object>();

		System.out.println("param : " + param);
		bean = new DaoBean("SelectOne", ns + ".daySert", param);
		result.put("daySert", di.dao(bean));
		if(result.get("daySert") == null) {
			result.put("daySert", "매출 정보가 없습니다.");
		}
		
		bean = new DaoBean("SelectOne", ns + ".weekSert", param);
		result.put("weekSert", di.dao(bean));
		if(result.get("weekSert") == null) {
			result.put("weekSert", "매출 정보가 없습니다.");
		}
		
		bean = new DaoBean("SelectOne", ns + ".monthSert", param);
		result.put("monthSert", di.dao(bean));
		if(result.get("monthSert") == null) {
			result.put("monthSert", "매출 정보가 없습니다.");
		}
		
		return result;
	}

	@Override
	public HashMap<String, Object> itemSert(HashMap<String, Object> param) {
		result = new HashMap<String, Object>();

		bean = new DaoBean("SelectOne", ns + ".itemDaySert", param);
		result.put("itemDaySert", di.dao(bean));
		if(result.get("itemDaySert") == null) {
			result.put("itemDaySert", "매출 정보가 없습니다.");
		}
		
		bean = new DaoBean("SelectOne", ns + ".itemWeekSert", param);
		result.put("itemWeekSert", di.dao(bean));
		if(result.get("itemWeekSert") == null) {
			result.put("itemWeekSert", "매출 정보가 없습니다.");
		}
		
		bean = new DaoBean("SelectOne", ns + ".itemMonthSert", param);
		result.put("itemMonthSert", di.dao(bean));
		if(result.get("itemMonthSert") == null) {
			result.put("itemMonthSert", "매출 정보가 없습니다.");
		}
		
		return result;
	}

}
