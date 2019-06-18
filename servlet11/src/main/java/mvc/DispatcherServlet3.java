package mvc;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 前端(核心)控制器,接受用户对所有servlet的请求
 * 将复杂的web处理代码封装在前端控制器内部
 * @author soft01
 *
 *
 */
public class DispatcherServlet3 extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//从web.xml中读取配置
		String encode=getServletContext().getInitParameter("encode");

		//响应乱码
		response.setContentType("text/html;charset="+encode);
		//请求乱码
		request.setCharacterEncoding(encode);

		try {
			String className="mvc.Controller";
			//获取用户本次请求的url
			String url=	request.getRequestURI();
			url=url.substring(request.getContextPath().length());
			System.out.println("url="+url);


			Class cz=Class.forName(className);
			Method[] ms=cz.getDeclaredMethods();

			for (Method m : ms) {
				Annotation [] ans=m.getAnnotations();
				for (Annotation an : ans) {
					if (an instanceof RequestMapping) {
						String value=((RequestMapping)an).value();
						if (value.equals(url)) {

							String path=(String)			m.invoke(cz.newInstance(),request);
							//拼接路径
							path="/WEB-INF/jsp/"+path+".jsp";
							//实现请求转发
							request.getRequestDispatcher(path).forward(request, response);

						}

					}

				}

			}




		} catch (Exception e) {
			e.printStackTrace();
			response.getWriter().write("服务器故障:"+e.getMessage());

		}


	}

}
