package co.edu.unbosque.model;

import java.io.IOException;
import java.util.ArrayList;

import co.edu.unbosque.model.persistence.ArchivoClientes;
import co.edu.unbosque.model.persistence.ArchivoTiendas;
import co.edu.unbosque.model.persistence.ClienteDAO;
import co.edu.unbosque.model.persistence.TiendaDAO;

/**
 * @author Gabriel Blanco Clase "multitoma" donde se define la soluciï¿½n de la
 *         problemï¿½tica
 */
public class Mundo {

	private ArchivoTiendas archivot = new ArchivoTiendas();
	private TiendaDAO tiendaDAO = new TiendaDAO(archivot);
	private ArchivoClientes archivoc = new ArchivoClientes();
	private ClienteDAO clienteDAO = new ClienteDAO(archivoc);
	private ArrayList<Cliente> clientes = new ArrayList<Cliente>();
	private ArrayList<Tienda> tiendas = new ArrayList<Tienda>();
	private Email email = new Email();

	public Mundo() {
		try {
			tiendaDAO.agregarTienda(tiendas, "EL BOSQUE");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		tiendaDAO.agregarAdministrador(tiendas, "EL BOSQUE", "admin", "12345a");
		clientes = archivoc.leerArchivo();
		tiendas = archivot.leerArchivo();
	}
	
	public boolean agregarCliente(String nombre, double cupo, String userid, String[] correo, String contrasena, String genero) throws Exception {
		clienteDAO.agregarCliente(clientes, nombre, cupo, userid, correo[0], contrasena, genero);
		email.sendEmail(correo, "¡Bienvenido a Hide & Seek!", "¡Hola!\nEstas son tus credenciales de acceso para el sistema:\nUsuario: "+correo[0]+"\nContraseña: "+contrasena+"\nEsperamos que disfrutes del servicio, tanto como nosotros disfrutamos en ofrecertelo.\nCon amor,\nEl equipo de Hide & Seek");
		return true;
	}
	
	public boolean agregarPareja() {
		return true;
	}

	public TiendaDAO getTiendaDAO() {
		return tiendaDAO;
	}

	public ClienteDAO getClienteDAO() {
		return clienteDAO;
	}

	public ArchivoTiendas getArchivot() {
		return archivot;
	}

	public ArchivoClientes getArchivoc() {
		return archivoc;
	}

	public ArrayList<Cliente> getClientes() {
		return clientes;
	}

	public ArrayList<Tienda> getTiendas() {
		return tiendas;
	}

	public Email getEmail() {
		return email;
	}
}
