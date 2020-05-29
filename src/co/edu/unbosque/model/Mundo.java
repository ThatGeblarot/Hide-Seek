package co.edu.unbosque.model;

import java.io.IOException;
import java.util.ArrayList;

import co.edu.unbosque.model.persistence.ArchivoClientes;
import co.edu.unbosque.model.persistence.ArchivoTiendas;
import co.edu.unbosque.model.persistence.ClienteDAO;
import co.edu.unbosque.model.persistence.TiendaDAO;

/**
 * Clase "multitoma" donde se definen e inicializan instancias de las clases del modelo.
 * @author Mois�s Salcedo y Ricardo Sanchez 
 */
public class Mundo {

	private ArchivoTiendas archivot = new ArchivoTiendas();
	private TiendaDAO tiendaDAO = new TiendaDAO(archivot);
	private ArchivoClientes archivoc = new ArchivoClientes();
	private ClienteDAO clienteDAO = new ClienteDAO(archivoc);
	private ArrayList<Cliente> clientes = new ArrayList<Cliente>();
	private ArrayList<Tienda> tiendas = new ArrayList<Tienda>();
	private Email email = new Email();

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
		clienteDAO.agregarCliente(clientes, "Gabriel", 30000000.00, "gblancol", "gblancol@unbosque.edu.co", "123456a", "Hombre");
		clienteDAO.agregarPareja(clientes, "gblancol", "Mireya ZunZun", 8500000.00, "mireya123", "gblancol@unbosque.edu.co", "12345a", "Mujer");
		tiendaDAO.agregarSucursal(tiendas,"EL BOSQUE", "CopyLucas 134", "Avenida 9 131-02");
		tiendaDAO.agregarSucursal(tiendas, "EL BOSQUE", "Chapinero", "Calle 63 # 13-08");
		tiendaDAO.agregarSucursal(tiendas, "EL BOSQUE", "Cedritos", "Calle 147 # 15-03");
		clienteDAO.asignarCupoCliente(clientes, "gblancol", 100000000.00);
		 tiendaDAO.agregarCompraCliente(tiendas, clientes, "EL BOSQUE", "CopyLucas 134", "gblancol", 943333.32);
		 tiendaDAO.agregarCompraCliente(tiendas, clientes, "EL BOSQUE", "CopyLucas 134", "gblancol", 943333.32);
		 tiendaDAO.agregarCompraCliente(tiendas, clientes, "EL BOSQUE", "CopyLucas 134", "gblancol", 943333.32);
		 tiendaDAO.agregarCompraCliente(tiendas, clientes, "EL BOSQUE", "CopyLucas 134", "gblancol", 943333.32);
		 tiendaDAO.agregarCompraCliente(tiendas, clientes, "EL BOSQUE", "CopyLucas 134", "gblancol", 943333.32);
		clientes = archivoc.leerArchivo();
		tiendas = archivot.leerArchivo();
	}
	
	public boolean agregarCliente(String nombre, double cupo, String userid, String[] correo, String contrasena, String genero) throws Exception {
		clienteDAO.agregarCliente(clientes, nombre, cupo, userid, correo[0], contrasena, genero);
		email.sendEmail(correo, "�Bienvenido a Hide & Seek!", "�Hola!\nEstas son tus credenciales de acceso para el sistema:\nUsuario: "+userid+"\nContrase�a: "+contrasena+"\nEsperamos que disfrutes del servicio, tanto como nosotros disfrutamos en ofrecertelo.\nCon amor,\nEl equipo de Hide & Seek");
		return true;
	}
	
	public boolean agregarParjea(String userid, String nombre, double cupo, String[] correo, String contrasena, String genero) throws Exception {
		clienteDAO.agregarPareja(clientes, "gblancol", nombre, cupo, userid, correo[0], contrasena, genero);
		email.sendEmail(correo, "�Te han solicitado ser pareja de un cliente de la tienda EL BOSQUE!", "�Hola!\nEstas son tus credenciales de acceso para el sistema:\nUsuario: "+userid+"\nContrase�a: "+contrasena+"\nEsperamos que disfrutes del servicio, tanto como nosotros disfrutamos en ofrecertelo.\nCon amor,\nEl equipo de Hide & Seek");
		return true;
	}
	
	public boolean asignarCupoCliente(String clientes,String userid, String userpareja, double nuevocupo) {
		return true;
	}
	
	public boolean agregarCompraCliente(String tienda, String sucursal, String cliente, double precio) {
		tiendaDAO.agregarCompraCliente(tiendas, clientes, tienda, sucursal, cliente, precio);
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