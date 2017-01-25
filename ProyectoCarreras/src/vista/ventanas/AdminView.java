package vista.ventanas;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextField;

import bbdd.ManagerBd;
import clases.Carrera;
import clases.UsuarioNormal;
import clases.UsuarioOrganizador;
import utilidades.Utilidades;
import utilidades.ViewUtil;
import vista.paneles.VisualizacionCarrerasPanel;
import vista.paneles.admin.BorradoUsuario;
import vista.paneles.admin.DeleteCarreraAdminPanel;
import vista.paneles.admin.ModificacionCarreraAdmin;
import vista.paneles.admin.ModificacionUsuarioAdmin;

public class AdminView extends JFrame implements ActionListener, ViewUtil {

	// OBJETOS
	private ManagerBd manager;
	private Utilidades util = new Utilidades();

	// PANELES
	private ModificacionCarreraAdmin panelModificacionCarrera = new ModificacionCarreraAdmin();
	private VisualizacionCarrerasPanel panelVisualizacion;
	private BorradoUsuario panelBorradoUsuario = new BorradoUsuario();
	private DeleteCarreraAdminPanel panelBorradoCarrera = new DeleteCarreraAdminPanel();
	private ModificacionUsuarioAdmin panelModificacionUsuario = new ModificacionUsuarioAdmin();

	// ITEMS MENU
	private JMenuItem mnVisualizarCarreras, mnModificarCarreras, mnEliminarCarreras, mnModificarUsuarios,
			mnEliminarUsuarios;

	// REFERENCIAS CARRERA
	// Referencias panel BorradoCarrera
	private JComboBox<Object> borradoComboCarrera = panelBorradoCarrera.getComboCarreraBorrar();
	private JButton btnBorradoCarrera = panelBorradoCarrera.getBtnBorrar();

	// Referencia panel ModificacionCarreraAdmin
	private JTextField modDistancia = panelModificacionCarrera.getTxtDistancia();
	private JTextField modDesnivel = panelModificacionCarrera.getTxtDesnivel();
	private JTextField modPrecio = panelModificacionCarrera.getTxtPrecio();
	private JTextField modLugar = panelModificacionCarrera.getTxtLugar();
	private JTextField modFecha = panelModificacionCarrera.getTxtFecha();
	private JComboBox<Object> modCombo = panelModificacionCarrera.getComboBox();
	private JButton modBtn = panelModificacionCarrera.getBtnModificar();

	// REFERENCIAS USUARIO
	// Referencias panel BorradoUsuario
	private JComboBox<String> borradoComboTipoUsuario = panelBorradoUsuario.getComboTipo();
	private JComboBox<Object> borradoComboEmailUsuario = panelBorradoUsuario.getComboEmail();
	private JButton btnBorradoUsuario = panelBorradoUsuario.getBtnBorrar();

	// Referencias panel ModificacionUsuario
	private JTextField modUsuarioNombre = panelModificacionUsuario.getTxtNombre();
	private JTextField modUsuarioApellidos = panelModificacionUsuario.getTxtApellidos();
	private JTextField modUsuarioDir = panelModificacionUsuario.getTxtDir();
	private JTextField modUsuarioPass = panelModificacionUsuario.getTxtPass();
	private JTextField modUsuarioTelf = panelModificacionUsuario.getTxtTelf();
	private JTextField modUsuarioClub = panelModificacionUsuario.getTxtClub();
	private JComboBox<String> modUsuarioComboTipo = panelModificacionUsuario.getComboTipoUsuarioModificar();
	private JComboBox<Object> modUsuarioComboEmail = panelModificacionUsuario.getComboEmailAModificar();
	private JButton modUsuarioBtnModificar = panelModificacionUsuario.getBtnModificar();

	private static final long serialVersionUID = 1L;

	public AdminView(final ManagerBd manager) {
		setLocation(new Point(0, 0));
		setMinimumSize(new Dimension(800, 600));
		setMaximumSize(new Dimension(800, 600));
		setResizable(false);
		this.manager = manager;
		this.panelVisualizacion = new VisualizacionCarrerasPanel(manager);
		initialize();
	}

