package bbdd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import clases.Carrera;
import clases.UsuarioAdmin;
import clases.UsuarioNormal;
import clases.UsuarioOrganizador;
import utilidades.Utilidades;

public class OracleManager extends MainDBManager{
	
	private final String ORACLE_DRIVER = "oracle.jdbc.driver.OracleDriver";
	private final String URL_DB = "jdbc:oracle:thin:@192.168.56.101:1521:XE";
	private final String DB_USER_ORACLE = "system";
	private final String DB_PASS_ORACLE = "unai1808";
	private final String DB_SERVER_ADDR = "192.168.56.101";
	
	private final Utilidades util = new Utilidades();
	
	@Override
	public Connection conectarBD() throws Exception {
		try {
			Class.forName(ORACLE_DRIVER != null ? ORACLE_DRIVER : "oracle.jdbc.driver.OracleDriver");
			Connection conexion = DriverManager
					.getConnection(URL_DB != null ? URL_DB : "jdbc:oracle:thin:@" + DB_SERVER_ADDR + ":1521:XE", DB_USER_ORACLE, DB_PASS_ORACLE);
			return conexion;
		} catch (ClassNotFoundException cnE) {
			cnE.printStackTrace();
			return null;
		} catch (SQLException e) {
			e.printStackTrace();
			util.createErrorbox("No se ha podido establecer conexion con la BD", "Error conexion BD");
			return null;
		}
	}
	@Override
	public ArrayList<Carrera> consultarCarreras() throws Exception {
		Connection cn = conectarBD();
		if (cn == null) {
			util.createErrorbox("No se ha podido establecer conexion con la base de datos.",
					"Error al conectar base de datos.");
		}
		try {
			String sql = "SELECT c.*, org.nombre AS nb_org, org.id AS id_org FROM CARRERAS c " +
					"INNER JOIN USUARIOS_ORGANIZADOR org " +
					"ON c.organizador.id = org.id";
			PreparedStatement sentencia = cn.prepareStatement(sql);
			ResultSet rs = sentencia.executeQuery();
			ArrayList<Carrera> arr = new ArrayList<Carrera>();
			while (rs.next()) {
				Carrera c = new Carrera();
				c.setNbCarrera(rs.getString("nombre"));
				c.setOrgCarrera(new UsuarioOrganizador(rs.getString("nb_org"), null, null, null, null, 0, null,
						rs.getInt("id_org")));
				c.setDistanciaCarrera(rs.getInt("distancia"));
				c.setDesnivelCarrera(rs.getInt("desnivel"));
				c.setPrecioCarrera(rs.getInt("precio"));
				c.setLugarCarrera(rs.getString("lugar"));
				c.setFechaCarrera(rs.getDate("fecha").toString());
				arr.add(c);
			}
			rs.close();
			return arr;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			if (cn != null)
				cn.close();
		}
	}
	
