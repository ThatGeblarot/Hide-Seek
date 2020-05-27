package co.edu.unbosque.view;

import javax.swing.*;

import java.awt.*;

/**
 * @author Ricardo Sanchez
 *
 */
public class JDialogRegistrar extends JDialog implements GabenDialog {

	private static final long serialVersionUID = 1L;
	private JLabel labelgenero = new JLabel("Genero: ");
	private JLabel labelusuario = new JLabel("Usuario: ");
	private JLabel labelcorreo = new JLabel("Correo: ");
	private JLabel labelconfcorreo = new JLabel("Confirmar Correo: ");
	private JLabel labelclave = new JLabel("Clave: ");
	private JLabel labelconfclave = new JLabel("Confirmar Clave: ");
	private JButton botonRegistrar = new JButton("Registrar");
	private JButton botonCancelar = new JButton("Cancelar");
	private JTextField textusuario = new JTextField("");
	private JTextField textcorreo = new JTextField("");
	private JTextField textconfcorreo = new JTextField("");
	private JTextField textclave = new JTextField("");
	private JTextField textconfclave = new JTextField("");
	private JComboBox<String> generocombo = new JComboBox<String>();
	public static final String REGISTRAR = "RegistrarRaitNau";
	public static final String CANCELAR = "CancelarRaitNau";

	public JDialogRegistrar() {
		try {
			load();
			addComponents();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void load() {
		setLayout(new BorderLayout());
		setTitle("Registro");
		setSize(800, 600);
		setDefaultCloseOperation(HIDE_ON_CLOSE);

		setResizable(false);
		setLocationRelativeTo(null);
		setLayout(null);
		setBackground(Color.BLACK);
		setVisible(false);
		labelusuario.setBounds(255, 80, 100, 50);
		textusuario.setBounds(335, 95, 200, 25);

		labelcorreo.setBounds(260, 130, 100, 50);
		textcorreo.setBounds(335, 145, 200, 25);

		labelconfcorreo.setBounds(195, 180, 200, 50);
		textconfcorreo.setBounds(335, 195, 200, 25);

		labelclave.setBounds(265, 230, 100, 50);
		textclave.setBounds(335, 245, 200, 25);

		labelconfclave.setBounds(205, 280, 200, 50);
		textconfclave.setBounds(335, 295, 200, 25);

		botonRegistrar.setBounds(250, 400, 100, 50);
		botonRegistrar.setActionCommand(REGISTRAR);
		botonRegistrar.setBackground(Color.WHITE);

		botonCancelar.setBounds(400, 400, 100, 50);
		botonCancelar.setActionCommand(CANCELAR);
		botonCancelar.setBackground(Color.WHITE);

		labelgenero.setBounds(260, 335, 100, 50);
		generocombo.setBounds(335, 350, 100, 25);
		generocombo.addItem("Hombre");
		generocombo.addItem("Mujer");
		generocombo.addItem("Otro");

	}

	public void clean() {
		textusuario.setText("");
		textcorreo.setText("");
		textconfcorreo.setText("");
		textclave.setText("");
		textconfclave.setText("");

	}

	public void addComponents() {
		add(labelgenero);
		add(generocombo);
		add(labelusuario);
		add(labelcorreo);
		add(labelconfcorreo);
		add(labelclave);
		add(labelconfclave);
		add(textusuario);
		add(textcorreo);
		add(textconfcorreo);
		add(textclave);
		add(textconfclave);
		add(botonRegistrar);
		add(botonCancelar);

	}

	public JLabel getLabelnom() {
		return labelusuario;
	}

	public void setLabelnom(JLabel labelnom) {
		this.labelusuario = labelnom;
	}

	public JLabel getLabelcorreo() {
		return labelcorreo;
	}

	public void setLabelcorreo(JLabel labelcorreo) {
		this.labelcorreo = labelcorreo;
	}

	public JLabel getLabelclave() {
		return labelclave;
	}

	public void setLabelclave(JLabel labelclave) {
		this.labelclave = labelclave;
	}

	public JButton getBotonRegistrar() {
		return botonRegistrar;
	}

	public void setBotonRegistrar(JButton botonRegistrar) {
		this.botonRegistrar = botonRegistrar;
	}

	public JTextField getTextnom() {
		return textusuario;
	}

	public void setTextnom(JTextField textnom) {
		this.textusuario = textnom;
	}

	public JTextField getTextcorreo() {
		return textcorreo;
	}

	public void setTextcorreo(JTextField textcorreo) {
		this.textcorreo = textcorreo;
	}

	public JTextField getTextclave() {
		return textclave;
	}

	public void setTextclave(JTextField textclave) {
		this.textclave = textclave;
	}

	public String getREGISTRAR() {
		return REGISTRAR;
	}

	public String getCANCELAR() {
		return CANCELAR;
	}

	public JButton getBotonCancelar() {
		return botonCancelar;
	}

	public void setBotonCancelar(JButton botonCancelar) {
		this.botonCancelar = botonCancelar;
	}

	public JLabel getLabelgenero() {
		return labelgenero;
	}

	public void setLabelgenero(JLabel labelgenero) {
		this.labelgenero = labelgenero;
	}

	public JLabel getLabelusuario() {
		return labelusuario;
	}

	public void setLabelusuario(JLabel labelusuario) {
		this.labelusuario = labelusuario;
	}

	public JLabel getLabelconfcorreo() {
		return labelconfcorreo;
	}

	public void setLabelconfcorreo(JLabel labelconfcorreo) {
		this.labelconfcorreo = labelconfcorreo;
	}

	public JLabel getLabelconfclave() {
		return labelconfclave;
	}

	public void setLabelconfclave(JLabel labelconfclave) {
		this.labelconfclave = labelconfclave;
	}

	public JTextField getTextusuario() {
		return textusuario;
	}

	public void setTextusuario(JTextField textusuario) {
		this.textusuario = textusuario;
	}

	public JTextField getTextconfcorreo() {
		return textconfcorreo;
	}

	public void setTextconfcorreo(JTextField textconfcorreo) {
		this.textconfcorreo = textconfcorreo;
	}

	public JTextField getTextconfclave() {
		return textconfclave;
	}

	public void setTextconfclave(JTextField textconfclave) {
		this.textconfclave = textconfclave;
	}

	public JComboBox<String> getGenerocombo() {
		return generocombo;
	}

	public void setGenerocombo(JComboBox<String> generocombo) {
		this.generocombo = generocombo;
	}

}
