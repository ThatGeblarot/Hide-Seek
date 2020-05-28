package co.edu.unbosque.view;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JPanel;
 /**
  * 
  * @author Ricardo Sanchez
  *
  */
public class JPanelAdmin extends JPanel{
	private static final long serialVersionUID = 1L;
	private JButton botonAgregarUsuario  = new JButton ("Agregar Usuarios");
	private JButton botonEliminarUsuario = new JButton("Eliminar Usuarios");
	private JButton botonMostrarSurcursal = new JButton("Mostrar Compras Sucursales");
	private JButton botonListaUsuario  = new JButton ("Lista Usuarios");
	private JButton botonActualizarDatos = new JButton ("Actualizar Datos Usuarios");
	private JButton botonAsignarCupoUsuario= new JButton ("Asignar cupo Usuario");
	private JButton botonAsignarHorarioUsuario= new JButton ("Asignar Horario y Ubicacion Usuario");
	private JButton botonHacerPago = new JButton("Realizar Pago Usuario");
	private JButton botonGenerarPDF = new JButton("Generar PDF");
	private JButton botonEstadisticas = new JButton("Ver Estadisticas");
	public final String AGREGARUSUARIO="agregar Usuario";
	public final String ELIMINARUSUARIOS="eliminar Usuario";
	public final String ACTUALIZARUSUARIOS ="actualizar Usuario";
	public final String LISTAUSUARIOS= "Lista Usuario";
	public final String ACTUALIZARDATOSUSUARIOS = "Actualizar Datos Usuarios";
	public final String ASIGNARCUPO = "Asignar Cupo";
	public final String ASIGNARHORARIO = "Asignar Horario";
	public final String HACERPAGO = "Hacer Pago";
	public final String HORARIO="horarioausuario";
	public final String SUCURSALES="mostrar sucursales";
	public final String MOSTRARPDF ="jdialogpdf";
	public final String VERESTADISTICA = "ver estadisticas";

	public JPanelAdmin() {
		try {
			cargar();
			addComponentes();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void cargar() throws Exception {
		setLayout(null);
		
		botonAgregarUsuario.setBounds(9, 10, 250, 50);
		botonAgregarUsuario.setActionCommand(AGREGARUSUARIO);
		botonAgregarUsuario.setBackground(Color.WHITE);
		
		botonEliminarUsuario.setBounds(270,10,250,50);
		botonEliminarUsuario.setActionCommand(ELIMINARUSUARIOS);
		botonEliminarUsuario.setBackground(Color.WHITE);
		
		botonActualizarDatos.setBounds(530,10 ,250, 50);
		botonActualizarDatos.setActionCommand(ACTUALIZARDATOSUSUARIOS);
		botonActualizarDatos.setBackground(Color.WHITE);
		
		botonMostrarSurcursal.setBounds(9,80,250,50);
		botonMostrarSurcursal.setActionCommand(SUCURSALES);
		botonMostrarSurcursal.setBackground(Color.WHITE);
		
		botonListaUsuario.setBounds(270, 80, 250, 50);
		botonListaUsuario.setActionCommand(LISTAUSUARIOS);
		botonListaUsuario.setBackground(Color.WHITE);
		
		botonAsignarCupoUsuario.setBounds(530,80,250,50);
		botonAsignarCupoUsuario.setActionCommand(ASIGNARCUPO);
		botonAsignarCupoUsuario.setBackground(Color.WHITE);
		
		botonGenerarPDF.setBounds(100,140,250,40);
		botonGenerarPDF.setActionCommand(MOSTRARPDF);
		botonGenerarPDF.setBackground(Color.WHITE);
		
		botonEstadisticas.setBounds(450, 140, 250, 40);
		botonEstadisticas.setActionCommand(VERESTADISTICA);
		botonEstadisticas.setBackground(Color.WHITE);
		setBackground(Color.RED);

		

		setVisible(false);
	}

	public void addComponentes() {
		add(botonEstadisticas);
		add(botonGenerarPDF);
		add(botonMostrarSurcursal);
		add(botonAgregarUsuario);
		add(botonEliminarUsuario);
        add(botonListaUsuario);
        add(botonActualizarDatos);
        add(botonHacerPago);
        add(botonAsignarCupoUsuario);
        add(botonAsignarHorarioUsuario);
	}
    
	public JButton getBotonGenerarPDF() {
		return botonGenerarPDF;
	}

	public void setBotonGenerarPDF(JButton botonGenerarPDF) {
		this.botonGenerarPDF = botonGenerarPDF;
	}

	public String getMOSTRARPDF() {
		return MOSTRARPDF;
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
