package vistas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JMenu;

public class OrgView {

	private JFrame frmVistaOrganizacion;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					OrgView window = new OrgView();
					window.frmVistaOrganizacion.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public OrgView() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmVistaOrganizacion = new JFrame();
		frmVistaOrganizacion.setTitle("Vista Organizacion");
		frmVistaOrganizacion.setBounds(100, 100, 450, 300);
		frmVistaOrganizacion.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JMenuBar menuBar = new JMenuBar();
		frmVistaOrganizacion.setJMenuBar(menuBar);
		
		JMenu mntCarreras = new JMenu("Gestion Carreras");
		menuBar.add(mntCarreras);
		
		JMenuItem mnVisualizacionCarreras = new JMenuItem("Visualizar Carreras");
		mntCarreras.add(mnVisualizacionCarreras);
		
		JMenuItem mnModificacionCarreras = new JMenuItem("Modificar Carreras");
		mntCarreras.add(mnModificacionCarreras);
	}

}
