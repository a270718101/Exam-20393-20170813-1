<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>编辑页面</title>
</head>
<body>
<form action="<%= request.getContextPath()%>/edit" method="post">
		<input type="hidden" name="film_id" value="<%=request.getParameter("film_id") %>" /> 
		电影主题： <input type="text" name="title" value="<%=request.getParameter("title")%>"> <br> 
		电影描述：<textarea name="description" rows="15" cols="80"><%=request.getParameter("description") %></textarea>
		电影语言： <input type="text" name="language" value="<%=request.getParameter("language")%>"> <br> 
		<br> <input type="submit" value="submit" />
	</form>
</body>
</html>