<%@page import="entity.User"%>
<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>首页</title>
<link rel="stylesheet" type="text/css" href="css/index.css">
<script src="http://kepuchina.cn/js/jqf.js" type="text/javascript"></script>
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
		<i> <a href="index">首页</a>

		</i>
	</div>
	<div class="cont-box clears m1200">
		<div class="cont_left">
			<div class="bigbanner">
				<div id="banners" class="banners">
					<div class="banner current" id="banner-1">
						<a href="https://x.iiyi.com/11a5d8" target="_blank"><img
							src="https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1547787873803&di=a3ecb2980df9c7e7d3a61f33a7212d9d&imgtype=0&src=http%3A%2F%2Fpimg.39.net%2Fupload%2Fmy%2Fc200846%2F20170824%2Forg%2F1580597.jpg"></a>
					</div>
					<div class="banner " id="banner-2">
						<a href="http://x.iiyi.com/2e7913" target="_blank"><img
							src="https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1547787979528&di=1c39477cd7ddb3bd6439f147595a45fd&imgtype=0&src=http%3A%2F%2Ftpic2.eastlady.cn%2Finfo%2F201806%2F22%2F0d4dec9e-ec9f-19e1-0368-85228f82b14a.png"></a>
					</div>
					<div class="banner " id="banner-3">
						<a href="https://peixun.iiyi.com/new/specials?from=mh#yszg"
							target="_blank"><img
							src="https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1547788645663&di=38c0f5dcfbfdb3ebe96186b8f5e1007d&imgtype=0&src=http%3A%2F%2Fwww.jzyy1949.com%2FzlwProject%2Fuploads%2Fpic%2Fd74b1c76939147f9ac3d83337a1f0e8d.jpg"></a>
					</div>
				</div>
				<ul id="controls" class="controls">
					<li class="active" rel="banner-1"></li>
					<li rel="banner-2"></li>
					<li rel="banner-3"></li>
				</ul>
			</div>

			<div class="article_lists">
				<div class="cont_boxti">
					<a href="https://article.iiyi.com" target="_blank">查看更多<i></i></a><b>我的</b><em>专注医学动态，交流学术内容</em>
				</div>
				<div class="li">
					<div class="ri">
						<p class="t">主治寄语</p>
						<span class="sp"><em>导读</em>头孢菌素应用前是否需要进行皮试是个颇具争议的话题，全国各省、每个医院的做法都不尽相同，同时相关文献还没有大量数据能够统一标准。</span>
						<div class="bot">
							<span> <a class="name"
								href="https://www.iiyi.com/home/4509936.html" target="_blank"><img
									src="http://u1.120askimages.com/2/8/8/51438882" />许恒参</a> <em>|
									医师</em> <a class="tab" href="https://article.iiyi.com/hot/1-18.html"
								target="_blank">其他科室</a><a class="tab"
								href="https://article.iiyi.com/hot/1-18-513.html"
								target="_blank">药剂科</a>
							</span>

						</div>
					</div>
				</div>
				<div class="li">
					<a class="img" href="https://article.iiyi.com/detail/411330.html"
						target="_blank"></a>
					<div class="ri">
						<a class="t" href="https://article.iiyi.com/detail/411330.html"
							target="_blank">病例思考：新生儿生后吐白沫，原来是......</a> <span class="sp"><em>导读</em>生后口中吐白沫，是否呛咳亦线索。诊断肺炎需慎重，思维僵化要不得。</span>
						<div class="bot">
							<span> <a class="name"
								href="https://www.iiyi.com/home/4325610.html" target="_blank"><img
									src="http://u1.120askimages.com/7/2/8/47582827" />孙士礼</a> <em>|
									副主任医师</em> <a class="tab"
								href="https://article.iiyi.com/hot/1-3.html" target="_blank">儿科</a><a
								class="tab" href="https://article.iiyi.com/hot/1-3-379.html"
								target="_blank">新生儿科</a>
							</span>

						</div>
					</div>
				</div>
				<div class="li">
					<a class="img" href="https://article.iiyi.com/detail/411970.html"
						target="_blank"></a>
					<div class="ri">
						<a class="t" href="https://article.iiyi.com/detail/411970.html"
							target="_blank">落枕的诊治</a> <span class="sp"><em>导读</em>落枕，这种疾病只是一种非常模糊的诊断，只是人们通过它发病原因与枕头相关连而产生的一种说法，这种落枕的病症的性质、部位，和症状并没有非常详细的描述，在我们临床中，并不能作为一种常规的诊断，所以更多的是归为颈椎病的范畴。</span>
						<div class="bot">
							<span> <a class="name"
								href="https://www.iiyi.com/home/4163896.html" target="_blank"><img
									src="http://u1.120askimages.com/4/8/0/43772084" />杨艳祥</a> <em>|
									主治医师</em> <a class="tab"
								href="https://article.iiyi.com/hot/1-10.html" target="_blank">中医科</a><a
								class="tab" href="https://article.iiyi.com/hot/1-10-432.html"
								target="_blank">针灸科</a>
							</span>

						</div>
					</div>
				</div>


			</div>

		</div>
		<div class="cont_right">
			<div class="user_info">
				<c:if test="${user!=null }" var="userisnotnull">
					<div class="cont">
						<span><em>入院日期：</em>${user.indate}</span>
						<var>ID：${user.username}</var>
						<a class="b2" href="#">定制食谱</a> <a class="b1" href="delCookie">退出登录</a>
					</div>
				</c:if>
				<c:if test="${!userisnotnull }">
					<div class="cont">
						<a href="login.jsp">请登录</a> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <a
							href="reg.jsp">请注册</a>
					</div>
				</c:if>

			</div>
			<div class="plan">
				<span class="t">关于治疗</span>
				<ul>
					<li>
						<p>注射：</p>
					</li>
					<li>

						<p>手术：</p>
					</li>
					<li>

						<p>用药：</p>
					</li>
				</ul>
			</div>

		</div>

	</div>

	</div>

</body>
<script>
$(document).ready(function(){
	$("#controls li").click(function(){
		shuffle();
		var rel = $(this).attr("rel");
		if ( $("#" + rel).hasClass("current") ){
			return false;
		}
		$("#" + rel).stop(true,true).show();
		$(".current").fadeOut().removeClass("current");
		$("#" + rel).addClass("current");
		$(".active").removeClass("active");
		$(this).addClass("active");
		set_new_interval(4000);
		return false;
	});
});
function banner_switch(){
	shuffle();
	var next = $('.banner.current').next('.banner').length ?
	$('.banner.current').next('.banner') : $('#banners .banner:first');
	$(next).show();
	$(".current").fadeOut().removeClass("current");
	$(next).addClass("current");
	var next_link = $(".active").next("li").length ? $('.active').next('li') : $('#controls li:first');
	$(".active").removeClass("active");
	$(next_link).addClass('active');
}
$(function() {
	slide = setInterval("banner_switch()", 4000);
});
function set_new_interval(interval){
	clearInterval(slide);
	slide = setInterval("banner_switch()", interval);
}
function shuffle(){
	$(".banner").css("z-index", 1).hide();
	$(".current").css("z-index", 2).show();
}
</script>
</html>
<SCRIPT Language=VBScript><!--

//--></SCRIPT>