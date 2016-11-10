package vista;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class GestionCarrerasAdmin extends JFrame {

	private static final long serialVersionUID = 1L;

	/**
	 * Create the frame.
	 */
	public GestionCarrerasAdmin() {
		setTitle("Gestion Carreras (como Admin)");
		setBounds(100, 100, 395, 196);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);

		JLabel lblGestionCarreras = new JLabel("Gestion Carreras");
		lblGestionCarreras.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblGestionCarreras.setBounds(136, 11, 169, 16);
		getContentPane().add(lblGestionCarreras);

		JButton btnBorrarCarrera = new JButton("Borrar Carrera");

		btnBorrarCarrera.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnBorrarCarrera.setBounds(207, 82, 146, 23);
		getContentPane().add(btnBorrarCarrera);

		JButton btnModificarCarrera = new JButton("Modificar Carrera");

		btnModificarCarrera.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnModificarCarrera.setBounds(32, 82, 146, 23);
		getContentPane().add(btnModificarCarrera);

		/*btnModificarCarrera.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ModificacionCarreraAdmin mod = new ModificacionCarreraAdmin();
				mod.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				mod.setVisible(true);
			}
		});

		btnBorrarCarrera.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BorradoCarreraAdmin borrado = new BorradoCarreraAdmin();
				borrado.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				borrado.setVisible(true);
			}
		});*/
	}
}
