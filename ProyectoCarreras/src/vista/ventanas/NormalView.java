package vista.ventanas;

import javax.swing.JFrame;
import javax.swing.JPanel;

import vista.paneles.VisualizacionCarrerasPanel;

public class NormalView extends JFrame {

	private static final long serialVersionUID = 1L;
	private final VisualizacionCarrerasPanel panel = new VisualizacionCarrerasPanel();
	
	public NormalView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		getContentPane().add(panel);
	}

}
