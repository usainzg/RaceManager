package bbdd;

import java.sql.Connection;
import java.util.ArrayList;

import clases.Carrera;
import clases.UsuarioAdmin;
import clases.UsuarioEstandar;
import clases.UsuarioOrganizador;

public abstract interface InterfazBD {
	
	// to connect database
	abstract Connection conectarBD() throws Exception;
	
	// selects
	abstract ArrayList<Carrera> consultarCarreras() throws Exception;
	abstract ArrayList<UsuarioEstandar> consultarUsuariosEstandar() throws Exception;
	abstract ArrayList<UsuarioOrganizador> consultarUsuariosOrganizador() throws Exception;
	
	// selects para vista
	abstract ArrayList<UsuarioEstandar> consultarEmailNormal() throws Exception;
	abstract ArrayList<UsuarioOrganizador> consultarEmailOrg() throws Exception;
	
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
	abstract int updateUsuarioOrganizador(UsuarioOrganizador uOrg, UsuarioOrganizador datos) throws Exception;
	abstract int updateUsuarioNormal(UsuarioEstandar uStd, UsuarioEstandar datos) throws Exception;
	
	// sistema login
	abstract boolean loginAdmin(UsuarioAdmin admin) throws Exception;
	abstract boolean loginNormal(UsuarioEstandar uStd) throws Exception;
	abstract boolean loginOrganizador(UsuarioOrganizador uOrg) throws Exception;
}
