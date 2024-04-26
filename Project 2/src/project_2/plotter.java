package project_2;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.io.IOException;

public class plotter 
{
	public double parb(int x)
	{	
		double result = Math.pow(x, 2)+ (2*x)+1;
		return result;
	}
	
	public void run(double runamount)
	{
		try(FileWriter Writer = new FileWriter("plotter.csv");
				BufferedWriter creator = new BufferedWriter(Writer))
			{
				for(int j =0; j<runamount;j++)
				{
					int function = (int) parb(j);
					creator.write(String.valueOf((function))); 
					creator.newLine();
				}
				System.out.println(" successfully transfered to file" );
			}
			catch(IOException e)
			{
				e.printStackTrace();
			}
	}
	
}
