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

import pl.coderslab.dao.WorkerDao;

/**
 * Servlet implementation class WorkersSelect
 */
@WebServlet("/WorkersShow")
public class WorkersShow extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public WorkersShow() {
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
		int id = Integer.parseInt(request.getParameter("selectWorker"));

		PrintWriter wr = response.getWriter();
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");

		try {
			List<HashMap<String, String>> orders;
			orders = WorkerDao.workerGetByStatus(id, "");
			request.setAttribute("orders", orders);
			List<HashMap<String, String>> workers;
			workers = WorkerDao.workerGetAll();
			request.setAttribute("workers", workers);
			getServletContext().getRequestDispatcher("/WEB-INF/views/workersShow.jsp").forward(request, response);

		} catch (Exception e) {
			wr.append(e.getMessage());
		}
	}
}
