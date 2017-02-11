
public class GameStart {

	private int[] board = new int[24];
	private int aPlayerOutGamePools;
	private int bPlayerOutGamePools;
	private int aPlayerInGamePools;
	private int bPlayerInGamePools;
	private boolean currTurn = true;
	private boolean dama = false;
	GameLogic gameLogic = new GameLogic();
	GameGraphic gameGraphic = new GameGraphic();

	public GameStart() {

		this.aPlayerOutGamePools = 9;
		this.bPlayerOutGamePools = 9;
		this.aPlayerInGamePools = 0;
		this.bPlayerInGamePools = 0;
	}

	void poolPlace(int place) {

		if (board[place] == 0) {
			if (currTurn) {
				board[place] = 1;
				aPlayerOutGamePools--;
				aPlayerInGamePools++;
				Game.game.gameGraphic.rightPanel.damaLabelOne
						.setText(" Red    pools to place:" + aPlayerOutGamePools + "  ");
				Game.game.gameGraphic.rightPanel.damaLabelTwo
						.setText(" Black pools to place:" + bPlayerOutGamePools + "  ");

				if (gameLogic.checkForDama(place)) {
					dama = true;
					Game.game.gameGraphic.rightPanel.damaLabelOne.setText("                     DAMA!");
					Game.game.gameGraphic.rightPanel.damaLabelTwo.setText("            Remove a pool!   ");
					gameGraphic.jFrame.repaint();
					return;
				}
				currTurn = false;
				gameGraphic.jFrame.repaint();
			} else {
				board[place] = 2;
				bPlayerOutGamePools--;
				bPlayerInGamePools++;
				Game.game.gameGraphic.rightPanel.damaLabelOne
						.setText(" Red    pools to place:" + aPlayerOutGamePools + "  ");
				Game.game.gameGraphic.rightPanel.damaLabelTwo
						.setText(" Black pools to place:" + bPlayerOutGamePools + "  ");

				if (this.gameLogic.checkForDama(place)) {
					dama = true;
					Game.game.gameGraphic.rightPanel.damaLabelOne.setText("       DAMA!");
					Game.game.gameGraphic.rightPanel.damaLabelTwo.setText("Remove a pool!   ");
					gameGraphic.jFrame.repaint();
					return;
				}
				currTurn = true;
				gameGraphic.jFrame.repaint();
			}
		} else {
			Game.game.gameGraphic.rightPanel.damaLabelOne.setText("This place is full");
		}
		this.showWichTurnIs();
	}

	void showWichTurnIs() {
		
		if (!this.currTurn) {
			Game.game.gameGraphic.rightPanel.label.setText(gameGraphic.rightPanel.getPlTwoNameString());
			gameGraphic.jFrame.repaint();
		} else {
			Game.game.gameGraphic.rightPanel.label.setText(gameGraphic.rightPanel.getPlOneNameString());
			gameGraphic.jFrame.repaint();
		}
	}

	boolean move(int place, int toPlace) {
		
		if (currTurn) {
			Game.game.gameGraphic.rightPanel.label.setText(gameGraphic.rightPanel.getPlTwoNameString());
			gameGraphic.jFrame.repaint();
		} else {
			Game.game.gameGraphic.rightPanel.label.setText(gameGraphic.rightPanel.getPlOneNameString());
			gameGraphic.jFrame.repaint();
		}

		if ((currTurn && board[place] == 1 && board[place] != 0)
				|| !currTurn && board[place] == 2 && board[place] != 0) {
			if (gameLogic.movePool(place, toPlace)) {
				gameGraphic.jFrame.repaint();
				if (this.gameLogic.checkForDama(toPlace)) {
					dama = true;
					Game.game.gameGraphic.rightPanel.damaLabelOne.setText("       DAMA!");
					Game.game.gameGraphic.rightPanel.damaLabelTwo.setText("Remove a pool!   ");
					return true;
				}
				this.currTurn = !this.currTurn;
				return true;
			}
		} else {
			Game.game.gameGraphic.rightPanel.damaLabelOne.setText(" You can move ");
			Game.game.gameGraphic.rightPanel.damaLabelTwo.setText(" only your pools! ");
		}
		if (currTurn) {
			Game.game.gameGraphic.rightPanel.label.setText(gameGraphic.rightPanel.getPlOneNameString());
			gameGraphic.jFrame.repaint();
		} else {
			Game.game.gameGraphic.rightPanel.label.setText(gameGraphic.rightPanel.getPlTwoNameString());
			gameGraphic.jFrame.repaint();
		}
		return false;
	}

	public int[] getBoard() {
		return board;
	}

	public void setBoard(int[] board) {
		this.board = board;
	}

	public int getaPlayerOutGamePools() {
		return aPlayerOutGamePools;
	}

	public void setaPlayerOutGamePools(int aPlayerOutGamePools) {
		this.aPlayerOutGamePools = aPlayerOutGamePools;
	}

	public int getbPlayerOutGamePools() {
		return bPlayerOutGamePools;
	}

	public void setbPlayerOutGamePools(int bPlayerOutGamePools) {
		this.bPlayerOutGamePools = bPlayerOutGamePools;
	}

	public boolean isCurrTurn() {
		return currTurn;
	}

	public void setCurrTurn(boolean currTurn) {
		this.currTurn = currTurn;
	}

	public int getaPlayerInGamePools() {
		return aPlayerInGamePools;
	}

	public void setaPlayerInGamePools(int aPlayerInGamePools) {
		this.aPlayerInGamePools = aPlayerInGamePools;
	}

	public int getbPlayerInGamePools() {
		return bPlayerInGamePools;
	}

	public void setbPlayerInGamePools(int bPlayerInGamePools) {
		this.bPlayerInGamePools = bPlayerInGamePools;
	}

	public boolean isDama() {
		return dama;
	}

	public void setDama(boolean dama) {
		this.dama = dama;
	}
	
	
	
}
