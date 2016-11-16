package bbdd;

import java.sql.Connection;
import java.util.ArrayList;

import clases.Carrera;
import clases.UsuarioAdmin;
import clases.UsuarioNormal;
import clases.UsuarioOrganizador;

public abstract interface InterfazBD {

	// to connect database
	abstract Connection conectarBD() throws Exception;

	// selects
	abstract ArrayList<Carrera> consultarCarreras() throws Exception;

	abstract ArrayList<UsuarioNormal> consultarUsuariosEstandar() throws Exception;

	abstract ArrayList<UsuarioOrganizador> consultarUsuariosOrganizador() throws Exception;

	abstract ArrayList<Carrera> consultarCarrerasOrg(UsuarioOrganizador org) throws Exception;

	// selects para vista
	abstract ArrayList<UsuarioNormal> consultarEmailNormal() throws Exception;

	abstract ArrayList<UsuarioOrganizador> consultarEmailOrg() throws Exception;

	// inserts
	abstract int altaCarrera(Carrera c) throws Exception;

	abstract int altaOrganizador(UsuarioOrganizador uOrg) throws Exception;

	abstract int altaUsuarioNormal(UsuarioNormal uStd) throws Exception;

	// deletes
	abstract int deleteCarrera(Carrera c) throws Exception;

	abstract int deleteUsuarioOrganizador(UsuarioOrganizador uOrg) throws Exception;

	abstract int deleteUsuarioNormal(UsuarioNormal uStd) throws Exception;

	// updates
	abstract int updateCarreraAdmin(Carrera c) throws Exception;

	abstract int updateCarreraOrg(Carrera cViejo, Carrera c) throws Exception;

	abstract int updateUsuarioOrganizador(UsuarioOrganizador uOrg, UsuarioOrganizador datos) throws Exception;

	abstract int updateUsuarioNormal(UsuarioNormal datos) throws Exception;

	// sistema login
	abstract boolean loginAdmin(UsuarioAdmin admin) throws Exception;

	abstract boolean loginNormal(UsuarioNormal uStd) throws Exception;

	abstract boolean loginOrganizador(UsuarioOrganizador uOrg) throws Exception;
}
