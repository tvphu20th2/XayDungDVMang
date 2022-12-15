package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import Model.Food;
import Model.NguoiDung1;

public class FoodDAO {
	public List<Food> getList() {

		List<Food> list = new ArrayList<Food>();
		DBService db = new DBService();
		PreparedStatement statement;

		try {
			statement = db.getConn().prepareStatement("SELECT * from MONAN");
			ResultSet rs = db.executeQuery(statement);

			if (rs != null) {
				while (rs.next()) {
					list.add(new Food(rs.getInt("id"), rs.getString("tenmonan"),

							rs.getString("hinhanh"), rs.getInt("gia")));
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	public Food getFoodByID(int id) {
		Food food = null;
		DBService db = new DBService();
		PreparedStatement statement;
		try {
			statement = db.getConn().prepareStatement("SELECT * from MONAN WHERE id=?");
			statement.setInt(1, id);

			ResultSet rs = db.executeQuery(statement);

			if (rs != null) {
				while (rs.next()) {
					food = new Food(rs.getInt("id"), rs.getString("tenmonan"),

							rs.getString("hinhanh"), rs.getInt("gia"));
				}
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return food;

	}

	public void Order(int idnguoidung, int idmonan, int soluong, int gia, int thanhtien) {
		DBService db = new DBService();
		PreparedStatement statement;
		try {
			statement = db.getConn().prepareStatement(
					"INSERT INTO DATMON(idnguoidung,idmonan,soluong,gia,thanhtien) values(?,?,?,?,?)");
			statement.setInt(1, idnguoidung);
			statement.setInt(2, idmonan);
			statement.setInt(3, soluong);
			statement.setInt(4, gia);
			statement.setInt(5, thanhtien);

			db.executeUpdate(statement);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