	private void initialize() {
		setTitle("Admin");
		setBounds(100, 100, 512, 500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		getContentPane().add(panelVisualizacion, BorderLayout.CENTER);
		pack();

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu mntCarreras = new JMenu("Gestion Carreras");
		menuBar.add(mntCarreras);

		mnVisualizarCarreras = new JMenuItem("Visualizar Carreras");
		mntCarreras.add(mnVisualizarCarreras);

		mnModificarCarreras = new JMenuItem("Modificar Carreras");
		mntCarreras.add(mnModificarCarreras);

		mnEliminarCarreras = new JMenuItem("Eliminar Carreras");
		mntCarreras.add(mnEliminarCarreras);

		JMenu mntUsuarios = new JMenu("Gestion Usuarios");
		menuBar.add(mntUsuarios);

		mnModificarUsuarios = new JMenuItem("Modificar Usuarios");
		mntUsuarios.add(mnModificarUsuarios);

		mnEliminarUsuarios = new JMenuItem("Eliminar Usuarios");
		mntUsuarios.add(mnEliminarUsuarios);

		// listeners jmenuitem carreras
		mnVisualizarCarreras.addActionListener(this);
		mnModificarCarreras.addActionListener(this);
		mnEliminarCarreras.addActionListener(this);

		// listeners jmenuitem usuarios
		mnModificarUsuarios.addActionListener(this);
		mnEliminarUsuarios.addActionListener(this);

		// listeners borrado usuario
		btnBorradoUsuario.addActionListener(this);
		borradoComboTipoUsuario.addActionListener(this);

		// listeners borrado carrera
		btnBorradoCarrera.addActionListener(this);

		// listeners modificacion carrera
		modBtn.addActionListener(this);

		// focus listener modFecha
		modFecha.addFocusListener(new FocusListener() {

			@Override
			public void focusLost(FocusEvent e) {
				if (!modFecha.equals("") && !util.isValidDate(modFecha)) {
					util.createInfobox(
							"Vuelva a introducir la fecha en el siguiente formato: 0000-00-00 / años-meses-dias",
							"Formato fecha erroneo");
					util.resetJTextField(modFecha);
					modFecha.requestFocus();
				}
			}

			@Override
			public void focusGained(FocusEvent e) {
				util.resetJTextField(modFecha);
			}
		});

		// listeners modificacion usuario
		modUsuarioComboTipo.addActionListener(this);
		modUsuarioBtnModificar.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == mnVisualizarCarreras) {
			VisualizacionCarrerasPanel panel = new VisualizacionCarrerasPanel(manager);
			changePanel(panel);

		} else if (e.getSource() == mnModificarCarreras) {

			changePanel(panelModificacionCarrera);
			initComboCarreraMod();

		} else if (e.getSource() == mnEliminarCarreras) {

			changePanel(panelBorradoCarrera);
			initComboCarrera();

		} else if (e.getSource() == mnModificarUsuarios) {

			changePanel(panelModificacionUsuario);
			modUsuarioComboTipo.setSelectedItem("Organizador");

		} else if (e.getSource() == mnEliminarUsuarios) {

			changePanel(panelBorradoUsuario);
			borradoComboTipoUsuario.setSelectedItem("Organizador");
		}

		// action listener panel borrado usuario
		if (e.getSource() == btnBorradoUsuario) {
			borrarUsuario();
		} else if (e.getSource() == borradoComboTipoUsuario) {
			changeComboTipoBorrado();
		}

		// action listener para borrado carrera
		if (e.getSource() == btnBorradoCarrera) {
			borrarCarrera();
		}

		// action listeners para modificar carrera
		if (e.getSource() == modBtn) {
			modificarCarrera();
		}

		// action listeners para modificacion usuario
		if (e.getSource() == modUsuarioBtnModificar) {
			modificarUsuario();
		} else if (e.getSource() == modUsuarioComboTipo) {
			changeComboTipoModificacion();
		}
	}

	// metodos BorradoUsuario
	private void changeComboTipoBorrado() {
		borradoComboEmailUsuario.removeAllItems();
		if (borradoComboTipoUsuario.getSelectedItem().equals("Normal")) {

			ArrayList<UsuarioNormal> arrU = new ArrayList<UsuarioNormal>();
			try {
				arrU = manager.consultarEmailNormal();
			} catch (Exception e1) {
				e1.printStackTrace();
			}

			for (UsuarioNormal u : arrU) {
				borradoComboEmailUsuario.addItem(u.getEmailUsuario());
			}

		} else {

			ArrayList<UsuarioOrganizador> arrU = new ArrayList<>();
			try {
				arrU = manager.consultarEmailOrg();
			} catch (Exception e1) {
				e1.printStackTrace();
			}

			for (UsuarioOrganizador u : arrU) {
				borradoComboEmailUsuario.addItem(u.getEmailUsuario());
			}
		}
	}

