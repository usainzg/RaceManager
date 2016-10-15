package bbdd;

import java.sql.Connection;
import java.sql.ResultSet;

import clases.Carrera;
import clases.UsuarioAdmin;
import clases.UsuarioEstandar;
import clases.UsuarioOrganizador;

public abstract interface InterfazBD {
	
	// to connect database
	abstract Connection conectarBD() throws Exception;
	
	// selects
	abstract ResultSet consultarCarreras() throws Exception;
	abstract ResultSet consultarUsuariosEstandar() throws Exception;
	abstract ResultSet consultarUsuariosOrganizador() throws Exception;
	
	//inserts
	abstract int altaCarrera(Carrera c) throws Exception;
	abstract int altaOrganizador(UsuarioOrganizador uOrg) throws Exception;
	abstract int altaUsuarioNormal(UsuarioEstandar uStd) throws Exception;
	
	// deletes
	abstract int deleteCarrera(Carrera c) throws Exception;
	abstract int deleteUsuarioOrganizador(UsuarioOrganizador uOrg) throws Exception;
	abstract int deleteUsuarioNormal(UsuarioEstandar uStd) throws Exception;
	
	// updates
	abstract int updateCarrera(Carrera c) throws Exception;
	abstract int updateUsuarioOrganizador(UsuarioOrganizador uOrg) throws Exception;
	abstract int updateUsuarioNormal(UsuarioEstandar uStd) throws Exception;
	
	// sistema login
	abstract boolean loginAdmin(UsuarioAdmin admin) throws Exception;
	abstract boolean loginNormal(UsuarioEstandar uStd) throws Exception;
	abstract boolean loginOrganizador(UsuarioOrganizador uOrg) throws Exception;
}
