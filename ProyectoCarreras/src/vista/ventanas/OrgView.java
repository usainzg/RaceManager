package vista.ventanas;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class OrgView extends JFrame {

	private static final long serialVersionUID = 1L;

	public OrgView() {
		initialize();
	}

	private void initialize() {
		setTitle("Vista Organizacion");
		setBounds(100, 100, 450, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mntCarreras = new JMenu("Gestion Carreras");
		menuBar.add(mntCarreras);
		
		JMenuItem mnVisualizacionCarreras = new JMenuItem("Visualizar Carreras");
		mntCarreras.add(mnVisualizacionCarreras);
		
		JMenuItem mnModificacionCarreras = new JMenuItem("Modificar Carreras");
		mntCarreras.add(mnModificacionCarreras);
	}

}
