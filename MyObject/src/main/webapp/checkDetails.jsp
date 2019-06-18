<%@ page   pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>${requestScope.che.name }</title>
    <link rel="stylesheet" type="text/css" href="css/liFeiPian.css">
</head>
<body>
     <div class="nav_all">
        <div class="nav">
            <div class="nav_left">
                
                <ul class="nav_ul">
                    <li><a href="index">首页</a></li>
                    <li><a href="disease">疾病百科</a></li>
                    <li><a href="checksl">疾病检查</a></li>
                    <li><a href="drugs">药品百科</a></li>
                    
                </ul>
            </div>
            <div class="nav_right">
                <div class="nav_right_input">
                    <input type="text" class="nav_r_input" placeholder="疾病/检查/药品" onmouseout="go_ask(this)" />
                    <input type="button" class="nav_r_button" value="搜索" />
                </div>
                <a href="http://ask.39.net/addtopic.aspx" class="go_ask">问医生</a>
            </div>
        </div>
        </div>
        <div class="webway">
     <i>
        <a href="index">首页 &gt;</a>
         <a href="checks">疾病检查 &gt;</a>
         <a href="#">${requestScope.che.name }</a>
        
    </i>
        </div>
        <div class="title">
        <h1>${requestScope.che.name }</h1>
        </div>
        <div class="container">
          <div class="left-container">
       
       
        <div class="left-title">
            <h2><span class="title-prefix">${requestScope.che.name }</span>注意事项</h2>
            <div class="left-title-line"></div>
        </div>

        <ul class="left-jiuzhentishi">
            
            <li><i>不适宜人群：</i></li>
            <li>${requestScope.che.unsuitable }</li>
        
         
        </ul>
       </div> 
        
    </div>
</body>
</html>