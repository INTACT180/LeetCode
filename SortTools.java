

public class SortTools
{
	
	public static void main (String[] args)
	{
		int[] array = new int[] {10,9,8,7,6,5,4,3,2,1,0};
		printArray(array);
		mergeSort(array);
		printArray(array);
	}

	public static void printArray(int[] array)
	{
		for(int x : array)
		{
			System.out.print(x + " ");
		}
		System.out.println();
	}

	public static void mergeSort(int[] array)
	{
		if(array.length <2)
			return;

		mergSort(array, 0, array.length-1);
		return;
	}

	private static void mergSort(int[] array, int left, int right)
	{
		if(right<=left)
			return;
		int mid = (right - left)/2;
		int newRight= mid+ left;
		int newLeft = mid+1 + left;

		mergSort(array, left, newRight);
		mergSort(array, newLeft, right);
		//System.out.println("Call : " + left + " " + newRight + " " + newLeft+ " " +right);
		merge(array,left, newRight, newLeft, right);

		printArray(array);

	}

	private static void merge( int[] array, int left, int newRight, int newLeft, int right)
{
	int size = right- left+ 1;
	int[] temp = new int[size];
	
 	int j=0;
	int k=0;
	int i;
	for(i= 0; i<temp.length && j+left<=newRight && k+newLeft<=right; i++)
	{

		if(array[left+j] < array[newLeft+k]){
 			temp[i] = array[left+ j++];
		}
		else{
 			temp[i] = array[newLeft+ k++];
		}
	}

 	while(left + j <= newRight)
	{
		temp[i++] = array[left + j++];
	}
	while(newLeft + k <= right)
	{
		temp[i++] = array[newLeft + k++];
	}
	for(i =0; i<temp.length; i++)
		array[left + i] = temp[i];
} 
}
