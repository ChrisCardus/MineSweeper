import java.util.Observable;
import javax.swing.JFrame;

/**
Creates a model that interacts with the MineSweeper class and updates all relevent observers
*/
public class MineModel extends Observable
{
	private MineSweeper mine;
	private JFrame frame;
	
	/**
	Constructs a model
	@param mine The Minesweeper Class
	@param frame The JFrame which everything is drawn upon
	*/
	public MineModel(MineSweeper mine, JFrame frame)
	{
		super();
		this.mine = mine;
		this.frame = frame;
	}
	
	/**
	Constructs a model for use by the test class
	@param mine The MineSweeper class
	*/
	public MineModel(MineSweeper mine)
	{
		super();
		this.mine = mine;
	}
	
	/**
	Returns the current boardSize
	@return The board size
	*/
	public int getBoardSize()
	{
		return mine.getBoardSize();
	}
	
	/**
	Returns the entire board array for use by the test class
	@return The board array
	*/
	public int[][] getBoard()
	{
		return mine.getBoard();
	}
	
	/**
	Returns whether or not the game is over
	@return The boolean value of whether or not the game is finished
	*/
	public boolean getOver()
	{
		return mine.getOver();
	}
	
	/**
	Sets whether or not the game is over
	@param over Whether or not the game is over
	*/
	public void setOver(boolean over)
	{
		mine.setOver(over);
	}
	
	/**
	Gets the value stored in a particular index of the 2D array
	@param i The i axis of the array
	@param j The j axis of the array
	*/
	public int getSquare(int i, int j)
	{
		return mine.getSquare(i, j);
	}
	
	/**
	Gets the current state of a particular index of a 2D array
	@param i The i axis of the array
	@param j The j axis of the array
	*/
	public int getState(int i, int j)
	{
		return mine.getState(i, j);
	}
	
	/**
	Set the difficulty of the game
	@param difficulty The new difficulty of the game
	*/
	public void setDifficulty(int difficulty)
	{
		mine.setDifficulty(difficulty);
	}
	
	/**
	Applies one turn of the game
	@param i The i index of the button which has been pressed
	@param j The j index of the button which has been pressed
	*/
	public void turn(int i, int j)
	{
		mine.turn(i, j);
		int restart = 0;
		setChanged();
		notifyObservers(restart);
	}
	
	/**
	Restarts the game and resets the game board
	*/
	public void restartGame()
	{
		mine.restartGame();
		int restart = 1;
		setChanged();
		notifyObservers(restart);
		int frameSize = mine.getBoardSize() * 50;
		frame.setSize(frameSize, frameSize);
	}
	
	/**
	Reveals all of the mines on the game board
	*/
	public void reveal()
	{
		mine.reveal();
		int restart = 0;
		setChanged();
		notifyObservers(restart);
	}
}

