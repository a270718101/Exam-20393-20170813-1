package Servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Bean.DB;

public class AddServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req,resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String title = req.getParameter("title");
		String description = req.getParameter("description");
		String language = req.getParameter("language");
		Connection conn = DB.getConn();
		String sql = "insert into film  (title,description,language) values ('?',''?',''?')";
		PreparedStatement pstmt = DB.prepareStmt(conn, sql);
		System.out.println(sql);
		try {
			pstmt.setString(1, title);
			pstmt.setString(2, description);
			pstmt.setString(3, language);
			pstmt.executeUpdate(); 
		} catch (SQLException e) {
			e.printStackTrace();
		}
		DB.close(pstmt);
		DB.close(conn);
		resp.sendRedirect(req.getContextPath() + "/index.jsp");
	}

}
