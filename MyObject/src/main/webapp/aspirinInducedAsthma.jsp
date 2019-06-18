<%@page import="entity.DiseaseEntity"%>
<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<title>${requestScope.dis.name }</title>

<link rel="stylesheet" type="text/css"
	href="css/aspirinInducedAsthma.css">
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
		<i> <a href="index">首页 &gt;</a> <a href="disease">疾病百科 &gt;</a> <a
			href="#">${requestScope.dis.name }</a>

		</i>
	</div>
	<div class="title">
		<h1>${requestScope.dis.name }</h1>
	</div>
	<div class="container">
		<div class="left-container">
			<div class="left-title">
				<h2>
					<span class="title-prefix">${requestScope.dis.name }</span>基本知识
				</h2>
				<div class="left-title-line"></div>
			</div>
			<div class="left-baseinfo">
				<table>
					<tr>
						<td class="baseinfo-left"><i>发病部位：</i>
							${requestScope.dis.buwei }</td>
						<td><i>患病比例：</i>${requestScope.dis.percent }</td>
					</tr>
					<tr>
						<td class="baseinfo-left"><i>发病季节：</i>
							${requestScope.dis.seson }</td>
						<td><i>是否传染：</i> ${requestScope.dis.acctive }</td>
					</tr>
					<tr>
						<td class="baseinfo-left"><i>易感人群：</i>
							${requestScope.dis.people }</td>
						<td><i>传染方式：</i> ${requestScope.dis.way }</td>
					</tr>

				</table>
			</div>
			<!--基本信息 结束-->

			<!--就诊提示 开始-->
			<div class="left-title">
				<h2>
					<span class="title-prefix">${requestScope.dis.name }</span>就诊提示
				</h2>
				<div class="left-title-line"></div>
			</div>

			<ul class="left-jiuzhentishi">
				<li><i>就诊科室：</i>${requestScope.dis.keshi }</li>
				<li><i>是否医保：</i>${requestScope.dis.yibao }</li>
				<li><i>治疗周期：</i>${requestScope.dis.time }</li>
				<li><i>治疗费用：</i>${requestScope.dis.money }</li>
				<li><i> 治愈率：</i>${requestScope.dis.zhiyu }</li>

			</ul>
			<!--就诊提示 结束-->

			<!--温馨提示 开始-->
			<div class="left-title">
				<h2>
					<span class="title-prefix">${requestScope.dis.name }</span>护理
				</h2>
				<div class="left-title-line"></div>
			</div>

			<ul class="left-tips">
				<li>${requestScope.dis.care }</li>
			</ul>
			<div class="left-title">
				<h2>
					<span class="title-prefix">${requestScope.dis.name }</span>康复饮食
				</h2>
				<div class="left-title-line"></div>
			</div>

			<ul class="left-tips">
				<li>${requestScope.dis.diet }</li>
			</ul>
			<div class="left-title">
				<h2>
					<span class="title-prefix">${requestScope.dis.name }</span>饮食禁忌
				</h2>
				<div class="left-title-line"></div>
			</div>

			<ul class="left-tips">
				<li>${requestScope.dis.ban}</li>
			</ul>
		</div>
	</div>
</body>
</html>