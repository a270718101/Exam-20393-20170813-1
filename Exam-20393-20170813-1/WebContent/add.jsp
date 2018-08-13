<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>新增页面</title>
</head>
<body>
<form action="<%= request.getContextPath()%>/edit" method="get">
		电影主题： <input type="text" name="title" > <br> 
		电影描述：<textarea name="description" rows="15" cols="80"></textarea>
		电影语言： <input type="text" name="language" > <br> 
		电影语言：	<select>
					<option>请选择</option>
					<option>11</option>
					<option>22</option>
					<option>33</option>
					<option>44</option>
				</select>
		<br> <input type="submit" value="submit" />
	</form>
</body>
</html>