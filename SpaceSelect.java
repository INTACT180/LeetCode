
import java.util.*;

public class SpaceSelect
{
	

	public static HashSet<String> dic = new HashSet<String>();

	public static void main(String[] args)
	{
		dic.add("looked");
		dic.add("just");
		dic.add("like");
		dic.add("her");
		dic.add("brother");

		Result result = insertSpaces("jesslookedjustlikeherbrothertim");

		System.out.println(result.s.toString());
	}

	public static Result insertSpaces (String input)
	{
		Result[] results = new Result[input.length()];
		split(input, 0, results);

		for(Result r : results)
			System.out.println(r.s + " " + r.validChars);

		return results[0];
	}

	public static int split (String input, int start, Result[] results)
	{
		if(start >= input.length())
			return 0;

		if(results[start] != null)
			return results[start].validChars;

		results[start] = new Result();

		int currentValid=0;
		int bestValid= -1;

		StringBuilder buffer = new StringBuilder();

		for(int i =0; i<input.length() - start; i++)
		{
			buffer.append(input.charAt(i+start));
			System.out.println(buffer + " " + start + " " + i);

			boolean contributesValid = false;

			if(dic.contains(buffer.toString()))
			{
				contributesValid = true;
				currentValid = i +1;
			}
			else
				currentValid =0;

			currentValid += split(input, start+i+1, results);

			if(currentValid > bestValid)
			{
				bestValid = currentValid;

				results[start].validChars = bestValid;
				results[start].contributesValid = contributesValid;
				results[start].s = new StringBuilder(buffer);

				if(start+i+1 < input.length() )
				{
					if(contributesValid == false && true == results[start+i+1].contributesValid)
						results[start].s.append(' ');
					if(results[start+i+1].validChars != bestValid)
						results[start].s.append(' ');
					results[start].s.append(results[start+i+1].s);
				}
				
			}
			
		}

		return bestValid;
	}
}

class Result
{
	public StringBuilder s;
	public int validChars = 0;
	public boolean contributesValid = false;
}