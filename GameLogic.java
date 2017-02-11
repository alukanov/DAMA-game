import javax.swing.JOptionPane;

public class GameLogic {
	boolean checkForDama(int pos) {
		int[] board = Game.game.getBoard();

		switch (pos) {
		case 0:
			if (((board[0] == board[1]) && (board[0] == board[2]))
					|| ((board[0] == board[9]) && (board[0] == board[21]))) {
				return true;
			}
			break;
		case 1:
			if (((board[1] == board[0]) && (board[1] == board[2]))
					|| ((board[1] == board[4]) && (board[1] == board[7]))) {
				return true;
			}
			break;
		case 2:
			if (((board[2] == board[0]) && (board[2] == board[1]))
					|| ((board[2] == board[14]) && (board[2] == board[23]))) {
				return true;
			}
			break;
		case 3:
			if (((board[3] == board[4]) && (board[3] == board[5]))
					|| ((board[3] == board[10]) && (board[3] == board[18]))) {
				return true;
			}
			break;
		case 4:
			if (((board[4] == board[3]) && (board[4] == board[5]))
					|| ((board[4] == board[1]) && (board[4] == board[7]))) {
				return true;
			}
			break;
		case 5:
			if (((board[5] == board[4]) && (board[5] == board[3]))
					|| ((board[5] == board[13]) && (board[5] == board[20]))) {
				return true;
			}
			break;
		case 6:
			if (((board[6] == board[7]) && (board[6] == board[8]))
					|| ((board[6] == board[11]) && (board[6] == board[15]))) {
				return true;
			}
			break;
		case 7:
			if (((board[7] == board[1]) && (board[7] == board[4]))
					|| ((board[7] == board[6]) && (board[7] == board[8]))) {
				return true;
			}
			break;
		case 8:
			if (((board[8] == board[7]) && (board[8] == board[6]))
					|| ((board[8] == board[12]) && (board[8] == board[17]))) {
				return true;
			}
			break;
		case 9:
			if (((board[9] == board[10]) && (board[9] == board[11]))
					|| ((board[9] == board[0]) && (board[9] == board[21]))) {
				return true;
			}
			break;
		case 10:
			if (((board[10] == board[3]) && (board[10] == board[18]))
					|| ((board[10] == board[9]) && (board[10] == board[11]))) {
				return true;
			}
			break;
		case 11:
			if (((board[11] == board[10]) && (board[11] == board[9]))
					|| ((board[11] == board[6]) && (board[11] == board[15]))) {
				return true;
			}
			break;
		case 12:
			if (((board[12] == board[13]) && (board[12] == board[14]))
					|| ((board[12] == board[8]) && (board[12] == board[17]))) {
				return true;
			}
			break;
		case 13:
			if (((board[13] == board[12]) && (board[13] == board[14]))
					|| ((board[13] == board[5]) && (board[13] == board[20]))) {
				return true;
			}
			break;
		case 14:
			if (((board[14] == board[2]) && (board[14] == board[23]))
					|| ((board[14] == board[13]) && (board[14] == board[12]))) {
				return true;
			}
			break;
		case 15:
			if (((board[15] == board[16]) && (board[15] == board[17]))
					|| ((board[15] == board[11]) && (board[15] == board[6]))) {
				return true;
			}
			break;
		case 16:
			if (((board[16] == board[15]) && (board[16] == board[17]))
					|| ((board[16] == board[19]) && (board[16] == board[22]))) {
				return true;
			}
			break;
		case 17:
			if (((board[17] == board[16]) && (board[17] == board[15]))
					|| ((board[17] == board[12]) && (board[17] == board[8]))) {
				return true;
			}
			break;
		case 18:
			if (((board[18] == board[10]) && (board[18] == board[3]))
					|| ((board[18] == board[19]) && (board[18] == board[20]))) {
				return true;
			}
			break;
		case 19:
			if (((board[19] == board[18]) && (board[19] == board[20]))
					|| ((board[19] == board[16]) && (board[19] == board[22]))) {
				return true;
			}
			break;
		case 20:
			if (((board[20] == board[19]) && (board[20] == board[18]))
					|| ((board[20] == board[13]) && (board[20] == board[5]))) {
				return true;
			}
			break;
		case 21:
			if (((board[21] == board[9]) && (board[21] == board[0]))
					|| ((board[21] == board[22]) && (board[21] == board[23]))) {
				return true;
			}
			break;
		case 22:
			if (((board[22] == board[21]) && (board[22] == board[23]))
					|| ((board[22] == board[19]) && (board[22] == board[16]))) {
				return true;
			}
			break;
		case 23:
			if (((board[23] == board[22]) && (board[23] == board[21]))
					|| ((board[23] == board[14]) && (board[23] == board[2]))) {
				return true;
			}
			break;

		default:
			break;
		}

		return false;
	}

