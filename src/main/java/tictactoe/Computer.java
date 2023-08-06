package tictactoe;

import java.util.Random;


class Computer {
    private final char symbol;
    private final Random random;
    private static final int BOARD_SIDE = 9;

    Computer(char symbol) {
        this.symbol = symbol;
        this.random = new Random();
    }

    char getSymbol() {
        return symbol;
    }

    int getComputerMove(final GameBoard gameBoard) {
        int rand;
        while (!gameBoard.isBoardFull()) {
            rand = random.nextInt(BOARD_SIDE) + 1;
            if (gameBoard.isBoxEmpty(rand)) {
                return rand;
            }
        }
        return GameBoard.DRAW;
    }
}


