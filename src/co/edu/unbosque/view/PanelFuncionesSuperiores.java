package co.edu.unbosque.view;

import javax.swing.*;
import java.awt.*;

public class PanelFuncionesSuperiores extends JPanel implements GabenPanel{

	private static final long serialVersionUID = 1L;
	//private JSeparator separador = new JSeparator();
	private JMenuBar tooltip = new JMenuBar();
	private JMenu archivo = new JMenu("Archivo"), ayuda = new JMenu("Ayuda");
	private JMenuItem nuevo = new JMenuItem("Nuevo"), guardar = new JMenuItem("Guardar"), cargar = new JMenuItem("Cargar"), acercaDe = new JMenuItem("Acerca De"), salir = new JMenuItem("Salir"), cerrarSesion = new JMenuItem("Cerrar Sesion");
	public static final String NUEVOARCHIVO = "NuevoArchivoFrame", GUARDAR = "GuardarArchivoFrame", CARGAR = "CargarArchivoFrame", ACERCADE = "AcercaDeArchivoFrame", SALIR = "SalirFrame", CERRARSESION = "CERRARSESIONFrame";
	
	public PanelFuncionesSuperiores() {
		load();
		addComponents();
	}
	
	public void load() {
		setLayout(new BorderLayout());
		setBackground(Color.WHITE);
		nuevo.setActionCommand(NUEVOARCHIVO);
		guardar.setActionCommand(GUARDAR);
		cargar.setActionCommand(CARGAR);
		acercaDe.setActionCommand(ACERCADE);
		salir.setActionCommand(SALIR);
		cerrarSesion.setActionCommand(CERRARSESION);
	}
	
	public void addComponents() {
		add(tooltip, BorderLayout.CENTER);
		tooltip.add(archivo); tooltip.add(ayuda);
		archivo.add(cerrarSesion); archivo.addSeparator(); archivo.add(salir);
		//archivo.add(nuevo); archivo.add(separador); archivo.add(guardar); archivo.add(cargar); archivo.add(separador); archivo.add(salir);
		ayuda.add(acercaDe);
	}

	public JMenuItem getNuevo() {
		return nuevo;
	}

	public JMenuItem getGuardar() {
		return guardar;
	}

	public JMenuItem getCargar() {
		return cargar;
	}

	public JMenuItem getAcercaDe() {
		return acercaDe;
	}

	public JMenuItem getSalir() {
		return salir;
	}

	public JMenuItem getCerrarSesion() {
		return cerrarSesion;
	}
	
}
