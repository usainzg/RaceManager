package vista;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class MenuAdmin extends JFrame {

	private static final long serialVersionUID = 1L;

	/**
	 * Create the frame.
	 */
	public MenuAdmin() {
		setTitle("MENU ADMIN");
		setBounds(100, 100, 379, 222);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);

		JLabel lblMenuAdministrador = new JLabel("MENU ADMINISTRADOR");
		lblMenuAdministrador.setHorizontalAlignment(SwingConstants.CENTER);
		lblMenuAdministrador.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblMenuAdministrador.setBounds(89, 11, 193, 34);
		getContentPane().add(lblMenuAdministrador);

		JButton btnVisualizarCarreras = new JButton("Visualizar Carreras");
		btnVisualizarCarreras.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnVisualizarCarreras.setBounds(10, 86, 166, 23);
		getContentPane().add(btnVisualizarCarreras);

		JButton btnGestionarUsuarios = new JButton("Gestionar Usuarios");
		btnGestionarUsuarios.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnGestionarUsuarios.setBounds(186, 86, 166, 23);
		getContentPane().add(btnGestionarUsuarios);

		JButton btnGestioncarreras = new JButton("GestionCarreras");

		btnGestioncarreras.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnGestioncarreras.setBounds(120, 131, 125, 23);
		getContentPane().add(btnGestioncarreras);

		// action listeners for buttons
		btnVisualizarCarreras.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				VisualizacionCarrerasWindow carrerasView = new VisualizacionCarrerasWindow();
				carrerasView.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				carrerasView.setVisible(true);

			}
		});

		btnGestionarUsuarios.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				GestionUsuarios ges = new GestionUsuarios();
				ges.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				ges.setVisible(true);
			}
		});

		btnGestioncarreras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				GestionCarrerasAdmin gesCarr = new GestionCarrerasAdmin();
				gesCarr.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				gesCarr.setVisible(true);

			}
		});

	}
}
