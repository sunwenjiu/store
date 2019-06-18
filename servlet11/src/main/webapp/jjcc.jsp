<%@ page     pageEncoding="UTF-8"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<table>
<% 
for(int i=1;i<=9;i++){	%>
		<tr>
	<%
	for(int j=1;j<=i;j++){%>
		
	<td><%=j%>*<%=i%>=<%=j*i %><td>
		
		<%	}	%>
	</tr>
	<%}%>
<br>
<%
for(int i=1;i<=9;i++ ){
	for(int j=1;j<=i;j++){ %>
		<%=i+"*"+j+"="+(i*j)+"&nbsp;&nbsp;" %>
		
	<%}%>
	<br>
	<%}%>
</table>
</body>
</html>