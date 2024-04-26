package plotterSalterSmotherV3;

public class TesterV3 
{
	public static void main(String[] args)
	{
		
		plotterv3 graph = new plotterv3 ("plotterv3");
		graph.run();

		SalterV3 salt = new SalterV3("Salter_vs3");
		salt.run();

		SmootherV3 smooth = new SmootherV3("Smoother_vs3");
		smooth.run();	
	}

}
