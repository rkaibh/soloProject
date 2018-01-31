package com.java.pos.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.pos.dao.DaoBean;
import com.java.pos.daobean.DaoInterface;

@Service
public class orderService implements orderServiceInterface {

	@Autowired
	DaoInterface di;

	private final String ns = "order";
	private HashMap<String, Object> result;
	private DaoBean bean;

	@Override
	public HashMap<String, Object> addOrder1(HashMap<String, Object> param) {
		bean = new DaoBean("Insert", ns + ".addOrder1", param);
		result = new HashMap<String, Object>();
		result.put("stat", di.dao(bean));
		return result;
	}

	@Override
	public HashMap<String, Object> addOrder2(HashMap<String, Object> param) {
		bean = new DaoBean("Insert", ns + ".addOrder2", param);
		result = new HashMap<String, Object>();
		result.put("stat", di.dao(bean));
		return result;
	}

	@Override
	public HashMap<String, Object> orderDetail(HashMap<String, Object> param) {
		result = new HashMap<String, Object>();
		boolean temchk = false;
		
		if(param.get("item_Amount").equals("0")) {
			temchk = true;
		}
		
		if(temchk) {
			HashMap<String, Object> item = new HashMap<String, Object>();
			item.put("user_ID", param.get("user_ID"));
			item.put("order_No", param.get("order_No"));
			item.put("item_No", param.get("item_No"));
			item.put("order_Way", param.get("order_Way"));
			bean = new DaoBean("Update", ns + ".orderDetailDel", item);
			result.put("stat", di.dao(bean));
		} else{
			bean = new DaoBean("Insert", ns + ".orderDetail", param);
			result.put("stat", di.dao(bean));
			return result;
		}
		
		return result;
	}

	@Override
	public HashMap<String, Object> orderDetail2(HashMap<String, Object> param) {
		bean = new DaoBean("Insert", ns + ".orderDetail", param);
		result = new HashMap<String, Object>();
		result.put("stat", di.dao(bean));
		return result;
	}

	@Override
	public HashMap<String, Object> orderDetailList(HashMap<String, Object> param) {
		bean = new DaoBean("SelectList", ns + ".orderDetailList", param);
		result = new HashMap<String, Object>();
		result.put("list", di.dao(bean));
		return result;
	}

	@Override
	public HashMap<String, Object> orderDetailList2(HashMap<String, Object> param) {
		bean = new DaoBean("SelectList", ns + ".orderDetailList2", param);
		result = new HashMap<String, Object>();
		result.put("list", di.dao(bean));
		return result;
	}

	@Override
	public HashMap<String, Object> orderDetailDel(HashMap<String, Object> param) {
		bean = new DaoBean("Update", ns + ".orderDetailDel", param);
		result = new HashMap<String, Object>();
		result.put("stat", di.dao(bean));
		return result;
	}

	@Override
	public HashMap<String, Object> orderList(HashMap<String, Object> param) {
		bean = new DaoBean("SelectList", ns + ".orderList", param);
		result = new HashMap<String, Object>();
		result.put("list", di.dao(bean));
		return result;
	}

	@Override
	public HashMap<String, Object> orderDetailUp(HashMap<String, Object> param) {
		bean = new DaoBean("Update", ns + ".orderDetailUp", param);
		result = new HashMap<String, Object>();
		result.put("stat", di.dao(bean));
		return result;
	}

	@Override
	public HashMap<String, Object> forOrderList(HashMap<String, Object> param) {
		bean = new DaoBean("SelectList", ns + ".forOrderList", param);
		result = new HashMap<String, Object>();
		result.put("list", di.dao(bean));
		return result;
	}

	@SuppressWarnings("unchecked")
	@Override
	public HashMap<String, Object> forOrderDetail(HashMap<String, Object> param) {
		result = new HashMap<String, Object>();
		bean = new DaoBean("SelectList", ns + ".forOrderDetail", param);
		result.put("list", di.dao(bean));
		
		List<HashMap<String, Object>> List = (ArrayList<HashMap<String, Object>>) di.dao(bean);
		result.put("order_No", List.get(0).get("order_No"));
		result.put("order_Way", List.get(0).get("order_Way"));
		result.put("reg_date", List.get(0).get("reg_date"));
		return result;
	}

