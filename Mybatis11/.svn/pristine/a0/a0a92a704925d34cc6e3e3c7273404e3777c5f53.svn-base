<!DOCTYPE html>
<html>
<head>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<meta charset="UTF-8">
<title>注册</title>
<link rel="stylesheet" type="text/css" href="../css/bootstrap.css">
<script type="text/javascript" src="../js/jquery-1.11.1.js"></script>
<script type="text/javascript" src="../js/bootstrap.js"></script>
<style type="text/css">
.msg-error {
	color: red;
	font-size: 12px;
	margin-left: 90px;
	height: 25px;
}

.msg-success {
	color: green;
	font-size: 12px;
	margin-left: 90px;
	height: 25px;
}
</style>
</head>
<body>
	<form class="form-horizontal" role="form">
		<div class="form-group">
			<label for="inputEmail3" class="col-sm-2 control-label">ID</label>
			<div class="col-sm-3">
				<input type="text" class="form-control" id="id" onblur="checkId()">
			</div>
			<div class="col-sm-3">
				<span id="msg_id"></span>
			</div>
		</div>
		<div class="form-group">
			<label for="inputPassword3" class="col-sm-2 control-label">名字</label>
			<div class="col-sm-3">
				<input type="text" class="form-control" id="name">
			</div>
			<div class="col-sm-3">
				<span id="msg_name"></span>
			</div>
		</div>
		<div class="form-group">
			<label for="inputPassword3" class="col-sm-2 control-label">密码</label>
			<div class="col-sm-3">
				<input type="password" class="form-control" id="password">
			</div>
			<div class="col-sm-3">
				<span id="msg_pwd"></span>
			</div>
		</div>
		<div class="form-group">
			<label class="col-sm-2 control-label">部门</label>
			<div class="col-sm-3">
				<select id="camp" id="camp" onblur="checkCamp()">
					<option value="-1">请选择</option>
					<option value="0002">总部</option>
					<option value="0001">信息部</option>
				</select>
			</div>
			<div class="col-sm-3 ">
				<span id="msg_camp"></span>
			</div>
		</div>
		<div class="form-group ">
		<div class="col-sm-3 control-label" >
			<img src="code.do" onclick="this.src='code.do?'+new Date().getTime();">
		</div> 
		<div class="col-sm-3">
			<input type="text" placeholder="验证码" name="code">
		</div>
		</div>
		<div class="form-group">
			<div class="col-sm-offset-2 col-sm-10">
				<button type="submit" class="btn btn-default">提交</button>
			</div>
		</div>

	</form>
</body>
<script type="text/javascript">
	function checkId() {
		var a = $("#id").val();
		if (a == "") {
			$("#msg_id").html("id不能为空");
			$("#msg_id").attr("class", "msg-error");
			return false;
		} else if (a.length > 4) {
			$("#msg_id").html("id长度不能超过4");
			$("#msg_id").attr("class", "msg-error");
			return false;
		} else {
			$("#msg_id").html("id格式正确");
			$("#msg_id").attr("class", "msg-success");
			$.ajax({
				url : "../user/checkId.do",
				data : "id=" + $("#id").val(),
				type : "get",
				dataType : "json",
				success : function(obj) {
					//显示服务器的响应信息
					$("#msg_id").html(obj.message);
					if (obj.state == 0) {
						$("#msg_id").attr("class", "msg-error");
					} else {
						$("#msg_id").attr("class", "msg-success");
					}
				}
			});
			return true;
		}
	}
</script>
</html>