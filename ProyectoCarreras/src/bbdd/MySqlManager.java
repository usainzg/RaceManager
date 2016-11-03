package bbdd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import clases.Carrera;
import clases.UsuarioAdmin;
import clases.UsuarioEstandar;
import clases.UsuarioOrganizador;
import utilidades.Utilidades;

public class MySqlManager implements InterfazBD {
	
	private final String MYSQL_DRIVER = "com.mysql.jdbc.Driver";
	private final String URL_DB = "jdbc:mysql://localhost/proyectobd";
	private final Utilidades util = new Utilidades();

	@Override
	public Connection conectarBD() throws Exception {
		try {
			Class.forName(MYSQL_DRIVER != null ? MYSQL_DRIVER : "com.mysql.jdbc.Driver");
			Connection conexion = DriverManager
					.getConnection(URL_DB != null ? URL_DB : "jdbc:mysql://localhost/proyectobd", "administrador", "Admin1234");
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

	// SELECTs
	@Override
	public ArrayList<Carrera> consultarCarreras() throws Exception {
		Connection cn = conectarBD();
		if (cn == null) {
			util.createErrorbox("No se ha podido establecer conexion con la base de datos.",
					"Error al conectar base de datos.");
		}
		try {
			String sql = "SELECT c.*, org.nombre AS nbOrg, org.id AS idOrg FROM carrera c "
					+ "INNER JOIN usuarioorganizador org ON c.organizador = org.id";
			Statement sentencia = cn.createStatement();
			ResultSet rs = sentencia.executeQuery(sql);
			ArrayList<Carrera> arr = new ArrayList<Carrera>();
			while (rs.next()) {
				Carrera c = new Carrera();
				c.setNbCarrera(rs.getString("nombre"));
				c.setOrgCarrera(new UsuarioOrganizador(rs.getString("nbOrg"), null, null, null, null, 0, null,
						rs.getInt("idOrg")));
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
	public ArrayList<UsuarioOrganizador> consultarUsuariosOrganizador() throws Exception {
		Connection cn = conectarBD();
		if (cn == null) {
			util.createErrorbox("No se ha podido establecer conexion con la base de datos.",
					"Error al conectar base de datos.");
		}

		try {
			String sql = "SELECT * FROM usuarioorganizador";
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
	public ArrayList<UsuarioEstandar> consultarUsuariosEstandar() throws Exception {
		Connection cn = conectarBD();
		if (cn == null) {
			util.createErrorbox("No se ha podido establecer conexion con la base de datos.",
					"Error al conectar base de datos.");
		}

		try {
			String sql = "SELECT * FROM usuarionormal";
			Statement sentencia = cn.createStatement();
			ResultSet rs = sentencia.executeQuery(sql);
			ArrayList<UsuarioEstandar> arr = new ArrayList<UsuarioEstandar>();
			while (rs.next()) {
				UsuarioEstandar uStd = new UsuarioEstandar();
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
	// end selects

	// INSERT�s
	@Override
	public int altaCarrera(Carrera c) throws Exception {
		Connection cn = conectarBD();
		if (cn == null) {
			return -1;
		}

		try {
			String sql = "INSERT INTO carrera (nombre, organizador, distancia, desnivel, precio, fecha, lugar) VALUES ("
					+ c.getNbCarrera() + "," + c.getOrgCarrera().getId() + "," + c.getDistanciaCarrera() + ","
					+ c.getDesnivelCarrera() + "," + c.getPrecioCarrera() + "," + c.getFechaCarrera() + ","
					+ c.getLugarCarrera() + ")";
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
	public int altaOrganizador(UsuarioOrganizador uOrg) throws Exception {
		Connection cn = conectarBD();
		if (cn == null) {
			util.createErrorbox("No se ha podido establecer conexion con la base de datos.",
					"Error al conectar base de datos.");
		}

		try {
			String sql = "INSERT INTO usuarioorganizador (nombre, apellidos, email, password, direccion, telefono, club) VALUES ('"
					+ uOrg.getNbUsuario() + "','" + uOrg.getApellidosUsuario() + "','" + uOrg.getEmailUsuario() + "','"
					+ uOrg.getPassUsuario() + "','" + uOrg.getDirUsuario() + "','" + uOrg.getTelfUsuario() + "','"
					+ uOrg.getClubUsuario() + "')";
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
	public int altaUsuarioNormal(UsuarioEstandar uStd) throws Exception {
		Connection cn = conectarBD();
		if (cn == null) {
			util.createErrorbox("No se ha podido establecer conexion con la base de datos.",
					"Error al conectar base de datos.");
		}

		try {
			String sql = "INSERT INTO usuarionormal (nombre, apellidos, email, password, direccion, telefono, club) VALUES ('"
					+ uStd.getNbUsuario() + "','" + uStd.getApellidosUsuario() + "','" + uStd.getEmailUsuario() + "','"
					+ uStd.getPassUsuario() + "','" + uStd.getDirUsuario() + "','" + uStd.getTelfUsuario() + "','"
					+ uStd.getClubUsuario() + "')";
			Statement sentencia = cn.createStatement();

			return sentencia.executeUpdate(sql);
		} catch (Exception e) {
			return -1;
		} finally {
			if (cn != null)
				cn.close();
		}
	}
	// END INSERT�s

	// DELETE�s
	@Override
	public int deleteCarrera(Carrera c) throws Exception {
		Connection cn = conectarBD();
		if (cn == null) {
			return -1;
		}
		try {
			String sql = "DELETE FROM carrera WHERE nombre='" + c.getNbCarrera() + "'";
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
			String sql = "DELETE FROM usuarioorganizador WHERE email='" + uOrg.getEmailUsuario() + "'";
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
	public int deleteUsuarioNormal(UsuarioEstandar uStd) throws Exception {
		Connection cn = conectarBD();
		if (cn == null) {
			util.createErrorbox("No se ha podido establecer conexion con la base de datos.",
					"Error al conectar base de datos.");
		}
		try {
			String sql = "DELETE FROM usuarionormal WHERE email='" + uStd.getEmailUsuario() + "'";
			Statement sentencia = cn.createStatement();
			return sentencia.executeUpdate(sql);
		} catch (Exception e) {
			return -1;
		} finally {
			if (cn != null)
				cn.close();
		}
	}
	// END DELETE�s

	// UPDATE�s
	@Override
	public int updateCarreraAdmin(Carrera cViejo, Carrera c) throws Exception {
		Connection cn = conectarBD();
		if (cn == null) {
			return -1;
		}
		try {
			String sql = "UPDATE `carrera` SET `distancia`='" + c.getDistanciaCarrera() + "',`desnivel`='"
					+ c.getDesnivelCarrera() + "',`precio`='" + c.getPrecioCarrera() + "',`fecha`='"
					+ c.getFechaCarrera() + "',`lugar`='" + c.getLugarCarrera() + "' WHERE nombre='" + c.getNbCarrera()
					+ "'";
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
	public int updateCarreraOrg(Carrera cViejo, Carrera c) throws Exception {
		// TODO
		return 0;
	}

	@Override
	public int updateUsuarioOrganizador(UsuarioOrganizador uOrg, UsuarioOrganizador datos) throws Exception {
		Connection cn = conectarBD();
		if (cn == null) {
			return -1;
		}
		try {
			String sql = "UPDATE `usuarioorganizador` SET nombre='" + datos.getNbUsuario() + "',apellidos='"
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
	public int updateUsuarioNormal(UsuarioEstandar uStd, UsuarioEstandar datos) throws Exception {
		Connection cn = conectarBD();
		if (cn == null) {
			return -1;
		}

		try {
			String sql = "UPDATE `usuarionormal` SET nombre='" + datos.getNbUsuario() + "',apellidos='"
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
	// END OF UPDATE�s

	// LOGIN SYSTEM
	@Override
	public boolean loginAdmin(UsuarioAdmin admin) throws Exception {
		Connection cn = conectarBD();
		if (cn == null) {
			return false;
		}
		try {
			// select for check if exists in DB
			String sql = "SELECT * FROM usuarioadmin WHERE email='" + admin.getEmailUsuario() + "' && password='"
					+ admin.getPassUsuario() + "'";
			Statement sentencia = cn.createStatement();
			ResultSet rs = sentencia.executeQuery(sql);

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
	public boolean loginNormal(UsuarioEstandar uStd) throws Exception {
		Connection cn = conectarBD();
		if (cn == null) {
			return false;
		}
		try {
			// select for check if exists in DB
			String sql = "SELECT * FROM usuarionormal WHERE email='" + uStd.getEmailUsuario() + "' && password='"
					+ uStd.getPassUsuario() + "'";
			Statement sentencia = cn.createStatement();
			ResultSet rs = sentencia.executeQuery(sql);

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
			String sql = "SELECT * FROM usuarioorganizador WHERE email='" + uOrg.getEmailUsuario() + "' && password='"
					+ uOrg.getPassUsuario() + "'";
			Statement sentencia = cn.createStatement();
			ResultSet rs = sentencia.executeQuery(sql);

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
	// END OF LOGIN

	@Override
	public ArrayList<UsuarioEstandar> consultarEmailNormal() throws Exception {
		Connection cn = conectarBD();
		if (cn == null) {
			return null;
		}

		try {
			String sql = "SELECT email FROM usuarionormal";
			Statement sentencia = cn.createStatement();
			ResultSet rs = sentencia.executeQuery(sql);

			ArrayList<UsuarioEstandar> arr = new ArrayList<UsuarioEstandar>();
			while (rs.next()) {
				UsuarioEstandar uStd = new UsuarioEstandar();
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
			String sql = "SELECT email FROM usuarioorganizador";
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

}
