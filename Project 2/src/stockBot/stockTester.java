package stockBot;
/**
 * referenced this git hub 
 * https://github.com/Roxy-0904/Probability-and-applied-statistics/tree/master/Project_2/src/stockmarket
 */
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Map;
import java.util.List;

public class stockTester 
{
	public static void main(String[] args) 
	{
		String File ="GME.csv";
		Map<String, stockreader> stockinfo = stockEvaluatore.readData(File); 
		
		List<stockreader> stock = new ArrayList<>(stockinfo.values());
		
		Collections.sort(stock, Comparator.comparing(stockreader :: getDate)); 
		
		try 
		{
			int periodLength =14;
			double rsi = RSICalculator.calculateRSI(stock, periodLength);
			System.out.println("Rsi is:  " + rsi);
		}
		catch (IllegalArgumentException e)
		{
			System.out.println("Error: "+ e.getMessage());
		}
	}
}
