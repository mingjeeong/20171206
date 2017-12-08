package com.remp.work.model.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.remp.work.model.dao.AssetsDao;
import com.remp.work.model.dao.ItemsDao;
import com.remp.work.model.dto.Item;

import com.remp.work.model.dto.Product;

@Service("assetService")
public class AssetServiceImpl implements AssetService {
	@Autowired
	private AssetsDao assetsDao;
	
	public List<Map<String, String>> getInputRequest(String assetState){
		return assetsDao.selectInputRequest(assetState);
	}
	
	public int setInputState(String inputId, String assetState){
		return assetsDao.updateInputState(inputId, assetState);
	}
	
	public List<Map<String,String>> searchInputRequest(String assetState, String productName){
		return assetsDao.selectInputRequest(assetState, productName);
	}
	
	public List<Map<String, String>> getInput(String assetState){
		return assetsDao.selectInputList(assetState);
	}
	
	public List<Map<String,String>> searchInput(String assetState, String productName){
		return assetsDao.selectInputSearch(assetState, productName);
	}
	
	public ArrayList<Product> getRepairList(){
		ArrayList<Product> list = assetsDao.selectRepairList();
		for(int i = 0 ; i < list.size() ; i++) {
			switch (list.get(i).getState()) {
			case "wa_check":
				list.get(i).setState("점검대기");
				break;
			case "wa_product":
				list.get(i).setState("내부수리완료");
				break;
			case "wa_repair":
				list.get(i).setState("수리대기");
				break;
			case "re_exoutput":
				list.get(i).setState("외부수리");
				break;
			case "re_disuse":
				list.get(i).setState("수리불가능");
				break;
			default :
			}
		}
		return list;
	}
	
	public List<Map<String,String>> searchRepairList(String keyword, String selectName){
		List<Map<String,String>> list = assetsDao.selectRepairList(keyword,selectName);
		for (Map<String,String> map : list) {
			switch (map.get("state")) {
			case "wa_check":
				map.put("state", "점검대기");
				break;
			case "wa_product":
				map.put("state", "내부수리완료");
				break;
			case "wa_repair":
				map.put("state", "수리대기");
				break;
			case "re_exoutput":
				map.put("state", "외부수리");
				break;
			case "re_disuse":
				map.put("state", "수리불가능");
				break;
			default:
			}
		}
		return list;
	}
	
	public Map<String, String> getRepairForm(String productId, String productState){
		switch(productState) {
		case "점검대기":
			productState = "wa_check";
			break;
		case "수리대기":
			productState = "wa_repair";
			break;
		default :
		}
		return assetsDao.selectRepairForm(productId, productState);
	}
	
	public List<Map<String,String>> getRepairPartsList(String itemId){
		return assetsDao.selectRepairPartsList(itemId );
	}
	
	public int updateProductState(String productId, String repairSort) {
		return assetsDao.updateProductState(productId, repairSort);
	}
	
	public List<Map<String, String>> getAllParts() {
		return assetsDao.selectAllParts();
	}
	
	public List<Map<String, String>> getAllRepairResult(String engineerId) {
		return assetsDao.selectAllRepairResult(engineerId);
	}
	
	public int insertCustomerBuy(Map<String, String> rentalInfo) {
		return assetsDao.insertCustomerBuy(rentalInfo);
	}
	
	public List<Map<String, String>> getRepairResult(String type, String keyword){
		return assetsDao.selectPartsList(type,keyword);
	}
	
	public List<Map<String, String>> getRepairResult(String engineerId,String startDate, String endDate, String repairSort){
		return assetsDao.selectRepairResult(engineerId, startDate, endDate, repairSort);
	}
	
	public int insertOutput(Map<String, String> map) {
		return assetsDao.insertCustomerBuyOutput(map);
	}

	@Override
	public int addRepairResult(Map<String, Object> formInput, Map<String, String> partsInput) {
		return assetsDao.insertRepairResult(formInput, partsInput);
	}

	
	
}
