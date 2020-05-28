package co.edu.unbosque.view;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 * @author Ricardo Sanchez
 *
 */
public class JDialogBuscador extends JDialog implements GabenDialog {
	private static final long serialVersionUID = 1L;
	private JLabel labelBuscador = new JLabel("Buscador:");
	private JButton botonBuscar = new JButton("Buscar");
	private JButton botonCancelar = new JButton("Cancelar");
	private JTextField textbuscador = new JTextField("");
	public final String BUSCAR= "buscar";
	public final String CANCELAR = "cancelarbuscar";
    
	public JDialogBuscador() {
		try {
			load();
			addComponents();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void load() {
		setLayout(new BorderLayout());
		setTitle("Buscador");
		setSize(600,400);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		setResizable(false);
		setLocationRelativeTo(null);
		setLayout(null);
		setBackground(Color.BLACK);
		

		labelBuscador.setBounds(150, 100, 100, 50);
		textbuscador.setBounds(250, 115, 200, 25);
		labelBuscador.setForeground(Color.BLACK);

		botonBuscar.setBounds(50,200, 200, 50);
		botonBuscar.setActionCommand(BUSCAR);
		botonBuscar.setBackground(Color.BLACK);
		botonBuscar.setForeground(Color.WHITE);

		botonCancelar.setBounds(300, 200, 200, 50);
		botonCancelar.setActionCommand(CANCELAR);
		botonCancelar.setBackground(Color.BLACK);
		botonCancelar.setForeground(Color.WHITE);
		setVisible(false);
	}

	public void addComponents() {
		
		add(labelBuscador);
		add(textbuscador);
		add(botonBuscar);
		add(botonCancelar);

	}
	public void clean() {
		textbuscador.setText("");
	}

	public JLabel getLabelBuscador() {
		return labelBuscador;
	}

	public void setLabelBuscador(JLabel labelBuscador) {
		this.labelBuscador = labelBuscador;
	}

	public JButton getBotonBuscar() {
		return botonBuscar;
	}

	public void setBotonBuscar(JButton botonBuscar) {
		this.botonBuscar = botonBuscar;
	}

	public JButton getBotonCancelar() {
		return botonCancelar;
	}

	public void setBotonCancelar(JButton botonCancelar) {
		this.botonCancelar = botonCancelar;
	}

	public JTextField getTextbuscador() {
		return textbuscador;
	}

	public void setTextbuscador(JTextField textbuscador) {
		this.textbuscador = textbuscador;
	}

	public String getBUSCAR() {
		return BUSCAR;
	}

	public String getCANCELAR() {
		return CANCELAR;
	}
	

}
