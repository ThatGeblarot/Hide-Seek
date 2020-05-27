package co.edu.unbosque.model.persistence;

import java.io.IOException;
import java.util.ArrayList;

import co.edu.unbosque.model.Cliente;
import co.edu.unbosque.model.Pareja;

public class ClienteDAO {
	
	
private ArchivoClientes archivo;
	
	public ClienteDAO(ArchivoClientes ar){
		archivo= ar;
	}
	
	public Cliente buscarCliente(ArrayList<Cliente> clientes, String userid){
		Cliente encontrado= null;
		for(int i=0; i<clientes.size(); i++){
			if(clientes.get(i).getUserid().contentEquals(userid)){
				encontrado= clientes.get(i);
			}
		}
		return encontrado;
	}
	
	public String verCliente(ArrayList<Cliente> clientes, String userid){
		String info= "";
		if(buscarCliente(clientes, userid) == null){
			return null;
		}else{
			info= buscarCliente(clientes, userid).toString();
			return info;
		}
	}
	

	
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
	// toca hacer metodo de buscar,agregar y de eliminar parejas
	public boolean agregarPareja(ArrayList<Cliente> clientes,String userid, String nombre, double cupo, String userpareja, String correo, String contraseña, String genero){
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
