package vista.paneles;

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import utilidades.Utilidades;

public class RegistroPanel extends JPanel {

	private static final long serialVersionUID = 1L;

	private JTextField registroNombre;
	private JTextField registroApellidos;
	private JTextField registroEmail;
	private JTextField registroPassword;
	private JTextField registroDireccion;
	private JTextField registroTelf;
	private JTextField registroClub;
	private JButton cancelBtn, okBtn, btnLimpiar;
	private JComboBox<String> comboTipoUsuario;

	private JLabel lblClub;
	private JLabel lblApellidos;
	private JLabel lblEmail;
	private JLabel lblTelefono;
	private JLabel lblContrasena;
	private JLabel lblDireccion;
	private JLabel lblNewLabel;

	private Utilidades util = new Utilidades();

	public JButton getCancelBtn() {
		return cancelBtn;
	}

	public JButton getOkBtn() {
		return okBtn;
	}

	public JButton getBtnLimpiar() {
		return btnLimpiar;
	}

	public JTextField getRegistroNombre() {
		return registroNombre;
	}

	public JTextField getRegistroApellidos() {
		return registroApellidos;
	}

	public JTextField getRegistroEmail() {
		return registroEmail;
	}

	public JTextField getRegistroPassword() {
		return registroPassword;
	}

	public JTextField getRegistroDireccion() {
		return registroDireccion;
	}

	public JTextField getRegistroTelf() {
		return registroTelf;
	}

	public JTextField getRegistroClub() {
		return registroClub;
	}

	public JComboBox<String> getComboTipoUsuario() {
		return comboTipoUsuario;
	}

	private final String[] USERTYPES = { "Normal", "Organizacion" };

	public RegistroPanel() {
		setLayoutView();
	}

