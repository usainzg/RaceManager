package clases;

import java.util.Date;

public class Carrera {
	
	// Carrera class params
	private String nbCarrera;
	private UsuarioOrganizador orgCarrera;
	private int distanciaCarrera;
	private int desnivelCarrera;
	private int precioCarrera;
	private Date fechaCarrera;
	private String lugarCarrera;
	
	public Carrera(String nombre, UsuarioOrganizador organizador, int distancia, int desnivel, int precio, 
			Date fecha, String lugar){
		this.nbCarrera = nombre;
		this.orgCarrera = organizador;
		this.distanciaCarrera = distancia;
		this.desnivelCarrera = desnivel;
		this.precioCarrera = precio;
		this.fechaCarrera = fecha;
		this.lugarCarrera = lugar;
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

	public Date getFechaCarrera() {
		return fechaCarrera;
	}

	public void setFechaCarrera(Date fechaCarrera) {
		this.fechaCarrera = fechaCarrera;
	}

	public String getLugarCarrera() {
		return lugarCarrera;
	}

	public void setLugarCarrera(String lugarCarrera) {
		this.lugarCarrera = lugarCarrera;
	}
	
	
	

}