	private void borrarUsuario() {
		if (borradoComboTipoUsuario.getSelectedItem().equals("Normal")) {

			try {
				UsuarioNormal uStd = new UsuarioNormal();
				uStd.setNbUsuario("");
				uStd.setApellidosUsuario("");
				uStd.setEmailUsuario(borradoComboEmailUsuario.getSelectedItem().toString());
				uStd.setPassUsuario("");
				uStd.setDirUsuario("");
				uStd.setTelfUsuario(0);
				uStd.setClubUsuario("");
				int filas = manager.deleteUsuarioNormal(uStd);
				util.createInfobox("Se han eliminado " + filas + " de la base de datos.", "Borrado completado");
				borradoComboEmailUsuario.removeItem(uStd.getEmailUsuario());
			} catch (Exception ex) {
				util.createErrorbox("No se ha podido borrar el usuario", "Borrado no completado");
			}

		} else {

			try {
				UsuarioOrganizador uOrg = new UsuarioOrganizador();

				uOrg.setNbUsuario("");
				uOrg.setApellidosUsuario("");
				uOrg.setEmailUsuario(borradoComboEmailUsuario.getSelectedItem().toString());
				uOrg.setPassUsuario("");
				uOrg.setDirUsuario("");
				uOrg.setTelfUsuario(0);
				uOrg.setClubUsuario("");
				int filas = manager.deleteUsuarioOrganizador(uOrg);
				util.createInfobox("Se han eliminado " + filas + " de la base de datos.", "Borrado completado");
				borradoComboEmailUsuario.removeItem(uOrg.getEmailUsuario());
			} catch (Exception ex) {
				util.createErrorbox("No se ha podido borrar el usuario", "Borrado no completado");
			}

		}
	}

	// metodos ModificacionUsuarioAdmin
	private void changeComboTipoModificacion() {

		modUsuarioComboEmail.removeAllItems();
		if (modUsuarioComboTipo.getSelectedItem().equals("Normal")) {

			ArrayList<UsuarioNormal> arrU = new ArrayList<UsuarioNormal>();
			try {
				arrU = manager.consultarEmailNormal();
			} catch (Exception e1) {
				e1.printStackTrace();
			}

			for (UsuarioNormal u : arrU) {
				modUsuarioComboEmail.addItem(u.getEmailUsuario());
			}

		} else {

			ArrayList<UsuarioOrganizador> arrU = new ArrayList<>();
			try {
				arrU = manager.consultarEmailOrg();
			} catch (Exception e1) {
				e1.printStackTrace();
			}

			for (UsuarioOrganizador u : arrU) {
				modUsuarioComboEmail.addItem(u.getEmailUsuario());
			}

		}

	}

	private void modificarUsuario() {

		if (validarEntradaModificacionUsuario() == true) {

			if (modUsuarioComboTipo.getSelectedItem().equals("Normal")) {
				UsuarioNormal u = new UsuarioNormal();

				u.setNbUsuario(modUsuarioNombre.getText());
				u.setApellidosUsuario(modUsuarioApellidos.getText());
				u.setEmailUsuario(modUsuarioComboEmail.getSelectedItem().toString());
				u.setPassUsuario(modUsuarioPass.getText());
				u.setDirUsuario(modUsuarioDir.getText());
				u.setTelfUsuario(Integer.parseInt(modUsuarioTelf.getText()));
				u.setClubUsuario(modUsuarioClub.getText());

				try {
					int filas = manager.updateUsuarioNormal(u);
					util.createInfobox("Se han modificado " + filas + " correctamente.", "Modificacion correcta");
				} catch (Exception e1) {
					e1.printStackTrace();
				}

			} else {

				UsuarioOrganizador uViejo = new UsuarioOrganizador("", "", "",
						modUsuarioComboEmail.getSelectedItem().toString(), "", 0, "");
				UsuarioOrganizador uOrg = new UsuarioOrganizador();

				uOrg.setNbUsuario(modUsuarioNombre.getText());
				uOrg.setApellidosUsuario(modUsuarioApellidos.getText());
				uOrg.setEmailUsuario(modUsuarioComboEmail.getSelectedItem().toString());
				uOrg.setPassUsuario(modUsuarioPass.getText());
				uOrg.setDirUsuario(modUsuarioDir.getText());
				uOrg.setTelfUsuario(Integer.parseInt(modUsuarioTelf.getText()));
				uOrg.setClubUsuario(modUsuarioClub.getText());

				try {
					int filas = manager.updateUsuarioOrganizador(uViejo, uOrg);
					util.createInfobox("Se han modificado " + filas + " correctamente.", "Modificacion correcta");
				} catch (Exception e1) {
					e1.printStackTrace();
				}

			}

		} else {
			util.createErrorbox("Vuelve a introducir los datos por favor.", "Datos erroneos");
		}
	}

