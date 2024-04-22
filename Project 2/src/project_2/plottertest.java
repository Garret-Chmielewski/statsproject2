package project_2;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;

public class plottertest 
{
	public static void main(String[] arg) throws IOException
	{
		plotter test= new plotter();
		
		PrintWriter data= new PrintWriter("plot.csv");
		
		//test.run(5000);
		
		salter trial =new salter();
				
		//trial.saltedvalues("plotter.csv",2500, 7500);		
		
		smoother burgle = new smoother();
		
		burgle.smooth("Function_points_salted.csv",6000,6000);
	}
}
