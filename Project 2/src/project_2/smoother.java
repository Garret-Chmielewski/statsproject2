package project_2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import java.io.*;
import java.util.ArrayList;

public class smoother 
{
    public void smooth(String filename, int leftBound, int rightBound) throws IOException 
    {
        BufferedReader reader = new BufferedReader(new FileReader(filename));
        ArrayList<Integer> saltedData = new ArrayList<>();
        FileWriter fileWriter = new FileWriter("SmoothedPolynomialResults.csv");
        BufferedWriter writer = new BufferedWriter(fileWriter);
        String currentLine = "";
        String[] values;
        try 
        {
            while ((currentLine = reader.readLine()) != null) 
            {
                values = currentLine.split(",");
                int value = Integer.parseInt(values[0]);
                saltedData.add(value);
            }

            //0, 1, 2, 3, 4, 5, 6, 7, 8, 9,  10, 11
            //1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12
            double sum = 0;
            int count = 0;
            for (int i = 0; i < saltedData.size(); i++) 
            {
                if (i >= leftBound || i <= rightBound) 
                {
                    sum = sum + saltedData.get(i);
                    count++;
                }

            }
            double average = sum / count;
            String smoothedValue = String.valueOf(average);
            writer.write(smoothedValue);
            
            System.out.println("Smoothing is complete");
        }
        	
        catch (IOException e)
        {
            e.printStackTrace();
        }
		finally
        {
            try
            {
                if (reader != null) 
                {
                    reader.close();
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