/*Clase que modela la tienda que va a guardase la informacion de la misma , y organizar por medio de los CRUD
 */ 
package co.edu.unbosque.model;

import java.util.ArrayList;
/**
 * La clase Tienda contiene la informacion clave en relacion a las otras clases por ello se organiza con un 
 * arraylist con una clase que se manejaran los datos como un objeto.
 * 
 *
 * @author Moises Salcedo & Ricardo Sanchez
 */
public class Tienda {
     
	public String nombre;
	
	private ArrayList <Sucursal> sucursales;
	private ArrayList <Administrador> administradores;
	private ArrayList <Compra> compras;
	/**
	 * Es el constructor de la clase Tienda
	 * @param nombre de la tienda con la se encontrara cual tienda se manejara
	 */
	public Tienda(String nombre) {
		super();
		this.nombre = nombre;
		sucursales = new ArrayList<Sucursal>();
		administradores = new ArrayList<Administrador>();
		compras= new ArrayList<Compra>();
	}
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public ArrayList<Sucursal> getSucursales() {
		return sucursales;
	}
	public void setSucursales(ArrayList<Sucursal> sucursales) {
		this.sucursales = sucursales;
	}
	public ArrayList<Administrador> getAdministradores() {
		return administradores;
	}
	public void setAdministradores(ArrayList<Administrador> administradores) {
		this.administradores = administradores;
	}
	
	public ArrayList<Compra> getCompras() {
		return compras;
	}


	public void setCompras(ArrayList<Compra> compras) {
		this.compras = compras;
	}
	
	
	/**
	 * Este metodo busca las compras realizada en una surcursal que se pasa por parametro para encontrarla.
	 * 	<b>pre</b> el nombe sucursal este llena (que no sea null). <br>
	 * <b>post</b> se ha recorrido el objeto compras[] y retornado el log de compras  <br>
	 * @param nombresucursal
	 * @return
	 */
	public Compra[] buscarCompraSucursal( String nombresucursal) {
		int p=0;
		Compra[] logcompras= new Compra[noComprasSucursal(nombresucursal)];
		for (int i = 0; i < compras.size(); i++) {
			String aux=compras.get(i).getTienda();
		
			if(aux==nombresucursal) {
			Compra auxc=compras.get(i);
			logcompras[p]=auxc;
			p++;
			}
			
		}
			
			return logcompras;
	}
	/**
	 * Este metodo busca las compras realizadas en una surcursal que pasa por parametro y las retorna con log
	 * compras como un toString.
	 * 	<b>pre</b> el string nombresucursal no puede estar vacio (no deberia ser null). <br>
	 * <b>post</b> Encontrar en los datos guardados <br>
	 * @param nombresucursal donde se usa para identificar dentro del arreglo cual sucursal se esta buscando.
	 * @return retorna el log de compras como un arreglo de strings.
	 */
	public String[] CompraSucursal( String nombresucursal) {
		int p=0;
		String[] logcompras= new String[noComprasSucursal(nombresucursal)];
		for (int i = 0; i < compras.size(); i++) {
			String aux=compras.get(i).getTienda();
		
			if(aux==nombresucursal) {
			String auxc=compras.get(i).toString();
			logcompras[p]=auxc;
			p++;
			}
			
		}
			
			return logcompras;
	}
	/**
	 * Este metodo busca la cantidad de compras realizadas y las retorna
	 * <b>pre</b> el nombresucursal no deba ser vacia o null. <br>
	 * <b>post</b> Se use como mirar el log de datos de la sucursal la informacion que se quiera saber de ella <br>
	 * @param nombresucursal se utiliza para encontrar la sucursal deseada por el usuario
	 * @return un entero que es la compras realizadas en la tienda.
	 */
	public int noComprasSucursal(String nombresucursal) {
		int p=0;
		for (int i = 0; i < compras.size(); i++) {
			String aux=compras.get(i).getTienda();
		
			if(aux==nombresucursal) {
				p++;
			}
		}
		
		return p;
	}
	

