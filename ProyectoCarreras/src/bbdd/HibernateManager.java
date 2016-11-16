package bbdd;

import java.sql.Connection;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import clases.Carrera;
import clases.UsuarioAdmin;
import clases.UsuarioNormal;
import clases.UsuarioOrganizador;

public class HibernateManager extends MainDBManager {

	private Session sesion;

	private void iniciaOperacion() {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		sesion = sessionFactory.openSession();
		sesion.getTransaction().begin();
	}

	private void terminaOperacion() {
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

		if (query != null) {
			List<clasesHibernate.Carrera> lista = query.getResultList();
			Iterator<clasesHibernate.Carrera> iterator = lista.iterator();
			while (iterator.hasNext()) {
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

		if (query != null) {
			List<clasesHibernate.Usuarionormal> lista = query.getResultList();
			Iterator<clasesHibernate.Usuarionormal> iterator = lista.iterator();
			while (iterator.hasNext()) {
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

		if (query != null) {
			List<clasesHibernate.Usuarioorganizador> lista = query.getResultList();
			Iterator<clasesHibernate.Usuarioorganizador> iterator = lista.iterator();
			while (iterator.hasNext()) {
				UsuarioOrganizador o = new UsuarioOrganizador(iterator.next());
				orgs.add(o);
			}
		}

		terminaOperacion();
		return orgs;
	}

	@Override
	public ArrayList<Carrera> consultarCarrerasOrg(UsuarioOrganizador org) throws Exception {
		iniciaOperacion();

		ArrayList<Carrera> carreras = new ArrayList<>();

		Query<clasesHibernate.Carrera> query = sesion.createQuery("FROM Carrera WHERE usuarioorganizador.email = '" + org.getEmailUsuario() + "'");

		if (query != null) {
			List<clasesHibernate.Carrera> lista = query.getResultList();
			Iterator<clasesHibernate.Carrera> iterator = lista.iterator();
			while (iterator.hasNext()) {
				Carrera c = new Carrera(iterator.next());
				carreras.add(c);
			}
		}

		terminaOperacion();
		return carreras;
	}

	@Override
	public ArrayList<UsuarioNormal> consultarEmailNormal() throws Exception {
		iniciaOperacion();

		ArrayList<UsuarioNormal> normales = new ArrayList<>();

		Query<clasesHibernate.Usuarionormal> query = sesion.createQuery("FROM Usuarionormal");

		if (query != null) {
			List<clasesHibernate.Usuarionormal> lista = query.getResultList();
			Iterator<clasesHibernate.Usuarionormal> iterator = lista.iterator();
			while (iterator.hasNext()) {
				UsuarioNormal u = new UsuarioNormal(iterator.next());
				normales.add(u);
			}
		}

		terminaOperacion();
		return normales;
	}

	@Override
	public ArrayList<UsuarioOrganizador> consultarEmailOrg() throws Exception {
		iniciaOperacion();

		ArrayList<UsuarioOrganizador> orgs = new ArrayList<>();

		Query<clasesHibernate.Usuarioorganizador> query = sesion.createQuery("FROM Usuarioorganizador");

		if (query != null) {
			List<clasesHibernate.Usuarioorganizador> lista = query.getResultList();
			Iterator<clasesHibernate.Usuarioorganizador> iterator = lista.iterator();
			while (iterator.hasNext()) {
				UsuarioOrganizador o = new UsuarioOrganizador(iterator.next());
				orgs.add(o);
			}
		}

		terminaOperacion();
		return orgs;
	}

	@Override
	public int altaCarrera(Carrera c) throws Exception {
		// TODO
		return 0;
	}

	@Override
	public int altaOrganizador(UsuarioOrganizador uOrg) throws Exception {
		
		clasesHibernate.Usuarioorganizador org = new clasesHibernate.Usuarioorganizador();
		org.setNombre(uOrg.getNbUsuario());
		org.setApellidos(uOrg.getApellidosUsuario());
		org.setEmail(uOrg.getEmailUsuario());
		org.setPassword(uOrg.getPassUsuario());
		org.setDireccion(uOrg.getDirUsuario());
		org.setTelefono(uOrg.getTelfUsuario());
		org.setClub(uOrg.getClubUsuario());

		try {
			iniciaOperacion();
			sesion.save(org);
			terminaOperacion();
			return 1;
		} catch (Exception e) {
			return 0;
		}

	}

	@Override
	public int altaUsuarioNormal(UsuarioNormal uStd) throws Exception {
		clasesHibernate.Usuarionormal u = new clasesHibernate.Usuarionormal();
		u.setNombre(uStd.getNbUsuario());
		u.setApellidos(uStd.getApellidosUsuario());
		u.setEmail(uStd.getEmailUsuario());
		u.setPassword(uStd.getPassUsuario());
		u.setDireccion(uStd.getDirUsuario());
		u.setTelefono(uStd.getTelfUsuario());
		u.setClub(uStd.getClubUsuario());

		try {
			iniciaOperacion();
			sesion.save(u);
			terminaOperacion();
			return 1;
		} catch (Exception e) {
			return 0;
		}
	}

	@Override
	public int deleteCarrera(Carrera c) throws Exception {

		clasesHibernate.Carrera ca = new clasesHibernate.Carrera();
		
		try{
			iniciaOperacion();
			
			ca = (clasesHibernate.Carrera) sesion.get(clasesHibernate.Carrera.class, c.getNbCarrera());
			
			sesion.delete(ca);
			
			terminaOperacion();
			
			return 1;
		}catch(Exception e){
			return 0;
		}
	}

	@Override
	public int deleteUsuarioOrganizador(UsuarioOrganizador uOrg) throws Exception {
		
		try {
			String hql = "DELETE Usuarioorganizador WHERE email= :email";
			iniciaOperacion();
			Query q = sesion.createQuery(hql);
			q.setParameter("email", uOrg.getEmailUsuario());
			int filas = q.executeUpdate();
			terminaOperacion();
			return filas;
		}catch(Exception e){
			return 0;
		}
	}

	@Override
	public int deleteUsuarioNormal(UsuarioNormal uStd) throws Exception {
		try {
			String hql = "DELETE Usuarionormal WHERE email= :email";
			iniciaOperacion();
			Query q = sesion.createQuery(hql);
			q.setParameter("email", uStd.getEmailUsuario());
			int filas = q.executeUpdate();
			terminaOperacion();
			return filas;
		}catch(Exception e){
			return 0;
		}
	}

	@Override
	public int updateCarreraAdmin(Carrera c) throws Exception {
		
		clasesHibernate.Carrera ca = new clasesHibernate.Carrera();
		
		try{
			iniciaOperacion();
			
			ca = (clasesHibernate.Carrera) sesion.get(clasesHibernate.Carrera.class, c.getNbCarrera());
			ca.setDistancia(c.getDistanciaCarrera());
			ca.setDesnivel(c.getDesnivelCarrera());
			ca.setPrecio(c.getPrecioCarrera());
			
			SimpleDateFormat formatoDelTexto = new SimpleDateFormat("yyyy-MM-dd");
			Date date = formatoDelTexto.parse(c.getFechaCarrera());
			ca.setFecha(date);
			ca.setLugar(c.getLugarCarrera());
			sesion.update(ca);
			
			terminaOperacion();
			
			return 1;
		}catch(Exception e){
			return 0;
		}
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
		Query<?> query = sesion.createQuery("FROM Usuarioadmin WHERE email='" + admin.getEmailUsuario()
				+ "' AND password='" + admin.getPassUsuario() + "'");
		if (query.getSingleResult() != null) {
			terminaOperacion();
			return true;
		} else {
			terminaOperacion();
			return false;
		}

	}

	@Override
	public boolean loginNormal(UsuarioNormal uStd) throws Exception {
		iniciaOperacion();
		Query<?> query = sesion.createQuery("FROM Usuarioadmin WHERE email='" + uStd.getEmailUsuario()
				+ "' AND password='" + uStd.getPassUsuario() + "'");
		if (query.getSingleResult() != null) {
			terminaOperacion();
			return true;
		} else {
			terminaOperacion();
			return false;
		}
	}

	@Override
	public boolean loginOrganizador(UsuarioOrganizador uOrg) throws Exception {
		iniciaOperacion();
		Query<?> query = sesion.createQuery("FROM Usuarioorganizador WHERE email='" + uOrg.getEmailUsuario()
				+ "' AND password='" + uOrg.getPassUsuario() + "'");
		if (query.getSingleResult() != null) {
			terminaOperacion();
			return true;
		} else {
			terminaOperacion();
			return false;
		}
	}

}
