package vista.paneles;

import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;
import javax.swing.table.DefaultTableModel;

import bbdd.ManagerBd;
import clases.Carrera;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;

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
		modelo = new DefaultTableModel();

		modelo.addColumn("NOMBRE");
		modelo.addColumn("ORGANIZADOR");
		modelo.addColumn("DISTANCIA");
		modelo.addColumn("DESNIVEL");
		modelo.addColumn("PRECIO");
		modelo.addColumn("FECHA");
		modelo.addColumn("LUGAR");
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{460, 0};
		gridBagLayout.rowHeights = new int[]{413, 0};
		gridBagLayout.columnWeights = new double[]{0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		table = new JTable();
		table.setColumnSelectionAllowed(true);
		table.setCellSelectionEnabled(true);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		table.setFillsViewportHeight(true);
		table.setEnabled(false);
		table.setRowSelectionAllowed(false);
		JScrollPane sp = new JScrollPane(table);
		sp.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		table.setModel(modelo);
		
				GridBagConstraints gbc_sp = new GridBagConstraints();
				gbc_sp.fill = GridBagConstraints.BOTH;
				gbc_sp.gridx = 0;
				gbc_sp.gridy = 0;
				add(sp, gbc_sp);
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

