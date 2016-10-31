package vista;

import java.awt.BorderLayout;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import bbdd.ManagerBd;
import clases.Carrera;

public class VisualizacionCarrerasWindow extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	private DefaultTableModel modelo;
	private final ManagerBd mySql = new ManagerBd(null);

	/**
	 * Create the frame.
	 */
	public VisualizacionCarrerasWindow() {
		setTitle("Carreras");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 642, 462);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		table = new JTable();
		table.setEnabled(false);
		table.setRowSelectionAllowed(false);
		JScrollPane sp = new JScrollPane(table);
		sp.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		modelo = new DefaultTableModel();

		modelo.addColumn("NOMBRE");
		modelo.addColumn("ORGANIZADOR");
		modelo.addColumn("DISTANCIA");
		modelo.addColumn("DESNIVEL");
		modelo.addColumn("PRECIO");
		modelo.addColumn("FECHA");
		modelo.addColumn("LUGAR");

		ArrayList<Carrera> carreras;
		try {
			carreras = mySql.consultarCarreras();

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
		table.setModel(modelo);

		contentPane.add(sp);
		table.setAutoCreateRowSorter(true);
	}

}
