package co.edu.unbosque.controller;

import java.awt.TrayIcon.MessageType;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;

import javax.swing.JOptionPane;

import co.edu.unbosque.model.Mundo;
import co.edu.unbosque.view.View;

/**
 * @author Gabriel Blanco Clase Controlador
 *
 */
public class Controller implements ActionListener {

	private Mundo mundo = new Mundo();
	private View view = new View();
	public final static String NOMBREPROYECTO = "Hide & Seek";
	
	
	
	
	/**
	 * Método Constructor del Controlador
	 * 
	 * @throws IOException
	 */
	public Controller() throws Exception {
		GUI();
	}

	/**
	 * Método para probar casos puntuales en consola
	 * 
	 * @throws IOException
	 */
	public void Consola() throws Exception {
		// Se inicializa gui aqui ya que es necesario para probar por via JOptionPane
		/*
		 * TODO: Buscar un método mas eficiente para mostrar TODOS los errores por
		 * JOptionPane
		 */
		boolean activo = true;
		while (activo) {

			try {
				int comando = Integer.parseInt(view.getDialogos().input(System.in, NOMBREPROYECTO+": DebuggerMode",
						"holis", JOptionPane.PLAIN_MESSAGE));
				switch (comando) {
				default:
					view.getDialogos().output("Error", "Bad command!", JOptionPane.ERROR_MESSAGE);
					break;
				case 0:
					activo = false;
					break;
				case 1:
					activo = false;
					GUI();
					break;
				case 2:
					view.getDialogos().notification(NOMBREPROYECTO, mundo.toString(), MessageType.NONE);
					break;
				}
			} catch (Exception e) {
				StringWriter errors = new StringWriter();
				e.printStackTrace(new PrintWriter(errors));
				
			}
		}
	}

	/**
	 * Método para iniciar la GUI
	 */
	public void GUI() throws Exception {
		try {
			view.setTitle(NOMBREPROYECTO);
			view.start(this);
			login();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void login() throws Exception {
		try {
			view.setVisible(false);
			view.getLogin().setVisible(true);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	
	/**
	 * @author Carl Quinn && Ricardo Sanchez
	 * Método para escuchar los eventos de la vista
	 */
	@SuppressWarnings("static-access")
	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			/*
			 * Panel Funciones Superiores
			 */
			if(e.getActionCommand() == view.getToolbar().NUEVOARCHIVO) {
				//Poner accion aquí
			}
			if(e.getActionCommand() == view.getToolbar().GUARDAR) {
				view.guardarArchivo();
			}
			if(e.getActionCommand() == view.getToolbar().CARGAR) {
				view.cargarArchivo();
			}
			if(e.getActionCommand() == view.getToolbar().SALIR) {
				view.dispose();
			}
			if(e.getActionCommand() == view.getToolbar().ACERCADE) {
				view.getDialogos().output("Acerca De", NOMBREPROYECTO+" by The Forest Software Company\nv1.0", JOptionPane.INFORMATION_MESSAGE);
			}
			
			if(e.getActionCommand() == view.getToolbar().CERRARSESION) {
				//TODO: SOmeday: Logica para cerrar sesion
				view.dispose();
			}
			//Formulario Login
			if(e.getActionCommand() == view.getLogin().REGISTRAR) {
				view.getLogin().setVisible(false);
				view.getRegistrar().setVisible(true);
			}
			//Formulario Registro
			if(e.getActionCommand() == view.getRegistrar().CANCELAR) {
				view.getRegistrar().setVisible(false);
				view.getLogin().setVisible(true);
				view.getRegistrar().clean();
				
			}
			if(e.getActionCommand() == view.getRegistrar().REGISTRAR) {
				view.getRegistrar().setVisible(false);
				view.getLogin().setVisible(true);
				//TODO logica
			}
		}
			
		/*
		 * Estas líneas son para controlar en caso de que por falta de memoria no genere
		 * el log. Esto es vital para el programa ya que me permite llevar una trazabilidad
		 */
		catch (Exception e2) {
			
			view.getDialogos().output("Error", "Ha ocurrido un error inesperado\n"
					+ "Se ha creado en <proyecto>/docs/Output un archivo myLog.log en donde aparece el detalle específico del error causado.",
					JOptionPane.ERROR_MESSAGE);
		}

	}

}