	boolean dama(int posForRemove) {
		int[] board = Game.game.getBoard();

		if (!checkForDama(posForRemove)) {
			if (Game.game.isCurrTurn() && board[posForRemove] == 2) {
				board[posForRemove] = 0;
				Game.game.setbPlayerInGamePools(Game.game.getbPlayerInGamePools() - 1);
				Game.game.setCurrTurn(!Game.game.isCurrTurn());
				Game.game.gameGraphic.rightPanel.damaLabelOne.setText(" ");
				Game.game.gameGraphic.rightPanel.damaLabelTwo.setText(" ");
				Game.game.showWichTurnIs();
				Game.game.gameLogic.isGameOver();
				return true;
			}
			if (!Game.game.isCurrTurn() && board[posForRemove] == 1) {
				board[posForRemove] = 0;
				Game.game.setaPlayerInGamePools(Game.game.getaPlayerInGamePools() - 1);
				Game.game.setCurrTurn(!Game.game.isCurrTurn());
				Game.game.gameGraphic.rightPanel.damaLabelOne.setText(" ");
				Game.game.gameGraphic.rightPanel.damaLabelTwo.setText(" ");
				// Game.game.printBoard(board);
				Game.game.showWichTurnIs();
				Game.game.gameLogic.isGameOver();
				return true;
			}
		}
		return false;
	}

	// Check for end of the game
	void isGameOver() {
		String winner = "";
		if ((Game.game.getaPlayerOutGamePools() == 0 && Game.game.getbPlayerOutGamePools() == 0)
				&& (Game.game.getaPlayerInGamePools() < 3 || Game.game.getbPlayerInGamePools() < 3)) {

			Game.game.gameGraphic.rightPanel.damaLabelOne.setText(" GAME OVER !");

			if (Game.game.getaPlayerInGamePools() < 3) {
				Game.game.gameGraphic.rightPanel.damaLabelTwo
						.setText(" " + Game.game.gameGraphic.rightPanel.getPlTwoNameString() + " wins!");
				winner = Game.game.gameGraphic.rightPanel.getPlTwoNameString();
			} else {
				Game.game.gameGraphic.rightPanel.damaLabelTwo
						.setText(" " + Game.game.gameGraphic.rightPanel.getPlOneNameString() + " wins!");
				winner = Game.game.gameGraphic.rightPanel.getPlOneNameString();
			}

			JOptionPane.showMessageDialog(null, "GAME OVER! " + winner + " wins!");
			Game.game.gameGraphic.jFrame.repaint();
		}
	}

