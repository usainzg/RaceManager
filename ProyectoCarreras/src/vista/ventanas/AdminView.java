package vista.ventanas;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class AdminView extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;

	public AdminView() {
		initialize();
	}

	private void initialize() {
		setTitle("Vista Admin");
		setBounds(100, 100, 450, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mntCarreras = new JMenu("Gestion Carreras");
		menuBar.add(mntCarreras);
		
		JMenuItem mnVisualizarCarreras = new JMenuItem("Visualizar Carreras");
		mntCarreras.add(mnVisualizarCarreras);
		
		JMenuItem mnModificarCarreras = new JMenuItem("Modificar Carreras");
		mntCarreras.add(mnModificarCarreras);
		
		JMenuItem mnEliminarCarreras = new JMenuItem("Eliminar Carreras");
		mntCarreras.add(mnEliminarCarreras);
		
		JMenu mntUsuarios = new JMenu("Gestion Usuarios");
		menuBar.add(mntUsuarios);
		
		JMenuItem mnModificarUsuarios = new JMenuItem("Modificar Usuarios");
		mntUsuarios.add(mnModificarUsuarios);
		
		JMenuItem mnEliminarUsuarios = new JMenuItem("Eliminar Usuarios");
		mntUsuarios.add(mnEliminarUsuarios);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO
		if(e.getSource() == "mnEliminarCarreras"){
			System.out.println("DESDE ELIMINAR CARRERAS");
		}else if(e.getSource() == "mnVisualizarCarreras"){
			System.out.println("DESDE VER CARRERAS");
		}else if(e.getSource() == "mnModificarCarreras"){
			
		}
		
	}
}
