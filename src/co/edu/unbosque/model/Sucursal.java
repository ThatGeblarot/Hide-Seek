/*Clase que modela una sucursal que va a simular la sucursal de una tienda*/
package co.edu.unbosque.model;
/**
 * La clase Sucursal contiene la informacion de la direccion y el nombre por cual es definido 
 * y puede ser buscado en el programa.
 * @author Moises Salcedo
 *
 */


public class Sucursal {
	
	private String direccion;
	private String  nombre;
	
	/**
     * Es el contructor de la clase Sucursal
     * @param direcci�n donde se encuentra la sucursal
     * @param nombre de la sucursal
     */
	public Sucursal(String direccion, String nombre) {
		super();
		this.direccion = direccion;
		this.nombre = nombre;
		
		
	}
	
	
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	

	
	
}
