package servlet;

import java.io.IOException;
import java.util.ArrayList;

import hito.*;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 * Servlet implementation class Control
 */
public class Control extends HttpServlet {
  private static final long serialVersionUID = 1L;

  /**
   * @see HttpServlet#HttpServlet()
   */
  public Control() {
    super();

    // TODO Auto-generated constructor stub
  }

  /**
   * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
   *      response)
   */
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
          throws ServletException, IOException {

    HttpSession session = request.getSession();
    RequestDispatcher rd = request.getRequestDispatcher("login.jsp");

    Usuario usuario = (Usuario) session.getAttribute("usuario");
    if (usuario == null) {
      session.setAttribute("usuario", usuario);
      rd = request.getRequestDispatcher("login.jsp");

    } else if (usuario instanceof Profesor) {
      rd = request.getRequestDispatcher("profesor.jsp");
    } else if (usuario instanceof Alumno) {
      rd = request.getRequestDispatcher("alumno.jsp");
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

  @Override
  public void init() throws ServletException {
    super.init();
    Escuela escuela = new Escuela();
    escuela.nuevoProfesor("Pepe", "1234" );
    Profesor p1 = (Profesor) escuela.getUsuarios().get("Pepe");
    ArrayList<Especialidad> especialidades1 = new ArrayList<>();
    especialidades1.add(new Especialidad("Matematicas"));
    especialidades1.add(new Especialidad("Fisica"));
    p1.setEspecialidades(especialidades1);
    escuela.nuevoProfesor("Juan", "1234");
    Profesor p2 = (Profesor) escuela.getUsuarios().get("Juan");
    ArrayList<Especialidad> especialidades2 = new ArrayList<>();
    especialidades2.add(new Especialidad("Informática"));
    p2.setEspecialidades(especialidades2);
    escuela.nuevoAlumno("Alicia", "2345");
    escuela.nuevoAlumno("Miguel", "2345");

    ServletContext contextAplication = this.getServletContext();
    contextAplication.setAttribute("escuela", escuela);
  }
}
