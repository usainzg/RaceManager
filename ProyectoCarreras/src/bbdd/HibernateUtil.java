package bbdd;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

/**
 * 
 * @author unaisainz
 *
 */

public class HibernateUtil {
	
	/**
	 * Singleton 
	 */

	private static final SessionFactory sessionFactory = buildSessionFactory();

	/**
	 * Metodo estatico para crear un sessionFactory
	 * @return SessionFactory un objeto SessionFactory
	 */
	private static SessionFactory buildSessionFactory() {
		try {
			return new Configuration().configure()
					.buildSessionFactory(new StandardServiceRegistryBuilder().configure().build());
		} catch (Throwable ex) {
			System.err.println("Session Factory creation failed" + ex);
			throw new ExceptionInInitializerError(ex);
		}
	}

	/**
	 * Metodo para devolver el sessionFactory
	 * @return SessionFactory objeto sessionFactory
	 */
	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}

}
