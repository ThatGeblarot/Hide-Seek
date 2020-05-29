package co.edu.unbosque.view;


import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JDialog;

import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 * @author Ricardo Sanchez
 *
 */
public class JDialogMostrarCompras extends JDialog implements GabenDialog{
    private static final long serialVersionUID = 1L;
    private JTextArea arealog = new JTextArea();
    private JScrollPane scroll = new JScrollPane();
    private JButton botonmostrardatos = new JButton("Ver Datos");
    private JButton botoncancelar= new JButton("Cancelar");
    private JButton botonOrdenaras = new JButton("Ordenar Ascendente");
    private JButton botonOrdenardes = new JButton("Ordenar Descendente");
	public final String INFORMACION= "Informacioncompras";
	public final String CANCELAR = "cancelarcompras";
	public final String ORDENADAS = "ordenarascendente";
	public final String ORDENARDES = "ordenardescendente";
    
	public JDialogMostrarCompras() {
		try {
			load();
			addComponents();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void load() {
		setLayout(null);
		setTitle("Mostrar Compras");
		setSize(800,600);
	
		
		setResizable(false);
		setLocationRelativeTo(null);
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
		
		botonOrdenaras.setBounds(550, 100, 200, 50);
		botonOrdenaras.setActionCommand(ORDENADAS);
		botonOrdenaras.setBackground(Color.WHITE);
		
		botonOrdenardes.setBounds(550,200, 200, 50);
		botonOrdenardes.setActionCommand(ORDENARDES);
		botonOrdenardes.setBackground(Color.WHITE);
		
		botonmostrardatos.setBounds(550, 300, 200, 50);
		botonmostrardatos.setActionCommand(INFORMACION);
		botonmostrardatos.setBackground(Color.WHITE);
		
		botoncancelar.setBounds(550, 400, 200, 50);
		botoncancelar.setActionCommand(CANCELAR);
		botoncancelar.setBackground(Color.WHITE);
		
		

		
		setVisible(false);
	}

	public void addComponents() {
		add(botonOrdenaras);
		add(botonOrdenardes);
		add(scroll);
		add(botonmostrardatos);
		add(botoncancelar);
		
    
	}
	public JButton getBotonOrdenaras() {
		return botonOrdenaras;
	}

	public void setBotonOrdenaras(JButton botonOrdenaras) {
		this.botonOrdenaras = botonOrdenaras;
	}

	public JButton getBotonOrdenardes() {
		return botonOrdenardes;
	}

	public void setBotonOrdenardes(JButton botonOrdenardes) {
		this.botonOrdenardes = botonOrdenardes;
	}

	public String getORDENADAS() {
		return ORDENADAS;
	}

	public String getORDENARDES() {
		return ORDENARDES;
	}

	public void clean() {
		arealog.setText("");
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
