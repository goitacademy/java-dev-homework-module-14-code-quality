package tictactoe;

import java.util.logging.Logger;

public class GameBoard {
    private char[] box;
    public static final char PLAYER_SYMBOL = 'X';
    public static final char COMPUTER_SYMBOL = 'O';
    private static final char EMPTY_CELL = ' ';
    private static final byte PLAYER_WINS = 1;
    private static final byte COMPUTER_WINS = 2;
    private static final byte DRAW = 3;
    private static final Logger logger = Logger.getLogger(GameBoard.class.getName());

    public GameBoard() {
        this.box = new char[]{'1', '2', '3', '4', '5', '6', '7', '8', '9'};
    }

    public void displayBoard() {
        String boardString = "\n\n " + box[0] + " | " + box[1] + " | " + box[2] + " "
                + "\n-----------"
                + "\n " + box[3] + " | " + box[4] + " | " + box[5] + " "
                + "\n-----------"
                + "\n " + box[6] + " | " + box[7] + " | " + box[8] + " \n";

        logger.info(boardString);
    }

    public void displayStartMessage() {
        logger.info("Enter box number to select. Enjoy!\n");
    }


    public void resetBoard() {
        for (int i = 0; i < 9; i++)
            box[i] = EMPTY_CELL;
    }

    public boolean isBoxEmpty(int boxNumber) {
        return box[boxNumber - 1] == EMPTY_CELL && boxNumber >= 1 && boxNumber <= 9;
    }


    public boolean checkWin(char symbol) {
        return (box[0] == symbol && box[1] == symbol && box[2] == symbol) ||
                (box[3] == symbol && box[4] == symbol && box[5] == symbol) ||
                (box[6] == symbol && box[7] == symbol && box[8] == symbol) ||
                (box[0] == symbol && box[3] == symbol && box[6] == symbol) ||
                (box[1] == symbol && box[4] == symbol && box[7] == symbol) ||
                (box[2] == symbol && box[5] == symbol && box[8] == symbol) ||
                (box[0] == symbol && box[4] == symbol && box[8] == symbol) ||
                (box[2] == symbol && box[4] == symbol && box[6] == symbol);
    }

    public boolean isBoardFull() {
        for (int i = 0; i < 9; i++) {
            if (box[i] != PLAYER_SYMBOL && box[i] != COMPUTER_SYMBOL) {
                return false;
            }
        }
        return true;
    }

    public void makeMove(int position, char symbol) {
        if (isBoxEmpty(position)) {
            box[position - 1] = symbol;
        } else {
            logger.info("That one is already in use. Enter another.");
        }
    }

    public byte isWinner() {
        if (checkWin(PLAYER_SYMBOL)) {
            return PLAYER_WINS;
        } else if (checkWin(COMPUTER_SYMBOL)) {
            return COMPUTER_WINS;
        } else if (isBoardFull()) {
            return DRAW;
        } else {
            return 0;
        }
    }

    public String getGameResultMessage(byte winner) {
        switch (winner) {
            case PLAYER_WINS:
                return "You won the game!";
            case COMPUTER_WINS:
                return "You lost the game!";
            case DRAW:
                return "It's a draw!";
            default:
                return "";
        }
    }

    public void announceGameResult(byte winner) {
        if (winner != 0) {
            String message = String.format("%s%nCreated by Shreyas Saha. Thanks for playing!", getGameResultMessage(winner));
            logger.info(message);
        }
    }
}


