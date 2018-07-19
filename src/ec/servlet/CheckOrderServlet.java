package ec.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ec.bean.CustomerBean;
import ec.bean.OrderedBean;
import ec.dao.CheckOrderDAO;
import ec.dao.DAOException;


@WebServlet("/CheckOrderServlet")
public class CheckOrderServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String action=request.getParameter("action");

		try {
			if(action.equals("customer")) {
				CheckOrderDAO dao=new CheckOrderDAO();
				List<CustomerBean> list=dao.findCustomerInfo();
				request.setAttribute("customer", list);
				gotoPage(request,response,"/orderedItems.jsp");

			}else if(action.equals("itemsDetail")) {
				String getCode=request.getParameter("orderedCode");
				if(getCode==null||getCode.length()==0) {
					request.setAttribute("message", "正しく入力してください。");
					RequestDispatcher rd=request.getRequestDispatcher("/errInternal.jsp");
					rd.forward(request, response);
					return;
				}
				try {
				int orderedCode=Integer.parseInt(getCode);
				CheckOrderDAO dao=new CheckOrderDAO();
				List<OrderedBean> list=dao.findItemsByOrderedCode(orderedCode);
				request.setAttribute("items", list);
				gotoPage(request,response,"/viewOrderedItems.jsp");
				}catch(NumberFormatException e) {
					e.printStackTrace();
					request.setAttribute("message", "半角で入力してください。");
					gotoPage(request,response,"/errInternal.jsp");

				}

			}
		}catch(DAOException e) {
			e.printStackTrace();
			request.setAttribute("message", "内部エラーが発生しました。");
			gotoPage(request,response,"/errInternal.jsp");
		}
	}

	private void gotoPage(HttpServletRequest request, HttpServletResponse response, String page)throws ServletException,IOException{
		RequestDispatcher rd=request.getRequestDispatcher(page);
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
