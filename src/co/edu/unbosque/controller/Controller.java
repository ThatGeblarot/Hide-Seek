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
	private String actualLogin = new String();
	private int actualType = 0;
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
				int comando = Integer.parseInt(view.getDialogos().input(System.in, NOMBREPROYECTO + ": DebuggerMode",
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
			startUp();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void startUp() {
		view.setVisible(false);
		view.getLogin().setVisible(true);
	}

	public void login(String user, String password) throws Exception {
		setActualLogin(user);
		doLogin(verificarPerfil(user, password));
	}

	public void doLogin(int userType) throws Exception {
		setActualType(userType);
		switch (userType) {
		case 1:
			view.getLogin().setVisible(false);
			view.setVisible(true);
			view.getAdmin().setVisible(true);
			view.getUsuarios().setVisible(true);
			view.getParejas().setVisible(true);
			break;
		case 2:
			view.getLogin().setVisible(false);
			view.setVisible(true);
			view.getAdmin().setVisible(false);
			view.getUsuarios().setVisible(true);
			view.getParejas().setVisible(true);
			break;
		case 3:
			view.getLogin().setVisible(false);
			view.setVisible(true);
			view.getAdmin().setVisible(false);
			view.getUsuarios().setVisible(false);
			view.getParejas().setVisible(true);
			break;
		default:
			view.getDialogos().output("Error",
					"Usuario y/o clave incorrecta. Verifique las credenciales y el tipo de usuario e intente nuevamente",
					JOptionPane.ERROR_MESSAGE);
			break;
		}
	}

	public void registrar() throws Exception {
		if (mundo.getClienteDAO().agregarCliente(mundo.getClientes(), view.getRegistrar().getTextnom().getText(), 0.0,
				view.getRegistrar().getTextusuario().getText(), view.getRegistrar().getTextcorreo().getText(),
				view.getRegistrar().getTextclave().getText(),
				view.getRegistrar().getGenerocombo().getSelectedItem().toString()))
			;
		{
			String[] correo = { view.getRegistrar().getTextcorreo().getText() };
			mundo.agregarCliente(view.getRegistrar().getTextnom().getText(), 0.0,
					view.getRegistrar().getTextusuario().getText(), correo,
					view.getRegistrar().getTextclave().getText(),
					view.getRegistrar().getGenerocombo().getSelectedItem().toString());
			view.getDialogos().output("Informacion", "Se ha enviado un correo a "+correo[0]+" con las credenciales de acceso.", JOptionPane.INFORMATION_MESSAGE);
		}
	}

	public int verificarPerfil(String user, String password) throws Exception {
		int ans = 0;
		if (mundo.getTiendaDAO().verificarPasswordAdministrador(mundo.getTiendas().get(0), user, password)) {
			ans = 1;
		}
		if (mundo.getClienteDAO().verificarPswdCliente(mundo.getClientes(), user, password)) {
			ans = 2;
			for (int i = 0; i < mundo.getClientes().size(); i++) {
				if (mundo.getClienteDAO().verificarPswdPareja(mundo.getClientes().get(i), user, password)) {
					ans = 3;
				}
			}
		}
		return ans;

	}

	/**
	 * @author Carl Quinn && Ricardo Sanchez Método para escuchar los eventos de la
	 *         vista
	 */
	@SuppressWarnings("static-access")
	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			/*
			 * Panel Funciones Superiores
			 */
			if (e.getActionCommand() == view.getToolbar().NUEVOARCHIVO) {
				// Poner accion aquí
			}
			if (e.getActionCommand() == view.getToolbar().GUARDAR) {
				view.guardarArchivo();
			}
			if (e.getActionCommand() == view.getToolbar().CARGAR) {
				view.cargarArchivo();
			}
			if (e.getActionCommand() == view.getToolbar().SALIR) {
				view.dispose();
			}
			if (e.getActionCommand() == view.getToolbar().ACERCADE) {
				view.getDialogos().output("Acerca De", NOMBREPROYECTO + " by The Forest Software Company\nv1.0",
						JOptionPane.INFORMATION_MESSAGE);
			}

			if (e.getActionCommand() == view.getToolbar().CERRARSESION) {
				startUp();
			}
			/*
			 * Formulario Login
			 */
			if (e.getActionCommand() == view.getLogin().REGISTRAR) {
				view.getLogin().setVisible(false);
				view.getRegistrar().setVisible(true);
			}
			if (e.getActionCommand() == view.getLogin().LOGIN) {
				login(view.getLogin().getTextcorreo().getText(), view.getLogin().getTextclave().getText());

			}
			/*
			 * Formulario Registro
			 *TODO error en registrar se activa login de nuevo
			 */
			if (e.getActionCommand() == view.getRegistrar().CANCELAR) {
				view.getRegistrar().setVisible(false);
				view.getLogin().setVisible(true);
				view.getRegistrar().clean();

			}
			if (e.getActionCommand() == view.getRegistrar().REGISTRAR) {
				view.getLogin().setVisible(false);
				if ((view.getRegistrar().getTextcorreo().getText() == view.getRegistrar().getTextconfcorreo().getText()
						&& view.getRegistrar().getTextclave().getText() == view.getRegistrar().getTextconfclave()
								.getText())) {
					view.getDialogos().output("Error",
							"La clave o el correo no coinciden. Verifique los campos e intente nuevamente.",
							JOptionPane.ERROR_MESSAGE);
					view.getRegistrar().clean();
				} else {
					registrar();
					view.getRegistrar().setVisible(false);
					view.getLogin().setVisible(true);
					view.getRegistrar().clean();
				}
			}
			/*
			 * Panel Parejas
			 */
			if (e.getActionCommand() == view.getParejas().LISTAAFILIADOS) {
				view.getListar().setVisible(true);
			}
			if (e.getActionCommand() == view.getParejas().DATOS) {
				view.getPersonal().setVisible(true);
			}
			if (e.getActionCommand() == view.getParejas().ACTUALIZARDATOS) {
				view.getActualizar().setVisible(true);
			}
			if (e.getActionCommand() == view.getParejas().ELIMINARDATOS) {
				
			}
			if (e.getActionCommand() == view.getParejas().HACERPAGO) {
				for (int i = 0; i < mundo.getTiendas().get(0).getSucursales().size(); i++) {
					view.getPago().getCombo().addItem(mundo.getTiendas().get(0).getSucursales().get(i).getdireccion());
				}
				view.getPago().getSucursal().setText("Sucursal");
				view.getPago().setVisible(true);
			}
			/*
			 * Panel Usuarios
			 */
			if (e.getActionCommand() == view.getUsuarios().AGREGARPAREJA) {
				view.getRegistrar().getBotonRegistrar().setActionCommand("ParejaGestionarRegistro");
				view.getRegistrar().setVisible(true);
				
			}
			/*
			 * Panel Usuario (Agregar Pareja)
			 */
			if(e.getActionCommand() == "ParejaGestionarRegistro") {
				String[] mail = {view.getRegistrar().getTextcorreo().getText()};
				mundo.agregarParjea(view.getRegistrar().getTextusuario().getText(), view.getRegistrar().getTextnom().getText(), 10000.0, mail, view.getRegistrar().getTextclave().getText(), view.getRegistrar().getGenerocombo().toString());
				view.getDialogos().output("Informacion", "Se ha enviado un correo a "+mail[0]+". El correohabiente deberá confirmar si es su pareja.", JOptionPane.INFORMATION_MESSAGE);
				view.getRegistrar().setVisible(false);
			}
			if (e.getActionCommand() == view.getUsuarios().ELIMINARPAREJA) {
				view.getEliminar().setVisible(true);
			}
			if (e.getActionCommand() == view.getUsuarios().ACTUALIZARPAREJA) {
				view.getActualizar().setVisible(true);
			}
			if (e.getActionCommand() == view.getUsuarios().LISTAPAREJAS) {
				view.getListar().setVisible(true);
			}
			if (e.getActionCommand() == view.getUsuarios().ACTUALIZARDATOS) {
				view.getActualizar().setVisible(true);
			}
			if (e.getActionCommand() == view.getUsuarios().ASIGNARCUPO) {
				for (int i = 0; i < mundo.getClientes().get(0).getParejas().size(); i++) {
					view.getAsignarCupo().anadirColumna(mundo.getClientes().get(0).getParejas().get(i).getUserid(), mundo.getClientes().get(0).getParejas().get(i).getCorreo(), "EL BOSQUE", String.valueOf(mundo.getClientes().get(0).getParejas().get(i).getCupo()));
				}
				view.getAsignarCupo().setVisible(true);
			}
			if (e.getActionCommand() == view.getUsuarios().ASIGNARHORARIO) {
				view.getHorario().setVisible(true);
			}
			if (e.getActionCommand() == view.getUsuarios().COMPRAS) {
				view.getMostrarcompras().setVisible(true);
			}
			if (e.getActionCommand() == view.getUsuarios().HORARIO) {
				view.getHorario().setVisible(true);
			}
			/*
			 * Panel Administrador
			 */
			if (e.getActionCommand() == view.getAdmin().AGREGARUSUARIO) {
				view.getRegistrar().getBotonRegistrar().setActionCommand("AdminGestionarRegistro");
				view.getRegistrar().setVisible(true);
			}
			/*
			 * Panel Administrador (Agregar Usuario)
			 */
			if(e.getActionCommand() == "AdminGestionarRegistro") {
				String[] mail = {view.getRegistrar().getTextcorreo().getText()};
				mundo.agregarCliente(view.getRegistrar().getTextnom().getText(), 150000.0, view.getRegistrar().getTextusuario().getText(), mail, view.getRegistrar().getTextclave().getText(), view.getRegistrar().getGenerocombo().getSelectedItem().toString());
				view.getDialogos().output("Informacion", "Se ha enviado un correo a "+mail[0]+" con las credenciales de acceso.", JOptionPane.INFORMATION_MESSAGE);
				view.getRegistrar().setVisible(false);
			}
			if (e.getActionCommand() == view.getAdmin().ELIMINARUSUARIOS) {
				view.getEliminar().setVisible(true);
			}
			if (e.getActionCommand() == view.getAdmin().ACTUALIZARUSUARIOS) {
				view.getActualizar().setVisible(true);
			}
			if (e.getActionCommand() == view.getAdmin().LISTAUSUARIOS) {
				view.getListar().setVisible(true);
			}
			if (e.getActionCommand() == view.getAdmin().ACTUALIZARDATOSUSUARIOS) {
				view.getActualizar().setVisible(true);
			}
			if (e.getActionCommand() == view.getAdmin().ASIGNARCUPO) {
				for (int i = 0; i < mundo.getClientes().size(); i++) {
					view.getAsignarCupo().anadirColumna(mundo.getClientes().get(i).getUserid(), mundo.getClientes().get(i).getCorreo(), "EL BOSQUE", String.valueOf(mundo.getClientes().get(i).getCupo()));
				}
				view.getAsignarCupo().setVisible(true);
			}
			if (e.getActionCommand() == view.getAdmin().HACERPAGO) {
				for (int i = 0; i < mundo.getTiendas().get(0).getSucursales().size(); i++) {
					view.getPago().getCombo().addItem(mundo.getTiendas().get(0).getSucursales().get(i).getdireccion());
				}
				view.getPago().setVisible(true);
			}
			if (e.getActionCommand() == view.getAdmin().HORARIO) {
				view.getHorario().setVisible(true);
			}
			if (e.getActionCommand() == view.getAdmin().SUCURSALES) {
				for (int i = 0; i < mundo.getTiendas().get(0).getSucursales().size(); i++) {
					view.getComprasSucursales().getSucursal().addItem(mundo.getTiendas().get(0).getSucursales().get(i).getdireccion());
				}
				view.getComprasSucusales().setVisible(true);
			}
			if(e.getActionCommand() == view.getAdmin().MOSTRARPDF) {
				view.getGenerarPDF().setVisible(true); 
			}
			if(e.getActionCommand() == view.getAdmin().VERESTADISTICA) {
				view.getStats().getStats().getData().setValue("Chapinero", 2);
				view.getStats().getStats().getData().setValue("Cedritos", 5);
				view.getStats().getStats().getData().setValue("Copylucas 134", mundo.getTiendas().get(0).getCompras().size());
				int media = (90+120+50)/3;
				int moda = 0;
				int mediana = 90;
				view.getStats().getModa().setText(moda+".");
				view.getStats().getMedia().setText(media+".");
				view.getStats().getMediana().setText(mediana+".");
				view.getStats().setVisible(true);
			}
			/*
			 * Dialog Buscar
			 */
			if(e.getActionCommand() == view.getBuscador().BUSCAR) {
				
			}
			if(e.getActionCommand() == view.getBuscador().CANCELAR) {
				view.getBuscador().clean();
				view.getBuscador().setVisible(false);
			}
			/*
			 * Dialog Actualizar
			 */
			if (e.getActionCommand() == view.getActualizar().ACTUALIZAR) {
				view.getActualizar().setVisible(false);
			}
			if (e.getActionCommand() == view.getActualizar().CANCELAR) {
				view.getActualizar().clean();
				view.getActualizar().setVisible(false);
			}
			/*
			 * Dialog Asignar Cupo
			 */
			if(e.getActionCommand() == view.getAsignarCupo().ASIGNAR) {
				view.getPago().getSucursal().setText("Pareja");
				for (int i = 0; i < mundo.getClientes().get(0).getParejas().size(); i++) {
					view.getPago().getCombo().addItem(mundo.getClientes().get(0).getParejas().get(i).getUserid());
				}
				view.getPago().getPagar().setActionCommand("UserAsignarCupo");
				view.getPago().setVisible(true);
			}
			/*
			 * Asignar Cupo (User Asignar Cupo)
			 */
			if(e.getActionCommand() == "UserAsignarCupo") {
				view.getAsignarCupo().clean();
				view.getPago().getCombo().removeAllItems();
				view.getPago().setVisible(false);
				view.getAsignarCupo().setVisible(false);
			}
			if(e.getActionCommand() == view.getAsignarCupo().CANCELAR) {
				view.getAsignarCupo().setVisible(false);
			}
			if(e.getActionCommand() == view.getAsignarCupo().QUITAR) {
				view.getAsignarCupo().clean();
			}
			/*
			 * Dialog Eliminar
			 */
			if(e.getActionCommand() == view.getEliminar().ELIMINAR) {
				
			}
			if(e.getActionCommand() == view.getEliminar().CANCELAR) {
				view.getEliminar().clean();
				view.getEliminar().setVisible(false);
			}
			/*
			 * GenerarPDF
			 */
			if(e.getActionCommand() == view.getGenerarPDF().PDF) {
				mundo.getArchivot().crearPDF(mundo.getTiendas().get(0).CompraSucursalPDF());
				view.getDialogos().output("Operacion Finalizada", "PDF Generado", JOptionPane.INFORMATION_MESSAGE);
			}
			if(e.getActionCommand() == view.getGenerarPDF().CANCELAR) {
				view.getGenerarPDF().setVisible(false);
			}
			/*
			 * Horario
			 */
			if(e.getActionCommand() == view.getHorario().ASIGNAR) {
				
			}
			if(e.getActionCommand() == view.getHorario().CANCELAR) {
				view.getHorario().setVisible(false);
			}
			/*
			 * Listar
			 */
			if(e.getActionCommand() == view.getListar().LIMPIAR) {
				view.getListar().clean();
			}
			if(e.getActionCommand() == view.getListar().MOSTRAR) {
				
			}
			if(e.getActionCommand() == view.getListar().CANCELAR) {
				view.getListar().clean();
				view.getListar().setVisible(false);
			}
			/*
			 * Mostrar Compras
			 */
			if(e.getActionCommand() == view.getMostrarcompras().INFORMACION) {
				var log = mundo.getTiendas().get(0).CompraSucursalPDF();
				for (int i = 0; i < log.length; i++) {
					view.getMostrarcompras().getArealog().setText(log[i]+"\n");
				}
				
			}
			if(e.getActionCommand() == view.getMostrarcompras().CANCELAR) {
				view.getMostrarcompras().clean();
				view.getMostrarcompras().setVisible(false);
			}
			if(e.getActionCommand() == view.getMostrarcompras().ORDENADAS) {
				
			}
			if(e.getActionCommand() == view.getMostrarcompras().ORDENARDES) {
				
			}
			/*
			 * Mostrar Compras Sucursales
			 */
			if(e.getActionCommand() == view.getComprasSucusales().INFORMACION) {
				
			}
			if(e.getActionCommand() == view.getComprasSucusales().CANCELAR) {
				view.getComprasSucusales().clean();
				view.getComprasSucusales().setVisible(false);
			}
			/*
			 * Pago
			 */
			if(e.getActionCommand() == view.getPago().PAGAR) {
				mundo.agregarCompraCliente("EL BOSQUE", view.getPago().getCombo().getSelectedItem().toString(), actualLogin, Double.parseDouble(view.getPago().getTextcantidad().getText()));
				view.getPago().clean();
				view.getPago().getCombo().removeAllItems();
				view.getPago().setVisible(false);
			}
			if(e.getActionCommand() == view.getPago().CANCELAR) {
				view.getPago().clean();
				view.getPago().setVisible(false);
			}
			/*
			 * Informacion personal
			 */
			if(e.getActionCommand() == view.getPersonal().getMOSTRAR()) {
				
			}
			if(e.getActionCommand() == view.getPersonal().getCANCELAR()) {
				view.getPersonal().clean();
				view.getPersonal().setVisible(false);
			}
			/*
			 * Stats
			 */

		}

		/*
		 * Estas líneas son para controlar en caso de que por falta de memoria no genere
		 * el log. Esto es vital para el programa ya que me permite llevar una
		 * trazabilidad
		 */
		catch (Exception e2) {
			StringWriter errors = new StringWriter();
			e2.printStackTrace(new PrintWriter(errors));
			System.out.println(errors);
			view.getDialogos().output("ERROR FATAL", "Ocurrio un error", JOptionPane.ERROR_MESSAGE);
		}

	}

	public String getActualLogin() {
		return actualLogin;
	}

	public void setActualLogin(String actualLogin) {
		this.actualLogin = actualLogin;
	}

	public int getActualType() {
		return actualType;
	}

	public void setActualType(int actualType) {
		this.actualType = actualType;
	}

}
