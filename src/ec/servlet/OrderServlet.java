package ec.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ec.bean.CartBean;
import ec.bean.CustomerBean;
import ec.dao.DAOException;
import ec.dao.OrderDAO;


@WebServlet("/OrderServlet")
public class OrderServlet extends HttpServlet {


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		HttpSession session=request.getSession(false);
		if(session==null) {
			request.setAttribute("message", "セッションが切れています。もう一度トップページより操作してください。");
			gotoPage(request,response,"/errInternal.jsp");
			return;
		}
		CartBean cart=(CartBean)session.getAttribute("cart");
		if(cart==null) {
			request.setAttribute("message", "正しく操作してください。");
			gotoPage(request,response,"/errInternal.jsp");
			return;
		}

		try {
			String action=request.getParameter("action");
			if(action==null||action.length()==0||action.equals("input_customer")) {
				gotoPage(request,response,"/customerInfo.jsp");
			}else if(action.equals("confirm")) {
				String Name=request.getParameter("name");
				String Address=request.getParameter("address");
				String Tel=request.getParameter("tel");
				String Email=request.getParameter("email");

				if(Name==null||Name.length()==0||Address==null||Address.length()==0
						||Tel==null||Tel.length()==0||Email==null||Email.length()==0) {
					request.setAttribute("message", "全ての項目を正しく入力してください。");
					RequestDispatcher rd=request.getRequestDispatcher("/errInternal.jsp");
					rd.forward(request, response);
					return;
				}
				CustomerBean bean=new CustomerBean();
				bean.setName(Name);
				bean.setAddress(Address);
				bean.setTel(Tel);
				bean.setEmail(Email);
				session.setAttribute("customer",bean);
				gotoPage(request,response,"/confirm.jsp");
			}else if(action.equals("order")) {
				CustomerBean customer=(CustomerBean)session.getAttribute("customer");
				if(customer==null) {
					request.setAttribute("message", "正しく操作してください。");
					gotoPage(request,response,"/errInternal.jsp");
				}

				OrderDAO order=new OrderDAO();
				int orderNumber=order.saveOrder(customer,cart);
				session.removeAttribute("cart");
				session.removeAttribute("customer");
				request.setAttribute("orderNumber", new Integer(orderNumber));
				gotoPage(request,response,"/order.jsp");
			}else {
				request.setAttribute("message", "正しく操作してください。");
				gotoPage(request,response,"/errInternal.jsp");
			}
		}catch(DAOException e) {
			e.printStackTrace();
			request.setAttribute("message", "内部エラーが発生しました。");
			gotoPage(request,response,"/errInternal.jsp");
		}
	}

	private void gotoPage(HttpServletRequest request,HttpServletResponse response,String page) throws
		ServletException,IOException{
		RequestDispatcher rd=request.getRequestDispatcher(page);
		rd.forward(request,response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
