/*Clase que modela mundo que conecta todas las clases logicas en una*/
package co.edu.unbosque.model;

import java.util.ArrayList;

import co.edu.unbosque.model.persistence.ArchivoClientes;
import co.edu.unbosque.model.persistence.ArchivoTiendas;
import co.edu.unbosque.model.persistence.ClienteDAO;
import co.edu.unbosque.model.persistence.TiendaDAO;

/**
 * La clase mundo es muy util para conectar y organizar la informacion de las clases logicas para solucionar
 * la problematica del programa
 * @author Gabriel Blanco 
 */
public class Mundo {

	private ArchivoTiendas archivot= new ArchivoTiendas();
	private TiendaDAO tiendaDAO=new TiendaDAO(archivot);
	private ArchivoClientes archivoc= new ArchivoClientes();
	private ClienteDAO clienteDAO = new ClienteDAO(archivoc);
	private ArrayList<Cliente> clientes=archivoc.leerArchivo();
	private ArrayList<Tienda> tiendas=archivot.leerArchivo();
	/**
	 * Es el Constructor de la clase Mundo.
	 */
	
	public Mundo() {
		tiendaDAO.agregarTienda(tiendas, "EL BOSQUE");
		tiendaDAO.agregarAdministrador(tiendas, "EL BOSQUE", "admin", "12345a");
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
