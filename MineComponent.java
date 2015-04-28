import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JFrame;

/**
Combines all of the JPanel components in order to easily draw them to the JFrame
*/
public class MineComponent extends JPanel
{
	public int frameSize;
	
	public MineComponent(MineSweeper mine, JFrame frame)
	{
		super();
		
		MineModel model = new MineModel(mine, frame);
		
		frameSize = model.getBoardSize();
		
		BoardView view = new BoardView(model);
		
		ControlPanel control = new ControlPanel(model);
		
		model.addObserver(view);
		
		setLayout(new BorderLayout());
		
		add(view, BorderLayout.CENTER);
		add(control, BorderLayout.SOUTH);
	}
	
	/**
	Used to set the default frame size when the game starts up
	@return The frame size
	*/
	public int getFrameSize()
	{
		return frameSize * 50;
	}
}
