package bbdd;

import static com.mongodb.client.model.Filters.and;
import static com.mongodb.client.model.Filters.eq;
import static com.mongodb.client.model.Filters.in;
import static com.mongodb.client.model.Projections.include;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.bson.Document;

import com.mongodb.BasicDBObject;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.UpdateResult;

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
	        double distancia = d.getDouble("distancia");
	        double desnivel = d.getDouble("desnivel");
	        double precio = d.getDouble("precio");
	        String fecha = d.get("fecha").toString();
	        String lugar = d.getString("lugar");
	        String nombreOrg = "";
	        
	        MongoCollection<Document> orgsColeccion = db.getCollection("usuariosOrg");
	        ArrayList<Document> orgDocumentList = orgsColeccion.find().into(new ArrayList<>());
	        
	        for(Document dOrg: orgDocumentList){
	        	
	        	ArrayList<String> carrerasOrg = (ArrayList<String>) dOrg.get("carreras");
	        	if(carrerasOrg != null && carrerasOrg.contains(nombre)){
	        		nombreOrg = dOrg.getString("nombre");
	        	}
	        }
	        
	        Carrera c = new Carrera();
	        c.setNbCarrera(nombre);
	        
	        UsuarioOrganizador uOrg = new UsuarioOrganizador();
	        uOrg.setNb(nombreOrg);
	        
	        c.setOrgCarrera(uOrg);
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
		MongoClient client = new MongoClient();
		MongoDatabase db = client.getDatabase(MONGO_DB_NAME);
		MongoCollection<Document> col = db.getCollection("usuariosOrg");
		
		ArrayList<Carrera> carreras = new ArrayList<>();
		List<Document> docCarreras;
		Document docOrg;
		
		try{
			docOrg = col.find( eq("email", org.getEmailUsuario()) ).first();
			
			col = db.getCollection("carreras");
			
			docCarreras = col.find( in("_id", docOrg.get("carreras", ArrayList.class)) ).into(new ArrayList<>());
		
			for(Document d: docCarreras){
				Carrera c = new Carrera();
				
				String nombre = (String) d.get("_id");
		        double distancia = (double) d.get("distancia");
		        double desnivel = (double) d.get("desnivel");
		        double precio = (double) d.get("precio");
		        String fecha = d.getString("fecha");
		        String lugar = d.getString("lugar");
		        String nombreOrg = docOrg.getString("nombre");
		        
		        UsuarioOrganizador uOrg = new UsuarioOrganizador();
		        uOrg.setNb(nombreOrg);
		        
		        c.setNbCarrera(nombre);
		        c.setOrgCarrera(uOrg);
		        c.setDistanciaCarrera((int) distancia);
				c.setDesnivelCarrera((int) desnivel);
				c.setPrecioCarrera((int) precio);
				c.setLugarCarrera(lugar);
				c.setFechaCarrera(fecha);
				carreras.add(c);
		        
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		
		client.close();
		return carreras;
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
		MongoCollection<Document> coleccion = db.getCollection("usuariosOrg");
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
		MongoClient client = new MongoClient();
		try{
			MongoDatabase db = client.getDatabase(MONGO_DB_NAME);
			MongoCollection<Document> coleccion = db.getCollection("carreras");
			
			Document carr = new Document();
			carr.put("_id", c.getNbCarrera());
			carr.put("distancia", c.getDistanciaCarrera());
			carr.put("desnivel", c.getDesnivelCarrera());
			carr.put("precio", c.getPrecioCarrera());
			carr.put("fecha", c.getFechaCarrera());
			carr.put("lugar", c.getLugarCarrera());
			coleccion.insertOne(carr);
			return 1;
		}catch(Exception e){
			return -1;
		}finally{
			if(client != null) client.close();
		}
	}

	@Override
	public int altaOrganizador(UsuarioOrganizador uOrg) throws Exception {
		MongoClient client = new MongoClient();
		try{
			MongoDatabase db = client.getDatabase(MONGO_DB_NAME);
			MongoCollection<Document> coleccion = db.getCollection("usuariosOrg");
			
			Document org = new Document();
			org.put("nombre", uOrg.getNbUsuario());
			org.put("apellidos", uOrg.getApellidosUsuario());
			org.put("email", uOrg.getEmailUsuario());
			org.put("password", uOrg.getPassUsuario());
			org.put("direccion", uOrg.getDirUsuario());
			org.put("telefono", uOrg.getTelfUsuario());
			coleccion.insertOne(org);
			return 1;
		}catch(Exception e){
			return -1;
		}finally{
			if(client != null) client.close();
		}
	}

	@Override
	public int altaUsuarioNormal(UsuarioNormal uStd) throws Exception {
		MongoClient client = new MongoClient();
		try{
			MongoDatabase db = client.getDatabase(MONGO_DB_NAME);
			MongoCollection<Document> coleccion = db.getCollection("usuariosNormal");
			
			Document std = new Document();
			std.put("nombre", uStd.getNbUsuario());
			std.put("apellidos", uStd.getApellidosUsuario());
			std.put("email", uStd.getEmailUsuario());
			std.put("password", uStd.getPassUsuario());
			std.put("direccion", uStd.getDirUsuario());
			std.put("telefono", uStd.getTelfUsuario());
			coleccion.insertOne(std);
			return 1;
		}catch(Exception e){
			return -1;
		}finally{
			if(client != null) client.close();
		}
	}

	@Override
	public int deleteCarrera(Carrera c) throws Exception {
		String nombreCarrera = c.getNbCarrera();
		MongoClient client = new MongoClient();
		try{
			MongoDatabase db = client.getDatabase(MONGO_DB_NAME);
			MongoCollection<Document> coleccion = db.getCollection("carreras");
			DeleteResult res = coleccion.deleteOne(eq("_id", nombreCarrera));
			
			if(res.getDeletedCount() == 1){
				
				coleccion = db.getCollection("usuariosOrg");
				
				ArrayList<Document> orgs = coleccion.find().into(new ArrayList<>());
				
				for(Document d: orgs){
					
					ArrayList<String> carreras = (ArrayList<String>) d.get("carreras");
					boolean tieneLaCarrera = false;
					
					for(String s: carreras){
						if(s.equals(nombreCarrera)) tieneLaCarrera = true;
					}
					
					if(tieneLaCarrera){
						
						BasicDBObject match = new BasicDBObject("email", d.getString("email")); 
						BasicDBObject update = new BasicDBObject("carreras", c.getNbCarrera());
						coleccion = db.getCollection("usuariosOrg");
						coleccion.updateOne(match, new BasicDBObject("$pull", update));
					}
				}
				
			}
			
			return (int) res.getDeletedCount();
		}catch(Exception e){
			e.printStackTrace();
			return -1;
		}finally{
			if(client != null) client.close();
		}
	}

	@Override
	public int deleteUsuarioOrganizador(UsuarioOrganizador uOrg) throws Exception {
		MongoClient client = new MongoClient();
		try{
			MongoDatabase db = client.getDatabase(MONGO_DB_NAME);
			MongoCollection<Document> coleccion = db.getCollection("usuariosOrg");
			DeleteResult res = coleccion.deleteOne(eq("email", uOrg.getEmailUsuario()));
			return (int) res.getDeletedCount();
		}catch(Exception e){
			return -1;
		}finally{
			if(client != null) client.close();
		}
	}

	@Override
	public int deleteUsuarioNormal(UsuarioNormal uStd) throws Exception {
		MongoClient client = new MongoClient();
		try{
			MongoDatabase db = client.getDatabase(MONGO_DB_NAME);
			MongoCollection<Document> coleccion = db.getCollection("usuariosNormal");
			DeleteResult res = coleccion.deleteOne(eq("email", uStd.getEmailUsuario()));
			return (int) res.getDeletedCount();
		}catch(Exception e){
			return -1;
		}finally{
			if(client != null) client.close();
		}
	}

	@Override
	public int updateCarrera(Carrera c) throws Exception {
		MongoClient client = new MongoClient();
		try{
			MongoDatabase db = client.getDatabase(MONGO_DB_NAME);
			MongoCollection<Document> coleccion = db.getCollection("carreras");
			
			// FIXME
			UpdateResult res = coleccion.updateOne( eq("_id", c.getNbCarrera()), 
					new Document("$set", 
							new Document("distancia", (double) c.getDistanciaCarrera())
							.append("desnivel", (double) c.getDesnivelCarrera())
							.append("precio", (double) c.getPrecioCarrera())
							.append("fecha", c.getFechaCarrera())
							.append("lugar", c.getLugarCarrera())
					));
			return (int) res.getModifiedCount();

		}catch(Exception e){
			e.printStackTrace();
			return -1;
		}finally{
			if(client != null) client.close();
		}
	}

	@Override
	public int updateUsuarioOrganizador(UsuarioOrganizador uOrg, UsuarioOrganizador datos) throws Exception {
		MongoClient client = new MongoClient();
		try{
			MongoDatabase db = client.getDatabase(MONGO_DB_NAME);
			MongoCollection<Document> coleccion = db.getCollection("usuariosOrg");
			
			UpdateResult res = coleccion.updateOne( eq("email", uOrg.getEmailUsuario() ), 
					new Document("$set", 
							new Document("nombre", datos.getNbUsuario())
							.append("apellidos", datos.getApellidosUsuario())
							.append("password", datos.getPassUsuario())
							.append("direccion", datos.getDirUsuario())
							.append("telefono", datos.getTelfUsuario())
							.append("club", datos.getClubUsuario())
					));
			return (int) res.getModifiedCount();

		}catch(Exception e){
			return -1;
		}finally{
			if(client != null) client.close();
		}
	}

	@Override
	public int updateUsuarioNormal(UsuarioNormal uStd) throws Exception {
		MongoClient client = new MongoClient();
		try{
			MongoDatabase db = client.getDatabase(MONGO_DB_NAME);
			MongoCollection<Document> coleccion = db.getCollection("usuariosNormal");
			
			UpdateResult res = coleccion.updateOne( eq("email", uStd.getEmailUsuario() ), 
					new Document("$set", 
							new Document("nombre", uStd.getNbUsuario())
							.append("apellidos", uStd.getApellidosUsuario())
							.append("password", uStd.getPassUsuario())
							.append("direccion", uStd.getDirUsuario())
							.append("telefono", uStd.getTelfUsuario())
							.append("club", uStd.getClubUsuario())
					));
			
			return (int) res.getModifiedCount();

		}catch(Exception e){
			e.printStackTrace();
			return -1;
		}finally{
			if(client != null) client.close();
		}
	}

	@Override
	public boolean loginAdmin(UsuarioAdmin admin) throws Exception {
		MongoClient client = new MongoClient();
		try{
			MongoDatabase db = client.getDatabase(MONGO_DB_NAME);
			MongoCollection<Document> coleccion = db.getCollection("usuariosAdmin");
			MongoCursor<Document> doc = coleccion.find( and(eq("email", admin.getEmailUsuario()), eq("password", admin.getPassUsuario()))).iterator();
			
			if(doc.hasNext()){
				return true;
			}else{
				return false;
			}
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}finally{
			if(client != null) client.close();
		}
		
	}

	@Override
	public boolean loginNormal(UsuarioNormal uStd) throws Exception {
		MongoClient client = new MongoClient();
		try{
			MongoDatabase db = client.getDatabase(MONGO_DB_NAME);
			MongoCollection<Document> coleccion = db.getCollection("usuariosNormal");
			MongoCursor<Document> doc = coleccion.find( and(eq("email", uStd.getEmailUsuario()), eq("password", uStd.getPassUsuario()))).iterator();
			
			if(doc.hasNext()){
				return true;
			}else{
				return false;
			}
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}finally{
			if(client != null) client.close();
		}
	}

	@Override
	public boolean loginOrganizador(UsuarioOrganizador uOrg) throws Exception {
		MongoClient client = new MongoClient();
		try{
			MongoDatabase db = client.getDatabase(MONGO_DB_NAME);
			MongoCollection<Document> coleccion = db.getCollection("usuariosOrg");
			MongoCursor<Document> doc = coleccion.find( and(eq("email", uOrg.getEmailUsuario()), eq("password", uOrg.getPassUsuario()))).iterator();
			
			if(doc.hasNext()){
				return true;
			}else{
				return false;
			}
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}finally{
			if(client != null) client.close();
		}
	}

}
