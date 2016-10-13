package bbdd;

import java.sql.Connection;
import java.util.ArrayList;

import clases.Carrera;
import clases.Usuario;

public class ManagerMySql implements InterfazBD{
	
	MySqlManager mySql = new MySqlManager();
	
	@Override
	public Connection conectarBD() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Carrera> consultarCarreras() throws Exception {
		return mySql.consultarCarreras();
	}

	@Override
	public ArrayList<Usuario> consultarUsuarios() throws Exception {
		return mySql.consultarUsuarios();
	}

	@Override
	public int altaCarrera(Carrera c) throws Exception {
		return mySql.altaCarrera(c);
	}

	@Override
	public int altaUsuario(Usuario u) throws Exception {
		return mySql.altaUsuario(u);
	}

	@Override
	public int deleteCarrera(Carrera c) throws Exception {
		return mySql.deleteCarrera(c);
	}

	@Override
	public int deleteUsuario(Usuario u) throws Exception {
		return mySql.deleteUsuario(u);
	}

	@Override
	public int updateCarrera(Carrera c) throws Exception {
		return mySql.updateCarrera(c);
	}

	@Override
	public int updateUsuario(Usuario u) throws Exception {
		return mySql.updateUsuario(u);
	}

	

}
