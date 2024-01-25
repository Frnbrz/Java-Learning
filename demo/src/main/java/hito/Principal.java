package hito;

import java.util.Scanner;

public class Principal {
	public static void main(String[] args) {
		Escuela escuela = new Escuela();
		Scanner lector = new Scanner(System.in);
		escuela.nuevoProfesor("Pepe", "1234");
		escuela.nuevoProfesor("Juan", "1234");
		escuela.nuevoAlumno("Alicia", "2345");
		escuela.nuevoAlumno("Miguel", "2345");

		Usuario usuario;
		Profesor profesor;
		Alumno alumno;

		System.out.println("VAMOS A AÑADIR UNA CALIFICACIÓN");
		System.out.print("Introduce el nombre del profesor: ");
		String p = lector.nextLine();

		usuario = escuela.getUsuarios().get(p);
		if (usuario == null) {
			System.out.println("El usuario con login " + p + " no está registrado");
			lector.close();
			return;
		} else if (usuario instanceof Profesor) {
			profesor = (Profesor) usuario;
			System.out.println(profesor.getLogin() + " es un profesor");
		} else {
			System.out.println(usuario.getLogin() + " no es un profesor");
			lector.close();
			return;
		}

		System.out.print("Introduce el nombre del alumno: ");
		String a = lector.nextLine();

		usuario = escuela.getUsuarios().get(a);
		if (usuario == null) {
			System.out.println("El usuario con login " + a + " no está registrado");
			lector.close();
			return;
		} else if (usuario instanceof Alumno) {
			alumno = (Alumno) usuario;
			System.out.println(alumno.getLogin() + " es un alumno");
		} else {
			System.out.println(usuario.getLogin() + " no es un alumno");
			lector.close();
			return;
		}

		String continuar = "S";
		do {
			System.out.print("Introduce el nombre de la asignatura: ");
			String esp = lector.nextLine();
			System.out.print("Introduce el nombre del Examen: ");
			String examen = lector.nextLine();
			Especialidad especialidad = new Especialidad(esp);
			System.out.print("Introduce la nota (0-100): ");
			int nota = lector.nextInt();
			lector.nextLine(); // Limpiar el buffer.
			alumno.calificar(profesor, alumno ,especialidad , nota, examen);
			System.out.print("¿Quieres añadir más calificaciones (S/N)? ");
			continuar = lector.nextLine();
		} while (continuar.toUpperCase().equals("S"));

		System.out.println(alumno);

		lector.close();
	}

}
