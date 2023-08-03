package tic_tac_toe;

import java.util.logging.*;

public class LoggerConfig {
    private LoggerConfig() {
        throw new AssertionError("Utility class, should not be instantiated.");
    }

    public static void configureLogger() {
        LogManager.getLogManager().reset();
        Logger logger = Logger.getLogger(TicTacToe.class.getName());
        logger.setLevel(Level.ALL);

        ConsoleHandler handler = new ConsoleHandler();
        handler.setLevel(Level.ALL);
        handler.setFormatter(new SimpleFormatter() {
            @Override
            public String format(LogRecord message) {
                return message.getMessage() + "\n";
            }
        });

        logger.addHandler(handler);
    }
}
