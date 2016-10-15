package bbdd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import clases.Carrera;
import clases.UsuarioAdmin;
import clases.UsuarioEstandar;
import clases.UsuarioOrganizador;
import utilidades.Utilidades;

public class MySqlManager implements InterfazBD{
	
	private static final String URL_DB = "jdbc:mysql://localhost/proyectobd";
	private final Utilidades util = new Utilidades();
	
	public MySqlManager(){ }
	
	@Override
	public Connection conectarBD() throws Exception {
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection conexion = DriverManager.getConnection(URL_DB, "root", "");
			return conexion;
		}catch(ClassNotFoundException cnE){
			System.out.println("hola");
			cnE.printStackTrace();
			return null;
		}catch(SQLException e){
			e.printStackTrace();
			return null;
		}
	}
	
	// SELECT큦
	@Override
	public ResultSet consultarCarreras() throws Exception {
		Connection cn = conectarBD();
		if(cn == null){
			util.createErrorbox("No se ha podido establecer conexion con la base de datos.", "Error al conectar base de datos.");
		}
		try{
			String sql = "SELECT * FROM carrera";
			Statement sentencia = cn.createStatement();
			return sentencia.executeQuery(sql);
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}finally{
			if(cn != null)
				cn.close();
		}
	}
	
	@Override
	public ResultSet consultarUsuariosOrganizador() throws Exception {
		Connection cn = conectarBD();
		if(cn == null){
			util.createErrorbox("No se ha podido establecer conexion con la base de datos.", "Error al conectar base de datos.");
		}
		
		try{
			String sql = "SELECT * FROM usuarioorganizador";
			Statement sentencia = cn.createStatement();
			return sentencia.executeQuery(sql);
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}finally{
			if(cn != null)
				cn.close();
		}
	}
	
	@Override
	public ResultSet consultarUsuariosEstandar() throws Exception {
		Connection cn = conectarBD();
		if(cn == null){
			util.createErrorbox("No se ha podido establecer conexion con la base de datos.", "Error al conectar base de datos.");
		}
		
		try{
			String sql = "SELECT * FROM usuarionormal";
			Statement sentencia = cn.createStatement();
			return sentencia.executeQuery(sql);
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}finally{
			if(cn != null)
				cn.close();
		}
	}
	// end selects


	// INSERT큦
	@Override
	public int altaCarrera(Carrera c) throws Exception {
		Connection cn = conectarBD();
		if(cn == null){
			return -1;
		}

		try{
			String sql = "INSERT INTO carrera (nombre, organizador, distancia, desnivel, precio, fecha, lugar) VALUES (" + c.getNbCarrera() + "," + 
					c.getOrgCarrera().getId() + "," + c.getDistanciaCarrera() + "," + c.getDesnivelCarrera() + "," + c.getPrecioCarrera() + "," + c.getFechaCarrera() +
					"," + c.getLugarCarrera() + ")";
			Statement sentencia = cn.createStatement();
			return sentencia.executeUpdate(sql);
		}catch(Exception e){
			return -1;
		}finally{
			if(cn != null)
				cn.close();
		}	
	}
	
	@Override
	public int altaOrganizador(UsuarioOrganizador uOrg) throws Exception {
		Connection cn = conectarBD();
		if(cn == null){
			util.createErrorbox("No se ha podido establecer conexion con la base de datos.", "Error al conectar base de datos.");
		}
		
		try{
			String sql = "INSERT INTO usuarioorganizador (nombre, apellidos, email, password, direccion, telefono, club) VALUES ('"+ 
					uOrg.getNbUsuario() + "','" + uOrg.getApellidosUsuario() + "','" + uOrg.getEmailUsuario() + "','" + uOrg.getPassUsuario() + "','" + uOrg.getDirUsuario() +
					"','" + uOrg.getTelfUsuario() + "','" + uOrg.getClubUsuario() + "')";
			Statement sentencia = cn.createStatement();
			return sentencia.executeUpdate(sql);
		}catch(Exception e){
			return -1;
		}finally{
			if(cn != null)
				cn.close();
		}	
	}

	@Override
	public int altaUsuarioNormal(UsuarioEstandar uStd) throws Exception {
		Connection cn = conectarBD();
		if(cn == null){
			util.createErrorbox("No se ha podido establecer conexion con la base de datos.", "Error al conectar base de datos.");
		}
		
		try{
			String sql = "INSERT INTO usuarionormal (nombre, apellidos, email, password, direccion, telefono, club) VALUES ('" +
					uStd.getNbUsuario() + "','" + uStd.getApellidosUsuario() + "','" + uStd.getEmailUsuario() + "','" + uStd.getPassUsuario() + "','" + uStd.getDirUsuario() +
					"','" + uStd.getTelfUsuario() + "','" + uStd.getClubUsuario() + "')";
			Statement sentencia = cn.createStatement();
			
			return sentencia.executeUpdate(sql);
		}catch(Exception e){
			return -1;
		}finally{
			if(cn != null)
				cn.close();
		}	
	}
	// END INSERT큦

	
	// DELETE큦
	@Override
	public int deleteCarrera(Carrera c) throws Exception {
		Connection cn = conectarBD();
		if(cn == null){
			return -1;
		}
		try{
			String sql = "DELETE FROM carrera WHERE nombre=" + c.getNbCarrera();
			Statement sentencia = cn.createStatement();
			return sentencia.executeUpdate(sql);
		}catch(Exception e){
			return -1;
		}finally{
			if(cn != null)
				cn.close();
		}
	}
	
	@Override
	public int deleteUsuarioOrganizador(UsuarioOrganizador uOrg) throws Exception {
		Connection cn = conectarBD();
		if(cn == null){
			util.createErrorbox("No se ha podido establecer conexion con la base de datos.", "Error al conectar base de datos.");
		}
		try{
			String sql = "DELETE FROM usuarioorganizador WHERE email=" + uOrg.getEmailUsuario();
			Statement sentencia = cn.createStatement();
			return sentencia.executeUpdate(sql);
		}catch(Exception e){
			return -1;
		}finally{
			if(cn != null)
				cn.close();
		}
	}

	@Override
	public int deleteUsuarioNormal(UsuarioEstandar uStd) throws Exception {
		Connection cn = conectarBD();
		if(cn == null){
			util.createErrorbox("No se ha podido establecer conexion con la base de datos.", "Error al conectar base de datos.");
		}
		try{
			String sql = "DELETE FROM usuarionormal WHERE email=" + uStd.getEmailUsuario();
			Statement sentencia = cn.createStatement();
			return sentencia.executeUpdate(sql);
		}catch(Exception e){
			return -1;
		}finally{
			if(cn != null)
				cn.close();
		}
	}
	// END DELETE큦

	
	// UPDATE큦
	@Override
	public int updateCarrera(Carrera c) throws Exception {
		Connection cn = conectarBD();
		if(cn == null){
			util.createErrorbox("No se ha podido establecer conexion con la base de datos.", "Error al conectar base de datos.");
		}
		return 0;
	}

	@Override
	public int updateUsuarioOrganizador(UsuarioOrganizador uOrg) throws Exception {
		Connection cn = conectarBD();
		if(cn == null){
			return -1;
		}
		return 0;
	}

	@Override
	public int updateUsuarioNormal(UsuarioEstandar uStd) throws Exception {
		Connection cn = conectarBD();
		if(cn == null){
			return -1;
		}
		return 0;
	}
	// END OF UPDATE큦
	

	// LOGIN SYSTEM
	@Override
	public boolean loginAdmin(UsuarioAdmin admin) throws Exception {
		Connection cn = conectarBD();
		if(cn == null){
			return false;
		}
		try {
			// select for check if exits in DB
			String sql = "SELECT * FROM usuarioadmin WHERE email='" + admin.getEmailUsuario() + "' && password='" + admin.getPassUsuario() + "'";
			Statement sentencia = cn.createStatement();
			ResultSet rs = sentencia.executeQuery(sql);
			
			if (rs.next() == false) {    
			    return false;
			}else{
				return true;
			}
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}finally{
			if(cn != null)
				cn.close();
		}
	}

	@Override
	public boolean loginNormal(UsuarioEstandar uStd) throws Exception {
		Connection cn = conectarBD();
		if(cn == null){
			return false;
		}
		try {
			// select for check if exits in DB
			String sql = "SELECT * FROM usuarionormal WHERE email='" + uStd.getEmailUsuario() + "' && password='" + uStd.getPassUsuario() + "'";
			Statement sentencia = cn.createStatement();
			ResultSet rs = sentencia.executeQuery(sql);
			
			if (rs.next() == false) {    
			    return false;
			}else{
				return true;
			}
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}finally{
			if(cn != null)
				cn.close();
		}
	}

	@Override
	public boolean loginOrganizador(UsuarioOrganizador uOrg) throws Exception {
		Connection cn = conectarBD();
		if(cn == null){
			return false;
		}
		try {
			// select for check if exits in DB
			String sql = "SELECT * FROM usuarioorganizador WHERE email='" + uOrg.getEmailUsuario() + "' && password='" + uOrg.getPassUsuario() + "'";
			Statement sentencia = cn.createStatement();
			ResultSet rs = sentencia.executeQuery(sql);
			
			if (rs.next() == false) {    
			    return false;
			}else{
				return true;
			}
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}finally{
			if(cn != null)
				cn.close();
		}
	}
	// END OF LOGIN

	

}
