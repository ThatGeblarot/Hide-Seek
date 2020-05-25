package co.edu.unbosque.model;

public class Compra {
	
	private String date;
	private String tienda;
	private String cliente;
	private String pareja;
	private double precio;
	
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
		return "Compra [date=" + date + ", tienda=" + tienda + ", cliente=" + cliente + ", pareja=" + pareja + ", precio=" + precio + "]";
	}
	
	
	

}
