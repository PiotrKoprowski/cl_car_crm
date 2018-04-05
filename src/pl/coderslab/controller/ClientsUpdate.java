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
import pl.coderslab.entity.Client;

/**
 * Servlet implementation class ClientsUpdate
 */
@WebServlet("/ClientsUpdate")
public class ClientsUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ClientsUpdate() {
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

		// Client update
		int id = Integer.parseInt(request.getParameter("id"));
		String name = request.getParameter("name");
		String surname = request.getParameter("surname");
		String email = request.getParameter("email");
		String phone = request.getParameter("phone");
		String birthDate = request.getParameter("birthDate");
		
		try {
			ClientDao.clientUpdate(id, name, surname, email, phone, birthDate);

			List<HashMap<String, String>> clients;
			clients = ClientDao.clientGetAll();
			request.setAttribute("clients", clients);

			String alert = "Client updated!";
			request.setAttribute("alert", alert);

			getServletContext().getRequestDispatcher("/WEB-INF/views/clientsHome.jsp").forward(request, response);
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
		// client selection
		String id = request.getParameter("selectClient");

		PrintWriter wr = response.getWriter();
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");

		try {
			Client client = new Client();
			client = ClientDao.clientSelectById(Integer.parseInt(id));
			request.setAttribute("client", client);

			List<HashMap<String, String>> clients;
			clients = ClientDao.clientGetAll();
			request.setAttribute("clients", clients);

			getServletContext().getRequestDispatcher("/WEB-INF/views/clientsUpdate.jsp").forward(request, response);

		} catch (Exception e) {
			wr.append(e.getMessage());
		}
	}

}
