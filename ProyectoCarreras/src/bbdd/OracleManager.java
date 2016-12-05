package bbdd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;

import clases.Carrera;
import clases.UsuarioAdmin;
import clases.UsuarioNormal;
import clases.UsuarioOrganizador;
import utilidades.Utilidades;

public class OracleManager extends MainDBManager{
	
	private final String ORACLE_DRIVER = "oracle.jdbc.driver.OracleDriver";
	private final String URL_DB = "jdbc:oracle:thin:@localhost:1521:XE";
	private final String DB_USER_ORACLE = "system";
	private final String DB_PASS_ORACLE = "unai1808";
	
	private final Utilidades util = new Utilidades();
	
	@Override
	public Connection conectarBD() throws Exception {
		try {
			Class.forName(ORACLE_DRIVER != null ? ORACLE_DRIVER : "oracle.jdbc.driver.OracleDriver");
			Connection conexion = DriverManager
					.getConnection(URL_DB != null ? URL_DB : "jdbc:oracle:thin:@localhost:1521:XE", DB_USER_ORACLE, DB_PASS_ORACLE);
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
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public ArrayList<UsuarioNormal> consultarUsuariosEstandar() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public ArrayList<UsuarioOrganizador> consultarUsuariosOrganizador() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public ArrayList<Carrera> consultarCarrerasOrg(UsuarioOrganizador org) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public ArrayList<UsuarioNormal> consultarEmailNormal() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public ArrayList<UsuarioOrganizador> consultarEmailOrg() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public int altaCarrera(Carrera c) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public int altaOrganizador(UsuarioOrganizador uOrg) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public int altaUsuarioNormal(UsuarioNormal uStd) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public int deleteCarrera(Carrera c) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public int deleteUsuarioOrganizador(UsuarioOrganizador uOrg) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public int deleteUsuarioNormal(UsuarioNormal uStd) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public int updateCarrera(Carrera c) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public int updateUsuarioOrganizador(UsuarioOrganizador uOrg, UsuarioOrganizador datos) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public int updateUsuarioNormal(UsuarioNormal datos) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public boolean loginAdmin(UsuarioAdmin admin) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean loginNormal(UsuarioNormal uStd) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean loginOrganizador(UsuarioOrganizador uOrg) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

}
