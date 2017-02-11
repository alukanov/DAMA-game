import java.awt.Font;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class RightPanel extends JPanel {

	private String plOneNameString = " player ONE ";
	private String plTwoNameString = " player TWO ";
	JLabel playerOneName = new JLabel(plOneNameString);
	JLabel playerTwoName = new JLabel(plTwoNameString);
	private Font font = new Font("Verdana", Font.BOLD, 13);

	JLabel label = new JLabel();
	JLabel nowPlays = new JLabel("Now plays:");
	JButton button = new JButton("BUTTON");
	JLabel damaLabelOne = new JLabel();
	JLabel damaLabelTwo = new JLabel();
	JLabel playerOneLabel = new JLabel(" RED`s player: ");
	JLabel playerTwoLabel = new JLabel(" BLACK`s player: ");

	RightPanel() {
		
		JOptionPane.showMessageDialog(null, "      Welcome to DAMA!", "DAMA", JOptionPane.INFORMATION_MESSAGE);

		plOneNameString = JOptionPane.showInputDialog("Enter player ONE`s name:");
		plTwoNameString = JOptionPane.showInputDialog("Enter player TWO`s name:");

		BoxLayout layout = new BoxLayout(this, BoxLayout.Y_AXIS);
		setLayout(layout);
		this.setFont(font);
		label.setFont(font);
		label.setText(plOneNameString);
		nowPlays.setFont(font);

		playerOneLabel.setFont(font);
		playerOneName = new JLabel(plOneNameString);
		playerOneName.setFont(font);

		playerTwoLabel.setFont(font);
		playerTwoName = new JLabel(plTwoNameString);
		playerTwoName.setFont(font);

		damaLabelOne.setFont(font);
		damaLabelTwo.setFont(font);
		button = new JButton("         NEW GAME         ");

		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				Game.game.setaPlayerInGamePools(0);
				Game.game.setbPlayerInGamePools(0);
				Game.game.setaPlayerOutGamePools(9);
				Game.game.setbPlayerOutGamePools(9);
				int[] board = new int[24];
				Game.game.setBoard(board);
//				Game.game.gameGraphic.rightPanel.
				damaLabelOne.setText("  ");
//				Game.game.gameGraphic.rightPanel.
				damaLabelTwo.setText("  ");
				label.setText(plOneNameString);
				

				Game.game.gameGraphic.repaint();

				// Game.main(null);

			}
		});

		this.add(button);
		this.add(new JLabel(" "));
		this.add(playerOneLabel);
		this.add(playerOneName);
		this.add(new JLabel(" "));
		this.add(playerTwoLabel);
		this.add(playerTwoName);
		this.add(new JLabel(" "));
		this.add(new JLabel(" "));
		this.add(new JLabel(" "));
		this.add(new JLabel(" "));
		this.add(nowPlays);
		this.add(label);
		this.add(new JLabel(" "));
		this.add(new JLabel(" "));
		this.add(new JLabel(" "));
		this.add(new JLabel(" "));
		this.add(new JLabel(" "));
		this.add(new JLabel(" "));
		this.add(new JLabel(" "));
		this.add(new JLabel(" "));
		this.add(new JLabel(" "));
		this.add(damaLabelOne);
		this.add(damaLabelTwo);

	}

	public String getPlOneNameString() {
		return plOneNameString;
	}

	public void setPlOneNameString(String plOneNameString) {
		this.plOneNameString = plOneNameString;
	}

	public String getPlTwoNameString() {
		return plTwoNameString;
	}

	public void setPlTwoNameString(String plTwoNameString) {
		this.plTwoNameString = plTwoNameString;
	}

}
