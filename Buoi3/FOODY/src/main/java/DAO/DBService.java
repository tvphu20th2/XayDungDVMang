package DAO;

import java.sql.*;


public class DBService {

	static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
	static final String DB_URL ="jdbc:mysql://172.18.25.145:3306/FOODY_DTH195338?allowPublicKeyRetrieval=true&useSSL=false"";
	static final String USER = "dbuser";
	static final String PASS = "p@ssword";
	Connection conn = null;
	
	public DBService()
	{
		try {
			Class.forName(JDBC_DRIVER);
			conn = DriverManager.getConnection(DB_URL,USER,PASS);
		} catch (ClassNotFoundException | SQLException e) 
		{
			e.printStackTrace();
		}}
	public Connection getConn()
	{
		return conn;
	}
	public ResultSet executeQuery(PreparedStatement stmt)
	{
		//Statement stmt = null;
		ResultSet rs=null;
		try {
			//stmt = conn.createStatement();
			rs = stmt.executeQuery();
			//stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;
	}
	public void executeUpdate(PreparedStatement stmt)
	{
		try {
			stmt.executeUpdate();
			stmt.close();
		} catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		public void close() {
			try {
				//stmt.close();
				conn.close();
		} catch (SQLException e) {
		// TODO Auto-generated catch block
				e.printStackTrace();
		}
	}
}