	private void setLayoutView() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 32, 84, 20, 52, 81, 34, 75, 1, 173, 37, 0 };
		gridBagLayout.rowHeights = new int[] { 59, 29, 29, 30, 38, 37, 41, 32, 0 };
		gridBagLayout.columnWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
				Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		setLayout(gridBagLayout);

		// labels
		lblNewLabel = new JLabel("Nombre");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 1;
		gbc_lblNewLabel.gridy = 1;
		add(lblNewLabel, gbc_lblNewLabel);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 12));

		// textfields

		registroNombre = new JTextField();
		GridBagConstraints gbc_registroNombre = new GridBagConstraints();
		gbc_registroNombre.fill = GridBagConstraints.BOTH;
		gbc_registroNombre.insets = new Insets(0, 0, 5, 5);
		gbc_registroNombre.gridwidth = 3;
		gbc_registroNombre.gridx = 2;
		gbc_registroNombre.gridy = 1;
		add(registroNombre, gbc_registroNombre);
		registroNombre.setColumns(10);

		lblApellidos = new JLabel("Apellidos");
		lblApellidos.setFont(new Font("Tahoma", Font.BOLD, 12));
		GridBagConstraints gbc_lblApellidos = new GridBagConstraints();
		gbc_lblApellidos.anchor = GridBagConstraints.WEST;
		gbc_lblApellidos.fill = GridBagConstraints.VERTICAL;
		gbc_lblApellidos.insets = new Insets(0, 0, 5, 5);
		gbc_lblApellidos.gridwidth = 3;
		gbc_lblApellidos.gridx = 6;
		gbc_lblApellidos.gridy = 1;
		add(lblApellidos, gbc_lblApellidos);

		registroApellidos = new JTextField();
		registroApellidos.setColumns(10);
		GridBagConstraints gbc_registroApellidos = new GridBagConstraints();
		gbc_registroApellidos.fill = GridBagConstraints.BOTH;
		gbc_registroApellidos.insets = new Insets(0, 0, 5, 5);
		gbc_registroApellidos.gridx = 8;
		gbc_registroApellidos.gridy = 1;
		add(registroApellidos, gbc_registroApellidos);

		lblContrasena = new JLabel("Contrase\u00F1a");
		lblContrasena.setFont(new Font("Tahoma", Font.BOLD, 12));

		GridBagConstraints gbc_lblContrasena = new GridBagConstraints();
		gbc_lblContrasena.fill = GridBagConstraints.BOTH;
		gbc_lblContrasena.insets = new Insets(0, 0, 5, 5);
		gbc_lblContrasena.gridx = 1;
		gbc_lblContrasena.gridy = 2;
		add(lblContrasena, gbc_lblContrasena);

		registroPassword = new JTextField();
		registroPassword.setColumns(10);
		GridBagConstraints gbc_registroPassword = new GridBagConstraints();
		gbc_registroPassword.fill = GridBagConstraints.BOTH;
		gbc_registroPassword.insets = new Insets(0, 0, 5, 5);
		gbc_registroPassword.gridwidth = 3;
		gbc_registroPassword.gridx = 2;
		gbc_registroPassword.gridy = 2;
		add(registroPassword, gbc_registroPassword);

		lblClub = new JLabel("Club");
		lblClub.setFont(new Font("Tahoma", Font.BOLD, 12));
		GridBagConstraints gbc_lblClub = new GridBagConstraints();
		gbc_lblClub.fill = GridBagConstraints.BOTH;
		gbc_lblClub.insets = new Insets(0, 0, 5, 5);
		gbc_lblClub.gridwidth = 2;
		gbc_lblClub.gridx = 6;
		gbc_lblClub.gridy = 2;
		add(lblClub, gbc_lblClub);

		registroClub = new JTextField();
		registroClub.setColumns(10);
		GridBagConstraints gbc_registroClub = new GridBagConstraints();
		gbc_registroClub.fill = GridBagConstraints.BOTH;
		gbc_registroClub.insets = new Insets(0, 0, 5, 5);
		gbc_registroClub.gridx = 8;
		gbc_registroClub.gridy = 2;
		add(registroClub, gbc_registroClub);

		lblTelefono = new JLabel("Telefono");
		lblTelefono.setFont(new Font("Tahoma", Font.BOLD, 12));
		GridBagConstraints gbc_lblTelefono = new GridBagConstraints();
		gbc_lblTelefono.fill = GridBagConstraints.BOTH;
		gbc_lblTelefono.insets = new Insets(0, 0, 5, 5);
		gbc_lblTelefono.gridx = 1;
		gbc_lblTelefono.gridy = 3;
		add(lblTelefono, gbc_lblTelefono);

		registroTelf = new JTextField();
		GridBagConstraints gbc_registroTelf = new GridBagConstraints();
		gbc_registroTelf.fill = GridBagConstraints.BOTH;
		gbc_registroTelf.insets = new Insets(0, 0, 5, 5);
		gbc_registroTelf.gridwidth = 3;
		gbc_registroTelf.gridx = 2;
		gbc_registroTelf.gridy = 3;
		add(registroTelf, gbc_registroTelf);
		registroTelf.setColumns(10);

		// label for combobox
		JLabel lblTipoUsuario = new JLabel("Tipo usuario");
		GridBagConstraints gbc_lblTipoUsuario = new GridBagConstraints();
		gbc_lblTipoUsuario.anchor = GridBagConstraints.WEST;
		gbc_lblTipoUsuario.insets = new Insets(0, 0, 5, 5);
		gbc_lblTipoUsuario.gridx = 6;
		gbc_lblTipoUsuario.gridy = 3;
		add(lblTipoUsuario, gbc_lblTipoUsuario);
		lblTipoUsuario.setFont(new Font("Tahoma", Font.BOLD, 12));

		// combobox with user types
		comboTipoUsuario = new JComboBox<String>();

		// populate combobox with constant string array
		comboTipoUsuario.setModel(new DefaultComboBoxModel<String>(USERTYPES));
		GridBagConstraints gbc_comboTipoUsuario = new GridBagConstraints();
		gbc_comboTipoUsuario.fill = GridBagConstraints.BOTH;
		gbc_comboTipoUsuario.insets = new Insets(0, 0, 5, 5);
		gbc_comboTipoUsuario.gridwidth = 2;
		gbc_comboTipoUsuario.gridx = 7;
		gbc_comboTipoUsuario.gridy = 3;
		add(comboTipoUsuario, gbc_comboTipoUsuario);

		lblDireccion = new JLabel("Direccion");
		lblDireccion.setFont(new Font("Tahoma", Font.BOLD, 12));
		GridBagConstraints gbc_lblDireccion = new GridBagConstraints();
		gbc_lblDireccion.fill = GridBagConstraints.BOTH;
		gbc_lblDireccion.insets = new Insets(0, 0, 5, 5);
		gbc_lblDireccion.gridwidth = 2;
		gbc_lblDireccion.gridx = 1;
		gbc_lblDireccion.gridy = 4;
		add(lblDireccion, gbc_lblDireccion);

		registroDireccion = new JTextField();
		registroDireccion.setColumns(10);
		GridBagConstraints gbc_registroDireccion = new GridBagConstraints();
		gbc_registroDireccion.fill = GridBagConstraints.HORIZONTAL;
		gbc_registroDireccion.insets = new Insets(0, 0, 5, 5);
		gbc_registroDireccion.gridwidth = 3;
		gbc_registroDireccion.gridx = 2;
		gbc_registroDireccion.gridy = 4;
		add(registroDireccion, gbc_registroDireccion);

		lblEmail = new JLabel("Email");
		lblEmail.setFont(new Font("Tahoma", Font.BOLD, 12));
		GridBagConstraints gbc_lblEmail = new GridBagConstraints();
		gbc_lblEmail.fill = GridBagConstraints.BOTH;
		gbc_lblEmail.insets = new Insets(0, 0, 5, 5);
		gbc_lblEmail.gridwidth = 2;
		gbc_lblEmail.gridx = 6;
		gbc_lblEmail.gridy = 4;
		add(lblEmail, gbc_lblEmail);

		registroEmail = new JTextField();
		registroEmail.setColumns(10);
		GridBagConstraints gbc_registroEmail = new GridBagConstraints();
		gbc_registroEmail.fill = GridBagConstraints.HORIZONTAL;
		gbc_registroEmail.insets = new Insets(0, 0, 5, 5);
		gbc_registroEmail.gridx = 8;
		gbc_registroEmail.gridy = 4;
		add(registroEmail, gbc_registroEmail);

		okBtn = new JButton("Registrarse");
		okBtn.setFont(new Font("Tahoma", Font.BOLD, 11));
		okBtn.setActionCommand("");
		GridBagConstraints gbc_okBtn = new GridBagConstraints();
		gbc_okBtn.anchor = GridBagConstraints.SOUTH;
		gbc_okBtn.fill = GridBagConstraints.HORIZONTAL;
		gbc_okBtn.insets = new Insets(0, 0, 5, 5);
		gbc_okBtn.gridwidth = 2;
		gbc_okBtn.gridx = 1;
		gbc_okBtn.gridy = 6;
		add(okBtn, gbc_okBtn);

		cancelBtn = new JButton("Cancel");
		GridBagConstraints gbc_cancelBtn = new GridBagConstraints();
		gbc_cancelBtn.anchor = GridBagConstraints.SOUTH;
		gbc_cancelBtn.fill = GridBagConstraints.HORIZONTAL;
		gbc_cancelBtn.insets = new Insets(0, 0, 5, 5);
		gbc_cancelBtn.gridx = 4;
		gbc_cancelBtn.gridy = 6;
		add(cancelBtn, gbc_cancelBtn);

		cancelBtn.setFont(new Font("Tahoma", Font.BOLD, 11));
		cancelBtn.setActionCommand("Cancel");

		JButton btnLimpiar = new JButton("Limpiar");
		GridBagConstraints gbc_btnLimpiar = new GridBagConstraints();
		gbc_btnLimpiar.insets = new Insets(0, 0, 5, 5);
		gbc_btnLimpiar.anchor = GridBagConstraints.NORTHWEST;
		gbc_btnLimpiar.gridx = 8;
		gbc_btnLimpiar.gridy = 6;
		add(btnLimpiar, gbc_btnLimpiar);
		btnLimpiar.setFont(new Font("Tahoma", Font.BOLD, 11));

		btnLimpiar.addActionListener(new ActionListener() {
			JTextField[] arrJ = { registroNombre, registroApellidos, registroClub, registroDireccion, registroEmail,
					registroPassword, registroTelf };

			public void actionPerformed(ActionEvent arg0) {
				for (JTextField j : arrJ) {
					util.resetJTextField(j);
				}
			}
		});
	}

}

// }
