/*Clase que modela una sucursal que va a simular la sucursal de una tienda*/
package co.edu.unbosque.model;
/**
 * La clase Sucursal contiene la informacion de la direccion y el nombre por cual es definido 
 * y puede ser buscado en el programa.
 * @author Moises Salcedo
 *
 */


public class Sucursal {
	
	private String direcci�n;
	private String  nombre;
	
	/**
     * Es el contructor de la clase Sucursal
     * @param direcci�n donde se encuentra la sucursal
     * @param nombre de la sucursal
     */
	public Sucursal(String direcci�n, String nombre) {
		super();
		this.direcci�n = direcci�n;
		this.nombre = nombre;
		
		
	}
	
	
	public String getDirecci�n() {
		return direcci�n;
	}
	public void setDirecci�n(String direcci�n) {
		this.direcci�n = direcci�n;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	

	
	
}
