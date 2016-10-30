package login;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JTextField;

import bbdd.MySqlManager;
import clases.UsuarioAdmin;
import clases.UsuarioEstandar;
import clases.UsuarioOrganizador;
import utilidades.Utilidades;
import vista.MenuAdmin;
import vista.MenuOrg;
import vista.VisualizacionCarrerasWindow;

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
	
	// VALIDACION DE LOGIN
	public void validacionLogin(JComboBox<String> comboTipoUsuario, JTextField txtEmail, JTextField txtPassword) throws Exception {
		
		if (!txtEmail.getText().equals("") && !txtPassword.getText().equals("")) {

			// validate email
			if (!util.validarEmail(txtEmail.getText())) {
				util.createErrorbox("Introduce una direccion de email valida.", "Formato email erroneo.");
				txtEmail.setText("");
				txtPassword.setText("");

				// validate password
			} else if (!util.isValidPassword(txtPassword.getText())) {
				util.createErrorbox(
						"La contraseña debe tener al menos 6 caracteres de longitud y algun letra mayuscula.",
						"Formato contraseña erroneo.");
				txtEmail.setText("");
				txtPassword.setText("");
			} else {

				// admin login
				if (comboTipoUsuario.getSelectedItem().toString() == "Admin") {
					if (loginAdmin(txtEmail, txtPassword)) {
						MenuAdmin menuAdmin = new MenuAdmin();
						menuAdmin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
						menuAdmin.setVisible(true);
					}

					// usuario normal login
				} else if (comboTipoUsuario.getSelectedItem().toString() == "Normal") {
					if (loginNormal(txtEmail, txtPassword)) {
						VisualizacionCarrerasWindow viCarr = new VisualizacionCarrerasWindow();
						viCarr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
						viCarr.setVisible(true);
					}

					// organizador login
				} else {
					if (loginOrganizador(txtEmail, txtPassword)) {
						MenuOrg menuOrg = new MenuOrg();
						menuOrg.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
						menuOrg.setVisible(true);
					}
				}
			}

			// comprueba cuando hay campos vacios
		} else {
			util.createErrorbox("Te faltan campos por rellenar, por favor completa todos los campos.",
					"Faltan campos por rellenar.");
			txtEmail.requestFocus();
		}

	}

}
