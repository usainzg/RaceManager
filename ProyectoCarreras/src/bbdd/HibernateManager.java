package bbdd;

import java.sql.Connection;
import java.util.ArrayList;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import clases.Carrera;
import clases.UsuarioAdmin;
import clases.UsuarioEstandar;
import clases.UsuarioOrganizador;

public class HibernateManager extends MainDBManager{
	
	private Session sesion;
	
	private void iniciaOperacion()
	{
	        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
	        sesion = sessionFactory.openSession();
	        sesion.getTransaction().begin();
	}
	
	private void terminaOperacion()
	{
	        sesion.getTransaction().commit();
	        sesion.close();
	}

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
	public ArrayList<UsuarioEstandar> consultarUsuariosEstandar() throws Exception {
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
	public ArrayList<UsuarioEstandar> consultarEmailNormal() throws Exception {
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
	public int altaUsuarioNormal(UsuarioEstandar uStd) throws Exception {
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
	public int deleteUsuarioNormal(UsuarioEstandar uStd) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateCarreraAdmin(Carrera cViejo, Carrera c) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateCarreraOrg(Carrera cViejo, Carrera c) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateUsuarioOrganizador(UsuarioOrganizador uOrg, UsuarioOrganizador datos) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateUsuarioNormal(UsuarioEstandar uStd, UsuarioEstandar datos) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean loginAdmin(UsuarioAdmin admin) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean loginNormal(UsuarioEstandar uStd) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean loginOrganizador(UsuarioOrganizador uOrg) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

}
