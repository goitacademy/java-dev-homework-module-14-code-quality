package tic_tac_toe;

import java.util.Scanner;

public class TicTacToe {
    private static final char PLAYER_SYMBOL = 'X';
    private static final char COMPUTER_SYMBOL = 'O';
    private static final int BOARD_SIZE = 9;
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
        System.out.println("Enter box number to select. Enjoy!\n");
        displayBoard();

        while (winner == 0) {
            if (isBoardFull()) {
                winner = 3;
            } else {
                playerMove();
                if (checkWin(PLAYER_SYMBOL)) {
                    winner = 1;
                } else {
                    computerMove();
                    if (checkWin(COMPUTER_SYMBOL)) {
                        winner = 2;
                    }
                }
            }
            displayBoard();
        }

        printResult();
    }

    private void displayBoard() {
        System.out.println("\n\n " + board[0] + " | " + board[1] + " | " + board[2] + " ");
        System.out.println("-----------");
        System.out.println(" " + board[3] + " | " + board[4] + " | " + board[5] + " ");
        System.out.println("-----------");
        System.out.println(" " + board[6] + " | " + board[7] + " | " + board[8] + " \n");
    }

    private void playerMove() {
        while (true) {
            byte input = scanner.nextByte();
            if (input >= 1 && input <= BOARD_SIZE && board[input - 1] != PLAYER_SYMBOL && board[input - 1] != COMPUTER_SYMBOL) {
                board[input - 1] = PLAYER_SYMBOL;
                break;
            } else {
                System.out.println("Invalid input. Enter again.");
            }
        }
    }

    private boolean isBoardFull() {
        for (char box : board) {
            if (box != PLAYER_SYMBOL && box != COMPUTER_SYMBOL) {
                return false;
            }
        }
        return true;
    }

    private boolean checkWin(char symbol) {
        return checkRows(symbol) || checkColumns(symbol) || checkDiagonals(symbol);
    }

    private boolean checkRows(char symbol) {
        return (board[0] == symbol && board[1] == symbol && board[2] == symbol)
                || (board[3] == symbol && board[4] == symbol && board[5] == symbol)
                || (board[6] == symbol && board[7] == symbol && board[8] == symbol);
    }

    private boolean checkColumns(char symbol) {
        return (board[0] == symbol && board[3] == symbol && board[6] == symbol)
                || (board[1] == symbol && board[4] == symbol && board[7] == symbol)
                || (board[2] == symbol && board[5] == symbol && board[8] == symbol);
    }

    private boolean checkDiagonals(char symbol) {
        return (board[0] == symbol && board[4] == symbol && board[8] == symbol)
                || (board[2] == symbol && board[4] == symbol && board[6] == symbol);
    }

    private void computerMove() {
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
            System.out.println("You won the game!\nThanks for playing!");
        } else if (winner == 2) {
            System.out.println("You lost the game!\nThanks for playing!");
        } else if (winner == 3) {
            System.out.println("It's a draw!\nThanks for playing!");
        }
    }
}