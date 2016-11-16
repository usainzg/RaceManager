package clases;

public class UsuarioAdmin extends Usuario {

	public UsuarioAdmin(String nombre, String apellidos, String direccion, String email, String pass, int telf,
			String club) {
		super(nombre, apellidos, direccion, email, pass, telf, club);
	}

	public UsuarioAdmin() {
	}

	public UsuarioAdmin(clasesHibernate.Usuarioadmin uA) {
		super(uA.getNombre(), uA.getApellidos(), uA.getDireccion(), uA.getEmail(), uA.getPassword(), uA.getTelefono(),
				uA.getClub());
	}
}
