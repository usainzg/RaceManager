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
import vista.paneles.admin.BorradoUsuario;
import vista.paneles.admin.DeleteCarreraAdminPanel;
import vista.paneles.admin.ModificacionCarreraAdmin;
import vista.paneles.admin.ModificacionUsuarioAdmin;

public class AdminView extends JFrame {
	
	private ManagerBd manager;
	
	private ModificacionCarreraAdmin panelModificacionCarrera = new ModificacionCarreraAdmin();
	private VisualizacionCarrerasPanel panelVisualizacion;
	private BorradoUsuario panelBorradoUsuario = new BorradoUsuario();
	private DeleteCarreraAdminPanel panelBorradoCarrera = new DeleteCarreraAdminPanel();
	private ModificacionUsuarioAdmin panelModificacionUsuario = new ModificacionUsuarioAdmin();
	
	
	private static final long serialVersionUID = 1L;

	public AdminView(ManagerBd manager) {
		setResizable(false);
		this.manager = manager;
		this.panelVisualizacion = new VisualizacionCarrerasPanel(manager);
		initialize();
	}

	private void initialize() {
		setTitle("Admin");
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
				
				getContentPane().add(panelModificacionCarrera);
				pack();
				getContentPane().repaint();
				getContentPane().revalidate();
				
			}
		});
		
		mnEliminarCarreras.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				getContentPane().removeAll();
				getContentPane().repaint();
				getContentPane().revalidate();
				
				getContentPane().add(panelBorradoCarrera);
				pack();
				getContentPane().repaint();
				getContentPane().revalidate();
				
			}
		});
		
		
		
		mnModificarUsuarios.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				getContentPane().removeAll();
				getContentPane().repaint();
				getContentPane().revalidate();
				
				getContentPane().add(panelModificacionUsuario);
				pack();
				getContentPane().repaint();
				getContentPane().revalidate();
				
			}
		});
		
		mnEliminarUsuarios.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				getContentPane().removeAll();
				getContentPane().repaint();
				getContentPane().revalidate();
				
				getContentPane().add(panelBorradoUsuario);
				pack();
				getContentPane().repaint();
				getContentPane().revalidate();
			}
		});
		
		
	}
}
