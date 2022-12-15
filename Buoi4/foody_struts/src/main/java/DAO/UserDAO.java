package DAO;


import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import Model.NguoiDung1;

public class UserDAO {
	public NguoiDung1 login(String tendangnhap, String matkhau)
 {
 NguoiDung1 nd=null;
 DBService db=new DBService();
 PreparedStatement statement;
 try {
 statement = db.getConn().prepareStatement("SELECT * from NGUOIDUNG WHERE tendangnhap = ? AND matkhau=?");
 statement.setString(1, tendangnhap);
 statement.setString(2,MD5.getMd5(matkhau) );
 ResultSet rs=db.executeQuery(statement);
 if(rs!=null)
 { while(rs.next())
 {
 nd=new NguoiDung1(rs.getInt("id"),rs.getString("tendangnhap"),rs.getString("loaiquyen"));
 }
 }
 } catch (SQLException e) {
 // TODO Auto-generated catch block
 e.printStackTrace();
 }

 return nd;

 }
}