package login;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JTextField;

import bbdd.ManagerBd;
import clases.UsuarioAdmin;
import clases.UsuarioEstandar;
import clases.UsuarioOrganizador;
import utilidades.Utilidades;
import vista.ventanas.AdminView;
import vista.ventanas.NormalView;
import vista.ventanas.OrgView;

public class Login {
	
	private ManagerBd dbm = null;
	private Utilidades util = new Utilidades();
	private UsuarioOrganizador orgLogeado;

	public Login(ManagerBd dbm) {
		this.dbm = dbm;
	}

	// ADMIN LOGIN
	public boolean loginAdmin(final JTextField email, final JTextField pass) {

		UsuarioAdmin uAdmin = new UsuarioAdmin("", "", "", email.getText(), pass.getText(), 0, "");
		try {
			boolean resLogin = dbm.loginAdmin(uAdmin);
			if (resLogin == true) {
				util.createInfobox("Logeado!", "Login realizado con exito.");
				return true;
			} else {
				util.createInfobox("Datos incorrectos.", "No logeado.");
				return false;
			}

		} catch (Exception e1) {
			e1.printStackTrace();
			return false;
		}
	}

	// NORMAL LOGIN
	public boolean loginNormal(final JTextField email, final JTextField pass) {
		UsuarioEstandar uStd = new UsuarioEstandar("", "", "", email.getText(), pass.getText(), 0, "");
		try {
			boolean resLogin = dbm.loginNormal(uStd);
			if (resLogin == true) {
				util.createInfobox("Logeado!", "Login realizado con existo");
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
	public boolean loginOrganizador(final JTextField email, final JTextField pass) {
		UsuarioOrganizador uOrg = new UsuarioOrganizador("", "", "", email.getText(), pass.getText(), 0, "", 0);
		try {
			boolean resLogin = dbm.loginOrganizador(uOrg);
			if (resLogin == true) {
				util.createInfobox("Logeado!", "Login realizado con existo");
				orgLogeado = new UsuarioOrganizador("", "", "", email.getText(), pass.getText(), 0, "", 0);
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
	public void validacionLogin(final JComboBox<String> comboTipoUsuario, final JTextField txtEmail, final JTextField txtPassword)
			throws Exception {

		if (!txtEmail.getText().equals("") && !txtPassword.getText().equals("")) {

			// validate email
			if (!util.isValidEmail(txtEmail.getText())) {
				util.createErrorbox("Introduce una direccion de email valida.", "Formato email erroneo.");
				util.resetJTextField(txtEmail, txtPassword);

				// validate password
			} else if (!util.isValidPassword(txtPassword.getText())) {
				util.createErrorbox(
						"La contraseña debe tener al menos 6 caracteres de longitud y algun letra mayuscula.",
						"Formato contraseña erroneo.");
				util.resetJTextField(txtEmail, txtPassword);
			} else {

				// admin login
				if (comboTipoUsuario.getSelectedItem().toString() == "Admin") {
					if (loginAdmin(txtEmail, txtPassword)) {
						AdminView admin = new AdminView(dbm);
						admin.setVisible(true);
						admin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					}

					// usuario normal login
				} else if (comboTipoUsuario.getSelectedItem().toString() == "Normal") {
					if (loginNormal(txtEmail, txtPassword)) {
						NormalView normal = new NormalView(dbm);
						normal.setVisible(true);
						normal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					}

					// organizador login
				} else {
					if (loginOrganizador(txtEmail, txtPassword)) {
						OrgView org = new OrgView(dbm, orgLogeado);
						org.setVisible(true);
						org.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
