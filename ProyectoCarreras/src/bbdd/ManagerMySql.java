package bbdd;

import java.sql.Connection;
import java.util.ArrayList;

import clases.Carrera;
import clases.UsuarioAdmin;
import clases.UsuarioEstandar;
import clases.UsuarioOrganizador;

public class ManagerMySql implements InterfazBD {

	MySqlManager mySql = new MySqlManager();

	@Override
	public Connection conectarBD() throws Exception {
		return mySql.conectarBD();
	}

	@Override
	public ArrayList<Carrera> consultarCarreras() throws Exception {
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
	public ArrayList<UsuarioEstandar> consultarUsuariosEstandar() throws Exception {
		return mySql.consultarUsuariosEstandar();
	}

	@Override
	public ArrayList<UsuarioOrganizador> consultarUsuariosOrganizador() throws Exception {
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
	public int updateUsuarioOrganizador(UsuarioOrganizador uOrg, UsuarioOrganizador datos) throws Exception {
		return mySql.updateUsuarioOrganizador(uOrg, datos);
	}

	@Override
	public int updateUsuarioNormal(UsuarioEstandar uStd, UsuarioEstandar datos) throws Exception {
		return mySql.updateUsuarioNormal(uStd, datos);
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

	@Override
	public ArrayList<UsuarioEstandar> consultarEmailNormal() throws Exception {
		return mySql.consultarEmailNormal();
	}

	@Override
	public ArrayList<UsuarioOrganizador> consultarEmailOrg() throws Exception {
		return mySql.consultarEmailOrg();
	}

	@Override
	public int updateCarreraAdmin(Carrera cViejo, Carrera c) throws Exception {
		return mySql.updateCarreraAdmin(cViejo, c);
	}

	@Override
	public int updateCarreraOrg(Carrera cViejo, Carrera c) throws Exception {
		return mySql.updateCarreraOrg(cViejo, c);
	}

}
