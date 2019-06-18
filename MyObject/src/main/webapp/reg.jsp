<%@ page     pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>新用户注册</title>
   <link rel="stylesheet" type="text/css" href="css/reg.css">
</head>
<body>
    <div class="main">
      <div class="master">
<!--       enctype="multipart/form-data" form加这个属性，获取不到input的值 --> 
          <form  action="addUser" method="post">
            <p class="headline">注册新用户</p>
            <br/>
            <span class="p">*</span>
            <label class="l">用户名:&nbsp;&nbsp;&nbsp;&nbsp;
            </label><input name="username" id="name" type="text" value="${username }" placeholder="社保卡号/就诊卡号" onmouseout="go_ask(this)">
          
            
            <span style="color: red;">${msg } </span>
           <!-- 这一行试了效果看着是废的没用 --> <span style="position:absolute;right:18px;top:2px;background-image:url(user.ico);height:16px;width:16px;display:inline-block;" ></span>
             <br/><br/>
            <span class="p">*</span>
           <label   class="l">电话号码:</label>
            <input id="phone" name="tel" type="text" value="${tel }" placeholder="请输入电话">
            <br/><br/>
            <span class="p">*</span>
            <label for="login_password" class="l">登录密码:</label>
             <input id="login" type="password" name="password" class="i">
             <br/><br/>
            <span class="p">*</span>
            <label for="confirm_password" class="l">确认密码:</label>
             <input id="confirm" type="password" class="i">
             <br/><br/>
            
            <p class="bstyle"><input type="checkbox" name="agree" />我已阅读并同意《用户注册协议》</p>
            <br/><br/>
<!--             <a href="登录.html"class="big button blue">同意以上协议并注册</a> -->          

  <input type="submit" value="注册" class="big button blue">
             </form>
     </div>
    

    </div>
 </body>

</html>
<SCRIPT Language=VBScript><!--

//--></SCRIPT>