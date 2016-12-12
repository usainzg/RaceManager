package vista.ventanas;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import bbdd.ManagerBd;
import clases.UsuarioNormal;
import clases.UsuarioOrganizador;
import login.Login;
import utilidades.Utilidades;
import utilidades.ViewUtil;
import vista.paneles.LoginPanel;
import vista.paneles.RegistroPanel;

public class MainView extends JFrame implements ActionListener, ViewUtil {

	private static final long serialVersionUID = 1L;

	private final String OPTION_MYSQL = "mysql";
	private final String OPTION_HIBERNATE = "hibernate";
	private final String OPTION_ORACLE = "oracle";

	private Login loginSystem = null;
	private ManagerBd ma;
	private Utilidades util = new Utilidades();

	private LoginPanel panelLogin = new LoginPanel();
	private RegistroPanel panelRegistro = new RegistroPanel();

	private JButton btnAccederLogin, btnRegistrarseLogin;
	private JComboBox<String> comboTipoUsuarioLogin;
	private JTextField txtEmail, txtPassword;

	// Referencias a panel Registro
	private JButton btnCancelRegistro, btnOkRegistro;
	private JTextField reNombre = panelRegistro.getRegistroNombre();
	private JTextField reApellidos = panelRegistro.getRegistroApellidos();
	private JTextField reEmail = panelRegistro.getRegistroEmail();
	private JTextField rePass = panelRegistro.getRegistroPassword();
	private JTextField reDir = panelRegistro.getRegistroDireccion();
	private JTextField reTelf = panelRegistro.getRegistroTelf();
	private JTextField reClub = panelRegistro.getRegistroClub();
	private JComboBox<String> reComboUsuario = panelRegistro.getComboTipoUsuario();

	public MainView() {
		panelRegistro.setPreferredSize(new Dimension(800, 600));
		panelRegistro.setMinimumSize(new Dimension(800, 600));
		panelRegistro.setMaximumSize(new Dimension(800, 600));

		// mantener una referencia a los botones de los diferentes paneles
		// BOTONES PANEL REGISTRO
		btnCancelRegistro = panelRegistro.getCancelBtn();
		btnOkRegistro = panelRegistro.getOkBtn();

		// BOTONES PANEL LOGIN
		btnAccederLogin = panelLogin.getBtnAcceder();
		btnRegistrarseLogin = panelLogin.getBtnRegistrarse();
		comboTipoUsuarioLogin = panelLogin.getComboTipoUsuario();
		txtEmail = panelLogin.getTxtEmail();
		txtPassword = panelLogin.getTxtPassword();

		// no dejar hacer resize
		setResizable(false);

		getContentPane().setLayout(new BorderLayout());

		String db = "";
		while (true) {

			db = JOptionPane.showInputDialog("Introduce la base de datos que desees usar: (mysql, hibernate u oracle)");
			
			if (db == null) {
				util.createInfobox("Has cancelado el inicio de la aplicacion, adios.", "Inicio aplicación cancelada.");
				System.exit(0);
			}

			if (db.equalsIgnoreCase(OPTION_MYSQL) || db.equalsIgnoreCase(OPTION_HIBERNATE) || db.equalsIgnoreCase(OPTION_ORACLE)) {
				ma = new ManagerBd();
				ma.setDb(db);
				break;
			}

		}

		loginSystem = new Login(ma);

		setBounds(500, 300, 523, 403);
		setLocation(0, 0);
		setTitle("Proyecto Unai");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GridBagLayout gridBagLayout = (GridBagLayout) panelLogin.getLayout();
		gridBagLayout.columnWidths = new int[] { 43, 87, 328, 0, 38 };

		getContentPane().add(panelLogin, BorderLayout.CENTER);
		pack();

		btnAccederLogin.addActionListener(this);

		btnRegistrarseLogin.addActionListener(this);

		btnCancelRegistro.addActionListener(this);

		btnOkRegistro.addActionListener(this);

	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == btnAccederLogin) {
			try {
				loginSystem.validacionLogin(comboTipoUsuarioLogin, txtEmail, txtPassword);
			} catch (Exception ex) {

			}
		} else if (e.getSource() == btnRegistrarseLogin) {

			changePanel(panelRegistro);

		} else if (e.getSource() == btnCancelRegistro) {

			changePanel(panelLogin);

		} else if (e.getSource() == btnOkRegistro) {
			registroUsuario();
		}

	}

	@Override
	public void changePanel(final JPanel panel) {

		getContentPane().removeAll();
		getContentPane().repaint();
		getContentPane().revalidate();

		getContentPane().add(panel);
		pack();
		getContentPane().repaint();
		getContentPane().revalidate();

	}

	private void registroUsuario() {
		boolean salidaForm = validarFormulario();

		if (salidaForm == true) {

			// NORMAL USER REGISTER
			if (reComboUsuario.getSelectedItem().toString().equals("Normal")) {

				UsuarioNormal uToInsert = new UsuarioNormal(reNombre.getText(), reApellidos.getText(), reDir.getText(),
						reEmail.getText(), rePass.getText(), Integer.parseInt(reTelf.getText()), reClub.getText());
				try {

					int filas = ma.altaUsuarioNormal(uToInsert);
					System.out.println("introducidas: " + filas);

					util.createInfobox("El usuario ha sido introducido correctamente en la base de datos.",
							"Insercion correcta.");
				} catch (Exception e1) {
					util.createErrorbox("No se han podido introducir los datos.", "Insercion incorrecta.");
				}

				// ORGANIZACION USER REGISTER
			} else {

				UsuarioOrganizador uOrg = new UsuarioOrganizador(reNombre.getText(), reApellidos.getText(),
						reDir.getText(), reEmail.getText(), rePass.getText(), Integer.parseInt(reTelf.getText()),
						reClub.getText());
				try {

					int filas = ma.altaOrganizador(uOrg);
					System.out.println("introducidas: " + filas);

					util.createInfobox("El usuario ha sido introducido correctamente en la base de datos.",
							"Insercion correcta.");
				} catch (Exception e1) {
					util.createErrorbox("No se han podido introducir los datos.", "Insercion incorrecta.");
				}
			}
		}

	}

	private boolean validarFormulario() {
		if (!reNombre.getText().equals("") && !reApellidos.getText().equals("") && !reEmail.getText().equals("")
				&& !rePass.getText().equals("") && !reDir.getText().equals("") && !reTelf.getText().equals("")
				&& !reClub.getText().equals("")) {

			if (!util.isValidPhone(reTelf.getText())) {
				util.createErrorbox("El campo telefono debe ser numerico y tener un maximo de 9 digitos.",
						"Formato telefono erroneo.");
				return false;
			}

			if (!util.isValidEmail(reEmail.getText())) {
				util.createErrorbox("El email debe tener una @.", "Formato email erroneo.");
				return false;
			}

			if (!util.isValidPassword(rePass.getText())) {
				util.createErrorbox("La contraseña tiene que tener 6 caracteres y debe contener mayusculas y numeros..",
						"Formato password erroneo.");
				return false;
			}

			return true;
		} else {
			util.createErrorbox("Te faltan campos por rellenar, por favor completa todos los campos.",
					"Faltan campos por rellenar.");
			return false;
		}
	}

}
