package co.edu.unbosque.view;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 * @author Ricardo Sanchez
 *
 */
public class JDialogActualizar extends JDialog implements GabenDialog {
	
	private static final long serialVersionUID = 1L;
	private JLabel labelusuario = new JLabel("Nuevo Usuario: ");
	private JLabel labelcorreo = new JLabel("Nuevo Correo: ");
	private JLabel labelconfcorreo = new JLabel("Confirmar Correo:");
	private JLabel labelclave = new JLabel("Nueva clave: ");
	private JLabel labelconfclave = new JLabel("Confirmar Clave: ");
	private JButton botonActualizar = new JButton("Actualizar");
	private JButton botonCancelar = new JButton("Cancelar");
	private JTextField textusuario = new JTextField("");
	private JTextField textcorreo = new JTextField("");
	private JTextField textconfcorreo = new JTextField("");
	private JTextField textclave = new JTextField("");
	private JTextField textconfclave = new JTextField("");
	public static final String ACTUALIZAR = "Actualizar";
	public static final String CANCELAR = "cancelaractualizacion";

	public JDialogActualizar() {
		try {
			load();
			addComponents();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void load() {
		setLayout(null);
		setTitle("Actualizar Datos");
		setSize(600, 400);

		setResizable(false);
		setLocationRelativeTo(null);
		setBackground(Color.WHITE);

		labelcorreo.setBounds(115,40 , 125, 50);
        textcorreo.setBounds(250, 55, 200, 25);

        labelconfcorreo.setBounds(90, 85, 160, 50);
        textconfcorreo.setBounds(250, 95, 200, 25);


        labelclave.setBounds(130, 125, 100, 50);
        textclave.setBounds(250, 135, 200, 25);


        labelconfclave.setBounds(105, 165, 200, 50);
        textconfclave.setBounds(250, 175, 200, 25);


        botonActualizar.setBounds(150, 235, 150, 50);
        botonActualizar.setActionCommand(ACTUALIZAR);
        botonActualizar.setBackground(Color.BLACK);
        botonActualizar.setForeground(Color.WHITE);

        botonCancelar.setBounds(350,235, 100, 50);
        botonCancelar.setActionCommand(CANCELAR);
        botonCancelar.setBackground(Color.BLACK);
        botonCancelar.setForeground(Color.WHITE);

		setVisible(false);
	}

	public void addComponents() {
		getContentPane().add(labelcorreo);
		getContentPane().add(textcorreo);
		getContentPane().add(labelconfcorreo);
		getContentPane().add(labelclave);
		getContentPane().add(labelconfclave);
		getContentPane().add(textconfcorreo);
		getContentPane().add(textclave);
		getContentPane().add(textconfclave);
		getContentPane().add(botonActualizar);
		getContentPane().add(botonCancelar);

	}
	public void clean() {
		textusuario.setText("");
		textcorreo.setText("");
		textconfclave.setText("");
		textclave.setText("");
		
	}

	public JButton getBotonActualizar() {
		return botonActualizar;
	}

	public JButton getBotonCancelar() {
		return botonCancelar;
	}

	public JTextField getTextcorreo() {
		return textcorreo;
	}

	public JTextField getTextconfcorreo() {
		return textconfcorreo;
	}

	public JTextField getTextclave() {
		return textclave;
	}

	public JTextField getTextconfclave() {
		return textconfclave;
	}

	public JLabel getLabelusuario() {
		return labelusuario;
	}

}
