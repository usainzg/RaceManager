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
import java.awt.GridBagLayout;

public class MainView extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	
	private final String OPTION_MYSQL = "mysql";
	private final String OPTION_HIBERNATE = "hibernate";
	
	
	private Login loginSystem = null;
	private ManagerBd ma;
	
	private LoginPanel panelLogin = new LoginPanel();
	private RegistroPanel panelRegistro = new RegistroPanel();
	
	private JButton btnAccederLogin, btnRegistrarseLogin;
	private JComboBox<String> comboTipoUsuarioLogin;
	private JTextField txtEmail, txtPassword;
	
	private JButton btnCancelRegistro, btnOkRegistro;
	

	public MainView() {
		
		// mantener una referencia a los botones de los diferentes paneles
		// BOTONES PANEL REGISTRO
		btnCancelRegistro = panelRegistro.getCancelBtn();
		btnOkRegistro = panelRegistro.getOkBtn();
		
		
		// BOTONES PANEL LOGIN
		btnAccederLogin = panelLogin.getBtnAcceder();
		btnRegistrarseLogin = panelLogin.getBtnRegistrarse();
		comboTipoUsuarioLogin = panelLogin.getComboTipoUsuario();
		txtEmail = panelLogin.getTxtEmail();
		txtPassword = panelLogin.getTxtPassword();
		
		// no dejar hacer resize
		setResizable(false);
		
		
		getContentPane().setLayout(new BorderLayout());
		
		String db = "";
		while(true){
			
			db = JOptionPane.showInputDialog("Introduce la base de datos que desees usar: (mysql o hibernate)");
			// TODO si mete uno erroneo
			
			if(db.equalsIgnoreCase(OPTION_MYSQL) || db.equalsIgnoreCase(OPTION_HIBERNATE)) {
				ma = new ManagerBd();
				ma.setDb(db);
				break;
			}
			
		}
		
		
		loginSystem = new Login(ma);
		
		
		setBounds(500, 300, 523, 403);
		setTitle("Proyecto Unai");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GridBagLayout gridBagLayout = (GridBagLayout) panelLogin.getLayout();
		gridBagLayout.columnWidths = new int[]{43, 87, 328, 0, 38};
		
		getContentPane().add(panelLogin, BorderLayout.CENTER);
		pack();
		
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
		
		
		btnCancelRegistro.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				getContentPane().removeAll();
				getContentPane().repaint();
				getContentPane().revalidate();
				
				getContentPane().add(panelLogin);
				pack();
				getContentPane().repaint();
				getContentPane().revalidate();
			}
		});
		
		btnOkRegistro.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				// TODO validar datos e introducirlos en la bbdd
				
			}
		});
		
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}
