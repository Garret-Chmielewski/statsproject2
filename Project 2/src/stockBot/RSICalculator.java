package stockBot;
/**
 * referenced this git hub 
 * https://github.com/Roxy-0904/Probability-and-applied-statistics/tree/master/Project_2/src/stockmarket
 * Mia helped complete
 */
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
public class RSICalculator 
{
	 public static double calculateRSI(List<stockreader > Data, int quarter) {
	        // Ensure enough data is available
	        if (Data.size() < quarter) {
	            throw new IllegalArgumentException("Insufficient data for RSI calculation");
	        }

	        double averageGain = 0, averageLoss = 0;

	        // Initial average gain/loss calculation
	        for (int i = 1; i <= quarter; i++) {
	            double Change = Data.get(i).getClosePrice() - Data.get(i - 1).getClosePrice();
	            if (Change > 0) {
	                averageGain += Change;
	            } else {
	                averageLoss += Math.abs(Change);
	            }
	        }

	        averageGain /= quarter;
	        averageLoss /= quarter;

	        // Continued calculation for the remaining days
	        for (int i = quarter; i < Data.size(); i++) {
	            double Change = Data.get(i).getClosePrice() - Data.get(i - 1).getClosePrice();
	            if (Change > 0) {
	                averageGain = ((averageGain * (quarter - 1)) + Change) / quarter;
	                averageLoss = (averageLoss * (quarter - 1)) / quarter;
	            } else {
	                averageLoss = ((averageLoss * (quarter - 1)) + Math.abs(Change)) / quarter;
	                averageGain = (averageGain * (quarter - 1)) / quarter;
	            }
	        }

	        double rs = (averageLoss == 0) ? 100 : averageGain / averageLoss;
	        return 100 - (100 / (1 + rs));
	    }

	    public static void main(String[] args) {
	        String csvFilePath = "GME.csv"; 

	        // Use CSVReader to get the stock data
	        Map<String, stockreader > stockMap = stockEvaluatore.readData(csvFilePath);
	        List<stockreader > stockData = new ArrayList<>(stockMap.values());

	        // Sort the list by date
	        Collections.sort(stockData, Comparator.comparing(stockreader ::getDate));

	        try {
	            int periodLength = 14; // Typical RSI period length
	            double rsi = calculateRSI(stockData, periodLength);
	            System.out.println("RSI: " + rsi);
	        } catch (IllegalArgumentException e) {
	            System.out.println("Error: " + e.getMessage());
	        }
	    }
}