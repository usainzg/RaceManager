package vista.paneles.admin;

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ModificacionUsuarioAdmin extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField txtNombre;
	private JTextField txtApellidos;
	private JTextField txtDir;
	private JTextField txtPass;
	private JTextField txtTelf;
	private JTextField txtClub;
	private JComboBox<String> comboTipoUsuarioModificar;
	private JComboBox<Object> comboEmailAModificar;
	private JButton btnModificar;

	public JTextField getTxtNombre() {
		return txtNombre;
	}

	public JTextField getTxtApellidos() {
		return txtApellidos;
	}

	public JTextField getTxtDir() {
		return txtDir;
	}

	public JTextField getTxtPass() {
		return txtPass;
	}

	public JTextField getTxtTelf() {
		return txtTelf;
	}

	public JTextField getTxtClub() {
		return txtClub;
	}

	public JComboBox<String> getComboTipoUsuarioModificar() {
		return comboTipoUsuarioModificar;
	}

	public JComboBox<Object> getComboEmailAModificar() {
		return comboEmailAModificar;
	}

	public JButton getBtnModificar() {
		return btnModificar;
	}

	/**
	 * Create the panel.
	 */
	public ModificacionUsuarioAdmin() {
		setLayoutView();
	}

	private void setLayoutView() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 57, 47, 18, 136, 10, 12, 11, 79, 43, 0 };
		gridBagLayout.rowHeights = new int[] { 34, 20, 20, 30, 23, 23, 0, 0, 0, 0, 0, 0, 0, 33, 0 };
		gridBagLayout.columnWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
				Double.MIN_VALUE };
		setLayout(gridBagLayout);

		JLabel lblTipoUsuarioA = new JLabel("Tipo usuario a modificar: ");
		lblTipoUsuarioA.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblTipoUsuarioA.setBounds(77, 50, 162, 14);
		GridBagConstraints gbc_lblTipoUsuarioA = new GridBagConstraints();
		gbc_lblTipoUsuarioA.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblTipoUsuarioA.anchor = GridBagConstraints.EAST;
		gbc_lblTipoUsuarioA.insets = new Insets(0, 0, 5, 5);
		gbc_lblTipoUsuarioA.gridx = 1;
		gbc_lblTipoUsuarioA.gridy = 1;
		add(lblTipoUsuarioA, gbc_lblTipoUsuarioA);

		comboTipoUsuarioModificar = new JComboBox<String>();
		comboTipoUsuarioModificar.setBounds(87, 77, 142, 20);
		comboTipoUsuarioModificar.addItem("Normal");
		comboTipoUsuarioModificar.addItem("Organizador");
		comboTipoUsuarioModificar.setSelectedItem("Normal");
		GridBagConstraints gbc_comboTipoUsuarioModificar = new GridBagConstraints();
		gbc_comboTipoUsuarioModificar.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboTipoUsuarioModificar.anchor = GridBagConstraints.NORTHWEST;
		gbc_comboTipoUsuarioModificar.insets = new Insets(0, 0, 5, 5);
		gbc_comboTipoUsuarioModificar.gridx = 3;
		gbc_comboTipoUsuarioModificar.gridy = 1;
		add(comboTipoUsuarioModificar, gbc_comboTipoUsuarioModificar);

		JLabel lblEmailUsuarioA = new JLabel("Email usuario a modificar: ");
		lblEmailUsuarioA.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblEmailUsuarioA.setBounds(300, 50, 177, 14);
		GridBagConstraints gbc_lblEmailUsuarioA = new GridBagConstraints();
		gbc_lblEmailUsuarioA.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblEmailUsuarioA.anchor = GridBagConstraints.EAST;
		gbc_lblEmailUsuarioA.insets = new Insets(0, 0, 5, 5);
		gbc_lblEmailUsuarioA.gridx = 5;
		gbc_lblEmailUsuarioA.gridy = 1;
		add(lblEmailUsuarioA, gbc_lblEmailUsuarioA);

		comboEmailAModificar = new JComboBox<>();
		comboEmailAModificar.setBounds(310, 77, 214, 20);
		GridBagConstraints gbc_comboEmailAModificar = new GridBagConstraints();
		gbc_comboEmailAModificar.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboEmailAModificar.anchor = GridBagConstraints.NORTHWEST;
		gbc_comboEmailAModificar.insets = new Insets(0, 0, 5, 5);
		gbc_comboEmailAModificar.gridx = 7;
		gbc_comboEmailAModificar.gridy = 1;
		add(comboEmailAModificar, gbc_comboEmailAModificar);

		JLabel lblNuevosDatos = new JLabel("Nuevos datos:");
		lblNuevosDatos.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNuevosDatos.setBounds(22, 123, 101, 14);
		GridBagConstraints gbc_lblNuevosDatos = new GridBagConstraints();
		gbc_lblNuevosDatos.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblNuevosDatos.anchor = GridBagConstraints.WEST;
		gbc_lblNuevosDatos.insets = new Insets(0, 0, 5, 5);
		gbc_lblNuevosDatos.gridx = 1;
		gbc_lblNuevosDatos.gridy = 3;
		add(lblNuevosDatos, gbc_lblNuevosDatos);

		JLabel lblNombre = new JLabel("Nombre: ");
		lblNombre.setBounds(32, 151, 61, 14);
		GridBagConstraints gbc_lblNombre = new GridBagConstraints();
		gbc_lblNombre.insets = new Insets(0, 0, 5, 5);
		gbc_lblNombre.gridx = 1;
		gbc_lblNombre.gridy = 4;
		add(lblNombre, gbc_lblNombre);

		txtNombre = new JTextField();
		txtNombre.setBounds(128, 148, 142, 20);
		GridBagConstraints gbc_txtNombre = new GridBagConstraints();
		gbc_txtNombre.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtNombre.insets = new Insets(0, 0, 5, 5);
		gbc_txtNombre.gridx = 3;
		gbc_txtNombre.gridy = 4;
		add(txtNombre, gbc_txtNombre);
		txtNombre.setColumns(10);

		JLabel lblApellidos = new JLabel("Apellidos:");
		lblApellidos.setBounds(310, 234, 70, 14);
		GridBagConstraints gbc_lblApellidos = new GridBagConstraints();
		gbc_lblApellidos.insets = new Insets(0, 0, 5, 5);
		gbc_lblApellidos.gridx = 1;
		gbc_lblApellidos.gridy = 5;
		add(lblApellidos, gbc_lblApellidos);

		txtApellidos = new JTextField();
		txtApellidos.setBounds(404, 231, 140, 20);
		GridBagConstraints gbc_txtApellidos = new GridBagConstraints();
		gbc_txtApellidos.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtApellidos.anchor = GridBagConstraints.WEST;
		gbc_txtApellidos.insets = new Insets(0, 0, 5, 5);
		gbc_txtApellidos.gridx = 3;
		gbc_txtApellidos.gridy = 5;
		add(txtApellidos, gbc_txtApellidos);
		txtApellidos.setColumns(10);

		JLabel lblConstrasea = new JLabel("Contrase\u00F1a: ");
		lblConstrasea.setBounds(32, 190, 91, 14);
		GridBagConstraints gbc_lblConstrasea = new GridBagConstraints();
		gbc_lblConstrasea.insets = new Insets(0, 0, 5, 5);
		gbc_lblConstrasea.gridx = 1;
		gbc_lblConstrasea.gridy = 6;
		add(lblConstrasea, gbc_lblConstrasea);

		txtPass = new JTextField();
		txtPass.setBounds(128, 187, 142, 20);
		GridBagConstraints gbc_txtPass = new GridBagConstraints();
		gbc_txtPass.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtPass.anchor = GridBagConstraints.WEST;
		gbc_txtPass.insets = new Insets(0, 0, 5, 5);
		gbc_txtPass.gridx = 3;
		gbc_txtPass.gridy = 6;
		add(txtPass, gbc_txtPass);
		txtPass.setColumns(10);

		JLabel lblDireccion = new JLabel("Direccion:");
		lblDireccion.setBounds(310, 151, 84, 14);
		GridBagConstraints gbc_lblDireccion = new GridBagConstraints();
		gbc_lblDireccion.insets = new Insets(0, 0, 5, 5);
		gbc_lblDireccion.gridx = 1;
		gbc_lblDireccion.gridy = 7;
		add(lblDireccion, gbc_lblDireccion);

		txtDir = new JTextField();
		txtDir.setBounds(404, 148, 142, 20);
		GridBagConstraints gbc_txtDir = new GridBagConstraints();
		gbc_txtDir.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtDir.anchor = GridBagConstraints.NORTHWEST;
		gbc_txtDir.insets = new Insets(0, 0, 5, 5);
		gbc_txtDir.gridx = 3;
		gbc_txtDir.gridy = 7;
		add(txtDir, gbc_txtDir);
		txtDir.setColumns(10);

		JLabel lblTelefono = new JLabel("Telefono:");
		lblTelefono.setBounds(310, 190, 84, 14);
		GridBagConstraints gbc_lblTelefono = new GridBagConstraints();
		gbc_lblTelefono.insets = new Insets(0, 0, 5, 5);
		gbc_lblTelefono.gridx = 1;
		gbc_lblTelefono.gridy = 8;
		add(lblTelefono, gbc_lblTelefono);

		txtTelf = new JTextField();
		txtTelf.setBounds(404, 187, 142, 20);
		GridBagConstraints gbc_txtTelf = new GridBagConstraints();
		gbc_txtTelf.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtTelf.anchor = GridBagConstraints.WEST;
		gbc_txtTelf.insets = new Insets(0, 0, 5, 5);
		gbc_txtTelf.gridx = 3;
		gbc_txtTelf.gridy = 8;
		add(txtTelf, gbc_txtTelf);
		txtTelf.setColumns(10);

		JLabel lblClub = new JLabel("Club:");
		lblClub.setBounds(32, 234, 46, 14);
		GridBagConstraints gbc_lblClub = new GridBagConstraints();
		gbc_lblClub.insets = new Insets(0, 0, 5, 5);
		gbc_lblClub.gridx = 1;
		gbc_lblClub.gridy = 9;
		add(lblClub, gbc_lblClub);

		txtClub = new JTextField();
		txtClub.setBounds(128, 231, 142, 20);
		GridBagConstraints gbc_txtClub = new GridBagConstraints();
		gbc_txtClub.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtClub.anchor = GridBagConstraints.WEST;
		gbc_txtClub.insets = new Insets(0, 0, 5, 5);
		gbc_txtClub.gridx = 3;
		gbc_txtClub.gridy = 9;
		add(txtClub, gbc_txtClub);
		txtClub.setColumns(10);

		btnModificar = new JButton("Modificar");

		btnModificar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnModificar.setBounds(162, 294, 89, 23);
		GridBagConstraints gbc_btnModificar = new GridBagConstraints();
		gbc_btnModificar.insets = new Insets(0, 0, 5, 5);
		gbc_btnModificar.gridx = 3;
		gbc_btnModificar.gridy = 12;
		add(btnModificar, gbc_btnModificar);

		JButton btnLimpiar = new JButton("Limpiar");

		btnLimpiar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnLimpiar.setBounds(334, 294, 89, 23);
		GridBagConstraints gbc_btnLimpiar = new GridBagConstraints();
		gbc_btnLimpiar.insets = new Insets(0, 0, 5, 5);
		gbc_btnLimpiar.gridx = 5;
		gbc_btnLimpiar.gridy = 12;
		add(btnLimpiar, gbc_btnLimpiar);

	}

}
