package agu.edu.vn;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.FoodDAO;
import Models.Food;
import Models.NguoiDung;

/**
 * Servlet implementation class oderServlet
 */
@WebServlet("/oderServlet")
public class oderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public oderServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse	 response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		Food food=new FoodDAO().getFoodByID(Integer.parseInt(
				request.getParameter("idmonan")));
				request.setAttribute("food", food);
				RequestDispatcher view =
				request.getRequestDispatcher("datmon.jsp");
				view.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		HttpSession session = request.getSession();
		NguoiDung nd =(NguoiDung)session.getAttribute("nguoidung");
		new FoodDAO().Order(nd.getId(),
		Integer.parseInt(request.getParameter("idmonan"))
		,
		Integer.parseInt(request.getParameter("soluong")),
		Integer.parseInt(request.getParameter("gia")),
		Integer.parseInt(request.getParameter("thanhtien")));
		List list=new FoodDAO().getList();
		request.setAttribute("list", list);
		request.setAttribute("message", "Món ăn đã được đặt thành công!");
		RequestDispatcher view =
		request.getRequestDispatcher("thucdon.jsp");
		view.forward(request, response);
	}

}
