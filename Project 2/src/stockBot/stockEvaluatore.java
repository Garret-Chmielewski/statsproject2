package stockBot;
/**
 * referenced this git hub 
 * https://github.com/Roxy-0904/Probability-and-applied-statistics/tree/master/Project_2/src/stockmarket
 *  Mia helped complete
 */
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import project_2.smoother;

public class stockEvaluatore 
{
	public static Map<String, stockreader > readData(String File) 
	{
        Map<String, stockreader > stockDataM = new HashMap<>();

        try (BufferedReader objReader = new BufferedReader(new FileReader(File))) 
        {
        	objReader.readLine(); 

            String line;
            while ((line = objReader.readLine()) != null) 
            {
                String[] columns = line.split(",");

                String date = columns[0];
                double open = Double.parseDouble(columns[1]);
                double close = Double.parseDouble(columns[2]);

                stockreader  stockData = new stockreader (date, open, close);
                stockDataM.put(date, stockData);
            }
        } catch (IOException e) 
        {
            e.printStackTrace();
        }
        return stockDataM;
    }
	public static double calculateMovingAverage(List<Double> cost, int time) 
	{

	        double sum = 0;


	        for (int i = 0; i < time; i++) {

	            sum += cost.get(i);

	        }
	        
	        return sum / time;
	    }

    public static void main(String[] args) 
    {
        String File = "GME.csv";
        Map<String, stockreader> stockDataM = readData(File);


        System.out.println(stockDataM.get("12/12/2022"));
        System.out.println();

    }
}

