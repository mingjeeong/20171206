package com.remp.work.control;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.remp.work.model.dto.Item;
import com.remp.work.model.dto.Product;
import com.remp.work.util.RempUtility;

@Controller
public class DefaultControl extends ControllerAdapter {
	/**
	 * 비밀번호 변경
	 * @param session
	 * @param presentPw
	 * @param newPw
	 * @return
	 */
	@RequestMapping("changepw.do")
	public ModelAndView setPassword(HttpSession session, String presentPw, String newPw) {
		ModelAndView mv = new ModelAndView();
		String id = (String) session.getAttribute("id");
		boolean result = customerService.setPassword(id, presentPw, newPw);
		if(result) {
			mv.setViewName("home");
		}
		return mv;
	}
	
	/**
	 * 비밀번호 변경 페이지로 가기
	 */
	@RequestMapping("gochangepw.do")
	public ModelAndView goSetPassword() {
		return getPlainPage("changepw.jsp");
	}
	
	/**
	 * 렌탈 메인 페이지로 가기
	 * @return
	 */
	@RequestMapping("gorentalmain.do")
	public ModelAndView goRentalMain() {
		return getPlainPage("rentalmain.jsp");
	}
	/**
	 * 렌탈 메인
	 * @return
	 */
	@RequestMapping("rentalmain.do")
	public ModelAndView rentalMain() {
		ModelAndView mv = getPlainPage("rentalmain.jsp");
		ArrayList<Item> list = rentalService.getItemList();
		if(list != null) {
			mv.addObject("list", list);
		}
		return mv;
	}
	
	/**
	 * 렌탈 제품 검색하기
	 * @param sb_search
	 * @param item
	 * @return
	 */
	@RequestMapping("searchitem.do")
	public ModelAndView getSearchList(String sb_search, String item) {
		ModelAndView mv = getPlainPage("rentalmain.jsp");
		ArrayList<Item> list = rentalService.getSearchList(sb_search, item);
		if((item.trim().length() == 0) || (item.equals("")) || (list.size() == 0)) {
			StringBuffer message = new  StringBuffer();
			message.append("'").append(item);
			message.append("'에 대한 검색 결과가 없습니다.");
			mv.addObject("message", message);
		}
		else if((list != null) && (!list.isEmpty())) {
			StringBuffer message = new  StringBuffer();
			message.append("'").append(item);
			message.append("'에 대한 검색 결과가 ").append(list.size());
			message.append("건이 있습니다.");
			mv.addObject("list", list);
			mv.addObject("message", message);
			
		}
		return mv;
	}
	
	/**
	 * 렌탈 제품 상세보기로 가기
	 * @return
	 */
	@RequestMapping("gorentaldetail.do")
	public ModelAndView goRentalDetail() {
		return getPlainPage("rentaldetail.jsp");
		
	}
	/**
	 *  렌탈 제품 상세보기
	 * @param id
	 * @return
	 */
	@RequestMapping("rentaldetail.do")
	public ModelAndView rentalDetail(@RequestParam String itemId) {
		ModelAndView mv = getPlainPage("rentaldetail.jsp");
		Item dto = rentalService.getItem(itemId);
		if(dto != null) {
			mv.addObject("dto", dto);
			RempUtility ru = new RempUtility();
			mv.addObject("price", ru.numMoney(dto.getPrice()));
		}
		return mv;
	}
	/**
	 * 렌탈 하기
	 * @param itemId
	 * @return
	 */
	@RequestMapping("rental.do")
	public ModelAndView rental(@RequestParam String itemId) {
		ModelAndView mv = getPlainPage("rental.jsp");;
		Item dto = rentalService.getItem(itemId);
		if(dto != null) {
			mv.addObject("dto", dto);
			RempUtility ru = new RempUtility();
			mv.addObject("price", ru.numMoney(dto.getPrice()));
		}
		return mv;
	}
	
