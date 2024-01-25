package hito;

import java.util.ArrayList;
import java.util.List;

public class Alumno extends Usuario {
    private ArrayList<Calificacion> calificaciones;

    public Alumno(String login, String password) {
        super(login, password);
        this.calificaciones = new ArrayList<>();
    }

    public List<Calificacion> getCalificaciones() {
        return calificaciones;
    }

    public void calificar(Profesor profesor, Alumno alumno, Especialidad especialidad, int nota, String examen) {

        Calificacion newCalificaion = new Calificacion(profesor, alumno, especialidad, nota, examen);


         if (!this.calificaciones.isEmpty()) {
             for (Calificacion especialidad1 : this.calificaciones) {
                 if (especialidad1.getExamen().equals(newCalificaion.getExamen()) && especialidad1.getEspecialidad().equals(newCalificaion.getEspecialidad())) {
                     especialidad1.setNota(newCalificaion.getNota());
                     return;
                 }
             }

         }
             this.calificaciones.add(newCalificaion);
    }

    @Override
    public String toString() {
        String calificacionesString = "";
        for (Calificacion calificacion : this.getCalificaciones()) {
            calificacionesString = calificacionesString.concat(calificacion.toString() + "\n");
        }
        return "Alumno: " + this.getLogin() + "\n" + calificacionesString;
    }
}
