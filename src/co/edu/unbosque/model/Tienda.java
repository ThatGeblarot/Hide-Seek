package co.edu.unbosque.model;

public class Tienda {

	private String idtienda;
	private String direcci�n;
	
	
	public Tienda(String idtienda, String direcci�n) {
		super();
		this.idtienda = idtienda;
		this.direcci�n = direcci�n;

	}
	
	public String getIdtienda() {
		return idtienda;
	}
	public void setIdtienda(String idtienda) {
		this.idtienda = idtienda;
	}
	public String getDirecci�n() {
		return direcci�n;
	}
	public void setDirecci�n(String direcci�n) {
		this.direcci�n = direcci�n;
	}

	
}
