package bbdd;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import clases.Carrera;
import clases.UsuarioAdmin;
import clases.UsuarioNormal;
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
		return null;
	}

	@Override
	public ArrayList<Carrera> consultarCarreras() throws Exception {
		iniciaOperacion();
		
		ArrayList<Carrera> carreras = new ArrayList<>();
		
		Query<clasesHibernate.Carrera> query = sesion.createQuery("FROM Carrera");
		
		if(query != null){
			List<clasesHibernate.Carrera> lista = query.getResultList();
			Iterator<clasesHibernate.Carrera> iterator = lista.iterator();
			while(iterator.hasNext()){
				Carrera c = new Carrera(iterator.next());
				carreras.add(c);
			}
		}
	    
	    terminaOperacion(); 
	    return carreras;
	}

	@Override
	public ArrayList<UsuarioNormal> consultarUsuariosEstandar() throws Exception {
		iniciaOperacion();
		
		ArrayList<UsuarioNormal> normales = new ArrayList<>();
		
		Query<clasesHibernate.Usuarionormal> query = sesion.createQuery("FROM Usuarionormal");
		
		if(query != null){
			List<clasesHibernate.Usuarionormal> lista = query.getResultList();
			Iterator<clasesHibernate.Usuarionormal> iterator = lista.iterator();
			while(iterator.hasNext()){
				UsuarioNormal u = new UsuarioNormal(iterator.next());
				normales.add(u);
			}
		}
	    
	    terminaOperacion(); 
	    return normales;
	}

	@Override
	public ArrayList<UsuarioOrganizador> consultarUsuariosOrganizador() throws Exception {
		iniciaOperacion();
		
		ArrayList<UsuarioOrganizador> orgs = new ArrayList<>();
		
		Query<clasesHibernate.Usuarioorganizador> query = sesion.createQuery("FROM Usuarioorganizador");
		
		if(query != null){
			List<clasesHibernate.Usuarioorganizador> lista = query.getResultList();
			Iterator<clasesHibernate.Usuarioorganizador> iterator = lista.iterator();
			while(iterator.hasNext()){
				UsuarioOrganizador o = new UsuarioOrganizador(iterator.next());
				orgs.add(o);
			}
		}
	    
	    terminaOperacion(); 
	    return orgs;
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
	public int updateUsuarioNormal(UsuarioNormal uStd, UsuarioNormal datos) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean loginAdmin(UsuarioAdmin admin) throws Exception {

		iniciaOperacion();
		Query<?> query = sesion.createQuery("FROM Usuarioadmin WHERE email='" + admin.getEmailUsuario() + "' AND password='"
				+ admin.getPassUsuario() + "'");
		if(query.getSingleResult() != null) {
			terminaOperacion();
			return true;
		}else{
			terminaOperacion();
			return false;
		}
		
	}

	@Override
	public boolean loginNormal(UsuarioNormal uStd) throws Exception {
		iniciaOperacion();
		Query<?> query = sesion.createQuery("FROM Usuarioadmin WHERE email='" + uStd.getEmailUsuario() + "' AND password='"
				+ uStd.getPassUsuario() + "'");
		if(query.getSingleResult() != null) {
			terminaOperacion();
			return true;
		}else{
			terminaOperacion();
			return false;
		}
	}

	@Override
	public boolean loginOrganizador(UsuarioOrganizador uOrg) throws Exception {
		iniciaOperacion();
		Query<?> query = sesion.createQuery("FROM Usuarioorganizador WHERE email='" + uOrg.getEmailUsuario() + "' AND password='"
				+ uOrg.getPassUsuario() + "'");
		if(query.getSingleResult() != null) {
			terminaOperacion();
			return true;
		}else{
			terminaOperacion();
			return false;
		}
	}

}
