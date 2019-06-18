package web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DisDAO;
import entity.DiseaseEntity;

/**
 * 疾病百科的详情页
 */
public class AspirinInducedAsthmaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		
		//获取请求数据no
		int no=Integer.parseInt(request.getParameter("no"));
		
		
		
		//用no去查询该病所有信息
		
		DisDAO dao = new DisDAO();
	DiseaseEntity dis=	dao.getDiseaseById(no);
		
		
		//转发给aspirinInducedAsthma.jsp详情页处理
		//绑定数据
	request.setAttribute("dis", dis);
	//转发
	request.getRequestDispatcher("aspirinInducedAsthma.jsp").forward(request, response);
		
	}

}
