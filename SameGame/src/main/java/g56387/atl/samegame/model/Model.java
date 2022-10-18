package g56387.atl.samegame.model;

/**
 * Interface for the Game model.
 *
 * @author mohamed
 */
public interface Model {

    /**
     * fill in the bubbles board randomly
     */
    public void start();

    /**
     * checks if the game is finished or not
     *
     * @return true if the game is over or false is not
     */
    public boolean isGameOver();

    /**
     * cheeks if the bubble at a given position exists
     *
     * @param pos The position of the bubble
     * @return true if the bubble is not null
     */
    public boolean isBubblePresent(Position pos);

    /**
     * Allows you to play a move
     *
     * @param position position where the move will be made
     */
    public void play(Position position);

    /**
     * allows to change the state of a game by a state previously played
     *
     * @param oldState
     */
    public void setState(GameState oldState);

    /**
     * cheeks if a bubble at a given position has neighbours of the same colour
     *
     * @param pos Position of the bubble to be checked
     * @return true if the bubble is not a neighbouring bubble of the same
     * colour false if not
     */
    public boolean bubbleIsAlone(Position pos);

    public Board getBoard();

    public int getScore();

}
