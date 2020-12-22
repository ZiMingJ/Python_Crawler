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
		// ��������
		Connection conn;
		try {
			conn = MySQLUtil.getConnection();
			// ����SQL
			PreparedStatement stmt = conn.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			// ���������
			while (rs.next()) {// ȡһ��

				Job c = new Job();
				c.setJobName(rs.getString(1));// ������
				c.setjCnt(rs.getInt(2));// ��λ��
				// �Ѷ�����뼯��
				list.add(c);
			}
			// �ر�����
			MySQLUtil.closeConnection(conn, stmt, rs);

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// ���ؼ���
		return list;
	}
}
