package co.edu.unbosque.controller;

import java.awt.AWTException;
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
	 * M�todo Constructor del Controlador
	 * 
	 * @throws IOException
	 */
	public Controller() throws Exception {
		Consola();
	}

	/**
	 * M�todo para probar casos puntuales en consola
	 * 
	 * @throws IOException
	 */
	public void Consola() throws Exception {
		// Se inicializa gui aqui ya que es necesario para probar por via JOptionPane
		/*
		 * TODO: Buscar un m�todo mas eficiente para mostrar TODOS los errores por
		 * JOptionPane
		 */
		boolean activo = true;
		while (activo) {
			try {
				int comando = Integer.parseInt(view.getDialogos().input(System.in, NOMBREPROYECTO+": DebuggerMode",
						mundo.getArchivo().leerArchivo("./docs/Required/ayuda.txt"), JOptionPane.PLAIN_MESSAGE));
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
				view.getDialogos().notification("File created successfully", mundo.getArchivo().makeLog(errors.toString()), MessageType.INFO);
				view.getDialogos().output("Error", "Ha ocurrido un error inesperado\n"
						+ "Se ha creado en <proyecto>/docs/Output un archivo myLog.log en donde aparece el detalle espec�fico del error causado.",
						JOptionPane.ERROR_MESSAGE);
			}
		}
	}

	/**
	 * M�todo para iniciar la GUI
	 */
	public void GUI() throws Exception {
		try {
			view.setTitle(NOMBREPROYECTO);
			view.start(this);
			view.getLogin().setVisible(true);
		} catch (Exception e) {
			StringWriter errors = new StringWriter();
			e.printStackTrace(new PrintWriter(errors));
			view.getDialogos().notification("File created successfully", mundo.getArchivo().makeLog(errors.toString()), MessageType.INFO);
			view.getDialogos().output("Error", "Ha ocurrido un error inesperado\n"
					+ "Se ha creado en <proyecto>/docs/Output un archivo myLog.log en donde aparece el detalle espec�fico del error causado.",
					JOptionPane.ERROR_MESSAGE);
		}
	}
	public void iniciarSesion(String user, String password) throws Exception {
		String data = mundo.login(user, password);
		if(data != null) {
			String[] profile = data.split(",");
			auth(profile[0],Integer.parseInt(profile[2]));
		} else {
			view.getDialogos().output("Error", "Usuario o clave incorrecta", JOptionPane.ERROR_MESSAGE);
		}
	}
	public void registrarse() throws Exception {
		
	}
	public void auth(String user, int profile) throws Exception {
		if(profile == 0) {
			view.getAdmin().setTitle("H&S ADMIN: "+user);
			view.getAdmin().start(this);
		}
		if(profile == 1) {
			view.getUser().setTitle("Hide & Seek: "+user);
			view.getUser().start(this);
		}
		if(profile == 2) {
			view.getCouple().setTitle("Hide & Seek: "+user);
			view.getCouple().start(this);
		}
	}
	/**
	 * @author Carl Quinn
	 * M�todo para escuchar los eventos de la vista
	 */
	@SuppressWarnings("static-access")
	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			/*
			 * Panel Funciones Superiores
			 */
			if(e.getActionCommand() == view.getToolbar().NUEVOARCHIVO) {
				//Poner accion aqu�
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
			/*
			 * Login
			 */
			if(e.getActionCommand() == view.getLogin().SIGNIN) {
				iniciarSesion(view.getLogin().getTxUser().getText(), view.getLogin().getTxPassword().getText());
			}
			if(e.getActionCommand() == view.getLogin().SIGNUP) {
				registrarse();
			}

		} 
		/*
		 * Estas l�neas son para controlar en caso de que por falta de memoria no genere
		 * el log. Esto es vital para el programa ya que me permite llevar una trazabilidad
		 */
		catch (Exception e2) {
			StringWriter errors = new StringWriter();
			e2.printStackTrace(new PrintWriter(errors));
			try {
				view.getDialogos().notification("File created successfully", mundo.getArchivo().makeLog(errors.toString()), MessageType.INFO);
				view.getDialogos().output("Error", "Ha ocurrido un error inesperado\n"
						+ "Se ha creado en <proyecto>/docs/Output un archivo myLog.log en donde aparece el detalle espec�fico del error causado.",
						JOptionPane.ERROR_MESSAGE);
			} catch (IOException e1) {
				view.getDialogos().output("Error Fatal",
						"Ha ocurrido un error inesperado donde se debe salir del programa.\nMotivo: Error creando el log de archivos",
						JOptionPane.ERROR_MESSAGE);
				System.exit(1);
			} catch (AWTException e1) {
				// TODO Auto-generated catch block
				
			}
			view.getDialogos().output("Error", "Ha ocurrido un error inesperado\n"
					+ "Se ha creado en <proyecto>/docs/Output un archivo myLog.log en donde aparece el detalle espec�fico del error causado.",
					JOptionPane.ERROR_MESSAGE);
		}

	}

}
