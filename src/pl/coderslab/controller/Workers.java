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
 * Servlet implementation class Workers
 */
@WebServlet("/workers")
public class Workers extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Workers() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter wr = response.getWriter();
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		
		try {
			String function = request.getParameter("function");
			if(function.equals("add")){
				getServletContext()
				.getRequestDispatcher("/WEB-INF/views/workersAdd.jsp")
				.forward(request, response);
			} else if(function.equals("update")){
				List<HashMap<String, String>> workers;
				workers = WorkerDao.workerGetAll();
				request.setAttribute("workers", workers);
				getServletContext()
				.getRequestDispatcher("/WEB-INF/views/workersUpdate.jsp")
				.forward(request, response);
			} else if(function.equals("delete")){
				List<HashMap<String, String>> workers;
				workers = WorkerDao.workerGetAll();
				request.setAttribute("workers", workers);
				getServletContext()
				.getRequestDispatcher("/WEB-INF/views/workersDelete.jsp")
				.forward(request, response);
			} else if(function.equals("show")){
				List<HashMap<String, String>> workers;
				workers = WorkerDao.workerGetAll();
				request.setAttribute("workers", workers);
				getServletContext()
				.getRequestDispatcher("/WEB-INF/views/workersShow.jsp")
				.forward(request, response);
			}
		} catch (Exception e) {
			wr.append(e.getMessage());
		}
		
		
		List<HashMap<String, String>> workers;
		try {
			workers = WorkerDao.workerGetAll();
			request.setAttribute("workers", workers);
			getServletContext()
			.getRequestDispatcher("/WEB-INF/views/workersHome.jsp")
			.forward(request, response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
