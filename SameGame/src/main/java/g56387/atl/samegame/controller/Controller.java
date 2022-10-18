package g56387.atl.samegame.controller;

import g56387.atl.samegame.commands.Move;
import g56387.atl.samegame.model.Board;
import g56387.atl.samegame.model.Bubble;
import g56387.atl.samegame.model.Game;
import g56387.atl.samegame.model.Model;
import g56387.atl.samegame.model.Position;
import g56387.atl.samegame.viewconsole.MyView;

/**
 * Represents the controller of game, it makes the link between javaFx view and
 * console view with model
 *
 * @author mohamed
 */
public class Controller {

    private Model model;
    private MyView view;
    CommandManager commandManager;

    /**
     * a simple Constructor use for the console game.
     *
     * @param model The model
     * @param view The console view
     */
    public Controller(Model model, MyView view) {

        this.model = model;
        this.view = view;
        commandManager = new CommandManager();

    }

    /**
     * a simple constructor use for the javaFx view.
     *
     *
     * @param model The model
     */
    public Controller(Model model) {
        this.model = model;
        model.start();
        commandManager = new CommandManager();
    }

    /**
     * Allows you to play the entire same game on the console
     */
    public void SameGame() {

        model.start();
        view.decoration();
        view.printBoard();
        while (!model.isGameOver()) {
            Position pos = view.askPositionBulle();
            Move move = new Move(model, pos);

            commandManager.addCommand(move);
            view.printBoard();
            stateChosenByPlayer(commandManager);

        }

    }

    /**
     * Take into account the action of the player and execute it.
     *
     * @param commandManager for a possible undo/redo
     */
    public void stateChosenByPlayer(CommandManager commandManager) {
        String command;

        do {

            command = view.askUndo_redo_exit();
            switch (command) {

                case "exit":

                    System.exit(0);
                    break;

                case "undo":
                    commandManager.undo();
                    break;
                case "redo":

                    commandManager.redos();
                    break;

            }
            view.printBoard();
        } while (!command.equals("continue"));

    }

    /**
     * Allows you to play a move from the javaFX view
     *
     * @param pos the given Position
     */
    public void play(Position pos) {

        Move move = new Move(model, pos);
        commandManager.addCommand(move);

    }

    /**
     * Allows to see if a bubble is alone from the javaFXiew (alone: this does
     * mean that it has no neighbour of the same colour)
     *
     * @param pos A position
     * @return true if the bubble is alone false if not.
     */
    public boolean bubbleIsAlone(Position pos) {

        return model.bubbleIsAlone(pos);

    }

    /**
     * Allows undo from javaFX view
     */
    public void undo() {

        commandManager.undo();

    }

    /*
     * Allows redo from javaFX view
     */
    public void redo() {

        commandManager.redos();

    }

    public void setScore() {

        model.getScore();

    }

    public boolean gameOver() {
        return model.isGameOver();
    }

    public Bubble[][] getArrayBubble() {

        return model.getBoard().getBubbles();
    }

    public Model getModel() {
        return model;
    }

}
