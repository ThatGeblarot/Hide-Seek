package co.edu.unbosque.model;

public class Pareja {
	
	private String nombre;
	private double cupo;
	private String userid;//este es el user id de pareja
	private String correo;
	private String contraseña;
	private String genero;
	private String tipo;
	private double gasto;
	private String dia;
	private String inicio;
	private String fin;
	
	
	
	
	public Pareja(String nombre, double cupo, String userid, String correo, String contraseña, String genero) {
		super();
		this.nombre = nombre;
		this.cupo = cupo;
		this.userid = userid;
		this.correo = correo;
		this.contraseña = contraseña;
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
	public String getContraseña() {
		return contraseña;
	}
	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
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
