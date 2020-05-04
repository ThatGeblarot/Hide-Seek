package co.edu.unbosque.model.persistence;

/**
 * @author Gabriel Blanco Clase para usar propiedades
 */

import java.io.*;
import java.util.Properties;

public class GabenProperties {
	private Properties property = new Properties();

	/**
	 * M�todo para escribir la propiedad
	 * 
	 * @author Gabriel Blanco
	 * @param key
	 * @param value
	 * @param location
	 * @param comments
	 * @throws IOException
	 */
	public String escribirPropiedad(String key, String value, String fileName, String comments) throws IOException {
		File f = new File("./docs/Output");
		property.setProperty(key, value);
		property.store(new FileOutputStream(f+"/"+fileName), comments);
		return f.getAbsolutePath();
	}

	/**
	 * M�todo para leer la propiedad
	 * 
	 * @author Gabriel Blanco
	 * @param location
	 * @param key
	 * @return
	 * @throws IOException
	 */
	public String leerPropiedad(String fileName, String key) throws IOException {
		File f = new File("./docs/Output");
		String linea = "";
		property.load(new FileInputStream(f+"/"+fileName));
		linea += property.getProperty(key);
		return linea;

	}
	
	/**
	 * M�todo para eliminar la propiedad
	 * 
	 * @author Gabriel Blanco
	 * @param fileName
	 * @param key
	 * @return
	 * @throws IOException
	 */
	public String eliminarPropiedad(String fileName, String key) throws IOException {
		File f = new File("./docs/Output");
		String linea = "";
		property.load(new FileInputStream(f+"/"+fileName));
		property.remove(key);
		return linea;
		
	}
}
