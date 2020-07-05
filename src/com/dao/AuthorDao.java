package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.bean.AuthorBean;
import com.util.DBConnection;

public class AuthorDao {

	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;

	public List<AuthorBean> authorList() {

		List<AuthorBean> authorList = new ArrayList<AuthorBean>();

		conn = DBConnection.getDBConnection();
		if (conn != null) {
			String selectSQL = "select * from author";
			try {
				pstmt = conn.prepareStatement(selectSQL);
				rs = pstmt.executeQuery();
				while (rs.next()) {

					AuthorBean authorBean = new AuthorBean();
					authorBean.setaId(rs.getInt("aid"));
					authorBean.setaName(rs.getString("aname"));
					authorList.add(authorBean);
				}

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		return authorList;

	}
}
