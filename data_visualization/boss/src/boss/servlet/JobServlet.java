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
		// 处理所有的浏览器GET方式发送的请求
		// 调用Dao中的方法，查询数据库
		JobDao dao = new JobDao();
		List<Job> list = dao.findJob();

		// 按echart要求组装数据，横坐标，纵坐标
		// ["衬衫","羊毛衫","雪纺衫","裤子","高跟鞋","袜子"]
		// [5, 20, 36, 10, 10, 20]

		String x1 = "[";
		String y1 = "[";
		for (Job c : list) { // for each
			x1 += "'" + c.getJobName() + "'" + ",";
			y1 += "{value:" + c.getjCnt() + "," + "name:" + "'" + c.getJobName() +"'"+"}"+",";
		}
		x1 = x1.substring(0, x1.length() - 1) + "]";
		y1 = y1.substring(0, y1.length() - 1) + "]";

		// 保存，等待JSP使用
		request.setAttribute("x1", x1);
		request.setAttribute("y1", y1);

		// 跳转到JSP
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
