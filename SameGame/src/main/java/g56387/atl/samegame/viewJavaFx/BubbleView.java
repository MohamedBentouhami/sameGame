package g56387.atl.samegame.viewJavaFx;

import g56387.atl.samegame.model.Colour;
import g56387.atl.samegame.model.Position;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.Circle;

/**
 * Represents a bubble in the Same Game
 *
 * @author mohamed
 */
public final class BubbleView extends StackPane {

    private static final double RADIUS = 27;
    private final Button circle;
    private final Colour colour;
    private final Position pos;

    /**
     * A simple constructor
     *
     * @param color
     * @param pos
     */
    public BubbleView(Colour color, Position pos) {
        circle = new Button();
        circle.setShape(new Circle(RADIUS));
        circle.setMinSize(RADIUS, RADIUS);
        this.colour = color;
        this.pos = pos;
        colorOfCircle(color);
        this.getChildren().addAll(circle);

    }

    /**
     * Colour the bubble according to the colour of the bubble
     *
     * @param color The colour of the bubble;
     */
    public void colorOfCircle(Colour color) {

        switch (color) {
            case RED:
                circle.setStyle("-fx-background-color: #df3612");
                break;
            case BLUE:
                circle.setStyle("-fx-background-color: #00cff4");
                break;
            case YELLOW:
                circle.setStyle("-fx-background-color: #f0f400");
                break;
            case GREEN:
                circle.setStyle("-fx-background-color: green");
                break;

            case WHITE:
                circle.setStyle("-fx-background-color: #DBE5FF");
                break;
            case PURPLE:
                circle.setStyle("-fx-background-color: #800080");
                break;

        }

    }

    public Button getCircle() {

        return circle;
    }

    public Colour getColour() {
        return colour;
    }

    public Position getPos() {
        return pos;
    }

}
