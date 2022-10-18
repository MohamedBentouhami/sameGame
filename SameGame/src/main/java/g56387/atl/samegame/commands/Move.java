package g56387.atl.samegame.commands;

/**
 * Represents a move in a game that can be reversed
 */
import g56387.atl.samegame.model.GameState;
import g56387.atl.samegame.model.Model;
import g56387.atl.samegame.model.Position;

public class Move implements Command {

    private final Model game;
    private final Position pos;
    private GameState oldState;

    /**
     * Simple constructor of Move class
     *
     * @param game represents the game
     * @param pos position where the move will be made.
     */
    public Move(Model game, Position pos) {

        this.game = game;
        this.pos = pos;

    }

    @Override
    public void exceute() {
        oldState = new GameState(game);

        game.play(pos);

    }

    @Override
    public void undo() {
        game.setState(oldState);

    }

}
