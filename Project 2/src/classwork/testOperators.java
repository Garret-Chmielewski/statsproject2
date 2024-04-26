package classwork;

import java.math.BigInteger;
import java.util.ArrayList;

public class testOperators  
{
	public static void main(String[] args) 
	{
		SetOperations test = new SetOperations(); 
		
		double findPossion = test.poisson(4,4);
		
		double cheb = test.chebyshevs(2);
		
		System.out.println("Chapter 3");
		
		System.out.println("the Poisson distribution of these numbers is: " + findPossion);
		
		System.out.println("the percentage using Chebyshev's theorem is : " + cheb);
		
		System.out.println();
		
		System.out.println("Chapter 4");
		
		double findUniform = test.UniformPD(55,70,65,70);
		
		double uniformE = test.expectedUniform(50,70);
		
		double uniformSD = test.SDUniform(50,70);
		
		System.out.println("the Uniform Probability Distribution of these numbers is: " + findUniform);
		
		System.out.println("The expected value for this Uniform Probability Distribution is: "+ uniformE);
		
		System.out.println("The expected value for this Uniform Probability Distribution is: " + uniformSD);
	}
}
