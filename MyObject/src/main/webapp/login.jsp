<%@ page     pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>用户登录</title>
	<link rel="stylesheet" type="text/css" href="css/login.css">
</head>
<body>
	<div class="container">
		<!-- 导航 -->
		<div class="nav">
			<ul>
				<li><a href="#">链接三</a></li>
				<li><a href="#">链接二</a></li>
				<li><a href="#">链接一</a></li>
				<li><a href="index">首页</a></li>
			</ul>
		</div>
 
		<!-- 主体内容 （登陆界面）-->
		<div class="main">
			<!-- 左侧信息栏 -->
			<div class="sideleft">
				<h1>呼吸内科住院患者健康指导</h1>
				<h4>互联网+医疗  改变健康教育模式</h4>
				</br></br></br>
				<p>精准推送、个体化管理</p>
				<p>提高住院患者临床路径下健康教育质量</p>
				
 
			</div>
			<!-- 右侧登陆界面 -->
			<div class="sideright">
				<div class="index">
					<form action="login" method="post">
						<p class="headline">用户登录</p>
						<p class="astyle">用户名：</p>
						<input type="text" name="username" value="${username }" placeholder="社保卡号/就诊卡号" onmouseout="go_ask(this)">
						
						<span style="color: red;">${msg}</span>
						<p class="astyle">密码：</p>
						<input type="password" name="password" placeholder="请输入密码"onmouseout="go_ask(this)">
				
						<!-- <a href="#"class="big button blue"> 登录 </a>  --> 
						<input type="submit" value="登录"  class="big button blue">
						<p class="bstyle"><input type="checkbox" name="rempas" />  记住密码</p>
						<p class="cstyle">忘记密码</p>
						</br></br>
						<p class="cstyle">没有账号？<a href="reg.jsp">立即注册</a></p>
					</form>
 
				</div>
			</div>
		</div>
 
		<!-- 尾部 -->
		<div class="footer">
				<ul>
					<li><a href="#">福建中医药大学</a></li>
					<li><a href="#">2015级信息管理与信息系统（医学信息方向）</a></li>
					<li><a href="#">3150707001</a></li>
					<li><a href="#">唐紫麒</a></li>
				</ul>
 
		</div>
 
	</div>
</body>
</html>
<SCRIPT Language=VBScript><!--

//--></SCRIPT>