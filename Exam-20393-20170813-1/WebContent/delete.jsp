<%@ page pageEncoding="GB18030"%>
<%@ page import="java.sql.*, Bean.*, java.util.*"%>
<%
	String title = request.getParameter("title");
	System.out.println("title:" + title);
	System.out.println("1111");
	Connection conn = null;
	try {
		conn = DB.getConn();
		String sql = "DELETE FROM film WHERE title = '" + title + "'";
		System.out.println("sql:" + sql);
		DB.executeUpdate(conn, sql);
	} finally {
		DB.close(conn);
	}
	response.sendRedirect(request.getContextPath() + "/show.jsp");
%>