package com.care.cs.session;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.springframework.stereotype.Repository;

@Repository
public class SessionDbDAO {
	private Connection con;
	
	public SessionDbDAO() {
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "oracle";
		String password = "oracle";
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			con = DriverManager.getConnection(url, user, password);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public SessionDbDTO login(String id) {
		String sql = "SELECT * FROM session_test WHERE id = ?";
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			ps = con.prepareCall(sql);
			ps.setString(1, id);
			rs = ps.executeQuery();
			if(rs.next()) {
				SessionDbDTO dto = new SessionDbDTO();
				dto.setId(rs.getString("id"));
				dto.setPw(rs.getString("pw"));
				dto.setName(rs.getString("name"));
				dto.setEmail(rs.getString("email"));
				return dto;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
