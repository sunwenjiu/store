<%@page import="entity.DiseaseEntity"%>
<%@page import="java.util.List"%>
<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>

<html lang="en">
<head>
<meta charset="UTF-8">
<!-- 是第一次访问drugs.jsp就走这里，然后自动跳转 -->
<c:if test="${list==null }" var="listisnull">
	<meta http-equiv="refresh" content="0;url=disease">
</c:if>

<title>疾病百科</title>
<link rel="stylesheet" type="text/css" href="css/disease.css">
</head>
<body>
	<div class="nav_all">
		<div class="nav">
			<div class="nav_left">

				<ul class="nav_ul">
					<li><a href="index">首页</a></li>
					<li><a href="disease">疾病百科</a></li>
					<li><a href="checks">检查</a></li>
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
		<i> <a href="index">首页 &gt; </a> <a href="disease">疾病百科 </a>
		</i>
	</div>
	<div class="container">
		<!--//疾病列表-->
		<!-- 用户直接访问disease.jsp是不会显示下面的 -->
		<c:if test="${!listisnull }">


			<div class="listSicks">
				<h1>呼吸内科</h1>
				<div class="listSicks-item">
					<ul>


						<c:forEach items="${list }" var="dis">
							<li><a href="aspi?no=${dis.no }" target="_blank">${dis.name }</a></li>

						</c:forEach>




					</ul>
				</div>
				<!-- 添加翻页的代码 点下一页后，提交给disease来
        处理，需要传入三个值，1和2是 limit查询用，
        3是给disease后又返回的当前页数，检查3用1和2的来转换是否方便
        点击按钮会执行方法，方法将值传给servlet?
          -->
				<div>
					<form action="disease" method="post">

						<input type="button" value="上一页"
							onclick="location='disease?page=${page-1<0?0:page-1}'"> <input
							type="button" value="下一页"
							onclick="location='disease?page=${pageok==true?page+1:page}'">>
					</form>
				</div>
			</div>


		</c:if>
	</div>

</body>
</html>