package com.remp.work.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.jdt.internal.compiler.parser.ParserBasicInformation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.env.SystemEnvironmentPropertySource;
import org.springframework.stereotype.Repository;

import com.remp.work.model.dto.Product;
import com.remp.work.util.RempUtility;
import com.sun.org.glassfish.external.statistics.annotations.Reset;

@Repository
public class AssetsDao {
	@Autowired
	@Qualifier("factory")
	private FactoryDao factory;
	
	/**
	 * 요청자산 조회
	 * @param assetState
	 * @return
	 */
	public List<Map<String, String>> selectInputRequest(String assetState){ 
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select IN_ID, IT_ID, to_char(IN_COUNT, '9,990') in_count, IN_STATE, to_char(IN_DAY,'yyyy-MM-dd hh24:mi') in_day, IN_DELIVERY from input where IN_STATE = ? order by in_day, IN_ID";
		List<Map<String, String>> list = new ArrayList<>();
		try {
			con = factory.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, assetState);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				Map<String,String> map = new HashMap<>();
				map.put("id", rs.getString("IN_ID"));
				map.put("name", rs.getString("IT_ID"));
				map.put("count", rs.getString("IN_COUNT"));
				map.put("state", rs.getString("IN_STATE"));
				map.put("date", rs.getString("IN_DAY"));
				map.put("delivery", rs.getString("IN_DELIVERY"));
				list.add(map);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				factory.close(con, pstmt, rs);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return list;
	}
	
	/**
	 * 입고요청 등록
	 * @param inputId
	 * @param assetState
	 * @return
	 */
	public int updateInputState(String inputId, String assetState){ 
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "";
		if(assetState.equals("re_ninput")) {
			sql = "update input set IN_STATE = 'wa_ninput', IN_FDAY = SYSTIMESTAMP, PR_ID = 'PR'||trim(to_char(SEQ_PR_ID.nextval,'0000000000')), IN_COMPLETE ='Y'  where IN_ID = ? ";
		}else if(assetState.equals("re_reinput")) {
			sql = "update input set IN_STATE = 'wa_check', IN_FDAY = SYSTIMESTAMP, IN_COMPLETE ='Y' where IN_ID = ?";
		}else if(assetState.equals("re_exinput")) {
			sql = "update input set IN_STATE = 'wa_policy', IN_FDAY = SYSTIMESTAMP, IN_COMPLETE ='Y' where IN_ID = ?";
		}
		try {
			con = factory.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, inputId);
			return pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				factory.close(con, pstmt, rs);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return 0;
	}
	
	/**
	 * 요청자산 검색 조회
	 * @param state
	 * @param name
	 * @return
	 */
	public List<Map<String, String>> selectInputRequest(String assetState, String productName){ 
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select i.in_id, i.it_id, i.in_count, to_char(i.in_day, 'yyyy-MM-dd') IN_DAY, i.in_delivery from (select in_id, in_id||' '||it_id||' '||in_count||' '||in_day||' '||in_delivery combination from input) c, input i where c.in_id = i.in_id and i.in_state = ? and regexp_like(c.combination, ?)";
		List<Map<String, String>> list = new ArrayList<>();
		
		try {
			con = factory.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, assetState);
			pstmt.setString(2, productName);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				Map<String, String> map = new HashMap<>();
				map.put("id", rs.getString("IN_ID"));
				map.put("name", rs.getString("IT_ID"));
				map.put("count", rs.getString("IN_COUNT"));
				map.put("date", rs.getString("IN_DAY"));
				map.put("delivery", rs.getString("IN_DELIVERY"));
				list.add(map);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				factory.close(con, pstmt, rs);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return list;
	}
	
