import java.awt.Point;
import java.util.*;

public class GraphTools
{

	public static String bestLine(Point[] graph)
	{
		HashMap<String, Integer> lines = new HashMap<String,Integer>();

		double slope, yInt;
		Integer numOc;
		int maxOc=0;

		String output = null;
		
		StringBuilder temp = new StringBuilder();

		for(int i =0; i < graph.length-1; i++)
		{
			for(int j=i+1; j<graph.length;j++)
			{
				slope = getSlope(graph[i],graph[j]);
				yInt  = getYInt(graph[i], slope);

				temp.append(slope);
				temp.append(" ");
				temp.append(yInt);
				String data = temp.toString();

				temp.setLength(0);

				numOc = lines.get(data);
				if( numOc == null)
				{
					lines.put(data, 1);
					if(maxOc < 1)
					{
						maxOc =1;
						output = data;
					}
				}
				else
				{
					lines.put(data,numOc+1);
					lines.put(data, 1);
					if(maxOc < numOc+1)
					{
						maxOc =numOc+1;
						output = data;
					}
				}
			}
		}

		return output;
	}

	public static double getSlope(Point a, Point b)
	{
		return ((double)a.getY()-b.getY()) / ((double)a.getX()-b.getX());
	}

	public static double getYInt(Point a, double m)
	{
		return ((double) a.getY()) - (m* (double) a.getX());
	}
	
}
