package ec.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import ec.bean.CustomerBean;
import ec.bean.OrderedBean;

public class CheckOrderDAO {

	private Connection con;

	public CheckOrderDAO() throws DAOException {
		getConnection();
	}

	public List<CustomerBean> findCustomerInfo() throws DAOException{
		if(con==null)
			getConnection();

		PreparedStatement st=null;
		ResultSet rs=null;
		try {
			String sql="SELECT * FROM customer";
			st=con.prepareStatement(sql);
			rs=st.executeQuery();

			List<CustomerBean> list=new ArrayList<CustomerBean>();
				while(rs.next()) {
					int code=rs.getInt("code");
					String name=rs.getString("name");
					String address=rs.getString("address");
					String tel=rs.getString("tel");
					String email=rs.getString("email");
					CustomerBean bean=new CustomerBean(code,name,address,tel,email);
					list.add(bean);
				}
			return list;
		}catch(Exception e) {
			e.printStackTrace();
			throw new DAOException("レコードの取得に失敗しました。");
		}finally {
			try {
				if(rs!=null) rs.close();
				if(st!=null) st.close();
				close();
			}catch(Exception e) {
				throw new DAOException("リソースの解放に失敗しました。");
			}
		}
	}

	public List<OrderedBean> findItemsByOrderedCode(int orderedCode) throws DAOException{
		if(con==null)
			getConnection();

		PreparedStatement st=null;
		ResultSet rs=null;
		try {
			String sql="SELECT * FROM ordered_detail INNER JOIN item "
					+ "ON ordered_detail.item_code=item.code "
					+ "WHERE ordered_code=?";

			st=con.prepareStatement(sql);

			st.setInt(1, orderedCode);
			rs=st.executeQuery();

			List<OrderedBean> list=new ArrayList<OrderedBean>();
			while(rs.next()) {
				int orderCode=rs.getInt("ordered_code");
				int itemCode=rs.getInt("item_code");
				String itemName=rs.getString("name");
				int itemPrice=rs.getInt("price");
				int num=rs.getInt("num");
				OrderedBean bean=new OrderedBean(orderCode,itemCode,itemName,itemPrice,num);
				list.add(bean);
			}
				return list;
		}catch(Exception e) {
			e.printStackTrace();
			throw new DAOException("レコードの取得に失敗しました。");
		}finally {
			try {
				if(rs!=null)rs.close();
				if(st!=null)rs.close();
				close();
			}catch(Exception e) {
				throw  new DAOException("レコードの解放に失敗しました。");
			}
		}
	}

	private void getConnection() throws DAOException{
		try {
			Class.forName("org.postgresql.Driver");

			String url="jdbc:postgresql:ecsite";
			String user="taisei";
			String pass="himitu";

			con=DriverManager.getConnection(url, user, pass);
		}catch(Exception e) {
			e.printStackTrace();
			throw new DAOException("接続に失敗しました。");
		}
	}

	private void close() throws SQLException{
		if(con!=null) {
			con.close();
			con=null;
		}
	}
}
