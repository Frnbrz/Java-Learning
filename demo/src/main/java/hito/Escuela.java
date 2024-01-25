package hito;

import java.util.TreeMap;

public class Escuela {
	private TreeMap<String, Usuario> usuarios;

	public Escuela() {
		super();
		this.usuarios = new TreeMap<>();
	}

	public void nuevoProfesor(String login, String password) {
		usuarios.put(login, new Profesor(login, password));
	}

	public void nuevoAlumno(String login, String password) {
		usuarios.put(login, new Alumno(login, password));
	}

	public TreeMap<String, Usuario> getUsuarios() {
		return usuarios;
	}

}