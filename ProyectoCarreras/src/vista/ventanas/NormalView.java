package vista.ventanas;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Point;

import javax.swing.JFrame;

import bbdd.ManagerBd;
import vista.paneles.VisualizacionCarrerasPanel;

public class NormalView extends JFrame {

	private static final long serialVersionUID = 1L;

	private VisualizacionCarrerasPanel panel;

	private ManagerBd manager;

	public NormalView(ManagerBd ma) {
		setLocation(new Point(0, 0));
		setMinimumSize(new Dimension(800, 600));
		setMaximumSize(new Dimension(800, 600));
		setTitle("Visualizar Carreras (Como usuario normal)");
		setResizable(false);

		manager = ma;
		panel = new VisualizacionCarrerasPanel(manager);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 519, 431);
		getContentPane().add(panel, BorderLayout.CENTER);
		pack();
	}

}
