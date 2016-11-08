package vista.paneles;

import java.awt.Font;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import login.Login;

public class LoginPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField txtEmail;
	private final String[] USERTYPES = { "Normal", "Admin", "Organizador" };
	private JPasswordField txtPassword;
	
	/**
	 * Create the panel.
	 */
	public LoginPanel() {
		setLayout();
	}
	
	private void setLayout(){
		
		JLabel lblNewLabel = new JLabel("Bienvenido al sistema");
		lblNewLabel.setBounds(185, 26, 255, 38);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 23));
		add(lblNewLabel);

		JLabel lblEntrar = new JLabel("Iniciar sesion: ");
		lblEntrar.setBounds(93, 101, 125, 20);
		lblEntrar.setFont(new Font("Tahoma", Font.BOLD, 14));
		add(lblEntrar);

		JLabel label = new JLabel("");
		label.setBounds(66, 117, 46, 14);
		add(label);

		txtEmail = new JTextField();
		txtEmail.setBounds(135, 140, 149, 20);
		add(txtEmail);
		txtEmail.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("Email");
		lblNewLabel_1.setBounds(93, 142, 46, 14);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		add(lblNewLabel_1);

		JLabel lblContrasea = new JLabel("Contrase\u00F1a");
		lblContrasea.setBounds(326, 142, 67, 14);
		lblContrasea.setFont(new Font("Tahoma", Font.PLAIN, 13));
		add(lblContrasea);

		JButton btnAcceder = new JButton("Acceder");
		btnAcceder.setBounds(361, 187, 89, 23);

		btnAcceder.setFont(new Font("Tahoma", Font.BOLD, 13));
		add(btnAcceder);

		JLabel lblEnCasoDe = new JLabel("En caso de no estar registrado y que desee hacerlo: ");
		lblEnCasoDe.setBounds(149, 262, 369, 20);
		lblEnCasoDe.setFont(new Font("Tahoma", Font.BOLD, 14));
		add(lblEnCasoDe);

		JButton btnRegistrarse = new JButton("Registrarse");
		btnRegistrarse.setBounds(262, 312, 111, 23);

		btnRegistrarse.setFont(new Font("Tahoma", Font.BOLD, 11));
		add(btnRegistrarse);

		JComboBox<String> comboTipoUsuario = new JComboBox<String>();
		comboTipoUsuario.setBounds(176, 189, 91, 20);
		comboTipoUsuario.setModel(new DefaultComboBoxModel<String>(USERTYPES));
		add(comboTipoUsuario);

		JLabel lblTipoUsuario = new JLabel("Tipo Usuario");
		lblTipoUsuario.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblTipoUsuario.setBounds(93, 191, 81, 14);
		add(lblTipoUsuario);
		
		txtPassword = new JPasswordField();
		txtPassword.setBounds(403, 140, 149, 20);
		add(txtPassword);
	}

}
