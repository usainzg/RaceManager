package vista.paneles.admin;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

public class DeleteCarreraAdminPanel extends JPanel {
	
	private JComboBox<Object> comboCarreraBorrar;
	private JButton btnBorrar;
	
	

	public JComboBox<Object> getComboCarreraBorrar() {
		return comboCarreraBorrar;
	}

	public JButton getBtnBorrar() {
		return btnBorrar;
	}

	private static final long serialVersionUID = 1L;

	public DeleteCarreraAdminPanel() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 101, 91, 108, 101, 0 };
		gridBagLayout.rowHeights = new int[] { 60, 47, 0, 60, 0 };
		gridBagLayout.columnWeights = new double[] { 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		setLayout(gridBagLayout);

		JLabel lblCarreraABorrar = new JLabel("Carrera a borrar:");
		lblCarreraABorrar.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblCarreraABorrar.setBounds(71, 48, 110, 14);
		GridBagConstraints gbc_lblCarreraABorrar = new GridBagConstraints();
		gbc_lblCarreraABorrar.anchor = GridBagConstraints.WEST;
		gbc_lblCarreraABorrar.insets = new Insets(0, 0, 5, 5);
		gbc_lblCarreraABorrar.gridx = 1;
		gbc_lblCarreraABorrar.gridy = 1;
		add(lblCarreraABorrar, gbc_lblCarreraABorrar);

		comboCarreraBorrar = new JComboBox<>();
		comboCarreraBorrar.setBounds(191, 45, 180, 20);
		GridBagConstraints gbc_comboCarreraBorrar = new GridBagConstraints();
		gbc_comboCarreraBorrar.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboCarreraBorrar.anchor = GridBagConstraints.WEST;
		gbc_comboCarreraBorrar.insets = new Insets(0, 0, 5, 5);
		gbc_comboCarreraBorrar.gridx = 2;
		gbc_comboCarreraBorrar.gridy = 1;
		add(comboCarreraBorrar, gbc_comboCarreraBorrar);

		btnBorrar = new JButton("Borrar");

		btnBorrar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnBorrar.setBounds(151, 108, 89, 23);
		GridBagConstraints gbc_btnBorrar = new GridBagConstraints();
		gbc_btnBorrar.insets = new Insets(0, 0, 5, 5);
		gbc_btnBorrar.anchor = GridBagConstraints.NORTHWEST;
		gbc_btnBorrar.gridx = 1;
		gbc_btnBorrar.gridy = 2;
		add(btnBorrar, gbc_btnBorrar);

		/*
		 * ArrayList<Carrera> arr = new ArrayList<>();
		 * 
		 * try { arr = mySql.consultarCarreras();
		 * 
		 * for (Carrera c : arr) { comboBox.addItem(c.getNbCarrera()); } } catch
		 * (Exception e) {
		 * util.createErrorbox("Error al recoger datos de la base de datos",
		 * "Error conexion base de datos"); }
		 */

		btnBorrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					// Carrera c = new
					// Carrera(comboBox.getSelectedItem().toString(), null, 0,
					// 0, 0, "", "");
					// int filas = mySql.deleteCarrera(c);

					// util.createInfobox("Se han borrado " + filas + " filas de
					// la base de datos.", "Borrado completado");
					// comboBox.removeItem(c.getNbCarrera());

				} catch (Exception ex) {
					// util.createErrorbox("No se ha podido borrar la carrera",
					// "Borrado no completado");
				}
			}
		});
	}

}

// }
