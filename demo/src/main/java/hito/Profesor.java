package hito;

import java.util.ArrayList;

public class Profesor extends Usuario {
	private ArrayList<Especialidad> especialidades;

	public Profesor(String login, String password, String especialidad) {
		super(login, password);
		this.especialidades.add(new Especialidad(especialidad));
	}

	public Profesor(String login, String password) {
		super(login, password);
		this.especialidades = new ArrayList<>();
	}

	public ArrayList<Especialidad> getEspecialidades() {
		return especialidades;
	}

	public void setEspecialidades(ArrayList<Especialidad> especialidades) {
		this.especialidades = especialidades;
	}
}
