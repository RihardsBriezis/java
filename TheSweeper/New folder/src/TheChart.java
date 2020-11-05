import javax.swing.JFrame;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;

public class TheChart extends JFrame
{
	private static final long serialVersionUID = -0L;
	
	TheChart()
	{
		this.setTitle("Yup, this is my first chart window");
		this.setBounds(400 , 100 , 800 , 600);
		this.setVisible(true);
		this.setDefaultCloseOperation(TheChart.EXIT_ON_CLOSE);
	}
	
	CategoryDataset createCountDataset(String[] names, int[] values, double[] prices)
	{		
		DefaultCategoryDataset ds = new DefaultCategoryDataset();
		
		if (names.length == values.length)
		{
			int c = names.length;
			for(int i = 0; i<c; i++)
			{
				ds.addValue(values[i], names[i], "Pirkumu skaits");
			}
			for(int i = 0; i<c; i++)
			{
				ds.addValue(prices[i], names[i], "Pirkumu skaits");
			}
		}
		
		return ds;
	}
	
	void makeCountBarChart(String[] names, int[] values, double[] prices)
	{
		JFreeChart barChart = ChartFactory.createBarChart("Purchase count" , "Type" , "Amount" , createCountDataset(names, values, prices) , PlotOrientation.VERTICAL , true , true , false);
		ChartPanel chartPanel = new ChartPanel(barChart);
		this.setContentPane(chartPanel);
		this.repaint();
		chartPanel.setHorizontalAxisTrace(true);
		chartPanel.setVerticalAxisTrace(true);
		this.pack();
	}
}
