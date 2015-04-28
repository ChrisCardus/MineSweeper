import javax.swing.JFrame;

/**
Creates the JFrame on which the components of the game can then be added too
*/
public class MineSweeperGUI extends JFrame
{
	public static void main(String[] args)
	{
		MineSweeper mine = new MineSweeper();
		
		JFrame frame = new JFrame();
		
		MineComponent mineComp = new MineComponent(mine, frame);
		
		
		int frameSize = mineComp.getFrameSize();

		frame.setTitle("Minesweeper");
		frame.setSize(frameSize, frameSize);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(mineComp);
		frame.setVisible(true);
	}
}
