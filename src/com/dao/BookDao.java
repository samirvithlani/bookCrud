package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.bean.BookBean;
import com.util.DBConnection;

public class BookDao {

	PreparedStatement pstmt;
	Connection conn;
	ResultSet rs;

	public boolean addBook(BookBean bookBean) {

		boolean flag = false;
		conn = DBConnection.getDBConnection();
		if (conn != null) {
			String insertSQL = "insert into book(bname,bprice,bqty,aid)values(?,?,?,?)";
			try {
				pstmt = conn.prepareStatement(insertSQL);

				pstmt.setString(1, bookBean.getbName());
				pstmt.setInt(2, bookBean.getbPrice());
				pstmt.setInt(3, bookBean.getbQty());
				pstmt.setInt(4, bookBean.getaId());

				int res = pstmt.executeUpdate();
				if (res > 0) {

					flag = true;

				}

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

		return flag;
	}

	public List<BookBean> bookList() {

		List<BookBean> listOfBooks = new ArrayList<BookBean>();
		conn = DBConnection.getDBConnection();

		if (conn != null) {

			String selectSQL = "select * from book"; //
			try {
				pstmt = conn.prepareStatement(selectSQL);

				rs = pstmt.executeQuery();// result set //ite

				while (rs.next()) {

					System.out.println(rs.getInt("bid"));
					BookBean bookBean = new BookBean(); // 1
					bookBean.setbId(rs.getInt("bid"));
					bookBean.setbName(rs.getString("bname"));
					bookBean.setbPrice(rs.getInt("bprice"));
					bookBean.setbQty(rs.getInt("bqty"));
					listOfBooks.add(bookBean);//

				}

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

		return listOfBooks;
	}

	public boolean deleteBook(int bid) {

		boolean flag = false;
		conn = DBConnection.getDBConnection();
		if (conn != null) {

			String deleteSQL = "delete from book where bid =?";

			try {
				pstmt = conn.prepareStatement(deleteSQL);
				pstmt.setInt(1, bid);

				int res = pstmt.executeUpdate();
				if (res > 0) {

					flag = true;
				}

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

		return flag;
	}

	public BookBean getDataById(int bId) {

		conn = DBConnection.getDBConnection();
		BookBean bookBean = null;
		if (conn != null) {

			String selectSQL = "select * from book where bid =?";
			try {
				pstmt = conn.prepareStatement(selectSQL);

				pstmt.setInt(1, bId);
				rs = pstmt.executeQuery();
				while (rs.next()) {
					bookBean = new BookBean();

					bookBean.setbId(rs.getInt("bid"));
					bookBean.setbName(rs.getString("bname"));
					bookBean.setbPrice(rs.getInt("bprice"));
					bookBean.setbQty(rs.getInt("bqty"));

				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		return bookBean;

	}

	public boolean updateBook(BookBean bookBean) {

		conn = DBConnection.getDBConnection();
		boolean flag = false;
		if (conn != null) {

			String updateSQl = "update book set bname =?,bprice=?,bqty=? where bid =?";
			try {
				pstmt = conn.prepareStatement(updateSQl);

				pstmt.setString(1, bookBean.getbName());
				pstmt.setInt(2, bookBean.getbPrice());
				pstmt.setInt(3, bookBean.getbQty());
				pstmt.setInt(4, bookBean.getbId());

				int res = pstmt.executeUpdate();
				if (res > 0) {

					flag = true;

				}

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		return flag;
	}

}
