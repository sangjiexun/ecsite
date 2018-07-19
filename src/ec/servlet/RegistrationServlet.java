package ec.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ec.dao.DAOException;
import ec.dao.RegistrationDAO;

@WebServlet("/RegistrationServlet")
public class RegistrationServlet extends HttpServlet {


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();

		String action = request.getParameter("action");

		if (action.equals("AllnewDateAdd")) {

			String Name = request.getParameter("name");
			String Address = request.getParameter("address");
			String Gender = request.getParameter("gender");
			if(Gender.equals("m")){
				Gender = "男";
			} else {
				Gender = "女";
			}
			String Tel = request.getParameter("tel");
			String loginID = request.getParameter("user_id");
			String passWord = request.getParameter("password");

			if(Name==null||Name.length()==0||Address==null||Address.length()==0
					||Gender==null||Gender.length()==0||Tel==null||Tel.length()==0
					||loginID==null||loginID.length()==0||passWord==null||passWord.length()==0) {
				request.setAttribute("message", "全ての項目を正しく入力してください。");
				RequestDispatcher rd=request.getRequestDispatcher("/errInternal.jsp");
				rd.forward(request, response);
				return;
			}

			HttpSession session = request.getSession();
			session.setAttribute("name", Name);
			session.setAttribute("gender", Gender);
			session.setAttribute("address", Address);
			session.setAttribute("tel", Tel);
			session.setAttribute("user_id", loginID);
			session.setAttribute("password", passWord);



			RegistrationDAO dao;
			try {
				dao = new RegistrationDAO();


				if (dao.AllnewDataAdd(Name,Address, Tel, Gender, loginID, passWord) == 1) {

					HttpSession session2 = request.getSession();
					session2.setAttribute("", "true");
					out.println("<html><head><title>true</title></head><body>");
					out.println("<h1>新規登録完了</h1>");
					out.println("<p><a href=startPage.jsp>ログイン画面に入る</a></p>");
					out.println("</body></html>");
				} else {
					out.println("<html><head><title>error</title></head><body>");
					out.println("<h1>登録できませんでした。もう一度やり直してください。</h1>");
					out.println("<p><a href=registration.jsp>新規登録画面に戻る</a></p>");
					out.println("</body></html>");
				}

			} catch (DAOException e) {
				e.printStackTrace();
			}

		} else {
			response.sendRedirect("/ecsite/registration.jsp");
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
