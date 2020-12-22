package boss.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class JobDao {
	// Data Access Object

	public List<Job> findJob() {

		List<Job> list = new ArrayList<>();
		String sql = "SELECT job, count(*) from info GROUP BY job ORDER BY count(*) DESC limit 5";
		// 连接数据
		Connection conn;
		try {
			conn = MySQLUtil.getConnection();
			// 处理SQL
			PreparedStatement stmt = conn.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			// 结果集处理
			while (rs.next()) {// 取一行

				Job c = new Job();
				c.setJobName(rs.getString(1));// 工作名
				c.setjCnt(rs.getInt(2));// 岗位数
				// 把对象加入集合
				list.add(c);
			}
			// 关闭连接
			MySQLUtil.closeConnection(conn, stmt, rs);

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// 返回集合
		return list;
	}
}
