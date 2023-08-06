package tictactoe;

import java.util.Scanner;
import java.util.logging.Logger;

class Player {
    private final char symbol;
    private final Scanner scanner;
    private static final Logger LOGGER = Logger.getLogger(Player.class.getName());
    private static final int MIN_INPUT = 1;
    private static final int MAX_INPUT = 9;

    Player(char symbol) {
        this.symbol = symbol;
        this.scanner = new Scanner(System.in);
    }

    char getSymbol() {
        return symbol;
    }

    byte getPlayerInput(GameBoard gameBoard) {
        while (true) {
            try {
                byte input = scanner.nextByte();
                if (input >= MIN_INPUT && input <= MAX_INPUT) {
                    if (gameBoard.isBoxEmpty(input)) {
                        return input;
                    } else {
                        LOGGER.info("That one is already in use. Enter another.");
                    }
                } else {
                    LOGGER.info("Invalid input. Enter a number between 1 and 9.");
                }
            } catch (java.util.InputMismatchException e) {
                LOGGER.info("Invalid input. Please enter a valid number.");
                scanner.nextLine();
            }
        }
    }

    void closeScanner() {
        scanner.close();
    }
}
