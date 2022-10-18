package g56387.atl.samegame.viewJavaFx;

import g56387.atl.samegame.controller.Controller;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;

/**
 * Represents the game status
 *
 * @author mohamed
 */
public final class StatusView extends VBox {

    private final Controller controller;
    private Text text;
    private static int MAX_WIDTH = 15;
    private static int MAX_HEIGHT = 40;

    /**
     * Simple constructor of the game status.
     *
     * @param controller
     */
    public StatusView(Controller controller) {

        this.controller = controller;
        decoration();

    }

    /**
     * brings a style to the status game component
     */
    public void decoration() {
        Label label = new Label("Status game ");
        label.setStyle("-fx-font-family: Courier New;"
                + "-fx-font-weight: bold;"
                + "-fx-font-size: 19;"
        );
        this.setMaxWidth(MAX_WIDTH);
        this.setMaxHeight(MAX_HEIGHT);
        this.text = new Text("Welcome     ");
        text.setFill(Color.web("#012998"));
        text.setStyle("-fx-font-weight: bold;"
                + "-fx-font-size: 15;");
        this.getChildren().add(label);
        this.getChildren().add(text);
        this.setPadding(new Insets(0, 20, 250, 0));
        this.setStyle("-fx-background-color: beige");
        this.setMinSize(150, 300);

    }

    /**
     * change the text according to the different states of the game
     *
     * @param status
     */
    public void setText(String status) {

        switch (status) {
            case "flush":
                this.text.setText("         ");
                break;

            case "alone":

                this.text.setText("bubble is alone !!");
                break;

            case "game over":
                this.text.setText("GAME OVER  ");
                break;

            case "win":
                this.text.setText("YOU WIN    ");
                break;
        }

    }

}
