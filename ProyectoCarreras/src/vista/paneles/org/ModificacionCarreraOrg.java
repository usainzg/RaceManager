package vista.paneles.org;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

public class ModificacionCarreraOrg extends JPanel {

	private static final long serialVersionUID = 1L;

	private JTextField txtDistancia;
	private JTextField txtDesnivel;
	private JTextField txtPrecio;
	private JTextField txtFecha;
	private JTextField txtLugar;
	private JButton btnModificar, btnLimpiar;
	private JComboBox<Object> comboCarreraModificar;

	
	public JTextField getTxtDistancia() {
		return txtDistancia;
	}

	public JTextField getTxtDesnivel() {
		return txtDesnivel;
	}

	public JTextField getTxtPrecio() {
		return txtPrecio;
	}

	public JTextField getTxtFecha() {
		return txtFecha;
	}

	public JTextField getTxtLugar() {
		return txtLugar;
	}

	public JButton getBtnModificar() {
		return btnModificar;
	}

	public JButton getBtnLimpiar() {
		return btnLimpiar;
	}

	public JComboBox<Object> getComboCarreraModificar() {
		return comboCarreraModificar;
	}


	public ModificacionCarreraOrg() {
		setBounds(100, 100, 582, 351);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 65, 86, 134, 65, 0 };
		gridBagLayout.rowHeights = new int[] { 60, 23, 20, 0, 0, 0, 0, 0, 0, 0, 60, 0 };
		gridBagLayout.columnWeights = new double[] { 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
				Double.MIN_VALUE };
		setLayout(gridBagLayout);

		JLabel lblCarreraAModificar = new JLabel("Carrera a modificar: ");
		lblCarreraAModificar.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		lblCarreraAModificar.setBounds(29, 19, 147, 16);
		GridBagConstraints gbc_lblCarreraAModificar = new GridBagConstraints();
		gbc_lblCarreraAModificar.anchor = GridBagConstraints.EAST;
		gbc_lblCarreraAModificar.insets = new Insets(0, 0, 5, 5);
		gbc_lblCarreraAModificar.gridx = 1;
		gbc_lblCarreraAModificar.gridy = 1;
		add(lblCarreraAModificar, gbc_lblCarreraAModificar);

		comboCarreraModificar = new JComboBox<>();
		comboCarreraModificar.setBounds(188, 15, 203, 27);
		GridBagConstraints gbc_comboCarreraModificar = new GridBagConstraints();
		gbc_comboCarreraModificar.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboCarreraModificar.anchor = GridBagConstraints.NORTHWEST;
		gbc_comboCarreraModificar.insets = new Insets(0, 0, 5, 5);
		gbc_comboCarreraModificar.gridx = 2;
		gbc_comboCarreraModificar.gridy = 1;
		add(comboCarreraModificar, gbc_comboCarreraModificar);

		JLabel lblNuevosDatos = new JLabel("Nuevos Datos: ");
		lblNuevosDatos.setFont(new Font("Lucida Grande", Font.BOLD, 15));
		lblNuevosDatos.setBounds(29, 63, 129, 27);
		GridBagConstraints gbc_lblNuevosDatos = new GridBagConstraints();
		gbc_lblNuevosDatos.anchor = GridBagConstraints.NORTHWEST;
		gbc_lblNuevosDatos.insets = new Insets(0, 0, 5, 5);
		gbc_lblNuevosDatos.gridx = 1;
		gbc_lblNuevosDatos.gridy = 2;
		add(lblNuevosDatos, gbc_lblNuevosDatos);

		JLabel lblDistancia = new JLabel("Distancia: ");
		lblDistancia.setBounds(59, 125, 78, 16);
		GridBagConstraints gbc_lblDistancia = new GridBagConstraints();
		gbc_lblDistancia.insets = new Insets(0, 0, 5, 5);
		gbc_lblDistancia.gridx = 1;
		gbc_lblDistancia.gridy = 3;
		add(lblDistancia, gbc_lblDistancia);

		txtDistancia = new JTextField();
		txtDistancia.setBounds(149, 120, 130, 26);
		GridBagConstraints gbc_txtDistancia = new GridBagConstraints();
		gbc_txtDistancia.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtDistancia.anchor = GridBagConstraints.WEST;
		gbc_txtDistancia.insets = new Insets(0, 0, 5, 5);
		gbc_txtDistancia.gridx = 2;
		gbc_txtDistancia.gridy = 3;
		add(txtDistancia, gbc_txtDistancia);
		txtDistancia.setColumns(10);

