package CodilityChallanges;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class smallestNotInArray 
{
	
	//Here we must find the smallest number which does not exist in a given array. The array can be filled with both positive and 
	//negative numbers. In this example i use an array of size 10 with randomly generated integers between 1 & 10
	
	public static void main(String[] args)
	{
		//generate an array of length 10 with random numbers between 1 & 10, either positive or negative
		
		int[] a = new int[10];
		
		for(int i = 0; i<10;i++)
		{
			Random rand = new Random();
			a[i] =  rand.nextInt(11) * (rand.nextBoolean() ? -1 : 1);
			System.out.println(a[i]);
		}
		
		System.out.println("\n\nResult: " + getSmallest(a));
	}
	
	public static int getSmallest(int[] a)
	{
		//create a hash set and move all positive integers into this set, this allows for easy searching and also eliminates
		//the negative numbers
		Set<Integer> hS = new HashSet<Integer>();
		
		for(int A: a)
		{
			if(A > 0)
			{
				hS.add(A);
			}
		}
		
		
		//create smallestNum, if the size == 0, for instance if there was no positive numbers, then it will be 1.
		int smallestNum = 0;
		
		if(hS.size() == 0)
		{
			return smallestNum;
		}
		
		//loop through the set and check against possible i's.
		for(int i = 1; i<a.length+1; i++)
		{
			if(!hS.contains(i))
			{
				smallestNum = i;
				break;
			}
		}
		
		//if smallestNum still = 0, this means every number from 1 -> the size of the set was in the set. 
		//in this case the smallestNum not there will be the size + 1
		if(smallestNum == 0)
		{
			smallestNum = hS.size() + 1;
		}
		
		
		return smallestNum;
	}
}
