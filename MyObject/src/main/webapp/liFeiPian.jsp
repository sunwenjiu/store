<%@page import="entity.DrugsEntity"%>
<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>${requestScope.dru.name }</title>
<link rel="stylesheet" type="text/css" href="css/liFeiPian.css">
</head>
<body>
	<div class="nav_all">
		<div class="nav">
			<div class="nav_left">

				<ul class="nav_ul">
					<li><a href="index">首页</a></li>
					<li><a href="dis">疾病百科</a></li>
					<li><a href="#">检查</a></li>
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
		<i> <a href="index">首页 &gt;</a> <a href="drugs">药品百科 &gt;</a> <a
			href="#">${requestScope.dru.name }</a>

		</i>
	</div>
	<div class="title">
		<h1>${requestScope.dru.name }</h1>
	</div>
	<div class="container">
		<div class="left-container">


			<div class="left-title">
				<h2>
					<span class="title-prefix">${requestScope.dru.name }</span>说明书
				</h2>
				<div class="left-title-line"></div>
			</div>

			<ul class="left-jiuzhentishi">
				<li><i>主要成分：</i>${requestScope.dru.basis }</li>
				<li><i>适应症：</i>${requestScope.dru.indication }</li>
				<li><i>用法用量：</i>${requestScope.dru.dosage }</li>
				<li><i>不良反应：</i>${requestScope.dru.reaction }</li>
				<li><i>注意事项：</i>${requestScope.dru.attentions }</li>
				<li><i>禁忌：</i>${requestScope.dru.taboo }</li>
				<li><i>剂型：</i>${requestScope.dru.dosage_forms }</li>
				<li><i>性状：</i>${requestScope.dru.yao_character }</li>
				<li><i>贮藏：</i>${requestScope.dru.store }</li>
				<li><i>有效期：</i>${requestScope.dru.effective }个月</li>
			</ul>
		</div>

	</div>
</body>
</html>