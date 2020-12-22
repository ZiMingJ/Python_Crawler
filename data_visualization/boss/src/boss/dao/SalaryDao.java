package boss.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SalaryDao {
	// Data Access Object

	public List<Salary> findSalary() {

		List<Salary> list = new ArrayList<>();
		String sql = "SELECT company, avg(salary) from info GROUP BY company ORDER BY avg(salary) DESC limit 5";
		// ��������
		Connection conn;
		try {
			conn = MySQLUtil.getConnection();
			// ����SQL
			PreparedStatement stmt = conn.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			// ���������
			while (rs.next()) {// ȡһ��

				Salary c = new Salary();
				c.setcNmae(rs.getString(1));// ��˾��
				c.setSalary(rs.getString(2));// ��λ��
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
