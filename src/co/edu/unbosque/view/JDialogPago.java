package co.edu.unbosque.view;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;


/**
 * @author Ricardo Sanchez
 *
 */
public class JDialogPago extends JDialog implements GabenDialog {
	private static final long serialVersionUID = 1L;
	private JButton pagar = new JButton("Realizar Pago");
	private JButton cancelar = new JButton("Cancelar");
	private JLabel label = new JLabel("Ingrese el monto: ");
	private JTextField textcantidad = new JTextField();
	private JLabel sucursal = new JLabel("Sucursal: ");
	private JComboBox<String> combo = new JComboBox<String>();
	public final String PAGAR ="pagar",CANCELAR ="cancelarpago";
	public JDialogPago() {
		try {
			load();
			addComponents();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void load() {
		setTitle("Pago");
		setSize(600,400);
		
		setResizable(false);
		setLocationRelativeTo(null);
		setLayout(null);
		setBackground(Color.BLACK);
		
		sucursal.setBounds(125, 70, 100, 50);
		combo.setBounds(200, 85, 200, 25);
		
		label.setBounds(90,125 , 300, 25);
		textcantidad.setBounds(200, 125, 200, 25);
		
		pagar.setBounds(150, 200, 150, 50);
		pagar.setBackground(Color.BLACK);
		pagar.setForeground(Color.WHITE);
		pagar.setActionCommand(PAGAR);
		
		cancelar.setBounds(350, 200, 100, 50);
		cancelar.setActionCommand(CANCELAR);
		cancelar.setBackground(Color.BLACK);
		cancelar.setForeground(Color.WHITE);
		
		

		
		setVisible(false);
	}
	
	
	public void addComponents() {
		add(combo);
		add(sucursal);
		add(label);
		add(pagar);
		add(cancelar);
		add(textcantidad);
		

	}
	public void clean() {
		textcantidad.setText("");
	}
	
    public JLabel getSucursal() {
		return sucursal;
	}

	public void setSucursal(JLabel sucursal) {
		this.sucursal = sucursal;
	}

	public JComboBox<String> getCombo() {
		return combo;
	}

	public void setCombo(JComboBox<String> combo) {
		this.combo = combo;
	}

	public JButton getPagar() {
		return pagar;
	}

	public void setPagar(JButton pagar) {
		this.pagar = pagar;
	}

	public JButton getCancelar() {
		return cancelar;
	}

	public void setCancelar(JButton cancelar) {
		this.cancelar = cancelar;
	}

	public JLabel getLabel() {
		return label;
	}

	public void setLabel(JLabel label) {
		this.label = label;
	}

	public JTextField getTextcantidad() {
		return textcantidad;
	}

	public void setTextcantidad(JTextField textcantidad) {
		this.textcantidad = textcantidad;
	}

	public String getPAGAR() {
		return PAGAR;
	}

	public String getCANCELAR() {
		return CANCELAR;
	}
 
}