	@Override
	public ModelAndView home() {
		return getHeadDetailPage("head.jsp", "detail.jsp");
	}
	/**
	 * 요청자산 조회로 이동
	 * @return
	 */
	@RequestMapping("goinputrequest.do")
	public ModelAndView goInputRequest() {
		return getHeadDetailPage("searchinputrequesthead.jsp", "searchinputrequestdetail.jsp");
	}
	/**
	 * 요청자산 조회
	 * @param jsonObjectString
	 * @return
	 */
	@RequestMapping(value="getinputrequest.do", method=RequestMethod.POST)
	public @ResponseBody List<Map<String, String>> getInputRequeat(@RequestBody String jsonObjectString) {
		return assetService.getInputRequest(jsonToMap(jsonObjectString).get("inputState"));
	}
	/**
	 * json타입을 map으로 형변환
	 * @param jsonObjectString
	 * @return
	 */
	public Map<String, String> jsonToMap(String jsonObjectString) {
		Map<String, String> returnValue = new HashMap<String, String>();
		if(jsonObjectString.trim().length() <= 3) {
			returnValue.put("errMsg", "요청이 올바르지 않습니다.");
		}
		String temp[] = jsonObjectString.replace("{", "").replace("}", "").replace("\"","").split(",");
		for (int i = 0; i < temp.length; i++) {
			String tempItem[] = temp[i].trim().split(":");
			if (tempItem.length >= 1) {
				if(returnValue.get(tempItem[0]) != null) { //name 값 중복  ex)checkbox
					returnValue.put(tempItem[0].trim(), returnValue.get(tempItem[0].trim()) + "," + tempItem[1].trim());
				} else if(tempItem.length > 2) { //시간
					returnValue.put(tempItem[0].trim(), tempItem[1].trim()+":"+tempItem[2].trim());
				} else if(tempItem.length == 1) { //value = 빈 값일경우
					returnValue.put(tempItem[0].trim(), "");
				} else {
					returnValue.put(tempItem[0].trim(), tempItem[1].trim());
				}
			}
		}
		return returnValue;
	}
	/**
	 * 요청자산 등록
	 * @param jsonObjectString
	 * @return
	 */
	@RequestMapping(value="setinputstate.do", method=RequestMethod.POST)
	public  @ResponseBody Map<String, String> setInputState(@RequestBody String jsonObjectString) {
		List<Map<String, String>> list = new ArrayList<>();
		Map<String, String> map = new HashMap<>();
		int result = assetService.setInputState(jsonToMap(jsonObjectString).get("id"),jsonToMap(jsonObjectString).get("state"));
		if(result == 1) {
			map.put("result", "성공적으로 입고 처리되었습니다.");
		}else {
			map.put("result", "입고처리를 실패하였습니다.");
		}
		return map;
	}
	/**
	 * 요청자산 검색 조회
	 * @param jsonObjectString
	 * @return
	 */
	@RequestMapping(value="searchinputrequest.do", method=RequestMethod.POST) 
	public @ResponseBody List<Map<String, String>> searchInputRequest(@RequestBody String jsonObjectString) {
		return assetService.searchInputRequest(jsonToMap(jsonObjectString).get("state"),jsonToMap(jsonObjectString).get("name").trim());
	}
	/**
	 * 입고조회로 이동
	 * @return
	 */
	@RequestMapping("goinput.do")
	public ModelAndView goInput() {
		return getHeadDetailPage("searchinputhead.jsp", "searchinputdetail.jsp");
	}
	/**
	 * 입고조회
	 * @param jsonObjectString
	 * @return
	 */
	@RequestMapping("getinput.do") 
	public @ResponseBody List<Map<String, String>> getInput(@RequestBody String jsonObjectString) {
		System.out.println(jsonToMap(jsonObjectString).get("state"));
		List<Map<String, String>> result = assetService.getInput(jsonToMap(jsonObjectString).get("state"));
		System.out.println(result);
		return result;
	}
	/**
	 * 
	 * @param jsonObjectString
	 * @return
	 */
	@RequestMapping(value="searchinput.do", method=RequestMethod.POST) 
	public @ResponseBody List<Map<String, String>> searchInput(@RequestBody String jsonObjectString) {
		System.out.println(jsonObjectString);
		return assetService.searchInput(jsonToMap(jsonObjectString).get("state"),jsonToMap(jsonObjectString).get("name").trim());
	}
	/**
	 * 내부수리기사 점검등록 페이지로 이동
	 * @return
	 */
	@RequestMapping("gorepairlist.do")
	public ModelAndView goRepairList(HttpSession session) {
		ModelAndView mv = getHeadDetailPage("addrepairresulthead.jsp", "addrepairresultdetail.jsp");
		ArrayList<Product> list = assetService.getRepairList();
		if(list != null) {
			mv.addObject("list", list);
		}
		//String id = session.getId();
		//String name = session.getName();
		mv.addObject("id", "1234");//세션이라고 가정
		mv.addObject("name", "이민정");//세션이라고 가정
		return mv;
	}
	/**
	 * 내부수리기사 점검대기 데이터 검색조회
	 * @param jsonObjectString
	 * @return
	 */
	@RequestMapping(value="getrepairlist.do", method=RequestMethod.POST)
	public @ResponseBody List<Map<String, String>> getRepairList(@RequestBody String jsonObjectString) {
		return assetService.searchRepairList(jsonToMap(jsonObjectString).get("keyword"), jsonToMap(jsonObjectString).get("select"));
	}
	/**
	 * 헤드에서 항목 클릭하면 디테일영역에 데이터 가져오기
	 * @param jsonObjectString
	 * @return
	 */
	@RequestMapping(value="getrepairform.do", method=RequestMethod.POST)
	public @ResponseBody Map<String, String> getRepairForm(@RequestBody String jsonObjectString ) {
		return assetService.getRepairForm(jsonToMap(jsonObjectString).get("id"));
	}
	/**
	 * 내부수리기사 점검내역 등록할 때 내부수리시 수리하는 품목에 맞는 부품리스트 보여주기
	 * @param jsonObjectString
	 * @return
	 */
	@RequestMapping(value="getpartslist.do", method=RequestMethod.POST)
	public @ResponseBody List<Map<String, String>> getPartsList(@RequestBody String jsonObjectString ) {
		return assetService.getRepairPartsList(jsonToMap(jsonObjectString).get("id"));
	}
	/**
	 * 내부수리기사 점검내역 등록
	 * @param jsonObjectString
	 * @return
	 */
	@RequestMapping(value="addrepairresult.do", method=RequestMethod.POST)
	public  @ResponseBody Map<String, String> addRepairResult(@RequestBody String jsonObjectString) {
		Map<String, String> map = jsonToMap(jsonObjectString);
		int result = assetService.addRepairResult(jsonToMap(jsonObjectString).get("itemName"),jsonToMap(jsonObjectString).get("productId"),
				jsonToMap(jsonObjectString).get("engineerId"),jsonToMap(jsonObjectString).get("engineerName"),
				jsonToMap(jsonObjectString).get("repairSort"),jsonToMap(jsonObjectString).get("repairContent"));
		if(result == 1) {
			int upadateProduct = assetService.updateProductState(jsonToMap(jsonObjectString).get("productId"),jsonToMap(jsonObjectString).get("repairSort"));
			map.put("result", "성공적으로 점검내역이 등록되었습니다.");
		}else {
			map.put("result", "점검내역 등록을 실패하였습니다.");
		}
		return map;
	}
	/**
	 * 부품조회 페이지로 이동
	 * @return
	 */
	@RequestMapping("gosearchparts.do")
	public ModelAndView goSearchPart() {
		return getPlainPage("searchparts.jsp");
	}
	/**
	 * 모든 부품 리스트 보여주기(부품조회 초기페이지의 데이터)
	 * @return
	 */
	@RequestMapping(value="getallpartslist.do", method=RequestMethod.POST) 
	public @ResponseBody List<Map<String, String>> getAllParts() {
		return assetService.getAllParts();
	}
	/**
	 * 내부수리기사 점검결과보기 페이지로 이동
	 * @return
	 */
	@RequestMapping("gorepairresult.do")
	public ModelAndView goRepairResult() {
		ModelAndView mv = getPlainPage("searchrepairresult.jsp");
		return mv;
	}
	/**
	 * 내부수리기사 모든 점검결과  보여주기 
	 * @param session
	 * @param jsonObjectString
	 * @return
	 */
	@RequestMapping(value="getallrepairresultlist.do", method=RequestMethod.POST) 
	public @ResponseBody List<Map<String, String>> getAllRepairResult(HttpSession session,@RequestBody String jsonObjectString) {
		String id = (String) session.getAttribute("id");
		return assetService.getAllRepairResult(id);
	}
	/**
	 * 렌탈 구매, 구매내역확인으로 이동
	 * @param session
	 * @param map
	 * @return
	 */
	@RequestMapping(value="rentalpayment.do", method=RequestMethod.POST) 
	public ModelAndView rentalPayment(HttpSession session, @RequestParam Map<String, String> map) {
		ModelAndView mv = getPlainPage("complitedpayment.jsp");
		String customerId = (String) session.getAttribute("id");//세션아이디 가져오기
		customerId = "user01";//하드코딩
		int buyResult = assetService.insertCustomerBuy(customerId,map.get("itemId"),map.get("price"),
		map.get("start"),map.get("end"),map.get("tb_post"),map.get("tb_addr"),map.get("tb_addD"),
		map.get("rb_payment"),map.get("sb_card"),map.get("cardNum"),map.get("sb_bank"),map.get("accountNum"));
		if(buyResult != 0) {
			map.put("tb_itNumber", "1");
			int outputResult = assetService.insertOutput(map); 
			mv.addObject("map", map);
			RempUtility ru = new RempUtility();
			mv.addObject("price", ru.numMoney(Integer.parseInt(map.get("price"))));
		}
		return mv;
	}
	/**
	 * 부속품 검색조회
	 * @param jsonObjectString
	 * @return
	 */
	@RequestMapping(value="getsearchpartslist.do", method=RequestMethod.POST) 
	public @ResponseBody List<Map<String, String>> getSearchPartsList(@RequestBody String jsonObjectString) {
		System.out.println(">>>>>>"+jsonObjectString);
		return assetService.getRepairResult(jsonToMap(jsonObjectString).get("searchType"),jsonToMap(jsonObjectString).get("searchKeyword"));
	}
	/**
	 * 수리기사 점검내역 결과 검색조회
	 * @param session
	 * @param jsonObjectString
	 * @return
	 */
	@RequestMapping(value="getrepairresultlist.do", method=RequestMethod.POST) 
	public @ResponseBody List<Map<String, String>> getRepairResult(HttpSession session,@RequestBody String jsonObjectString) {
		String id = (String) session.getAttribute("id");
		List<Map<String, String>> result = assetService.getRepairResult(id,jsonToMap(jsonObjectString).get("startDate"),jsonToMap(jsonObjectString).get("endDate"),jsonToMap(jsonObjectString).get("repairSort"));
		return result;
	}
	
	
}
