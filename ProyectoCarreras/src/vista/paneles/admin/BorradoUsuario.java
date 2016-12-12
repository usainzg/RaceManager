package vista.paneles.admin;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class BorradoUsuario extends JPanel {

	private static final long serialVersionUID = 1L;

	private JComboBox<String> comboTipo;
	private JComboBox<Object> comboEmail;
	private JButton btnBorrar;

	public JComboBox<String> getComboTipo() {
		return comboTipo;
	}

	public JComboBox<Object> getComboEmail() {
		return comboEmail;
	}

	public JButton getBtnBorrar() {
		return btnBorrar;
	}

	public BorradoUsuario() {
		setMinimumSize(new Dimension(800, 600));
		setMaximumSize(new Dimension(800, 600));
		setLayoutView();
	}

	private void setLayoutView() {

		setBounds(100, 100, 434, 198);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 50, 98, 102, 72, 0 };
		gridBagLayout.rowHeights = new int[] { 38, 0, 0, 0, 0, 33, 39, 0 };
		gridBagLayout.columnWeights = new double[] { 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		setLayout(gridBagLayout);

		JLabel lblUsuarioABorrar = new JLabel("Usuario a borrar: ");
		lblUsuarioABorrar.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblUsuarioABorrar.setBounds(35, 82, 116, 14);
		GridBagConstraints gbc_lblUsuarioABorrar = new GridBagConstraints();
		gbc_lblUsuarioABorrar.anchor = GridBagConstraints.WEST;
		gbc_lblUsuarioABorrar.insets = new Insets(0, 0, 5, 5);
		gbc_lblUsuarioABorrar.gridx = 1;
		gbc_lblUsuarioABorrar.gridy = 1;
		add(lblUsuarioABorrar, gbc_lblUsuarioABorrar);

		comboEmail = new JComboBox<>();
		comboEmail.setBounds(161, 79, 195, 20);
		GridBagConstraints gbc_comboEmail = new GridBagConstraints();
		gbc_comboEmail.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboEmail.anchor = GridBagConstraints.WEST;
		gbc_comboEmail.insets = new Insets(0, 0, 5, 5);
		gbc_comboEmail.gridx = 2;
		gbc_comboEmail.gridy = 1;
		add(comboEmail, gbc_comboEmail);

		JLabel lblTipoUsuarioA = new JLabel("Tipo usuario a borrar: ");
		lblTipoUsuarioA.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblTipoUsuarioA.setBounds(35, 35, 143, 14);
		GridBagConstraints gbc_lblTipoUsuarioA = new GridBagConstraints();
		gbc_lblTipoUsuarioA.anchor = GridBagConstraints.WEST;
		gbc_lblTipoUsuarioA.insets = new Insets(0, 0, 5, 5);
		gbc_lblTipoUsuarioA.gridx = 1;
		gbc_lblTipoUsuarioA.gridy = 3;
		add(lblTipoUsuarioA, gbc_lblTipoUsuarioA);

		comboTipo = new JComboBox<>();
		comboTipo.setBounds(161, 32, 195, 20);
		comboTipo.addItem("Normal");
		comboTipo.addItem("Organizador");
		comboTipo.setSelectedItem("Normal");
		GridBagConstraints gbc_comboTipo = new GridBagConstraints();
		gbc_comboTipo.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboTipo.insets = new Insets(0, 0, 5, 5);
		gbc_comboTipo.anchor = GridBagConstraints.WEST;
		gbc_comboTipo.gridx = 2;
		gbc_comboTipo.gridy = 3;
		add(comboTipo, gbc_comboTipo);

		btnBorrar = new JButton("Borrar");

		btnBorrar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnBorrar.setBounds(155, 125, 89, 23);
		GridBagConstraints gbc_btnBorrar = new GridBagConstraints();
		gbc_btnBorrar.anchor = GridBagConstraints.NORTHWEST;
		gbc_btnBorrar.insets = new Insets(0, 0, 5, 5);
		gbc_btnBorrar.gridx = 2;
		gbc_btnBorrar.gridy = 5;
		add(btnBorrar, gbc_btnBorrar);
	}

}
