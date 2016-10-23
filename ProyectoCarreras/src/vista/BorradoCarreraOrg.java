package vista;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class BorradoCarreraOrg extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Create the frame.
	 */
	public BorradoCarreraOrg() {
		setTitle("Borrado Carrera (como Organizador)");
		setBounds(100, 100, 408, 224);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);

		JLabel lblCarreraABorrar = new JLabel("Carrera a borrar: ");
		lblCarreraABorrar.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblCarreraABorrar.setBounds(47, 50, 118, 14);
		getContentPane().add(lblCarreraABorrar);

		JButton btnBorrar = new JButton("Borrar");

		btnBorrar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnBorrar.setBounds(137, 110, 89, 23);
		getContentPane().add(btnBorrar);

		JComboBox<Object> comboBox = new JComboBox<>();
		comboBox.setBounds(176, 47, 173, 20);
		getContentPane().add(comboBox);

		btnBorrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});

	}
}
