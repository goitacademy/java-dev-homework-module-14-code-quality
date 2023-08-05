package tictactoe;

import java.util.Scanner;

public class TicTacToeGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        GameBoard gameBoard = new GameBoard();
        Player player = new Player(GameBoard.PLAYER_SYMBOL);
        Computer computer = new Computer(GameBoard.COMPUTER_SYMBOL);

        gameBoard.displayStartMessage();
        playGame(gameBoard, player, computer);
        scanner.close();
    }

    public static void playGame(GameBoard gameBoard, Player player, Computer computer) {
        byte winner = 0;
        boolean boxEmpty = false;

        while (true) {
            gameBoard.displayBoard();

            if (!boxEmpty) {
                gameBoard.resetBoard();
                boxEmpty = true;
            }

            winner = gameBoard.isWinner();
            gameBoard.announceGameResult(winner);

            if (winner != 0) {
                break;
            }

            byte input = player.getPlayerInput(gameBoard);
            gameBoard.makeMove(input, player.getSymbol());

            int computerMove = computer.getComputerMove(gameBoard);
            gameBoard.makeMove(computerMove, computer.getSymbol());
        }
    }
}
