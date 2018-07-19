package ec.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginDAO {
	private Connection con;

	public LoginDAO() throws DAOException{
		getConnection();
	}

	public boolean checkLoginmember(String name,String passWord) throws DAOException{
		if(con==null)
			getConnection();

		PreparedStatement st=null;
		ResultSet rs=null;

		try {
			String sql = "SELECT * FROM member WHERE login_id=? and login_pass=?";

			st=con.prepareStatement(sql);

			st.setString(1, name);
			st.setString(2, passWord);

			rs=st.executeQuery();

			if(rs.next()) {
				return true;
			}
			return false;
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
			throw new DAOException("接続に失敗しました");
		}
	}

	private void close() throws SQLException{
		if(con!=null) {
			con.close();
			con=null;
		}
	}
}
