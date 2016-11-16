package clases;

public class Carrera {

	// Carrera class params
	private String nbCarrera;
	private UsuarioOrganizador orgCarrera;
	private int distanciaCarrera;
	private int desnivelCarrera;
	private int precioCarrera;
	private String fechaCarrera;
	private String lugarCarrera;

	public Carrera(String nombre, UsuarioOrganizador organizador, int distancia, int desnivel, int precio, String fecha,
			String lugar) {
		this.nbCarrera = nombre;
		this.orgCarrera = organizador;
		this.distanciaCarrera = distancia;
		this.desnivelCarrera = desnivel;
		this.precioCarrera = precio;
		this.fechaCarrera = fecha;
		this.lugarCarrera = lugar;
	}

	public Carrera(clasesHibernate.Carrera c) {
		this.nbCarrera = c.getNombre();
		this.distanciaCarrera = c.getDistancia();
		this.desnivelCarrera = c.getDesnivel();
		this.precioCarrera = c.getPrecio();
		this.fechaCarrera = c.getFecha().toString();
		this.lugarCarrera = c.getLugar();

		UsuarioOrganizador org = new UsuarioOrganizador();
		org.setId(c.getUsuarioorganizador().getId());
		org.setNbUsuario(c.getUsuarioorganizador().getNombre());
		org.setTelfUsuario(c.getUsuarioorganizador().getTelefono());
		org.setPassUsuario(c.getUsuarioorganizador().getPassword());
		org.setEmailUsuario(c.getUsuarioorganizador().getEmail());
		org.setDirUsuario(c.getUsuarioorganizador().getDireccion());
		org.setClubUsuario(c.getUsuarioorganizador().getClub());
		org.setApellidosUsuario(c.getUsuarioorganizador().getApellidos());

		this.orgCarrera = org;
	}

	public Carrera() {
	}

	// getters and setters
	public String getNbCarrera() {
		return nbCarrera;
	}

	public void setNbCarrera(String nbCarrera) {
		this.nbCarrera = nbCarrera;
	}

	public UsuarioOrganizador getOrgCarrera() {
		return orgCarrera;
	}

	public void setOrgCarrera(UsuarioOrganizador orgCarrera) {
		this.orgCarrera = orgCarrera;
	}

	public int getDistanciaCarrera() {
		return distanciaCarrera;
	}

	public void setDistanciaCarrera(int distanciaCarrera) {
		this.distanciaCarrera = distanciaCarrera;
	}

	public int getDesnivelCarrera() {
		return desnivelCarrera;
	}

	public void setDesnivelCarrera(int desnivelCarrera) {
		this.desnivelCarrera = desnivelCarrera;
	}

	public int getPrecioCarrera() {
		return precioCarrera;
	}

	public void setPrecioCarrera(int precioCarrera) {
		this.precioCarrera = precioCarrera;
	}

	public String getFechaCarrera() {
		return fechaCarrera;
	}

	public void setFechaCarrera(String fechaCarrera) {
		this.fechaCarrera = fechaCarrera;
	}

	public String getLugarCarrera() {
		return lugarCarrera;
	}

	public void setLugarCarrera(String lugarCarrera) {
		this.lugarCarrera = lugarCarrera;
	}

}
