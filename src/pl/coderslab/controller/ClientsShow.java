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
 * Servlet implementation class ClientsShow
 */
@WebServlet("/ClientsShow")
public class ClientsShow extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ClientsShow() {
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
		int id = Integer.parseInt(request.getParameter("selectClient"));

		PrintWriter wr = response.getWriter();
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");

		try {
			List<HashMap<String, String>> orders;
			orders = ClientDao.clientGetByStatus(id, "");
			request.setAttribute("orders", orders);
			List<HashMap<String, String>> clients;
			clients = ClientDao.clientGetAll();
			request.setAttribute("clients", clients);
			getServletContext().getRequestDispatcher("/WEB-INF/views/clientsShow.jsp").forward(request, response);

		} catch (Exception e) {
			wr.append(e.getMessage());
		}
	}

}
