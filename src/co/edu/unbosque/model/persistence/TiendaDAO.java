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
	
	
	
private ArchivoTiendas archivo;
	
	public TiendaDAO(ArchivoTiendas ar){
		archivo= ar;
	}
	
	public Tienda buscarTienda(ArrayList<Tienda> tiendas, String nombretienda){
		Tienda encontrado= null;
		for(int i=0; i<tiendas.size(); i++){
			if(tiendas.get(i).getNombre().contentEquals(nombretienda)){
				encontrado= tiendas.get(i);
			}
		}
		return encontrado;
	}
	
	public String verTienda(ArrayList<Tienda> tiendas, String nombretienda){
		String info= "";
		if(buscarTienda(tiendas, nombretienda) == null){
			return null;
		}else{
			info= buscarTienda(tiendas, nombretienda).toString();
			return info;
		}
	}
	

	
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
	
	
	
	public Administrador buscarAdministrador(Tienda t, String useradmin) {
		ArrayList <Administrador> d=t.getAdministradores();
		
		for (int i = 0; i < d.size(); i++) {
			if(d.get(i).getAdminuser().equals(useradmin)) {
				return d.get(i);
			}
			
		}
		
		return null;
	}
	
	

	public Sucursal buscarSucursal(Tienda t, String nombresucursal) {
		ArrayList <Sucursal> d=t.getSucursales();
		
		for (int i = 0; i < d.size(); i++) {
			if(d.get(i).getNombre().equals(nombresucursal)) {
				return d.get(i);
			}
			
		}
		
		return null;
	}
	
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
	
	//log compras
	public boolean agregarCompraCliente(ArrayList<Tienda> tiendas,ArrayList<Cliente> clientes,String tienda,String sucursal, String nombre, String direccion,String cliente, double precio){
		
		//aquí se agrega la fecha
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
	
	public boolean agregarCompraPareja(ArrayList<Tienda> tiendas,ArrayList<Cliente> clientes,String tienda,String sucursal, String nombre, String direccion,String cliente, double precio, String pareja){
		
		//aquí se agrega la fecha
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
