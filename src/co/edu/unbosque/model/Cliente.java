package co.edu.unbosque.model;

import java.io.Serializable;
import java.util.ArrayList;
/**
 * 
 * La clase Cliente posee toda la informacion que es necesaria para la validacion
 * de los usuarios.
 * @author Moises Salcedo & Ricardo Sanchez
 * 
 */
public class Cliente implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String nombre;
	private double cupo;
	private String userid;
	private String correo;
	private String contrase�a;
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
     * @param contrase�a es un string que se usa para validad si el registro realmente lo hace ese mismo usuario.
     * @param genero es el string que indica el sexo del cliente.
     */
	
	
	public Cliente(String nombre, double cupo,String userid, String correo, String contrase�a, String genero) {
		super();
		this.nombre = nombre;
		this.cupo = cupo;
		this.userid = userid;
		this.correo = correo;
		this.contrase�a = contrase�a;
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

	/**
	 * este m�todo retorna el valor restante que puede gastar el cliente
	 * @return retorna el saldo disponible
	 */
	public double saldoCliente() {
		
		return cupo-gasto;
	}
	
	
	
	
	
	/**
	 * Este m�todo retorna un array con los nombres de las parejas 
	 * <b>pre</b> LA clase cliente est� incializada<br>
	 * @return se retorna un arreglo de strings con el nombre de las parejas
	 * <b>post</b> Se ha retornado el arraylist con el  nombre de pareja <br>
	 */
	
	//m�todo que muestra nombre de parejas de un cliente
	public String[] listarParejas() {
	int c=parejas.size();
	
	String[] nombreparejas=new String[c];
	
		for (int i = 0; i < c; i++) {
			nombreparejas[i]=parejas.get(i).getNombre();
		}
		
		return nombreparejas;
	}
	
	@Override
	public String toString() {
		return nombre+" con userID "+userid+ " y correo "+ correo +" tiene "+saldoCliente()+" de saldo restante";
	}
	
	
	
}
