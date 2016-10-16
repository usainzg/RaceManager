package vista;


import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GestionUsuarios extends JFrame {


	private static final long serialVersionUID = 1L;

	/**
	 * Create the frame.
	 */
	public GestionUsuarios() {
		setTitle("Gestion Usuarios");
		setBounds(100, 100, 405, 225);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Gestion Usuarios");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel.setBounds(136, 11, 126, 14);
		getContentPane().add(lblNewLabel);
		
		JButton btnBorrarUsuario = new JButton("Borrar Usuario");
		
		btnBorrarUsuario.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnBorrarUsuario.setBounds(41, 78, 126, 23);
		getContentPane().add(btnBorrarUsuario);
		
		JButton btnModificarUsuario = new JButton("Modificar Usuario");
		
		btnModificarUsuario.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnModificarUsuario.setBounds(214, 78, 149, 23);
		getContentPane().add(btnModificarUsuario);
		
		
		// action listeners
		btnModificarUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				ModificacionUsuario usu = new ModificacionUsuario();
				usu.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				usu.setVisible(true);
				
			}
		});
		
		
		btnBorrarUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});

	}
}
