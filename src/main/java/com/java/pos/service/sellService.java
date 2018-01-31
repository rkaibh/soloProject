package com.java.pos.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.pos.dao.DaoBean;
import com.java.pos.daobean.DaoInterface;

@Service
public class sellService implements sellServiceInterface {

	@Autowired
	DaoInterface di;
	
	private final String ns = "sell";
	private HashMap<String, Object> result;
	private DaoBean bean;

	@Override
	public HashMap<String, Object> addsell1(HashMap<String, Object> param) {
		bean = new DaoBean("Insert", ns + ".addsell1", param);
		result = new HashMap<String, Object>();
		result.put("stat", di.dao(bean));
		return result;
	}

	@Override
	public HashMap<String, Object> addsell2(HashMap<String, Object> param) {
		bean = new DaoBean("Insert", ns + ".addSell2", param);
		result = new HashMap<String, Object>();
		result.put("stat", di.dao(bean));
		return result;
	}

	@Override
	public HashMap<String, Object> sellDetail1(HashMap<String, Object> param) {
		bean = new DaoBean("Insert", ns + ".sellDetail1", param);
		result = new HashMap<String, Object>();
		result.put("stat", di.dao(bean));
		return result;
	}

	@Override
	public HashMap<String, Object> sellDetail2(HashMap<String, Object> param) {
		bean = new DaoBean("Insert", ns + ".sellDetail2", param);
		result = new HashMap<String, Object>();
		result.put("stat", di.dao(bean));
		return result;
	}

	@Override
	public HashMap<String, Object> takeBack(HashMap<String, Object> param) {
		bean = new DaoBean("Update", ns + ".takeBack", param);
		result = new HashMap<String, Object>();
		result.put("stat", di.dao(bean));
		return result;
	}

	@Override
	public HashMap<String, Object> sellList(HashMap<String, Object> param) {
		bean = new DaoBean("SelectList", ns + ".sellList", param);
		result = new HashMap<String, Object>(); 
		result.put("list", di.dao(bean));
		if(result.get("list") == null) {
			HashMap<String, Object> map = new HashMap<String, Object>();
			map.put("sell_No", "");
			map.put("sell_Total", "");
			map.put("sell_Sub", "");
			map.put("sell_Result", "");
			map.put("sell_Way", "");
			result.put("list", map);
		}
		return result;
	}

	@Override
	public HashMap<String, Object> sellDetailList(HashMap<String, Object> param) {
		bean = new DaoBean("SelectList", ns + ".sellDetailList", param);
		result = new HashMap<String, Object>(); 
		result.put("list", di.dao(bean));
		return result;
	}

	@Override
	public HashMap<String, Object> forSellOrder(HashMap<String, Object> param) {
		bean = new DaoBean("SelectList", ns + ".forSellOrder", param);
		result = new HashMap<String, Object>(); 
		result.put("list", di.dao(bean));
		return result;
	}

	@Override
	public HashMap<String, Object> sellforList(HashMap<String, Object> param) {
		bean = new DaoBean("SelectList", ns + ".sellforList", param);
		result = new HashMap<String, Object>(); 
		result.put("list", di.dao(bean));
		return result;
	}

	@Override
	public HashMap<String, Object> sellboard(HashMap<String, Object> param) {
		bean = new DaoBean("SelectOne", ns + ".sellboard", param);
		result = new HashMap<String, Object>();
		result.put("list", di.dao(bean)); 
		if(result.get("list") == null) {
			result.put("stat", 0);
		} else {
			result.put("stat", 1);
		}
		return result;
	}

