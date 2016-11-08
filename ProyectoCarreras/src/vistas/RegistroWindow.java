package vistas;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import bbdd.ManagerBd;
import clases.UsuarioEstandar;
import clases.UsuarioOrganizador;
import utilidades.Utilidades;

public class RegistroWindow extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField registroNombre;
	private JTextField registroApellidos;
	private JTextField registroEmail;
	private JTextField registroPassword;
	private JTextField registroDireccion;
	private JTextField registroTelf;
	private JTextField registroClub;
	private final String[] USERTYPES = { "Normal", "Organizacion" };
	// TODO change null
	private ManagerBd dbm = null;
	private final Utilidades util = new Utilidades();

	/**
	 * Create the dialog.
	 */
	public RegistroWindow(ManagerBd dbm) {
		this.dbm = dbm;
		
		setTitle("Registro");
		setBounds(100, 100, 492, 292);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		// labels
		{
			JLabel lblNewLabel = new JLabel("Nombre");
			lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
			lblNewLabel.setBounds(10, 38, 56, 14);
			contentPanel.add(lblNewLabel);
		}
		{
			JLabel lblApellidos = new JLabel("Apellidos");
			lblApellidos.setFont(new Font("Tahoma", Font.BOLD, 12));
			lblApellidos.setBounds(222, 38, 65, 14);
			contentPanel.add(lblApellidos);
		}
		{
			JLabel lblEmail = new JLabel("Email");
			lblEmail.setFont(new Font("Tahoma", Font.BOLD, 12));
			lblEmail.setBounds(10, 82, 46, 14);
			contentPanel.add(lblEmail);
		}
		{
			JLabel lblContrasea = new JLabel("Contrase\u00F1a");
			lblContrasea.setFont(new Font("Tahoma", Font.BOLD, 12));
			lblContrasea.setBounds(222, 82, 83, 14);
			contentPanel.add(lblContrasea);
		}
		{
			JLabel lblDireccion = new JLabel("Direccion");
			lblDireccion.setFont(new Font("Tahoma", Font.BOLD, 12));
			lblDireccion.setBounds(10, 121, 56, 14);
			contentPanel.add(lblDireccion);
		}
		{
			JLabel lblTelefono = new JLabel("Telefono");
			lblTelefono.setFont(new Font("Tahoma", Font.BOLD, 12));
			lblTelefono.setBounds(222, 121, 56, 14);
			contentPanel.add(lblTelefono);
		}
		{
			JLabel lblClub = new JLabel("Club");
			lblClub.setFont(new Font("Tahoma", Font.BOLD, 12));
			lblClub.setBounds(10, 160, 46, 14);
			contentPanel.add(lblClub);
		}

		// textfields
		{
			registroNombre = new JTextField();
			registroNombre.setBounds(76, 36, 125, 20);
			contentPanel.add(registroNombre);
			registroNombre.setColumns(10);
		}
		{
			registroApellidos = new JTextField();
			registroApellidos.setBounds(307, 36, 150, 20);
			contentPanel.add(registroApellidos);
			registroApellidos.setColumns(10);
		}
		{
			registroEmail = new JTextField();
			registroEmail.setBounds(76, 80, 125, 20);
			contentPanel.add(registroEmail);
			registroEmail.setColumns(10);
		}
		{
			registroPassword = new JTextField();
			registroPassword.setBounds(307, 80, 150, 20);
			contentPanel.add(registroPassword);
			registroPassword.setColumns(10);
		}
		{
			registroDireccion = new JTextField();
			registroDireccion.setBounds(76, 119, 125, 20);
			contentPanel.add(registroDireccion);
			registroDireccion.setColumns(10);
		}
		{
			registroTelf = new JTextField();
			registroTelf.setBounds(307, 119, 150, 20);
			contentPanel.add(registroTelf);
			registroTelf.setColumns(10);
		}
		{
			registroClub = new JTextField();
			registroClub.setBounds(76, 158, 125, 20);
			contentPanel.add(registroClub);
			registroClub.setColumns(10);
		}

		// combobox with user types
		JComboBox<String> comboTipoUsuario = new JComboBox<String>();
		comboTipoUsuario.setBounds(307, 158, 150, 20);

		// populate combobox with constant string array
		comboTipoUsuario.setModel(new DefaultComboBoxModel<String>(USERTYPES));
		contentPanel.add(comboTipoUsuario);

		// label for combobox
		JLabel lblTipoUsuario = new JLabel("Tipo usuario");
		lblTipoUsuario.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblTipoUsuario.setBounds(222, 161, 83, 14);
		contentPanel.add(lblTipoUsuario);

		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okBtn = new JButton("Registrarse");

				// register event handler
				okBtn.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						boolean salidaForm = validarFormulario();
						if (salidaForm == true) {

							// NORMAL USER REGISTER
							if (comboTipoUsuario.getSelectedItem().toString().equals("Normal")) {
								UsuarioEstandar uToInsert = new UsuarioEstandar(registroNombre.getText(),
										registroApellidos.getText(), registroDireccion.getText(),
										registroEmail.getText(), registroPassword.getText(),
										Integer.parseInt(registroTelf.getText()), registroClub.getText());
								try {
									
									int filas = dbm.altaUsuarioNormal(uToInsert);
									System.out.println("introducidas: " + filas);
									
									util.createInfobox("El usuario ha sido introducido correctamente en la base de datos.",
											"Insercion correcta.");
								} catch (Exception e1) {
									util.createErrorbox("No se han podido introducir los datos.",
											"Insercion incorrecta.");
								}

								// ORGANIZACION USER REGISTER
							} else {
								UsuarioOrganizador uOrg = new UsuarioOrganizador(registroNombre.getText(),
										registroApellidos.getText(), registroDireccion.getText(),
										registroEmail.getText(), registroPassword.getText(),
										Integer.parseInt(registroTelf.getText()), registroClub.getText());
								try {
									
									int filas = dbm.altaOrganizador(uOrg);
									System.out.println("introducidas: " + filas);
									
									util.createInfobox("El usuario ha sido introducido correctamente en la base de datos.",
											"Insercion correcta.");
								} catch (Exception e1) {
									util.createErrorbox("No se han podido introducir los datos.",
											"Insercion incorrecta.");
								}
							}
						}

					}
				});
				okBtn.setFont(new Font("Tahoma", Font.BOLD, 11));
				okBtn.setActionCommand("");
				buttonPane.add(okBtn);
				getRootPane().setDefaultButton(okBtn);

				{
					JButton btnLimpiar = new JButton("Limpiar");
					btnLimpiar.addActionListener(new ActionListener() {
						JTextField[] arrJ = { registroNombre, registroApellidos, registroClub, registroDireccion,
								registroEmail, registroPassword, registroTelf };

						public void actionPerformed(ActionEvent arg0) {
							for (JTextField j : arrJ) {
								util.resetJTextField(j);
							}

						}
					});
					btnLimpiar.setFont(new Font("Tahoma", Font.BOLD, 11));
					buttonPane.add(btnLimpiar);
				}

			}
			{
				JButton cancelBtn = new JButton("Cancel");

				// cancel event handler
				cancelBtn.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				cancelBtn.setFont(new Font("Tahoma", Font.BOLD, 11));
				cancelBtn.setActionCommand("Cancel");
				buttonPane.add(cancelBtn);
			}
		}
	}

	// TODO refactor
	private boolean validarFormulario() {
		Utilidades util = new Utilidades();
		if (!registroNombre.getText().equals("") && !registroApellidos.getText().equals("")
				&& !registroEmail.getText().equals("") && !registroPassword.getText().equals("")
				&& !registroDireccion.getText().equals("") && !registroTelf.getText().equals("")
				&& !registroClub.getText().equals("")) {

			// validate email
			if (!util.isValidEmail(registroEmail.getText())) {
				util.createErrorbox("Introduce una direccion de email valida.", "Formato email erroneo.");
				registroEmail.setText("");
				return false;
			}

			// validate pass
			if (!util.isValidPassword(registroPassword.getText())) {
				util.createErrorbox(
						"La contrase�a debe tener al menos 6 caracteres de longitud y algun letra mayuscula.",
						"Formato contrase�a erroneo.");
				registroPassword.setText("");
				return false;
			}

			// validate telf
			if (!util.isValidPhone(registroTelf.getText())) {
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
}
