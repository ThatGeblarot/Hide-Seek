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

public class ArchivoTiendas {

	private ObjectInputStream entrada;
	private ObjectOutputStream salida;
	private File archivo =new File("./data/Base de Datos Tiendas.dat");
	private File path;
	
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
