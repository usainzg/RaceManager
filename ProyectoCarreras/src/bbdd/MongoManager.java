package bbdd;

import java.sql.Connection;
import java.util.ArrayList;

import org.bson.Document;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import static com.mongodb.client.model.Projections.*;

import clases.Carrera;
import clases.UsuarioAdmin;
import clases.UsuarioNormal;
import clases.UsuarioOrganizador;

public class MongoManager extends MainDBManager{
	
	public final String MONGO_DB_NAME = "proyectobd";
	
	@Override
	public Connection conectarBD() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Carrera> consultarCarreras() throws Exception {
		MongoClient client = new MongoClient();
		MongoDatabase db = client.getDatabase(MONGO_DB_NAME);
		MongoCollection<Document> coleccion = db.getCollection("carreras");
		
		ArrayList<Document> carrerasDocument = coleccion.find().into(new ArrayList<>());
		
		ArrayList<Carrera> carreras = new ArrayList<>();
		
		for(Document d: carrerasDocument){
			
			String nombre = (String) d.get("_id");
	        double distancia = (double) d.get("distancia");
	        double desnivel = (double) d.get("desnivel");
	        double precio = (double) d.get("precio");
	        String fecha = d.getDate("fecha").toString();
	        String lugar = d.getString("lugar");
	        
	        Carrera c = new Carrera();
	        c.setNbCarrera(nombre);
			c.setDistanciaCarrera((int) distancia);
			c.setDesnivelCarrera((int) desnivel);
			c.setPrecioCarrera((int) precio);
			c.setLugarCarrera(lugar);
			c.setFechaCarrera(fecha);
			carreras.add(c);
	        
		}
		
		client.close();
		return carreras;
	}

	@Override
	public ArrayList<UsuarioNormal> consultarUsuariosEstandar() throws Exception {
		MongoClient client = new MongoClient();
		MongoDatabase db = client.getDatabase(MONGO_DB_NAME);
		MongoCollection<Document> coleccion = db.getCollection("usuariosNormal");
		
		ArrayList<Document> usuariosDocument = coleccion.find().into(new ArrayList<>());
		
		ArrayList<UsuarioNormal> usuarios = new ArrayList<>();
		
		for(Document d: usuariosDocument){
			
			String nombre = (String) d.get("nombre");
			String apellidos = (String) d.get("apellidos");
			String club = (String) d.get("club");
			String dir = (String) d.get("direccion");
			String email = (String) d.get("email");
			String pass = (String) d.get("password");
			double telf = (double) d.get("telefono");
	       
	        UsuarioNormal u = new UsuarioNormal();
	        u.setNbUsuario(nombre);
	        u.setApellidosUsuario(apellidos);
	        u.setClubUsuario(club);
	        u.setDirUsuario(dir);
	        u.setEmailUsuario(email);
	        u.setPassUsuario(pass);
	        u.setTelfUsuario((int) telf);
	        
	        usuarios.add(u);
		}
		
		client.close();
		return usuarios;
	}
	
	@Override
	public ArrayList<UsuarioOrganizador> consultarUsuariosOrganizador() throws Exception {
		MongoClient client = new MongoClient();
		MongoDatabase db = client.getDatabase(MONGO_DB_NAME);
		MongoCollection<Document> coleccion = db.getCollection("usuariosNormal");
		
		ArrayList<Document> usuariosDocument = coleccion.find().into(new ArrayList<>());
		
		ArrayList<UsuarioOrganizador> usuarios = new ArrayList<>();
		
		for(Document d: usuariosDocument){
			
			String nombre = (String) d.get("nombre");
			String apellidos = (String) d.get("apellidos");
			String club = (String) d.get("club");
			String dir = (String) d.get("direccion");
			String email = (String) d.get("email");
			String pass = (String) d.get("password");
			double telf = (double) d.get("telefono");
	       
	        UsuarioOrganizador u = new UsuarioOrganizador();
	        u.setNbUsuario(nombre);
	        u.setApellidosUsuario(apellidos);
	        u.setClubUsuario(club);
	        u.setDirUsuario(dir);
	        u.setEmailUsuario(email);
	        u.setPassUsuario(pass);
	        u.setTelfUsuario((int) telf);
	        
	        usuarios.add(u);
		}
		
		client.close();
		return usuarios;
	}

	@Override
	public ArrayList<Carrera> consultarCarrerasOrg(UsuarioOrganizador org) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<UsuarioNormal> consultarEmailNormal() throws Exception {
		MongoClient client = new MongoClient();
		MongoDatabase db = client.getDatabase(MONGO_DB_NAME);
		MongoCollection<Document> coleccion = db.getCollection("usuariosNormal");
		MongoCursor<Document> doc = coleccion.find()
				.projection(include("email")).iterator();
		
		ArrayList<UsuarioNormal> usuarios = new ArrayList<>();
		while(doc.hasNext()){
			
			Document docu = doc.next();
			UsuarioNormal uStd = new UsuarioNormal();
			uStd.setNbUsuario("");
			uStd.setApellidosUsuario("");
			uStd.setEmailUsuario(docu.getString("email"));
			uStd.setPassUsuario("");
			uStd.setDirUsuario("");
			uStd.setTelfUsuario(0);
			uStd.setClubUsuario("");
			usuarios.add(uStd);
		}
		
		client.close();
		return usuarios;
	}

	@Override
	public ArrayList<UsuarioOrganizador> consultarEmailOrg() throws Exception {
		MongoClient client = new MongoClient();
		MongoDatabase db = client.getDatabase(MONGO_DB_NAME);
		MongoCollection<Document> coleccion = db.getCollection("usuariosOrganizador");
		MongoCursor<Document> doc = coleccion.find()
				.projection(include("email")).iterator();
		
		ArrayList<UsuarioOrganizador> usuarios = new ArrayList<>();
		while(doc.hasNext()){
			
			Document docu = doc.next();
			UsuarioOrganizador uStd = new UsuarioOrganizador();
			uStd.setNbUsuario("");
			uStd.setApellidosUsuario("");
			uStd.setEmailUsuario(docu.getString("email"));
			uStd.setPassUsuario("");
			uStd.setDirUsuario("");
			uStd.setTelfUsuario(0);
			uStd.setClubUsuario("");
			usuarios.add(uStd);
		}
		
		client.close();
		return usuarios;
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
