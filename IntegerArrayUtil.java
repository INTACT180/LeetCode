
import java.util.*;

public class IntegerArrayUtil
{
	public static void main (String[] args)
	{
		int [] array = new int[] {7,5,9,0,2,1,3,5,7,9,1,1,5,8,8,9,7};
		int [] uniqueSet = new int[] {1,5,9};
	    System.out.println(uniqueSet.toString());

	    printArray(array);
	    printArray(uniqueSet);

	    printArray(shortestSubsequence(array,uniqueSet));
	}

	public static void printArray(int[] array)
	{
		System.out.print("[");
		for(int i=0; i<array.length; i++)
		{
			System.out.print(array[i]);
			if(i != array.length -1)
				System.out.print(", ");
		}

		System.out.print("]\n");
	}
	public static int[] shortestSubsequence(int[] array, int[] uniqueSet)
	{
		if(uniqueSet.length > array.length)
			return int [] { -1, -1};
		
		HashMap<Integer, Integer> set = new HashMap<Integer, Integer>();

		for( int x : uniqueSet)
		{
			set.put(x,0);
		}
		
		int start =-1;
		int end   =-1;
		int minStart =-1;
		int minEnd   =-1;

		int complete = 0;
		int sizeC = uniqueSet.length;
		Integer count;
	
		for(int i=0; i < array.length; i++)
		{
			count = set.get(array[i]);
			
			if(count== null)
			{
				continue;
			}
			
			// We found one more
			set.put(array[i],count+1);

			if(count == 0) // we found something new
				complete++;
						
			if( start == -1)
			{
				start = i; //found a guy
				continue;
			}	

			if(array[start] == array[i])
			{
				start++;
				set.put(array[i],count--);

				count = set.get(array[start]);
				while(count == null || count > 1)
				{
					if(count ==null)
					{
						start++;
				count = set.get(array[start]);
				}
					else
					{
						set.put(array[i],count--);
						start++;
						count = set.get(array[start]);
					}
				}
			}

			if(complete == sizeC)
			{
				end = i;
				if( minStart== -1)
				{
					minStart = start;
					minEnd   = end;
				}
				else
				{
					int diff = end - start;
					int diff2 = minEnd -minStart;
					if(diff < diff2)
					{
						minStart = start;
						minEnd = end;
					}
				}
			}
		}
			
		if(minEnd == -1)
			return int [] { -1, -1};

		return new int [] { minStart, minEnd} ;
	}
}
