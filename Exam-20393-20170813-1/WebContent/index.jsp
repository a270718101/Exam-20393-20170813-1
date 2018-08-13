<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>主页面</title>
</head>
<body>
<p><a href="login.jsp" style="text-decoration:none">用户登录页面</a>
<p><a href="show.jsp" style="text-decoration:none">列表显示页面</a>
<p><a href="add.jsp" style="text-decoration:none">新增页面</a>

<%
	String flag = "";
	Object obj = session.getAttribute("flag");
	if(obj != null){
		flag = obj.toString();
	}
	if(flag.equals("login_success")){
%>
	<p><a href="<%=request.getContextPath() %>/logout" style="text-decoration:none">退出</a>
<%} else{%> 
	<p><a href="<%=request.getContextPath() %>/login.jsp" style="text-decoration:none">登陆</a>
<%} %>
</body>
</html>