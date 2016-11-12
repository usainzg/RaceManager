package vista.ventanas;

import javax.swing.JFrame;

import bbdd.ManagerBd;
import vista.paneles.VisualizacionCarrerasPanel;

public class NormalView extends JFrame {

	private static final long serialVersionUID = 1L;
	
	private VisualizacionCarrerasPanel panel;
	
	private ManagerBd manager;
	
	public NormalView(ManagerBd ma) {
		setTitle("Visualizar Carreras (Como usuario normal)");
		setResizable(false);
		
		manager = ma;
		panel = new VisualizacionCarrerasPanel(manager);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 519, 431);
		getContentPane().add(panel);
	}

}
