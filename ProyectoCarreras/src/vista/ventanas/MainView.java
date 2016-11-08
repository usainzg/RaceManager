package vista.ventanas;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import bbdd.ManagerBd;
import login.Login;

public class MainView extends JFrame {

	private static final long serialVersionUID = 1L;
	private Login loginSystem = null;

	public MainView() {
		
		String db = JOptionPane.showInputDialog("Introduce la base de datos que desees usar: (mysql o hibernate)");
		ManagerBd ma = new ManagerBd();
		ma.setDb(db);
		loginSystem = new Login(ma);
		
		
		setBounds(500, 300, 667, 473);
		setTitle("Proyecto Unai");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);

		

		// action listeners
		 /*btnRegistrarse.addActionListener(new ActionListener() {
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
		});*/
		// end action listeners
	}
}
