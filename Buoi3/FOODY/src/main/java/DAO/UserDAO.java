package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Models.NguoiDung;

public class UserDAO {
	public NguoiDung login(String tendangnhap, String matkhau)
	{
		NguoiDung nd=null;
		DBService db=new DBService();
		PreparedStatement statement;
	try {
		statement = db.getConn().prepareStatement("SELECT * from NGUOIDUNG WHERE tendangnhap = ? AND matkhau=?");
		statement.setString(1, tendangnhap);
		statement.setString(2,MD5.getMd5(matkhau) );
		ResultSet rs=db.executeQuery(statement);
	if(rs!=null)
	{ 
			while(rs.next())
			{
				nd=new NguoiDung(rs.getInt("id"),
				rs.getString("tendangnhap"));
			}
	}
	} catch (SQLException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
	}
	return nd;
	}

}
