package co.edu.unbosque.view;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class JDialogPersonal extends JDialog implements GabenDialog {
	private static final long serialVersionUID = 1L;
	private JLabel labelpersonal = new JLabel("Informacion Personal:");
	private JButton botonMostrar = new JButton("Mostrar informacion");
	private JButton botonCancelar = new JButton("Cancelar");
	private JTextField textpersonal = new JTextField("");
	public static final String MOSTRAR= "mostrarpersonal";
	public static final String CANCELAR = "cancelarpersonal";
    
	public JDialogPersonal() {
		try {
			load();
			addComponents();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void load() {
		setTitle("Informacion Personal");
		setSize(800,400);
		
		setResizable(false);
		setLocationRelativeTo(null);
		setLayout(null);
		setBackground(Color.BLACK);
		

		labelpersonal.setBounds(50, 100, 200, 50);
		textpersonal.setBounds(250, 115, 500, 25);
		textpersonal.setEditable(false);
		labelpersonal.setForeground(Color.BLACK);

		botonMostrar.setBounds(200,200, 200, 50);
		botonMostrar.setActionCommand(MOSTRAR);
		botonMostrar.setBackground(Color.BLACK);
		botonMostrar.setForeground(Color.WHITE);

		botonCancelar.setBounds(500, 200, 100, 50);
		botonCancelar.setActionCommand(CANCELAR);
		botonCancelar.setBackground(Color.BLACK);
		botonCancelar.setForeground(Color.WHITE);
		setVisible(false);
	}

	public void addComponents() {
		
		add(labelpersonal);
		add(textpersonal);
		add(botonMostrar);
		add(botonCancelar);

	}

	public JLabel getLabelpersonal() {
		return labelpersonal;
	}

	public void setLabelpersonal(JLabel labelpersonal) {
		this.labelpersonal = labelpersonal;
	}

	public JButton getBotonMostrar() {
		return botonMostrar;
	}

	public void setBotonMostrar(JButton botonMostrar) {
		this.botonMostrar = botonMostrar;
	}

	public JButton getBotonCancelar() {
		return botonCancelar;
	}

	public void setBotonCancelar(JButton botonCancelar) {
		this.botonCancelar = botonCancelar;
	}

	public JTextField getTextpersonal() {
		return textpersonal;
	}

	public void setTextpersonal(JTextField textpersonal) {
		this.textpersonal = textpersonal;
	}

	public String getMOSTRAR() {
		return MOSTRAR;
	}

	public String getCANCELAR() {
		return CANCELAR;
	}
	


}
