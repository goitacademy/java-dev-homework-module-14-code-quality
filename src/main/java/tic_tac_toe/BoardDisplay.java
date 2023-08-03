package tic_tac_toe;

import java.util.logging.Logger;

public class BoardDisplay {
    private static final Logger logger = Logger.getLogger(TicTacToe.class.getName());

    private BoardDisplay() {
        throw new AssertionError("Utility class, should not be instantiated.");
    }

    public static void displayBoard(char[] board) {
        String str = String.format("""
                        %s | %s | %s
                        ------------
                        %s | %s | %s
                        ------------
                        %s | %s | %s""",
                board[0], board[1], board[2], board[3], board[4], board[5], board[6], board[7], board[8]);
        logger.info(str);
    }
}
