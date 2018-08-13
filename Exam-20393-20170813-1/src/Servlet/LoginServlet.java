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
//		System.out.println("�û��� ==>>" + userName); 
//		System.out.println("����==>>" + password);
//		
//	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String userName = req.getParameter("uname");
		String password = req.getParameter("upwd");
		
		System.out.println("====����doGet����====");
		System.out.println("�û��� ==>>" + userName);
		System.out.println("����==>>" + password);
		doPost(req,resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String userName = req.getParameter("uname");
		String password = req.getParameter("upwd");
		String return_url = req.getParameter("return_url");
		
		System.out.println("====����doPost����====");
		System.out.println("�û��� ==>>" + userName);
		System.out.println("����==>>" + password);
		System.out.println("return_url==>>" + return_url);
		
		RequestDispatcher rd = null;
		if(userName == null || password == null) {
			req.setAttribute("msg","�û���������Ϊ�գ�����");
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
			req.setAttribute("msg", "�û����������������");
			rd = req.getRequestDispatcher("/login.jsp");
			rd.forward(req, resp);
		}
	}
	

//		String forward = null;
//		if(userName.equals("xuqinren") && password.equals("123456")) {
//			//����ת�� 
//			forward = "/success.jsp"; //ת���ĵ�ַ
//			//��������� ��װ��ת���ķ���
//			RequestDispatcher rd = req.getRequestDispatcher(forward);			
//			rd.forward(req, resp);
//			
//			
//			//�����ض���
//			//ʹ���ض����޷���ȡ���ύ������
//		//	resp.sendRedirect(req.getContextPath() + "/success.jsp");
//		}else {
//			//����ת�� 
//			forward = "/error.jsp";
//			RequestDispatcher rd = req.getRequestDispatcher(forward);			
//			rd.forward(req, resp);
//		//	resp.sendRedirect(req.getContextPath() + "/error.jsp");
//		}
		
	}

}
