import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import java.awt.event.*;

/**
Holds a JPanel of all of the controls needed for the game
*/
public class ControlPanel extends JPanel
{
	/**
	Constructs a JPanel which holds the controls to exit and reset the game, reveal the mines and set the difficulty
	@param model The model that the controls effect
	*/
	public ControlPanel(final MineModel model)
	{		
		String[] difficulty = {"Easy", "Medium", "Hard"};
		final JComboBox<String> difficultySelect = new JComboBox<String>(difficulty);
		difficultySelect.setSelectedIndex(0);
		difficultySelect.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent e)
				{
					model.setDifficulty(difficultySelect.getSelectedIndex());
				}
			});
			
		JButton exit = new JButton("Exit");
		JButton restart = new JButton("Restart");
		JButton reveal = new JButton("Reveal the mines");
		
		exit.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent e)
				{
					System.exit(0);
				}
			});
			
		restart.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent e)
				{
					model.restartGame();
				}
			});
			
		reveal.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent e)
				{
					model.reveal();
				}
			});
			
		add(difficultySelect);
		add(exit);
		add(restart);
		add(reveal);
	}
}
