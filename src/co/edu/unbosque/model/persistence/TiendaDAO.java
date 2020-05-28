package co.edu.unbosque.model.persistence;

import java.io.IOException;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import co.edu.unbosque.model.Tienda;
import co.edu.unbosque.model.Administrador;
import co.edu.unbosque.model.Compra;
import co.edu.unbosque.model.Pareja;
import co.edu.unbosque.model.Sucursal;
import co.edu.unbosque.model.Cliente;


public class TiendaDAO {
	
/**
 * Esta clasecontiene todos los métodos relacionados con el manejo de la tiendas, sucursales y compras.
 */
	
private ArchivoTiendas archivo;
	
/**
 * Este es el constructor de la clase TiendaDAO
 * @param ar es el archivo de la clase ArchivoTiendas
 */
	public TiendaDAO(ArchivoTiendas ar){
		archivo= ar;
	}
	
	
	/**
	 * Este metodo sirve para buscar el objeto de tiendas
	 * <b>pre</b> el ArrayList de tiendas esta inicializado (no es null). <br>
	 * <b>post</b> Se ha encontrado la tienda y se deuelve <br>
	 * @param tiendas es el arraylist de tiendas
	 * @param nombretienda es el nombre de la tienda que buscamos
	 * @return se retorna el o bjeto de tienda correspondiente al nombre.
	 */
	public Tienda buscarTienda(ArrayList<Tienda> tiendas, String nombretienda){
		Tienda encontrado= null;
		for(int i=0; i<tiendas.size(); i++){
			if(tiendas.get(i).getNombre().contentEquals(nombretienda)){
				encontrado= tiendas.get(i);
			}
		}
		return encontrado;
	}
	
	
	/**
	 * Este método muestra el string con la información de la tienda
	 * <b>pre</b> el ArrayList de tiendas esta inicializado (no es null). <br>
	 * <b>post</b> Se ha encontrado la tienda y se deuelve el string con su información<br>
	 * @param tiendas es el arraylist de tiendas
	 * @param nombretienda es el nombre de la tienda que buscamos
	 * @return se muestra el string con la información de la tienda
	 */
	public String verTienda(ArrayList<Tienda> tiendas, String nombretienda){
		String info= "";
		if(buscarTienda(tiendas, nombretienda) == null){
			return null;
		}else{
			info= buscarTienda(tiendas, nombretienda).toString();
			return info;
		}
	}
	

	/**
	 * Este metodo agrega una tienda
	 * <b>pre</b> el ArrayList de tiendas esta inicializado (no es null). <br>
	 * <b>post</b> Se ha agregado una tienda<br>
	 * @param tiendas es el arraylist de tiendas
	 * @param nombretienda es el nombre de la tienda que buscamos
	 * @return true si se agrega la tienda y false sino se agrega
	 * @throws IOException si hay conflicto con el serializable del arcchivo tiendas
	 */
	public boolean agregarTienda(ArrayList<Tienda> tiendas, String nombretienda) throws IOException {
		Tienda nuevo= new Tienda(nombretienda);
		if(buscarTienda(tiendas, nombretienda) == null){
			tiendas.add(nuevo);
			getArchivoTiendas().getArchivoTiendas().delete();
			getArchivoTiendas().getArchivoTiendas().createNewFile();
			getArchivoTiendas().escribirEnArchivo(tiendas);
			return true;
		}else {
			return false;			
		}
	}
	
	
	/**
	 * Este método elimina una tienda.
	 * <b>pre</b> el ArrayList de tiendas esta inicializado (no es null). <br>
	 * <b>post</b> Se ha eliminado una tienda en específico<br>
	 * @param tiendas es el arraylist de tiendas
	 * @param nombretienda es el nombre de la tienda que buscamos
	 * @return true si se agrega la tienda, false sino se agrega
	 */
	public boolean eliminarTienda(ArrayList<Tienda> tiendas, String nombretienda){
		try {
			if(buscarTienda(tiendas, nombretienda) == null){
				return false;
			}else{
				tiendas.remove(buscarTienda(tiendas, nombretienda));
				getArchivoTiendas().getArchivoTiendas().delete();
				getArchivoTiendas().getArchivoTiendas().createNewFile();
				getArchivoTiendas().escribirEnArchivo(tiendas);
				return true;
			}
		} catch (IOException e) {
			System.out.println("Eliminar Tienda: " +e.getMessage());
			return false;
		}
	}

	
	
	
	/**
	 * Este método agrega un administrador a las tiendas
	 * <b>pre</b> el ArrayList de tiendas esta inicializado (no es null). <br>
	 * <b>post</b> Se ha agregado un administrador<br>
	 * @param tiendas es el arraylist de tiendas
	 * @param nombretienda es el nombre de la tienda que buscamos
	 * @param useradmin es el user del administrador
	 * @param password es la contraseña del administrador
	 * @return true si se agrega el administrador, false sino se agrega
	 */
	
