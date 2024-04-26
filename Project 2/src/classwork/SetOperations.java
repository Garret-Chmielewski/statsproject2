package classwork;

public class SetOperations 
{
	
	public int factorial(int n) {
	      int fact = 1;
	      int i = 1;
	      while(i <= n) {
	         fact = fact * i;
	         i++;
	      }
	      return fact;
	   }
	
	/**
	 * find the permutations between two numbers 
	 * @param n one integer that the user selected 
	 * @param r another integer that the user selected 
	 * @return
	 */
	public int permutaion(int n, int r)
	{
		int per=factorial(n) / factorial(n-r);
		return per;
	}
	/**
	 * find the combinations between two numbers 
	 * @param n one integer that the user selected 
	 * @param r another integer that the user selected 
	 * @return
	 */
	public int combination(int n, int r)
	{
		int com =factorial(n) / (factorial(r) * factorial(n-r));
		return com;
	}
	
	/* Chapter 3 coding*/
	
	/**
	 * used to find the poisson distribution 
	 * @param l the time period for problem 
	 * @param y random variable 
	 * @return
	 */
	public double poisson(double l, int y)
	{
		double num = (Math.pow(l, y)*Math.pow(Math.E, -l));
		double dem = factorial(y);
		double result = num/dem;
		return result;
	}
	/**
	 * Uses Tchebysheffs to find % of where value can fall in a range
	 * @param k random value
	 * @return
	 */
	public double chebyshevs(int k)
	{
		double result = 1-(1/Math.pow(k, 2));
		return result;
	}
	/**
	 * this method does the Uniform Probability Distribution
	 * @param a lower range
	 * @param b higher range
	 * @param c different lower range
	 * @param d different higher range
	 * @return
	 */
	public double UniformPD(double a,double b,double c,double d)
	{
		double num = d-c;
		double dem = b-a;
		double result = num/dem;
		return result;
	}
	/**
	 * this is the method for expected value of Uniform Distribution
	 * @param a lower range
	 * @param b higher range
	 * @return
	 */
	public double expectedUniform(double a, double b)
	{
		double num = a+b;
		double result = num/2;
		return result;
	}
	/**
	 * this is the method for standard Distribution of Uniform Distribution
	 * @param a lower range
	 * @param b higher range
	 * @return
	 */
	public double SDUniform(double a, double b)
	{
		double num = (Math.pow(b-a, 2));
		double result = num/12;
		return result;
	}

}
