package db;

import java.sql.*;

public class DBHandler {
	String driver = "oracle.jdbc.OracleDriver";
	String url = "jdbc:oracle:thin:@localhost:1521:xe";
	String dbuid = "sky";
	String dbpwd = "1234";
	
	//회원 검색
	public int list(String userid, String username, String email) throws ClassNotFoundException, SQLException {
		Class.forName(driver);
		Connection conn = DriverManager.getConnection(url, dbuid, dbpwd);
		
		String sql = "";
			   sql += "SELECT * FROM TMEM";
			   sql += " WHERE USERNAME LIKE ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, "%" + username + "%");
		
		ResultSet rs = pstmt.executeQuery();
		
		while(rs.next()){
			String uid = rs.getString("userid");
			String uname = rs.getString("username");
			String uemail = rs.getString("email");
			
			String tag = "";
			tag += "<li>"+ uid  + "," + uname + "," + uemail +"</li>";
		}
		
		int aftcnt = pstmt.executeUpdate();
		
		rs.close();
		pstmt.close();
		conn.close();
		
		return aftcnt;
	}
	
	//회원 추가
	public int addUser(String userid, String username, String email) throws ClassNotFoundException, SQLException {
		Class.forName(driver);
		Connection conn = DriverManager.getConnection(url, dbuid, dbpwd);
		
		String sql = "";
			   sql += "INSERT INTO TMEM VALUES(?, ?, ?)";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, userid);
		pstmt.setString(2, username);
		pstmt.setString(3, email);
		
		int aftcnt = pstmt.executeUpdate();
		
		pstmt.close();
		conn.close();
		
		return aftcnt;
	}
}
