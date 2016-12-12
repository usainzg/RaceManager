package vista.paneles;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class LoginPanel extends JPanel {

	private static final long serialVersionUID = 1L;

	private JTextField txtEmail;
	private JButton btnAcceder, btnRegistrarse;
	private JLabel lblTipoUsuario;
	private JComboBox<String> comboTipoUsuario;
	private JPasswordField txtPassword;

	private final String[] USERTYPES = { "Normal", "Admin", "Organizador" };

	public LoginPanel() {
		setMinimumSize(new Dimension(800, 600));
		setMaximumSize(new Dimension(800, 600));
		setLayoutView();
	}

	private void setLayoutView() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 24, 17, 0, 0, 30, 30 };
		gridBagLayout.rowHeights = new int[] { 36, 56, 0, 0, 0, 30, 0, 82, 0, 42 };
		gridBagLayout.columnWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0 };
		gridBagLayout.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0 };
		setLayout(gridBagLayout);

		JLabel lblNewLabel = new JLabel("Bienvenido al sistema");
		lblNewLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 23));
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.anchor = GridBagConstraints.NORTHWEST;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 2;
		gbc_lblNewLabel.gridy = 1;
		add(lblNewLabel, gbc_lblNewLabel);

		JLabel lblEntrar = new JLabel("Iniciar sesion: ");
		lblEntrar.setVerticalAlignment(SwingConstants.TOP);
		lblEntrar.setHorizontalAlignment(SwingConstants.CENTER);
		lblEntrar.setFont(new Font("Tahoma", Font.BOLD, 14));
		GridBagConstraints gbc_lblEntrar = new GridBagConstraints();
		gbc_lblEntrar.anchor = GridBagConstraints.WEST;
		gbc_lblEntrar.insets = new Insets(0, 0, 5, 5);
		gbc_lblEntrar.gridx = 1;
		gbc_lblEntrar.gridy = 2;
		add(lblEntrar, gbc_lblEntrar);

		JLabel lblNewLabel_1 = new JLabel("Email");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 1;
		gbc_lblNewLabel_1.gridy = 3;
		add(lblNewLabel_1, gbc_lblNewLabel_1);

		txtEmail = new JTextField();
		GridBagConstraints gbc_txtEmail = new GridBagConstraints();
		gbc_txtEmail.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtEmail.anchor = GridBagConstraints.WEST;
		gbc_txtEmail.insets = new Insets(0, 0, 5, 5);
		gbc_txtEmail.gridx = 2;
		gbc_txtEmail.gridy = 3;
		add(txtEmail, gbc_txtEmail);
		txtEmail.setColumns(10);

		JLabel lblContrasea = new JLabel("Contrase\u00F1a");
		lblContrasea.setFont(new Font("Tahoma", Font.PLAIN, 13));
		GridBagConstraints gbc_lblContrasea = new GridBagConstraints();
		gbc_lblContrasea.insets = new Insets(0, 0, 5, 5);
		gbc_lblContrasea.gridx = 1;
		gbc_lblContrasea.gridy = 4;
		add(lblContrasea, gbc_lblContrasea);

		txtPassword = new JPasswordField();
		GridBagConstraints gbc_txtPassword = new GridBagConstraints();
		gbc_txtPassword.anchor = GridBagConstraints.WEST;
		gbc_txtPassword.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtPassword.insets = new Insets(0, 0, 5, 5);
		gbc_txtPassword.gridx = 2;
		gbc_txtPassword.gridy = 4;
		add(txtPassword, gbc_txtPassword);

		lblTipoUsuario = new JLabel("Tipo Usuario");
		lblTipoUsuario.setFont(new Font("Tahoma", Font.PLAIN, 13));
		GridBagConstraints gbc_lblTipoUsuario = new GridBagConstraints();
		gbc_lblTipoUsuario.insets = new Insets(0, 0, 5, 5);
		gbc_lblTipoUsuario.gridx = 1;
		gbc_lblTipoUsuario.gridy = 5;
		add(lblTipoUsuario, gbc_lblTipoUsuario);

		comboTipoUsuario = new JComboBox<String>();
		comboTipoUsuario.setModel(new DefaultComboBoxModel<String>(USERTYPES));
		GridBagConstraints gbc_comboTipoUsuario = new GridBagConstraints();
		gbc_comboTipoUsuario.anchor = GridBagConstraints.WEST;
		gbc_comboTipoUsuario.insets = new Insets(0, 0, 5, 5);
		gbc_comboTipoUsuario.gridx = 2;
		gbc_comboTipoUsuario.gridy = 5;
		add(comboTipoUsuario, gbc_comboTipoUsuario);

		btnAcceder = new JButton("Acceder");

		btnAcceder.setFont(new Font("Tahoma", Font.BOLD, 13));
		GridBagConstraints gbc_btnAcceder = new GridBagConstraints();
		gbc_btnAcceder.insets = new Insets(0, 0, 5, 5);
		gbc_btnAcceder.gridwidth = 3;
		gbc_btnAcceder.gridx = 2;
		gbc_btnAcceder.gridy = 6;
		add(btnAcceder, gbc_btnAcceder);

		JLabel lblEnCasoDe = new JLabel("En caso de no estar registrado y que desee hacerlo: ");
		lblEnCasoDe.setHorizontalAlignment(SwingConstants.LEFT);
		lblEnCasoDe.setFont(new Font("Tahoma", Font.BOLD, 13));
		GridBagConstraints gbc_lblEnCasoDe = new GridBagConstraints();
		gbc_lblEnCasoDe.insets = new Insets(0, 0, 5, 5);
		gbc_lblEnCasoDe.gridx = 2;
		gbc_lblEnCasoDe.gridy = 7;
		add(lblEnCasoDe, gbc_lblEnCasoDe);

		btnRegistrarse = new JButton("Registrarse");

		btnRegistrarse.setFont(new Font("Tahoma", Font.BOLD, 11));
		GridBagConstraints gbc_btnRegistrarse = new GridBagConstraints();
		gbc_btnRegistrarse.insets = new Insets(0, 0, 5, 5);
		gbc_btnRegistrarse.gridx = 3;
		gbc_btnRegistrarse.gridy = 7;
		add(btnRegistrarse, gbc_btnRegistrarse);

	}

	public JTextField getTxtEmail() {
		return txtEmail;
	}

	public void setTxtEmail(JTextField txtEmail) {
		this.txtEmail = txtEmail;
	}

	public JButton getBtnAcceder() {
		return btnAcceder;
	}

	public void setBtnAcceder(JButton btnAcceder) {
		this.btnAcceder = btnAcceder;
	}

	public JButton getBtnRegistrarse() {
		return btnRegistrarse;
	}

	public void setBtnRegistrarse(JButton btnRegistrarse) {
		this.btnRegistrarse = btnRegistrarse;
	}

	public JPasswordField getTxtPassword() {
		return txtPassword;
	}

	public void setTxtPassword(JPasswordField txtPassword) {
		this.txtPassword = txtPassword;
	}

	public JComboBox<String> getComboTipoUsuario() {
		return comboTipoUsuario;
	}

	public void setComboTipoUsuario(JComboBox<String> comboTipoUsuario) {
		this.comboTipoUsuario = comboTipoUsuario;
	}

}
