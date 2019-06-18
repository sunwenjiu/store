<%@page import="entity.User"%>
<%@page import="java.util.List"%>
<%@page import="dao.UserDAO"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@ page     pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib  prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<title>listUsers</title>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/css/style.css" />
	</head>
	<body>
		<div id="wrap">
			<div id="top_content"> 
				<div id="header">
					<div id="rightheader">
						<p>
								<jsp:useBean id="today" class="java.util.Date"></jsp:useBean>
								<fmt:formatDate value="${today }" pattern="yyyy/MM/dd" />
							
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
						<c:forEach  items="${list }" var="user" varStatus="st">
							<tr class='${st.count%2==0?"row2":"row1" }'>
							
							<td>
							${user.id }
							
							</td>
							<td>
							${user.username }
							
							</td>
							<td>
							${user.password }
								
							</td>
							<td>
							${user.email }
								
							</td>
							<td>
								<a href="${app }/delUser.do?id=${user.id}">删除</a>&nbsp;
								
							</td>
						</tr>
						
						</c:forEach>
						
						
						
					</table>
					<p>
						<input type="button" class="button" value="添加用户" onclick="location='${app}/addUser-form.do'"/>
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
