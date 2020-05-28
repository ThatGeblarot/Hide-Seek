package co.edu.unbosque.model;

import java.io.IOException;
import java.util.ArrayList;

import co.edu.unbosque.model.persistence.ArchivoClientes;
import co.edu.unbosque.model.persistence.ArchivoTiendas;
import co.edu.unbosque.model.persistence.ClienteDAO;
import co.edu.unbosque.model.persistence.TiendaDAO;

/**
 * Clase "multitoma" donde se definen e inicializan instancias de las clases del modelo.
 * @author Moisés Salcedo y Ricardo Sanchez 
 */
public class Mundo {

	private ArchivoTiendas archivot = new ArchivoTiendas();
	private TiendaDAO tiendaDAO = new TiendaDAO(archivot);
	private ArchivoClientes archivoc = new ArchivoClientes();
	private ClienteDAO clienteDAO = new ClienteDAO(archivoc);
	private ArrayList<Cliente> clientes = new ArrayList<Cliente>();
	private ArrayList<Tienda> tiendas = new ArrayList<Tienda>();

	/**
     * Es el Constructor de la clase Mundo.
     */
	
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

}
