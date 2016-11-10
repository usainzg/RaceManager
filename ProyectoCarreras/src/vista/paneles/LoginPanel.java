package vista.paneles;

import java.awt.Font;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class LoginPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	
	private JTextField txtEmail;
	private JButton btnAcceder, btnRegistrarse;
	private JLabel lblTipoUsuario;
	private JComboBox<String> comboTipoUsuario;
	private JPasswordField txtPassword;
	
	private final String[] USERTYPES = { "Normal", "Admin", "Organizador" };

	
	public LoginPanel() {
		setLayout();
	}
	
	private void setLayout(){
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Bienvenido al sistema");
		lblNewLabel.setBounds(100, 5, 255, 28);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 23));
		add(lblNewLabel);

		JLabel lblEntrar = new JLabel("Iniciar sesion: ");
		lblEntrar.setBounds(169, 45, 102, 17);
		lblEntrar.setFont(new Font("Tahoma", Font.BOLD, 14));
		add(lblEntrar);

		JLabel label = new JLabel("");
		label.setBounds(408, 19, 0, 0);
		add(label);

		txtEmail = new JTextField();
		txtEmail.setBounds(64, 74, 130, 26);
		add(txtEmail);
		txtEmail.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("Email");
		lblNewLabel_1.setBounds(21, 79, 31, 16);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		add(lblNewLabel_1);

		JLabel lblContrasea = new JLabel("Contrase\u00F1a");
		lblContrasea.setBounds(217, 79, 65, 16);
		lblContrasea.setFont(new Font("Tahoma", Font.PLAIN, 13));
		add(lblContrasea);

		btnAcceder = new JButton("Acceder");
		btnAcceder.setBounds(278, 120, 97, 29);

		btnAcceder.setFont(new Font("Tahoma", Font.BOLD, 13));
		add(btnAcceder);

		JLabel lblEnCasoDe = new JLabel("En caso de no estar registrado y que desee hacerlo: ");
		lblEnCasoDe.setBounds(47, 201, 361, 17);
		lblEnCasoDe.setFont(new Font("Tahoma", Font.BOLD, 14));
		add(lblEnCasoDe);

		btnRegistrarse = new JButton("Registrarse");
		btnRegistrarse.setBounds(169, 241, 110, 29);

		btnRegistrarse.setFont(new Font("Tahoma", Font.BOLD, 11));
		add(btnRegistrarse);

		comboTipoUsuario = new JComboBox<String>();
		comboTipoUsuario.setBounds(100, 121, 133, 27);
		comboTipoUsuario.setModel(new DefaultComboBoxModel<String>(USERTYPES));
		add(comboTipoUsuario);

		lblTipoUsuario = new JLabel("Tipo Usuario");
		lblTipoUsuario.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblTipoUsuario.setBounds(21, 125, 73, 16);
		add(lblTipoUsuario);
		
		txtPassword = new JPasswordField();
		txtPassword.setBounds(294, 74, 133, 26);
		add(txtPassword);
		
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
