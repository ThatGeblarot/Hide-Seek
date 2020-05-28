package co.edu.unbosque.test;

import junit.framework.TestCase;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import co.edu.unbosque.model.Administrador;
import co.edu.unbosque.model.Sucursal;
import co.edu.unbosque.model.Tienda;
import co.edu.unbosque.model.persistence.ArchivoTiendas;
import co.edu.unbosque.model.persistence.TiendaDAO;
import junit.framework.TestCase;

public class TiendaDAOTest extends TestCase {

	TiendaDAO tienda;
	ArchivoTiendas archivoT;
	File fileTienda = new File("dataTest/basedatosTiendaTest.dat");
	ArrayList<Tienda> listaTienda;
	ArrayList<Sucursal> listaSucursal;
	ArrayList<Administrador> listaAdmin;

	Tienda Tienda_1;
	Tienda Tienda_2;
	Sucursal sucursal_1;
	Sucursal sucursal_2;
	Administrador admin_1;

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
		tienda = new TiendaDAO(archivoT);

		Tienda_1 = new Tienda("Tiendita bosque");
		Tienda_2 = new Tienda("Tiendita MarvelHeroes");
		sucursal_1 = new Sucursal("cra1340", "Unibostienda");
		sucursal_2 = new Sucursal("cra176", "guante del infinito");
		admin_1 = new Administrador("Thanos", "unAlmaPorOtraAlma");

		listaTienda.add(Tienda_1);
		listaTienda.add(Tienda_2);
		listaSucursal.add(sucursal_1);
		listaSucursal.add(sucursal_2);
		listaAdmin.add(admin_1);

	}

	public void testTiendaDAO() {
		setupEscenario();

		assertEquals("La cantidad de tiendas debe ser 2", 2, listaTienda.size());
		assertEquals("La cantidad de sucursales debe ser 2", 2, listaSucursal.size());
		assertEquals("La cantidad de sucursales debe ser 1", 1, listaAdmin.size());
	}

	public void testAgregarTienda() throws IOException {
		assertEquals("Se debió agregar la tienda", true, tienda.agregarTienda(listaTienda, Tienda_1.getNombre()));
		assertFalse("No se debería agregar una tienda ya existente",
				tienda.agregarTienda(listaTienda, "Tiendita bosque"));
	}

}
