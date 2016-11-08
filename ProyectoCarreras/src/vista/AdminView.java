package vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JMenu;

public class AdminView {

	private JFrame frmVistaAdmin;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminView window = new AdminView();
					window.frmVistaAdmin.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public AdminView() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmVistaAdmin = new JFrame();
		frmVistaAdmin.setTitle("Vista Admin");
		frmVistaAdmin.setBounds(100, 100, 450, 300);
		frmVistaAdmin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JMenuBar menuBar = new JMenuBar();
		frmVistaAdmin.setJMenuBar(menuBar);
		
		JMenu mntCarreras = new JMenu("Gestion Carreras");
		menuBar.add(mntCarreras);
		
		JMenuItem mnVisualizacionCarreras = new JMenuItem("Visualizar Carreras");
		mntCarreras.add(mnVisualizacionCarreras);
		
		JMenuItem mnModificacionCarreras = new JMenuItem("Modificar Carreras");
		mntCarreras.add(mnModificacionCarreras);
		
		JMenuItem mnNewMenuItem = new JMenuItem("Eliminar Carreras");
		mntCarreras.add(mnNewMenuItem);
		
		JMenu mntUsuarios = new JMenu("Gestion Usuarios");
		menuBar.add(mntUsuarios);
		
		JMenuItem mnModificacionUsuario = new JMenuItem("Modificar Usuarios");
		mntUsuarios.add(mnModificacionUsuario);
		
		JMenuItem mnEliminacionCarreras = new JMenuItem("Eliminar Usuarios");
		mntUsuarios.add(mnEliminacionCarreras);
	}
}
