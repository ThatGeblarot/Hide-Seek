package co.edu.unbosque.view;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import co.edu.unbosque.controller.Controller;

import java.awt.*;
import java.io.IOException;

/**
 * @author Gabriel Blanco
 * Clase para definir la ventana principal
 */
public class View extends JFrame implements GabenFrame {

	private static final long serialVersionUID = 1L;
	private Dialogos dialogos = new Dialogos();
	private PanelFuncionesSuperiores toolbar = new PanelFuncionesSuperiores();
	private JPanelAdmin admin = new JPanelAdmin();
	private JPanelParejas parejas = new JPanelParejas();
	private JPanelUsuarios usuarios = new JPanelUsuarios();
	private JDialogActualizar actualizar = new JDialogActualizar();
	private JDialogAsignarCupo asignarCupo = new JDialogAsignarCupo();
	private JDialogBuscador buscador = new JDialogBuscador();
	private JDialogEliminar eliminar = new JDialogEliminar();
	private JDialogHorario horario = new JDialogHorario();
	private JDialogListar listar = new JDialogListar();
	private JDialogLogin login = new JDialogLogin();
	private JDialogPago pago = new JDialogPago();
	private JDialogRegistrar registrar = new JDialogRegistrar();
	private JDialogMostrarCompras mostrarcompras = new JDialogMostrarCompras();
	/**
	 * Método para iniciar la ventana principal
	 * @author Gabriel Blanco
	 * @param control
	 */
	public void start(Controller control) {
		load();
		addComponents();
		listenComponents(control);
	}
	/**
	 * Método para cargar la configuración de la ventana principal
	 * @author Gabriel Blanco
	 */
	public void load() {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(800,600);
		setLocationRelativeTo(null);
		setLayout(new BorderLayout());
		setVisible(true);
		setResizable(false);
	}
	
	/**
	 * Método para añadir los componentes de la ventana principal
	 * @author Gabriel Blanco
	 */
	public void addComponents() {
		JPanel containerPanel = new JPanel();
		containerPanel.setLayout(new GridLayout(3,1));
		containerPanel.add(parejas);
		containerPanel.add(usuarios);
		containerPanel.add(admin);
		add(containerPanel, BorderLayout.CENTER);
		add(toolbar, BorderLayout.NORTH);
		//TODO: Añadir aquí los componentes
		
	}
	
	/**
	 * Método para escuchar los componentes donde <pre>Controller</pre> va a manejar todas
	 * estas excepciones.
	 * @author Gabriel Blanco & Ricardo Sanchez
	 * @param control
	 */
	public void listenComponents(Controller control) {
		//PanelFuncionesSuperiores
		toolbar.getAcercaDe().addActionListener(control);
		toolbar.getNuevo().addActionListener(control);
		toolbar.getGuardar().addActionListener(control);
		toolbar.getCargar().addActionListener(control);
		toolbar.getSalir().addActionListener(control);
		//Dialogo AsignarCupo
		asignarCupo.getAsignar().addActionListener(control);
		asignarCupo.getCancelar().addActionListener(control);
		asignarCupo.getQuitar().addActionListener(control);
		//Dialogo Actualizar
		actualizar.getBotonActualizar().addActionListener(control);
		actualizar.getBotonCancelar().addActionListener(control);
		//Dialogo Buscador
		buscador.getBotonBuscar().addActionListener(control);
		buscador.getBotonCancelar().addActionListener(control);
		//Dialogo Eliminar
		eliminar.getBotonEliminar().addActionListener(control);
		eliminar.getBotonCancelar().addActionListener(control);
		//Dialogo Horario
		horario.getBotonaceptar().addActionListener(control);
		//Dialogo Listar
		listar.getMostrar().addActionListener(control);
		listar.getCancelar().addActionListener(control);
		listar.getLimpiar().addActionListener(control);
		//Dialogo Login
		login.getBotonRegistrarse().addActionListener(control);
		login.getBotonLogin().addActionListener(control);
		login.getCombo().addActionListener(control);
		//Dialogo Pago
		pago.getPagar().addActionListener(control);
		pago.getCancelar().addActionListener(control);
		//Dialogo Registrar
		registrar.getBotonRegistrar().addActionListener(control);
		registrar.getBotonCancelar().addActionListener(control);
		//Dialogo Mostrar Compras
		mostrarcompras.getBotonmostrardatos().addActionListener(control);
		mostrarcompras.getBotonmostrardatos().addActionListener(control);
		
	}
	
	public String cargarArchivo() throws IOException {
		String path = "";
		JFileChooser chooser = new JFileChooser();
		FileNameExtensionFilter filter = new FileNameExtensionFilter("Forest Binary Files", new String[] {"TEXTFILES"});
		chooser.addChoosableFileFilter(filter);
		chooser.setFileFilter(filter);
		int returnVal = chooser.showOpenDialog(chooser);
		if(returnVal == JFileChooser.APPROVE_OPTION) {
			path = chooser.getSelectedFile().getAbsolutePath();
			return path;
		} else {
			//No hace nada
			return null;
		}
	}
	
	/**
	 * Método para guardar un archivo via JFileChooser
	 * @author Gabriel Blanco
	 * @param linea
	 * @throws IOException
	 */
	public String guardarArchivo() throws IOException {
		String path = "";
		JFileChooser chooser = new JFileChooser();
		FileNameExtensionFilter filter = new FileNameExtensionFilter("Text Files", new String[] {"TXT"});
		chooser.addChoosableFileFilter(filter);
		chooser.setFileFilter(filter);
		int returnVal = chooser.showSaveDialog(chooser);
		if(returnVal == JFileChooser.APPROVE_OPTION) {
			path = chooser.getSelectedFile().getAbsolutePath();
		} 
		else {
			//No hace nada
		}
		return path;
	}

	public Dialogos getDialogos() {
		return dialogos;
	}
	public PanelFuncionesSuperiores getToolbar() {
		return toolbar;
	}
	public JPanelAdmin getAdmin() {
		return admin;
	}
	public JPanelParejas getParejas() {
		return parejas;
	}
	public JPanelUsuarios getUsuarios() {
		return usuarios;
	}
	public JDialogActualizar getActualizar() {
		return actualizar;
	}
	public JDialogAsignarCupo getAsignarCupo() {
		return asignarCupo;
	}
	public JDialogBuscador getBuscador() {
		return buscador;
	}
	public JDialogEliminar getEliminar() {
		return eliminar;
	}
	public JDialogHorario getHorario() {
		return horario;
	}
	public JDialogListar getListar() {
		return listar;
	}
	public JDialogLogin getLogin() {
		return login;
	}
	public JDialogPago getPago() {
		return pago;
	}
	public JDialogRegistrar getRegistrar() {
		return registrar;
	}
	
}
