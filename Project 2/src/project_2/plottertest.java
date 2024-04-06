package project_2;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class plottertest 
{
	public static void main(String[] arg) throws FileNotFoundException
	{
		plotter test= new plotter();
		PrintWriter data= new PrintWriter("plot.csv");
		
		//test.run(100);
		
		salter trial =new salter();
				
		trial.saltedvalues("plotter.csv",2500, 7500);		
		
	}
}