	@Override
	public ArrayList<UsuarioNormal> consultarUsuariosEstandar() throws Exception {
		Connection cn = conectarBD();
		if (cn == null) {
			util.createErrorbox("No se ha podido establecer conexion con la base de datos.",
					"Error al conectar base de datos.");
		}

		try {
			String sql = "SELECT * FROM USUARIOS_NORMAL";
			Statement sentencia = cn.createStatement();
			ResultSet rs = sentencia.executeQuery(sql);
			ArrayList<UsuarioNormal> arr = new ArrayList<UsuarioNormal>();
			while (rs.next()) {
				UsuarioNormal uStd = new UsuarioNormal();
				uStd.setNbUsuario(rs.getString("nombre"));
				uStd.setApellidosUsuario(rs.getString("apellidos"));
				uStd.setEmailUsuario(rs.getString("email"));
				uStd.setPassUsuario(rs.getString("password"));
				uStd.setDirUsuario(rs.getString("direccion"));
				uStd.setTelfUsuario(rs.getInt("telefono"));
				uStd.setClubUsuario(rs.getString("club"));
				arr.add(uStd);
			}
			rs.close();
			return arr;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			if (cn != null)
				cn.close();
		}
	}
	@Override
	public ArrayList<UsuarioOrganizador> consultarUsuariosOrganizador() throws Exception {
		Connection cn = conectarBD();
		if (cn == null) {
			util.createErrorbox("No se ha podido establecer conexion con la base de datos.",
					"Error al conectar base de datos.");
		}

		try {
			String sql = "SELECT * FROM USUARIOS_ORGANIZADOR";
			Statement sentencia = cn.createStatement();
			ResultSet rs = sentencia.executeQuery(sql);
			ArrayList<UsuarioOrganizador> arr = new ArrayList<UsuarioOrganizador>();
			while (rs.next()) {
				UsuarioOrganizador uOrg = new UsuarioOrganizador();
				uOrg.setNbUsuario(rs.getString("nombre"));
				uOrg.setApellidosUsuario(rs.getString("apellidos"));
				uOrg.setEmailUsuario(rs.getString("email"));
				uOrg.setPassUsuario(rs.getString("password"));
				uOrg.setDirUsuario(rs.getString("direccion"));
				uOrg.setTelfUsuario(rs.getInt("telefono"));
				uOrg.setClubUsuario(rs.getString("club"));
				arr.add(uOrg);
			}
			rs.close();
			return arr;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			if (cn != null)
				cn.close();
		}
	}
	@Override
	public ArrayList<Carrera> consultarCarrerasOrg(UsuarioOrganizador org) throws Exception {
		Connection cn = conectarBD();
		if (cn == null) {
			util.createErrorbox("No se ha podido establecer conexion con la base de datos.",
					"Error al conectar base de datos.");
		}
		try {
			String sql = "SELECT c.* FROM CARRERAS c "
					+ "WHERE c.organizador.id= (SELECT id FROM USUARIOS_ORGANIZADOR WHERE email= '" + org.getEmailUsuario()
					+ "')";
			
			Statement sentencia = cn.createStatement();
			ResultSet rs = sentencia.executeQuery(sql);
			ArrayList<Carrera> arr = new ArrayList<Carrera>();
			while (rs.next()) {
				Carrera c = new Carrera();
				c.setNbCarrera(rs.getString("nombre"));
				c.setOrgCarrera(org);
				c.setDistanciaCarrera(rs.getInt("distancia"));
				c.setDesnivelCarrera(rs.getInt("desnivel"));
				c.setPrecioCarrera(rs.getInt("precio"));
				c.setLugarCarrera(rs.getString("lugar"));
				c.setFechaCarrera(rs.getDate("fecha").toString());
				arr.add(c);
			}
			rs.close();
			return arr;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			if (cn != null)
				cn.close();
		}
	}
	@Override
	public ArrayList<UsuarioNormal> consultarEmailNormal() throws Exception {
		Connection cn = conectarBD();
		if (cn == null) {
			return null;
		}

		try {
			String sql = "SELECT email FROM USUARIOS_NORMAL";
			Statement sentencia = cn.createStatement();
			ResultSet rs = sentencia.executeQuery(sql);

			ArrayList<UsuarioNormal> arr = new ArrayList<UsuarioNormal>();
			while (rs.next()) {
				UsuarioNormal uStd = new UsuarioNormal();
				uStd.setNbUsuario("");
				uStd.setApellidosUsuario("");
				uStd.setEmailUsuario(rs.getString("email"));
				uStd.setPassUsuario("");
				uStd.setDirUsuario("");
				uStd.setTelfUsuario(0);
				uStd.setClubUsuario("");
				arr.add(uStd);
			}
			rs.close();
			return arr;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			if (cn != null)
				cn.close();
		}
	}
	@Override
	public ArrayList<UsuarioOrganizador> consultarEmailOrg() throws Exception {
		Connection cn = conectarBD();
		if (cn == null) {
			return null;
		}

		try {
			String sql = "SELECT email FROM USUARIOS_ORGANIZADOR";
			Statement sentencia = cn.createStatement();
			ResultSet rs = sentencia.executeQuery(sql);

			ArrayList<UsuarioOrganizador> arr = new ArrayList<UsuarioOrganizador>();
			while (rs.next()) {
				UsuarioOrganizador uOrg = new UsuarioOrganizador();
				uOrg.setNbUsuario("");
				uOrg.setApellidosUsuario("");
				uOrg.setEmailUsuario(rs.getString("email"));
				uOrg.setPassUsuario("");
				uOrg.setDirUsuario("");
				uOrg.setTelfUsuario(0);
				uOrg.setClubUsuario("");
				arr.add(uOrg);
			}
			rs.close();
			return arr;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			if (cn != null)
				cn.close();
		}
	}
	@Override
	public int altaCarrera(Carrera c) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}
	
	@Override
	public int altaOrganizador(UsuarioOrganizador uOrg) throws Exception {
		Connection cn = conectarBD();
		if (cn == null) {
			util.createErrorbox("No se ha podido establecer conexion con la base de datos.",
					"Error al conectar base de datos.");
		}

		try {
			
			String sql = "INSERT INTO USUARIOS_ORGANIZADOR VALUES (USUARIO_ORGANIZADOR (id_org.nextval, '" + uOrg.getNbUsuario() +
					"','" + uOrg.getApellidosUsuario() + "','" + uOrg.getEmailUsuario() + "','" + uOrg.getPassUsuario() + "','" +
					uOrg.getDirUsuario() + "','" + uOrg.getTelfUsuario() + "','" + uOrg.getClubUsuario() + "'))";
			
			Statement sentencia = cn.createStatement();
			return sentencia.executeUpdate(sql);
		} catch (Exception e) {
			e.printStackTrace();
			return -1;
		} finally {
			if (cn != null)
				cn.close();
		}
	}
	@Override
	public int altaUsuarioNormal(UsuarioNormal uStd) throws Exception {
		Connection cn = conectarBD();
		if (cn == null) {
			util.createErrorbox("No se ha podido establecer conexion con la base de datos.",
					"Error al conectar base de datos.");
		}

		try {
			String sql = "INSERT INTO USUARIOS_NORMAL VALUES (USUARIO_NORMAL ('" + uStd.getNbUsuario() +
					"','" + uStd.getApellidosUsuario() + "','" + uStd.getEmailUsuario() + "','" + uStd.getPassUsuario() + "','" +
					uStd.getDirUsuario() + "','" + uStd.getTelfUsuario() + "','" + uStd.getClubUsuario() + "'))";
			
			Statement sentencia = cn.createStatement();
			return sentencia.executeUpdate(sql);
		} catch (Exception e) {
			return -1;
		} finally {
			if (cn != null)
				cn.close();
		}
	}
	@Override
	public int deleteCarrera(Carrera c) throws Exception {
		Connection cn = conectarBD();
		if (cn == null) {
			return -1;
		}
		try {
			String sql = "DELETE FROM CARRERAS WHERE nombre='" + c.getNbCarrera() + "'";
			Statement sentencia = cn.createStatement();
			return sentencia.executeUpdate(sql);
		} catch (Exception e) {
			return -1;
		} finally {
			if (cn != null)
				cn.close();
		}
	}
	@Override
	public int deleteUsuarioOrganizador(UsuarioOrganizador uOrg) throws Exception {
		Connection cn = conectarBD();
		if (cn == null) {
			util.createErrorbox("No se ha podido establecer conexion con la base de datos.",
					"Error al conectar base de datos.");
		}
		try {
			String sql = "DELETE FROM USUARIOS_ORGANIZADOR WHERE email='" + uOrg.getEmailUsuario() + "'";
			Statement sentencia = cn.createStatement();
			return sentencia.executeUpdate(sql);
		} catch (Exception e) {
			return -1;
		} finally {
			if (cn != null)
				cn.close();
		}
	}
	@Override
	public int deleteUsuarioNormal(UsuarioNormal uStd) throws Exception {
		Connection cn = conectarBD();
		if (cn == null) {
			util.createErrorbox("No se ha podido establecer conexion con la base de datos.",
					"Error al conectar base de datos.");
		}
		try {
			String sql = "DELETE FROM USUARIOS_NORMAL WHERE email='" + uStd.getEmailUsuario() + "'";
			Statement sentencia = cn.createStatement();
			return sentencia.executeUpdate(sql);
		} catch (Exception e) {
			return -1;
		} finally {
			if (cn != null)
				cn.close();
		}
	}
	@Override
	public int updateCarrera(Carrera c) throws Exception {
		Connection cn = conectarBD();
		if (cn == null) {
			return -1;
		}
		try {
			String sql = "UPDATE CARRERAS SET distancia='" + c.getDistanciaCarrera() + "',desnivel='"
					+ c.getDesnivelCarrera() + "',precio='" + c.getPrecioCarrera() + "',fecha=TO_DATE('"
					+ c.getFechaCarrera() + "','YYYY-MM-DD'),lugar='" + c.getLugarCarrera() + "' WHERE nombre='" + c.getNbCarrera()
					+ "'";
			Statement sentencia = cn.createStatement();
			return sentencia.executeUpdate(sql);
		} catch (Exception e) {
			e.printStackTrace();
			return -1;
		} finally {
			if (cn != null)
				cn.close();
		}
	}
	@Override
	public int updateUsuarioOrganizador(UsuarioOrganizador uOrg, UsuarioOrganizador datos) throws Exception {
		Connection cn = conectarBD();
		if (cn == null) {
			return -1;
		}
		try {
			String sql = "UPDATE USUARIOS_ORGANIZADOR SET nombre='" + datos.getNbUsuario() + "',apellidos='"
					+ datos.getApellidosUsuario() + "',direccion='" + datos.getDirUsuario() + "',password='"
					+ datos.getPassUsuario() + "',telefono='" + datos.getTelfUsuario() + "',club='"
					+ datos.getClubUsuario() + "' WHERE email='" + uOrg.getEmailUsuario() + "'";

			Statement sentencia = cn.createStatement();

			return sentencia.executeUpdate(sql);
		} catch (Exception e) {
			return -1;
		} finally {
			if (cn != null)
				cn.close();
		}
	}
	@Override
	public int updateUsuarioNormal(UsuarioNormal datos) throws Exception {
		Connection cn = conectarBD();
		if (cn == null) {
			return -1;
		}

		try {
			String sql = "UPDATE USUARIOS_NORMAL SET nombre='" + datos.getNbUsuario() + "',apellidos='"
					+ datos.getApellidosUsuario() + "',direccion='" + datos.getDirUsuario() + "',password='"
					+ datos.getPassUsuario() + "',telefono='" + datos.getTelfUsuario() + "',club='"
					+ datos.getClubUsuario() + "' WHERE email='" + datos.getEmailUsuario() + "'";
			Statement sentencia = cn.createStatement();

			return sentencia.executeUpdate(sql);
		} catch (Exception e) {
			return -1;
		} finally {
			if (cn != null)
				cn.close();
		}
	}
	
	@Override
	public boolean loginAdmin(UsuarioAdmin admin) throws Exception {
		Connection cn = conectarBD();
		if (cn == null) {
			return false;
		}
		try {
			// select for check if exists in DB
			String sql = "SELECT * FROM USUARIOS_ADMIN A WHERE A.EMAIL=? AND A.PASSWORD=?";
			PreparedStatement sentencia = cn.prepareStatement(sql);
			sentencia.setString(1, admin.getEmailUsuario());
			sentencia.setString(2, admin.getPassUsuario());
			ResultSet rs = sentencia.executeQuery();
	
			if (rs.next() == false) {
				return false;
			} else {
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		} finally {
			if (cn != null) cn.close();
		}
	}
	@Override
	public boolean loginNormal(UsuarioNormal uStd) throws Exception {
		Connection cn = conectarBD();
		if (cn == null) {
			return false;
		}
		try {
			// select for check if exists in DB
			String sql = "SELECT * FROM USUARIOS_NORMAL NO WHERE NO.email=? AND NO.password=?";
			PreparedStatement sentencia = cn.prepareStatement(sql);
			sentencia.setString(1, uStd.getEmailUsuario());
			sentencia.setString(2, uStd.getPassUsuario());
			ResultSet rs = sentencia.executeQuery();

			if (rs.next() == false) {
				return false;
			} else {
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		} finally {
			if (cn != null)
				cn.close();
		}
	}
	@Override
	public boolean loginOrganizador(UsuarioOrganizador uOrg) throws Exception {
		Connection cn = conectarBD();
		if (cn == null) {
			return false;
		}
		try {
			// select for check if exists in DB
			String sql = "SELECT * FROM USUARIOS_ORGANIZADOR ORG WHERE ORG.email=? AND ORG.password=?";
			PreparedStatement sentencia = cn.prepareStatement(sql);
			sentencia.setString(1, uOrg.getEmailUsuario());
			sentencia.setString(2, uOrg.getPassUsuario());
			ResultSet rs = sentencia.executeQuery();

			if (rs.next() == false) {
				return false;
			} else {
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		} finally {
			if (cn != null)
				cn.close();
		}
	}

}
