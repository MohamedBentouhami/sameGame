package g56387.atl.samegame.controller;

import java.util.Stack;
import g56387.atl.samegame.commands.Command;

/**
 * Manage the different action of the game
 *
 * @author mohamed
 */
public class CommandManager {

    private Stack<Command> history;
    private Stack<Command> redos;

    /**
     * A simple constructor of commandManager
     */
    public CommandManager() {

        this.history = new Stack<>();
        this.redos = new Stack<>();

    }

    /**
     * executes the action and saves it in the history stack so that it can undo
     * it.
     *
     * @param action
     */
    public void addCommand(Command action) {

        action.exceute();
        redos.clear();
        history.push(action);

    }

    /**
     * Allows you to go back and cancel the last move(s)
     */
    public void undo() {
        if (!history.empty()) {
            Command action = history.pop();
            action.undo();
            redos.push(action);

        }

    }

    /**
     * Allows you to reset after the undo command
     */
    public void redos() {

        if (!redos.empty()) {
            Command action = redos.pop();
            action.exceute();
            history.push(action);

        }

    }

}
