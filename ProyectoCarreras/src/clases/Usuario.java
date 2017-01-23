package clases;

public abstract class Usuario {

	// Usuario class attributes
	protected String nbUsuario;
	protected String apellidosUsuario;
	protected String dirUsuario;
	protected String emailUsuario;
	protected String passUsuario;
	protected int telfUsuario;
	protected String clubUsuario;

	public Usuario(String nombre, String apellidos, String direccion, String email, String pass, int telefono,
			String club) {
		this.nbUsuario = nombre;
		this.apellidosUsuario = apellidos;
		this.dirUsuario = direccion;
		this.emailUsuario = email;
		this.passUsuario = pass;
		this.telfUsuario = telefono;
		this.clubUsuario = club;
	}

	public Usuario() {
	}

	// getters and setters
	public String getNbUsuario() {
		return nbUsuario;
	}

	public void setNbUsuario(String nbUsuario) {
		this.nbUsuario = nbUsuario;
	}

	public String getApellidosUsuario() {
		return apellidosUsuario;
	}

	public void setApellidosUsuario(String apellidosUsuario) {
		this.apellidosUsuario = apellidosUsuario;
	}

	public String getDirUsuario() {
		return dirUsuario;
	}

	public void setDirUsuario(String dirUsuario) {
		this.dirUsuario = dirUsuario;
	}

	public String getEmailUsuario() {
		return emailUsuario;
	}

	public void setEmailUsuario(String emailUsuario) {
		this.emailUsuario = emailUsuario;
	}

	public String getPassUsuario() {
		return passUsuario;
	}

	public void setPassUsuario(String passUsuario) {
		this.passUsuario = passUsuario;
	}

	public int getTelfUsuario() {
		return telfUsuario;
	}

	public void setTelfUsuario(int telfUsuario) {
		this.telfUsuario = telfUsuario;
	}

	public String getClubUsuario() {
		return clubUsuario;
	}

	public void setClubUsuario(String clubUsuario) {
		this.clubUsuario = clubUsuario;
	}

}
