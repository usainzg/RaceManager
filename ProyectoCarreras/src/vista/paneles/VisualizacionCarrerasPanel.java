package vista.paneles;

import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;
import javax.swing.table.DefaultTableModel;

import bbdd.ManagerBd;
import clases.Carrera;

public class VisualizacionCarrerasPanel extends JPanel {
	
	private static final long serialVersionUID = 1L;
	private JTable table;
	private DefaultTableModel modelo;
	private ManagerBd manager;

	/**
	 * Create the panel.
	 */
	public VisualizacionCarrerasPanel(ManagerBd manager) {
		
		this.manager = manager;
		
		table = new JTable();
		table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		table.setFillsViewportHeight(true);
		table.setEnabled(false);
		table.setRowSelectionAllowed(false);
		JScrollPane sp = new JScrollPane(table);
		sp.setBounds(-2, 0, 520, 413);
		sp.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		modelo = new DefaultTableModel();

		modelo.addColumn("NOMBRE");
		modelo.addColumn("ORGANIZADOR");
		modelo.addColumn("DISTANCIA");
		modelo.addColumn("DESNIVEL");
		modelo.addColumn("PRECIO");
		modelo.addColumn("FECHA");
		modelo.addColumn("LUGAR");

		
		setLayout(null);
		table.setModel(modelo);

		add(sp);
		table.setAutoCreateRowSorter(true);
		
		rellenarTabla();
	}
	
	private void rellenarTabla(){
		ArrayList<Carrera> carreras;
		try {
			carreras = manager.consultarCarreras();

			for (Carrera c : carreras) {
				Object[] fila = new Object[7];
				fila[0] = c.getNbCarrera();
				fila[1] = c.getOrgCarrera().getNbUsuario();
				fila[2] = c.getDistanciaCarrera();
				fila[3] = c.getDesnivelCarrera();
				fila[4] = c.getPrecioCarrera();
				fila[5] = c.getFechaCarrera();
				fila[6] = c.getLugarCarrera();

				modelo.addRow(fila);
			}

		} catch (Exception e1) {
			e1.printStackTrace();
		}
	}

}

