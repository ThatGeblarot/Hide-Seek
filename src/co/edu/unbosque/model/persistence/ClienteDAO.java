package co.edu.unbosque.model.persistence;

import java.io.IOException;
import java.util.ArrayList;

import co.edu.unbosque.model.Cliente;
import co.edu.unbosque.model.Pareja;
/**
 * Esta clase contiene todos los métodos relacionados con el manejo de clientes inscritos.
 * @author Moises Salcedo
 */
public class ClienteDAO {
	
	
private ArchivoClientes archivo;
	
	/**
	 * Este es el constructor de la clase ClienteDAO
	 * el objeto de clase ArchivoTiendas ha sido creado previamente <br>
	 * <b>post</b> Se ha creado la clase ClienteDAO <br>
	 * @param ar es el objeto de archivo clienes
	 */
	public ClienteDAO(ArchivoClientes ar){
		archivo= ar;
	}
	
	/**
	 * Este método retorna un cliente que coincida con un user específico. 
	 * <b>pre</b> el ArrayList de clientes está inicializado (no es null). <br>
	 * <b>post</b> Se ha retornado el objeto cliente con el user especificado <br>
	 * @param userid es la identificación de usuario del cliente inscrito.
	 * @param clientes es el ArrayList de los clientes inscritos.
	 * @return se retorna un objeto del tipo ciudadano.
	 */
	

