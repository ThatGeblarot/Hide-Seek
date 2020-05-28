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

/**
 * Esta clase se encarga de hacer el manejo de los archivos de persistencia de clientes.
 * @author Moises Salcedo
 */
public class ArchivoClientes {

	private ObjectInputStream entrada;
	private ObjectOutputStream salida;
	private File archivo =new File("./data/Base de Datos Clientes.dat");
	
	/**
	 * Este es el contructor de la clase archivoClientes, este archivo contiene los clientes inscritos.
	 * <b>post</b> Se ha creado el archivo de ciudadanos<br> 
	 */
	
	public ArchivoClientes(){
		
		if(archivo.exists()){
			//System.out.println("El archivo ya existe");
		}else{
			try {
				//archivo.mkdir();
				archivo.createNewFile();
			} catch (Exception e) {
				System.out.println("Creación del archivo clientes: " +e.getMessage());
			}
		}
	}
	
	/**
	 * Este metodo se encarga de escribir en el archivo de clientes.
	 *  <b>pre</b> La lista de usuarios está inicializada (no es null). <br>
	 * <b>post</b> Se ha persisitido la informacion de los usuarios inscritos <br>
	 * @param usuarios es el Arraylist que contiene a los clientes inscritos
	 */
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

	
	/**
	 * Este método lee el archivo donde se encuentra persistida la informacion  de clientes y carga la informacion
	 * de los clientes inscritos al arrayList clientes
	 *  <b>pre</b> El archivo con la información de los clientes existe no está vacío <br>
	 * <b>post</b> Se ha cargado la información del archivo de clientes y se ha retornado el arrayList
	 * clientes con la información <br>
	 * @return retorna el arrayList con los clientes que hayan sido inscritos
	 */
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
