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
public class JDialogListar extends JDialog {
    private static final long serialVersionUID = 1L;
    private JTable tabla;
	private DefaultTableModel model;
	private JScrollPane scrollpane;
	private JButton Mostrar = new JButton("Mostrar");
	private JButton Cancelar = new JButton("Cancelar");
	private JButton Limpiar = new JButton("Limpiar");
	public final String MOSTRAR = "mostrardatos";
	public final String CANCELAR = "cancelarlista";
	public final String LIMPIAR = "Limpiarlista";
	private int counter = 0;
	
	public JDialogListar() {
		cargar();
		agregarcomponentes();
		panelbotones();
	}

	public void cargar() {
		
		
		setLayout(new BorderLayout());
		setTitle("Lista");
		setSize(800,600);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		setResizable(false);
		setLocationRelativeTo(null);
		setLayout(null);
		setBackground(Color.BLACK);
		/**
		 * TODO Cambiar los datos que se llenan en la tabla
		 */
	
		
		tabla = new JTable(new DefaultTableModel(new Object[] {"Correo", "Tienda", "Activa", "Dinero en cuenta"}, counter));
		model = (DefaultTableModel) tabla.getModel();
		tabla.setAutoscrolls(true);
		tabla.setColumnSelectionAllowed(false);
		scrollpane = new JScrollPane(tabla);
		scrollpane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		scrollpane.setViewportView(tabla);
		setLayout(new BorderLayout());
		counter++;
		
	}
	public void panelbotones()  {
		JPanel panelboton = new JPanel();
		panelboton.setLayout(new GridLayout(3,1));
		Mostrar.setBackground(Color.BLACK);
		Mostrar.setForeground(Color.WHITE);
		Limpiar.setBackground(Color.BLACK);
		Limpiar.setForeground(Color.WHITE);
		Cancelar.setBackground(Color.BLACK);
		Cancelar.setForeground(Color.WHITE);
		panelboton.add(Mostrar);
		panelboton.add(Limpiar);
		panelboton.add(Cancelar);
		add(panelboton, BorderLayout.EAST);
	}

	public void agregarcomponentes() {
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

	public JButton getMostrar() {
		return Mostrar;
	}

	public JButton getCancelar() {
		return Cancelar;
	}

	public JButton getLimpiar() {
		return Limpiar;
	}
}
