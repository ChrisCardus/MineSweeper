import javax.swing.JButton;
import javax.swing.JPanel;
import java.util.Observer;
import java.util.Observable;
import java.awt.GridLayout;
import java.awt.Font;
import java.awt.Color;
import javax.swing.ImageIcon;
import java.net.URL;  
import java.awt.Dimension;
import java.awt.Image;

/**
Creates the board and holds all of the JButtons and their listeners
*/
public class BoardView extends JPanel implements Observer
{
	private MineModel model;
	private JButton[][] cell;
	private int boardSize;
	
	/**
	Constructs an object of type BoardView
	@param model The model to be observed
	*/
	public BoardView(MineModel model)
	{
		super();
		this.model = model;
		
		setupBoard();
	}
	
	/**
	Configures the default state of the game board
	*/
	private void setupBoard()
	{
		boardSize = model.getBoardSize();
		
		System.out.println(cell);
		
		cell = new JButton[boardSize][boardSize];
		
		System.out.println(cell.length);
		
		setLayout(new GridLayout(boardSize, boardSize));
		
		for(int i = 0; i < cell.length; i++)
		{
			for(int j = 0; j < cell.length; j++)
			{
				cell[i][j] = new JButton("");
				cell[i][j].setFont(new Font("Arial", Font.BOLD, 20));
				cell[i][j].addActionListener(new SquareListener(model, i, j));
				add(cell[i][j]);
			}
		}
	}
	
	/**
	Updates the game board based on what the player has done
	@param arg Whether or not the game has been reset
	*/
	public void update(Observable o, Object arg)
	{
		Color x = new Color(124, 252, 98); //Green
		Color y = new Color(255, 69, 69); //Red

		//ImageIcon mine = new ImageIcon(((new ImageIcon("Mine.png")).getImage()).getScaledInstance(30, 30, java.awt.Image.SCALE_SMOOTH));
		
		if(arg.equals(1))
		{
			int iteration = cell.length;
			for(int i = 0; i < iteration; i++)
			{
				for(int j = 0; j < iteration; j++)
				{
					remove(cell[i][j]);
				}
			}
			cell = null;
			setupBoard();
			model.setOver(true);
		}
		
		int width = getWidth() / (cell.length + 5);
		int height = getHeight() / (cell.length + 5);
		
		ImageIcon mine = new ImageIcon("Mine.png");
		Image img = mine.getImage();
		Image scale = img.getScaledInstance(width, height, java.awt.Image.SCALE_SMOOTH);
		mine = new ImageIcon(scale);
		
		for(int i = 0; i < cell.length; i++)
		{
			for(int j = 0; j < cell.length; j++)
			{
				if(model.getState(i, j) == -1)
				{
					cell[i][j].setIcon(mine);
					cell[i][j].setEnabled(false);
					cell[i][j].setBackground(y);
				}
				else if(model.getState(i, j) >= 1)
				{
					String text = String.valueOf(model.getSquare(i, j));
					cell[i][j].setText(text);
					cell[i][j].setEnabled(false);
					cell[i][j].setBackground(x);
				}
				else
				{
					cell[i][j].setText("");
					cell[i][j].setEnabled(model.getOver());
					cell[i][j].setBackground(null);
				}
			}
		}
		revalidate();
	}
}
