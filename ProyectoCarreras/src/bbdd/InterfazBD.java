package bbdd;

import java.sql.Connection;
import java.util.ArrayList;

import clases.Carrera;
import clases.Usuario;

public abstract interface InterfazBD {
	
	// to connect database
	abstract Connection conectarBD() throws Exception;
	
	// selects
	abstract ArrayList<Carrera> consultarCarreras() throws Exception;
	abstract ArrayList<Usuario> consultarUsuarios() throws Exception;
	
	//inserts
	abstract int altaCarrera(Carrera c) throws Exception;
	abstract int altaUsuario(Usuario u) throws Exception;
	
	// deletes
	abstract int deleteCarrera(Carrera c) throws Exception;
	abstract int deleteUsuario(Usuario u) throws Exception;
	// updates
	abstract int updateCarrera(Carrera c) throws Exception;
	abstract int updateUsuario(Usuario u) throws Exception;

}
