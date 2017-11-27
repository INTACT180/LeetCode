
public class TreeCheck
{
	public static boolean isBalanced ( Node head )
	{
		Queue<Node> q = new Queue<Node>();
		
		if ( node == null )
			return true;

		q.enqueue(head);
		int limit = 1;
		boolean broken = false;


		while( ! q.isEmpty())
		{
			int size = q.size();
			for(int i = 0; i< size; i++)
			{
			Node current = q.pop();
			if(current.left != null) 
				q.enqueue(current.left);
			if(current.right != null) 
				q.enqueue(current.right);
			}
			
			if( size < limit )
			{
				if(broken)
					return false;
				broken = true;
			}
		}

		return true;
	}
}
