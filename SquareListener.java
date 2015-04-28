import java.awt.event.*;

/**
Creates a listener for the game board that responds to users interaction with the game
*/
public class SquareListener implements ActionListener
{
	private MineModel model;
	private int row;
	private int column;
	
	/**
	Constructs a listener for the game board
	@param model The model to be observed
	@param row The row of the button which has been pressed
	@param column The column of the button which has been pressed
	*/
	public SquareListener(MineModel model, int row, int column)
	{
		this.model = model;
		this.row = row;
		this.column = column;
	}
	
	/**
	Calls the turn method when a button on the game board is pressed
	@param e The event that was performed
	*/
	public void actionPerformed(ActionEvent e)
	{
		model.turn(row, column);
	}
}
