package bbdd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;

import clases.Carrera;
import clases.Usuario;

public class MySqlManager implements InterfazBD{
	
	private static final String urlDB = "jdbc:mysql://localhost/ -- cambiar--";
	
	public MySqlManager(){ }
	
	@Override
	public Connection conectarBD() throws Exception {
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection conexion = DriverManager.getConnection(urlDB, "root", "");
			return conexion;
		}catch(ClassNotFoundException cnE){
			cnE.printStackTrace();
			return null;
		}catch(SQLException e){
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public ArrayList<Carrera> consultarCarreras() throws Exception {
		return null;
	}

	@Override
	public ArrayList<Usuario> consultarUsuarios() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int altaCarrera(Carrera c) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int altaUsuario(Usuario u) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteCarrera(Carrera c) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteUsuario(Usuario u) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateCarrera(Carrera c) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateUsuario(Usuario u) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	

}
