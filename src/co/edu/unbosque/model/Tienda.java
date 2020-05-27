package co.edu.unbosque.model;

import java.util.ArrayList;

public class Tienda {

	public String nombre;
	
	private ArrayList <Sucursal> sucursales;
	private ArrayList <Administrador> administradores;
	private ArrayList <Compra> compras;
	
	public Tienda(String nombre) {
		super();
		this.nombre = nombre;
		sucursales = new ArrayList<Sucursal>();
		administradores = new ArrayList<Administrador>();
		compras= new ArrayList<Compra>();
	}
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public ArrayList<Sucursal> getSucursales() {
		return sucursales;
	}
	public void setSucursales(ArrayList<Sucursal> sucursales) {
		this.sucursales = sucursales;
	}
	public ArrayList<Administrador> getAdministradores() {
		return administradores;
	}
	public void setAdministradores(ArrayList<Administrador> administradores) {
		this.administradores = administradores;
	}
	
	public ArrayList<Compra> getCompras() {
		return compras;
	}


	public void setCompras(ArrayList<Compra> compras) {
		this.compras = compras;
	}
	
	
	

	
	public Compra[] buscarCompraSucursal( String nombresucursal) {
		int p=0;
		Compra[] logcompras= new Compra[noComprasSucursal(nombresucursal)];
		for (int i = 0; i < compras.size(); i++) {
			String aux=compras.get(i).getTienda();
		
			if(aux==nombresucursal) {
			Compra auxc=compras.get(i);
			logcompras[p]=auxc;
			p++;
			}
			
		}
			
			return logcompras;
	}
	//retorna el log de compras como un arreglo de strings
	public String[] CompraSucursal( String nombresucursal) {
		int p=0;
		String[] logcompras= new String[noComprasSucursal(nombresucursal)];
		for (int i = 0; i < compras.size(); i++) {
			String aux=compras.get(i).getTienda();
		
			if(aux==nombresucursal) {
			String auxc=compras.get(i).toString();
			logcompras[p]=auxc;
			p++;
			}
			
		}
			
			return logcompras;
	}
	
	public int noComprasSucursal(String nombresucursal) {
		int p=0;
		for (int i = 0; i < compras.size(); i++) {
			String aux=compras.get(i).getTienda();
		
			if(aux==nombresucursal) {
				p++;
			}
		}
		
		return p;
	}
	
	//comprascliente
	
	public Compra[] buscarCompraCliente( String usercliente) {
		int p=0;
		Compra[] logcompras= new Compra[noComprasClientes(usercliente)];
		for (int i = 0; i < compras.size(); i++) {
			String aux=compras.get(i).getCliente();
		
			if(aux==usercliente) {
			Compra auxc=compras.get(i);
			logcompras[p]=auxc;
			p++;
			}
			
		}
			
			return logcompras;
	}
	
	//retorna el log de compras de cliente en un arreglo de strings
	public String[] compraCliente( String usercliente) {
		int p=0;
		String[] logcompras= new String[noComprasClientes(usercliente)];
		for (int i = 0; i < compras.size(); i++) {
			String aux=compras.get(i).getCliente();
		
			if(aux==usercliente) {
			String auxc=compras.get(i).toString();
			logcompras[p]=auxc;
			p++;
			}
			
		}
			
			return logcompras;
	}
	
	
	public int noComprasClientes(String usercliente) {
		int p=0;
		for (int i = 0; i < compras.size(); i++) {
			String aux=compras.get(i).getCliente();
		
			if(aux==usercliente) {
				p++;
			}
		}	
		return p;
	}
	
	
	//Este método retorna los nombres de las sucursales en un arreglo de Strings
	
	public String[] nombreSucursales() {
		
		int p=sucursales.size();
		String[] nombresucursales=new String[p];
		for (int i = 0; i < sucursales.size(); i++) {
			nombresucursales[i]=sucursales .get(i).getNombre();
		}
		return nombresucursales;
	}
	
	public Compra[] ordenarComprasMayor(Compra[] compras) {
		int i,j;
		int num=compras.length;
		Compra temp;
		
		     for ( i = 0; i < num-1; i++) 
		        { 
		    
		            int min = i; 
		            for ( j = i+1; j < num; j++) 
		                if (compras[j].getPrecio() < compras[min].getPrecio()) 
		                    min = j; 
		  
		     
		            temp = compras[min]; 
		            compras[min] = compras[i]; 
		            compras[i] = temp; 
		        } 
		    
		
		
		
		return compras;
		
	
	}
	
	
	public Compra[] ordenarComprasMenor(Compra[] compras) {
		int i,j;
		int num=compras.length;
		Compra temp;
		
		     for ( i = 0; i < num-1; i++) 
		        { 
		    
		            int min = i; 
		            for ( j = i+1; j < num; j++) 
		                if (compras[j].getPrecio() > compras[min].getPrecio()) 
		                    min = j; 
		  
		     
		            temp = compras[min]; 
		            compras[min] = compras[i]; 
		            compras[i] = temp; 
		        } 
		return compras;
	} 
	
	
	
	@Override
	public String toString() {
		return "Super tiendas " + nombre ;
	}
  
	
}
