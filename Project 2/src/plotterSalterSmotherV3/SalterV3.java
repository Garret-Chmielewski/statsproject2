package plotterSalterSmotherV3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Random;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import org.jfree.ui.ApplicationFrame;


public class SalterV3 extends ApplicationFrame
{
	private static final long serialVersionUID = 1L;
	private XYSeries salter = new XYSeries("Salter");
	private XYSeries smoother = new XYSeries("Smoother");
	private static final Random n = new Random();
	private int lowlimit = 0;
	private int upperlimit = 5000;
	
	public void run() 
	{
		System.out.println("salting is complete");
		
		pack();
		setVisible(true);
	}
	public SalterV3(String title) 
	{
		super(title);
		createLinechart("salt Graph V3",Salter(2500, 7500));
	}
	public void createLinechart(String title, XYDataset dataset)
	{
		JFreeChart XYLineChart = ChartFactory.createXYLineChart(title,"x","y", dataset, PlotOrientation.VERTICAL,false,false,false);
		ChartPanel chartpan = new ChartPanel(XYLineChart);
		chartpan.setPreferredSize(new java.awt.Dimension(1000,500));
		setContentPane(chartpan);
	}
	
	private XYDataset Salter(int minsaltvalue, int maxsaltvalue)
	{
		readCSVToData(2);
		for (int i = 0; i <= salter.getMaxX(); i++)
		{
			int randomNumber = n.nextInt(maxsaltvalue - minsaltvalue / 2);
			int new_y_values = salter.getY(i).intValue();
			new_y_values = new_y_values + randomNumber;
			
			// update() updates an the index value's x-value in the series
			salter.update(salter.getX(i), new_y_values);
			writeTofile(salter.getX(i).intValue(),new_y_values);
		}
		final XYSeriesCollection dataset = new XYSeriesCollection();
		dataset.addSeries(salter);
		return dataset;
	}

	
	private void writeTofile(int dim, int function)
	{
		
		try (FileWriter Creater = new FileWriter("SalterV3.csv",true))

		{
			
			String s2 = (dim + "," + function+"\n");
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
		int counter = 0;String strLine = "";
	
		try {
			objReader = new BufferedReader(new FileReader("plotter_V3.csv"));
			
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
	public XYSeries getSalterData() 
	{
		return salter;
	}
	public int getlowlimit() {
		return lowlimit;
	}
	
	public int getupperlimit() {
		return upperlimit;
	}
}
