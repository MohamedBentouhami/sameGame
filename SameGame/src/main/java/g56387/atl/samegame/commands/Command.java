package g56387.atl.samegame.commands;

/**
 * Command interface with undo/redo
 *
 * @author mohamed
 */
public interface Command {

    /**
     * Executes the specified command
     */
    public void exceute();

    /**
     * Undoes the specified command
     *
     */
    public void undo();
}
