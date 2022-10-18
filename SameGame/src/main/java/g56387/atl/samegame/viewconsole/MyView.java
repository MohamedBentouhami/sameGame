package g56387.atl.samegame.viewconsole;

import g56387.atl.samegame.model.Board;
import g56387.atl.samegame.model.Game;
import g56387.atl.samegame.model.Position;

import java.util.Scanner;

/**
 * @author mohamed
 */
public class MyView {

    private final Game game;

    public MyView(Game game) {
        this.game = game;
    }

    /**
     * Ask for a row and column number as long as the position has a bubble to
     * make it a position in the game.
     *
     * @return A position on the board of the game
     */
    public Position askPositionBulle() {

        int row = 0;
        int column = 0;
        Position pos;
        do {
            row = readInt("Enter the line of the desired position", 0,
                    game.getBoard().getWidth() - 1);
            column = readInt("Enter the column of the desired position", 0,
                    game.getBoard().getHeigth() - 1);

            pos = new Position(row, column);

        } while (!game.isBubblePresent(pos));

        return pos;
    }

    /**
     * Reads an integer between a min and a max If the value entered is not an
     * integer in the correct range the method asks the question again until it
     * is correct.
     *
     * @param msg the message to be displayed to the user.
     * @param min the minimum value allowed.
     * @param max the maximum allowable value.
     * @return the integer read.
     *
     */
    public static int readInt(String msg, int min, int max) {
        int value;
        String msgWithLimits = msg + " (" + min + " à " + max + ")";
        value = readInt(msgWithLimits);
        while (value < min || value > max) {
            value = readInt(msgWithLimits);
        }
        return value;
    }

    /**
     * Reads an integer. If the input does not match an integer, an error
     * message is displayed and the method asks the question again until it
     * reads an integer.
     *
     * @param msg the message to be displayed to the user.
     * @return the integer read.
     */
    public static int readInt(String msg) {
        Scanner clavier = new Scanner(System.in);
        System.out.println(msg + ": ");
        while (!clavier.hasNextInt()) {
            System.err.print("This is not a number\n");
            clavier.next();
            System.out.println(msg + ":");
        }
        return clavier.nextInt();
    }

    /**
     * Asks the user if they want to continue, undo, redo or exit
     *
     * @return a string which represents the user's choice
     */
    public String askUndo_redo_exit() {
        Scanner keyboard = new Scanner(System.in);
        String command;
        do {
            System.out.println("tap continue - exit - undo - redo");
            command = keyboard.nextLine();

        } while (!command.equals("continue") && !command.equals("exit")
                && !command.equals("undo") && !command.equals("redo"));

        return command;
    }

    /**
     * Displays the game board
     */
    public void printBoard() {

        Board board = game.getBoard();
        header(board);

        for (int i = 0; i < board.getWidth(); i++) {
            System.out.print(i + "| ");
            for (int j = 0; j < board.getHeigth(); j++) {

                if (board.givenBubble(i, j) != null && !board.givenStateBubble(i, j)) {
                    System.out.print(board.givenBulleColor(i, j) + "  ");

                } else {
                    System.out.print("   ");
                }

            }
            System.out.println("");

        }
        printScore();

    }

    /**
     * Display the total score.
     */
    public void printScore() {
        System.out.println("score : " + game.getScore());

    }

    public void decoration() {

        System.out.println("******* SameGame ********\n");
    }

    public void header(Board board) {
        System.out.print("   ");
        for (int i = 0; i < board.getHeigth(); i++) {
            System.out.print(i + "  ");

        }
        System.out.println();

    }

}
