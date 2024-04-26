package project_2;
/**
 * geot reference from this git hub
 * https://github.com/Roxy-0904/Probability-and-applied-statistics/tree/master/Project_2
 */
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class salter 
{
	int current=0;
	private static final Random n = new Random();
	public void  saltedvalues(String filename,int minsaltvalue, int maxsaltvalue)
	{
		BufferedReader Reader = null;
		FileWriter writer = null;
		BufferedWriter Creater = null;
		try 
		{
			Reader = new BufferedReader(new FileReader(filename));
			writer = new FileWriter("salted.csv");
			Creater = new BufferedWriter(writer);
			String strLine = "";
			while ((strLine = Reader.readLine()) != null) 
			{
				String[] values = strLine.split("");
				int randomNumber = n.nextInt(maxsaltvalue - minsaltvalue / 2);
				int old_y_values = Integer.parseInt(values[0]);
				int new_y_values = randomNumber + old_y_values;
				values[0] = Integer.toString(new_y_values);
				String s2 = (values[0]);
				Creater.write(s2);
				Creater.newLine();
				Creater.flush();
				
			}
			current++;
			System.out.println("Salting is complete");
		}
		
		catch (IOException e) 
		{
			e.printStackTrace();
		} 
		finally 
		{
			try 
			{
				if (Reader != null)
				{
					Reader.close();
					writer.close();
				}
		     
		   } 
		   catch (IOException ex) 
		   {
			   ex.printStackTrace();
		   }
		}	
	}	
}
	
	

