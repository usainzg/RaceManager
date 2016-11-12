package vista.ventanas;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import bbdd.ManagerBd;
import login.Login;
import vista.paneles.LoginPanel;
import vista.paneles.RegistroPanel;

public class MainView extends JFrame {

	private static final long serialVersionUID = 1L;
	
	
	private Login loginSystem = null;
	private ManagerBd ma;
	
	private LoginPanel panelLogin = new LoginPanel();
	private RegistroPanel panelRegistro = new RegistroPanel();
	
	private JButton btnAccederLogin, btnRegistrarseLogin;
	private JComboBox<String> comboTipoUsuarioLogin;
	private JTextField txtEmail, txtPassword;
	

	public MainView() {
		setResizable(false);
		
		// TODO si mete uno erroneo
		getContentPane().setLayout(new BorderLayout());
		
		String db = JOptionPane.showInputDialog("Introduce la base de datos que desees usar: (mysql o hibernate)");

		ma = new ManagerBd();
		ma.setDb(db);
		
		loginSystem = new Login(ma);
		
		
		setBounds(500, 300, 523, 403);
		setTitle("Proyecto Unai");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		getContentPane().add(panelLogin, BorderLayout.CENTER);
		pack();
		
		btnAccederLogin = panelLogin.getBtnAcceder();
		btnRegistrarseLogin = panelLogin.getBtnRegistrarse();
		comboTipoUsuarioLogin = panelLogin.getComboTipoUsuario();
		txtEmail = panelLogin.getTxtEmail();
		txtPassword = panelLogin.getTxtPassword();
		
		
		
		btnAccederLogin.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try{
					loginSystem.validacionLogin(comboTipoUsuarioLogin, txtEmail, txtPassword);
				}catch(Exception ex){
					
				}
			}
		});
		
		btnRegistrarseLogin.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				getContentPane().removeAll();
				getContentPane().repaint();
				getContentPane().revalidate();
				
				getContentPane().add(panelRegistro);
				pack();
				getContentPane().repaint();
				getContentPane().revalidate();
				
			}
		});
	}
}
