package co.edu.unbosque.view;

import java.awt.AWTException;
import java.awt.Image;
import java.awt.SystemTray;
import java.awt.Toolkit;
import java.awt.TrayIcon;
import java.awt.TrayIcon.MessageType;
import java.io.InputStream;

import javax.swing.JOptionPane;

/**
 * @author Gabriel Blanco Clase para mostrar los di�logos
 */
public class Dialogos {

	/**
	 * M�todo utilizado para la entrada del usuario
	 * 
	 * @param systemIn
	 * @param title
	 * @param message
	 * @param messageType
	 * @return
	 */
	public String input(InputStream systemIn, String title, String message, int messageType) {
		return JOptionPane.showInputDialog(null, message, title, messageType);
	}

	/**
	 * M�todo utilizado para la salida del sistema
	 * 
	 * @param title
	 * @param message
	 * @param messageType
	 */
	public void output(String title, String message, int messageType) {
		JOptionPane.showMessageDialog(null, message, title, messageType);
	}
	/**
	 * M�todo para mostrar notificaciones del sistema al usuario
	 * @param title
	 * @param message
	 * @throws AWTException
	 */
	public void notification(String title, String message, MessageType messageType) throws AWTException {
		SystemTray tray = SystemTray.getSystemTray();
		Image image = Toolkit.getDefaultToolkit().createImage("./docs/icon.png");
		TrayIcon icon = new TrayIcon(image, "Message by Gaben");
		icon.setImageAutoSize(true);
		icon.setToolTip("Message by Gaben");
		tray.add(icon);
		icon.displayMessage(title, message, messageType);
	}

}
