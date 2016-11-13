package vista.paneles.org;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

public class BorradoCarreraOrg extends JPanel {

	private static final long serialVersionUID = 1L;

	private JButton btnBorrar;
	private JComboBox<Object> comboCarreraBorrarOrg;

	public JButton getBtnBorrar() {
		return btnBorrar;
	}

	public JComboBox<Object> getComboCarreraBorrarOrg() {
		return comboCarreraBorrarOrg;
	}

	public BorradoCarreraOrg() {
		setLayoutView();
	}
	

	private void setLayoutView() {
		setBounds(100, 100, 408, 224);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 93, 98, 94, 94, 0 };
		gridBagLayout.rowHeights = new int[] { 72, 0, 0, 78, 0 };
		gridBagLayout.columnWeights = new double[] { 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		setLayout(gridBagLayout);

		JLabel lblCarreraABorrar = new JLabel("Carrera a borrar: ");
		lblCarreraABorrar.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblCarreraABorrar.setBounds(47, 50, 118, 14);
		GridBagConstraints gbc_lblCarreraABorrar = new GridBagConstraints();
		gbc_lblCarreraABorrar.anchor = GridBagConstraints.WEST;
		gbc_lblCarreraABorrar.insets = new Insets(0, 0, 5, 5);
		gbc_lblCarreraABorrar.gridx = 1;
		gbc_lblCarreraABorrar.gridy = 1;
		add(lblCarreraABorrar, gbc_lblCarreraABorrar);

		comboCarreraBorrarOrg = new JComboBox<>();
		comboCarreraBorrarOrg.setBounds(176, 47, 173, 20);
		GridBagConstraints gbc_comboCarreraBorrarOrg = new GridBagConstraints();
		gbc_comboCarreraBorrarOrg.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboCarreraBorrarOrg.insets = new Insets(0, 0, 5, 5);
		gbc_comboCarreraBorrarOrg.anchor = GridBagConstraints.WEST;
		gbc_comboCarreraBorrarOrg.gridx = 2;
		gbc_comboCarreraBorrarOrg.gridy = 1;
		add(comboCarreraBorrarOrg, gbc_comboCarreraBorrarOrg);

		btnBorrar = new JButton("Borrar");
		btnBorrar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnBorrar.setBounds(137, 110, 89, 23);
		GridBagConstraints gbc_btnBorrar = new GridBagConstraints();
		gbc_btnBorrar.anchor = GridBagConstraints.NORTHWEST;
		gbc_btnBorrar.insets = new Insets(0, 0, 5, 5);
		gbc_btnBorrar.gridx = 1;
		gbc_btnBorrar.gridy = 2;
		add(btnBorrar, gbc_btnBorrar);
	}

}
