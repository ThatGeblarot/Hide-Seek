package co.edu.unbosque.view;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
/**
 * @author Ricardo Sanchez
 *
 */
public class JDialogMostrarComprasSucursales extends JDialog {
	 private static final long serialVersionUID = 1L;
	    private JLabel labelsucursal = new JLabel("Escoja la Sucursal");
	    private JTextArea arealog = new JTextArea();
	    private JScrollPane scroll = new JScrollPane();
	    private JComboBox<String> sucursal = new JComboBox<String>();
	    private JButton botonmostrardatos = new JButton("Ver Datos");
	    private JButton botoncancelar= new JButton("Cancelar");
		public final String INFORMACION= "informacion";
		public final String CANCELAR = "cancelarinformacion";
	    
		public JDialogMostrarComprasSucursales() {
			try {
				cargar();
				addComponentes();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		public void cargar() throws Exception {
			setLayout(null);
			setTitle("Mostrar Compras");
			setSize(800,600);
			setDefaultCloseOperation(DISPOSE_ON_CLOSE);
			
			setResizable(false);
			setLocationRelativeTo(null);
			setLayout(null);
			setBackground(Color.BLACK);
			
			arealog.setBounds(25, 25,500 , 500);
			arealog.setBackground(Color.WHITE);
			arealog.setEditable(false);
			arealog.setWrapStyleWord(true);
			arealog.setLineWrap(true);
			arealog.setAutoscrolls(true);
			
			scroll = new JScrollPane(arealog);
			scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
			scroll.setViewportView(arealog);
			scroll.setBounds(25, 25,500 , 500);
			
			labelsucursal.setBounds(550, 80, 200, 50);
			sucursal.setBounds(550, 120, 200, 50);
			sucursal.setBackground(Color.WHITE);
			
			botonmostrardatos.setBounds(550, 200, 200, 50);
			botonmostrardatos.setActionCommand(INFORMACION);
			botonmostrardatos.setBackground(Color.WHITE);
			
			botoncancelar.setBounds(600, 300, 100, 50);
			botoncancelar.setActionCommand(CANCELAR);
			botoncancelar.setBackground(Color.WHITE);
			
			

			
			setVisible(false);
		}

		public void addComponentes() {
			add(scroll);
			add(botonmostrardatos);
			add(botoncancelar);
			add(labelsucursal);
			add(sucursal);

		}
		public void clean() {
			arealog.setText("");
		}
        
		public JLabel getLabelsucursal() {
			return labelsucursal;
		}

		public void setLabelsucursal(JLabel labelsucursal) {
			this.labelsucursal = labelsucursal;
		}

		public JTextArea getArealog() {
			return arealog;
		}

		public void setArealog(JTextArea arealog) {
			this.arealog = arealog;
		}

		public JScrollPane getScroll() {
			return scroll;
		}

		public void setScroll(JScrollPane scroll) {
			this.scroll = scroll;
		}

		public JComboBox<String> getSucursal() {
			return sucursal;
		}

		public void setSucursal(JComboBox<String> sucursal) {
			this.sucursal = sucursal;
		}

		public JButton getBotonmostrardatos() {
			return botonmostrardatos;
		}

		public void setBotonmostrardatos(JButton botonmostrardatos) {
			this.botonmostrardatos = botonmostrardatos;
		}

		public JButton getBotoncancelar() {
			return botoncancelar;
		}

		public void setBotoncancelar(JButton botoncancelar) {
			this.botoncancelar = botoncancelar;
		}

		public String getINFORMACION() {
			return INFORMACION;
		}

		public String getCANCELAR() {
			return CANCELAR;
		}
		


}