	private boolean validarEntradaModificacionUsuario() {
		if (!modUsuarioNombre.getText().equals("") && !modUsuarioApellidos.getText().equals("")
				&& !modUsuarioPass.getText().equals("") && !modUsuarioDir.getText().equals("")
				&& !modUsuarioTelf.getText().equals("") && !modUsuarioClub.getText().equals("")) {

			// validate pass
			if (!util.isValidPassword(modUsuarioPass.getText())) {
				util.createErrorbox(
						"La contraseña debe tener al menos 6 caracteres de longitud y algun letra mayuscula.",
						"Formato contraseña erroneo.");
				modUsuarioPass.setText("");
				return false;
			}

			// validate telf
			if (!util.isValidPhone(modUsuarioTelf.getText())) {
				util.createErrorbox("El campo telefono debe ser numerico y tener un maximo de 9 digitos.",
						"Formato telefono erroneo.");
				return false;
			}
			return true;
		} else {
			util.createErrorbox("Te faltan campos por rellenar, por favor completa todos los campos.",
					"Faltan campos por rellenar.");
			return false;
		}
	}

	// metodos BorradoCarrera
	private void initComboCarrera() {
		ArrayList<Carrera> arr = new ArrayList<>();

		try {
			arr = manager.consultarCarreras();
			for (Carrera c : arr) {
				borradoComboCarrera.addItem(c.getNbCarrera());
			}
		} catch (Exception e) {
			util.createErrorbox("Error al recoger datos de la base de datos", "Error conexion base de datos");
		}
	}

	private void borrarCarrera() {

		try {
			Carrera c = new Carrera(borradoComboCarrera.getSelectedItem().toString(), null, 0, 0, 0, "", "");
			int filas = manager.deleteCarrera(c);

			util.createInfobox("Se han borrado " + filas + " filas de la base de datos.", "Borrado completado");
			borradoComboCarrera.removeItem(c.getNbCarrera());

		} catch (Exception ex) {
			util.createErrorbox("No se ha podido borrar la carrera", "Borrado no completado");
		}
	}

	// metodos ModificacionCarreraAdmin
	private void initComboCarreraMod() {
		ArrayList<Carrera> arr = new ArrayList<>();

		try {
			arr = manager.consultarCarreras();

			for (Carrera c : arr) {
				modCombo.addItem(c.getNbCarrera());
			}
		} catch (Exception e) {
			util.createErrorbox("Error al recoger datos de la base de datos", "Error conexion base de datos");
		}
	}

	private void modificarCarrera() {
		if (util.isValidDate(modFecha)) {
			try {

				Carrera cNueva = new Carrera();
				cNueva.setNbCarrera(modCombo.getSelectedItem().toString());
				cNueva.setOrgCarrera(null);
				cNueva.setDistanciaCarrera(Integer.parseInt(modDistancia.getText()));
				cNueva.setDesnivelCarrera(Integer.parseInt(modDesnivel.getText()));
				cNueva.setPrecioCarrera(Integer.parseInt(modPrecio.getText()));

				SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
				String str = modFecha.getText();

				try {
					Date date = formatter.parse(str);
					String formateado = formatter.format(date);
					cNueva.setFechaCarrera(formateado);
				} catch (Exception ex) {
					ex.printStackTrace();
				}

				cNueva.setLugarCarrera(modLugar.getText());

				int filas = manager.updateCarrera(cNueva);
				util.createInfobox("Se han modificado " + filas + " filas de la base de datos.",
						"Modificacion completada.");

			} catch (Exception ex) {
				ex.printStackTrace();
			}

		} else {
			util.createErrorbox("Revise los campos", "Fallo de formato");
		}

	}

	// metodos de la interfaz
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

}
