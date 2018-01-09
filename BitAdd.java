

public class BitAdd
{
	
	public static void main (String[] args)
	{
		System.out.println(add(5,6));

		System.out.println(add(7,1));
		System.out.println(add(7,-1));

	}

	public static int add ( int n, int m)
	{
		if(m == 0) 
			return n;

		int resOr, resAnd, resXOr;

		resOr = n | m;
		resAnd = n & m;
		resXOr = resOr ^ resAnd;

		return add( resXOr, resAnd << 1);

	}
}