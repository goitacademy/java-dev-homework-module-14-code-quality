import tic_tac_toe.LoggerConfig;
import tic_tac_toe.TicTacToe;

public class Main {
    public static void main(String[] args) {

        LoggerConfig.configureLogger();
        TicTacToe ticTacToe = new TicTacToe();
        ticTacToe.playGame();
    }
}
