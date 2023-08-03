import java.util.Random;
import java.util.Scanner;
import java.util.logging.Logger;

class Board {
    private static final char PLAYER_X = 'X';
    private static final char PLAYER_O = 'O';
    private static final int DRAW = 3;
    private static final Random random = new Random();
    private static final int[][] WINNING_CONDITIONS = {
            {0, 1, 2}, {3, 4, 5}, {6, 7, 8}, // Rows
            {0, 3, 6}, {1, 4, 7}, {2, 5, 8}, // Columns
            {0, 4, 8}, {2, 4, 6} // Diagonals
    };

    private final char[] cells;
    private int winner;
    private final Logger logger;

    public Board(Logger logger) {
        cells = new char[]{'1', '2', '3', '4', '5', '6', '7', '8', '9'};
        winner = 0;
        this.logger = logger;
    }


    public void play() {
        while (winner == 0) {
            printBoard();
            int input = getPlayerInput();
            if (input != -1) {
                cells[input - 1] = PLAYER_X;
                winner = checkWinner(PLAYER_X);
                if (winner == 0) {
                    int move = getRandomMove();
                    cells[move] = PLAYER_O;
                    winner = checkWinner(PLAYER_O);
                }
            } else {
                logger.warning("Invalid input. Enter again.");
            }
        }
        if (winner == 1) {
            logger.info("You won the game!");
        } else if (winner == 2) {
            logger.info("You lost the game!");
        } else if (winner == DRAW) {
            logger.info("It's a draw!");
        }
        printBoard();
    }

    public void printBoard() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 9; i += 3) {
            sb.append(String.format(" %c | %c | %c ", cells[i], cells[i + 1], cells[i + 2]));
            if (i < 6) {
                sb.append(System.lineSeparator())
                        .append("---+---+---")
                        .append(System.lineSeparator());
            }
        }
        String currentBoard = sb.toString();
        logger.info(currentBoard);
    }

    public int getPlayerInput() {
        Scanner scan = new Scanner(System.in);
        int input = scan.nextInt();

        if (input < 1 || input > 9) {
            return -1;
        }
        if (cells[input - 1] == PLAYER_X || cells[input - 1] == PLAYER_O) {
            return -1;
        }

        return input;
    }

    public int getRandomMove() {
        int availableMoves = 9;
        for (char cell : cells) {
            if (cell == PLAYER_X || cell == PLAYER_O) {
                availableMoves--;
            }
        }

        int randomIndex = random.nextInt(availableMoves);
        for (int i = 0; i < 9; i++) {
            if (cells[i] != PLAYER_X && cells[i] != PLAYER_O) {
                if (randomIndex == 0) {
                    return i;
                }
                randomIndex--;
            }
        }
        return -1;
    }

    public int checkWinner(char player) {
        for (int[] condition : WINNING_CONDITIONS) {
            if (cells[condition[0]] == player && cells[condition[1]] == player && cells[condition[2]] == player) {
                return (player == PLAYER_X) ? 1 : 2;
            }
        }

        for (char cell : cells) {
            if (cell != PLAYER_X && cell != PLAYER_O) {
                return 0;
            }
        }
        return DRAW;
    }
}