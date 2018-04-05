package pl.coderslab.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pl.coderslab.dao.CarDao;

/**
 * Servlet implementation class CarsDelete
 */
@WebServlet("/CarsDelete")
public class CarsDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CarsDelete() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter wr = response.getWriter();
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		
		String idDelete = request.getParameter("deleteCar");
		try {
		CarDao.carDelete(Integer.parseInt(idDelete));
		
		String alert = "Car deleted!";
		request.setAttribute("alert", alert);
		
		List<HashMap<String, String>> cars;
		cars = CarDao.carGetAll();
		request.setAttribute("cars", cars);
		
				getServletContext()
				.getRequestDispatcher("/WEB-INF/views/carsHome.jsp")
				.forward(request, response);

		} catch (Exception e) {
			wr.append(e.getMessage());
		}
	}

}
