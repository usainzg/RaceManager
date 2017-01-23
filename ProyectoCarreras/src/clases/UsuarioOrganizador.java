package clases;

public class UsuarioOrganizador extends Usuario {
	
	private int id;

	public UsuarioOrganizador(String nombre, String apellidos, String direccion, String email, String pass, int telf,
			String club, int id) {
		super(nombre, apellidos, direccion, email, pass, telf, club);
		this.id = id;
	}

	public UsuarioOrganizador() {
	}

	public UsuarioOrganizador(String nombre, String apellidos, String direccion, String email, String pass, int telf,
			String club) {
		super(nombre, apellidos, direccion, email, pass, telf, club);
	}

	public UsuarioOrganizador(clasesHibernate.Usuarioorganizador org) {
		super(org.getNombre(), org.getApellidos(), org.getDireccion(), org.getEmail(), org.getPassword(),
				org.getTelefono(), org.getClub());
		this.id = org.getId();
	}

	// getters and setters
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public void setNb(String name){
		this.nbUsuario = name;
	}

}
