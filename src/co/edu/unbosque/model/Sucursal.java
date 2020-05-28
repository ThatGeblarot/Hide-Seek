package co.edu.unbosque.model;
/**
 * La clase Sucursal contiene la informacion de la direccion y el nombre por cual es definido 
 * y puede ser buscado en el programa.
 * @author Moises Salcedo
 *
 */


public class Sucursal {
	
	private String dirección;
	private String  nombre;
	
	/**
     * Es el contructor de la clase Sucursal
     * @param dirección donde se encuentra la sucursal
     * @param nombre de la sucursal
     */
	public Sucursal(String dirección, String nombre) {
		super();
		this.dirección = dirección;
		this.nombre = nombre;
		
		
	}
	
	
	public String getDirección() {
		return dirección;
	}
	public void setDirección(String dirección) {
		this.dirección = dirección;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	

	
	
}
