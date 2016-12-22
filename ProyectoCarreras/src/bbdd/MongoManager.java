package bbdd;

import java.sql.Connection;
import java.util.ArrayList;

import clases.Carrera;
import clases.UsuarioAdmin;
import clases.UsuarioNormal;
import clases.UsuarioOrganizador;

public class MongoManager extends MainDBManager{

	@Override
	public Connection conectarBD() throws Exception {
		// TODO Auto-generated method stub
		return null;
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
