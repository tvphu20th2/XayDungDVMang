package Action;

import java.util.List;

import DAO.FoodDAO;
import Model.Food;

public class KhachAction {
	List<Food> foodlist;

	public List<Food> getFoodlist() {
		return foodlist;
	}

	public void setFoodlist(List<Food> foodlist) {
		this.foodlist = foodlist;
	}
	
	public String home() {
		System.out.println("welcome Khach action");
		foodlist=new FoodDAO().getList();
		return "success";
	}
}
