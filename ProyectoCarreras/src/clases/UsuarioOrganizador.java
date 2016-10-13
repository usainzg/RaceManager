package clases;

import java.util.ArrayList;

import interfaces.CreacionCarrera;
import interfaces.ModificacionCarrera;

public class UsuarioOrganizador extends Usuario implements CreacionCarrera, ModificacionCarrera {
	
	private ArrayList<Carrera> carrerasPropias = new ArrayList<>();

	public UsuarioOrganizador(String nombre, String apellidos, String direccion, String email, String pass, int telf, 
			String club, ArrayList<Carrera> carrerasPropias){
		super(nombre, apellidos, direccion, email, pass, telf, club);
		this.carrerasPropias = carrerasPropias;
	}
	
	
	// getter and setter
	public ArrayList<Carrera> getCarrerasPropias() {
		return carrerasPropias;
	}


	public void setCarrerasPropias(ArrayList<Carrera> carrerasPropias) {
		this.carrerasPropias = carrerasPropias;
	}


	// TODO implement interfaces
	@Override
	public int modificarCarrera(Carrera c) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int crearCarrera(Carrera c) {
		// TODO Auto-generated method stub
		return 0;
	}

}
