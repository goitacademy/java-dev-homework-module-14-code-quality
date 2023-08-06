package tictactoe;

import java.util.logging.Logger;

class GameBoard {
    private final char[] box;
    public static final char PLAYER_SYMBOL = 'X';
    public static final char COMPUTER_SYMBOL = 'O';
    private static final int BOARD_SIDE = 9;
    private static final char EMPTY_CELL = ' ';
    private static final byte PLAYER_WINS = 1;
    private static final byte COMPUTER_WINS = 2;
    public static final byte DRAW = 3;
    private static final Logger LOGGER = Logger.getLogger(GameBoard.class.getName());

    GameBoard() {
        this.box = new char[]{'1', '2', '3', '4', '5', '6', '7', '8', '9'};
    }

    void displayBoard() {
        String boardString = "\n\n " + box[0] + " | " + box[1] + " | " + box[2] + " "
                + "\n-----------"
                + "\n " + box[3] + " | " + box[4] + " | " + box[5] + " "
                + "\n-----------"
                + "\n " + box[6] + " | " + box[7] + " | " + box[8] + " \n";

        LOGGER.info(boardString);
    }

    void displayStartMessage() {
        LOGGER.info("Enter box number to select. Enjoy!\n");
    }


    void resetBoard() {
        for (int i = 0; i < BOARD_SIDE; i++) {
            box[i] = EMPTY_CELL;
        }
    }

    boolean isBoxEmpty(final int boxNumber) {
        return box[boxNumber - 1] == EMPTY_CELL;
    }


    boolean checkWin(final char symbol) {
        int[][] winConditions = {
                {0, 1, 2}, {3, 4, 5}, {6, 7, 8},
                {0, 3, 6}, {1, 4, 7}, {2, 5, 8},
                {0, 4, 8}, {2, 4, 6}
        };

        for (int[] condition : winConditions) {
            if (box[condition[0]] == symbol && box[condition[1]] == symbol && box[condition[2]] == symbol) {
                return true;
            }
        }

        return false;
    }

    boolean isBoardFull() {
        for (int i = 0; i < BOARD_SIDE; i++) {
            if (box[i] != PLAYER_SYMBOL && box[i] != COMPUTER_SYMBOL) {
                return false;
            }
        }
        return true;
    }

    void makeMove(final int position, final char symbol) {
        if (isBoxEmpty(position)) {
            box[position - 1] = symbol;
        } else {
            LOGGER.info("That one is already in use. Enter another.");
        }
    }

    byte isWinner() {
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

    String getGameResultMessage(final byte winner) {
        return switch (winner) {
            case PLAYER_WINS -> "You won the game!";
            case COMPUTER_WINS -> "You lost the game!";
            case DRAW -> "It's a draw!";
            default -> "";
        };
    }

    void announceGameResult(final byte winner) {
        if (winner != 0) {
            String message = String.format("%s%nCreated by Shreyas Saha. Thanks for playing!", getGameResultMessage(winner));
            LOGGER.info(message);
        }
    }
}


