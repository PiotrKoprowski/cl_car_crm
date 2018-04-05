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
 * Servlet implementation class WorkersAdd
 */
@WebServlet("/WorkersAdd")
public class WorkersAdd extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public WorkersAdd() {
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

			String alert = "Worker added!";
			request.setAttribute("alert", alert);
			
			List<HashMap<String, String>> workers;
			workers = WorkerDao.workerGetAll();
			request.setAttribute("workers", workers);
				getServletContext()
				.getRequestDispatcher("/WEB-INF/views/workersHome.jsp")
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
		String name = request.getParameter("name");
		String surname = request.getParameter("surname");
		String address = request.getParameter("address");
		String phone = request.getParameter("phone");
		String note = request.getParameter("note");
		String man_hour = request.getParameter("man_hour");
		
		try {
			WorkerDao.workerAdd(name, surname, address, phone, note, man_hour);
		} catch (Exception e) {
			wr.append("Can not add worker to database");
			e.printStackTrace();
		}
		doGet(request, response);
	}

}
