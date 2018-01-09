import java.util.*;


public class MissingTwo
{
	public static void main(String args[])
	{
		int[] test = {1,3,4,5,6,7};
		int[] output = missingTwo(test);
		System.out.println(output[0] + " " + output[1]);
	}


	private static int countToN(int n)
	{
		if(n<1)
			return 0;

		return (n*(n+1))/2;
	}

	public static int[] missingTwo(int[] array)
	{
		int[] output = {-1,-1};
		int n = array.length;
		int count = countToN(n+2);

		int c1 = count;

		for(int i=0; i<array.length; i++)
			c1 -= array[i];

		if(c1<0)
			return output;

		int mid = c1/2;

		int b = count - countToN(mid);
		for(int i=0; i<array.length; i++)
			if(array[i] > mid)
				b -= array[i];

		output[1] = b;
		output[0] = c1-b;

		return output;
	}
}