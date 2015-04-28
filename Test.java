/**
Tests the MineSweeper and MineModel classes to ensure they initialise correctly
*/
public class Test
{
	public static void main(String[] args)
	{
		MineSweeper mine = new MineSweeper();
		MineModel model = new MineModel(mine);
		
		int[][] board = model.getBoard();
		
		for(int i = 0; i < board.length; i++)
		{
			for(int j = 0; j < board.length; j++)
			{
				System.out.print(board[i][j] + ", ");
			}
			
			System.out.println(" ");
		}
	}
}
