package boss.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.sql.Statement;



public class MySQLUtil {
	public static Connection getConnection() throws SQLException, ClassNotFoundException {
		// 加载驱动
		Class.forName("com.mysql.jdbc.Driver");
		// 连接
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/boss?useUnicode=true&characterEncoding=utf8", "root", "123456");
		return conn;
	}
	
	public static void closeConnection(Connection conn, Statement stmt, ResultSet rs) throws SQLException {
		
		if (rs != null)
			rs.close();
		if (stmt != null)
			stmt.close();
		if (conn != null)
			conn.close();
	}

}
