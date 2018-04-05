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

import pl.coderslab.dao.ClientDao;

/**
 * Servlet implementation class ClientsAdd
 */
@WebServlet("/ClientsAdd")
public class ClientsAdd extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ClientsAdd() {
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

			String alert = "Client added!";
			request.setAttribute("alert", alert);
			
			List<HashMap<String, String>> clients;
			clients = ClientDao.clientGetAll();
			request.setAttribute("clients", clients);
			
				getServletContext()
				.getRequestDispatcher("/WEB-INF/views/clientsHome.jsp")
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
		String email = request.getParameter("email");
		String phone = request.getParameter("phone");
		String birthDate = request.getParameter("birthDate");
		
		try {
			ClientDao.clientAdd(name, surname, email, phone, birthDate);
		} catch (Exception e) {
			wr.append("Can not add client to database");
			e.printStackTrace();
		}
		doGet(request, response);
	}

}
