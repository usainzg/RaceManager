package vista.paneles.admin;

import java.awt.Font;

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
	private JComboBox<String> comboUserTypes;
	
	/**
	 * Create the panel.
	 */
	public ModificacionUsuarioAdmin() {
		setLayout();
	}
	
	private void setLayout(){
		
		JLabel lblTipoUsuarioA = new JLabel("Tipo usuario a modificar: ");
		lblTipoUsuarioA.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblTipoUsuarioA.setBounds(77, 50, 162, 14);
		add(lblTipoUsuarioA);

		comboUserTypes = new JComboBox<String>();
		comboUserTypes.setBounds(87, 77, 142, 20);
		add(comboUserTypes);

		JLabel lblNombre = new JLabel("Nombre: ");
		lblNombre.setBounds(32, 151, 61, 14);
		add(lblNombre);

		JLabel lblEmailUsuarioA = new JLabel("Email usuario a modificar: ");
		lblEmailUsuarioA.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblEmailUsuarioA.setBounds(300, 50, 177, 14);
		add(lblEmailUsuarioA);

		JComboBox<Object> comboBox_1 = new JComboBox<>();
		comboBox_1.setBounds(310, 77, 214, 20);
		add(comboBox_1);

		JLabel lblNuevosDatos = new JLabel("Nuevos datos:");
		lblNuevosDatos.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNuevosDatos.setBounds(22, 123, 101, 14);
		add(lblNuevosDatos);

		txtNombre = new JTextField();
		txtNombre.setBounds(128, 148, 142, 20);
		add(txtNombre);
		txtNombre.setColumns(10);

		txtDir = new JTextField();
		txtDir.setBounds(404, 148, 142, 20);
		add(txtDir);
		txtDir.setColumns(10);

		JLabel lblDireccion = new JLabel("Direccion:");
		lblDireccion.setBounds(310, 151, 84, 14);
		add(lblDireccion);

		JLabel lblConstrasea = new JLabel("Contrase\u00F1a: ");
		lblConstrasea.setBounds(32, 190, 91, 14);
		add(lblConstrasea);

		JLabel lblTelefono = new JLabel("Telefono:");
		lblTelefono.setBounds(310, 190, 84, 14);
		add(lblTelefono);

		JLabel lblClub = new JLabel("Club:");
		lblClub.setBounds(32, 234, 46, 14);
		add(lblClub);

		txtPass = new JTextField();
		txtPass.setBounds(128, 187, 142, 20);
		add(txtPass);
		txtPass.setColumns(10);

		txtTelf = new JTextField();
		txtTelf.setBounds(404, 187, 142, 20);
		add(txtTelf);
		txtTelf.setColumns(10);

		txtClub = new JTextField();
		txtClub.setBounds(128, 231, 142, 20);
		add(txtClub);
		txtClub.setColumns(10);

		JButton btnModificar = new JButton("Modificar");

		btnModificar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnModificar.setBounds(162, 294, 89, 23);
		add(btnModificar);

		JButton btnLimpiar = new JButton("Limpiar");

		btnLimpiar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnLimpiar.setBounds(334, 294, 89, 23);
		add(btnLimpiar);

		JLabel lblApellidos = new JLabel("Apellidos:");
		lblApellidos.setBounds(310, 234, 70, 14);
		add(lblApellidos);

		txtApellidos = new JTextField();
		txtApellidos.setBounds(404, 231, 140, 20);
		add(txtApellidos);
		txtApellidos.setColumns(10);
		
		initUserTypesCombo();
		
	}
	
	private void initUserTypesCombo(){
		comboUserTypes.addItem("Normal");
		comboUserTypes.addItem("Organizador");
		comboUserTypes.setSelectedItem("Normal");
	}

}