	public boolean agregarAdministrador(ArrayList<Tienda> tiendas,String nombretienda, String useradmin, String password){
		Administrador nuevo= new Administrador( useradmin,password);
		Tienda c=buscarTienda(tiendas, nombretienda);
		if( buscarAdministrador(c,useradmin)== null){
			c.getAdministradores().add(nuevo);
			getArchivoTiendas().escribirEnArchivo(tiendas);
			return true;
		}else {
			return false;			
		}
	}
	
	
	/**
	 * Este método verifica el password del administrador para el login del sistema de la tienda
	 * <b>pre</b> la tienda existe no es null<br>
	 * <b>post</b> Se ha verificado si las contraseñas coinciden<br>
	 * @param t es el objeto de la tienda que contiene el arraylist de administrador
	 * @param useradmin es el user del administrador
	 * @param passwordadmin es la contraseña del administrador
	 * @return retorna true si coinciden las contraseñas y false sino coinciden
	 */
	public boolean verificarPasswordAdministrador(Tienda t, String useradmin, String passwordadmin) {
		Administrador d=buscarAdministrador(t,useradmin);
		if (d==null){
			return false;
		}else {
			if (d.getPassword().equals(passwordadmin)==true) {
			 
			 return true;
			}else {
			 return false;
			}
		 
		}
		
	}
	
	/**
	 * Este método elimina a una administrador
	 * <b>pre</b> la tienda existe no es null<br>
	 * <b>post</b> Se ha verificado si las contraseñas coinciden<br>
	 * @param c es el objeto de tienda
	 * @param useradmin es el user del administrador
	 * @param tiendas es el arrayList de Tiendas
	 * @return true si se elimina al administrador y false sino es eliminado
	 */
	
	public boolean eliminarAdministrador(Tienda c, String useradmin,ArrayList<Tienda> tiendas){
		ArrayList <Administrador> d=c.getAdministradores();
		try {
			if( d== null){
				return false;
			}else{
				d.remove(buscarAdministrador(c, useradmin));
				getArchivoTiendas().getArchivoTiendas().delete();
				getArchivoTiendas().getArchivoTiendas().createNewFile();
				getArchivoTiendas().escribirEnArchivo(tiendas);
				return true;
			}
		} catch (IOException e) {
			System.out.println("Eliminar Administrador: " +e.getMessage());
			return false;
		}
	}
	
	
	
	/**
	 * Este método busca un administrador y devuelve un objeto de administrador
	 * si es encontrado
	 * <b>pre</b> la tienda existe no es null<br>
	 * <b>post</b> se ha retornado el administrador buscado<br>
	 * @param t es el objeto de tienda que contiene al administrador
	 * @param useradmin es el usario de administrador
	 * @return se retorna el administrador que fue buscado y null sino se encontró
	 */
	public Administrador buscarAdministrador(Tienda t, String useradmin) {
		ArrayList <Administrador> d=t.getAdministradores();
		
		for (int i = 0; i < d.size(); i++) {
			if(d.get(i).getAdminuser().equals(useradmin)) {
				return d.get(i);
			}
			
		}
		
		return null;
	}
	
	
	
	/**
	 * Este método busca las sucursales y las retorna como objetos
	 * <b>pre</b> la tienda existe no es null<br>
	 * <b>post</b> se ha retornado la sucursal buscada<br>
	 * @param t  es el objeto de tienda que contiene al administrador
	 * @param nombresucursal es el nombre de la sucursal
	 * @return se retorna un objeto sucursal si es encontrado
	 */

	public Sucursal buscarSucursal(Tienda t, String nombresucursal) {
		ArrayList <Sucursal> d=t.getSucursales();
		
		for (int i = 0; i < d.size(); i++) {
			if(d.get(i).getNombre().equals(nombresucursal)) {
				return d.get(i);
			}
			
		}
		
		return null;
	}
	
	
	/**
	 * Este método agrega una nueva sucursal
	 * <b>pre</b> el ArrayList de tienda existe, no es null<br>
	 * <b>post</b> se ha agregado la sucursal<br>
	 * @param tiendas es el ArrayList de las tiendas
	 * @param nombretienda es el nombre de la tienda que contiene la sucursal
	 * @param nombre es el nombre de la sucursal
	 * @param direccion es la dirección de la sucursal
	 * @return true si se agrega la sucursal false sino se agrega
	 */
	public boolean agregarSucursal(ArrayList<Tienda> tiendas,String nombretienda, String nombre, String direccion){
		Sucursal nuevo= new Sucursal( nombre, direccion);
		Tienda c=buscarTienda(tiendas, nombretienda);
		if( buscarSucursal(c,nombre)== null){
			c.getSucursales().add(nuevo);
			getArchivoTiendas().escribirEnArchivo(tiendas);
			return true;
		}else {
			return false;			
		}
	}
	
