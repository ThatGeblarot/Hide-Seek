/*Clase que modela las parejas que van a hacer administradas por el usuario*/
package co.edu.unbosque.model;

import java.io.Serializable;

/**
 * La clase pareja contiene la informacion de los datos basico que necesita una pareja 
 * para ser identificado/
 * @author Moises Salcedo
 */
public class Pareja implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private String nombre;
	private double cupo;
	private String userid;//este es el user id de pareja
	private String correo;
	private String contrasena;
	private String genero;
	private String tipo;
	private double gasto;
	private String dia;
	private String inicio;
	private String fin;
	
	/**
     * Es el Constructor de Pareja
     * @param nombre de la pareja
     * @param cupo dinero o alcancia a su cuenta
     * @param userid usuario que la identifica
     * @param correo informacion adicional
     * @param contrasena dato para verificar si es la misma pareja quien se registra
     * @param genero define su genero 
     */
	
	
	public Pareja(String nombre, double cupo, String userid, String correo, String contrasena, String genero) {
		super();
		this.nombre = nombre;
		this.cupo = cupo;
		this.userid = userid;
		this.correo = correo;
		this.contrasena = contrasena;
		this.genero = genero;
		this.gasto=0;
		this.dia=null;
		this.inicio=null;
		this.fin=null;
		this.tipo="1";
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public double getCupo() {
		return cupo;
	}
	public void setCupo(double cupo) {
		this.cupo = cupo;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getCorreo() {
		return correo;
	}
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	public String getcontrasena() {
		return contrasena;
	}
	public void setcontrasena(String contrasena) {
		this.contrasena = contrasena;
	}
	public String getGenero() {
		return genero;
	}
	public void setGenero(String genero) {
		this.genero = genero;
	}
	public String getTipo() {
		return tipo;
	}

	public double getGasto() {
		return gasto;
	}

	public void setGasto(double gasto) {
		this.gasto = gasto;
	}

	public double saldoPareja() {
		double sal=cupo-gasto;
		return sal;
	}

	public String getDia() {
		return dia;
	}

	public void setDia(String dia) {
		this.dia = dia;
	}

	public String getInicio() {
		return inicio;
	}

	public void setInicio(String inicio) {
		this.inicio = inicio;
	}

	public String getFin() {
		return fin;
	}

	public void setFin(String fin) {
		this.fin = fin;
	}

	@Override
	public String toString() {
		return nombre + " "+ userid+"tiene un saldo restante de "+saldoPareja(); 
	}
	
	
	
	

}
