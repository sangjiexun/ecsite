package ec.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class RegistrationDAO {
	private Connection con;

	public RegistrationDAO() throws DAOException {
		getConnection();
	}
	public int AllnewDataAdd(String Name, String Address, String Tel, String Gender, String loginID, String passWord)
			throws DAOException {
		if (con == null)
			getConnection();

		PreparedStatement st = null;
		try {

			String sql = "INSERT INTO member(name,address,tel,gender,login_id,login_pass) VALUES(?,?,?,?,?,?)";

			st = con.prepareStatement(sql);

			st.setString(1, Name);
			st.setString(2, Address);
			st.setString(3, Tel);
			st.setString(4, Gender);
			st.setString(5, loginID);
			st.setString(6, passWord);

			int rows = st.executeUpdate();

			return rows;

		} catch (Exception e) {
			e.printStackTrace();
			throw new DAOException("レコードの操作に失敗しました。");
		} finally {
			try {
				if(st!=null) st.close();
				close();
				} catch (Exception e) {
				throw new DAOException("リソースの解放に失敗しました。");
			}
		}
	}

	private void getConnection() throws DAOException {
		try {
			Class.forName("org.postgresql.Driver");
			String url = "jdbc:postgresql:ecsite";
			String user = "taisei";
			String pass = "himitu";

			con = DriverManager.getConnection(url, user, pass);
		} catch (Exception e) {
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