	/**
	 * Este método elimina una sucursal si su ombre coincide con el nombre de la sucursal a eliminar
	 * <b>pre</b> el ArrayList de tienda existe, no es null<br>
	 * <b>post</b> se ha agregado la sucursal<br>
	 * @param c es el objeto de tienda donde se encuentra la sucursal
	 * @param nombresucursal es el nombre de la sucursal
	 * @param tiendas es el ArrayList de tiendas
	 * @return true si se elimina la tienda y false sino se elimina
	 */
	public boolean eliminarSucursal(Tienda c, String nombresucursal,ArrayList<Tienda> tiendas){
		ArrayList <Sucursal> d=c.getSucursales();
		try {
			if( d== null){
				return false;
			}else{
				d.remove(buscarSucursal(c, nombresucursal));
				getArchivoTiendas().getArchivoTiendas().delete();
				getArchivoTiendas().getArchivoTiendas().createNewFile();
				getArchivoTiendas().escribirEnArchivo(tiendas);
				return true;
			}
		} catch (IOException e) {
			System.out.println("Eliminar Sucursal: " +e.getMessage());
			return false;
		}
	}
	
	
	
	/**
	 * Este método agrega logs de compras de clientes al arrayList de compras
	 * <b>pre</b> los ArrayList de tiendas y  clientes existen, no son null<br>
	 * <b>post</b> se ha agregado el log de compra<br>
	 * @param tiendas es el ArrayList de tiendas
	 * @param clientes es el ArrayList de Clientes
	 * @param tienda es la tienda que contiene las sucursales donde se haen las compras
	 * @param sucursal es la sucursal donde se hace la compra
	 * @param cliente es el cliente que hace la compra
	 * @param precio es el valor de la compra
	 * @return true si se agregó la compra false sino se hizo la compra
	 */
	//log compras
	public boolean agregarCompraCliente(ArrayList<Tienda> tiendas,ArrayList<Cliente> clientes,String tienda,String sucursal,String cliente, double precio){
		
		//aquï¿½ se agrega la fecha
		 Date fecha = new Date();
		String formatoFecha = "hh:mm:ss a dd-MMM-yyyy"; 
		  SimpleDateFormat objSDF = new SimpleDateFormat(formatoFecha); 
		
		
		Compra nuevolog= new Compra( objSDF.format(fecha), sucursal, cliente, null, precio);
		Tienda c=buscarTienda(tiendas, tienda);
		//busco cliente
		Cliente auxc=null;
		for(int i=0; i<clientes.size(); i++){
			if(clientes.get(i).getUserid().contentEquals(cliente)){
				auxc= clientes.get(i);
			}
		}
		
		
		if(auxc.saldoCliente()>=precio){
			c.getCompras().add(nuevolog);
			auxc.setGasto(auxc.getGasto()+precio);
			getArchivoTiendas().escribirEnArchivo(tiendas);
			return true;
		}else {
			return false;			
		}
	}
	
	/**
	 * Este método agrega logs de compras de las parejas de los clientes al arrayList de compras
	 * <b>pre</b> los ArrayList de tiendas, parejas y  clientes existen, no son null<br>
	 * <b>post</b> se ha agregado el log de compra<br>
	 * @param tiendas es el ArrayList de tiendas
	 * @param clientes es el ArrayList de Clientes
	 * @param tienda es la tienda que contiene las sucursales donde se haen las compras
	 * @param sucursal es la sucursal donde se hace la compra
	 * @param cliente es el cliente que hace la compra
	 * @param userpareja es el user de la preja que realiza la compra
	 * @param precio es el valor de la compra
	 * @return true si se agregó la compra false sino se hizo la compra
	 */
	public boolean agregarCompraPareja(ArrayList<Tienda> tiendas,ArrayList<Cliente> clientes,String tienda,String sucursal,String cliente, double precio, String pareja){
		
		//aquï¿½ se agrega la fecha
		 Date fecha = new Date();
		String formatoFecha = "hh:mm:ss a dd-MMM-yyyy"; 
		  SimpleDateFormat objSDF = new SimpleDateFormat(formatoFecha); 
		
		
		Compra nuevolog= new Compra( objSDF.format(fecha), sucursal, cliente, pareja, precio);
		Tienda c=buscarTienda(tiendas, tienda);
		//busco cliente
		Cliente auxc=null;
		Pareja auxp=null;
		for(int i=0; i<clientes.size(); i++){
			if(clientes.get(i).getUserid().contentEquals(cliente)){
				auxc= clientes.get(i);
			}
		}
		
		ArrayList<Pareja> d=auxc.getParejas();
		for (int i = 0; i < d.size(); i++) {
			if(d.get(i).getUserid().equals(pareja)) {
				auxp=d.get(i);
			}
			
		}
		
		
		if(auxc.saldoCliente()>=precio && auxp.saldoPareja()>=precio){
			c.getCompras().add(nuevolog);
			auxc.setGasto(auxc.getGasto()+precio);
			auxp.setGasto(auxc.getGasto()+precio);
			getArchivoTiendas().escribirEnArchivo(tiendas);
			return true;
		}else {
			return false;			
		}
	}
	
	

	//aqui termina log de compras
	
	
	public ArchivoTiendas getArchivoTiendas() {
		return archivo;
	
	}
	

}
