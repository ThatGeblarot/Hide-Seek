/*Clase que modela la tienda que va a guardase la informacion de la misma , y organizar por medio de los CRUD
 */ 
package co.edu.unbosque.model;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * La clase Tienda contiene la informacion clave en relacion a las otras clases por ello se organiza con un 
 * arraylist con una clase que se manejaran los datos como un objeto.
 * @author Moises Salcedo 
 */


public class Tienda implements Serializable {
	private static final long serialVersionUID = 1L;

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
     *     <b>pre</b> el nombe sucursal este llena (que no sea null). <br>
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
     *     <b>pre</b> el string nombresucursal no puede estar vacio (no deberia ser null). <br>
     * <b>post</b> Encontrar en los datos guardados <br>
     * @param nombresucursal donde se usa para identificar dentro del arreglo cual sucursal se esta buscando.
     * @return retorna el log de compras como un arreglo de strings.
     */
	//retorna el log de compras como un arreglo de strings
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
	//comprascliente
	
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
	
	/**
     * Este metodo busca al cliente para buscar cuantas compra este mismo realizo y mostrarlo con un toString.
     * <b>pre</b> el usercliente no deba ser vacia o null. <br>
     * <b>post</b> Se use como mirar el log de datos de la sucursal la informacion que se quiera saber de ella <br>
     * @param usercliente para saber que usuario se desea saber la cantidad de compras realizadas
     * @return retorna el log de compras de cliente en un arreglo de strings
     */
	//retorna el log de compras de cliente en un arreglo de strings
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
	
	/**
     * Este metodo asigna las surcursales guardadas y las iguala a un string[] y asi retornarlas.
     * <b>pre</b> las surcursales  no deben ser vacia o null. <br>
     * <b>post</b> Se ha encontrado las surcursales y retornadas para su uso <br>
     * @return retorna los nombres de las sucursales en un arreglo de Strings
     */
	//Este m�todo retorna los nombres de las sucursales en un arreglo de Strings
	
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
	//se ordenan las compras ascendentemente con bubble sort
	public Compra[] ordenarComprasAscendente(Compra[] compras) {
		int i,j;
		int num=compras.length;
		Compra temp;
		
	    for (i = 0; i < ( num - 1 ); i++) {
	        for (j = 0; j < num - i - 1; j++) {
	          if (compras[j].getPrecio() > compras[j+1].getPrecio()) 
	          {
	             temp = compras[j];
	             compras[j] = compras[j+1];
	             compras[j+1] = temp;
	          }
	        }
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
	
	//se calcula la media
	public double calcularMedia(Compra[] compras) {
		int n=compras.length;
		double suma=0;
		double promedio;
		for (int i = 0; i < compras.length; i++) {
			
			suma=suma+compras[i].getPrecio();
		}
		
		try {
		promedio=suma/n;
		
		return promedio;
		}	
		catch(ArithmeticException e)
		{
		return 0;
		}
	}
	
	
	//se calcula la mediana
			public double calcularMediana(Compra[] compras) {
		        
				Compra[] newcompras=ordenarComprasAscendente(compras);
		        int n=compras.length;
		    
		        if (n % 2 != 0) 
		            return (double)newcompras[n / 2].getPrecio(); 
		  
		        return (double)(newcompras[(n - 1) / 2].getPrecio() + newcompras[n / 2].getPrecio()) / 2.0; 
			
		}
	
	
	
	//se calcula la moda
	public double calcularModa(Compra[] compras) {
		double maxvalue = -1.0d;
		double tolerancia=0.1;
		int maxCount = 0;
		for (int i = 0; i < compras.length; ++i) {
		    double currentValue = compras[i].getPrecio();
		    int currentCount = 1;
		    for (int j = i + 1; j < compras.length; ++j) {
		        if (Math.abs(compras[j].getPrecio() - currentValue) < tolerancia) {
		            ++currentCount;
		        } 
		    }
		    if (currentCount > maxCount) {
		        maxCount = currentCount;
		        maxvalue = currentValue;
		    } else if (currentCount == maxCount) {
		        maxvalue = Double.NaN;
		    }
		}
			return maxvalue;
		}
		
	/**
     * Este metodo de ordenamiento se usa para ordenar las compras de descendente
     * <b>pre</b> el compras no debe ser vacia o null. <br>
     * <b>post</b> Se use como mirar el log de datos de la sucursal la informacion que se quiera saber de ella <br>
     * @param compras es la cantiad de compras que se realizaron 
     * @return retorna las compras descendente 
     */
	//se ordena la compra descendentemente con selection sort
	public Compra[] ordenarComprasDescendente(Compra[] compras) {
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
		return "Super tiendas " + nombre+". \n Contamos con "+sucursales.size()+ " sucursales para su comodidad";
	}
  
	
}
