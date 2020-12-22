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
		// 处理所有的浏览器GET方式发送的请求
		// 调用Dao中的方法，查询数据库
		CompanyDao dao = new CompanyDao();
		List<Company> list = dao.findCompany();

		// 按echart要求组装数据，横坐标，纵坐标
		// ["衬衫","羊毛衫","雪纺衫","裤子","高跟鞋","袜子"]
		// [5, 20, 36, 10, 10, 20]

		String x = "[";
		String y = "[";
		for (Company c : list) { // for each
			x += "'" + c.getName() + "',";
			y += c.getCnt() + ",";
		}
		x = x.substring(0, x.length() - 1) + "]";
		y = y.substring(0, y.length() - 1) + "]";

		// 保存，等待JSP使用
		request.setAttribute("x", x);
		request.setAttribute("y", y);

		// 跳转到JSP
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
