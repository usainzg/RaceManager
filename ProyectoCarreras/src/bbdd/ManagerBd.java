package bbdd;

import java.sql.Connection;
import java.util.ArrayList;

import clases.Carrera;
import clases.UsuarioAdmin;
import clases.UsuarioNormal;
import clases.UsuarioOrganizador;

public class ManagerBd implements InterfazBD {

	private MainDBManager dbm = null;
	private final String MYSQL = "mysql";
	private final String HIBERNATE = "hibernate";

	public void setDb(final String db) {
		switch (db) {
		case MYSQL:
			dbm = new MySqlManager();
			break;
		case HIBERNATE:
			dbm = new HibernateManager();
			break;
		default:
			break;
		}
	}

	@Override
	public Connection conectarBD() throws Exception {
		return dbm.conectarBD();
	}

	@Override
	public ArrayList<Carrera> consultarCarreras() throws Exception {
		return dbm.consultarCarreras();
	}

	@Override
	public int altaCarrera(Carrera c) throws Exception {
		return dbm.altaCarrera(c);
	}

	@Override
	public int deleteCarrera(Carrera c) throws Exception {
		return dbm.deleteCarrera(c);
	}

	@Override
	public ArrayList<UsuarioNormal> consultarUsuariosEstandar() throws Exception {
		return dbm.consultarUsuariosEstandar();
	}

	@Override
	public ArrayList<UsuarioOrganizador> consultarUsuariosOrganizador() throws Exception {
		return dbm.consultarUsuariosOrganizador();
	}

	@Override
	public int altaOrganizador(UsuarioOrganizador uOrg) throws Exception {
		return dbm.altaOrganizador(uOrg);
	}

	@Override
	public int altaUsuarioNormal(UsuarioNormal uStd) throws Exception {
		return dbm.altaUsuarioNormal(uStd);
	}

	@Override
	public int deleteUsuarioOrganizador(UsuarioOrganizador uOrg) throws Exception {
		return dbm.deleteUsuarioOrganizador(uOrg);
	}

	@Override
	public int deleteUsuarioNormal(UsuarioNormal uStd) throws Exception {
		return dbm.deleteUsuarioNormal(uStd);
	}

	@Override
	public int updateUsuarioOrganizador(UsuarioOrganizador uOrg, UsuarioOrganizador datos) throws Exception {
		return dbm.updateUsuarioOrganizador(uOrg, datos);
	}

	@Override
	public int updateUsuarioNormal(UsuarioNormal uStd, UsuarioNormal datos) throws Exception {
		return dbm.updateUsuarioNormal(uStd, datos);
	}

	@Override
	public boolean loginAdmin(UsuarioAdmin admin) throws Exception {
		return dbm.loginAdmin(admin);
	}

	@Override
	public boolean loginNormal(UsuarioNormal uStd) throws Exception {
		return dbm.loginNormal(uStd);
	}

	@Override
	public boolean loginOrganizador(UsuarioOrganizador uOrg) throws Exception {
		return dbm.loginOrganizador(uOrg);
	}

	@Override
	public ArrayList<UsuarioNormal> consultarEmailNormal() throws Exception {
		return dbm.consultarEmailNormal();
	}

	@Override
	public ArrayList<UsuarioOrganizador> consultarEmailOrg() throws Exception {
		return dbm.consultarEmailOrg();
	}

	@Override
	public int updateCarreraAdmin(Carrera cViejo, Carrera c) throws Exception {
		return dbm.updateCarreraAdmin(cViejo, c);
	}

	@Override
	public int updateCarreraOrg(Carrera cViejo, Carrera c) throws Exception {
		return dbm.updateCarreraOrg(cViejo, c);
	}

	@Override
	public ArrayList<Carrera> consultarCarrerasOrg(UsuarioOrganizador org) throws Exception {
		return dbm.consultarCarrerasOrg(org);
	}

}
