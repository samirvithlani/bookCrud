package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.bean.AdminBean;
import com.util.DBConnection;

public class AdminDao {

	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;

	public AdminBean loginAdmin(String aEmail, String aPassword) {
		conn = DBConnection.getDBConnection();
		AdminBean adminBean = null;
		if (conn != null) {

			String selectSQL = "select * from admin where aemail=? and apassword =?";
			try {
				pstmt = conn.prepareStatement(selectSQL);
				pstmt.setString(1, aEmail);
				pstmt.setString(2, aPassword);
				rs = pstmt.executeQuery();
				while (rs.next()) {
					adminBean = new AdminBean();
					adminBean.setaId(rs.getInt("aid"));
					adminBean.setaName(rs.getString("aname"));
					adminBean.setaEmail(rs.getString("aemail"));
					adminBean.setaPassword(rs.getString("apassword"));

				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		return adminBean;

	}
}
