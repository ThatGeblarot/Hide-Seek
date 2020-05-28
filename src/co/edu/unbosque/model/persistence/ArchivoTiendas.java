package co.edu.unbosque.model.persistence;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;


import co.edu.unbosque.model.Tienda;     
/**
 * Esta clase se encarga de hacer el manejo de los archivos de persistencia de tiendas.
 * @author Alberto Ortega
 */
public class ArchivoTiendas {

	private ObjectInputStream entrada;
	private ObjectOutputStream salida;
	private File archivo =new File("./data/Base de Datos Tiendas.dat");
	private File path;

	/**
	 * Este es el contructor de la clase archivoTiendas, este archivo contiene las tiendas inscritas.
	 * <b>post</b> Se ha creado el archivo de tiendas<br> 
	 */
	public ArchivoTiendas(){
		
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
	/**
	 * Este metodo se encarga de escribir en el archivo de tiendas.
	 *  <b>pre</b> La lista de tiendas está inicializada (no es null). <br>
	 * <b>post</b> Se ha persisitido la informacion de las tiendas inscritas <br>
	 * @param usuarios es el Arraylist que contiene a las tiendas inscritos
	 */
	
	public void escribirEnArchivo(ArrayList<Tienda> tiendas){
		try {
			salida= new ObjectOutputStream(new FileOutputStream(getArchivoTiendas()));
			salida.writeObject(tiendas);
			salida.close();
		} catch (FileNotFoundException e) {
			System.out.println("No se encontro el archivo tiendas: " +e.getMessage());
		} catch (IOException e){
			System.out.println("Escritura de archivo tiendas: " +e.getMessage());
		}
	}

	/**
	 * Este método lee el archivo donde se encuentra persistida la informacion  de tiendas y carga la informacion
	 * de las tiendas inscritas al arrayList tiendas
	 *  <b>pre</b> El archivo con la información de las tiendas existe no está vacío <br>
	 * <b>post</b> Se ha cargado la información del archivo de tiendas y se ha retornado el arrayList
	 * tiendas con la información <br>
	 * @return retorna el arrayList con las tiendas que hayan sido inscritos
	 */
	@SuppressWarnings("unchecked")
	public ArrayList<Tienda> leerArchivo(){
		ArrayList<Tienda> tiendas= new ArrayList<Tienda>();
		if (getArchivoTiendas().length()!= 0) {
			try {
				entrada= new ObjectInputStream(new FileInputStream(getArchivoTiendas()));
				tiendas= (ArrayList<Tienda>) entrada.readObject();
			} catch (FileNotFoundException e) {
				System.out.println("No se encontro el archivo tiendas: " +e.getMessage());
			} catch (IOException e){
				System.out.println("Lectura de archivo tiendas: " +e.getMessage());
			} catch (ClassNotFoundException e){
				System.out.println("Class not found (lectura)" +e.getMessage());
			}
		}
		return tiendas;
	}

	public void crearPDF(String[] logs) {
		
	path= new File("./data/registroCompras.pdf");
	  try {
					if(path.exists()){
			        path.delete();
			        path.createNewFile();
			    }
			    final Document doc= new Document();
			    PdfWriter.getInstance(doc, new FileOutputStream(path));
			    doc.open();
			    for (int j = 0; j < logs.length; j++) {
			    	 Paragraph linea= new Paragraph(logs[j]);
					    doc.add(linea);
				}
			   
			    doc.close();
			} catch(FileNotFoundException e) {
			    System.out.println("no se encontró el pdf: " +e.getMessage());
			    e.printStackTrace();
			} catch(Exception e){
			    System.out.println("error al escribir en pdf: " +e.getMessage());
			}	
	}
	
	
	public File getArchivoTiendas() {
		return archivo;
	}
}
