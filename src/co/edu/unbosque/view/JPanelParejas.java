package co.edu.unbosque.view;

import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 * @author Ricardo Sanchez
 *
 */
public class JPanelParejas extends JPanel implements GabenPanel {

	private static final long serialVersionUID = 1L;
	private JButton botonEliminarDatos = new JButton("Eliminar datos cuenta");
	private JButton botonActualizarDatos = new JButton("Actualizar Datos ");
	private JButton botonHacerPago = new JButton("Realizar Pago");
	private JButton botonDatos = new JButton("Informacion personal");
	public static final String DATOS = "parejas mostrar datos";
	public static final String ELIMINARDATOS = "parejas eliminar datos";
	public static final String ACTUALIZARDATOS = "parejas actualizar Datos";
	public static final String HACERPAGO = "parejas hacer pago";
	public static final String LISTAAFILIADOS = "parejas lista afiliados";

	public JPanelParejas() {
		load();
		addComponents();
	}

	public void load() {
		setLayout(null);

		botonActualizarDatos.setBounds(175, 25, 200, 50);
		botonActualizarDatos.setActionCommand(ACTUALIZARDATOS);
		botonActualizarDatos.setBackground(Color.WHITE);

		botonDatos.setBounds(425, 25, 200, 50);
		botonDatos.setActionCommand(DATOS);
		botonDatos.setBackground(Color.WHITE);

		botonHacerPago.setBounds(175, 100, 200, 50);
		botonHacerPago.setActionCommand(HACERPAGO);
		botonHacerPago.setBackground(Color.WHITE);

		botonEliminarDatos.setBounds(425, 100, 200, 50);
		botonEliminarDatos.setActionCommand(ELIMINARDATOS);
		botonEliminarDatos.setBackground(Color.WHITE);

		setBackground(Color.BLUE);

		setVisible(false);
	}

	public void addComponents() {
		add(botonDatos);
		add(botonEliminarDatos);
		add(botonActualizarDatos);
		add(botonHacerPago);

	}

	public JButton getBotonEliminarPareja() {
		return botonEliminarDatos;
	}

	public void setBotonEliminarPareja(JButton botonEliminarPareja) {
		this.botonEliminarDatos = botonEliminarPareja;
	}

	public JButton getBotonActualizarDatos() {
		return botonActualizarDatos;
	}

	public void setBotonActualizarDatos(JButton botonActualizarDatos) {
		this.botonActualizarDatos = botonActualizarDatos;
	}

	public JButton getBotonHacerPago() {
		return botonHacerPago;
	}

	public void setBotonHacerPago(JButton botonHacerPago) {
		this.botonHacerPago = botonHacerPago;
	}

	public String getELIMINARPAREJA() {
		return ELIMINARDATOS;
	}

	public String getACTUALIZARDATOS() {
		return ACTUALIZARDATOS;
	}

	public String getHACERPAGO() {
		return HACERPAGO;
	}

	public JButton getBotonEliminarDatos() {
		return botonEliminarDatos;
	}

	public void setBotonEliminarDatos(JButton botonEliminarDatos) {
		this.botonEliminarDatos = botonEliminarDatos;
	}

	public JButton getBotonDatos() {
		return botonDatos;
	}

	public void setBotonDatos(JButton botonDatos) {
		this.botonDatos = botonDatos;
	}

	public String getDATOS() {
		return DATOS;
	}

	public String getELIMINARDATOS() {
		return ELIMINARDATOS;
	}

	public String getLISTAAFILIADOS() {
		return LISTAAFILIADOS;
	}
}
