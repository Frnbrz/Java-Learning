package servlet;

import hito.*;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

/**
 * Servlet implementation class Control
 */
public class Calificar extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public Calificar() {
        super();
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     * response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Profesor usuario = (Profesor) request.getSession().getAttribute("usuario");
        Escuela escuela = (Escuela) request.getServletContext().getAttribute("escuela");
        String alumno = request.getParameter("alumno");
        Alumno alumnoCalificar = (Alumno) escuela.getUsuarios().get(alumno);
        String examen = request.getParameter("examen");
        Especialidad asignatura = new Especialidad(request.getParameter("asignatura"));

        int calificacion = Integer.parseInt(request.getParameter("calificacion"));

        alumnoCalificar.calificar(usuario, alumnoCalificar, asignatura, calificacion, examen);
        ServletContext contextAplication = this.getServletContext();
        contextAplication.setAttribute("escuela", escuela);


        RequestDispatcher rd = request.getRequestDispatcher("profesor.jsp");
        rd.forward(request, response);
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     * response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

}
