package vista;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;

import bbdd.MySqlManager;
import clases.UsuarioEstandar;
import clases.UsuarioOrganizador;
import utilidades.Utilidades;

public class BorradoUsuario extends JFrame {

	private static final long serialVersionUID = 1L;
	private MySqlManager mySql = new MySqlManager();
	private Utilidades util = new Utilidades();

	/**
	 * Create the frame.
	 */
	public BorradoUsuario() {
		setTitle("Borrado Usuario (como Admin)");

		setBounds(100, 100, 416, 231);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);

		JComboBox<Object> comboEmail = new JComboBox<>();
		comboEmail.setBounds(161, 79, 195, 20);
		getContentPane().add(comboEmail);

		JLabel lblUsuarioABorrar = new JLabel("Usuario a borrar: ");
		lblUsuarioABorrar.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblUsuarioABorrar.setBounds(35, 82, 116, 14);
		getContentPane().add(lblUsuarioABorrar);

		JButton btnBorrar = new JButton("Borrar");

		btnBorrar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnBorrar.setBounds(155, 125, 89, 23);
		getContentPane().add(btnBorrar);

		JLabel lblTipoUsuarioA = new JLabel("Tipo usuario a borrar: ");
		lblTipoUsuarioA.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblTipoUsuarioA.setBounds(35, 35, 143, 14);
		getContentPane().add(lblTipoUsuarioA);

		JComboBox<String> comboTipo = new JComboBox<>();
		comboTipo.setBounds(161, 32, 195, 20);
		getContentPane().add(comboTipo);

		// action listener
		btnBorrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (comboTipo.getSelectedItem().equals("Normal")) {

					try {
						UsuarioEstandar uStd = new UsuarioEstandar();
						uStd.setNbUsuario("");
						uStd.setApellidosUsuario("");
						uStd.setEmailUsuario(comboEmail.getSelectedItem().toString());
						uStd.setPassUsuario("");
						uStd.setDirUsuario("");
						uStd.setTelfUsuario(0);
						uStd.setClubUsuario("");
						int filas = mySql.deleteUsuarioNormal(uStd);
						util.createInfobox("Se han eliminado " + filas + " de la base de datos.", "Borrado completado");
						comboEmail.removeItem(uStd.getEmailUsuario());
					} catch (Exception ex) {
						util.createErrorbox("No se ha podido borrar el usuario", "Borrado no completado");
					}

				} else {

					try {
						UsuarioOrganizador uOrg = new UsuarioOrganizador();

						uOrg.setNbUsuario("");
						uOrg.setApellidosUsuario("");
						uOrg.setEmailUsuario(comboEmail.getSelectedItem().toString());
						uOrg.setPassUsuario("");
						uOrg.setDirUsuario("");
						uOrg.setTelfUsuario(0);
						uOrg.setClubUsuario("");
						int filas = mySql.deleteUsuarioOrganizador(uOrg);
						util.createInfobox("Se han eliminado " + filas + " de la base de datos.", "Borrado completado");
						comboEmail.removeItem(uOrg.getEmailUsuario());
					} catch (Exception ex) {
						util.createErrorbox("No se ha podido borrar el usuario", "Borrado no completado");
					}

				}

			}
		});

		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent arg0) {
				comboTipo.addItem("Normal");
				comboTipo.addItem("Organizador");
				comboTipo.setSelectedItem("Normal");
			}
		});

		comboTipo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				comboEmail.removeAllItems();
				if (comboTipo.getSelectedItem().equals("Normal")) {

					ArrayList<UsuarioEstandar> arrU = new ArrayList<UsuarioEstandar>();
					try {
						arrU = mySql.consultarEmailNormal();
					} catch (Exception e1) {
						e1.printStackTrace();
					}

					for (UsuarioEstandar u : arrU) {
						comboEmail.addItem(u.getEmailUsuario());
					}

				} else {

					ArrayList<UsuarioOrganizador> arrU = new ArrayList<>();
					try {
						arrU = mySql.consultarEmailOrg();
					} catch (Exception e1) {
						e1.printStackTrace();
					}

					for (UsuarioOrganizador u : arrU) {
						comboEmail.addItem(u.getEmailUsuario());
					}

				}

			}
		});
	}

}
