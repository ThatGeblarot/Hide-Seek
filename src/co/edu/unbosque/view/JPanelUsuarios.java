package co.edu.unbosque.view;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JPanel;

/**
 * @author Ricardo Sanchez
 *
 */
public class JPanelUsuarios extends JPanel implements GabenPanel {
	private static final long serialVersionUID = 1L;
	private JButton botonAgregarPareja = new JButton("Agregar Pareja");
	private JButton botonEliminarPareja = new JButton("Eliminar Pareja");
	private JButton botonActualizarPareja = new JButton("Actualizar Pareja");
	private JButton botonListaParejas = new JButton("Lista Parejas");
	private JButton botonActualizarDatos = new JButton("Actualizar Datos Usuario");
	private JButton botonAsignarCupo = new JButton("Asignar cupo Pareja");
	private JButton botonAsignarHorario = new JButton("Asignar Horario y Ubicacion");
	private JButton botonMostrarcompras = new JButton("Mostrar Compras");
	private JButton botonAsignarHorarioUsuario = new JButton("Asignar Horario y Ubicacion ");
	public static final String AGREGARPAREJA = "agregar pareja";
	public static final String ELIMINARPAREJA = "eliminar pareja";
	public static final String ACTUALIZARPAREJA = "actualizar pareja";
	public static final String LISTAPAREJAS = "Lista Pareja";
	public static final String ACTUALIZARDATOS = "Actualizar Datos";
	public static final String ASIGNARCUPO = "AsignarCupo";
	public static final String ASIGNARHORARIO = "Asignar Horario";
	public static final String COMPRAS = "mostrarcompras";
	public static final String HORARIO = "horario";

	public JPanelUsuarios() {
		load();
		addComponents();
	}

	public void load() {
		setLayout(null);

		botonAgregarPareja.setBounds(75, 10, 200, 50);
		botonAgregarPareja.setActionCommand(AGREGARPAREJA);
		botonAgregarPareja.setBackground(Color.WHITE);

		botonEliminarPareja.setBounds(300, 10, 200, 50);
		botonEliminarPareja.setActionCommand(ELIMINARPAREJA);
		botonEliminarPareja.setBackground(Color.WHITE);

		botonActualizarPareja.setBounds(525, 10, 200, 50);
		botonActualizarPareja.setActionCommand(ACTUALIZARPAREJA);
		botonActualizarPareja.setBackground(Color.WHITE);

		botonListaParejas.setBounds(75, 70, 200, 50);
		botonListaParejas.setActionCommand(LISTAPAREJAS);
		botonListaParejas.setBackground(Color.WHITE);

		botonAsignarCupo.setBounds(300, 70, 200, 50);
		botonAsignarCupo.setActionCommand(ASIGNARCUPO);
		botonAsignarCupo.setBackground(Color.WHITE);

		botonAsignarHorarioUsuario.setBounds(525, 70, 200, 50);
		botonAsignarHorarioUsuario.setActionCommand(HORARIO);
		botonAsignarHorarioUsuario.setBackground(Color.WHITE);

		botonMostrarcompras.setBounds(300, 130, 200, 50);
		botonMostrarcompras.setActionCommand(COMPRAS);
		botonMostrarcompras.setBackground(Color.WHITE);

		setBackground(Color.MAGENTA);

		setVisible(false);
	}

	public void addComponents() {
		add(botonMostrarcompras);
		add(botonAgregarPareja);
		add(botonEliminarPareja);
		add(botonListaParejas);
		add(botonActualizarPareja);
		add(botonAsignarCupo);
		add(botonAsignarHorarioUsuario);
	}

	public JButton getBotonAgregarPareja() {
		return botonAgregarPareja;
	}

	public void setBotonAgregarPareja(JButton botonAgregarPareja) {
		this.botonAgregarPareja = botonAgregarPareja;
	}

	public JButton getBotonEliminarPareja() {
		return botonEliminarPareja;
	}

	public void setBotonEliminarPareja(JButton botonEliminarPareja) {
		this.botonEliminarPareja = botonEliminarPareja;
	}

	public JButton getBotonActualizarPareja() {
		return botonActualizarPareja;
	}

	public void setBotonActualizarPareja(JButton botonActualizarPareja) {
		this.botonActualizarPareja = botonActualizarPareja;
	}

	public JButton getBotonListaParejas() {
		return botonListaParejas;
	}

	public void setBotonListaParejas(JButton botonListaParejas) {
		this.botonListaParejas = botonListaParejas;
	}

	public JButton getBotonActualizarDatos() {
		return botonActualizarDatos;
	}

	public void setBotonActualizarDatos(JButton botonActualizarDatos) {
		this.botonActualizarDatos = botonActualizarDatos;
	}

	public JButton getBotonAsignarCupo() {
		return botonAsignarCupo;
	}

	public void setBotonAsignarCupo(JButton botonAsignarCupo) {
		this.botonAsignarCupo = botonAsignarCupo;
	}

	public JButton getBotonAsignarHorario() {
		return botonAsignarHorario;
	}

	public void setBotonAsignarHorario(JButton botonAsignarHorario) {
		this.botonAsignarHorario = botonAsignarHorario;
	}

	public String getAGREGARPAREJA() {
		return AGREGARPAREJA;
	}

	public String getELIMINARPAREJA() {
		return ELIMINARPAREJA;
	}

	public String getACTUALIZARPAREJA() {
		return ACTUALIZARPAREJA;
	}

	public String getLISTAPAREJAS() {
		return LISTAPAREJAS;
	}

	public String getACTUALIZARDATOS() {
		return ACTUALIZARDATOS;
	}

	public String getASIGNARCUPO() {
		return ASIGNARCUPO;
	}

	public String getASIGNARHORARIO() {
		return ASIGNARHORARIO;
	}

	public JButton getBotonMostrarcompras() {
		return botonMostrarcompras;
	}

	public void setBotonMostrarcompras(JButton botonMostrarcompras) {
		this.botonMostrarcompras = botonMostrarcompras;
	}

	public JButton getBotonAsignarHorarioUsuario() {
		return botonAsignarHorarioUsuario;
	}

	public void setBotonAsignarHorarioUsuario(JButton botonAsignarHorarioUsuario) {
		this.botonAsignarHorarioUsuario = botonAsignarHorarioUsuario;
	}

	public String getCOMPRAS() {
		return COMPRAS;
	}

	public String getHORARIO() {
		return HORARIO;
	}
}
