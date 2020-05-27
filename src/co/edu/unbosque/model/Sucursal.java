package co.edu.unbosque.model;



public class Sucursal {
	
	private String dirección;
	private String  nombre;
	
	
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
