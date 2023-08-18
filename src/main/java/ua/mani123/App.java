package ua.mani123;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class App {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    public static void main(String[] args) {
        App app = new App();
        app.runApp(new Game(app.logger));
    }

    public void runApp(Game game) {
        game.printPanel(); // Info panel
        logger.info("Enter box number to select. Enjoy!");
        game.clearPanel();

        while (true) {
            if (game.checkWinner()) {
                game.printPanel(); // Result panel
                break;
            } else {
                game.playerTurn(); // You can change who first start game
                game.computerTurn();
                game.printPanel(); // Game panel
            }
        }
    }


}