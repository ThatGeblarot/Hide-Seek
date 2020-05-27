package co.edu.unbosque.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 * @author Ricardo Sanchez
 *
 */
public class JDialogAsignarCupo extends JDialog implements GabenDialog {
	private static final long serialVersionUID = 1L;
    private JTable tabla;
	private DefaultTableModel model;
	private JScrollPane scrollpane;
	private JButton Asignar = new JButton("Asignar");
	private JButton Cancelar = new JButton("Cancelar");
	private JButton Quitar = new JButton("Quitar");
	public final String ASIGNAR = "asignarcupo";
	public final String CANCELAR = "cancelarcupo";
	public final String QUITAR = "quitarcupo";
	private int counter = 0;

	public JDialogAsignarCupo() {
		load();
		addComponents();
		panelbotones();
	}

	public void load() {

		setLayout(new BorderLayout());
		setTitle("Asignar Cupo");
		setSize(800, 600);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);

		setResizable(false);
		setLocationRelativeTo(null);
		setLayout(null);
		setBackground(Color.BLACK);

		tabla = new JTable(
				new DefaultTableModel(new Object[] { "Correo", "Tienda", "Activa", "Efectivo" }, counter));
		model = (DefaultTableModel) tabla.getModel();
		tabla.setAutoscrolls(true);
		tabla.setColumnSelectionAllowed(false);
		scrollpane = new JScrollPane(tabla);
		scrollpane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		scrollpane.setViewportView(tabla);
		setLayout(new BorderLayout());
		counter++;
		setVisible(false);

	}

	public void panelbotones() {
		JPanel panelboton = new JPanel();
		panelboton.setLayout(new GridLayout(3, 1));
		Asignar.setBackground(Color.BLACK);
		Asignar.setActionCommand(ASIGNAR);
		Asignar.setForeground(Color.WHITE);
		Quitar.setBackground(Color.BLACK);
		Quitar.setActionCommand(QUITAR);
		Quitar.setForeground(Color.WHITE);
		Cancelar.setBackground(Color.BLACK);
		Cancelar.setActionCommand(CANCELAR);
		Cancelar.setForeground(Color.WHITE);
		panelboton.add(Asignar);
		panelboton.add(Quitar);
		panelboton.add(Cancelar);
		add(panelboton, BorderLayout.EAST);
	}

	public void addComponents() {
		add(scrollpane, BorderLayout.CENTER);

	}

	public void clean() {
		for (int i = 0; i < tabla.getRowCount(); i++) {
			model.removeRow(i);
		}
	}


	public JTable getTabla() {
		return tabla;
	}

	public DefaultTableModel getModel() {
		return model;
	}

	public JScrollPane getScrollpane() {
		return scrollpane;
	}

	public int getCounter() {
		return counter;
	}

	public JButton getAsignar() {
		return Asignar;
	}

	public void setAsignar(JButton asignar) {
		Asignar = asignar;
	}

	public JButton getCancelar() {
		return Cancelar;
	}

	public void setCancelar(JButton cancelar) {
		Cancelar = cancelar;
	}

	public JButton getQuitar() {
		return Quitar;
	}

	public void setQuitar(JButton quitar) {
		Quitar = quitar;
	}

	public String getASIGNAR() {
		return ASIGNAR;
	}

	public String getCANCELAR() {
		return CANCELAR;
	}

	public String getQUITAR() {
		return QUITAR;
	}

	public void setTabla(JTable tabla) {
		this.tabla = tabla;
	}

	public void setModel(DefaultTableModel model) {
		this.model = model;
	}

	public void setScrollpane(JScrollPane scrollpane) {
		this.scrollpane = scrollpane;
	}

	public void setCounter(int counter) {
		this.counter = counter;
	}

}
