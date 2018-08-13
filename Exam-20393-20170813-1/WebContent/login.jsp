<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>用户登陆页面</title>
<script type="text/javascript">
	function check(form){
		if(document.forms.loginForm.uname.value==""){
			alert("请输入用户名！");
			document.forms.loginForm.uname.focus();
			return false;
		}
		if(document.forms.loginForm.upwd.value==""){
			alert("请输入密码！");
			document.forms.loginForm.upwd.focus();
			return false;
		}
	}
</script>
</head>
<body>
	<form action="<%= request.getContextPath()%>/login" method="get">
	<%if(request.getAttribute("return_url")!=null){%>
		<input type="hidden" name="return_url" value="<%=request.getAttribute("return_url")%>"/>
	<%}%>
		userName:<input type="text" name="uname" /><br/>
		password:<input type="password" name="upwd" /><br/>
		<input type="submit" value="Login"/>
		<input type="reset" value="Reset"/>
	</form>
</body>
</html>