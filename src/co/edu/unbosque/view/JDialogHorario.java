package co.edu.unbosque.view;



import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;


/**
 * @author Ricardo Sanchez
 *
 */
public class JDialogHorario extends JDialog {
	private static final long serialVersionUID = 1L;
	private JLabel labelhorain = new JLabel("Hora Inicial");
	private JLabel labelhorafi = new JLabel("Hora Final");
	private JLabel labeldia = new JLabel("Dia");
	private JButton botonAsignar = new JButton("Asignar Horario");
	private JComboBox<String> horain = new JComboBox<String>();
	private JComboBox<String> horafi = new JComboBox<String>();
	private JComboBox<String> dia = new JComboBox<String>();
	private JButton botoncancelar = new JButton("Cancelar");
	public final String ASIGNAR ="asignarfecha",CANCELAR="cancelarfecha";
	public JDialogHorario() {
		try {
			cargar();
			addComponentes();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void cargar() throws Exception {
		setTitle("Asignar Horario");
		setSize(600,400);
		
		setResizable(false);
		setLocationRelativeTo(null);
	    setLayout(null);
		
		
        
		
		labelhorain.setBounds(100, 80, 100, 25);
		horain.setBounds(100, 110, 75, 25);
		horain.addItem("7:00");horain.addItem("8:00");horain.addItem("9:00");horain.addItem("10:00");horain.addItem("11:00");horain.addItem("12:00");horain.addItem("13:00");horain.addItem("14:00");
		horain.addItem("15:00");horain.addItem("16:00");horain.addItem("17:00");horain.addItem("18:00");horain.addItem("19:00");horain.addItem("20:00");
		horain.setBackground(Color.WHITE);
		
		labelhorafi.setBounds(225, 80, 100, 25);
		horafi.setBounds(225, 110, 75, 25);
		horafi.addItem("8:00");horafi.addItem("9:00");horafi.addItem("10:00");horafi.addItem("11:00");horafi.addItem("12:00");horafi.addItem("13:00");horafi.addItem("14:00");horafi.addItem("15:00");
		horafi.addItem("16:00");horafi.addItem("17:00");horafi.addItem("18:00");horafi.addItem("19:00");horafi.addItem("20:00");horafi.addItem("21:00");
		horafi.setBackground(Color.WHITE);
		
		labeldia.setBounds(340,80, 100, 25);
		dia.setBounds(335, 110, 100, 25);
		dia.addItem("Lunes");dia.addItem("Martes");dia.addItem("Miercoles");dia.addItem("Jueves");dia.addItem("Sabado");dia.addItem("Domingo");
		dia.setBackground(Color.WHITE);
		
		
		

		botonAsignar.setBounds(100,200, 200, 50);
		botonAsignar.setActionCommand(ASIGNAR);
		botonAsignar.setBackground(Color.WHITE);
		
		botoncancelar.setBounds(325,200, 100, 50);
		botoncancelar.setActionCommand(CANCELAR);
		botoncancelar.setBackground(Color.WHITE);
		setVisible(false);
	}

	public void addComponentes() {
		add(labeldia);
		add(dia);
		add(labelhorafi);
		add(horafi);
		add(horain);
		add(botonAsignar);
		add(botoncancelar);
		add(labelhorain);
		
	}
	
	

	public JLabel getLabelhorain() {
		return labelhorain;
	}

	public void setLabelhorain(JLabel labelhorain) {
		this.labelhorain = labelhorain;
	}

	public JLabel getLabelhorafi() {
		return labelhorafi;
	}

	public void setLabelhorafi(JLabel labelhorafi) {
		this.labelhorafi = labelhorafi;
	}

	public JLabel getLabeldia() {
		return labeldia;
	}

	public void setLabeldia(JLabel labeldia) {
		this.labeldia = labeldia;
	}

	public JButton getBotonAsignar() {
		return botonAsignar;
	}

	public void setBotonAsignar(JButton botonAsignar) {
		this.botonAsignar = botonAsignar;
	}

	public JComboBox<String> getHorain() {
		return horain;
	}

	public void setHorain(JComboBox<String> horain) {
		this.horain = horain;
	}

	public JComboBox<String> getHorafi() {
		return horafi;
	}

	public void setHorafi(JComboBox<String> horafi) {
		this.horafi = horafi;
	}

	public JComboBox<String> getDia() {
		return dia;
	}

	public void setDia(JComboBox<String> dia) {
		this.dia = dia;
	}

	public JButton getBotoncancelar() {
		return botoncancelar;
	}

	public void setBotoncancelar(JButton botoncancelar) {
		this.botoncancelar = botoncancelar;
	}

	public String getASIGNAR() {
		return ASIGNAR;
	}

	public String getCANCELAR() {
		return CANCELAR;
	}

	public JLabel getLabelfecha() {
		return labelhorain;
	}

	public void setLabelfecha(JLabel labelfecha) {
		this.labelhorain = labelfecha;
	}

	public JButton getBotonaceptar() {
		return botonAsignar;
	}

	public void setBotonaceptar(JButton botonaceptar) {
		this.botonAsignar = botonaceptar;
	}

	
}
