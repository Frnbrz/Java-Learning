<%@ page import="java.util.Map" %>
<%@ page import="hito.*" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>

<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="ISO-8859-1">
    <title>Hito</title>
    <link href="style.css" rel="stylesheet" type="text/css">
    <link rel="stylesheet"
          href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.4.1/font/bootstrap-icons.css">
    <link
            href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
            rel="stylesheet">
</head>
<body>
<%
    Escuela escuela = (Escuela) request.getServletContext().getAttribute("escuela");
    Profesor usuario = (Profesor) request.getSession().getAttribute("usuario");

%>
<header>

    <h1>Profesor <%=usuario.getLogin() %>
    </h1> <a href="Logout" class="btn btn-primary btn-lg" role="button">Cerrar sesion</a>
</header>
<div class="login-page bg-light">
    <div class="bg-white shadow rounded container">



            <form method="GET" id="my_form" action="Calificar">
                <fieldset>
                    <legend>Calificar</legend>
                    <div class="mb-3">

               <select class="form-select" aria-label="Default select example" form="my_form"
                                        name="alumno">
                    <%
                        for (Map.Entry<String, Usuario> entry : escuela.getUsuarios().entrySet()) {
                            Usuario usuarios = entry.getValue();
                            if (usuarios instanceof Alumno) {%>


                    <option value="<%=usuarios.getLogin()%>"><%=usuarios.getLogin()%>
                    </option>


                    <%
                            }
                        }
                    %>
                </select>
                    </div>
                    <div class="mb-3">
                    <select class="form-select" aria-label="Default select example" form="my_form" name="asignatura">

                        <%
                            for (Especialidad asignatura : usuario.getEspecialidades()) {
                        %>
                        <option value="<%=asignatura.getNombre()%>"><%=asignatura.getNombre()%>
                        </option>
                        <%
                            }
                        %>
                    </select>

                    </div>
                    <div class="mb-3">
                        <label for="examen" class="form-label">Nombre Examen</label>
                        <input type="text" name="examen" id="examen" form="my_form"
                               placeholder="Hito1" class="form-control" required/>
                    </div>
                    <div class="mb-3">
                        <label for="calificacion" class="form-label">Calificacion</label>
                    <input type="number" min="1" max="100" name="calificacion" id="calificacion" form="my_form"
                           placeholder="100" class="form-control" required/>
                    </div>
                    <button type="submit" form="my_form" class="btn btn-primary">Calificar</button>
                </fieldset>
            </form>


        <h2>Notas</h2>
        <table class="table">
            <caption>Notas</caption>

            <thead>
            <tr>
                <th scope="col">Alumno</th>
                <th scope="col">Asignatura</th>
                <th scope="col">Nombre examen</th>
                <th scope="col">Calificacion</th>
                <th scope="col"></th>
            </tr>
            </thead>
            <tbody>


            <%
                for (Usuario entry : escuela.getUsuarios().values()) {
                    if (entry instanceof Alumno) {
                        for (Calificacion calificacion : ((Alumno) entry).getCalificaciones()) {
                            Alumno alumno = (Alumno) entry;
                            if (calificacion.getEspecialidad().getNombre() != null) {%>
            <tr>
                <th scope="row"><%= alumno.getLogin()%>
                </th>
                <td>
                    <%=calificacion.getEspecialidad().getNombre()%>
                </td>
                <td>
                    <%=calificacion.getExamen()%>
                </td>
                <td><%= calificacion.getNota()%>
                </td>
            </tr>

            <% } else { %>
            <tr>
                <td colspan="4">
                    No hay notas para mostrar
                </td>
            </tr>
            <%
                            }
                        }
                    }
                }
            %>


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