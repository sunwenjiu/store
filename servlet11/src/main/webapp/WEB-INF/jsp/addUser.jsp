<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@ page     pageEncoding="UTF-8"%>
<%@ taglib  prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<title>add User</title>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link rel="stylesheet" type="text/css"
			href="${app }/css/style.css" />
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
								<a href="#">添加用户</a>
							</h1>
						</div>
						<div id="navigation">
						</div>
					</div>
				<div id="content">
					<p id="whereami">
					</p>
					<h1>
						添加用户信息
					</h1>
					<form action="${app }/addUser.do" method="post">
						<table cellpadding="0" cellspacing="0" border="0"
							class="form_table">
							<tr>
								<td valign="middle" align="right">
									用户名:
								</td>
							
								<td valign="middle" align="left">
									<input type="text" class="inputgri" name="username" 
									value='${param.username }' />
									<span style="color: red;font-size: 15px;   " >
									
									${msg}
									</span>
								</td>
							</tr>
							<tr>
								<td valign="middle" align="right">
									密码:
								</td>
								<td valign="middle" align="left">
									<input type="password" class="inputgri" name="password" />
								</td>
							</tr>
							<tr>
								<td valign="middle" align="right">
									邮箱:
								</td>
						
							
								<td valign="middle" align="left">
									<input type="text" class="inputgri" name="email" 
									value='${param.email }' />
								</td>
							</tr>
						</table>
						<p>
							<input type="submit" class="button" value="添加" />
						</p>
					</form>
				</div>
			</div>
			<div id="footer">
				<div id="footer_bg">
					ABC@126.com
				</div>
			</div>
		</div>
	</body>
</html>
