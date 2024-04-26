package project_2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import java.io.*;
import java.util.ArrayList;
/*
 * Mia helped me finish the smoother
 */
public class smoother 
{
	ArrayList<Double> salted = new ArrayList<>();
	
	ArrayList<Double> smoothed = new ArrayList<>();
	

    public void smooth(String file, int window) throws IOException {
        
        BufferedReader reader = new BufferedReader(new FileReader(file));
        String currentLine;
        PrintWriter writer = new PrintWriter("SmoothedResults.csv");
 
        while((currentLine = reader.readLine()) != null) {
            String[] values = currentLine.split(",");
            for (String value : values) {
            	salted.add(Double.valueOf(value));
            }
        }
        
        for(int i = 0; i < salted.size(); i++) {
            double currentValue = salted.get(i);
            double leftSum = 0;
            double rightSum = 0;
 
            int count = 1;
            int bound = 1;
            if (i != 0 && i != salted.size() - 1) {
                while(bound <= window) {
                    if(i - bound >= 0) {
                        count = count + 1;
                        leftSum = leftSum + salted.get(i - bound);
                    }
                    else if(i + bound < salted.size()) {
                        count = count + 1;
                        rightSum = rightSum + salted.get(i + bound);
                    }
                    bound++;
                }
            }
            else if (i == 0) {
                while(bound <= window) {

                    if(i + bound < salted.size()) {

                        count = count + 1;
                        rightSum = rightSum + salted.get(i + bound);
                    }
                    bound++;
                }
            }

            else if (i == salted.size() - 1) {

                while(bound <= window) {

                    if (i - bound >= 0) {

                        count = count + 1;
                        leftSum = leftSum + salted.get(i - bound);
                    }

                    bound++;
                }
            }

            double smoothedValue = (leftSum + rightSum + currentValue) / count;
            smoothed.add(smoothedValue);
        }
        for (Double number : smoothed) {
            writer.println(number);
        }
        System.out.print("smoothing is complete");
        writer.close();
        
    }
}    