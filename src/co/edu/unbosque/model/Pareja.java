package co.edu.unbosque.model;

public class Pareja {
	
	private String nombre;
	private double cupo;
	private String userid;
	private String correo;
	private String contrase�a;
	private String genero;
	private String tipo;
	
	
	
	
	public Pareja(String nombre, double cupo, String userid, String correo, String contrase�a, String genero) {
		super();
		this.nombre = nombre;
		this.cupo = cupo;
		this.userid = userid;
		this.correo = correo;
		this.contrase�a = contrase�a;
		this.genero = genero;
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
	public String getContrase�a() {
		return contrase�a;
	}
	public void setContrase�a(String contrase�a) {
		this.contrase�a = contrase�a;
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

	
	
	
	
	

}