<%@ page import="hito.Escuela" %>
<%@ page import="hito.Alumno" %>
<%@ page import="hito.Calificacion" %>
<%@ page import="hito.Usuario" %>
<%@ page contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="ISO-8859-1">
    <title>Hito</title>
    <link href="style.css" rel="stylesheet" type="text/css">
    <link
            href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css"
            rel="stylesheet"
            integrity="sha384-iYQeCzEYFbKjA/T2uDLTpkwGzCiq6soy8tYaI1GyVh/UjpbCx/TYkiZhlZB6+fzT"
            crossorigin="anonymous"/>
</head>
<body>
<%
    Alumno usuario = (Alumno) request.getSession().getAttribute("usuario");


    ServletContext contextAplication = request.getServletContext();

    Escuela escuela = (Escuela) contextAplication.getAttribute("escuela");
    String nombre = usuario.getLogin();
    Alumno usuarioConCalificaciones = null;

    try {
        usuarioConCalificaciones = (Alumno)  escuela.getUsuarios().get(nombre);
    } catch (Exception e){
        response.sendRedirect("Login");
    }

%>
<header>

    <h1>Alumno <%= usuario.getLogin() %>
    </h1> <a href="Logout" class="btn btn-primary btn-lg" role="button" >Cerrar sesion</a>
</header>
<div class="login-page bg-light">
    <div class="bg-white shadow rounded container" >

        <table class="table">
            <caption>Alumnos</caption>
            <thead>
            <tr>
                <th scope="col">Asignatura</th>
                <th scope="col">Nombre Examen</th>
                <th scope="col">Calificacion</th>
                <th scope="col"></th>
            </tr>
            </thead>
            <tbody>
            <%
                for (Calificacion calificacion : usuarioConCalificaciones.getCalificaciones() ) {
            %>
            <tr>
                <th scope="row">
                    <%= calificacion.getEspecialidad().getNombre() %>
                </th>
                <td>

                    <%= calificacion.getExamen()%>

                </td>
                <td>

                    <%= calificacion.getNota()%>

                </td>
            </tr>
            <% } %>

            </tbody>
        </table>


    </div>
</div>
<script
        src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-u1OknCvxWvY5kfmNBILK2hRnQC3Pr17a+RTT6rIHI7NnikvbZlHgTPOOmMi466C8"
        crossorigin="anonymous"></script>

</body>
</html>