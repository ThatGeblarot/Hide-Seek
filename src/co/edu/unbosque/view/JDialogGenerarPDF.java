package co.edu.unbosque.view;

import java.awt.*;

import javax.swing.*;

/**
 * @author Ricardo Sanchez
 *
 */
public class JDialogGenerarPDF extends JDialog implements GabenDialog {

	private static final long serialVersionUID = 1L;
	private JButton botonGenerar = new JButton("Generar PDF");
	private JButton cancelar = new JButton("Cancelar");
	public final String PDF = "generarpdf", CANCELAR = "cancelarpdf";

	public JDialogGenerarPDF() {
		try {
			load();
			addComponents();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void load() {
		setTitle("Generar PDF");
		setSize(600, 200);
		

		setResizable(false);
		setLocationRelativeTo(null);
		setBackground(Color.BLACK);

		botonGenerar.setBounds(150, 50, 150, 50);
		botonGenerar.setBackground(Color.WHITE);
		botonGenerar.setActionCommand(PDF);

		cancelar.setBounds(350, 50, 100, 50);
		cancelar.setActionCommand(CANCELAR);
		cancelar.setBackground(Color.WHITE);

		setVisible(false);
	}

	public void addComponents() {

		add(botonGenerar);
		add(cancelar);

	}

	public JButton getBotonGenerar() {
		return botonGenerar;
	}

	public void setBotonGenerar(JButton botonGenerar) {
		this.botonGenerar = botonGenerar;
	}

	public JButton getCancelar() {
		return cancelar;
	}

	public void setCancelar(JButton cancelar) {
		this.cancelar = cancelar;
	}

	public String getPDF() {
		return PDF;
	}

	public String getCANCELAR() {
		return CANCELAR;
	}

}
