package ec.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ec.dao.DAOException;
import ec.dao.LoginDAO;


@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");

		String action=request.getParameter("action");

		if(action.equals("login")) {

			String name=request.getParameter("name");
			String passWord=request.getParameter("pw");
			LoginDAO dao;
			try {
				dao=new LoginDAO();

				if(dao.checkLoginmember(name, passWord)) {
					HttpSession session=request.getSession();
					session.setAttribute("isLogin", "true");


					request.getRequestDispatcher("/top.jsp").forward(request, response);

				}else {
					request.setAttribute("message", "IDもしくはパスワードを正しく入力してください。");
					RequestDispatcher rd=request.getRequestDispatcher("/errInternal.jsp");
					rd.forward(request, response);
					return;
				}
			}catch(DAOException e) {
				e.printStackTrace();
			}
		}else if(action.equals("logout")) {
			HttpSession session=request.getSession(false);
			if(session !=null) {
				session.invalidate();
				gotoPage(request,response,"/startPage.jsp");
			}
		}
	}

	private void gotoPage(HttpServletRequest request,HttpServletResponse response,String page)
			throws ServletException,
			IOException{
			RequestDispatcher rd=request.getRequestDispatcher(page);
			rd.forward(request, response);
		}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
