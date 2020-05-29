package co.edu.unbosque.test;

import junit.framework.TestCase;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import co.edu.unbosque.model.Administrador;
import co.edu.unbosque.model.Sucursal;
import co.edu.unbosque.model.Tienda;
import co.edu.unbosque.model.persistence.ArchivoClientes;
import co.edu.unbosque.model.persistence.ArchivoTiendas;
import co.edu.unbosque.model.persistence.ClienteDAO;
import co.edu.unbosque.model.persistence.TiendaDAO;
import junit.framework.TestCase;

public class TiendaDAOTest extends TestCase {

	TiendaDAO tiendaDAO;
	ArchivoTiendas archivoT;
	File fileTienda = new File("dataTest/basedatosTiendaTest.dat");
	ArrayList<Tienda> listaTienda;
	ArrayList<Sucursal> listaSucursal;
	ArrayList<Administrador> listaAdmin;

	Sucursal sucursal_1;
	Sucursal sucursal_2;
	Tienda tienda_1;
	private void setupEscenario() {
		fileTienda.delete();
		try {
			fileTienda.createNewFile();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		archivoT = new ArchivoTiendas();
		listaTienda = archivoT.leerArchivo();
		tiendaDAO = new TiendaDAO(archivoT);

		tienda_1= new Tienda("Unibos");
		listaTienda.add(tienda_1);
		sucursal_1 = new Sucursal("cra1340", "Unibostienda");
		listaTienda.get(0).getSucursales().add(sucursal_1);
		sucursal_2 = new Sucursal("cra176", "guante del infinito");
		listaTienda.get(0).getSucursales().add(sucursal_2);
	}

	public void testTiendaDAOSucursal() {
		setupEscenario();

		assertEquals("La cantidad de parejas debe ser 2", 2, listaTienda.size() );



}

}