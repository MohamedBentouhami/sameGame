package g56387.atl.samegame.viewJavaFx;

import g56387.atl.samegame.controller.Controller;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

/**
 * This class represent the score  and cuurentScore on the game.
 *
 * @author mohamed
 */
public class ScoreView extends VBox {

    private final Label scoreLabel;
    private final Text scoreValue;
    private final Controller controller;
    private final Label currentScore;

    /**
     * A simple controller of ScoreView class.
     *
     * @param controller
     */
    public ScoreView(Controller controller) {
        this.controller = controller;
        this.scoreLabel = new Label("Score");
        this.currentScore = new Label("current score : 0");
        this.scoreValue = new Text();
        scoreValue.setText("0");
        this.getChildren().add(scoreLabel);
        this.getChildren().add(scoreValue);
        decoration();
    }

    /**
     * Brings a style to the display of the score
     */
    private void decoration() {
        this.setPadding(new Insets(0, 0, 80, 0));
        scoreLabel.setStyle(
                "-fx-font-family: Courier New;"
                + "-fx-font-weight: bold;"
                + "-fx-font-size: 20;"
        );

        scoreValue.setStyle(
                "-fx-padding: 10;"
                + "-fx-font-family: Segoe UI Semibold;"
                + "-fx-font-weight: bold;"
                + "-fx-font-size: 20;"
        );

        currentScore.setStyle(
                "-fx-font-family: Courier New;"
                + "-fx-font-weight: bold;"
                + "-fx-font-size: 20;"
        );
        currentScore.setPadding(new Insets(50, 0, 0, 0));
    }

    /**
     * Allows you to update the total score
     *
     * @param score The total score.
     */
    public void updateScore(int score) {

        scoreValue.setText(String.valueOf(score));

    }

    /**
     * Allows to update the current score.
     *
     * @param score The current score
     */
    public void updateCurrentScore(int score) {

        currentScore.setText("current score : " + String.valueOf(score));

    }

    public Label getCurrentScore() {
        return currentScore;
    }

    /**
     * Allow to update the current score and the total score.
     */
    public void update() {
        updateScore(controller.getModel().getBoard().getScore());
        updateCurrentScore(controller.getModel().getBoard().getCurrentScore());

    }

}