	@SuppressWarnings("unchecked")
	@Override
	public HashMap<String, Object> listUpdating(HashMap<String, Object> param) {
		bean = new DaoBean("SelectList", ns + ".orderDetailList2", param);
		List<HashMap<String, Object>> list =  (ArrayList<HashMap<String, Object>>) di.dao(bean);
		HashMap<String, Object> item = new HashMap<String, Object>();
		
		boolean upchk = true;
		
		if(param.get("item_Amount").equals(0)) {
			param.put("del_yn", "Y");
		}
		
		if(param.get("del_yn").equals("N")) {
			upchk = true;
		} else if (param.get("del_yn").equals("Y")) {
			upchk = false;
		}
		
		for(int i=0; i<list.size(); i++) {
			if(list.get(i).get("item_Name").equals(param.get("item_Name"))) {
				param.put("same", 1);
				break;
			} else {
				param.put("same", 0);
			}
		}
		if(upchk) {
					if(param.get("same").equals(1)) {
						item.put("user_ID", param.get("user_ID"));
						item.put("order_No", param.get("order_No"));
						item.put("item_No", param.get("item_No"));
						item.put("item_Name", param.get("item_Name"));
						item.put("item_Amount", param.get("item_Amount"));
						item.put("item_Price", param.get("item_Price"));
						item.put("order_Way", param.get("order_Way"));
						bean = new DaoBean("Update", ns + ".orderDetailUp", item);
						result = new HashMap<String, Object>();
						result.put("stat", di.dao(bean));
					} else if (param.get("same").equals(0)){
						item.put("user_ID", param.get("user_ID"));
						item.put("order_No", param.get("order_No"));
						item.put("item_No", param.get("item_No"));
						item.put("item_Name", param.get("item_Name"));
						item.put("item_Amount", param.get("item_Amount"));
						item.put("item_Price", param.get("item_Price"));
						item.put("order_Way", param.get("order_Way"));
						bean = new DaoBean("Insert", ns + ".orderDetail2", item);
						result = new HashMap<String, Object>();
						result.put("stat", di.dao(bean));
					}
			} else if(!upchk) {
				item.put("user_ID", param.get("user_ID"));
				item.put("order_No", param.get("order_No"));
				item.put("item_No", param.get("item_No"));
				item.put("order_Way", param.get("order_Way"));
				bean = new DaoBean("Update", ns + ".orderDetailDel", item);

				result = new HashMap<String, Object>();
				result.put("stat", di.dao(bean));
			}
		return result;
	}

	@SuppressWarnings("unchecked")
	@Override
	public HashMap<String, Object> orderListforOrderWay(HashMap<String, Object> param) {
		result = new HashMap<String, Object>();
		HashMap<String, Object> order_Way = new HashMap<String, Object>();
		order_Way.put("order_Way", param.get("order_Way"));
		order_Way.put("user_ID", param.get("user_ID"));
		
		bean = new DaoBean("SelectOne", ns + ".orderListforOrderWay", order_Way);
		HashMap<String, Object> Waychk = new HashMap<String, Object>();
		Waychk.put("Chk", di.dao(bean));
		
		if(Waychk.get("Chk") == null) {
			Waychk.put("sameTable", 0);

			bean = new DaoBean("SelectList", ns + ".orderList", param);
			List<HashMap<String, Object>> listChk = (ArrayList<HashMap<String, Object>>) di.dao(bean);
			if(listChk.size() == 0) {
				HashMap<String, Object> addOrder1 = new HashMap<String, Object>();
				bean = new DaoBean("Insert", ns + ".addOrder1", order_Way);
				addOrder1.put("addOrder1", di.dao(bean));
				result.put("add", 0);
			} else {
				HashMap<String, Object> addOrder2 = new HashMap<String, Object>();
				bean = new DaoBean("Insert", ns + ".addOrder2", order_Way);
				addOrder2.put("addOrder2", di.dao(bean));
				result.put("add", 1);
				result.put("order_No", listChk.size() + 1);
			}
			
		} else {
			Waychk.put("smaeTable", 1);
			result.put("add", 2);
		}
			
		return result;
	}
}