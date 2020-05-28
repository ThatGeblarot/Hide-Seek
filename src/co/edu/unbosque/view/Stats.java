package co.edu.unbosque.view;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;
import javax.swing.*;
import java.awt.*;

public class Stats extends JPanel implements GabenPanel {
	private static final long serialVersionUID = 1L;
	private DefaultPieDataset data = new DefaultPieDataset();
	private JFreeChart chart;
	private ChartPanel panel;

	public Stats() {
		load();
		addComponents();
	}

	public void load() {
		// create a chart...
		chart = ChartFactory.createPieChart("", data, true, // legend?
				true, // tooltips?
				false // URLs?
		);
		// create and display a frame...
		panel = new ChartPanel(chart);
		panel.setVisible(true);
		setLayout(new BorderLayout());
	}

	public void addComponents() {
		add(panel, BorderLayout.CENTER);
	}

	public DefaultPieDataset getData() {
		return data;
	}

	public JFreeChart getChart() {
		return chart;
	}

	public ChartPanel getPanel() {
		return panel;
	}
}
