package plotterSalterSmotherV3;

import java.io.FileWriter;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import org.jfree.ui.ApplicationFrame;

public class plotterv3 extends ApplicationFrame 
{
	private static final long serialVersionUID = 1L;
	private XYSeries plotter = new XYSeries("Plotter");
	private int lowlimit = 0;
	private int upperlimit = 5000;
	
	public void run() 
	{
		System.out.println("Plot is compleate");
		
		pack();
		setVisible(true);
	}
	public plotterv3(String title) 
	{
		super(title);
		createchart("Plotter Graph V3",createPlotter());
	}
	public void createchart(String title, XYDataset dataset)
	{
		JFreeChart XYLineChart = ChartFactory.createXYLineChart(title,"x","y", dataset, PlotOrientation.VERTICAL,false,false,false);
		ChartPanel chartpan = new ChartPanel(XYLineChart);
		chartpan.setPreferredSize(new java.awt.Dimension(1000,500));
		setContentPane(chartpan);
	}
	
	private XYDataset createPlotter()
	{
		for(int i = lowlimit; i <= upperlimit; i++)
		{		
			int function = (int) (Math.pow(i, 2))+(2*i)-1;
			
			plotter.add(i,function);
			
			writeTofile(i,function);
		}
		final XYSeriesCollection dataset = new XYSeriesCollection();
		dataset.addSeries(plotter);
		return dataset;
	}
	
	private void writeTofile(int dim, int function)
	{
		
		try (FileWriter  Creater= new FileWriter("plotter_V3.csv", true))
		{	
			String s2 = (dim + "," + function + "\n" );
			Creater.write(s2);
			Creater.flush();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public XYSeries getPlotterSet() {
		return plotter;
	}
	public int getlowlimit() {
		return lowlimit;
	}
	
	public int getupperlimit() {
		return upperlimit;
	}
}
