package vista;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import bbdd.MySqlManager;
import clases.Carrera;
import utilidades.Utilidades;

public class ModificacionCarreraOrg extends JFrame {

	private static final long serialVersionUID = 1L;
	private JTextField txtDistancia;
	private JTextField txtDesnivel;
	private JTextField txtPrecio;
	private JTextField txtFecha;
	private JTextField txtLugar;

	private Utilidades util = new Utilidades();
	private MySqlManager mySql = new MySqlManager();

	/**
	 * Create the frame.
	 */
	public ModificacionCarreraOrg() {
		setBounds(100, 100, 568, 431);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);

		JLabel lblCarreraAModificar = new JLabel("Carrera a modificar: ");
		lblCarreraAModificar.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		lblCarreraAModificar.setBounds(29, 19, 147, 16);
		getContentPane().add(lblCarreraAModificar);

		JComboBox<Object> comboBox = new JComboBox<>();
		comboBox.setBounds(188, 15, 203, 27);
		getContentPane().add(comboBox);

		JLabel lblNuevosDatos = new JLabel("Nuevos Datos: ");
		lblNuevosDatos.setFont(new Font("Lucida Grande", Font.BOLD, 15));
		lblNuevosDatos.setBounds(29, 63, 129, 27);
		getContentPane().add(lblNuevosDatos);

		JLabel lblDistancia = new JLabel("Distancia: ");
		lblDistancia.setBounds(59, 125, 78, 16);
		getContentPane().add(lblDistancia);

		JLabel lblDesnivel = new JLabel("Desnivel: ");
		lblDesnivel.setBounds(59, 168, 78, 16);
		getContentPane().add(lblDesnivel);

		JLabel lblPrecio = new JLabel("Precio: ");
		lblPrecio.setBounds(59, 214, 61, 16);
		getContentPane().add(lblPrecio);

		JLabel lblFecha = new JLabel("Fecha: ");
		lblFecha.setBounds(59, 261, 61, 16);
		getContentPane().add(lblFecha);

		JLabel lblLugar = new JLabel("Lugar: ");
		lblLugar.setBounds(59, 309, 61, 16);
		getContentPane().add(lblLugar);

		txtDistancia = new JTextField();
		txtDistancia.setBounds(149, 120, 130, 26);
		getContentPane().add(txtDistancia);
		txtDistancia.setColumns(10);

		txtDesnivel = new JTextField();
		txtDesnivel.setBounds(149, 163, 130, 26);
		getContentPane().add(txtDesnivel);
		txtDesnivel.setColumns(10);

		txtPrecio = new JTextField();
		txtPrecio.setBounds(149, 209, 130, 26);
		getContentPane().add(txtPrecio);
		txtPrecio.setColumns(10);

		// on focus fecha

		txtLugar = new JTextField();
		txtLugar.setBounds(149, 304, 130, 26);
		getContentPane().add(txtLugar);
		txtLugar.setColumns(10);

		JButton btnModificar = new JButton("Modificar");

		btnModificar.setBounds(333, 120, 117, 29);
		getContentPane().add(btnModificar);

		JButton btnLimpiar = new JButton("Limpiar");

		btnLimpiar.setBounds(333, 163, 117, 29);
		getContentPane().add(btnLimpiar);

		txtFecha = new JTextField();
		txtFecha.setText("Ej. 1999-09-09");
		txtFecha.setBounds(149, 256, 130, 26);
		getContentPane().add(txtFecha);

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

		// listeners
		txtFecha.addFocusListener(new FocusListener() {

			@Override
			public void focusGained(FocusEvent e) {
				txtFecha.setText("");

			}

			@Override
			public void focusLost(FocusEvent e) {
				if (!util.isValidDate(txtFecha)) {
					util.createInfobox(
							"Vuelva a introducir la fecha en el siguiente formato: 0000-00-00 / años-meses-dias",
							"Formato fecha erroneo");
				}
			}
		});

		btnModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (util.isValidDate(txtFecha)) {
					try {

						Carrera c = new Carrera(comboBox.getSelectedItem().toString(), null, 0, 0, 0, "", "");
						Carrera cNueva = new Carrera();
						cNueva.setNbCarrera(comboBox.getSelectedItem().toString());
						cNueva.setOrgCarrera(null);
						cNueva.setDistanciaCarrera(Integer.parseInt(txtDistancia.getText()));
						cNueva.setDesnivelCarrera(Integer.parseInt(txtDesnivel.getText()));
						cNueva.setPrecioCarrera(Integer.parseInt(txtPrecio.getText()));

						SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
						String str = txtFecha.getText();

						try {
							Date date = formatter.parse(str);
							String formateado = formatter.format(date);
							cNueva.setFechaCarrera(formateado);
						} catch (Exception ex) {
							ex.printStackTrace();
						}

						cNueva.setLugarCarrera(txtLugar.getText());

						int filas = mySql.updateCarreraAdmin(c, cNueva);
						util.createInfobox("Se han modificado " + filas + " filas de la base de datos.",
								"Modificacion no completada.");

					} catch (Exception ex) {
						ex.printStackTrace();
					}

				} else {
					util.createErrorbox("Revise los campos", "Fallo de formato");
				}

			}
		});

		btnLimpiar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtDesnivel.setText("");
				txtDistancia.setText("");
				txtLugar.setText("");
				txtFecha.setText("");
			}
		});

	}
}
