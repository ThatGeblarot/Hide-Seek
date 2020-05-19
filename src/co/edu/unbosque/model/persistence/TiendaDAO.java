package co.edu.unbosque.model.persistence;

import java.io.IOException;
import java.util.ArrayList;

import co.edu.unbosque.model.Tienda;
import co.edu.unbosque.model.Administrador;
import co.edu.unbosque.model.Sucursal;


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
	

	
	public boolean agregarTienda(ArrayList<Tienda> tiendas, String nombretienda){
		Tienda nuevo= new Tienda(nombretienda);
		if(buscarTienda(tiendas, nombretienda) == null){
			tiendas.add(nuevo);
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
	

	
	
	public ArchivoTiendas getArchivoTiendas() {
		return archivo;
	
	}
	

}
