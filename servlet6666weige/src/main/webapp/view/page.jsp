<%@page import="entity.Hero"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Hero</title>
<link href="css/bootstrap.min.css" rel="Stylesheet">
<script type="text/javascript" src="js\jquery.min.js"></script>
<script type="text/javascript" src="js\bootstrap.min.js"></script>
<style type="text/css">
.msg_erro{
color: red;
}
.msg_succ{
color: green;
}

</style>
</head>
<body>
	<div class="table-responsive">
		<table class="table">
			<thead>
				<tr>
					<th>ID</th>
					<th>姓名</th>
					<th>昵称</th>
					<th>性别</th>
					<th>台词</th>
					<th>阵营</th>
					<th>属性</th>
					<th>操作</th>
				</tr>
			</thead>
			<tbody>
		
			<c:forEach items="${heros}" var="hero" >
			<tr>
					<td>${hero.id }</td>
					<td>${hero.name }</td>
					<td>${hero.nickname }</td>
					<td>${hero.sex }</td>
					<td>${hero.language }</td>
					<td>${hero.camp }</td>
					<td>${hero.type } </td>
					<td class="col-md-2">
						<button type="button" class="btn btn-danger col-md-5">删除</button>
						<button type="button"
							class="btn btn-warning col-md-5 col-md-offset-2 update"
							data-toggle="modal" data-target="#myModal">修改</button>
					</td>
				</tr>
			</c:forEach>
			</tbody>
		</table>
		<c:forEach begin="1" end="${button }" step="1" var="i" >
		<a href="page.do?page=${i }">第${i }页</a>
		</c:forEach>
		
		
	</div>
</body>
<div class="modal fade" id="myModal" tabindex="-1" role="dialog"
	aria-labelledby="myModalLabel" aria-hidden="true" >
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal"
					aria-hidden="true">&times;</button>
				<h4 class="modal-title" id="myModalLabel">信息修改</h4>
			</div>
			<div class="modal-body">
				<form class="form-horizontal" role="form" action="update.do" method="post" onsubmit="return checkNickName()+checkName()+checkCamp()==3">
					<div class="form-group">
						<label class="col-sm-2 control-label">ID</label>
						<div class="col-sm-5">
							<input type="text" class="form-control" id="id"
								readonly="readonly" name="id">
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-2 control-label">名字</label>
						<div class="col-sm-5">
							<input type="text" class="form-control" name="name" id="name" onblur="checkName()">
						</div>
						<div class="col-sm-5">
							<span id="msg_name"></span>
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-2 control-label">昵称</label>
						<div class="col-sm-5">
							<input type="text" class="form-control" name="nickname" id="nickname" onblur="checkNickName()">
						</div>
						<div class="col-sm-5">
							<span id="msg_nickname"></span>
						</div>
					</div>
					<div class="form-group">
						<label  class="col-sm-2 control-label">性别</label>
						<div class="col-sm-5">
							<input name="sex"  class="sex" type="radio" value="男" />男 
							<input name="sex" class="sex" type="radio" value="女"/>女
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-2 control-label">阵营</label>
						<div class="col-sm-5">
							<select id="camp" name="camp"  onblur="checkCamp()">
								<option value="-1">请选择</option>
								<option value="德玛西亚">德玛西亚</option>
								<option value="战争学院">战争学院</option>
								<option value="艾欧尼亚">艾欧尼亚</option>
								<option value="洛克萨斯">洛克萨斯</option>
								<option value="均衡教派">均衡教派</option>
								<option value="班德尔城">班德尔城</option>
								<option value="弗雷尔卓德">弗雷尔卓德</option>
								<option value="皮尔特沃夫">皮尔特沃夫</option>
								<option value="巨神峰">巨神峰</option>
							</select> 
						</div>
						<div class="col-sm-5">
							<span id="msg_camp"></span>
						</div>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
						<button type="submit" class="btn btn-primary">保存</button>
					</div>
				</form>
			</div>

		</div>
		<!-- /.modal-content -->
	</div>
	<!-- /.modal-dialog -->
</div>
<!-- /.modal -->
<script type="text/javascript">
$(function(){
	$(".update").click(function(){
		var id=$(this).parent().siblings("td:eq(0)").text();
		var name=$(this).parent().siblings("td:eq(1)").text();
		var nickname=$(this).parent().siblings("td:eq(2)").text();
		var sex=$(this).parent().siblings("td:eq(3)").text();
		if(sex=="男"){
			$(".sex:eq(0)").prop("checked",true);
			$(".sex:eq(1)").prop("checked",false);
		}else{
			$(".sex:eq(1)").prop("checked",true);
			$(".sex:eq(0)").prop("checked",false);
		}
		$("#id").val(id);
		$("#name").val(name);
		$("#nickname").val(nickname);
	});
});
function checkNickName(){
	var name=$("#nickname").val();
	if(name.length<2 || name.length>8){
		$("#msg_nickname").text("名字不合法");
		$("#msg_nickname").attr("class","msg_erro");
		return false;
	}else{
		$("#msg_nickname").text("名字合法");
		$("#msg_nickname").attr("class","msg_succ");
		return true;
	}
}  
function checkName(){
	var name=$("#name").val();
	if(name.length<2 || name.length>8){
		$("#msg_name").text("昵称不合法");
		$("#msg_name").attr("class","msg_erro");
		return false;
	}else{
		$("#msg_name").text("昵称合法");
		$("#msg_name").attr("class","msg_succ");
		return true;
	}
}

function checkCamp(){
	  var spec=$("#camp").val();
	 if (spec!=-1){
		 $("#msg_camp").html("正确");
		 $("#msg_camp").attr("class","msg_succ");
		 return true;
	 }else {
		 $("#msg_camp").html("请选择阵营");
		 $("#msg_camp").attr("class","msg_erro");
		 return false;
	}
}
</script>
</html>