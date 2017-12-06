package com.remp.work.model.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.remp.work.model.dto.Product;

public interface AssetService {
	
	public List<Map<String, String>> getInputRequest(String assetState);
	public int setInputState(String inputId, String assetState);
	public List<Map<String,String>> searchInputRequest(String assetState, String productName);
	public List<Map<String, String>> getInput(String assetState);
	public List<Map<String,String>> searchInput(String assetState, String productName);
	public ArrayList<Product> getRepairList();
	public List<Map<String,String>> searchRepairList(String keyword, String selectName);
	public Map<String, String> getRepairForm(String productId);
	public List<Map<String,String>> getRepairPartsList(String itemId);
	public int addRepairResult(String itName, String productId, String engineerId, String engineerName, String repairSort, String repairContent);
	public int updateProductState(String productId, String repairSort);
	public List<Map<String, String>> getAllParts();
	public List<Map<String, String>> getAllRepairResult(String id);
	public int insertCustomerBuy(String customerId, String itemId, String price, String startDate, String endDate, String post, String address, String addressDetail, String paymentMethod, String cardSort, String cardNum, String bankSort, String accountNum) ;
	public int insertOutput(Map<String, String> map); 
	public List<Map<String, String>> getRepairResult(String type, String keyword);
	public List<Map<String, String>> getRepairResult(String engineerId,String startDate, String endDate, String repairSort);
	
}
