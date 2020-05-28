package co.edu.unbosque.view;

import javax.swing.*;
import java.awt.*;

public class JDialogStats extends JDialog implements GabenDialog {
	
	private static final long serialVersionUID = 1L;
	private Stats stats = new Stats();
	private JLabel intro = new JLabel("Estadísticas de Venta"), lbModa = new JLabel("Moda"), lbMediana = new JLabel("Mediana"), lbMedia = new JLabel("Media");
	private JTextField moda = new JTextField("$-"), mediana = new JTextField("$-"), media = new JTextField("$-");
	private JPanel panelTexto = new JPanel();
	
	public JDialogStats() {
		load();
		addComponents();
	}
	@Override
	public void load() {
		setTitle("Estadísticas");
		setSize(800,600);
		setLayout(new BorderLayout());
		setLocationRelativeTo(null);
		panelTexto.setLayout(new GridLayout(3,2));
		moda.setEditable(false);
		mediana.setEditable(false);
		media.setEditable(false);
		moda.setHorizontalAlignment(SwingConstants.CENTER);
		mediana.setHorizontalAlignment(SwingConstants.CENTER);
		media.setHorizontalAlignment(SwingConstants.CENTER);
	}

	@Override
	public void addComponents() {
		add(intro, BorderLayout.NORTH);
		add(stats, BorderLayout.CENTER);
		panelTexto.add(lbModa); panelTexto.add(moda);
		panelTexto.add(lbMediana); panelTexto.add(mediana);
		panelTexto.add(lbMedia); panelTexto.add(media);
		add(panelTexto, BorderLayout.SOUTH);
		
	}

	public Stats getStats() {
		return stats;
	}

	public JTextField getModa() {
		return moda;
	}

	public JTextField getMediana() {
		return mediana;
	}

	public JTextField getMedia() {
		return media;
	}

	public JPanel getPanelTexto() {
		return panelTexto;
	}

}
