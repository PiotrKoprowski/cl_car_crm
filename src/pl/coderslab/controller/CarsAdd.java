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
import pl.coderslab.dao.ClientDao;

/**
 * Servlet implementation class CarsAdd
 */
@WebServlet("/CarsAdd")
public class CarsAdd extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CarsAdd() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter wr = response.getWriter();
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		
		try {

			String alert = "Car added!";
			request.setAttribute("alert", alert);
			
			List<HashMap<String, String>> cars;
			cars = CarDao.carGetAll();
			request.setAttribute("cars", cars);

			List<HashMap<String, String>> clients;
			clients = ClientDao.clientGetAll();
			request.setAttribute("clients", clients);
			
				getServletContext()
				.getRequestDispatcher("/WEB-INF/views/carsHome.jsp")
				.forward(request, response);

		} catch (Exception e) {
			wr.append(e.getMessage());
		}
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter wr = response.getWriter();
		String make = request.getParameter("make");
		String model = request.getParameter("model");
		String year = request.getParameter("year");
		String registration = request.getParameter("registration");
		String service = request.getParameter("service");
		String client_id = request.getParameter("client_id");
		
		try {
			CarDao.carAdd(make, model, year, registration, service, client_id);
		} catch (Exception e) {
			wr.append("Can not add car to database");
			e.printStackTrace();
		}
		doGet(request, response);
	}

}
