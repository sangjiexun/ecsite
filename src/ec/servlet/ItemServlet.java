package ec.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ec.bean.ItemBean;
import ec.dao.DAOException;
import ec.dao.OrganizeItemsDAO;


@WebServlet("/ItemServlet")
public class ItemServlet extends HttpServlet {


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		try {
			request.setCharacterEncoding("UTF-8");

			String action=request.getParameter("action");

			OrganizeItemsDAO dao= new OrganizeItemsDAO();

			if(action==null||action.length()==0) {
				List<ItemBean> list=dao.findAll();
				request.setAttribute("items", list);
				gotoPage(request,response,"/organizeItems.jsp");

			}else if(action.equals("add")) {
				String strCategory=request.getParameter("category");
				String strPrice=request.getParameter("price");
				String name=request.getParameter("name");

				if(strCategory==null||strCategory.length()==0||strPrice==null||strPrice.length()==0
						||name==null||name.length()==0) {
					request.setAttribute("message", "正しく入力してください。");
					RequestDispatcher rd=request.getRequestDispatcher("/errInternal.jsp");
					rd.forward(request, response);
					return;
				}

				int category=Integer.parseInt(request.getParameter("category"));
				int price=Integer.parseInt(request.getParameter("price"));

				dao.addItem(category,name,price);

				List<ItemBean> list=dao.findAll();

				request.setAttribute("items", list);
				gotoPage(request,response,"/organizeItems.jsp");
			}

			else if(action.equals("sort")) {
				String key=request.getParameter("key");
				List<ItemBean> list;

				if(key.equals("price_asc")) {
					list=dao.sortPrice(true);
				}else {
					list=dao.sortPrice(false);
				}

				request.setAttribute("items", list);
				gotoPage(request,response,"/organizeItems.jsp");
			}

			else if(action.equals("search")) {
				String strPrice=request.getParameter("price");

				if(strPrice==null||strPrice.length()==0) {
					request.setAttribute("message", "正しく入力してください。");
					RequestDispatcher rd=request.getRequestDispatcher("/errInternal.jsp");
					rd.forward(request, response);
					return;
				}

				int price=Integer.parseInt(strPrice);
				List<ItemBean> list=dao.findByPrice(price);

				request.setAttribute("items", list);
				gotoPage(request,response,"/organizeItems.jsp");
			}

			else if(action.equals("delete")) {
				String strCode=request.getParameter("code");

					if(strCode==null||strCode.length()==0) {
						request.setAttribute("message", "正しく入力してください。");
						RequestDispatcher rd=request.getRequestDispatcher("/errInternal.jsp");
						rd.forward(request, response);
						return;
					}

				int code=Integer.parseInt(strCode);

				dao.deleteByPrimaryKey(code);

				List<ItemBean> list=dao.findAll();

				request.setAttribute("items", list);
				gotoPage(request,response,"/organizeItems.jsp");
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

	private void gotoPage(HttpServletRequest request, HttpServletResponse response, String page)throws ServletException,IOException{
		RequestDispatcher rd=request.getRequestDispatcher(page);
		rd.forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
