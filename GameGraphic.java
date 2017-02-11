import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class GameGraphic extends JPanel {

	Font font = new Font("Verdana", Font.BOLD, 12);
	JFrame jFrame = new JFrame("Dama");

	RightPanel rightPanel = new RightPanel();
	Circles[] circles = new Circles[24];
	private static final int WIDE = 970;
	private static final int HIGH = 830;
	int initPos = -1;

	public GameGraphic() {
		this.circleMassive();
		jFrame.setSize(WIDE, HIGH);
		jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jFrame.add(rightPanel, BorderLayout.EAST);
		jFrame.add(this, BorderLayout.CENTER);
		jFrame.setResizable(false);
		jFrame.addMouseListener(new MouseHandler());
		jFrame.setVisible(true);
		jFrame.setLocation(400, 200);

	}

	private class MouseHandler extends MouseAdapter {
		@Override
		public void mousePressed(MouseEvent e) {

			Game.game.gameGraphic.rightPanel.damaLabelOne.setText(" ");
			Game.game.gameGraphic.rightPanel.damaLabelTwo.setText(" ");

			Point mousePt = e.getPoint();

			// Placing pools
			if (Game.game.getaPlayerOutGamePools() > 0 || Game.game.getbPlayerOutGamePools() > 0) {
				for (int i = 0; i < 24; i++) {
					if (circles[i].contains(mousePt)) {
						if (Game.game.isDama()) {
							if (Game.game.gameLogic.dama(i)) {
								Game.game.setDama(false);
								jFrame.repaint();
							}
							return;
						}
						Game.game.poolPlace(i);
					}
				}
				return;
			}

			// moving pools
			for (int i = 0; i < 24; i++) {
				if (circles[i].contains(mousePt)) {
					if (Game.game.isDama()) {
						if (Game.game.gameLogic.dama(i)) {
							Game.game.setDama(false);
							jFrame.repaint();
						}
						return;
					}
					if (initPos != -1) {
						Game.game.move(initPos, i);
						circles[i].selected = false;
						initPos = -1;
						jFrame.repaint();
						return;
					}
					circles[i].selected = true;
					jFrame.repaint();
					initPos = i;
				}
			}
		}
	}

	private class Circles {
		int x, y;
		int width;
		int height;
		private boolean selected = false;
		private Rectangle b = new Rectangle();
		Color color = Color.lightGray;

		public Circles(int x, int y, int width, int hight) {
			this.x = x;
			this.y = y;
			this.width = width;
			this.height = hight;
			setBoundary(b);
		}

		private void setBoundary(Rectangle b) {
			b.setBounds(x, y, 60, 60);
		}

		public boolean contains(Point p) {
			return b.contains(p);
		}
	}

	void circleMassive() {

		// first row
		for (int i = 0, x = 25; i < 3; i++, x += 350) {
			circles[i] = new Circles(x, 25, 50, 50);
		}
		// second row
		for (int i = 3, x = 125; i < 6; i++, x += 250) {
			circles[i] = new Circles(x, 125, 50, 50);
		}
		// third row
		for (int i = 6, x = 225; i < 9; i++, x += 150) {
			circles[i] = new Circles(x, 225, 50, 50);
		}
		// fourth row
		for (int i = 9, x = 25; i < 12; i++, x += 100) {
			circles[i] = new Circles(x, 375, 50, 50);
		}
		for (int i = 12, x = 525; i < 15; i++, x += 100) {
			circles[i] = new Circles(x, 375, 50, 50);
		}
		// fifth row
		for (int i = 15, x = 225; i < 18; i++, x += 150) {
			circles[i] = new Circles(x, 525, 50, 50);
		}
		for (int i = 15, x = 225; i < 18; i++, x += 150) {
			circles[i] = new Circles(x, 525, 50, 50);
		}
		// Sixth row
		for (int i = 18, x = 125; i < 21; i++, x += 250) {
			circles[i] = new Circles(x, 625, 50, 50);
		}
		// seventh row
		for (int i = 21, x = 25; i < 24; i++, x += 350) {
			circles[i] = new Circles(x, 725, 50, 50);
		}
	}

	protected void paintComponent(Graphics g) {
		super.paintComponent(g);

		int[] board = Game.game.getBoard();

		g.drawRect(50, 50, 700, 700);
		g.drawRect(150, 150, 500, 500);
		g.drawRect(250, 250, 300, 300);

		g.drawLine(400, 50, 400, 250);
		g.drawLine(400, 550, 400, 750);
		g.drawLine(50, 400, 250, 400);
		g.drawLine(550, 400, 750, 400);

		// Draw circles
		for (int i = 0; i < 24; i++) {
			if (board[i] == 0) {
				circles[i].color = Color.lightGray;
			} else {
				if (board[i] == 1) {
					circles[i].color = Color.red;
				} else {
					circles[i].color = Color.black;
				}
			}
			g.setColor(circles[i].color);
			g.fillOval(circles[i].x, circles[i].y, circles[i].height, circles[i].width);
		}
		// Draw selected circle
		for (int i = 0; i < 24; i++) {
			if (circles[i].selected) {
				g.setColor(circles[i].color);
				g.drawOval(circles[i].x - 15, circles[i].y - 15, circles[i].width + 30, circles[i].height + 30);

			} else {
				g.setColor(Color.lightGray);
				g.drawOval(circles[i].x - 15, circles[i].y - 15, circles[i].width + 30, circles[i].height + 30);

			}
		}

	}

}
