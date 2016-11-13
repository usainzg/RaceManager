package vista.paneles.org;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ModificacionCarreraOrg extends JPanel {

	private static final long serialVersionUID = 1L;
	
	
	private JTextField txtDistancia;
	private JTextField txtDesnivel;
	private JTextField txtPrecio;
	private JTextField txtFecha;
	private JTextField txtLugar;


	public ModificacionCarreraOrg() {
		setBounds(100, 100, 568, 431);

		JLabel lblCarreraAModificar = new JLabel("Carrera a modificar: ");
		lblCarreraAModificar.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		lblCarreraAModificar.setBounds(29, 19, 147, 16);
		add(lblCarreraAModificar);

		JComboBox<Object> comboBox = new JComboBox<>();
		comboBox.setBounds(188, 15, 203, 27);
		add(comboBox);

		JLabel lblNuevosDatos = new JLabel("Nuevos Datos: ");
		lblNuevosDatos.setFont(new Font("Lucida Grande", Font.BOLD, 15));
		lblNuevosDatos.setBounds(29, 63, 129, 27);
		add(lblNuevosDatos);

		JLabel lblDistancia = new JLabel("Distancia: ");
		lblDistancia.setBounds(59, 125, 78, 16);
		add(lblDistancia);

		JLabel lblDesnivel = new JLabel("Desnivel: ");
		lblDesnivel.setBounds(59, 168, 78, 16);
		add(lblDesnivel);

		JLabel lblPrecio = new JLabel("Precio: ");
		lblPrecio.setBounds(59, 214, 61, 16);
		add(lblPrecio);

		JLabel lblFecha = new JLabel("Fecha: ");
		lblFecha.setBounds(59, 261, 61, 16);
		add(lblFecha);

		JLabel lblLugar = new JLabel("Lugar: ");
		lblLugar.setBounds(59, 309, 61, 16);
		add(lblLugar);

		txtDistancia = new JTextField();
		txtDistancia.setBounds(149, 120, 130, 26);
		add(txtDistancia);
		txtDistancia.setColumns(10);

		txtDesnivel = new JTextField();
		txtDesnivel.setBounds(149, 163, 130, 26);
		add(txtDesnivel);
		txtDesnivel.setColumns(10);

		txtPrecio = new JTextField();
		txtPrecio.setBounds(149, 209, 130, 26);
		add(txtPrecio);
		txtPrecio.setColumns(10);

		txtLugar = new JTextField();
		txtLugar.setBounds(149, 304, 130, 26);
		add(txtLugar);
		txtLugar.setColumns(10);

		JButton btnModificar = new JButton("Modificar");

		btnModificar.setBounds(333, 120, 117, 29);
		add(btnModificar);

		JButton btnLimpiar = new JButton("Limpiar");

		btnLimpiar.setBounds(333, 163, 117, 29);
		add(btnLimpiar);

		txtFecha = new JTextField();
		txtFecha.setText("Ej. 1999-09-09");
		txtFecha.setBounds(149, 256, 130, 26);
		add(txtFecha);

	}

}
