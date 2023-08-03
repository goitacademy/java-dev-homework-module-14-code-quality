package tic_tac_toe;

import java.util.Scanner;
import java.util.logging.Logger;

public class TicTacToe {
    private static final char PLAYER_SYMBOL = 'X';
    private static final char COMPUTER_SYMBOL = 'O';
    private static final int BOARD_SIZE = 9;
    private static final Logger logger = Logger.getLogger(TicTacToe.class.getName());
    private final Scanner scanner;
    private final char[] board;
    private byte winner;

    public TicTacToe() {
        scanner = new Scanner(System.in);
        board = new char[BOARD_SIZE];
        winner = 0;
        initBoard();
    }

    private void initBoard() {
        for (int i = 0; i < BOARD_SIZE; i++) {
            board[i] = Character.forDigit(i + 1, 10);
        }
    }

    public void playGame() {
        logger.info("Enter box number to select. Enjoy!\n");
        BoardDisplay.displayBoard(board);

        while (winner == 0) {
            if (BoardChecker.isBoardFull(board)) {
                winner = 3;
            } else {
                playerMove();
                if (BoardChecker.checkWin(board, PLAYER_SYMBOL)) {
                    winner = 1;
                } else {
                    computerMove();
                    if (BoardChecker.checkWin(board, COMPUTER_SYMBOL)) {
                        winner = 2;
                    }
                }
            }
            BoardDisplay.displayBoard(board);
        }

        printResult();
        scanner.close();
    }

    private void playerMove() {
        if (winner != 0) {
            return;
        }

        while (true) {
            byte input = scanner.nextByte();
            if (input >= 1 && input <= BOARD_SIZE && board[input - 1] != PLAYER_SYMBOL && board[input - 1] != COMPUTER_SYMBOL) {
                board[input - 1] = PLAYER_SYMBOL;
                break;
            } else {
                logger.info("Invalid input. Enter again.");
            }
        }
    }

    private void computerMove() {
        if (winner != 0) {
            return;
        }

        byte rand;
        while (true) {
            rand = (byte) (Math.random() * BOARD_SIZE);
            if (board[rand] != PLAYER_SYMBOL && board[rand] != COMPUTER_SYMBOL) {
                board[rand] = COMPUTER_SYMBOL;
                break;
            }
        }
    }

    private void printResult() {
        if (winner == 1) {
            logger.info("You won the game!\nThanks for playing!");
        } else if (winner == 2) {
            logger.info("You lost the game!\nThanks for playing!");
        } else if (winner == 3) {
            logger.info("It's a draw!\nThanks for playing!");
        }
    }
}