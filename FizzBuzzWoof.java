package CodilityChallanges;

import java.util.Scanner;

//allow user input to define the size of result, every number divisible by 2,3,5 should be printed as Fizz, Buzz and Woof respectively.
//if divisible by multiple, concatenate the strings


public class FizzBuzzWoof 
{
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		
		System.out.println("please enter the size of the result as an integer:");
		int n = sc.nextInt();
		
		fizzBuzzWoof(n);
		
		sc.close();
		
	}
	
	
	public static void fizzBuzzWoof(int n)
	{
	
	for(int i = 1; i<=n; i++)
		{
			//create string, by creating it in the for loop we allow it to be cleared after every iteration
			String result = "";
			
			//here we check if i is perfectly divisible by the set numbers, 2,3 and 5. If so, add onto the string and then print.
			if(i%2 == 0)
			{
				result += "Fizz";
			}
			
			if(i%3 == 0)
			{
				result += "Buzz";
			}
			
			if(i%5 == 0)
			{
				result += "Woof";
			}
			
			//if i is not divisible by these numbers, make the string = the integer value and print
			if(i%2 !=0 && i%3 !=0 && i%5!= 0)
			{
				result = "" + i;
			}
			
			System.out.println(i + ": " + result);
		}
	}
	
}


