package clasesHibernate;
// Generated 15-nov-2016 9:41:01 by Hibernate Tools 5.2.0.Beta1

/**
 * Usuarioadmin generated by hbm2java
 */
public class Usuarioadmin implements java.io.Serializable {

	private String email;
	private String nombre;
	private String apellidos;
	private String password;
	private String direccion;
	private int telefono;
	private String club;

	public Usuarioadmin() {
	}

	public Usuarioadmin(String email, String nombre, String apellidos, String password, String direccion, int telefono,
			String club) {
		this.email = email;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.password = password;
		this.direccion = direccion;
		this.telefono = telefono;
		this.club = club;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return this.apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getDireccion() {
		return this.direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public int getTelefono() {
		return this.telefono;
	}

	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}

	public String getClub() {
		return this.club;
	}

	public void setClub(String club) {
		this.club = club;
	}

}
