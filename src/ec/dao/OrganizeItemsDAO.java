package ec.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import ec.bean.ItemBean;

public class OrganizeItemsDAO {

	private Connection con;

	public OrganizeItemsDAO() throws DAOException{
		getConnection();
	}

	public List<ItemBean> findAll() throws DAOException{
		if(con==null)
			getConnection();

		PreparedStatement st=null;
		ResultSet rs=null;
		try {
			String sql="SELECT * FROM item";
			st=con.prepareStatement(sql);
			rs=st.executeQuery();

			List<ItemBean> list=new ArrayList<ItemBean>();
				while(rs.next()) {
					int code=rs.getInt("code");
					String name=rs.getString("name");
					int price=rs.getInt("price");
					ItemBean bean=new ItemBean(code,name,price);
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


	public List<ItemBean> sortPrice(boolean isAscending) throws DAOException{
		if(con==null)
			getConnection();

		PreparedStatement st=null;
		ResultSet rs=null;
		try {
			String sql;
			if(isAscending)
				sql="SELECT * FROM item ORDER BY price";
			else
				sql="SELECT * FROM item ORDER BY price desc";
			st=con.prepareStatement(sql);
			rs=st.executeQuery();

			List<ItemBean> list=new ArrayList<ItemBean>();
			while(rs.next()) {
				int code=rs.getInt("code");
				String name=rs.getString("name");
				int price=rs.getInt("price");
				ItemBean bean=new ItemBean(code,name,price);
				list.add(bean);
			}
			return list;
		}catch(Exception e) {
			e.printStackTrace();
			throw new DAOException("レコードの操作に失敗しました。");
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

	public int addItem(int category,String name,int price) throws DAOException{
		if(con==null)
			getConnection();

		PreparedStatement st=null;
		try {
			String sql="INSERT INTO item(category_code,name,price) VALUES(?,?,?)";
			st=con.prepareStatement(sql);
			st.setInt(1, category);
			st.setString(2, name);
			st.setInt(3, price);

			int rows=st.executeUpdate();
			return rows;
		}catch(Exception e) {
			e.printStackTrace();
			throw new DAOException("レコードの操作に失敗しました。");
		}finally {
			try {
				if(st!=null) st.close();
				close();
			}catch(Exception e) {
				throw new DAOException("リソースの解放に失敗しました。");
			}
		}
	}

	public List<ItemBean> findByPrice(int lePrice) throws DAOException{
		if(con==null)
			getConnection();

		PreparedStatement st=null;
		ResultSet rs=null;
		try {
			String sql="SELECT * FROM item WHERE price <=?";

			st=con.prepareStatement(sql);
			st.setInt(1, lePrice);
			rs=st.executeQuery();

			List<ItemBean> list=new ArrayList<ItemBean>();
			while(rs.next()) {
				int code=rs.getInt("code");
				String name=rs.getString("name");
				int price=rs.getInt("price");
				ItemBean bean=new ItemBean(code,name,price);
				list.add(bean);
			}
			return list;
		}catch(Exception e) {
			e.printStackTrace();
			throw new DAOException("レコードの操作に失敗しました。");
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

	public int deleteByPrimaryKey(int key) throws DAOException{
		if(con==null)
			getConnection();

		PreparedStatement st=null;
		try {
			String sql="DELETE FROM item WHERE code=?";
			st=con.prepareStatement(sql);
			st.setInt(1, key);
			int rows=st.executeUpdate();
			return rows;
		}catch(Exception e) {
			e.printStackTrace();
			throw new DAOException("レコードの操作に失敗しました。");
		}finally {
			try {
				if(st!=null) st.close();
				close();
			}catch(Exception e) {
				throw new DAOException("リソースの解放に失敗しました。");
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
