package tic_tac_toe;

public class BoardChecker {
    private static final char PLAYER_SYMBOL = 'X';
    private static final char COMPUTER_SYMBOL = 'O';

    private BoardChecker() {
        throw new AssertionError("Utility class, should not be instantiated.");
    }

    public static boolean isBoardFull(char[] board) {
        for (char box : board) {
            if (box != PLAYER_SYMBOL && box != COMPUTER_SYMBOL) {
                return false;
            }
        }
        return true;
    }

    public static boolean checkWin(char[] board, char symbol) {
        return checkRows(board, symbol) || checkColumns(board, symbol) || checkDiagonals(board, symbol);
    }

    private static boolean checkRows(char[] board, char symbol) {
        return (board[0] == symbol && board[1] == symbol && board[2] == symbol)
                || (board[3] == symbol && board[4] == symbol && board[5] == symbol)
                || (board[6] == symbol && board[7] == symbol && board[8] == symbol);
    }

    private static boolean checkColumns(char[] board, char symbol) {
        return (board[0] == symbol && board[3] == symbol && board[6] == symbol)
                || (board[1] == symbol && board[4] == symbol && board[7] == symbol)
                || (board[2] == symbol && board[5] == symbol && board[8] == symbol);
    }

    private static boolean checkDiagonals(char[] board, char symbol) {
        return (board[0] == symbol && board[4] == symbol && board[8] == symbol)
                || (board[2] == symbol && board[4] == symbol && board[6] == symbol);
    }
}
