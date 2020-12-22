package boss.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import boss.dao.Company;
import boss.dao.CompanyDao;

/**
 * Servlet implementation class BossServlet
 */
@WebServlet("/c")
public class BossServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// �������е������GET��ʽ���͵�����
		// ����Dao�еķ�������ѯ���ݿ�
		CompanyDao dao = new CompanyDao();
		List<Company> list = dao.findCompany();

		// ��echartҪ����װ���ݣ������꣬������
		// ["����","��ë��","ѩ����","����","�߸�Ь","����"]
		// [5, 20, 36, 10, 10, 20]

		String x = "[";
		String y = "[";
		for (Company c : list) { // for each
			x += "'" + c.getName() + "',";
			y += c.getCnt() + ",";
		}
		x = x.substring(0, x.length() - 1) + "]";
		y = y.substring(0, y.length() - 1) + "]";

		// ���棬�ȴ�JSPʹ��
		request.setAttribute("x", x);
		request.setAttribute("y", y);

		// ��ת��JSP
		request.getRequestDispatcher("show.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
