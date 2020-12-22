package boss.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import boss.dao.Salary;
import boss.dao.SalaryDao;

/**
 * Servlet implementation class SalaryServlet
 */
@WebServlet("/s")
public class SalaryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// �������е������GET��ʽ���͵�����
		// ����Dao�еķ�������ѯ���ݿ�
		SalaryDao dao = new SalaryDao();
		List<Salary> list = dao.findSalary();

		// ��echartҪ����װ���ݣ������꣬������
		// ["����","��ë��","ѩ����","����","�߸�Ь","����"]
		// [5, 20, 36, 10, 10, 20]

		String x2 = "[";
		String y2 = "[";
		for (Salary c : list) { // for each
			x2 += "'" + c.getcNmae() + "',";
			y2 += c.getSalary() + ",";
		}
		x2 = x2.substring(0, x2.length() - 1) + "]";
		y2 = y2.substring(0, y2.length() - 1) + "]";

		// ���棬�ȴ�JSPʹ��
		request.setAttribute("x2", x2);
		request.setAttribute("y2", y2);

		// ��ת��JSP
		request.getRequestDispatcher("show.jsp").forward(request, response);

	}


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
