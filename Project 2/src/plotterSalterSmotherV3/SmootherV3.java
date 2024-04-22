package plotterSalterSmotherV3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

import org.apache.commons.math4.legacy.stat.descriptive.DescriptiveStatistics;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import org.jfree.ui.ApplicationFrame;

public class SmootherV3 extends ApplicationFrame
{
	private static final long serialVersionUID = 1L;
	private XYSeries salter = new XYSeries("Salter");
	private XYSeries smoother = new XYSeries("Smoother");
	private int lowlimit = 0;
	private int upperlimit = 5000;
	
	
	public void run() 
	{
		System.out.println("smoothing is compleate");
		
		pack();
		setVisible(true);
	}
	
	public SmootherV3(String title) 
	{
		super(title);
		createLinechart("Smooth Graph V3",Smoother(6000));
	}
	
	public void createLinechart(String title, XYDataset dataset)
	{
		JFreeChart XYLineChart = ChartFactory.createXYLineChart(title,"x","y", dataset, PlotOrientation.VERTICAL,false,false,false);
		ChartPanel chartpan = new ChartPanel(XYLineChart);
		chartpan.setPreferredSize(new java.awt.Dimension(1000,500));
		setContentPane(chartpan);
	}
	
	private XYDataset Smoother(int slidingWindowLength) 
	{
		DescriptiveStatistics ds = new DescriptiveStatistics();
		readCSVToData(3);
		for(int i = 0; i < smoother.getMaxX(); i++) 
		{
			ds.setWindowSize(slidingWindowLength);
			ds.addValue(smoother.getY(i).intValue());
			double rollingAvg = ds.getMean();
			smoother.update(smoother.getX(i), rollingAvg);
			writeTofile(smoother.getX(i).intValue(), (int) rollingAvg);
		}
		final XYSeriesCollection dataset = new XYSeriesCollection();
		dataset.addSeries(smoother);
			
		return dataset;
	}
	
	private void writeTofile(int dim, int function)
	{
		try (FileWriter Creater = new FileWriter("SmootherV3.csv",true))
		{
			if(dim == lowlimit) 
			{
				Creater.write("x" + "," + "y\n");
			}
			
			String s2 = (dim + "," + function + "\n");
			Creater.write(s2);
			Creater.flush();
			
		
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
	public void readCSVToData(int num) 
	{
		BufferedReader objReader = null;
		int counter = 0;
		
		try 
		{
			objReader = new BufferedReader(new FileReader("SalterV3.csv"));
			String strLine = "";
			while((strLine = objReader.readLine()) != null) 
			{
				if(counter != 0) 
				{
					String[] values  = strLine.split(",");
					int x = Integer.parseInt(values[0]);
					int y = Integer.parseInt(values[1]);
						
					if(num == 2) 
					{
						salter.add(x, y);
					} 
					else if (num == 3) 
					{
							smoother.add(x, y);
					}
				}
				counter++;
			}
	   } 
	   catch (Exception e) 
	   {
		 e.printStackTrace();
	   }
	}
	public XYSeries getSmootherData() {
		return smoother;
	}
	public int getlowlimit() {
		return lowlimit;
	}
	
	public int getupperlimit() {
		return upperlimit;
	}
}
