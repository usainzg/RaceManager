package vista;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import bbdd.MySqlManager;
import clases.UsuarioEstandar;
import clases.UsuarioOrganizador;
import utilidades.Utilidades;

public class ModificacionUsuario extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField txtNombre;
	private JTextField txtDir;
	private JTextField txtPass;
	private JTextField txtTelf;
	private JTextField txtClub;
	private MySqlManager mySql = new MySqlManager();
	private JTextField txtApellidos;
	private Utilidades util = new Utilidades();

	/**
	 * Create the frame.
	 */
	public ModificacionUsuario() {
		setTitle("Modificacion Usuarios");
		setBounds(100, 100, 525, 524);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);

		JLabel lblTipoUsuarioA = new JLabel("Tipo usuario a modificar: ");
		lblTipoUsuarioA.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblTipoUsuarioA.setBounds(22, 39, 162, 14);
		getContentPane().add(lblTipoUsuarioA);

		JComboBox<String> comboBox = new JComboBox<String>();

		comboBox.addItem("Normal");
		comboBox.addItem("Organizador");
		comboBox.setSelectedItem("Normal");

		comboBox.setBounds(32, 66, 142, 20);
		getContentPane().add(comboBox);

		JLabel lblNombre = new JLabel("Nombre: ");
		lblNombre.setBounds(32, 151, 46, 14);
		getContentPane().add(lblNombre);

		JLabel lblEmailUsuarioA = new JLabel("Email usuario a modificar: ");
		lblEmailUsuarioA.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblEmailUsuarioA.setBounds(245, 39, 177, 14);
		getContentPane().add(lblEmailUsuarioA);

		JComboBox<Object> comboBox_1 = new JComboBox<>();
		comboBox_1.setBounds(255, 66, 214, 20);
		getContentPane().add(comboBox_1);

		JLabel lblNuevosDatos = new JLabel("Nuevos datos:");
		lblNuevosDatos.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNuevosDatos.setBounds(22, 123, 101, 14);
		getContentPane().add(lblNuevosDatos);

		txtNombre = new JTextField();
		txtNombre.setBounds(106, 148, 142, 20);
		getContentPane().add(txtNombre);
		txtNombre.setColumns(10);

		txtDir = new JTextField();
		txtDir.setBounds(106, 186, 142, 20);
		getContentPane().add(txtDir);
		txtDir.setColumns(10);

		JLabel lblDireccion = new JLabel("Direccion:");
		lblDireccion.setBounds(32, 189, 60, 14);
		getContentPane().add(lblDireccion);

		JLabel lblConstrasea = new JLabel("Contrase\u00F1a: ");
		lblConstrasea.setBounds(32, 233, 80, 14);
		getContentPane().add(lblConstrasea);

		JLabel lblTelefono = new JLabel("Telefono:");
		lblTelefono.setBounds(32, 268, 60, 14);
		getContentPane().add(lblTelefono);

		JLabel lblClub = new JLabel("Club:");
		lblClub.setBounds(32, 304, 46, 14);
		getContentPane().add(lblClub);

		txtPass = new JTextField();
		txtPass.setBounds(106, 230, 142, 20);
		getContentPane().add(txtPass);
		txtPass.setColumns(10);

		txtTelf = new JTextField();
		txtTelf.setBounds(106, 265, 142, 20);
		getContentPane().add(txtTelf);
		txtTelf.setColumns(10);

		txtClub = new JTextField();
		txtClub.setBounds(106, 301, 142, 20);
		getContentPane().add(txtClub);
		txtClub.setColumns(10);

		JButton btnModificar = new JButton("Modificar");

		btnModificar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnModificar.setBounds(74, 431, 89, 23);
		getContentPane().add(btnModificar);

		JButton btnLimpiar = new JButton("Limpiar");

		btnLimpiar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnLimpiar.setBounds(192, 431, 89, 23);
		getContentPane().add(btnLimpiar);

		JLabel lblApellidos = new JLabel("Apellidos:");
		lblApellidos.setBounds(32, 353, 46, 14);
		getContentPane().add(lblApellidos);

		txtApellidos = new JTextField();
		txtApellidos.setBounds(108, 350, 140, 20);
		getContentPane().add(txtApellidos);
		txtApellidos.setColumns(10);

		// action listeners

		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent arg0) {
				comboBox.addItem("Normal");
				comboBox.addItem("Organizador");
				comboBox.setSelectedItem("Normal");
			}
		});

		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				comboBox_1.removeAllItems();
				if (comboBox.getSelectedItem().equals("Normal")) {

					ArrayList<UsuarioEstandar> arrU = new ArrayList<UsuarioEstandar>();
					try {
						arrU = mySql.consultarEmailNormal();
					} catch (Exception e1) {
						e1.printStackTrace();
					}

					for (UsuarioEstandar u : arrU) {
						comboBox_1.addItem(u.getEmailUsuario());
					}

				} else {

					ArrayList<UsuarioOrganizador> arrU = new ArrayList<>();
					try {
						arrU = mySql.consultarEmailOrg();
					} catch (Exception e1) {
						e1.printStackTrace();
					}

					for (UsuarioOrganizador u : arrU) {
						comboBox_1.addItem(u.getEmailUsuario());
					}

				}

			}
		});

		btnModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (validarEntrada() == true) {

					if (comboBox.getSelectedItem().equals("Normal")) {
						UsuarioEstandar uViejo = new UsuarioEstandar("", "", comboBox_1.getSelectedItem().toString(),
								"", "", 0, "");
						UsuarioEstandar u = new UsuarioEstandar();

						u.setNbUsuario(txtNombre.getText());
						u.setApellidosUsuario(txtApellidos.getText());
						u.setEmailUsuario(comboBox_1.getSelectedItem().toString());
						u.setPassUsuario(txtPass.getText());
						u.setDirUsuario(txtDir.getText());
						u.setTelfUsuario(Integer.parseInt(txtTelf.getText()));
						u.setClubUsuario(txtClub.getText());

						try {
							int filas = mySql.updateUsuarioNormal(uViejo, u);
							util.createInfobox("Se han modificado " + filas + " correctamente.",
									"Modificacion correcta");
						} catch (Exception e1) {
							e1.printStackTrace();
						}

					} else {

						UsuarioOrganizador uViejo = new UsuarioOrganizador("", "", "",
								comboBox_1.getSelectedItem().toString(), "", 0, "");
						UsuarioOrganizador uOrg = new UsuarioOrganizador();

						uOrg.setNbUsuario(txtNombre.getText());
						uOrg.setApellidosUsuario(txtApellidos.getText());
						uOrg.setEmailUsuario(comboBox_1.getSelectedItem().toString());
						uOrg.setPassUsuario(txtPass.getText());
						uOrg.setDirUsuario(txtDir.getText());
						uOrg.setTelfUsuario(Integer.parseInt(txtTelf.getText()));
						uOrg.setClubUsuario(txtClub.getText());

						try {
							int filas = mySql.updateUsuarioOrganizador(uViejo, uOrg);
							util.createInfobox("Se han modificado " + filas + " correctamente.",
									"Modificacion correcta");
						} catch (Exception e1) {
							e1.printStackTrace();
						}

					}

				} else {
					util.createErrorbox("Vuelve a introducir los datos por favor.", "Datos erroneos");
				}
			}
		});

		btnLimpiar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				txtNombre.setText("");
				txtApellidos.setText("");
				txtDir.setText("");
				txtPass.setText("");
				txtTelf.setText("");
				txtClub.setText("");

			}
		});
	}

	public boolean validarEntrada() {

		if (!txtNombre.getText().equals("") && !txtApellidos.getText().equals("") && !txtPass.getText().equals("")
				&& !txtDir.getText().equals("") && !txtTelf.getText().equals("") && !txtClub.getText().equals("")) {

			// validate pass
			if (!util.validarPassword(txtPass.getText())) {
				util.createErrorbox(
						"La contrase�a debe tener al menos 6 caracteres de longitud y algun letra mayuscula.",
						"Formato contrase�a erroneo.");
				txtPass.setText("");
			}

			// validate telf
			if (!util.validarTelefono(txtTelf.getText())) {
				util.createErrorbox("El campo telefono debe ser numerico y tener un maximo de 9 digitos.",
						"Formato telefono erroneo.");
			}
			return true;
		} else {
			util.createErrorbox("Te faltan campos por rellenar, por favor completa todos los campos.",
					"Faltan campos por rellenar.");
			return false;
		}
	}
}