	/**
	 * 입고조회
	 * @param assetState
	 * @return
	 */
	public List<Map<String, String>> selectInputList(String assetState){ 
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql ="select IN_ID, IT_ID, to_char(IN_COUNT, '9,990') in_count, IN_STATE, to_char(IN_FDAY,'yyyy-MM-dd hh24:mi') in_fday, IN_DELIVERY from input where IN_STATE =?";
		List<Map<String, String>> list = new ArrayList<>();
		try {
			con = factory.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, assetState);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				Map<String, String> map = new HashMap<>();
				map.put("id", rs.getString("IN_ID"));
				map.put("name", rs.getString("IT_ID"));
				map.put("count", rs.getString("IN_COUNT"));
				map.put("state", rs.getString("IN_STATE"));
				map.put("date", rs.getString("IN_FDAY"));
				map.put("delivery", rs.getString("IN_DELIVERY"));
				list.add(map);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				factory.close(con, pstmt, rs);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return list;
	}
	
	/**
	 * 입고 검색 조회
	 * @param assetState
	 * @param productName
	 * @return
	 */
	public List<Map<String, String>> selectInputSearch(String assetState, String productName){ 
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select i.in_id, i.it_id, i.in_count, to_char(i.in_day, 'yyyy-MM-dd hh24:mi') IN_DAY, i.in_delivery from (select in_id, in_id||' '||it_id||' '||in_count||' '||in_day||' '||in_delivery combination from input) c, input i where c.in_id = i.in_id and i.in_state = ? and regexp_like(c.combination, ?)";
		List<Map<String, String>> list = new ArrayList<>();
		
		try {
			con = factory.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, assetState);
			pstmt.setString(2, productName);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				Map<String, String> map = new HashMap<>();
				map.put("id", rs.getString("IN_ID"));
				map.put("name", rs.getString("IT_ID"));
				map.put("count", rs.getString("IN_COUNT"));
				map.put("date", rs.getString("IN_DAY"));
				map.put("delivery", rs.getString("IN_DELIVERY"));
				list.add(map);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				factory.close(con, pstmt, rs);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return list;
	}
	