	boolean movePool(int initPos, int pos) {
		int[] board = Game.game.getBoard();

		if ((initPos >= 0 && initPos < 24) && (board[pos] == 0)) {
			switch (initPos) {
			case 0:
				if ((pos == 1) || (pos == 9)) {
					board[pos] = board[initPos];
					board[initPos] = 0;
					return true;
				}
				break;
			case 1:
				if ((pos == 0) || (pos == 2) || (pos == 4)) {
					board[pos] = board[initPos];
					board[initPos] = 0;
					return true;
				}
				break;
			case 2:
				if ((pos == 1) || (pos == 14)) {
					board[pos] = board[initPos];
					board[initPos] = 0;
					return true;
				}
				break;
			case 3:
				if ((pos == 4) || (pos == 10)) {
					board[pos] = board[initPos];
					board[initPos] = 0;
					return true;
				}
				break;
			case 4:
				if ((pos == 1) || (pos == 3) || (pos == 5) || (pos == 7)) {
					board[pos] = board[initPos];
					board[initPos] = 0;
					return true;
				}
				break;
			case 5:
				if ((pos == 4) || (pos == 13)) {
					board[pos] = board[initPos];
					board[initPos] = 0;
					return true;
				}
				break;
			case 6:
				if ((pos == 7) || (pos == 11)) {
					board[pos] = board[initPos];
					board[initPos] = 0;
					return true;
				}
				break;
			case 7:
				if ((pos == 4) || (pos == 6) || (pos == 8)) {
					board[pos] = board[initPos];
					board[initPos] = 0;
					return true;
				}
				break;
			case 8:
				if ((pos == 7) || (pos == 12)) {
					board[pos] = board[initPos];
					board[initPos] = 0;
					return true;
				}
				break;
			case 9:
				if ((pos == 0) || (pos == 10) || (pos == 21)) {
					board[pos] = board[initPos];
					board[initPos] = 0;
					return true;
				}
				break;
			case 10:
				if ((pos == 3) || (pos == 9) || (pos == 11) || (pos == 18)) {
					board[pos] = board[initPos];
					board[initPos] = 0;
					return true;
				}
				break;
			case 11:
				if ((pos == 6) || (pos == 10) || (pos == 15)) {
					board[pos] = board[initPos];
					board[initPos] = 0;
					return true;
				}
				break;
			case 12:
				if ((pos == 8) || (pos == 13) || (pos == 17)) {
					board[pos] = board[initPos];
					board[initPos] = 0;
					return true;
				}
				break;
			case 13:
				if ((pos == 5) || (pos == 12) || (pos == 14) || (pos == 20)) {
					board[pos] = board[initPos];
					board[initPos] = 0;
					return true;
				}
				break;
			case 14:
				if ((pos == 2) || (pos == 13) || (pos == 23)) {
					board[pos] = board[initPos];
					board[initPos] = 0;
					return true;
				}
				break;
			case 15:
				if ((pos == 11) || (pos == 16)) {
					board[pos] = board[initPos];
					board[initPos] = 0;
					return true;
				}
				break;
			case 16:
				if ((pos == 15) || (pos == 17) || (pos == 19)) {
					board[pos] = board[initPos];
					board[initPos] = 0;
					return true;
				}
				break;
			case 17:
				if ((pos == 12) || (pos == 16)) {
					board[pos] = board[initPos];
					board[initPos] = 0;
					return true;
				}
				break;
			case 18:
				if ((pos == 10) || (pos == 19)) {
					board[pos] = board[initPos];
					board[initPos] = 0;
					return true;
				}
				break;
			case 19:
				if ((pos == 16) || (pos == 18) || (pos == 20) || (pos == 22)) {
					board[pos] = board[initPos];
					board[initPos] = 0;
					return true;
				}
				break;
			case 20:
				if ((pos == 13) || (pos == 19)) {
					board[pos] = board[initPos];
					board[initPos] = 0;
					return true;
				}
				break;
			case 21:
				if ((pos == 9) || (pos == 22)) {
					board[pos] = board[initPos];
					board[initPos] = 0;
					return true;
				}
				break;
			case 22:
				if ((pos == 19) || (pos == 21) || (pos == 23)) {
					board[pos] = board[initPos];
					board[initPos] = 0;
					return true;
				}
				break;
			case 23:
				if ((pos == 14) || (pos == 22)) {
					board[pos] = board[initPos];
					board[initPos] = 0;
					return true;
				}
				break;
			}

		}
		return false;
	}

}
