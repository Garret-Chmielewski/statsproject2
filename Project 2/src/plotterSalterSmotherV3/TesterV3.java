package plotterSalterSmotherV3;

public class TesterV3 
{
	public static void main(String[] args)
	{
		
		plotterv3 graph = new plotterv3 ("plotterv3");
		graph.run();
		//graph.plotterOfgraph(0,50);
		//graph.plotterOfgraph(2,100);
		SalterV3 salt = new SalterV3("Salter_vs3");
		salt.run();
		//salt.saltedvalues("Function_points.csv",5,10);
		//salt.saltedvalues("Function_points.csv",2500, 7500);
		SmootherV3 smooth = new SmootherV3("Smoother_vs3");
		smooth.run();
		//smooth.smoothData( "Function_points_salted.csv",5, 5);
		//smooth.smoothData( "Function_points_salted.csv",6000,6000);
		
		
	}

}
