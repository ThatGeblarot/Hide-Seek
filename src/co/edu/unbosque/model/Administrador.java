/*Clase que modela un admin que va a administrar el programa y usarlo
 */ 
package co.edu.unbosque.model;
/**
 * La clase Administrador contiene la informacion de clave y usuario que pertene al mismo,donde
 * se usara esos datos para logear y usar el aplicativo para cada tipo de requerimiento del programa
 * @author Moises Salcedo & Ricardo Sanchez
 */

public class Administrador {
	private String adminuser;
	private String password;
	/**
	 * Es el constructor de la clase Administrador
	 * @param adminuser es el userid de admin para identificar en login
	 * @param password es la clave que se usara para identificar el admin en login
	 */
	public Administrador(String adminuser, String password) {
		super();
		this.adminuser = adminuser;
		this.password = password;
	}

	public String getAdminuser() {
		return adminuser;
	}

	public void setAdminuser(String adminuser) {
		this.adminuser = adminuser;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
	 
	
}
