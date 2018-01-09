

public class twos
{
	public static void main(String[] args)
	{
		System.out.println(twos(10000));
	}

	public static int twos(int original)	
	{
		int running = original;
		int x;
		int i = 0;
		int calculatedMax = 0;
		int num2s =0;

		while(running!=0)
		{
			x = running%10;
			if(x == 2)
			{
				//We know the numbers leading up to here contribute a single 2

				num2s += (original %((int) Math.pow(10,i)))+ 1;

				//We also have to add the 2s contributing the 1/0 place

				num2s += 2*(calculatedMax);
			}
			else if(x >2)
			{
				num2s += (int) Math.pow(10,i);
				num2s += (x)*(calculatedMax);
			}

			else
				num2s += x*(calculatedMax);

			System.out.println("2s: " + num2s);
			System.out.println("x:  " + x);
			System.out.println("calcMax: " + calculatedMax);

			calculatedMax = 10*(calculatedMax);
			calculatedMax += (int) Math.pow(10,i);
			i++;
			running/=10;

			


		}
		return num2s;
	}

}

// 30
// 2,12,22
// 10
// 