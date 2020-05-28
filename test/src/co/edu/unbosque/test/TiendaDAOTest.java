package co.edu.unbosque.test;

import junit.framework.TestCase;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import co.edu.unbosque.model.Cliente;
import co.edu.unbosque.model.Pareja;
import co.edu.unbosque.model.Tienda;
import co.edu.unbosque.model.persistence.ArchivoClientes;
import co.edu.unbosque.model.persistence.ArchivoTiendas;
import co.edu.unbosque.model.persistence.TiendaDAO;
import junit.framework.TestCase;

public class TiendaDAOTest extends TestCase {

	TiendaDAO tienda;
	ArchivoTiendas archivoT;
	File file = new File("dataTest/basedatosTest.dat");
	ArrayList<Tienda> listaTienda;
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

}
