package Servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8880779722091371571L;

//	@Override
//	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		String userName = req.getParameter("uname");
//		String password = req.getParameter("upwd");
//		
//		System.out.println("用户名 ==>>" + userName); 
//		System.out.println("密码==>>" + password);
//		
//	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String userName = req.getParameter("uname");
		String password = req.getParameter("upwd");
		
		System.out.println("====进入doGet方法====");
		System.out.println("用户名 ==>>" + userName);
		System.out.println("密码==>>" + password);
		doPost(req,resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String userName = req.getParameter("uname");
		String password = req.getParameter("upwd");
		String return_url = req.getParameter("return_url");
		
		System.out.println("====进入doPost方法====");
		System.out.println("用户名 ==>>" + userName);
		System.out.println("密码==>>" + password);
		System.out.println("return_url==>>" + return_url);
		
		RequestDispatcher rd = null;
		if(userName == null || password == null) {
			req.setAttribute("msg","用户名或密码为空！！！");
			rd = req.getRequestDispatcher("/login.jsp");
			rd.forward(req, resp);
		}else {
			if(userName.equals("xuqinren") && password.equals("123456")) {
				req.getSession().setAttribute("flag", "login_success");	
			if(return_url != null) {
				rd = req.getRequestDispatcher(return_url);
				rd.forward(req, resp);
			}else {
				rd = req.getRequestDispatcher("/index.jsp");
				rd.forward(req, resp);
			}
		}else {
			req.getSession().setAttribute("flag", "login_error");
			req.setAttribute("msg", "用户名或密码输入错误");
			rd = req.getRequestDispatcher("/login.jsp");
			rd.forward(req, resp);
		}
	}
	

//		String forward = null;
//		if(userName.equals("xuqinren") && password.equals("123456")) {
//			//请求转发 
//			forward = "/success.jsp"; //转发的地址
//			//请求调度器 封装了转发的方法
//			RequestDispatcher rd = req.getRequestDispatcher(forward);			
//			rd.forward(req, resp);
//			
//			
//			//请求重定向
//			//使用重定向无法获取表单提交的数据
//		//	resp.sendRedirect(req.getContextPath() + "/success.jsp");
//		}else {
//			//请求转发 
//			forward = "/error.jsp";
//			RequestDispatcher rd = req.getRequestDispatcher(forward);			
//			rd.forward(req, resp);
//		//	resp.sendRedirect(req.getContextPath() + "/error.jsp");
//		}
		
	}

}
