/*Clase que modela un los clientes  quienes van a ser los usuarios del programa
 */ 
package co.edu.unbosque.model;
/**
 * 
 * La clase Cliente posee toda la informacion que es necesaria para la validacion
 * de los usuarios.
 * @author Moises Salcedo & Ricardo Sanchez
 * 
 */
import java.util.ArrayList;

public class Cliente {

	private String nombre;
	private double cupo;
	private String userid;
	private String correo;
	private String contraseña;
	private String genero;
	private String tipo;
	private double gasto;
	private ArrayList <Pareja> parejas;
	
	/**
	 * Este es el constructor de la clase Cliente
	 * @param Nombre es la informacion basica de usuario que se diferencia por un nombre propio.
	 * @param cupo es un double que se utiliza para cuanto dinero tiene en su cuenta cada usuario.
	 * @param userid se utiliza principalmente como nombre de usuario y se implementa para la logica se usa para la logica
	 * de los requerimientos pertinentes del programa, como busqueda, comprar, etc.
	 * @param correo informacion basica del usuario.
	 * @param contraseña es un string que se usa para validad si el registro realmente lo hace ese mismo usuario.
	 * @param genero es el string que indica el sexo del cliente.
	 */
	
	public Cliente(String nombre, double cupo,String userid, String correo, String contraseña, String genero) {
		super();
		this.nombre = nombre;
		this.cupo = cupo;
		this.userid = userid;
		this.correo = correo;
		this.contraseña = contraseña;
		this.genero = genero;
		this.tipo = "0";
		this.gasto=0;
		parejas = new ArrayList<Pareja>();
		
	}
	
	
	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
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


	public double getGasto() {
		return gasto;
	}


	public void setGasto(double gasto) {
		this.gasto = gasto;
	}


	public ArrayList<Pareja> getParejas() {
		return parejas;
	}

	public void setParejas(ArrayList<Pareja> parejas) {
		this.parejas = parejas;
	}


	public double saldoCliente() {
		
		return cupo-gasto;
	}
	/**
	 * método que muestra nombre de parejas de un cliente
	 * <b>pre</b> La lista de ciudadanos debera estar inicializada (no puede ser null). <br>
	 * <b>post</b> Se ha registrado una cantidad estimada minima en parejas para que no este vacio el mismo string[] <br>
	 * @return se retorna un arreglo tipo string que entragaria los nombres de la parejas.
	 */
	public String[] listarParejas() {
	int c=parejas.size();
	
	String[] nombreparejas=new String[c];
	
		for (int i = 0; i < c; i++) {
			nombreparejas[i]=parejas.get(i).getNombre();
		}
		
		return nombreparejas;
	}
	/**
	 * metodo que muestra la informacion por medio de un metodo toString().
	 * @return se retorna un String con la  informacion deseada.
	 */
	@Override
	public String toString() {
		return nombre+" con userID "+userid+ " y correo "+ correo +" tiene "+saldoCliente()+" de saldo restante";
	}
	
	
	
}
