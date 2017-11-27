
// Welcome friend to StringOpUtil.c

public class stringCheck
{

	public static void main (String args[])
	{
		String s = "bc";
		String b = "bca";

		System.out.println(s+ " " + b + " " + stringCheck(s,b));

	}

	public static boolean stringCheck(String s1, String s2)
	{
		if( Math.abs(s1.length() - s2.length()) > 1)
			return false;

		int tolerance =1, tracker =0;
		int i=0, j=0;

		while( i < s1.length() && j < s2.length())
		{
			if(s1.charAt(i) == s2.charAt(j))
			{
				i++;
				j++;
			}
			else if(s1.length() > s2.length())
			{
				i++;
				if(++tracker > tolerance)
					return false;
			}
			else if(s2.length() > s1.length())
			{
				j++;
				if(++tracker > tolerance)
					return false;
			}
		}

		System.out.println("here");
		//   faulty end condition.. fixed
		if( (s1.length() + s2.length()) > i+j && tracker >= tolerance)
			return false;

		return true;
		}
			  


}
