package bbdd;

import java.sql.Connection;
import java.sql.ResultSet;
import clases.Carrera;
import clases.UsuarioAdmin;
import clases.UsuarioEstandar;
import clases.UsuarioOrganizador;

public class ManagerMySql implements InterfazBD{
	
	MySqlManager mySql = new MySqlManager();
	
	@Override
	public Connection conectarBD() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultSet consultarCarreras() throws Exception {
		return mySql.consultarCarreras();
	}

	@Override
	public int altaCarrera(Carrera c) throws Exception {
		return mySql.altaCarrera(c);
	}

	@Override
	public int deleteCarrera(Carrera c) throws Exception {
		return mySql.deleteCarrera(c);
	}

	@Override
	public int updateCarrera(Carrera c) throws Exception {
		return mySql.updateCarrera(c);
	}

	@Override
	public ResultSet consultarUsuariosEstandar() throws Exception {
		return mySql.consultarUsuariosEstandar();
	}

	@Override
	public ResultSet consultarUsuariosOrganizador() throws Exception {
		return mySql.consultarUsuariosOrganizador();
	}

	@Override
	public int altaOrganizador(UsuarioOrganizador uOrg) throws Exception {
		return mySql.altaOrganizador(uOrg);
	}

	@Override
	public int altaUsuarioNormal(UsuarioEstandar uStd) throws Exception {
		return mySql.altaUsuarioNormal(uStd);
	}

	@Override
	public int deleteUsuarioOrganizador(UsuarioOrganizador uOrg) throws Exception {
		return mySql.deleteUsuarioOrganizador(uOrg);
	}

	@Override
	public int deleteUsuarioNormal(UsuarioEstandar uStd) throws Exception {
		return mySql.deleteUsuarioNormal(uStd);
	}

	@Override
	public int updateUsuarioOrganizador(UsuarioOrganizador uOrg) throws Exception {
		return mySql.updateUsuarioOrganizador(uOrg);
	}

	@Override
	public int updateUsuarioNormal(UsuarioEstandar uStd) throws Exception {
		return mySql.updateUsuarioNormal(uStd);
	}

	@Override
	public boolean loginAdmin(UsuarioAdmin admin) throws Exception {
		return mySql.loginAdmin(admin);
	}

	@Override
	public boolean loginNormal(UsuarioEstandar uStd) throws Exception {
		return mySql.loginNormal(uStd);
	}

	@Override
	public boolean loginOrganizador(UsuarioOrganizador uOrg) throws Exception {
		return mySql.loginOrganizador(uOrg);
	}

	

}