		JLabel lblDesnivel = new JLabel("Desnivel: ");
		lblDesnivel.setBounds(59, 168, 78, 16);
		GridBagConstraints gbc_lblDesnivel = new GridBagConstraints();
		gbc_lblDesnivel.insets = new Insets(0, 0, 5, 5);
		gbc_lblDesnivel.gridx = 1;
		gbc_lblDesnivel.gridy = 4;
		add(lblDesnivel, gbc_lblDesnivel);

		txtDesnivel = new JTextField();
		txtDesnivel.setBounds(149, 163, 130, 26);
		GridBagConstraints gbc_txtDesnivel = new GridBagConstraints();
		gbc_txtDesnivel.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtDesnivel.anchor = GridBagConstraints.WEST;
		gbc_txtDesnivel.insets = new Insets(0, 0, 5, 5);
		gbc_txtDesnivel.gridx = 2;
		gbc_txtDesnivel.gridy = 4;
		add(txtDesnivel, gbc_txtDesnivel);
		txtDesnivel.setColumns(10);

		JLabel lblPrecio = new JLabel("Precio: ");
		lblPrecio.setBounds(59, 214, 61, 16);
		GridBagConstraints gbc_lblPrecio = new GridBagConstraints();
		gbc_lblPrecio.insets = new Insets(0, 0, 5, 5);
		gbc_lblPrecio.gridx = 1;
		gbc_lblPrecio.gridy = 5;
		add(lblPrecio, gbc_lblPrecio);

		txtPrecio = new JTextField();
		txtPrecio.setBounds(149, 209, 130, 26);
		GridBagConstraints gbc_txtPrecio = new GridBagConstraints();
		gbc_txtPrecio.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtPrecio.anchor = GridBagConstraints.WEST;
		gbc_txtPrecio.insets = new Insets(0, 0, 5, 5);
		gbc_txtPrecio.gridx = 2;
		gbc_txtPrecio.gridy = 5;
		add(txtPrecio, gbc_txtPrecio);
		txtPrecio.setColumns(10);

		JLabel lblFecha = new JLabel("Fecha: ");
		lblFecha.setBounds(59, 261, 61, 16);
		GridBagConstraints gbc_lblFecha = new GridBagConstraints();
		gbc_lblFecha.insets = new Insets(0, 0, 5, 5);
		gbc_lblFecha.gridx = 1;
		gbc_lblFecha.gridy = 6;
		add(lblFecha, gbc_lblFecha);

		txtFecha = new JTextField();
		txtFecha.setText("Ej. 1999-09-09");
		txtFecha.setBounds(149, 256, 130, 26);
		GridBagConstraints gbc_txtFecha = new GridBagConstraints();
		gbc_txtFecha.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtFecha.anchor = GridBagConstraints.NORTH;
		gbc_txtFecha.insets = new Insets(0, 0, 5, 5);
		gbc_txtFecha.gridx = 2;
		gbc_txtFecha.gridy = 6;
		add(txtFecha, gbc_txtFecha);

		JLabel lblLugar = new JLabel("Lugar: ");
		lblLugar.setBounds(59, 309, 61, 16);
		GridBagConstraints gbc_lblLugar = new GridBagConstraints();
		gbc_lblLugar.insets = new Insets(0, 0, 5, 5);
		gbc_lblLugar.gridx = 1;
		gbc_lblLugar.gridy = 7;
		add(lblLugar, gbc_lblLugar);

		txtLugar = new JTextField();
		txtLugar.setBounds(149, 304, 130, 26);
		GridBagConstraints gbc_txtLugar = new GridBagConstraints();
		gbc_txtLugar.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtLugar.anchor = GridBagConstraints.WEST;
		gbc_txtLugar.insets = new Insets(0, 0, 5, 5);
		gbc_txtLugar.gridx = 2;
		gbc_txtLugar.gridy = 7;
		add(txtLugar, gbc_txtLugar);
		txtLugar.setColumns(10);

		btnModificar = new JButton("Modificar");

		btnModificar.setBounds(333, 120, 117, 29);
		GridBagConstraints gbc_btnModificar = new GridBagConstraints();
		gbc_btnModificar.insets = new Insets(0, 0, 5, 5);
		gbc_btnModificar.gridx = 1;
		gbc_btnModificar.gridy = 9;
		add(btnModificar, gbc_btnModificar);

		btnLimpiar = new JButton("Limpiar");

		btnLimpiar.setBounds(333, 163, 117, 29);
		GridBagConstraints gbc_btnLimpiar = new GridBagConstraints();
		gbc_btnLimpiar.insets = new Insets(0, 0, 5, 5);
		gbc_btnLimpiar.gridx = 2;
		gbc_btnLimpiar.gridy = 9;
		add(btnLimpiar, gbc_btnLimpiar);

	}

}
