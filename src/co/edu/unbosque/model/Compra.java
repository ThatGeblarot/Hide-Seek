package co.edu.unbosque.model;

import java.io.Serializable;
/**
 * La clase Compra contiene la informacion de 
 * @author Moises Salcedo
 */
public class Compra implements Serializable{
	
	private String date;
	private String tienda;
	private String cliente;
	private String pareja;
	private double precio;
	/**
     * Este es el constructor de la clase Compra
     * @param date fecha de la compra
     * @param tienda tienda donde se realizo la compra
     * @param cliente quien compro algo en la tienda
     * @param pareja la pareja del cliente
     * @param precio valor que gasto en la compra
     */
	public Compra(String date, String tienda, String cliente, String pareja, double precio) {
		super();
		this.date = date;
		this.tienda = tienda;
		this.cliente = cliente;
		this.pareja = pareja;
	
		this.precio = precio;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getTienda() {
		return tienda;
	}
	public void setTienda(String tienda) {
		this.tienda = tienda;
	}
	public String getCliente() {
		return cliente;
	}
	public void setCliente(String cliente) {
		this.cliente = cliente;
	}
	public String getPareja() {
		return pareja;
	}
	public void setPareja(String pareja) {
		this.pareja = pareja;
	}
	
	public double getPrecio() {
		return precio;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	
	@Override
	public String toString() {
		return precio+" "+tienda+" "+cliente+" "+pareja+" "+date;
	}
	
	
	

}
