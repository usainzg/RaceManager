package vista.ventanas;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import bbdd.ManagerBd;
import vista.paneles.VisualizacionCarrerasPanel;
import vista.paneles.admin.ModificacionCarreraAdmin;

public class AdminView extends JFrame {
	
	private ManagerBd manager;
	
	private ModificacionCarreraAdmin panelModificacion = new ModificacionCarreraAdmin();
	private VisualizacionCarrerasPanel panelVisualizacion;
	private BorradoUsuario panelBorradoUsuario = new BorradoUsuario();
	
	
	private static final long serialVersionUID = 1L;

	public AdminView(ManagerBd manager) {
		this.manager = manager;
		this.panelVisualizacion = new VisualizacionCarrerasPanel(manager);
		initialize();
	}

	private void initialize() {
		setTitle("Vista Admin");
		setBounds(100, 100, 450, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		getContentPane().add(panelVisualizacion, BorderLayout.CENTER);
		pack();
		
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
		
		
		mnVisualizarCarreras.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				getContentPane().removeAll();
				getContentPane().repaint();
				getContentPane().revalidate();
				
				getContentPane().add(panelVisualizacion);
				pack();
				getContentPane().repaint();
				getContentPane().revalidate();
			}
		});
		
		mnModificarCarreras.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				getContentPane().removeAll();
				getContentPane().repaint();
				getContentPane().revalidate();
				
				getContentPane().add(panelModificacion);
				pack();
				getContentPane().repaint();
				getContentPane().revalidate();
				
			}
		});
	}
}
