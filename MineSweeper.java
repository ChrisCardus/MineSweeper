import java.util.Random;

/**
Holds all of the data required for the game
*/
public class MineSweeper
{
	private int boardSize;
	private int mines;
	private int[][] board;
	private int[][] state;
	private Random random;
	private boolean over;
	private int difficulty;
	
	/**
	Constructs a minesweeper object
	*/
	public MineSweeper()
	{
		this.boardSize = 9;
		this.mines = 10;
		
		this.random = new Random();
		this.setupBoard();
		this.difficulty = 0;
		over = true;
	}
	
	/**
	Initialises the game board with the required settings
	*/
	private void setupBoard()
	{
		int x = 0;
		int y = 0;
		
		this.board = new int[boardSize][boardSize];
		this.state = new int[boardSize][boardSize];
		
		for(int i = 0; i < mines; i++)
		{
			x = random.nextInt(boardSize);
			y = random.nextInt(boardSize);
			
			if(board[x][y] != -1)
			{
				board[x][y] = -1;
			}
			else
			{
				board[x][y] = 0;
				i--;
			}
		}
		
		//I felt dirty writing this, but I couldn't think of another way to do it...
		for(int i = 0; i < boardSize; i++)
		{
			for(int j = 0; j < boardSize; j++)
			{
				if(board[i][j] != -1)
				{
					if(i > 0 && j > 0)
					{
						if(board[i-1][j-1] == -1)
						{
							board[i][j]++;
						}
					}
					
					if(j > 0)
					{
						if(board[i][j-1] == -1)
						{
							board[i][j]++;
						}
					}
					
					if(i < (boardSize - 1) && j > 0)
					{
						if(board[i+1][j-1] == -1)
						{
							board[i][j]++;
						}
					}
					
					if(i > 0)
					{
						if(board[i-1][j] == -1)
						{
							board[i][j]++;
						}
					}
					
					if(i < (boardSize - 1))
					{
						if(board[i+1][j] == -1)
						{
							board[i][j]++;
						}
					}
					
					if(i > 0 && j < (boardSize - 1))
					{
						if(board[i-1][j+1] == -1)
						{
							board[i][j]++;
						}
					}
					
					if(j < (boardSize - 1))
					{
						if(board[i][j+1] == -1)
						{
							board[i][j]++;
						}
					}
					
					if(i < (boardSize - 1) && j < (boardSize - 1))
					{
						if(board[i+1][j+1] == -1)
						{
							board[i][j]++;
						}
					}
				}
				state[i][j] = 0;
			}
		}
	}
	
	/**
	Returns the size of the game board
	@return The size of the game board
	*/
	public int getBoardSize()
	{
		return boardSize;
	}
	
	/**
	Returns the game board array for use in the test class
	@return The game board
	*/
	public int[][] getBoard()
	{
		return board;
	}
	
	/**
	Returns whether or not the game is over
	@return Whether or not the game is over
	*/
	public boolean getOver()
	{
		return over;
	}
	
	/**
	Sets whether or not the game is over
	@param over Whether or not the game is over
	*/
	public void setOver(boolean over)
	{
		this.over = over;
	}
	
	/**
	Gets the value stored in a particular index of the 2D array
	@param i The i axis of the array
	@param j The j axis of the array
	*/
	public int getSquare(int i, int j)
	{
		return board[i][j];
	}
	
	/**
	Gets the current state of a particular index of a 2D array
	@param i The i axis of the array
	@param j The j axis of the array
	*/
	public int getState(int i, int j)
	{
		return state[i][j];
	}
	
	/**
	Set the difficulty of the game
	@param difficulty The new difficulty of the game
	*/
	public void setDifficulty(int difficulty)
	{
		this.difficulty = difficulty;
		if(difficulty == 0)
		{
			boardSize = 9;
			mines = 10;
		}
		else if(difficulty == 1)
		{
			boardSize = 16;
			mines = 40;
		}
		else if(difficulty == 2)
		{
			boardSize = 22;
			mines = 99;
		}
	}
	
	/**
	Applies one turn of the game
	@param i The i index of the button which has been pressed
	@param j The j index of the button which has been pressed
	*/
	public void turn(int i, int j)
	{
		if(board[i][j] == -1)
		{
			state[i][j] = -1;
			state = board;
			over = false;
		}
		else if(board[i][j] >= 0)
		{
			state[i][j] = 1;
		}
	}
	
	/**
	Restarts the game and resets the game board
	*/
	public void restartGame()
	{
		this.board = null;
		this.state = null;
		this.setupBoard();
	}
	
	/**
	Reveals all of the mines on the game board
	*/
	public void reveal()
	{
		for(int i = 0; i < boardSize; i++)
		{
			for(int j = 0; j < boardSize; j++)
			{
				if(board[i][j] == -1)
				{
					state[i][j] = -1;
				}
			}
		}
	}
}
