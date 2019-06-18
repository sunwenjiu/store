package mvc;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

/**
 * 前端(核心)控制器,接受用户对所有servlet的请求
 * 将复杂的web处理代码封装在前端控制器内部
 * @author soft01
 *
 */
public class DispatcherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
HandlerMapping handlerMapping = new HandlerMapping();

	
	@Override
	public void init() throws ServletException {
		//初始化HandlerMappng
		try {
			SAXReader  reader =new SAXReader();
			String fileName=getInitParameter("fileName");
			
			InputStream is =getClass().getClassLoader().getResourceAsStream(fileName);
			
			Document document= reader.read(is);
			
			Element rootEle=document.getRootElement();
		List<Element> list=	rootEle.elements("bean");
		if (list!=null) {
			for (Element ele : list) {
				String classNmme= ele.attributeValue("class");
				handlerMapping.parseController(classNmme);
			}
		}	
		
			
			System.out.println("hm="+handlerMapping);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new ServletException("控制器解析异常",e);
		}
		

		
	}


	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	//从web.xml中读取配置
		String encode=getServletContext().getInitParameter("encode");
		
		//响应乱码
		response.setContentType("text/html;charset="+encode);
		//请求乱码
		request.setCharacterEncoding(encode);
		
		try {
			//获取请求
			String url =request.getRequestURI();
			//截取请求
			url=url.substring(request.getContextPath().length());
	//从HandlerMapping中获取对应的Handler
			Handler handler=handlerMapping.getHandler(url);
			//反射调用子控制器对应的方法
			String path=handler.execute(request);
			
			if (path.startsWith("redirect:")) {
				//重定向
				//对path进行截取
				path=path.substring("redirect:".length());
				//判断是否请求其他网站
				if (path.startsWith("http")) {
					response.sendRedirect(path);
				}else {
					//在路径前拼接ContextPath
					path=request.getContextPath()+path;
					response.sendRedirect(path);
				}
				
				
			}else {
				//转发
				
				
				//拼接jsp的路径
				path="/WEB-INF/jsp/"+path+".jsp";
				
				//基于方法返回值实现 请求转发
				request.getRequestDispatcher(path).forward(request, response);
				
				
			}
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
			response.getWriter().write("服务器故障:"+e.getMessage());
			
		}
		
		
	}

}
