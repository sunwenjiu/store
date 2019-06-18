package web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.HeroDAO;
import entity.Hero;

public class HeroServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		String path = request.getServletPath();
		if("/page.do".equals(path)) {

			findByPage(request, response);
		}else if("/update.do".equals(path)){
			update(request, response);
			
		}else {
			
		}


	}

	private void update(HttpServletRequest request, HttpServletResponse response) throws IOException {
		Integer id=Integer.parseInt(request.getParameter("id"));
		String name=request.getParameter("name");
		String nickname=request.getParameter("nickname");
		String sex=request.getParameter("sex");
		String camp=request.getParameter("camp");
		
		System.out.println(new Hero(id, name, nickname, sex, camp));

		HeroDAO dao = new HeroDAO();
		dao.update(id, name, nickname, sex, camp);
		
		response.sendRedirect("page.do");
		
	}

	public void findByPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Integer page=0;
		if(request.getParameter("page")==null) {
			page=1;
		}else {
			
			page=Integer.parseInt(request.getParameter("page"));
		}
		
		HeroDAO dao = new HeroDAO();
		Integer pageSize=5;
		Integer pageStart=(page-1)*pageSize;
		List<Hero> heros=dao.findbyPage(pageStart, pageSize);
		Integer count=dao.count();
		Integer button=count%pageSize==0?count/pageSize:count/pageSize+1;
		request.setAttribute("button", button);
		request.setAttribute("heros", heros);
		request.getRequestDispatcher("/view/page.jsp").forward(request, response);
		
	}

}
