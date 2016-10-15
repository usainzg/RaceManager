package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JButton;
import javax.swing.JDialog;

import java.awt.Font;
import javax.swing.JMenu;

import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MainWindow extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField textField;
	private JTextField textField_1;

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
		
		textField = new JTextField();
		textField.setBounds(129, 89, 86, 20);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Email");
		lblNewLabel_1.setBounds(73, 92, 46, 14);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		getContentPane().add(lblNewLabel_1);
		
		textField_1 = new JTextField();
		textField_1.setBounds(322, 89, 86, 20);
		getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblContrasea = new JLabel("Contrase\u00F1a");
		lblContrasea.setBounds(245, 92, 67, 14);
		lblContrasea.setFont(new Font("Tahoma", Font.BOLD, 11));
		getContentPane().add(lblContrasea);
		
		JButton btnAcceder = new JButton("Acceder");
		btnAcceder.setBounds(192, 134, 89, 23);
		
		
		btnAcceder.setFont(new Font("Tahoma", Font.BOLD, 11));
		getContentPane().add(btnAcceder);
		
		JLabel lblEnCasoDe = new JLabel("En caso de no estar registrado y que desee hacerlo: ");
		lblEnCasoDe.setBounds(46, 216, 302, 14);
		lblEnCasoDe.setFont(new Font("Tahoma", Font.BOLD, 11));
		getContentPane().add(lblEnCasoDe);
		
		JButton btnRegistrarse = new JButton("Registrarse");
		btnRegistrarse.setBounds(46, 248, 111, 23);
		
		
		btnRegistrarse.setFont(new Font("Tahoma", Font.BOLD, 11));
		getContentPane().add(btnRegistrarse);
		
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
				
			}
		});
		// end action listeners
	}
	
}
