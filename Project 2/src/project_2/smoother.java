package project_2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class smoother 
{
	public void smoothData(String filename,int windowValue_x, int windowValue_y) 
	{
		BufferedReader objReader = null;
		FileWriter writer = null;
		BufferedWriter Creater = null;
		int linenum = 0;
		ArrayList<Integer> yData = new ArrayList<Integer>();
		try 
		{
			objReader = new BufferedReader(new FileReader(filename));
			writer = new FileWriter("Function_points_smoothed.csv");
			Creater = new BufferedWriter(writer);
			String strLine = "";
			while ((strLine = objReader.readLine()) != null)
			{
				String[] values = strLine.split(",");
				int y_values = Integer.parseInt(values[1]);
				yData.add(y_values);
			}
}
