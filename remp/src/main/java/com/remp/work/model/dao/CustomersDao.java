package com.remp.work.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

@Repository
public class CustomersDao {
	@Autowired
	@Qualifier("factory")
	private FactoryDao factory;

	public boolean updatePassword(String id, String pw, String newPw) {
		Connection con = null;
		String sql = "update CUSTOMER set CU_PW=? where CU_PW=? and CU_ID=?";
		PreparedStatement pstmt = null;
		int result;
		try {
			con = factory.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, newPw);
			pstmt.setString(2, pw);
			pstmt.setString(3, id);
			result = pstmt.executeUpdate();
			
			if(result == 1) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				factory.close(con, pstmt,null);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return false;
	}
}
