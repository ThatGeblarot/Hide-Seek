package co.edu.unbosque.test;

import junit.framework.TestCase;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import co.edu.unbosque.model.Cliente;
import co.edu.unbosque.model.Pareja;
import co.edu.unbosque.model.persistence.ArchivoClientes;
import co.edu.unbosque.model.persistence.ClienteDAO;
import junit.framework.TestCase;

public class ClienteDAOTest extends TestCase {

	ClienteDAO cliente;
	ArchivoClientes archivoC;
	File file = new File("dataTest/basedatosTest.dat");
	ArrayList<Cliente> listaClientes;
	ArrayList<Pareja> listaPareja;

	Cliente cliente_1;
	Cliente cliente_2;
	Pareja pareja_1;
	Pareja pareja_2;

	private void setupEscenario() {
		file.delete();
		try {
			file.createNewFile();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		archivoC = new ArchivoClientes();
		listaClientes = archivoC.leerArchivo();
		cliente = new ClienteDAO(archivoC);

		cliente_1 = new Cliente("pepe", 4000000, "pepe1", "pepe1234@mailing.com", "xxxxxx", "Hombre");
		cliente_2 = new Cliente("carlos", 300000, "pepe1", "carlixtoc@mailing.com", "xxxxxxxx", "Otro");
		pareja_1 = new Pareja("Camila", 30000, "camixoxo", "camilita14@mailing.com", "xxxxxxxx", "Mujer");
		pareja_2 = new Pareja("Paula", 30000, "camixoxo", "paulamllan@mailing.com", "xxxxxxxx", "Mujer");

		listaClientes.add(cliente_1);
		listaClientes.add(cliente_2);
		listaClientes.get(0).getParejas().add(pareja_1);
		listaClientes.get(0).getParejas().add(pareja_2);

	}

	public void testClienteDAO() {
		setupEscenario();

		assertEquals("La cantidad de clientes debe ser 2", 2, listaClientes.size());
		assertEquals("La cantidad de parejas debe ser 2", 2, listaClientes.size());

	}

	public void testAgregarCliente() {
		setupEscenario();

		assertEquals("Se debió agregar el cliente", false,
				cliente.agregarCliente(listaClientes, cliente_1.getNombre(), cliente_1.getCupo(), cliente_1.getUserid(),
						cliente_1.getCorreo(), cliente_1.getContraseña(), cliente_1.getGenero()));

		assertFalse("No se debería agregar un Cliente con usuario ya existente",
				cliente.agregarCliente(listaClientes, cliente_2.getNombre(), cliente_2.getCupo(), cliente_2.getUserid(),
						cliente_2.getCorreo(), cliente_2.getContraseña(), cliente_2.getGenero()));

	}

	public void testAgregarPareja() {
		setupEscenario();

		assertTrue("Se debió agregar la pareja",
				cliente.agregarPareja(listaClientes, cliente_1.getUserid(), pareja_1.getNombre(), pareja_1.getCupo(),
						pareja_1.getUserid(), pareja_1.getCorreo(), pareja_1.getcontrasena(), pareja_1.getGenero()));

		assertTrue("No se debería agregar la pareja con usuario ya existente",
				cliente.agregarPareja(listaClientes, cliente_1.getUserid(), pareja_2.getNombre(), pareja_2.getCupo(),
						pareja_2.getUserid(), pareja_2.getCorreo(), pareja_2.getcontrasena(), pareja_2.getGenero()));

	}

	public void testBuscarCliente() {

		setupEscenario();

		assertNull("No debió encontrar un usuario NO existente en el sistema",
				cliente.buscarCliente(listaClientes, "spiderMan"));
		assertNotNull("Debió encontrarse al usuario", cliente.buscarCliente(listaClientes, cliente_1.getUserid()));
	}

	public void testBuscarPareja() {

		setupEscenario();

		assertNull("No debió encontrar un usuario NO existente en el sistema",
				cliente.buscarPareja(cliente_1, "spiderWomanss"));
		assertNotNull("Debió encontrarse al usuario", cliente.buscarPareja(cliente_1, pareja_1.getUserid()));
	}

	public void testEliminarCliente() {
		setupEscenario();

		assertEquals("Debió eliminarse el cliente", true,
				cliente.eliminarCliente(listaClientes, cliente_1.getUserid()));
		assertEquals("No se pudo eliminar el cliente el usuario no existe", false,
				cliente.eliminarCliente(listaClientes, "ironMan"));

	}
	public void testEliminarPareja() {
		setupEscenario();

		assertEquals("Debió eliminarse la pareja", true,
				cliente.eliminarPareja(cliente_1, pareja_1.getUserid(), listaClientes));
		assertEquals("No se pudo eliminar la pareja el usuario no existe", true,
				cliente.eliminarPareja(cliente_1, "ironWoman", listaClientes));

	}
	
	

}