package com.impetus.invc_mgmt.util;

import java.awt.Color;
import java.util.List;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.labels.StandardCategoryToolTipGenerator;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.CategoryItemRenderer;
import org.jfree.chart.urls.StandardCategoryURLGenerator;
import org.jfree.data.category.DefaultCategoryDataset;

import com.impetus.invc_mgmt.exception.GenericException;

// TODO: Auto-generated Javadoc
/**
 * The Class CreateGraph is used to generate the graph related to invoices.
 */
public class CreateGraph {

	/** The Constant RECEIVED. */
	private static final String RECEIVED = "Received";

	/** The Constant DUE. */
	private static final String DUE = "Due";

	/**
	 * Instantiates a new creates the graph.
	 */
	public CreateGraph() {

	}

	/**
	 * Gets the chart img.
	 * 
	 * @param param
	 *            the param
	 * @param list
	 *            the list
	 * @return the chart img
	 */
	@SuppressWarnings("deprecation")
	public JFreeChart getChartImg(String param, List<Double> list) {

		final int three = 3, four = 4, five = 5, six = 6, seven = 7;

		JFreeChart chart = null;
		try {

			// Create a simple Bar chart

			DefaultCategoryDataset dataset = new DefaultCategoryDataset();

			dataset.setValue(list.get(0), RECEIVED, param + " 4");
			dataset.setValue(list.get(1), DUE, param + " 4");

			dataset.setValue(list.get(2), RECEIVED, param + " 3");
			dataset.setValue(list.get(three), DUE, param + " 3");

			dataset.setValue(list.get(four), RECEIVED, param + " 2");
			dataset.setValue(list.get(five), DUE, param + " 2");

			dataset.setValue(list.get(six), RECEIVED, param + " 1");
			dataset.setValue(list.get(seven), DUE, param + " 1");

			chart = ChartFactory.createBarChart3D("Collection of Last 4 "
					+ param + "s", "Last 4 " + param + "s", "Collection",
					dataset, PlotOrientation.VERTICAL, true, true, false);
			chart.setBackgroundPaint(Color.white);

			// Set the background colour of the chart
			chart.getTitle().setPaint(Color.blue);

			// Adjust the colour of the title
			CategoryPlot plot = chart.getCategoryPlot();

			// Get the Plot object for a bar graph

			plot.setBackgroundPaint(Color.white);
			plot.setRangeGridlinePaint(Color.red);
			CategoryItemRenderer renderer = plot.getRenderer();
			renderer.setSeriesPaint(0, Color.red);
			renderer.setSeriesPaint(1, Color.green);
			renderer.setItemURLGenerator(

			new StandardCategoryURLGenerator("index1.html", "series", "section"));
			renderer.setToolTipGenerator(new StandardCategoryToolTipGenerator());

		} catch (Exception e) {
			throw new GenericException("ERROR!");
		}

		return chart;
	}

}
