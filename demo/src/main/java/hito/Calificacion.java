package hito;

public class Calificacion {
    private Alumno alumno;
    private Profesor profesor;
    private Especialidad especialidad;
    private int nota;
    private String examen;



    public Calificacion(Profesor profesor, Alumno alumno, Especialidad especialidad, int nota, String examen) {
        super();
        this.profesor = profesor;
        this.alumno = alumno;
        this.especialidad = especialidad;
        this.nota = nota;
        this.examen = examen;
    }
    public Especialidad getEspecialidad() {
        return especialidad;
    }
    public int getNota() {
        return nota;
    }
    public String getExamen() {
        return examen;
    }
    @Override
    public String toString() {
        return "Alumno: " + alumno.getLogin() +  "Asignatura: " + especialidad.getNombre() + ", Nota: " + nota + " - Calificado por " + this.profesor.getLogin();
    }

    public void setNota(int nota) {
        this.nota = nota;
    }
}
