package agu.edu.vn;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.FoodDAO;
import DAO.UserDAO;
import Models.NguoiDung;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public LoginServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
				NguoiDung nd=new
				UserDAO().login(request.getParameter("tendangnhap"),
				request.getParameter("matkhau"));
				if(nd!=null)
				{
					HttpSession session = request.getSession();
					session.setAttribute("nguoidung", nd);
					List list=new FoodDAO().getList();
					request.setAttribute("list", list);
					RequestDispatcher view =
					request.getRequestDispatcher("thucdon.jsp");
					view.forward(request, response);
				}
				else
				{
					request.setAttribute("message", "Tên đăng nhập hoặc mật "
							+ "khẩu không chính xác");
					RequestDispatcher view =
					request.getRequestDispatcher("login.jsp");
					view.forward(request, response);
	}}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
