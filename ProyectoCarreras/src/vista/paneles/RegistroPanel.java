package vista.paneles;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class RegistroPanel extends JPanel {

	private static final long serialVersionUID = 1L;

	private JTextField registroNombre;
	private JTextField registroApellidos;
	private JTextField registroEmail;
	private JTextField registroPassword;
	private JTextField registroDireccion;
	private JTextField registroTelf;
	private JTextField registroClub;
	private final String[] USERTYPES = { "Normal", "Organizacion" };
	private JLabel lblClub;
	private JLabel lblApellidos;
	private JLabel lblEmail;
	private JLabel lblTelefono;
	private JLabel lblContrasena;
	private JLabel lblDireccion;
	private JLabel lblNewLabel;

	public RegistroPanel() {
		setLayoutView();
	}

	private void setLayoutView() {
		setLayout(null);

		lblContrasena = new JLabel("Contraseña");
		lblContrasena.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblContrasena.setBounds(32, 110, 84, 29);

		registroPassword = new JTextField();
		registroPassword.setBounds(122, 110, 153, 29);
		registroPassword.setColumns(10);

		lblDireccion = new JLabel("Direccion");
		lblDireccion.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblDireccion.setBounds(32, 202, 99, 38);

		registroDireccion = new JTextField();
		registroDireccion.setBounds(122, 207, 153, 29);
		registroDireccion.setColumns(10);

		lblTelefono = new JLabel("Telefono");
		lblTelefono.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblTelefono.setBounds(32, 161, 69, 29);

		lblApellidos = new JLabel("Apellidos");
		lblApellidos.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblApellidos.setBounds(309, 59, 125, 29);

		registroApellidos = new JTextField();
		registroApellidos.setBounds(411, 59, 153, 29);
		registroApellidos.setColumns(10);

		lblEmail = new JLabel("Email");
		lblEmail.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblEmail.setBounds(309, 207, 84, 29);

		registroEmail = new JTextField();
		registroEmail.setBounds(411, 207, 153, 29);
		registroEmail.setColumns(10);

		lblClub = new JLabel("Club");
		lblClub.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblClub.setBounds(309, 110, 84, 29);

		registroClub = new JTextField();
		registroClub.setBounds(411, 110, 153, 29);
		registroClub.setColumns(10);

		// combobox with user types
		JComboBox<String> comboTipoUsuario = new JComboBox<String>();
		comboTipoUsuario.setBounds(392, 162, 192, 29);

		registroTelf = new JTextField();
		registroTelf.setBounds(122, 162, 153, 26);
		add(registroTelf);
		registroTelf.setColumns(10);

		// textfields

		registroNombre = new JTextField();
		registroNombre.setBounds(122, 60, 153, 26);
		add(registroNombre);
		registroNombre.setColumns(10);

		// labels
		lblNewLabel = new JLabel("Nombre");
		add(lblNewLabel);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel.setBounds(32, 66, 47, 15);

		// label for combobox
		JLabel lblTipoUsuario = new JLabel("Tipo usuario");
		lblTipoUsuario.setBounds(309, 168, 75, 15);
		add(lblTipoUsuario);
		lblTipoUsuario.setFont(new Font("Tahoma", Font.BOLD, 12));

		JButton btnLimpiar = new JButton("Limpiar");
		btnLimpiar.setBounds(424, 277, 85, 29);
		add(btnLimpiar);
		/*
		 * btnLimpiar.addActionListener(new ActionListener() { JTextField[] arrJ
		 * = { registroNombre, registroApellidos, registroClub,
		 * registroDireccion, registroEmail, registroPassword, registroTelf };
		 * 
		 * public void actionPerformed(ActionEvent arg0) { for (JTextField j :
		 * arrJ) { util.resetJTextField(j); }
		 * 
		 * } });
		 */
		btnLimpiar.setFont(new Font("Tahoma", Font.BOLD, 11));

		JButton okBtn = new JButton("Registrarse");
		okBtn.setBounds(32, 289, 110, 29);
		okBtn.setFont(new Font("Tahoma", Font.BOLD, 11));
		okBtn.setActionCommand("");
		add(okBtn);

		JButton cancelBtn = new JButton("Cancel");
		cancelBtn.setBounds(194, 289, 81, 29);
		add(cancelBtn);

		// cancel event handler
		cancelBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// TODO return to main panel (mainLoginPanel)
			}
		});
		cancelBtn.setFont(new Font("Tahoma", Font.BOLD, 11));
		cancelBtn.setActionCommand("Cancel");

		// populate combobox with constant string array
		comboTipoUsuario.setModel(new DefaultComboBoxModel<String>(USERTYPES));
		
		add(lblContrasena);
		add(registroPassword);
		add(lblDireccion);
		add(registroDireccion);
		add(lblTelefono);
		add(lblApellidos);
		add(registroApellidos);
		add(lblEmail);
		add(registroEmail);
		add(lblClub);
		add(registroClub);
		add(comboTipoUsuario);
	}

}

// }
