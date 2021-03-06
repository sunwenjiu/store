<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<!-- 是第一次访问checks.jsp就走这里，然后自动跳转 -->
<c:if test="${list==null }" var="listisnull">
	<meta http-equiv="refresh" content="0;url=checks">
</c:if>
<title>疾病检查</title>
<link rel="stylesheet" type="text/css" href="css/checks.css">
</head>
<body>
	<div class="nav_all">
		<div class="nav">
			<div class="nav_left">

				<ul class="nav_ul">
					<li><a href="index">首页</a></li>
					<li><a href="disease">疾病百科</a></li>
					<li><a href="checks">疾病检查</a></li>
					<li><a href="drugs">药品百科</a></li>

				</ul>
			</div>
			<div class="nav_right">
				<div class="nav_right_input">
					<input type="text" class="nav_r_input" placeholder="疾病/检查/药品"
						onmouseout="go_ask(this)" /> <input type="button"
						class="nav_r_button" value="搜索" />
				</div>
				<a href="http://ask.39.net/addtopic.aspx" class="go_ask">问医生</a>
			</div>
		</div>
	</div>
	<div class="webway">
		<i> <a href="index">首页 &gt; </a> <a href="#">疾病检查 </a>
		</i>
	</div>
	<div class="container">
		<c:if test="${!listisnull }">

			<!--//疾病列表-->
			<div class="listSicks">
				<h1>呼吸内科</h1>
				<div class="listSicks-item">
					<ul>

						<c:forEach items="${list }" var="che">
							<li><a href="checkDetails?id=${che.id }" target="_blank">${che.name }</a></li>

						</c:forEach>


						<!-- <li><a href="巴氏或H-E染色检查.html" title="巴氏或H-E染色检查"
						target="_blank">巴氏或H-E染色检查</a></li> -->


					</ul>
				</div>
				<div>
					<form action="drugs" method="post">

						<input type="button" value="上一页"
							onclick="location='checks?page=${page-1<0?0:page-1}'"> <input
							type="button" value="下一页"
							onclick="location='checks?page=${pageok==true?page+1:page}'">>
					</form>
				</div>
			</div>
		</c:if>
	</div>
</body>
</html>