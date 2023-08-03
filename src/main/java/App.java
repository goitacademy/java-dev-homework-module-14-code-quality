import java.util.logging.ConsoleHandler;
import java.util.logging.LogRecord;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class App {
    private static final Logger logger = Logger.getLogger(App.class.getName());

    public static void main(String[] args) {
        setupLogger();
        Board board = new Board(logger);
        logger.info("Enter box number to select. Enjoy!\n");
        board.play();
        logger.info("Created by Shreyas Saha. Thanks for playing!");
        logger.info("Optimized by Vladimir Shutyak");
    }
    public static void setupLogger() {
        logger.setUseParentHandlers(false);
        ConsoleHandler consoleHandler = new ConsoleHandler();
        consoleHandler.setFormatter(new SimpleFormatter() {
            @Override
            public synchronized String format(LogRecord lr) {
                return  lr.getMessage() + System.lineSeparator();
            }
        });

        logger.addHandler(consoleHandler);
    }
}