	public Cliente buscarCliente(ArrayList<Cliente> clientes, String userid){
		Cliente encontrado= null;
		for(int i=0; i<clientes.size(); i++){
			if(clientes.get(i).getUserid().contentEquals(userid)){
				encontrado= clientes.get(i);
			}
		}
		return encontrado;
	}
	
	
	/**
	 * Este método muestra la información de cliente en un string
	 * @param clientes es el ArrayList de los clientes inscritos.
	 * @param userid es la identificación de usuario del cliente inscrito.
	 * @return se retorna un string con la información del cliente
	 */
	public String verCliente(ArrayList<Cliente> clientes, String userid){
		String info= "";
		if(buscarCliente(clientes, userid) == null){
			return null;
		}else{
			info= buscarCliente(clientes, userid).toString();
			return info;
		}
	}
	
	
	/**
	 * Este metodo sirve para actualizar atriutos básicos del cliente como nombre, 
	 * userid y correo.
	 * <b>pre</b> el ArrayList de clientes esta inicializado (no es null). <br>
	 * <b>post</b> Se han cambiado los atributos del cliente usuario especifico <br>
	 * @param clientes clientes es el ArrayList de los clientes inscritos.
	 * @param userid es la identificación de usuario del cliente inscrito.
	 * @param nuevouser es el nuevo valor de userid a actualizar
	 * @param correo es el correo nuevo del cliente
	 * @param nombre es el nuevo nombre del cliente
	 * @return el cliente fue actualizado
	 */
	public boolean actualizarCliente(ArrayList<Cliente> clientes,String userid,  String nuevouser, String correo, String nombre){
		Cliente c=buscarCliente(clientes, userid);
		if(c==null) {
			return false;
		}else {
			c.setNombre(nombre);
			c.setCorreo(correo);
			c.setUserid(nuevouser);
			getArchivo().getArchivo().delete();
			try {
				getArchivo().getArchivo().createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			getArchivo().escribirEnArchivo(clientes);
			return true;
		}
	}
	
	/**
	 * Este metodo sirve para cambiar el cupo del cliente
	 * <b>pre</b> el ArrayList de clientes esta inicializado (no es null). <br>
	 * <b>post</b> Se ha cambiado el cupo del cliente usuario especifico <br>
	 * @param clientes es el ArrayList de los clientes inscritos.
	 * @param userid es la identificación de usuario del cliente inscrito.
	 * @param nuevocupo es el nuevo cupo del cliente
	 * @return el cliente fue actualizado
	 */
	public boolean asignarCupoCliente(ArrayList<Cliente> clientes,String userid, double nuevocupo){
		Cliente c=buscarCliente(clientes, userid);
		if( c== null){
			return false;
		}else {
			c.setCupo(nuevocupo);	
			getArchivo().getArchivo().delete();
			try {
				getArchivo().getArchivo().createNewFile();
			} catch (IOException e) {
				
				e.printStackTrace();
			}
			getArchivo().escribirEnArchivo(clientes);
			return true;			
		
		}
	}
	
	/**
	 * Este metodo agrega un cliente
	 * <b>pre</b> el ArrayList de clientes esta inicializado (no es null). <br>
	 * <b>post</b> Se ha retornado el cliente con el usuario especifico <br>
	 * @param clientes es el ArrayList de los clientes inscritos.
	 * @param nombre es el nombre del cliente
	 * @param cupo es el cupo de la tarjeta del cliente
	 * @param userid es el usuario del cliente
	 * @param correo es el correo del cliente
	 * @param contraseña es la contraseña del cliente
	 * @param genero es la contraseña del cliente
	 * @return se ha agregado el cliente
	 */

	
	public boolean agregarCliente(ArrayList<Cliente> clientes, String nombre, double cupo, String userid, String correo, String contraseña, String genero){
		Cliente nuevo= new Cliente(nombre,cupo, userid,correo, contraseña,genero);
		if(buscarCliente(clientes, userid) == null){
			clientes.add(nuevo);
			getArchivo().escribirEnArchivo(clientes);
			return true;
		}else {
			return false;			
		}
	}
	
	/**
	 * Este metodo elimina un cliente
	 * <b>pre</b> el ArrayList de clientes esta inicializado (no es null). <br>
	 * <b>post</b> Se ha eliminado el cliente con el usuario especifico <br>
	 * @param clientes es el ArrayList de los clientes inscritos.
	 * @param userid es el usuario del cliente
	 * @return retorna true si se elimina el cliente y false sino se elimina
	 */
	public boolean eliminarCliente(ArrayList<Cliente> clientes, String userid){
		try {
			if(buscarCliente(clientes, userid) == null){
				return false;
			}else{
				clientes.remove(buscarCliente(clientes, userid));
				getArchivo().getArchivo().delete();
				getArchivo().getArchivo().createNewFile();
				getArchivo().escribirEnArchivo(clientes);
				return true;
			}
		} catch (IOException e) {
			System.out.println("Eliminar Cliente: " +e.getMessage());
			return false;
		}
	}
	
	
	/**
	 * Esta clase compara la contraseña ingresada con la del cliente
	 * <b>pre</b> el ArrayList de clientes esta inicializado (no es null). <br>
	 * <b>post</b> Se ha verificado si las contraseñas concuerdan <br>
	 * @param clientesclientes es el ArrayList de los clientes inscritos.
	 * @param userid es el usuario del cliente
	 * @param contraseña es la contraseña del cliente a comparar
	 * @return retorna true si coinciden las contraseñas y false sino coinciden.
	 */
	
	//metodo de verificar pasword cliente
	public boolean verificarPswdCliente(ArrayList<Cliente> clientes, String userid, String contraseña) {
		Cliente c=buscarCliente(clientes,userid);
		if (c==null){
			return false;
		}else {
			if (c.getContraseña().equals(contraseña)==true) {
			 
			 return true;
			}else {
			 return false;
			}
		 
		}
		
	
	}
	
	/**
	 * Este metodo agrega una pareja
	 * <b>pre</b> los ArrayList de clientes y parejas estan inicializados (no son null)  <br>
	 * <b>post</b> Se ha agregado la pareja a el usuario especifico <br>
	 * @param clientes es el ArrayList de los clientes inscritos.
	 * @param nombre es el nombre de la pareja
	 * @param cupo es el cupo de la tarjeta de la pareja
	 * @param userid es el usuario del cliente
	 * @param userpareja es el usuario de la pareja
	 * @param correo es el correo de la pareja
	 * @param contraseña es la contraseña de la pareja
	 * @param genero es el genero de la pareja
	 * @return true si se agrega la pareja, false si el user de la pareja ya existe
	 */
	
	
	public boolean agregarPareja(ArrayList<Cliente> clientes,String userid	, String nombre, double cupo, String userpareja, String correo, String contraseña, String genero){
		Pareja nuevo= new Pareja( nombre,  cupo, userid,correo, contraseña,  genero);
		Cliente c=buscarCliente(clientes, userid);
		if( buscarPareja(c,userpareja)== null){
			c.getParejas().add(nuevo);
			getArchivo().escribirEnArchivo(clientes);
			return true;
		}else {
			return false;			
		}
	}
	
	/**
	 * Este método compara la clave real de la pareja con una enviada desde el login.
	 * <b>pre</b> la pareja se encuentra en el arraylist de parejas  <br>
	 * <b>post</b> Se ha verificado si las contraseñas coinciden<br>
	 * @param c es el objeto cliente
	 * @param userpareja es el user de la pareja
	 * @param clavepareja es la clave de la pareja a comparar con la que está guardada.
	 * @return true si coinciden las contraseñas y false sino coinciden.
	 */
	
	//metodo para verificar password de pareja
	public boolean verificarPswdPareja(Cliente c, String userpareja, String clavepareja) {
		Pareja d=buscarPareja(c,userpareja);
		if (d==null){
			return false;
		}else {
			if (d.getContraseña().equals(clavepareja)==true) {
			 
			 return true;
			}else {
			 return false;
			}
		 
		}
		
	}
	
	/**
	 * Este método se usa para agregar las restriccciones de horario a parejas
	 * <b>pre</b> los ArrayList de clientes y parejas estan inicializados (no son null)  <br>
	 * <b>post</b> Se ha agregado la restriccion a la pareja de el usuario especifico <br>
	 * @param clientes es el ArrayList de los clientes inscritos.
	 * @param userid es el suaurio del cliente
	 * @param userpareja es el usuario de la pareja del cliente
	 * @param dia es el día cuando puede comprar la pareja
	 * @param inicio es la hora de inicio en la que puede comprar la pareja
	 * @param fin es la hora final en la que puede comprar la pareja
	 * @return true si se agrega la restriccion y false sino se hace
	 */
	
	
	//agregar las restricciones de horario a la pareja
	public boolean agregarHorario(ArrayList<Cliente> clientes,String userid, String userpareja, String dia, String inicio, String fin){
		
		Cliente c=buscarCliente(clientes, userid);
		Pareja p=buscarPareja(c,userpareja);
		if( p.getDia()== null){
			p.setDia(dia);
			p.setInicio(inicio);
			p.setFin(fin);
			
			getArchivo().getArchivo().delete();
			try {
				getArchivo().getArchivo().createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			getArchivo().escribirEnArchivo(clientes);
			return true;
		}else {
			return false;			
		}
	}
	

	/**
	 * Este metodo sirve para actualizar atributos básicos de la pareja como nombre, 
	 * userid y correo.
	 * <b>pre</b> el ArrayList de clientes esta inicializado (no es null). <br>
	 * <b>post</b> Se han cambiado los atributos de la pareja con usuario especifico <br>
	 * @param clientes clientes es el ArrayList de los clientes inscritos.
	 * @param userid es la identificación de usuario del cliente inscrito.
	 * @param userpareja es el user de la pareja
	 * @param nuevouser es el nuevo valor de userid a actualizar
	 * @param correo es el correo nuevo de la pareja
	 * @param nombre es el nuevo nombre de la pareja
	 * @return true si la pareja fue actualizada false sino fue actualizada
	 */
	
	public boolean actualizarPareja(ArrayList<Cliente> clientes,String userid, String userpareja, String nuevouser, String correo, String nombre){
		
		Cliente c=buscarCliente(clientes, userid);
		Pareja p=buscarPareja(c,userpareja);
		if( p== null){
		return false;
		}else {
			p.setNombre(nombre);
			p.setCorreo(correo);
			p.setUserid(nuevouser);
			
			getArchivo().getArchivo().delete();
			try {
				getArchivo().getArchivo().createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			getArchivo().escribirEnArchivo(clientes);
			return true;			
		}
	}
	
	/**
	 * <b>pre</b> el ArrayList de clientes esta inicializado (no es null). <br>
	 * <b>post</b> Se han cambiado los atributos de la pareja con usuario especifico <br>
	 * @param clientes es el ArrayList de clientes
	 * @param userid es el usuario del cliente al que pertenece la pareja
	 * @param userpareja es el usuario de la pareja del cliente
	 * @param nuevocupo es el nuevo vupo de la pareja
	 * @return true si se actualiza el cupo y false sino se hace
	 */
	
	public boolean AsignarCupoPareja(ArrayList<Cliente> clientes,String userid, String userpareja, double nuevocupo){
		
		Cliente c=buscarCliente(clientes, userid);
		Pareja p=buscarPareja(c,userpareja);
		if( p== null){
			return false;
		}else {
			p.setCupo(nuevocupo);
			getArchivo().getArchivo().delete();
			try {
				getArchivo().getArchivo().createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			getArchivo().escribirEnArchivo(clientes);
			return true;			
		}
	}
	
	
	/**
	 * Este metodo elimina una pareja de un cliente
	 * <b>pre</b> el ArrayList de clientes esta inicializado (no es null). <br>
	 * <b>post</b> Se ha eliminado la pareja con el usuario especifico <br>
	 * @param clientes es el ArrayList de los clientes inscritos.
	 * @param userpareja es el usuario de la pareja
	 * @param c es el objeto de cliente donde se encuentra la pareja
	 * @return retorna true si se elimina la pareja y false sino se elimina
	 */
	
	public boolean eliminarPareja(Cliente c, String userpareja,ArrayList<Cliente> clientes){
		ArrayList <Pareja> d=c.getParejas();
		try {
			if( d== null){
				return false;
			}else{
				d.remove(buscarPareja(c, userpareja));
				getArchivo().getArchivo().delete();
				getArchivo().getArchivo().createNewFile();
				getArchivo().escribirEnArchivo(clientes);
				return true;
			}
		} catch (IOException e) {
			System.out.println("Eliminar Pareja: " +e.getMessage());
			return false;
		}
	}
	
	
	/**
	 * Este método retorna una pareja que coincida con un user específico. 
	 * <b>pre</b> el ArrayList de parejas está inicializado (no es null). <br>
	 * <b>post</b> Se ha retornado el objeto pareja con el user especificado <br>
	 * @param userid es la identificación de usuario de la pareja inscrita.
	 * @param c es el cliente a donde fue asiganada la pareja
	 * @return se retorna un objeto del tipo pareja.
	 */
	
	
	public Pareja buscarPareja(Cliente c, String userpareja) {
		ArrayList <Pareja> d=c.getParejas();
		
		for (int i = 0; i < d.size(); i++) {
			if(d.get(i).getUserid().equals(userpareja)) {
				return d.get(i);
			}
			
		}
		
		return null;
	}
	
	
	
	
	
	
	public ArchivoClientes getArchivo() {
		return archivo;
	}

}
