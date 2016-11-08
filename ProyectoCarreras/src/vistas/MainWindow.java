package vistas;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import bbdd.ManagerBd;
import login.Login;
import javax.swing.JPasswordField;

public class MainWindow extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField txtEmail;
	private final String[] USERTYPES = { "Normal", "Admin", "Organizador" };
	private Login loginSystem = null;
	private JPasswordField txtPassword;

	/**
	 * Create the application.
	 */
	public MainWindow() {
		
		String db = JOptionPane.showInputDialog("Introduce la base de datos que desees usar: (mysql o hibernate)");
		ManagerBd ma = new ManagerBd();
		ma.setDb(db);
		loginSystem = new Login(ma);
		
		
		setBounds(500, 300, 667, 473);
		setTitle("Proyecto Unai");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("Bienvenido al sistema");
		lblNewLabel.setBounds(185, 26, 255, 38);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 23));
		getContentPane().add(lblNewLabel);

		JLabel lblEntrar = new JLabel("Iniciar sesion: ");
		lblEntrar.setBounds(93, 101, 125, 20);
		lblEntrar.setFont(new Font("Tahoma", Font.BOLD, 14));
		getContentPane().add(lblEntrar);

		JLabel label = new JLabel("");
		label.setBounds(66, 117, 46, 14);
		getContentPane().add(label);

		txtEmail = new JTextField();
		txtEmail.setBounds(135, 140, 149, 20);
		getContentPane().add(txtEmail);
		txtEmail.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("Email");
		lblNewLabel_1.setBounds(93, 142, 46, 14);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		getContentPane().add(lblNewLabel_1);

		JLabel lblContrasea = new JLabel("Contrase\u00F1a");
		lblContrasea.setBounds(326, 142, 67, 14);
		lblContrasea.setFont(new Font("Tahoma", Font.PLAIN, 13));
		getContentPane().add(lblContrasea);

		JButton btnAcceder = new JButton("Acceder");
		btnAcceder.setBounds(361, 187, 89, 23);

		btnAcceder.setFont(new Font("Tahoma", Font.BOLD, 13));
		getContentPane().add(btnAcceder);

		JLabel lblEnCasoDe = new JLabel("En caso de no estar registrado y que desee hacerlo: ");
		lblEnCasoDe.setBounds(149, 262, 369, 20);
		lblEnCasoDe.setFont(new Font("Tahoma", Font.BOLD, 14));
		getContentPane().add(lblEnCasoDe);

		JButton btnRegistrarse = new JButton("Registrarse");
		btnRegistrarse.setBounds(262, 312, 111, 23);

		btnRegistrarse.setFont(new Font("Tahoma", Font.BOLD, 11));
		getContentPane().add(btnRegistrarse);

		JComboBox<String> comboTipoUsuario = new JComboBox<String>();
		comboTipoUsuario.setBounds(176, 189, 91, 20);
		comboTipoUsuario.setModel(new DefaultComboBoxModel<String>(USERTYPES));
		getContentPane().add(comboTipoUsuario);

		JLabel lblTipoUsuario = new JLabel("Tipo Usuario");
		lblTipoUsuario.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblTipoUsuario.setBounds(93, 191, 81, 14);
		getContentPane().add(lblTipoUsuario);
		
		txtPassword = new JPasswordField();
		txtPassword.setBounds(403, 140, 149, 20);
		getContentPane().add(txtPassword);

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu mnSalir = new JMenu("Ayuda");
		mnSalir.setFont(new Font("Segoe UI", Font.BOLD, 12));
		menuBar.add(mnSalir);

		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Contactar");
		mnSalir.add(mntmNewMenuItem_1);

		// action listeners
		btnRegistrarse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				RegistroWindow registro = new RegistroWindow(ma);
				registro.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
				registro.setVisible(true);
			}
		});

		btnAcceder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					loginSystem.validacionLogin(comboTipoUsuario, txtEmail, txtPassword);
				} catch (Exception e1) {
					e1.printStackTrace();
				}

			}
		});
		// end action listeners
	}
}
