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
import vista.paneles.org.BorradoCarreraOrg;
import vista.paneles.org.ModificacionCarreraOrg;

public class OrgView extends JFrame {
	
	private ManagerBd manager;
	
	private VisualizacionCarrerasPanel panelVisualizacion;
	private BorradoCarreraOrg panelBorradoCarreraOrg;
	private ModificacionCarreraOrg panelModificacionCarreraOrg;

	private static final long serialVersionUID = 1L;

	public OrgView(ManagerBd manager) {
		this.manager = manager;
		this.panelVisualizacion = new VisualizacionCarrerasPanel(manager);
		setLayoutView();
	}

	private void setLayoutView() {
		setTitle("Vista Organizacion");
		setBounds(100, 100, 450, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		getContentPane().add(panelVisualizacion, BorderLayout.CENTER);
		pack();
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mntCarreras = new JMenu("Gestion Carreras");
		menuBar.add(mntCarreras);
		
		JMenuItem mnVisualizacionCarreras = new JMenuItem("Visualizar Carreras");
		mntCarreras.add(mnVisualizacionCarreras);
		
		JMenuItem mnModificacionCarreras = new JMenuItem("Modificar Carrera");
		mntCarreras.add(mnModificacionCarreras);
		
		JMenuItem mnBorrarCarrera = new JMenuItem("Borrar Carrera");
		mntCarreras.add(mnBorrarCarrera);
		
		mnVisualizacionCarreras.addActionListener(new ActionListener() {
			
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
		
		mnModificacionCarreras.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				getContentPane().removeAll();
				getContentPane().repaint();
				getContentPane().revalidate();
				
				getContentPane().add(panelModificacionCarreraOrg);
				pack();
				getContentPane().repaint();
				getContentPane().revalidate();
				
			}
		});
		
		mnBorrarCarrera.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				getContentPane().removeAll();
				getContentPane().repaint();
				getContentPane().revalidate();
				
				getContentPane().add(panelBorradoCarreraOrg);
				pack();
				getContentPane().repaint();
				getContentPane().revalidate();
				
			}
		});
		
	}
	

}
