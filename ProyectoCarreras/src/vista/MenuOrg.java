package vista;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class MenuOrg extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public MenuOrg() {
		setTitle("MENU ORGANIZADOR");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 440, 195);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblMenuOrganizador = new JLabel("MENU ORGANIZADOR");
		lblMenuOrganizador.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblMenuOrganizador.setBounds(131, 11, 193, 34);
		contentPane.add(lblMenuOrganizador);

		JButton btnVisualizarCarreras = new JButton("Visualizar Carreras");

		btnVisualizarCarreras.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnVisualizarCarreras.setBounds(40, 76, 166, 23);
		contentPane.add(btnVisualizarCarreras);

		JButton btnModificarCarrerasPropias = new JButton("Modificar tus Carreras");
		btnModificarCarrerasPropias.setFont(new Font("Tahoma", Font.BOLD, 11));

		btnModificarCarrerasPropias.setBounds(216, 76, 177, 23);
		contentPane.add(btnModificarCarrerasPropias);

		// action listeners
		btnModificarCarrerasPropias.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ModificacionCarreraOrg org = new ModificacionCarreraOrg();
				org.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				org.setVisible(true);
			}
		});

		btnVisualizarCarreras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VisualizacionCarrerasWindow carrerasView = new VisualizacionCarrerasWindow();
				carrerasView.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				carrerasView.setVisible(true);
			}
		});
	}

}
