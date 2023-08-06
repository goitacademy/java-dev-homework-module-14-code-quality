package tictactoe;

import java.util.Scanner;
import java.util.logging.Logger;

public class Player {
    private char symbol;
    private Scanner scanner;

    private static final Logger logger = Logger.getLogger(Player.class.getName());
    private static final int MIN_INPUT = 1;
    private static final int MAX_INPUT = 9;

    public Player(char symbol) {
        this.symbol = symbol;
        this.scanner = new Scanner(System.in);
    }

    public char getSymbol() {
        return symbol;
    }

    public byte getPlayerInput(GameBoard gameBoard) {
        while (true) {
            try {
                byte input = scanner.nextByte();
                if (input >= MIN_INPUT && input <= MAX_INPUT) {
                    if (gameBoard.isBoxEmpty(input)) {
                        return input;
                    } else logger.info("That one is already in use. Enter another.");
                } else {
                    logger.info("Invalid input. Enter a number between 1 and 9.");
                }
            } catch (java.util.InputMismatchException e) {
                logger.info("Invalid input. Please enter a valid number.");
                scanner.nextLine();
            }
        }
    }

    public void closeScanner() {
        scanner.close();
    }
}
