package vista;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

import clases.Carrera;

public class DeleteCarreraAdminPanel extends JPanel {

	/**
	 * Create the panel.
	 */
	public DeleteCarreraAdminPanel() {
		
		JComboBox<Object> comboBox = new JComboBox<>();
		comboBox.setBounds(191, 45, 180, 20);
		add(comboBox);

		JLabel lblCarreraABorrar = new JLabel("Carrera a borrar:");
		lblCarreraABorrar.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblCarreraABorrar.setBounds(71, 48, 110, 14);
		add(lblCarreraABorrar);

		JButton btnBorrar = new JButton("Borrar");

		btnBorrar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnBorrar.setBounds(151, 108, 89, 23);
		add(btnBorrar);
		
		/*ArrayList<Carrera> arr = new ArrayList<>();

		try {
			arr = mySql.consultarCarreras();

			for (Carrera c : arr) {
				comboBox.addItem(c.getNbCarrera());
			}
		} catch (Exception e) {
			util.createErrorbox("Error al recoger datos de la base de datos", "Error conexion base de datos");
		}
		*/
		

		btnBorrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					// Carrera c = new Carrera(comboBox.getSelectedItem().toString(), null, 0, 0, 0, "", "");
					// int filas = mySql.deleteCarrera(c);

					// util.createInfobox("Se han borrado " + filas + " filas de la base de datos.", "Borrado completado");
					// comboBox.removeItem(c.getNbCarrera());

				} catch (Exception ex) {
					// util.createErrorbox("No se ha podido borrar la carrera", "Borrado no completado");
				}
			}
		});
	}

	}

// }
