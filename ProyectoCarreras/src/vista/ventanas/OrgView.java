package vista.ventanas;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

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

public class OrgView extends JFrame implements ActionListener, ViewUtil {

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
		if (e.getSource() == mnVisualizacionCarreras) {

			VisualizacionCarrerasPanel panel = new VisualizacionCarrerasPanel(manager);
			changePanel(panel);

		} else if (e.getSource() == mnModificacionCarreras) {

			changePanel(panelModificacionCarreraOrg);
			initComboModificar();

		} else if (e.getSource() == mnBorrarCarrera) {

			changePanel(panelBorradoCarreraOrg);
			initComboBorrado();

		}

		if (e.getSource() == btnBorrarPanelBorrado) {

			borrarCarreraOrg();

		}

		if (e.getSource() == btnModificar) {

			modificarCarreraOrg();

		} else if (e.getSource() == btnLimpiar) {
			util.resetJTextField(txtDesnivel, txtDistancia, txtFecha, txtLugar, txtPrecio);
		}
	}

	private void initComboBorrado() {

		try {
			ArrayList<Carrera> carreras = manager.consultarCarrerasOrg(orgLogeado);
			for (Carrera c : carreras) {
				comboPanelBorrado.addItem(c.getNbCarrera());
			}
		} catch (Exception e) {
			util.createErrorbox("Error al recoger datos de la base de datos", "Error conexion base de datos");
		}

	}

	private void borrarCarreraOrg() {

		try {
			Carrera c = new Carrera(comboPanelBorrado.getSelectedItem().toString(), null, 0, 0, 0, "", "");
			int filas = manager.deleteCarrera(c);

			util.createInfobox("Se han borrado " + filas + " filas de la base de datos.", "Borrado completado");
			comboPanelBorrado.removeItem(c.getNbCarrera());

		} catch (Exception ex) {
			util.createErrorbox("No se ha podido borrar la carrera", "Borrado no completado");
		}
	}

	private void initComboModificar() {
		try {
			ArrayList<Carrera> carreras = manager.consultarCarrerasOrg(orgLogeado);
			for (Carrera c : carreras) {
				comboCarreraModificar.addItem(c.getNbCarrera());
			}
		} catch (Exception e) {
			util.createErrorbox("Error al recoger datos de la base de datos", "Error conexion base de datos");
		}
	}

	private void modificarCarreraOrg() {

		if (util.isValidDate(txtFecha)) {
			try {

				Carrera cNueva = new Carrera();
				cNueva.setNbCarrera(comboCarreraModificar.getSelectedItem().toString());
				cNueva.setOrgCarrera(null);
				cNueva.setDistanciaCarrera(Integer.parseInt(txtDistancia.getText()));
				cNueva.setDesnivelCarrera(Integer.parseInt(txtDesnivel.getText()));
				cNueva.setPrecioCarrera(Integer.parseInt(txtPrecio.getText()));

				SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
				String str = txtFecha.getText();

				try {
					Date date = formatter.parse(str);
					String formateado = formatter.format(date);
					cNueva.setFechaCarrera(formateado);
				} catch (Exception ex) {
					ex.printStackTrace();
				}

				cNueva.setLugarCarrera(txtLugar.getText());

				int filas = manager.updateCarrera(cNueva);
				util.createInfobox("Se han modificado " + filas + " filas de la base de datos.",
						"Modificacion no completada.");

			} catch (Exception ex) {
				ex.printStackTrace();
			}

		} else {
			util.createErrorbox("Revise los campos", "Fallo de formato");
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
