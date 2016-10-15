package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;

import login.Login;
import utilidades.Utilidades;

import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JDialog;

import java.awt.Font;
import javax.swing.JMenu;

import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;

public class MainWindow extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField txtEmail;
	private JTextField txtPassword;
	private final String[] USERTYPES = {"Normal", "Admin", "Organizador"};
	private final Utilidades util = new Utilidades();
	private Login loginSystem = new Login();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainWindow window = new MainWindow();
					window.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MainWindow() {
		setBounds(500, 300, 500, 358);
		setTitle("Proyecto Unai");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Bienvenido al sistema");
		lblNewLabel.setBounds(129, 11, 219, 38);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 19));
		getContentPane().add(lblNewLabel);
		
		JLabel lblEntrar = new JLabel("Entrar");
		lblEntrar.setBounds(211, 49, 46, 20);
		lblEntrar.setFont(new Font("Tahoma", Font.BOLD, 13));
		getContentPane().add(lblEntrar);
		
		JLabel label = new JLabel("");
		label.setBounds(46, 67, 46, 14);
		getContentPane().add(label);
		
		txtEmail = new JTextField();
		txtEmail.setBounds(129, 89, 86, 20);
		getContentPane().add(txtEmail);
		txtEmail.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Email");
		lblNewLabel_1.setBounds(73, 92, 46, 14);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		getContentPane().add(lblNewLabel_1);
		
		txtPassword = new JTextField();
		txtPassword.setBounds(322, 89, 86, 20);
		getContentPane().add(txtPassword);
		txtPassword.setColumns(10);
		
		JLabel lblContrasea = new JLabel("Contrase\u00F1a");
		lblContrasea.setBounds(245, 92, 67, 14);
		lblContrasea.setFont(new Font("Tahoma", Font.BOLD, 11));
		getContentPane().add(lblContrasea);
		
		JButton btnAcceder = new JButton("Acceder");
		btnAcceder.setBounds(191, 165, 89, 23);
		
		
		btnAcceder.setFont(new Font("Tahoma", Font.BOLD, 11));
		getContentPane().add(btnAcceder);
		
		JLabel lblEnCasoDe = new JLabel("En caso de no estar registrado y que desee hacerlo: ");
		lblEnCasoDe.setBounds(95, 217, 302, 14);
		lblEnCasoDe.setFont(new Font("Tahoma", Font.BOLD, 11));
		getContentPane().add(lblEnCasoDe);
		
		JButton btnRegistrarse = new JButton("Registrarse");
		btnRegistrarse.setBounds(180, 249, 111, 23);
		
		
		btnRegistrarse.setFont(new Font("Tahoma", Font.BOLD, 11));
		getContentPane().add(btnRegistrarse);
		
		JComboBox<String> comboTipoUsuario = new JComboBox<String>();
		comboTipoUsuario.setBounds(245, 120, 91, 20);
		comboTipoUsuario.setModel(new DefaultComboBoxModel<String>(USERTYPES));
		getContentPane().add(comboTipoUsuario);
		
		JLabel lblTipoUsuario = new JLabel("Tipo Usuario");
		lblTipoUsuario.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblTipoUsuario.setBounds(152, 123, 81, 14);
		getContentPane().add(lblTipoUsuario);
		
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
				RegistroView registro = new RegistroView();
				registro.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
				registro.setVisible(true);
			}
		});
		
		btnAcceder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					validacionLogin(comboTipoUsuario);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				
			}
		});
		// end action listeners
	}
	
	public void validacionLogin(JComboBox<String> comboTipoUsuario) throws Exception{
		if(!txtEmail.getText().equals("") && !txtPassword.getText().equals("")){
			
			// validate email
			if(!util.validarEmail(txtEmail.getText())){
				util.createErrorbox("Introduce una direccion de email valida.", "Formato email erroneo.");
				txtEmail.setText("");
				txtPassword.setText("");
				
				// validate password
			}else if(!util.validarPassword(txtPassword.getText())){
				util.createErrorbox("La contraseña debe tener al menos 6 caracteres de longitud y algun letra mayuscula.", "Formato contraseña erroneo.");
				txtEmail.setText("");
				txtPassword.setText("");
			}else {
				
				// admin login
				if(comboTipoUsuario.getSelectedItem().toString() == "Admin"){
					loginSystem.loginAdmin(txtEmail, txtPassword);
					
					// usuario normal login
				}else if(comboTipoUsuario.getSelectedItem().toString() == "Normal"){
					loginSystem.loginNormal(txtEmail, txtPassword);
					
					
					// organizador login
				}else{
					loginSystem.loginOrganizador(txtEmail, txtPassword);
					
					
				}
			}
			
			// comprueba cuando hay campos vacios
		}else {
			util.createErrorbox("Te faltan campos por rellenar, por favor completa todos los campos.", "Faltan campos por rellenar.");
			txtEmail.requestFocus();
		}
		
	}
}
