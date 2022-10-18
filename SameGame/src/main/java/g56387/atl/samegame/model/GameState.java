package g56387.atl.samegame.model;

/**
 * Allows you to record the state of the game
 *
 * @author mohamed
 */
public class GameState {

    private Bubble[][] oldBubbles;
    private boolean[][] oldStatBubbles;
    private int score;
    private int oldCurrentScore;

    /**
     * A simple constructor of GameState which will record the board, the board
     * status, the score and current score
     *
     * @param game
     */
    public GameState(Model game) {

        oldBubbles = game.getBoard().getBubbles();
        oldStatBubbles = game.getBoard().getVisited();
        score = game.getScore();
        oldCurrentScore = game.getBoard().getCurrentScore();

    }

    public Bubble[][] getOldBubbles() {
        return oldBubbles;
    }

    public boolean[][] getOldStatBubbles() {
        return oldStatBubbles;
    }

    public int getScore() {
        return score;
    }

    public int getOldCurrentScore() {
        return oldCurrentScore;
    }

}
