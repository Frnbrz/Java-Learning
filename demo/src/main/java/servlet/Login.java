package servlet;

import java.io.IOException;

import hito.Alumno;
import hito.Escuela;
import hito.Usuario;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 * Servlet implementation class Login
 */
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Login() {
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

		HttpSession session = request.getSession();



		String username = request.getParameter("username");
		String password = request.getParameter("password");
		ServletContext contextAplication = this.getServletContext();
		Escuela escuela = (Escuela) contextAplication.getAttribute("escuela");

		Usuario usuario = escuela.getUsuarios().get(username);



		RequestDispatcher rd;
		if (usuario == null || !usuario.getPassword().equals(password)) {
			rd = request.getRequestDispatcher("login.jsp");

		} else {
			session.setAttribute("usuario", usuario);
			rd = request.getRequestDispatcher("Control");
		}
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
