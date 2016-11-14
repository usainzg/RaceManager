package vista.ventanas;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

import bbdd.ManagerBd;
import clases.UsuarioOrganizador;
import utilidades.ViewUtil;
import vista.paneles.VisualizacionCarrerasPanel;
import vista.paneles.org.BorradoCarreraOrg;
import vista.paneles.org.ModificacionCarreraOrg;

public class OrgView extends JFrame implements ActionListener, ViewUtil{
	
	// manager
	private ManagerBd manager;
	
	// referencia al org logeado
	private UsuarioOrganizador orgLogeado;
	
	// JMenuItems para cambiar paneles
	private JMenuItem mnVisualizacionCarreras, mnModificacionCarreras, mnBorrarCarrera;
	
	// Paneles
	private VisualizacionCarrerasPanel panelVisualizacion;
	private BorradoCarreraOrg panelBorradoCarreraOrg = new BorradoCarreraOrg();
	private ModificacionCarreraOrg panelModificacionCarreraOrg = new ModificacionCarreraOrg();

	private static final long serialVersionUID = 1L;

	public OrgView(ManagerBd manager, UsuarioOrganizador orgLogeado) {
		this.orgLogeado = orgLogeado;
		setResizable(false);
		this.manager = manager;
		this.panelVisualizacion = new VisualizacionCarrerasPanel(manager);
		setLayoutView();
	}

	private void setLayoutView() {
		setTitle("Organizador");
		setBounds(100, 100, 450, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		getContentPane().add(panelVisualizacion, BorderLayout.CENTER);
		pack();
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mntCarreras = new JMenu("Gestion Carreras");
		menuBar.add(mntCarreras);
		
		mnVisualizacionCarreras = new JMenuItem("Visualizar Carreras");
		mntCarreras.add(mnVisualizacionCarreras);
		
		mnModificacionCarreras = new JMenuItem("Modificar Carrera");
		mntCarreras.add(mnModificacionCarreras);
		
		mnBorrarCarrera = new JMenuItem("Borrar Carrera");
		mntCarreras.add(mnBorrarCarrera);
		
		mnVisualizacionCarreras.addActionListener(this);
		mnModificacionCarreras.addActionListener(this);
		mnBorrarCarrera.addActionListener(this);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == mnVisualizacionCarreras){
		
			changePanel(panelVisualizacion);
			
		}else if(e.getSource() == mnModificacionCarreras){
			
			changePanel(panelModificacionCarreraOrg);
			
		}else if(e.getSource() == mnBorrarCarrera){
			
			changePanel(panelBorradoCarreraOrg);
			
		}
		
	}

	@Override
	public void changePanel(final JPanel panel) {
		
		getContentPane().removeAll();
		getContentPane().repaint();
		getContentPane().revalidate();
		
		getContentPane().add(panel);
		pack();
		getContentPane().repaint();
		getContentPane().revalidate();
		
	}
	

}
