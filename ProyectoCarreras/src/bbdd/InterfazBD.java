package bbdd;

import java.sql.Connection;
import java.util.ArrayList;

import clases.Carrera;
import clases.UsuarioAdmin;
import clases.UsuarioNormal;
import clases.UsuarioOrganizador;

public abstract interface InterfazBD {
	
	/**
	 * Interfaz para el manejo de la Base de datos
	 * 
	 * @author Unai Sainz de la Maza Gamboa
	 * 
	 **/

	/**
	 * Devuelve un objeto Connection para ser usado con MySQL
	 * 
	 * @return Un objeto del tipo Connection
	 * @throws Exception ClassNotFoundException o SQLException
	 */
	abstract Connection conectarBD() throws Exception;

	/**
	 * Metodo para consultar todas las carreras
	 * 
	 * @return Un ArrayList de objetos del tipo Carrera
	 * @throws Exception SQLException
	 */
	abstract ArrayList<Carrera> consultarCarreras() throws Exception;

	/**
	 * Metodo para consultar todos los usuarios del tipo Normal
	 * 
	 * @return Un ArrayList de objetos del tipo UsuarioNormal
	 * @throws Exception SQLException
	 */
	abstract ArrayList<UsuarioNormal> consultarUsuariosEstandar() throws Exception;

	/**
	 * Metodo para consultar todos los usuarios del tipo Organizador
	 * 
	 * @return Un ArrayList de objetos del tipo UsuarioOrganizador
	 * @throws Exception SQLException
	 */
	abstract ArrayList<UsuarioOrganizador> consultarUsuariosOrganizador() throws Exception;

	/**
	 * Motodo para consultar las carreras de un unico Organizador (el logeado)
	 * 
	 * @param org Organizador logeado
	 * @return Un ArrayList de objetos del tipo Carrera
	 * @throws Exception SQLException
	 */
	abstract ArrayList<Carrera> consultarCarrerasOrg(UsuarioOrganizador org) throws Exception;

	/**
	 * Metodo para consultar el email de los usuarios normales y asi no tener que consultar
	 * todos los datos los mismos para algunas funciones de la vista.
	 * 
	 * @return ArrayList de objetos del tipo UsuarioNormal
	 * @throws Exception SQLException
	 */
	abstract ArrayList<UsuarioNormal> consultarEmailNormal() throws Exception;

	/**
	 * Metodo para consultar el email de los usuarios organizadores y asi no tener que consultar
	 * todos los datos los mismos para algunas funciones de la vista.
	 * 
	 * @return ArrayList de objetos del tipo UsuarioOrganizador
	 * @throws Exception SQLException 
	 */
	abstract ArrayList<UsuarioOrganizador> consultarEmailOrg() throws Exception;

	/**
	 * Metodo para las altas de las carreras
	 * 
	 * @param c objeto a insertar
	 * @return el numero de filas introducidas, 1 si se ha introducido o 0 en caso contrario
	 * @throws Exception SQLException
	 */
	abstract int altaCarrera(Carrera c) throws Exception;

	/**
	 * Metodo para dar de alta a los Usuarios Organizadores
	 * 
	 * @param uOrg objeto a insertar
	 * @return el numero de filas introducidas, 1 si se ha introducido o 0 en caso contrario
	 * @throws Exception SQLException
	 */
	abstract int altaOrganizador(UsuarioOrganizador uOrg) throws Exception;

	/**
	 * Metodo para dar de alta a los Usuarios Normales
	 * 
	 * @param uStd objeto a insertar
	 * @return el numero de filas introducidas, 1 si se ha introducido o 0 en caso contrario
	 * @throws Exception SQLException
	 */
	abstract int altaUsuarioNormal(UsuarioNormal uStd) throws Exception;

	/**
	 * Metodo para dar de baja una carrera
	 * 
	 * @param c objeto a eliminar
	 * @return el numero de filas eliminadas, 1 si se ha eliminado o 0 en caso contrario
	 * @throws Exception SQLException
	 */
	abstract int deleteCarrera(Carrera c) throws Exception;

	/**
	 * Metodo para dar de baja a un usuario organizador
	 * 
	 * @param uOrg objeto a eliminar
	 * @return el numero de filas eliminadas, 1 si se ha eliminado o 0 en caso contrario
	 * @throws Exception SQLException
	 */
	abstract int deleteUsuarioOrganizador(UsuarioOrganizador uOrg) throws Exception;

	/**
	 * Metodo para dar de baja a un usuario normal
	 * 
	 * @param uStd objeto a eliminar
	 * @return el numero de filas eliminadas, 1 si se ha eliminado o 0 en caso contrario
	 * @throws Exception SQLException
	 */
	abstract int deleteUsuarioNormal(UsuarioNormal uStd) throws Exception;

	/**
	 * Metodo para modificar carreras
	 * @param c objeto a modificar
	 * @return el numero de filas modificadas, 1 si se ha modificado o 0 en caso contrario
	 * @throws Exception SQLException 
	 */
	abstract int updateCarrera(Carrera c) throws Exception;

	/**
	 * Metodo para modificar los usuarios del tipo organizador
	 * 
	 * @param uOrg objeto para saber cual es el email del org a modificar
	 * @param datos objeto con los nuevos datos para modificar el registro
	 * @return el numero de filas modificadas, 1 si se ha modificado o 0 en caso contrario
	 * @throws Exception SQLException
	 */
	abstract int updateUsuarioOrganizador(UsuarioOrganizador uOrg, UsuarioOrganizador datos) throws Exception;

	/**
	 * Metodo para modificar los usuarios del tipo normal
	 * 
	 * @param datos objeto con los nuevos datos para modificar el registro
	 * @return el numero de filas modificadas, 1 si se ha modificado o 0 en caso contrario
	 * @throws Exception SQLException
	 */
	abstract int updateUsuarioNormal(UsuarioNormal datos) throws Exception;

	/**
	 * Metodo para el login del admin
	 * @param admin objeto admin a logear
	 * @return true si los datos coinciden, false si son erroneos
	 * @throws Exception SQLException
	 */
	abstract boolean loginAdmin(UsuarioAdmin admin) throws Exception;

	/**
	 * Metodo para el login de los usuarios normales
	 * @param uStd objeto usuario normal a logear
	 * @return true si los datos coinciden, false si son erroneos
	 * @throws Exception SQLException
	 */
	abstract boolean loginNormal(UsuarioNormal uStd) throws Exception;

	/**
	 * Metodo para el login de los usuarios organizadores
	 * 
	 * @param uOrg objeto usuario organizador a logear
	 * @return true si los datos coinciden, false si son erroneos
	 * @throws Exception SQLException
	 */
	abstract boolean loginOrganizador(UsuarioOrganizador uOrg) throws Exception;
}
