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

	public Login() {
	}

	// ADMIN LOGIN
	public boolean loginAdmin(JTextField email, JTextField pass) {

		UsuarioAdmin uAdmin = new UsuarioAdmin("", "", "", email.getText(), pass.getText(), 0, "");
		try {
			boolean resLogin = mySql.loginAdmin(uAdmin);
			if (resLogin == true) {
				util.createInfobox("logeado!", "Login realizado con existo");
				return true;
			} else {
				util.createInfobox("Datos incorrectos", "No logeado");
				return false;
			}

		} catch (Exception e1) {
			e1.printStackTrace();
			return false;
		}
	}

	// NORMAL LOGIN
	public boolean loginNormal(JTextField email, JTextField pass) {
		UsuarioEstandar uStd = new UsuarioEstandar("", "", "", email.getText(), pass.getText(), 0, "");
		try {
			boolean resLogin = mySql.loginNormal(uStd);
			if (resLogin == true) {
				util.createInfobox("logeado!", "Login realizado con existo");
				return true;
			} else {
				util.createInfobox("Datos incorrectos", "No logeado");
				return false;
			}

		} catch (Exception e1) {
			e1.printStackTrace();
			return false;
		}
	}

	// ORGANIZADOR LOGIN
	public boolean loginOrganizador(JTextField email, JTextField pass) {
		UsuarioOrganizador uOrg = new UsuarioOrganizador("", "", "", email.getText(), pass.getText(), 0, "", 0);
		try {
			boolean resLogin = mySql.loginOrganizador(uOrg);
			if (resLogin == true) {
				util.createInfobox("logeado!", "Login realizado con existo");
				return true;
			} else {
				util.createInfobox("Datos incorrectos", "No logeado");
				return false;
			}

		} catch (Exception e1) {
			e1.printStackTrace();
			return false;
		}

	}

}
