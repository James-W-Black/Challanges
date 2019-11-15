package CodilityChallanges;



public class diverseString 
{

	//for this challenge we had to create the longest possible diverse string consisting of a number of a's, b number of b's and c number of c's,
	//without any one letter being entered more than twice at a time. for example a: 1 b:3 c:1, could yield a correct result of: bbacb
	
	//I created 2 solutions to this challenge. As i was interested which would work better. The second solution, seems to work 3-5 nanoseconds faster. 
	
	public static void main(String[] args) 
	{
		
		long startTime = System.nanoTime();
		System.out.println(solution(1,3,1));
		System.out.println(solution(6,1,1));
		System.out.println(solution(0,1,8));
		System.out.println(solution(1,1,1));
		long endTime = System.nanoTime();
		
		System.out.println("\nThat took: " + (endTime-startTime)  + " nanoseconds\n");
		
		long startTime2 = System.nanoTime();
		System.out.println(solution2(1,3,1));
		System.out.println(solution2(6,1,1));
		System.out.println(solution2(0,1,8));
		System.out.println(solution2(1,1,1));
		long endTime2 = System.nanoTime();
		
		System.out.println("\nThat took: " + (endTime2-startTime2)  + " nanoseconds");
	}
	
	
	public static String solution(int A, int B, int C) 
	{

		 String substring = "";
		 
		 //First, load the string with 2 letters, to allow for char checking in the next stage, this also provides
		 //an easy way to ensure the string starts with the largest letter first
		 for(int i=0; i<2; i++) {
			  
			  if(A>0 && A>B && A>C) {substring += 'a'; A--;} 
			  else if(B>0 && B>A && B >C) {substring += 'b'; B--;} 
			  else if(C>0 && C>B && C >A) {substring += 'c'; C--;} 
			  else {
				  
				  if(A>0)
				  {
					  substring+='a';
					  A--;
					  continue;
				  }
				  
				  else if(B>0)
				  {
					  substring+='b';
					  B--;
					  continue;
				  }
				  else if(C>0)
				  {
					  substring+='c';
					  C--;
					  continue;
				  }
				  
			  }
			  }
		 
		 //loop through all possible letters which could be added, adding if it meets the requirements of the string, using charAt to ensure this.
		 int n = A+B+C;
		 for(int i=0; i<n; i++)
		 {
			 if (A>0)
		 {
				 if(substring.charAt(substring.length()-1) != 'a' || substring.charAt(substring.length()-2) != 'a')
				 {
					 substring += 'a';
					 A--;
				 }
			 }
			 
			 if (B>0)
			 {
				 if(substring.charAt(substring.length()-1) != 'b' || substring.charAt(substring.length()-2) != 'b')
				 {
					 substring += 'b';
					 B--;
				 }
			 }
			 
			 if (C>0)
			 {
				 if(substring.charAt(substring.length()-1) != 'c' || substring.charAt(substring.length()-2) != 'c')
				 {
					 substring += 'c';
					 C--;
				 }
			 }
			 
		 }
		 
		 
		return substring;
	}
	
	public static String solution2(int A, int B, int C) 
	{
		//this solution uses a different approach, creating a integer number for each letter and using this to count the number of times a single letter 
		//is entered, this allows you to control how many times a certain letter can be placed down one after another.
		
		int n = A+B+C;
		String substring = "";
		int a  =0;
		int b =0;
		int c=0;
			
		for(int i = 0; i<2;i++)
		{
			if(A>0 && A>B && A>C) {substring += 'a'; A--; a++; b=0; c=0;} 
			  else if(B>0 && B>A && B >C) {substring += 'b'; B--; b++; a=0; c=0;} 
			  else if(C>0 && C>B && C >A) {substring += 'c'; C--; c++; a=0; b=0;} 
		}
		
		
		 for(int i=0; i<n ;i++)
		 {
			 if(A > 0 && a < 2)
			 {
				 substring += "a";
				 a++;
				 A--;
				 b =0;
				 c = 0;
			 }
		 if(B > 0 && b < 2)
			 {
				 substring += "b";
				 b++;
				 B--;
				 a =0;
				 c =0;
			 }
		 if(C > 0 && c < 2)
		 	{
				 substring += "c";
				 c++;
				 C--;
				 a=0;
				 b =0;
		 	}
		 }
		 
		 return substring;
	}
	}

