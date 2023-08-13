package ua.mani123;

import org.slf4j.Logger;

import java.util.NoSuchElementException;
import java.util.Scanner;

public class Game {

    Logger logger;

    Scanner scan = new Scanner(System.in);
    char[] box = {'1', '2', '3', '4', '5', '6', '7', '8', '9'};

    public Game(Logger logger) {
        this.logger = logger;
    }


    public boolean isAvailable() {
        for (char c : box) {
            if (c != 'X' && c != 'O') {
                return true;
            }
        }
        return false;
    }

    public void computerTurn() {
        if (isAvailable()) {
            while (true) {
                byte rand = (byte) (Math.random() * (9 - 1 + 1) + 1);
                if (box[rand - 1] != 'X' && box[rand - 1] != 'O') {
                    box[rand - 1] = 'O';
                    break;
                }
            }
        }
    }

    public boolean checkWinner() {
        if (isCharWin('X')) {
            logger.warn("""
                    You won the game!
                    Created by Shreyas Saha (refactored by mani123). Thanks for playing!""");
            return true;
        } else if (isCharWin('O')) {
            logger.warn("""
                    You lost the game!
                    Created by Shreyas Saha (refactored by mani123). Thanks for playing!""");
            return true;
        } else if (!isAvailable()) {
            logger.warn("""
                    It's a draw!
                    Created by Shreyas Saha (refactored by mani123). Thanks for playing!""");
            return true;
        }
        return false;
    }

    public boolean isCharWin(char symbol) {
        for (int i = 0; i < 9; i += 3) {
            if (box[i] == symbol && box[i + 1] == symbol && box[i + 2] == symbol) {
                return true;
            }
        }
        for (int i = 0; i < 3; i++) {
            if (box[i] == symbol && box[i + 3] == symbol && box[i + 6] == symbol) {
                return true;
            }
        }
        if (box[0] == symbol && box[4] == symbol && box[8] == symbol) {
            return true;
        }
        return box[2] == symbol && box[4] == symbol && box[6] == symbol;
    }

    public void printPanel() {
        String str = String.format("""
                %s | %s | %s
                ------------
                %s | %s | %s
                ------------
                %s | %s | %s""", box[0], box[1], box[2], box[3], box[4], box[5], box[6], box[7], box[8]);
        logger.info(str);
    }

    public void clearPanel() {
        for (byte i = 0; i < 9; i++) {
            box[i] = ' ';
        }
    }

    public void playerTurn() {
        while (true) {
            try {
                byte input = scan.nextByte();
                if (input > 0 && input < 10) {
                    if (box[input - 1] == 'X' || box[input - 1] == 'O')
                        logger.error("That one is already in use. Enter another.");
                    else {
                        box[input - 1] = 'X';
                        return;
                    }
                } else logger.error("Invalid input. Enter again.");
            } catch (NoSuchElementException | IllegalStateException e) {
                logger.error(e.getMessage(), e);
                playerTurn();
            }
        }
    }


}
