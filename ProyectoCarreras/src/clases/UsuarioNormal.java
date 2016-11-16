package clases;

public class UsuarioNormal extends Usuario {

	public UsuarioNormal(String nombre, String apellidos, String direccion, String email, String pass, int telf,
			String club) {
		super(nombre, apellidos, direccion, email, pass, telf, club);
	}

	public UsuarioNormal() {
	}

	public UsuarioNormal(clasesHibernate.Usuarionormal u) {
		super(u.getNombre(), u.getApellidos(), u.getDireccion(), u.getEmail(), u.getPassword(), u.getTelefono(),
				u.getClub());
	}

}
