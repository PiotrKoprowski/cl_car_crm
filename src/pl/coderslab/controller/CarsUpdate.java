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
import pl.coderslab.dao.WorkerDao;
import pl.coderslab.entity.Car;
import pl.coderslab.entity.Worker;

/**
 * Servlet implementation class CarsUpdate
 */
@WebServlet("/CarsUpdate")
public class CarsUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CarsUpdate() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// car update
		int id = Integer.parseInt(request.getParameter("id"));
		String make = request.getParameter("make");
		String model = request.getParameter("model");
		String year = request.getParameter("year");
		String registration = request.getParameter("registration");
		String service = request.getParameter("service");
		String client_id = request.getParameter("client_id");

		try {
			CarDao.carUpdate(id, make, model, year, registration, service, client_id);
			
			List<HashMap<String, String>> cars;
			cars = CarDao.carGetAll();
			request.setAttribute("cars", cars);
			
			List<HashMap<String, String>> clients;
			clients = ClientDao.clientGetAll();
			request.setAttribute("clients", clients);

			String alert = "Car updated!";
			request.setAttribute("alert", alert);

			getServletContext().getRequestDispatcher("/WEB-INF/views/carsHome.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		// Worker selection
		String id = request.getParameter("selectCar");

		PrintWriter wr = response.getWriter();
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");

		try {
			Worker worker = new Worker();
			worker = WorkerDao.workerSelectById(Integer.parseInt(id));
			request.setAttribute("worker", worker);

			Car car = new Car();
			car = CarDao.carSelectById(Integer.parseInt(id));
			request.setAttribute("car", car);

			List<HashMap<String, String>> cars;
			cars = CarDao.carGetAll();
			request.setAttribute("cars", cars);

			getServletContext().getRequestDispatcher("/WEB-INF/views/carsUpdate.jsp").forward(request, response);

		} catch (Exception e) {
			wr.append(e.getMessage());
		}
	}

}
