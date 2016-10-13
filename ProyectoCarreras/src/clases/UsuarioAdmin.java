package clases;

import interfaces.CreacionCarrera;
import interfaces.ModificacionCarrera;

public class UsuarioAdmin extends Usuario implements CreacionCarrera, ModificacionCarrera {
	
	public UsuarioAdmin(String nombre, String apellidos, String direccion, String email, String pass, int telf, 
			String club){
		super(nombre, apellidos, direccion, email, pass, telf, club);
	}
	
	public int admitirUsuario(Usuario u){
		
		// TODO to admit user method
		return 0;
	}
	

	
	// TODO implement interfaces
	@Override
	public int modificarCarrera(Carrera c) {
		// TODO 
		return 0;
	}

	@Override
	public int crearCarrera(Carrera c) {
		// TODO 
		return 0;
	}

}
