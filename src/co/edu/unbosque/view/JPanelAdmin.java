package co.edu.unbosque.view;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JPanel;

/**
 * @author Ricardo Sanchez
 *
 */
public class JPanelAdmin extends JPanel implements GabenPanel {
	private static final long serialVersionUID = 1L;
	private JButton botonAgregarUsuario = new JButton("Agregar Usuarios");
	private JButton botonEliminarUsuario = new JButton("Eliminar Usuarios");
	private JButton botonMostrarSurcursal = new JButton("Mostrar Compras Sucursales");
	private JButton botonListaUsuario = new JButton("Lista Usuarios");
	private JButton botonActualizarDatos = new JButton("Actualizar Datos Usuarios");
	private JButton botonAsignarCupoUsuario = new JButton("Asignar cupo Usuario");
	private JButton botonAsignarHorarioUsuario = new JButton("Asignar Horario y Ubicacion Usuario");
	private JButton botonHacerPago = new JButton("Realizar Pago Usuario");
	public static final String AGREGARUSUARIO = "agregar Usuario";
	public static final String ELIMINARUSUARIOS = "eliminar Usuario";
	public static final String ACTUALIZARUSUARIOS = "actualizar Usuario";
	public static final String LISTAUSUARIOS = "Lista Usuario";
	public static final String ACTUALIZARDATOSUSUARIOS = "Actualizar Datos Usuarios";
	public static final String ASIGNARCUPO = "Asignar Cupo";
	public static final String ASIGNARHORARIO = "Asignar Horario";
	public static final String HACERPAGO = "Hacer Pago";
	public static final String HORARIO = "horarioausuario";
	public static final String SUCURSALES = "mostrar sucursales";

	public JPanelAdmin() {
		load();
		addComponents();
	}

	public void load() {
		setLayout(null);

		botonAgregarUsuario.setBounds(9, 30, 250, 50);
		botonAgregarUsuario.setActionCommand(AGREGARUSUARIO);
		botonAgregarUsuario.setBackground(Color.WHITE);

		botonEliminarUsuario.setBounds(270, 30, 250, 50);
		botonEliminarUsuario.setActionCommand(ELIMINARUSUARIOS);
		botonEliminarUsuario.setBackground(Color.WHITE);

		botonActualizarDatos.setBounds(530, 30, 250, 50);
		botonActualizarDatos.setActionCommand(ACTUALIZARDATOSUSUARIOS);
		botonActualizarDatos.setBackground(Color.WHITE);

		botonMostrarSurcursal.setBounds(9, 100, 250, 50);
		botonMostrarSurcursal.setActionCommand(SUCURSALES);
		botonMostrarSurcursal.setBackground(Color.WHITE);

		botonListaUsuario.setBounds(270, 100, 250, 50);
		botonListaUsuario.setActionCommand(LISTAUSUARIOS);
		botonListaUsuario.setBackground(Color.WHITE);

		botonAsignarCupoUsuario.setBounds(530, 100, 250, 50);
		botonAsignarCupoUsuario.setActionCommand(ASIGNARCUPO);
		botonAsignarCupoUsuario.setBackground(Color.WHITE);

		setBackground(Color.RED);

		setVisible(false);
	}

	public void addComponents() {
		add(botonMostrarSurcursal);
		add(botonAgregarUsuario);
		add(botonEliminarUsuario);
		add(botonListaUsuario);
		add(botonActualizarDatos);
		add(botonHacerPago);
		add(botonAsignarCupoUsuario);
		add(botonAsignarHorarioUsuario);
	}

	public JButton getBotonMostrarSurcursal() {
		return botonMostrarSurcursal;
	}

	public void setBotonMostrarSurcursal(JButton botonMostrarSurcursal) {
		this.botonMostrarSurcursal = botonMostrarSurcursal;
	}

	public String getHORARIO() {
		return HORARIO;
	}

	public String getSUCURSALES() {
		return SUCURSALES;
	}

	public JButton getBotonAgregarUsuario() {
		return botonAgregarUsuario;
	}

	public void setBotonAgregarUsuario(JButton botonAgregarUsuario) {
		this.botonAgregarUsuario = botonAgregarUsuario;
	}

	public JButton getBotonEliminarUsuario() {
		return botonEliminarUsuario;
	}

	public void setBotonEliminarUsuario(JButton botonEliminarUsuario) {
		this.botonEliminarUsuario = botonEliminarUsuario;
	}

	public JButton getBotonListaUsuario() {
		return botonListaUsuario;
	}

	public void setBotonListaUsuario(JButton botonListaUsuario) {
		this.botonListaUsuario = botonListaUsuario;
	}

	public JButton getBotonActualizarDatos() {
		return botonActualizarDatos;
	}

	public void setBotonActualizarDatos(JButton botonActualizarDatos) {
		this.botonActualizarDatos = botonActualizarDatos;
	}

	public JButton getBotonAsignarCupoUsuario() {
		return botonAsignarCupoUsuario;
	}

	public void setBotonAsignarCupoUsuario(JButton botonAsignarCupoUsuario) {
		this.botonAsignarCupoUsuario = botonAsignarCupoUsuario;
	}

	public JButton getBotonAsignarHorarioUsuario() {
		return botonAsignarHorarioUsuario;
	}

	public void setBotonAsignarHorarioUsuario(JButton botonAsignarHorarioUsuario) {
		this.botonAsignarHorarioUsuario = botonAsignarHorarioUsuario;
	}

	public JButton getBotonHacerPago() {
		return botonHacerPago;
	}

	public void setBotonHacerPago(JButton botonHacerPago) {
		this.botonHacerPago = botonHacerPago;
	}

	public String getAGREGARUSUARIO() {
		return AGREGARUSUARIO;
	}

	public String getELIMINARUSUARIOS() {
		return ELIMINARUSUARIOS;
	}

	public String getACTUALIZARUSUARIOS() {
		return ACTUALIZARUSUARIOS;
	}

	public String getLISTAUSUARIOS() {
		return LISTAUSUARIOS;
	}

	public String getACTUALIZARDATOSUSUARIOS() {
		return ACTUALIZARDATOSUSUARIOS;
	}

	public String getASIGNARCUPO() {
		return ASIGNARCUPO;
	}

	public String getASIGNARHORARIO() {
		return ASIGNARHORARIO;
	}

	public String getHACERPAGO() {
		return HACERPAGO;
	}

}
