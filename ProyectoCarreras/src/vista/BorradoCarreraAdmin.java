package vista;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;

import bbdd.ManagerBd;
import clases.Carrera;
import utilidades.Utilidades;

public class BorradoCarreraAdmin extends JFrame {

	private static final long serialVersionUID = 1L;
	// TODO change null
	private ManagerBd mySql = new ManagerBd();
	private Utilidades util = new Utilidades();

	/**
	 * Create the frame.
	 */
	public BorradoCarreraAdmin() {

		setTitle("Borrado Carreras (Como admin)");
		setBounds(100, 100, 433, 229);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);

		JComboBox<Object> comboBox = new JComboBox<>();
		comboBox.setBounds(191, 45, 180, 20);
		getContentPane().add(comboBox);

		JLabel lblCarreraABorrar = new JLabel("Carrera a borrar:");
		lblCarreraABorrar.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblCarreraABorrar.setBounds(71, 48, 110, 14);
		getContentPane().add(lblCarreraABorrar);

		JButton btnBorrar = new JButton("Borrar");

		btnBorrar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnBorrar.setBounds(151, 108, 89, 23);
		getContentPane().add(btnBorrar);

		// action listeners
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent arg0) {
				ArrayList<Carrera> arr = new ArrayList<>();

				try {
					arr = mySql.consultarCarreras();

					for (Carrera c : arr) {
						comboBox.addItem(c.getNbCarrera());
					}
				} catch (Exception e) {
					util.createErrorbox("Error al recoger datos de la base de datos", "Error conexion base de datos");
				}

			}
		});

		btnBorrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Carrera c = new Carrera(comboBox.getSelectedItem().toString(), null, 0, 0, 0, "", "");
					int filas = mySql.deleteCarrera(c);

					util.createInfobox("Se han borrado " + filas + " filas de la base de datos.", "Borrado completado");
					comboBox.removeItem(c.getNbCarrera());

				} catch (Exception ex) {
					util.createErrorbox("No se ha podido borrar la carrera", "Borrado no completado");
				}
			}
		});
	}
}
