package tictactoe;

import java.util.Random;

public class Computer {
    private char symbol;
    private Random random;
    private int boardSide = 9;

    public Computer(char symbol) {
        this.symbol = symbol;
        this.random = new Random();
    }

    public char getSymbol() {
        return symbol;
    }

    public int getComputerMove(GameBoard gameBoard) {
        int rand;
        while (true) {
            rand = random.nextInt(boardSide) + 1;
            if (gameBoard.isBoxEmpty(rand)) {
                return rand;
            }
        }
    }
}

