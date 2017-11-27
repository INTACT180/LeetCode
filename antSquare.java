import java.util.Scanner;



class antSquare
{

	private static boolean[][] board;
	private static int rows, cols;
	private static int[] movesx = {0,1};
	private static int[] movesy = {-1,0};

	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		int num = in.nextInt();
		
		cols = num/2 +1;


		if(num%2 == 1)
			rows = num/2 +2;
		else
			rows = cols;

		board = new boolean[rows][cols];

		boolean start = true;
		boolean current;
		for(int i = 0; i< rows; i++)
		{
			current = start;
			for(int j=0; j<cols; j++)
			{
				board[i][j] = current;
				if(current)
					System.out.print("O");
				else
					System.out.print("X");
				System.out.print("\t");
				current = !current;
			}
			System.out.print("\n");
			start = !start;
		}

		System.out.print("\n");
		System.out.print("\n");

		int x =0;
		int y =0;

		for(int i =0; i< num; i++)
		{
			board[x][y] = !board[x][y];

			if(i%2 == 0)
				x++;
			else
				y++;
		}
		board[x][y] = !board[x][y];		

		for(int i = 0; i< rows; i++)
		{
			for(int j=0; j<cols; j++)
			{
				if(board[i][j])
					System.out.print("O");
				else
					System.out.print("X");
				System.out.print("\t");
			}
			System.out.print("\n");
		}

	}

}