	/**
	 * 점검대기 리스트 출력
	 * @return
	 */
	public ArrayList<Product> selectRepairList(){
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT PR_ID, BUY_ID, IT_ID, IT_NAME, PR_STATE, to_char(PR_FIRST_DAY,'yyyy-MM-dd') pr_first_day,"
				+ "to_char(PR_IN_DAY,'yyyy-MM-dd') pr_in_day, to_char(PR_OUT_DAY,'yyyy-MM-dd') pr_out_day,"
				+ "PR_LOCATION, PR_NEEDS, PR_OUT_TARGET ,PR_COUNT, PR_QR FROM PRODUCT WHERE PR_STATE ='wa_check' or PR_STATE='wa_repair' ORDER BY PR_IN_DAY ";
		ArrayList<Product> list = new ArrayList<>();
		try {
			con = factory.getConnection();
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			String id = null;
			String itName = null;
			String inDay = null;
			String state = null;
			String buyId = null;
			String itId = null;
			String firstDay = null;
			String outDay = null;
			String outTarget = null;
			String location = null;
			String needs = null;
			int count = 0;
			String qr = null;
			while(rs.next()) {
				id = rs.getString("PR_ID");
				itName = rs.getString("IT_NAME");
				inDay = rs.getString("PR_IN_DAY");
				state = rs.getString("PR_STATE");
				buyId =  rs.getString("BUY_ID");
				itId =  rs.getString("IT_ID");
				firstDay =  rs.getString("PR_FIRST_DAY");
				outDay =  rs.getString("PR_OUT_DAY");
				outTarget =  rs.getString("PR_OUT_TARGET");
				location =  rs.getString("PR_LOCATION");
				needs =  rs.getString("PR_NEEDS");
				count =  rs.getInt("PR_COUNT");
				qr =  rs.getString("PR_QR");
				list.add(new Product( id,  buyId,  itId,  itName,  firstDay,  inDay,  outDay,
						 outTarget,  location,  needs,  state,  count,  qr));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				factory.close(con, pstmt, rs);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return list;
	}
	
	/**
	 * 점검대기 검색
	 * @param keyword
	 * @param selectName
	 * @return
	 */
	public List<Map<String, String>> selectRepairList(String keyword, String selectName) { 
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "";
		List<Map<String, String>> list = new ArrayList<>();
		if(selectName.equals("자산ID")) {
			sql = "SELECT PR_ID, IT_ID, IT_NAME, PR_STATE, to_char(PR_IN_DAY,'yyyy-MM-dd hh24:mi') pr_in_day FROM PRODUCT WHERE PR_ID like ? and (PR_STATE='wa_check' or PR_STATE='wa_repair')";
		}else if(selectName.equals("품목명"))
			sql = "SELECT PR_ID, IT_ID, IT_NAME, PR_STATE, to_char(PR_IN_DAY,'yyyy-MM-dd hh24:mi') pr_in_day FROM PRODUCT WHERE IT_NAME like ? and (PR_STATE='wa_check' or PR_STATE='wa_repair')";
		try {
			con = factory.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, "%"+keyword+"%");
			rs = pstmt.executeQuery();
			while(rs.next()) {
				Map<String, String> map = new HashMap<>();
				map.put("id", rs.getString("PR_ID"));
				map.put("itemId", rs.getString("IT_ID"));
				map.put("itemName", rs.getString("IT_NAME"));
				map.put("state", rs.getString("PR_STATE"));
				map.put("date", rs.getString("PR_IN_DAY"));
				list.add(map);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				factory.close(con, pstmt, rs);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return list;
	}
	
	/**
	 * 점검헤드에서 디테일로 가져오기
	 * @param productId
	 * @return
	 */
	public Map<String, String> selectRepairForm(String productId, String productState) {
		Map<String, String> returnValue = new HashMap<>();
		StringBuilder tempSql = new StringBuilder();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String waitCheckSql = "select PR_ID, IT_ID, IT_NAME, to_char(sysdate,'yyyy-MM-dd hh24:mi') today from product where pr_id = ? ";//점검대기
		String waitRepairSql ="select b.IT_ID, a.IT_NAME, a.PR_ID, to_char(sysdate,'yyyy-MM-dd hh24:mi') today, a.RE_CONTENT from repair a, product b where b.pr_id = ? and b.pr_id = a.pr_id and RE_STATE = ?";//수리대기
		try {
			con = factory.getConnection();
			switch (productState) {
			case "wa_check":
				pstmt = con.prepareStatement(waitCheckSql);
				pstmt.setString(1, productId);
				rs = pstmt.executeQuery();
				while(rs.next()) {
					returnValue.put("productId", rs.getString("PR_ID"));
					returnValue.put("itemId", rs.getString("IT_ID"));
					returnValue.put("itemName", rs.getString("IT_NAME"));
					returnValue.put("todayDate", rs.getString("today"));
				}
				break;
			case "wa_repair":
				pstmt = con.prepareStatement(waitRepairSql);
				pstmt.setString(1, productId);
				pstmt.setString(2, productState);
				rs = pstmt.executeQuery();
				while(rs.next()) {
					returnValue.put("productId", rs.getString("PR_ID"));
					returnValue.put("itemId", rs.getString("IT_ID"));
					returnValue.put("itemName", rs.getString("IT_NAME"));
					returnValue.put("todayDate", rs.getString("today"));
					returnValue.put("repairContent", rs.getString("RE_CONTENT"));
				}
				break;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				factory.close(con, pstmt, rs);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return returnValue;
	}
	
	/**
	 * 해당 품목에 부품 조회
	 * @param itemId
	 * @return
	 */
	public List<Map<String, String>> selectRepairPartsList(String itemId) { 
		Connection con = null;
		PreparedStatement pstmt = null;
		String sql ="select PA_ID, PA_SEARCH, PA_TOTAL from parts where it_id=?"; 
		ResultSet rs = null;
		List<Map<String,String>> list = new ArrayList<>();
		try {
			con = factory.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, itemId);
			rs = pstmt.executeQuery();
			while(rs.next()) { 
				Map<String,String> map = new HashMap<>();
				map.put("partId", rs.getString("PA_ID"));
				map.put("partName", rs.getString("PA_SEARCH"));
				map.put("partCount", ""+rs.getInt("PA_TOTAL"));
				list.add(map);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				factory.close(con, pstmt, rs);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return list;
	}
	
	/**
	 * 내부수리기사 점검 후 점검테이블에 점검내역 등록
	 * @param itName
	 * @param productId
	 * @param engineerId
	 * @param engineerName
	 * @param repairSort
	 * @param repairContent
	 * @return
	 */
	//수정필요 수리대기->update 점검대기 ->insert
	public int insertRepairResult(Map<String, Object> formInput, Map<String, String> partsInput) {
		int returnValue = -1;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		RempUtility ru = new RempUtility();
		StringBuilder temp = new StringBuilder();
		String repairSort = null;
		//sql
		String selectSql ="select SEQ_RE_ID.nextval seq from dual";
		String insertSql ="insert into repair values(?,?,?,?,?,?,?,SYSTIMESTAMP,?)";
		String insertPartSql = "insert into use_parts values(?,?,?)";
		String updatePartSql = "update parts set PA_TOTAL = PA_TOTAL - to_number(?) where PA_ID = ?";
		String insertOutputsql = "INSERT INTO output (ou_id, pr_id, it_id, ou_state, ou_out_day, ou_count, ou_complete) VALUES ('ou'||trim(to_char(output_seq.nextval,'0000000000')),?, (select it_id from product where pr_id=?),?,systimestamp,?,?)";
		String updateProductSql ="update product set PR_STATE=? where PR_ID =?";
		
		switch (formInput.get("repairSort").toString()) {
		case "wa_product":
			repairSort = "내부수리완료";
			break;
		case "wa_repair":
			repairSort = "수리대기";
			break;
		case "re_exoutput":
			repairSort = "외부수리";
			break;
		case "re_disuse":
			repairSort = "수리불가능";
		}
		try {
			//시퀸스 얻어오기
			con = factory.getConnection();
			pstmt = con.prepareStatement(selectSql);
			rs = pstmt.executeQuery();
			String repairId = null;
			if(rs.next()) {
				repairId = ru.getIdString("RE", rs.getInt("seq"), 12);
			} else {
				return -1;
			}
			returnValue += 2;
			//점검결과 등록
			System.out.println(formInput.get("repairSort").toString());
			pstmt.clearParameters();
			pstmt = con.prepareStatement(insertSql);
			pstmt.setString(1, repairId);
			pstmt.setString(2, formInput.get("itName").toString());
			pstmt.setString(3, formInput.get("productId").toString());
			pstmt.setString(4, formInput.get("engineerId").toString());
			pstmt.setString(5, formInput.get("engineerName").toString());
			pstmt.setString(6, repairSort);
			pstmt.setString(7, formInput.get("repairSort").toString());
			pstmt.setString(8, formInput.get("repairContent").toString());
			int insertResult = pstmt.executeUpdate();
			if (insertResult == 0) {
				return -1;
			}
			returnValue += 1;
			//자산테이블 변경
			pstmt.clearParameters();
			pstmt = con.prepareStatement(updateProductSql);
			pstmt.setString(1, formInput.get("repairSort").toString());
			pstmt.setString(2, formInput.get("productId").toString());
			int updateProductResult = pstmt.executeUpdate();
			if(updateProductResult == 0) {
				return -1;
			}
			returnValue += 1;
			if(repairSort.equals("외부수리")) {
			//출고 등록
			pstmt.clearParameters();
			pstmt = con.prepareStatement(insertOutputsql);
			pstmt.setString(1, formInput.get("productId").toString());
			pstmt.setString(2, formInput.get("productId").toString());
	        pstmt.setString(3, "re_exoutput");
	        pstmt.setInt(4, Integer.parseInt("1"));
	        pstmt.setString(5, "N");
	        int insertOutputResult = pstmt.executeUpdate();
	        returnValue += 1;
			}
			
			if(repairSort.equals("내부수리완료")){
				//사용부품 등록
				pstmt.clearParameters();
				pstmt = con.prepareStatement(insertPartSql);
				Set<String> keys = partsInput.keySet();
				Iterator<String> iter = keys.iterator();
				while(iter.hasNext()) {
					StringBuilder temp2 = new StringBuilder(iter.next());
					pstmt.setString(1, repairId);
					pstmt.setString(2, temp2.toString());
					pstmt.setString(3, partsInput.get(temp2.toString()));
					pstmt.addBatch();
				}
				int[] partsInsertResult = pstmt.executeBatch();
				returnValue += 1;
				
				//부품테이블 수량 업데이트
				pstmt.clearParameters();
				pstmt = con.prepareStatement(updatePartSql);
				Set<String> keys2 = partsInput.keySet();
				Iterator<String> iter2 = keys2.iterator();
				while(iter2.hasNext()) {
					StringBuilder temp2 = new StringBuilder(iter2.next());
					pstmt.setString(1, partsInput.get(temp2.toString()));
					pstmt.setString(2, temp2.toString());
					pstmt.addBatch();
				}
				int[] partsUpdateResult = pstmt.executeBatch();
				returnValue += 1;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				factory.close(con, pstmt, rs);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (returnValue < 3 || returnValue > 6) {
			returnValue = -1;
		}
		System.out.println(">>>>>>>returnValue: "+returnValue);
		return returnValue;
	}
	
	/**
	 * 내부수리기사 점검 후 자산테이블에 자산상태 변경
	 * @param productId
	 * @param repairSort
	 * @return
	 */
	public int updateProductState(String productId, String repairSort) {
		Connection con = null;
		PreparedStatement pstmt = null;
		String state = "";
		if(repairSort.equals("wa_product")) {
			state ="wa_product";
		}else if(repairSort.equals("wa_repair")) {
			state ="wa_repair";
		}else if(repairSort.equals("re_exoutput")) {
			state ="re_exoutput";
		}else if(repairSort.equals("re_disuse")) {
			state ="re_disuse";
		}
		String sql="update product set PR_STATE=? where PR_ID =?";
		try {
			con = factory.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, state);
			pstmt.setString(2, productId);
			return pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				factory.close(con, pstmt, null);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return 0;
	}
	
	/**
	 * 모든 부품 리스트 보여주기
	 * @return
	 */
	public List<Map<String, String>> selectAllParts() {
		Connection con = null;
		PreparedStatement pstmt = null;
		String sql = "select PA_ID, PA_MODEL, PA_SEARCH, IT_ID, PA_MANUFACTURER, PA_TOTAL, PA_SAFETY from parts order by PA_ID";
		ResultSet rs = null;
		List<Map<String, String>> list = new ArrayList<>();
		try {
			con = factory.getConnection();
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				Map<String, String> map = new HashMap<>();
				map.put("partId", rs.getString("PA_ID"));
				map.put("partModel", rs.getString("PA_MODEL"));
				map.put("partSearch", rs.getString("PA_SEARCH"));
				map.put("itemId", rs.getString("IT_ID"));
				map.put("partManufacturer", rs.getString("PA_MANUFACTURER"));
				map.put("partTotal", rs.getString("PA_TOTAL"));
				map.put("partSafety", rs.getString("PA_SAFETY"));
				list.add(map);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				factory.close(con, pstmt, rs);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return list;
	}
	
	/**
	 * 모든 점검결과 리스트 보여주기
	 * @param id
	 * @return
	 */
	public List<Map<String,String>> selectAllRepairResult(String id) {
		Connection con = null;
		PreparedStatement pstmt = null;
		String sql = "select RE_ID, IT_NAME, PR_ID, RE_ENGINEER_ID, RE_ENGINEER_NAME, RE_SORT, RE_STATE, to_char(RE_DAY,'yyyy-MM-dd hh24:mi') re_day, RE_CONTENT from repair where RE_ENGINEER_ID = ? order by RE_ID";
		ResultSet rs = null;
		List<Map<String, String>> list = new ArrayList<>();
		id="1234";//세션이라고 가정 엔지니어아이디
		try {
			con = factory.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				Map<String, String> map = new HashMap<>();
				map.put("repairId", rs.getString("RE_ID"));
				map.put("itemName", rs.getString("IT_NAME"));
				map.put("productId", rs.getString("PR_ID"));
				map.put("engineerId", rs.getString("RE_ENGINEER_ID"));
				map.put("engineerName", rs.getString("RE_ENGINEER_NAME"));
				map.put("repairSort", rs.getString("RE_SORT"));
				map.put("repairState", rs.getString("RE_STATE"));
				map.put("repairDate", rs.getString("re_day"));
				map.put("repairContent", rs.getString("RE_CONTENT"));
				list.add(map);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				factory.close(con, pstmt, rs);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return list;
	}
	
	/**
	 * 고객이 렌탈신청 구매정보테이블에 insert
	 * @param rentalInfo
	 * @return
	 */
	public int insertCustomerBuy(Map<String,String> rentalInfo) {
		Connection con = null;
		PreparedStatement pstmt = null;
		String sql = "";
		if(rentalInfo.get("rb_payment").equals("account")) {//계좌이체
			sql = "insert into buy (BUY_ID, BUY_DAY, CU_ID, IT_ID, BUY_PRICE, BUY_START, BUY_END, BUY_POST, BUY_ADDR, BUY_ADD_D, BUY_METHOD, BUY_CBANK, BUY_TRANSFER,BUY_PAY) VALUES('BU'||trim(to_char(SEQ_BU_ID.nextval,'0000000000')),sysdate,?,?,?,?,?,?,?,?,?,?,?,?)";
		}else if(rentalInfo.get("rb_payment").equals("card")) {//카드결제
			sql = "insert into buy (BUY_ID, BUY_DAY, CU_ID, IT_ID, BUY_PRICE, BUY_START, BUY_END, BUY_POST, BUY_ADDR, BUY_ADD_D, BUY_METHOD, BUY_CCOMPANY, BUY_CARD,BUY_PAY) VALUES('BU'||trim(to_char(SEQ_BU_ID.nextval,'0000000000')),sysdate,?,?,?,?,?,?,?,?,?,?,?,?)";
		}
		try {
			con = factory.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, rentalInfo.get("customerId"));
			pstmt.setString(2, rentalInfo.get("itemId"));
			pstmt.setInt(3, Integer.parseInt(rentalInfo.get("price")));
			pstmt.setString(4, rentalInfo.get("startDate"));
			pstmt.setString(5, rentalInfo.get("endDate"));
			pstmt.setString(6, rentalInfo.get("post"));
			pstmt.setString(7, rentalInfo.get("address"));
			pstmt.setString(8, rentalInfo.get("addressDetail"));
			pstmt.setString(9, rentalInfo.get("paymentMethod"));
			if(rentalInfo.get("rb_payment").equals("card")) {
				pstmt.setString(10, rentalInfo.get("cardSort"));
				pstmt.setString(11, rentalInfo.get("cardNum"));
			}else if(rentalInfo.get("rb_payment").equals("account")) {
				pstmt.setString(10, rentalInfo.get("bankSort"));
				pstmt.setString(11, rentalInfo.get("accountNum"));
			}
			pstmt.setString(12, "매월납부");//하드코딩 
			return pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				factory.close(con, pstmt, null);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return 0;
	}
	
	/**
	 * 고객 렌탈구매시 출고 테이블 등록
	 * @param adviceInfo
	 * @return
	 */
	   public int insertCustomerBuyOutput(Map<String, String> adviceInfo) {
	      Connection con = null;
	      PreparedStatement pstmt = null;
	      String sql = "INSERT INTO output (ou_id, it_id, ou_state, ou_out_day, ou_count, ou_complete) VALUES ('ou'||trim(to_char(output_seq.nextval,'0000000000')),?,?,systimestamp,?,?)";
	      try {
	         con = factory.getConnection();
	         pstmt = con.prepareStatement(sql);
	         pstmt.setString(1, adviceInfo.get("itemId"));
	         pstmt.setString(2, "re_output");
	         pstmt.setInt(3, Integer.parseInt(adviceInfo.get("tb_itNumber")));
	         pstmt.setString(4, "N");
	         return pstmt.executeUpdate();
	      } catch (Exception e) {
	         e.printStackTrace();
	      } finally {
	         try {
				factory.close(con, pstmt, null);
			} catch (SQLException e) {
				e.printStackTrace();
			}
	      }
	      return 0;
	   }
	   
	/**
	 * 부품 검색
	 * @param type
	 * @param keyword
	 * @return
	 */
	public List<Map<String, String>> selectPartsList(String type, String keyword){
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "";
		List<Map<String, String>> list = new ArrayList<>();
		if(type.equals("partId")) {//부품아이디로 검색
			sql = "select PA_ID, PA_MODEL, PA_SEARCH, IT_ID, PA_MANUFACTURER, PA_TOTAL, PA_SAFETY from parts where PA_ID like ?";
		}else if(type.equals("PartSearchName")) {//부품명으로 검색
			sql = "select PA_ID, PA_MODEL, PA_SEARCH, IT_ID, PA_MANUFACTURER, PA_TOTAL, PA_SAFETY from parts where PA_SEARCH like ?";
		}else if(type.equals("ItemId")) {//품목명으로 검색
			sql = "select PA_ID, PA_MODEL, PA_SEARCH, IT_ID, PA_MANUFACTURER, PA_TOTAL, PA_SAFETY from parts where IT_ID like ?";
		}else if(type.equals("partManufacturer")) {//부품제조사로 검색
			sql = "select PA_ID, PA_MODEL, PA_SEARCH, IT_ID, PA_MANUFACTURER, PA_TOTAL, PA_SAFETY from parts where PA_MANUFACTURER like ?";
		}else if(type.equals("all")) {//전체 검색
			sql = "select p.pa_id, p.pa_search, p.it_id, p.pa_manufacturer, p.pa_model, p.pa_total, p.pa_safety\r\n" + 
					"from (select pa_id, pa_id||' '||pa_search||' '||it_id||' '||pa_manufacturer||' '||pa_model combination from parts) c, parts p\r\n" + 
					"where c.pa_id = p.pa_id and c.combination like ?";
		}
		try {
			con = factory.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, "%"+keyword+"%");
			rs = pstmt.executeQuery();
			while(rs.next()) {
				Map<String, String> map = new HashMap<>();
				map.put("partId", rs.getString("PA_ID"));
				map.put("partModel", rs.getString("PA_MODEL"));
				map.put("partSearch", rs.getString("PA_SEARCH"));
				map.put("itemId", rs.getString("IT_ID"));
				map.put("partManufacturer", rs.getString("PA_MANUFACTURER"));
				map.put("partTotal", rs.getString("PA_TOTAL"));
				map.put("partSafety", rs.getString("PA_SAFETY"));
				list.add(map);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				factory.close(con, pstmt, rs);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return list;
	}
	
	/**
	 * 내부수리기사 점검내역 검색조회
	 * @param engineerId
	 * @param startDate
	 * @param endDate
	 * @param repairSort
	 * @return
	 */
	public List<Map<String, String>> selectRepairResult(String engineerId, String startDate, String endDate, String repairSort){
		Connection con = null;
		PreparedStatement pstmt = null;
		String sql ="";
		ResultSet rs = null;
		List<Map<String, String>> list = new ArrayList<>();
		engineerId = "1234"; //하드코딩 세션아이디
		if(repairSort.equals("수리대기")) {
			sql = "select RE_ID, IT_NAME, PR_ID, RE_ENGINEER_ID, RE_ENGINEER_NAME, RE_SORT, RE_STATE, to_char(RE_DAY,'yyyy-MM-dd hh24:mi') re_day, RE_CONTENT from repair where RE_DAY >= to_date(?,'yy/MM/dd') and RE_DAY <= to_date(?,'yy/MM/dd') and RE_STATE ='wa_repair' and RE_ENGINEER_ID = ?";//상태명 바꿔야함
		}else if(repairSort.equals("수리완료")) {
			sql = "select RE_ID, IT_NAME, PR_ID, RE_ENGINEER_ID, RE_ENGINEER_NAME, RE_SORT, RE_STATE, to_char(RE_DAY,'yyyy-MM-dd hh24:mi') re_day, RE_CONTENT from repair where RE_DAY >= to_date(?,'yy/MM/dd') and RE_DAY <= to_date(?,'yy/MM/dd') and RE_STATE ='wa_product' and RE_ENGINEER_ID = ?";//상태명 바꿔야함 
		}else if(repairSort.equals("외부수리")) {
			sql = "select RE_ID, IT_NAME, PR_ID, RE_ENGINEER_ID, RE_ENGINEER_NAME, RE_SORT, RE_STATE, to_char(RE_DAY,'yyyy-MM-dd hh24:mi') re_day, RE_CONTENT from repair where RE_DAY >= to_date(?,'yy/MM/dd') and RE_DAY <= to_date(?,'yy/MM/dd') and RE_STATE ='re_exoutput' and RE_ENGINEER_ID = ?";//상태명 바꿔야함 
		}else if(repairSort.equals("수리불가능")) {
			sql = "select RE_ID, IT_NAME, PR_ID, RE_ENGINEER_ID, RE_ENGINEER_NAME, RE_SORT, RE_STATE, to_char(RE_DAY,'yyyy-MM-dd hh24:mi') re_day, RE_CONTENT from repair where RE_DAY >= to_date(?,'yy/MM/dd') and RE_DAY <= to_date(?,'yy/MM/dd') and RE_STATE ='re_disuse' and RE_ENGINEER_ID = ?";//상태명 바꿔야함 
		}else if(repairSort.equals("전체")) {
			sql = "select RE_ID, IT_NAME, PR_ID, RE_ENGINEER_ID, RE_ENGINEER_NAME, RE_SORT, RE_STATE, to_char(RE_DAY,'yyyy-MM-dd hh24:mi') re_day, RE_CONTENT from repair where RE_DAY >= to_date(?,'yy/MM/dd') and RE_DAY <= to_date(?,'yy/MM/dd') and (RE_STATE ='re_disuse' or RE_STATE ='re_exoutput' or RE_STATE ='wa_product' or RE_STATE ='wa_repair') and RE_ENGINEER_ID = ?";
		}
		try {
			con = factory.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, startDate);
			pstmt.setString(2, endDate);
			pstmt.setString(3, engineerId);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				Map<String, String> map = new HashMap<>();
				map.put("repairId", rs.getString("RE_ID"));
				map.put("itemName", rs.getString("IT_NAME"));
				map.put("productId", rs.getString("PR_ID"));
				map.put("engineerId", rs.getString("RE_ENGINEER_ID"));
				map.put("engineerName", rs.getString("RE_ENGINEER_NAME"));
				map.put("repairSort", rs.getString("RE_SORT"));
				map.put("repairState", rs.getString("RE_STATE"));
				map.put("repairDate", rs.getString("re_day"));
				map.put("repairContent", rs.getString("RE_CONTENT"));
				list.add(map);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				factory.close(con, pstmt, rs);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return list;
	}
	
	
}
