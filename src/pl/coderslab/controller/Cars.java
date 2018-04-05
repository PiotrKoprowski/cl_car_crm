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
 * Servlet implementation class Cars
 */
@WebServlet("/Cars")
public class Cars extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Cars() {
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
			String function = request.getParameter("function");
			if(function.equals("add")){
				List<HashMap<String, String>> clients;
				clients = ClientDao.clientGetAll();
				request.setAttribute("clients", clients);
				getServletContext()
				.getRequestDispatcher("/WEB-INF/views/carsAdd.jsp")
				.forward(request, response);
			} else if(function.equals("update")){
				List<HashMap<String, String>> cars;
				cars = CarDao.carGetAll();
				request.setAttribute("cars", cars);
				getServletContext()
				.getRequestDispatcher("/WEB-INF/views/carsUpdate.jsp")
				.forward(request, response);
			} else if(function.equals("delete")){
				List<HashMap<String, String>> cars;
				cars = CarDao.carGetAll();
				request.setAttribute("cars", cars);
				getServletContext()
				.getRequestDispatcher("/WEB-INF/views/carsDelete.jsp")
				.forward(request, response);
			} else if(function.equals("show")){
				List<HashMap<String, String>> cars;
				cars = CarDao.carGetAll();
				request.setAttribute("cars", cars);
				getServletContext()
				.getRequestDispatcher("/WEB-INF/views/carsShow.jsp")
				.forward(request, response);
			}
		} catch (Exception e) {
			wr.append(e.getMessage());
		}
		
		
		List<HashMap<String, String>> cars;
		try {
			cars = CarDao.carGetAll();
			request.setAttribute("cars", cars);
			getServletContext()
			.getRequestDispatcher("/WEB-INF/views/carsHome.jsp")
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
