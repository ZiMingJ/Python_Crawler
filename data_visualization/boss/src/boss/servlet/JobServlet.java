package boss.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import boss.dao.Job;
import boss.dao.JobDao;

/**
 * Servlet implementation class JobServlet
 */
@WebServlet("/j")
public class JobServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// �������е������GET��ʽ���͵�����
		// ����Dao�еķ�������ѯ���ݿ�
		JobDao dao = new JobDao();
		List<Job> list = dao.findJob();

		// ��echartҪ����װ���ݣ������꣬������
		// ["����","��ë��","ѩ����","����","�߸�Ь","����"]
		// [5, 20, 36, 10, 10, 20]

		String x1 = "[";
		String y1 = "[";
		for (Job c : list) { // for each
			x1 += "'" + c.getJobName() + "'" + ",";
			y1 += "{value:" + c.getjCnt() + "," + "name:" + "'" + c.getJobName() +"'"+"}"+",";
		}
		x1 = x1.substring(0, x1.length() - 1) + "]";
		y1 = y1.substring(0, y1.length() - 1) + "]";

		// ���棬�ȴ�JSPʹ��
		request.setAttribute("x1", x1);
		request.setAttribute("y1", y1);

		// ��ת��JSP
		request.getRequestDispatcher("pie.jsp").forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
