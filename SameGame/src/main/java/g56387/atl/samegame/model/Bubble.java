package g56387.atl.samegame.model;

/**
 * Represents a bubble in the Same Game
 *
 * @author mohamed
 */
public class Bubble {

    private Colour color;
    private final Position position;

    /**
     * A simple constructor of Bubble
     *
     * @param color The colour of the bubble
     * @param position The position of the bubble in the board game
     */
    public Bubble(Colour color, Position position) {
        this.color = color;
        this.position = position;
    }

    public Colour getColor() {
        return color;
    }

    public void setColor(Colour color) {

        this.color = color;

    }

}
