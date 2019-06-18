<%@page import="entity.User"%>
<%@page import="java.util.List"%>
<%@page import="dao.UserDAO"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@ page     pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<title>listUsers</title>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link rel="stylesheet" type="text/css" href="css/style.css" />
	</head>
	<body>
		<div id="wrap">
			<div id="top_content"> 
				<div id="header">
					<div id="rightheader">
						<p>
							<%
								Date date=new Date();
							SimpleDateFormat sdf=new SimpleDateFormat("yyyy/MM/dd");
							%>
							<%=sdf.format(date) %>
							<br />
						</p>
					</div>
					<div id="topheader">
						<h1 id="title">
							<a href="#">main</a>
						</h1>
					</div>
					<div id="navigation">
					</div>
				</div>
				<div id="content">
					<p id="whereami">
					</p>
					<h1>
						Welcome!
					</h1>
					<table class="table">
						<tr class="table_header">
							<td>
								ID
							</td>
							<td>
								姓名
							</td>
							<td>
								密码
							</td>
							<td>
								邮箱
							</td>
							<td>
								操作
							</td>
						</tr>
						<%
						UserDAO dao=new UserDAO();
						List<User> list =dao.listUser();
						for(int i =0;i<list.size();i++){ %>
							<tr class='<%=(i+1)%2==0?"row2":"row1" %>'>
							<td>
								<%=list.get(i).getId() %>
							</td>
							<td>
							<%=list.get(i).getUsername() %>
							</td>
							<td>
								<%=list.get(i).getPassword() %>
							</td>
							<td>
								<%=list.get(i).getEmail() %>
							</td>
							<td>
								<a href="delUser?id=<%=list.get(i).getId() %>">删除</a>&nbsp;
								
							</td>
						</tr>
						
						
						<%}%>
						
						
					</table>
					<p>
						<input type="button" class="button" value="添加用户" onclick="location='addUser.jsp'"/>
					</p>
				</div>
			</div>
			<div id="footer">
				<div id="footer_bg">
				ABC@126.com
				</div>
			</div>
		</div>
	</body>

</html>`
