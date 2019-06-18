package web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DisDAO;
import entity.DiseaseEntity;

/**
 * 疾病百科首页展示添加了分页展示，处理了第一页和最后一页问题
 * @author Administrator
 *
 */
public class DiseaseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		int page=0;
		int pageTwo=18;
		//获取第几页
		if(request.getParameter("page")!=null) {
			
			page=Integer.parseInt(request.getParameter("page"));
		}
		request.setAttribute("page", page);
		page=page*pageTwo;
		//获取疾病百科数据
		DisDAO dao=new DisDAO();
		List<DiseaseEntity> list = dao.getDisease(page,pageTwo);
		int maxNo=dao.getMaxNo();
		boolean pageok=true;
		for (DiseaseEntity dis : list) {
			if (dis.getNo()==maxNo) {
				pageok=false;
			}
			
		}
		//将数据转发给disease.jsp处理
		 
		//绑定参数
		request.setAttribute("list", list);
		request.setAttribute("maxNo", maxNo);
		request.setAttribute("pageok", pageok);
		//转发请求
		request.getRequestDispatcher("disease.jsp").forward(request, response);
		
		
	}

}
