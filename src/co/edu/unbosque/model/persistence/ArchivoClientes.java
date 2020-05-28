package co.edu.unbosque.model.persistence;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import co.edu.unbosque.model.Cliente;     

public class ArchivoClientes {

	private ObjectInputStream entrada;
	private ObjectOutputStream salida;
	private File archivo =new File("./data/Base de Datos Clientes.dat");
	
	public ArchivoClientes(){
		
		if(archivo.exists()){
			//System.out.println("El archivo ya existe");
		}else{
			try {
				//archivo.mkdir();
				archivo.createNewFile();
			} catch (Exception e) {
				System.out.println("Creación del archivo tiendas: " +e.getMessage());
			}
		}
	}
	
	
	public void escribirEnArchivo(ArrayList<Cliente> usuarios){
		try {
			salida= new ObjectOutputStream(new FileOutputStream(getArchivo()));
			salida.writeObject(usuarios);
			salida.close();
		} catch (FileNotFoundException e) {
			System.out.println("No se encontro el archivo: " +e.getMessage());
		} catch (IOException e){
			System.out.println("Escritura de archivo: " +e.getMessage());
		}
	}
	
	@SuppressWarnings("unchecked")
	public ArrayList<Cliente> leerArchivo(){
		ArrayList<Cliente> usuarios= new ArrayList<Cliente>();
		if (getArchivo().length()!= 0) {
			try {
				entrada= new ObjectInputStream(new FileInputStream(getArchivo()));
				usuarios= (ArrayList<Cliente>) entrada.readObject();
			} catch (FileNotFoundException e) {
				System.out.println("No se encontro el archivo: " +e.getMessage());
			} catch (IOException e){
				System.out.println("Lectura de archivo: " +e.getMessage());
			} catch (ClassNotFoundException e){
				System.out.println("Class not found (lectura)" +e.getMessage());
			}
		}
		return usuarios;
	}

	
	
	public File getArchivo() {
		return archivo;
	}
}
