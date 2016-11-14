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

import bbdd.ManagerBd;
import clases.UsuarioEstandar;
import clases.UsuarioOrganizador;
import utilidades.Utilidades;
import utilidades.ViewUtil;
import vista.paneles.VisualizacionCarrerasPanel;
import vista.paneles.admin.BorradoUsuario;
import vista.paneles.admin.DeleteCarreraAdminPanel;
import vista.paneles.admin.ModificacionCarreraAdmin;
import vista.paneles.admin.ModificacionUsuarioAdmin;

public class AdminView extends JFrame implements ActionListener, ViewUtil{
	
	private ManagerBd manager;
	private Utilidades util = new Utilidades();
	
	private ModificacionCarreraAdmin panelModificacionCarrera = new ModificacionCarreraAdmin();
	private VisualizacionCarrerasPanel panelVisualizacion;
	private BorradoUsuario panelBorradoUsuario = new BorradoUsuario();
	private DeleteCarreraAdminPanel panelBorradoCarrera = new DeleteCarreraAdminPanel();
	private ModificacionUsuarioAdmin panelModificacionUsuario = new ModificacionUsuarioAdmin();
	
	
	private JMenuItem mnVisualizarCarreras, mnModificarCarreras, 
					mnEliminarCarreras, mnModificarUsuarios, mnEliminarUsuarios;
	
	// Referencias panel BorradoUsuario
	private JComboBox<String> borradoComboTipoUsuario = panelBorradoUsuario.getComboTipo();
	private JComboBox<Object> borradoComboEmailUsuario = panelBorradoUsuario.getComboEmail();
	private JButton btnBorradoUsuario = panelBorradoUsuario.getBtnBorrar();
	
	private static final long serialVersionUID = 1L;

	public AdminView(final ManagerBd manager) {
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
		
		mnVisualizarCarreras = new JMenuItem("Visualizar Carreras");
		mntCarreras.add(mnVisualizarCarreras);
		
		mnModificarCarreras = new JMenuItem("Modificar Carreras");
		mntCarreras.add(mnModificarCarreras);
		
		mnEliminarCarreras = new JMenuItem("Eliminar Carreras");
		mntCarreras.add(mnEliminarCarreras);
		
		JMenu mntUsuarios = new JMenu("Gestion Usuarios");
		menuBar.add(mntUsuarios);
		
		mnModificarUsuarios = new JMenuItem("Modificar Usuarios");
		mntUsuarios.add(mnModificarUsuarios);
		
		mnEliminarUsuarios = new JMenuItem("Eliminar Usuarios");
		mntUsuarios.add(mnEliminarUsuarios);
		
		
		mnVisualizarCarreras.addActionListener(this);
		mnModificarCarreras.addActionListener(this);
		mnEliminarCarreras.addActionListener(this);
		
		
		mnModificarUsuarios.addActionListener(this);
		mnEliminarUsuarios.addActionListener(this);
		
		
		btnBorradoUsuario.addActionListener(this);
		borradoComboTipoUsuario.addActionListener(this);
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

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() == mnVisualizarCarreras){
			
			changePanel(panelVisualizacion);
			
		}else if(e.getSource() == mnModificarCarreras){
			
			changePanel(panelModificacionCarrera);
			
		}else if(e.getSource() == mnEliminarCarreras){
			
			changePanel(panelBorradoCarrera);
			
		}else if(e.getSource() == mnModificarUsuarios){
			
			changePanel(panelModificacionUsuario);
			
		}else if(e.getSource() == mnEliminarUsuarios){
			changePanel(panelBorradoUsuario);
			borradoComboTipoUsuario.setSelectedItem("Normal");
		} 
		
		// action listener panel borrado usuario
		if(e.getSource() == btnBorradoUsuario){
			borrarUsuario();
		}else if(e.getSource() == borradoComboTipoUsuario){
			changeComboTipoBorrado();
		}
		
	}
	
	private void changeComboTipoBorrado(){
		borradoComboEmailUsuario.removeAllItems();
		if (borradoComboTipoUsuario.getSelectedItem().equals("Normal")) {

			ArrayList<UsuarioEstandar> arrU = new ArrayList<UsuarioEstandar>();
			try {
				arrU = manager.consultarEmailNormal();
			} catch (Exception e1) {
				e1.printStackTrace();
			}

			for (UsuarioEstandar u : arrU) {
				borradoComboEmailUsuario.addItem(u.getEmailUsuario());
			}

		} else {

			ArrayList<UsuarioOrganizador> arrU = new ArrayList<>();
			try {
				arrU = manager.consultarEmailOrg();
			} catch (Exception e1) {
				e1.printStackTrace();
			}

			for (UsuarioOrganizador u : arrU) {
				borradoComboEmailUsuario.addItem(u.getEmailUsuario());
			}
		}
	}
	
	private void borrarUsuario(){
		if (borradoComboTipoUsuario.getSelectedItem().equals("Normal")) {

			try {
				UsuarioEstandar uStd = new UsuarioEstandar();
				uStd.setNbUsuario("");
				uStd.setApellidosUsuario("");
				uStd.setEmailUsuario(borradoComboEmailUsuario.getSelectedItem().toString());
				uStd.setPassUsuario("");
				uStd.setDirUsuario("");
				uStd.setTelfUsuario(0);
				uStd.setClubUsuario("");
				int filas = manager.deleteUsuarioNormal(uStd);
				util.createInfobox("Se han eliminado " + filas + " de la base de datos.", "Borrado completado");
				borradoComboEmailUsuario.removeItem(uStd.getEmailUsuario());
			} catch (Exception ex) {
				util.createErrorbox("No se ha podido borrar el usuario", "Borrado no completado");
			}

		} else {

			try {
				UsuarioOrganizador uOrg = new UsuarioOrganizador();

				uOrg.setNbUsuario("");
				uOrg.setApellidosUsuario("");
				uOrg.setEmailUsuario(borradoComboEmailUsuario.getSelectedItem().toString());
				uOrg.setPassUsuario("");
				uOrg.setDirUsuario("");
				uOrg.setTelfUsuario(0);
				uOrg.setClubUsuario("");
				int filas = manager.deleteUsuarioOrganizador(uOrg);
				util.createInfobox("Se han eliminado " + filas + " de la base de datos.", "Borrado completado");
				borradoComboEmailUsuario.removeItem(uOrg.getEmailUsuario());
			} catch (Exception ex) {
				util.createErrorbox("No se ha podido borrar el usuario", "Borrado no completado");
			}

		}
	}
}
