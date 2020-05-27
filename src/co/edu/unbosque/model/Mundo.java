package co.edu.unbosque.model;

import java.util.ArrayList;

import co.edu.unbosque.model.persistence.ArchivoClientes;
import co.edu.unbosque.model.persistence.ArchivoTiendas;
import co.edu.unbosque.model.persistence.ClienteDAO;
import co.edu.unbosque.model.persistence.TiendaDAO;

/**
 * @author Gabriel Blanco Clase "multitoma" donde se define la soluci�n de la
 *         problem�tica
 */
public class Mundo {

	private ArchivoTiendas archivot= new ArchivoTiendas();
	private TiendaDAO tiendaDAO=new TiendaDAO(archivot);
	private ArchivoClientes archivoc= new ArchivoClientes();
	private ClienteDAO clienteDAO = new ClienteDAO(archivoc);
	private ArrayList<Cliente> clientes;
	private ArrayList<Tienda> tiendas;
	
	
	public Mundo() {
		tiendaDAO.agregarTienda(tiendas, "EL BOSQUE");
		tiendaDAO.agregarAdministrador(tiendas, "EL BOSQUE", "admin", "12345a");
		clientes= archivoc.leerArchivo();
		tiendas=archivot.leerArchivo();
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