	@SuppressWarnings("unchecked")
	@Override
	public HashMap<String, Object> Finish(HashMap<String, Object> param) {
		if(param.get("sell_Way").equals("card")) {
			if(param.get("sell_CardNum").equals("") || param.get("sell_Card").equals("")) {
				result.put("cardNull", 1);
				return result;
			}
		}
		result = new HashMap<String, Object>();
		HashMap<String, Object> forInsert = new HashMap<String, Object>();
		
		bean = new DaoBean("SelectList", ns + ".sellboard", param);
		List<HashMap<String, Object>> listChk = (ArrayList<HashMap<String, Object>>) di.dao(bean);
		
		HashMap<String, Object> forList = new HashMap<String, Object>();
		forList.put("sell_Way", param.get("sell_Way"));
		forList.put("sell_Card", param.get("sell_Card"));
		forList.put("sell_CardNum", param.get("sell_CardNum"));
		forList.put("sell_Sub", param.get("sell_Sub"));
		forList.put("sell_Sub", param.get("sell_Sub"));
		forList.put("order_No", param.get("order_No"));
		forList.put("user_ID", param.get("user_ID"));
		
		HashMap<String, Object> addMap = new HashMap<String, Object>();
		addMap.put("user_ID", param.get("user_ID"));
		addMap.put("order_No", param.get("order_No"));
		
//		bean = new DaoBean("SelectList", ns + ".sellList", forList);
//		List<HashMap<String, Object>> sellList = (ArrayList<HashMap<String, Object>>) di.dao(bean);
		
		bean = new DaoBean("SelectList", ns + ".sellList2", addMap);
		List<HashMap<String, Object>> sellListChk = (ArrayList<HashMap<String, Object>>) di.dao(bean);
		boolean listchk = true;
		if(sellListChk.size() == 0) {
			listchk = false;
		}else {
			listchk = true;
		}
		
		if(!listchk) {

			if(listChk.size() == 0) {
				bean = new DaoBean("Insert", ns + ".addsell1", addMap);
				forInsert.put("stat", di.dao(bean));
				result.put("add", 1);
				
				bean = new DaoBean("Insert", ns + ".sellDetail1", forList);
				result = new HashMap<String, Object>();
				result.put("sellListChk", di.dao(bean));

			} else {
				bean = new DaoBean("Insert", ns + ".addSell2", addMap);
				forInsert.put("stat", di.dao(bean));
				result.put("add", 2);
				
				bean = new DaoBean("Insert", ns + ".sellDetail1", forList);
				result.put("sellListChk", di.dao(bean));
			}
		} else if (listchk) {
			forList.put("sell_No", sellListChk.get(0).get("sell_No"));
			bean = new DaoBean("Insert", ns + ".sellDetail2", forList);
			result.put("sellListChk", di.dao(bean));
		}
		
		bean = new DaoBean("SelectList", ns + ".sellList2", addMap);
		List<HashMap<String, Object>> sellListChk1 = (ArrayList<HashMap<String, Object>>) di.dao(bean);
		
		boolean soldChk = true;
		for(int i=0; i<sellListChk1.size(); i++) {
			if(sellListChk1.get(i).get("sell_Result").equals(0)) {
				bean = new DaoBean("Update", ns + ".Finish", forList);
				result.put("sold", di.dao(bean));
				soldChk = false;
				break;
			}
		}
		
		if(!soldChk) {
			bean = new DaoBean("SelectList", ns + ".forSold", addMap);
			List<HashMap<String, Object>> sold = (ArrayList<HashMap<String, Object>>) di.dao(bean);
			for(int i=0; i<sold.size(); i++) {
				HashMap<String, Object> chan = new HashMap<String, Object>();
				chan.put("user_ID", sold.get(i).get("user_ID"));
				chan.put("item_No", sold.get(i).get("item_No"));
				chan.put("order_No", sold.get(i).get("order_No"));
				bean = new DaoBean("Update", ns + ".change", chan);
				result.put("ivAmount", di.dao(bean)); 
			}
			
			HashMap<String, Object> fundUp = new HashMap<String, Object>();
			fundUp.put("user_ID", sold.get(0).get("user_ID"));
			fundUp.put("order_No", sold.get(0).get("order_No"));
			bean = new DaoBean("Update", ns + ".fundUp", fundUp);
			result.put("fundUp", di.dao(bean)); 
			
		}

		bean = new DaoBean("SelectOne", ns + ".forResult", addMap);
		result.put("result", di.dao(bean));
		
		return result;
	}
	
	@Override
	public HashMap<String, Object> forResult(HashMap<String, Object> param) {
		result = new HashMap<String, Object>();
		bean = new DaoBean("SelectOne", ns + ".forResult", param);
		result.put("result", di.dao(bean));
		return result;
	}

	@Override
	public HashMap<String, Object> sellList3(HashMap<String, Object> param) {
		result = new HashMap<String, Object>();
		bean = new DaoBean("SelectList", ns + ".sellList3", param);
		result.put("list", di.dao(bean));
		return result;
	}

}
