package vista.ventanas;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextField;

import bbdd.ManagerBd;
import clases.Carrera;
import clases.UsuarioOrganizador;
import utilidades.Utilidades;
import utilidades.ViewUtil;
import vista.paneles.VisualizacionCarrerasPanel;
import vista.paneles.org.BorradoCarreraOrg;
import vista.paneles.org.ModificacionCarreraOrg;

public class OrgView extends JFrame implements ActionListener, ViewUtil{
	
	// manager
	private ManagerBd manager;
	private Utilidades util = new Utilidades();
	
	// Referencia al org logeado
	private UsuarioOrganizador orgLogeado;
	
	// JMenuItems para cambiar paneles
	private JMenuItem mnVisualizacionCarreras, mnModificacionCarreras, mnBorrarCarrera;
	
	// Paneles
	private VisualizacionCarrerasPanel panelVisualizacion;
	private BorradoCarreraOrg panelBorradoCarreraOrg = new BorradoCarreraOrg();
	private ModificacionCarreraOrg panelModificacionCarreraOrg = new ModificacionCarreraOrg();

	
	// Referencias panel Borrado
	private JButton btnBorrarPanelBorrado = panelBorradoCarreraOrg.getBtnBorrar();
	private JComboBox<Object> comboPanelBorrado = panelBorradoCarreraOrg.getComboCarreraBorrarOrg();
	
	// Referencias panel Modificacion
	private JTextField txtDistancia = panelModificacionCarreraOrg.getTxtDistancia();
	private JTextField txtDesnivel = panelModificacionCarreraOrg.getTxtDesnivel();
	private JTextField txtPrecio = panelModificacionCarreraOrg.getTxtPrecio();
	private JTextField txtFecha = panelModificacionCarreraOrg.getTxtFecha();
	private JTextField txtLugar = panelModificacionCarreraOrg.getTxtLugar();
	private JButton btnModificar = panelModificacionCarreraOrg.getBtnModificar();
	private JButton btnLimpiar = panelModificacionCarreraOrg.getBtnLimpiar();
	private JComboBox<Object> comboCarreraModificar = panelModificacionCarreraOrg.getComboCarreraModificar();
	
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
		
		btnBorrarPanelBorrado.addActionListener(this);
		
		btnModificar.addActionListener(this);
		btnLimpiar.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == mnVisualizacionCarreras){
		
			changePanel(panelVisualizacion);
			
		}else if(e.getSource() == mnModificacionCarreras){
			
			changePanel(panelModificacionCarreraOrg);
			
		}else if(e.getSource() == mnBorrarCarrera){
			
			changePanel(panelBorradoCarreraOrg);
			initComboBorrado();
			
		}
		
		
		if(e.getSource() == btnBorrarPanelBorrado){
			
			initComboBorrado();
		}
		
		
		if(e.getSource() == btnModificar){
			
		}else if(e.getSource() == btnLimpiar){
			util.resetJTextField(txtDesnivel, txtDistancia, txtFecha, txtLugar, txtPrecio);
		}
	}
	
	private void initComboBorrado(){
		
		System.out.println(orgLogeado.getNbUsuario());
		
		try {
			ArrayList<Carrera> carreras = manager.consultarCarrerasOrg(orgLogeado);
			System.out.println(carreras.size());
			for(Carrera c: carreras){
			}
		} catch (Exception e) {
			util.createErrorbox("Error al recoger datos de la base de datos", "Error conexion base de datos"); 
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
