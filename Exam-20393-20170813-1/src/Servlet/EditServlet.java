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

public class EditServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int film_id = Integer.parseInt(req.getParameter("film_id"));
		String title = req.getParameter("title");
		String description = req.getParameter("description");
		String language = req.getParameter("language");
		Connection conn = DB.getConn();
		PreparedStatement pstmt = DB.prepareStmt(conn, "update film set title = ? ,description = ?,language = ? where film_id = ?");
		try {
			pstmt.setString(1, title);
			pstmt.setString(2, description);
			pstmt.setString(3, language);
			pstmt.setInt(4,film_id);
			pstmt.executeUpdate(); 
		} catch (SQLException e) {
			e.printStackTrace();
		}
		DB.close(pstmt);
		DB.close(conn);
		resp.sendRedirect(req.getContextPath() + "/show.jsp");
	}

}