	/**
	 * Este metodo busca al cliente para buscar cuantas compras este mismo realizo.
	 * <b>pre</b> el usercliente no deba ser vacia o null. <br>
	 * <b>post</b> Se use como mirar el log de datos de la sucursal la informacion que se quiera saber de ella <br>
	 * @param usercliente para saber que usuario se desea saber la cantidad de compras realizadas
	 * @return retorna un log de compras que realizo el usuario.
	 */
	public Compra[] buscarCompraCliente( String usercliente) {
		int p=0;
		Compra[] logcompras= new Compra[noComprasClientes(usercliente)];
		for (int i = 0; i < compras.size(); i++) {
			String aux=compras.get(i).getCliente();
		
			if(aux==usercliente) {
			Compra auxc=compras.get(i);
			logcompras[p]=auxc;
			p++;
			}
			
		}
			
			return logcompras;
	}
	/**
	 * Este metodo busca al cliente para buscar cuantas compra este mismo realizo y mostrarlo con un toString.
	 * <b>pre</b> el usercliente no deba ser vacia o null. <br>
	 * <b>post</b> Se use como mirar el log de datos de la sucursal la informacion que se quiera saber de ella <br>
	 * @param usercliente para saber que usuario se desea saber la cantidad de compras realizadas
	 * @return retorna el log de compras de cliente en un arreglo de strings
	 */
	
	public String[] compraCliente( String usercliente) {
		int p=0;
		String[] logcompras= new String[noComprasClientes(usercliente)];
		for (int i = 0; i < compras.size(); i++) {
			String aux=compras.get(i).getCliente();
		
			if(aux==usercliente) {
			String auxc=compras.get(i).toString();
			logcompras[p]=auxc;
			p++;
			}
			
		}
			
			return logcompras;
	}
	/**
	 * Este metodo busca al cliente para mostrar en enteros las compras realizadas.
	 * <b>pre</b> el usercliente no deba ser vacia o null. <br>
	 * <b>post</b> Se use como mirar el log de datos de la sucursal la informacion que se quiera saber de ella <br>
	 * @param usercliente para saber que usuario se desea saber la cantidad de compras realizadas
	 * @return retorna un entero que son las compras del cliente usercliente.
	 */
	
	public int noComprasClientes(String usercliente) {
		int p=0;
		for (int i = 0; i < compras.size(); i++) {
			String aux=compras.get(i).getCliente();
		
			if(aux==usercliente) {
				p++;
			}
		}	
		return p;
	}
	
	/**
	 * Este metodo asigna las surcursales guardadas y las iguala a un string[] y asi retornarlas.
	 * <b>pre</b> las surcursales  no deben ser vacia o null. <br>
	 * <b>post</b> Se ha encontrado las surcursales y retornadas para su uso <br>
	 * @return retorna los nombres de las sucursales en un arreglo de Strings
	 */
	
	
	public String[] nombreSucursales() {
		
		int p=sucursales.size();
		String[] nombresucursales=new String[p];
		for (int i = 0; i < sucursales.size(); i++) {
			nombresucursales[i]=sucursales .get(i).getNombre();
		}
		return nombresucursales;
	}
	/**
	 * Este metodo de ordenamiento se usa para ordenar las compras de Ascendente.
	 * <b>pre</b> el usercliente no debe ser vacia o null. <br>
	 * <b>post</b> Se use como mirar el log de datos de la sucursal la informacion que se quiera saber de ella <br>
	 * @param Compras es la cantidad de compras que se realizaron
	 * @return retorna un entero que son las compras del cliente usercliente ascendente
	 */
	public Compra[] ordenarComprasMayor(Compra[] compras) {
		int i,j;
		int num=compras.length;
		Compra temp;
		
		     for ( i = 0; i < num-1; i++) 
		        { 
		    
		            int min = i; 
		            for ( j = i+1; j < num; j++) 
		                if (compras[j].getPrecio() < compras[min].getPrecio()) 
		                    min = j; 
		  
		     
		            temp = compras[min]; 
		            compras[min] = compras[i]; 
		            compras[i] = temp; 
		        } 
		    
		
		
		
		return compras;
		
	
	}
	/**
	 * Este metodo de ordenamiento se usa para ordenar las compras de descendente
	 * <b>pre</b> el compras no debe ser vacia o null. <br>
	 * <b>post</b> Se use como mirar el log de datos de la sucursal la informacion que se quiera saber de ella <br>
	 * @param compras es la cantiad de compras que se realizaron 
	 * @return retorna las compras descendente 
	 */
	
	public Compra[] ordenarComprasMenor(Compra[] compras) {
		int i,j;
		int num=compras.length;
		Compra temp;
		
		     for ( i = 0; i < num-1; i++) 
		        { 
		    
		            int min = i; 
		            for ( j = i+1; j < num; j++) 
		                if (compras[j].getPrecio() > compras[min].getPrecio()) 
		                    min = j; 
		  
		     
		            temp = compras[min]; 
		            compras[min] = compras[i]; 
		            compras[i] = temp; 
		        } 
		return compras;
	} 
	
	
	@Override
	public String toString() {
		return "Super tiendas " + nombre ;
	}
  
	
}
