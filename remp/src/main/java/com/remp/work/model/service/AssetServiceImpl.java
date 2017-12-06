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
		return assetsDao.selectRepairList();
	}
	
	public List<Map<String,String>> searchRepairList(String keyword, String selectName){
		return assetsDao.selectRepairList(keyword,selectName);
	}
	
	public Map<String, String> getRepairForm(String productId){
		return assetsDao.selectRepairForm(productId);
	}
	
	public List<Map<String,String>> getRepairPartsList(String itemId){
		return assetsDao.selectRepairPartsList(itemId);
	}
	
	public int addRepairResult(String itName, String productId, String engineerId, String engineerName, String repairSort, String repairContent) {
		return assetsDao.insertRepairResult(itName, productId, engineerId, engineerName, repairSort, repairContent);
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
	
	public int insertCustomerBuy(String customerId, String itemId, String price, String startDate, String endDate, String post, String address, String addressDetail, String paymentMethod, String cardSort, String cardNum, String bankSort, String accountNum) {
		return assetsDao.insertCustomerBuy(customerId, itemId, price, startDate, endDate, post, address, addressDetail, 
				paymentMethod, cardSort, cardNum, bankSort, accountNum);
	}
	
	public List<Map<String, String>> getRepairResult(String type, String keyword){
		return assetsDao.selectPartsList(type,keyword);
	}
	
	public List<Map<String, String>> getRepairResult(String engineerId,String startDate, String endDate, String repairSort){
		return assetsDao.selectRepairResult(engineerId, startDate, endDate, repairSort);
	}
	
	public int insertOutput(Map<String, String> map) {
		return assetsDao.insertOutput(map);
	}

	
	
}
