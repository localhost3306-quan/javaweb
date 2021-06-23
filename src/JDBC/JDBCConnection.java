package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;

public class JDBCConnection {
	public Connection getConnection() {
		final String username = "root";
		final String password = "123456aA@";
		final String url = "jdbc:mysql://localhost:3306/projectweb";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			return DriverManager.getConnection(url, username, password);
		} catch (Exception e) {
			System.out.println("Ket noi failed " + e);
		}
		
		return null; 
	}
	
	public static void main(String[] args) {
		JDBCConnection jdbc = new JDBCConnection();
		Connection conn = jdbc.getConnection();
		if (conn == null) {
			System.out.println("THAT BAI");
		} else {
			System.out.println("THANH CONG");
		}
	}
//	public Connection getConnection() {
//		final String username = "root";
//		final String password = "NCCiyx44482";
//		final String url = "jdbc:mysql://node8082-env-1272139.th.app.ruk-com.cloud/projectweb?useUnicode=true&characterEncoding=UTF-8";
//		try {
//			Class.forName("com.mysql.cj.jdbc.Driver");
//			return DriverManager.getConnection(url, username, password);
//			
//		} catch (Exception e) {
//			e.printStackTrace();
//			System.out.println("Ket noi failed " + e);
//		}
//		
//		return null; 
//	}
//	
//	public static void main(String[] args) {
//		JDBCConnection jdbc = new JDBCConnection();
//		Connection conn = jdbc.getConnection();
//		if (conn == null) {
//			System.out.println("THAT BAI");
//		} else {
//			System.out.println("THANH CONG");
//		}
//	}
}
