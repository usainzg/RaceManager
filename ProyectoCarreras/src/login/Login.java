package login;

import javax.swing.JTextField;

import bbdd.MySqlManager;
import clases.UsuarioAdmin;
import clases.UsuarioEstandar;
import clases.UsuarioOrganizador;
import utilidades.Utilidades;

public class Login {
	private MySqlManager mySql = new MySqlManager();
	private Utilidades util = new Utilidades();
	
	public Login(){ } 
	
	// ADMIN LOGIN
	public void loginAdmin(JTextField email, JTextField pass){
		
		UsuarioAdmin uAdmin = new UsuarioAdmin("", "", "", email.getText(), pass.getText(), 0, "");
		try {
			boolean resLogin = mySql.loginAdmin(uAdmin);
			if(resLogin == true)
				// TODO
				util.createInfobox("logeado!", "Login realizado con existo");
			else
				// TODO
				util.createInfobox("no logea bien", "mal");
		} catch (Exception e1) {
			e1.printStackTrace();
		}
	}
	
	// NORMAL LOGIN
	public void loginNormal(JTextField email, JTextField pass){
		UsuarioEstandar uStd = new UsuarioEstandar("", "", "", email.getText(), pass.getText(), 0, "");
		try {
			boolean resLogin = mySql.loginNormal(uStd);
			if(resLogin == true)
				// TODO
				util.createInfobox("logeado!", "Login realizado con existo");
			else
				// TODO
				util.createInfobox("no logea bien", "mal");
		} catch (Exception e1) {
			e1.printStackTrace();
		}
	}
	
	// ORGANIZADOR LOGIN
	public void loginOrganizador(JTextField email, JTextField pass){
		UsuarioOrganizador uOrg = new UsuarioOrganizador("", "", "", email.getText(), pass.getText(), 0, "", 0);
		try {
			boolean resLogin = mySql.loginOrganizador(uOrg);
			if(resLogin == true)
				// TODO
				util.createInfobox("logeado!", "Login realizado con existo");
			else
				// TODO
				util.createInfobox("no logea bien", "mal");
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		
	}

}
