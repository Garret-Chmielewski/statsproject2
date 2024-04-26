package stockBot;
/**
 * referenced this git hub 
 * https://github.com/Roxy-0904/Probability-and-applied-statistics/tree/master/Project_2/src/stockmarket
 */
public class stockreader 
{
	 private String date;
	 private double open;
	 private double close;

    
    
    public stockreader (String date, double open, double close) {
        this.date = date;
        this.open = open;
        this.close = close;

    }

    public String getDate() 
    {
        return date;
    }

    public double getOpenPrice() 
    {
        return open;
    }

    public double getClosePrice() 
    {
        return close;
    }

  
    public void setDate(String date) 
    {
        this.date = date;
    }

    public void setOpenPrice(double openPrice) {
        this.open = openPrice;
    }

    public void setAdjClosePrice(double closePrice) 
    {
        this.close = closePrice;
    }
    @Override
    public String toString() 
    {
        return "StockData{" +
                "date='" + date + '\'' +
                ", open=" + open +
                ", close=" + close +
                '}';
    }
}

