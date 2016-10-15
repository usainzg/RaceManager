package clases;


import interfaces.CreacionCarrera;
import interfaces.ModificacionCarrera;

public class UsuarioOrganizador extends Usuario implements CreacionCarrera, ModificacionCarrera {
	private int id;
	
	public UsuarioOrganizador(String nombre, String apellidos, String direccion, String email, String pass, int telf, 
			String club, int id){
		super(nombre, apellidos, direccion, email, pass, telf, club);
		this.id = id;
	}
	
	// getters and setters
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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
