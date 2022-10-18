package g56387.atl.samegame.viewJavaFx;

import g56387.atl.samegame.controller.Controller;
import g56387.atl.samegame.model.Bubble;
import g56387.atl.samegame.model.Colour;
import g56387.atl.samegame.model.Model;
import g56387.atl.samegame.model.Position;
import java.util.ArrayList;
import java.util.List;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

/**
 * Represent the game board
 *
 */
public final class BoardView {

    private static final int SIZE = 300;
    private final GridPane boardContainer;
    private final Controller gameController;
    private final Model model;
    private final List<BubbleView> listBublles;
    private Label nbBubblesLeft;

    /**
     * A simple constructor of the boardView
     *
     * @param gameController Controller of sameGame
     * @param model The model of sameGame
     */
    public BoardView(Controller gameController, Model model) {

        this.gameController = gameController;
        this.model = model;
        this.listBublles = new ArrayList<>();
        boardContainer = new GridPane();
        boardContainer.setMinSize(SIZE, SIZE);
        boardContainer.setMaxSize(SIZE, SIZE);
        boardContainer.setAlignment(Pos.CENTER_LEFT);
        updateBoard(this.gameController.getModel().getBoard().getBubbles());
        setNbBubbles();
    }

    public void setNbBubbles() {
        this.nbBubblesLeft = new Label("bubbles left : "
                + listBublles.size());
        nbBubblesLeft.setStyle(
                "-fx-font-family: Courier New;"
                + "-fx-font-weight: bold;"
                + "-fx-font-size: 19;"
        );
        this.nbBubblesLeft.setPadding(new Insets(50, 0, 0, 6));
    }

    public void updateBoard(Bubble[][] bubble) {

        for (int i = 0; i < bubble.length; i++) {
            for (int j = 0; j < bubble[0].length; j++) {

                if (bubble[i][j] != null) {
                    Colour currentColor = bubble[i][j].getColor();
                    BubbleView bub = new BubbleView(currentColor, new Position(i, j));
                    boardContainer.add(bub, j, i);
                    listBublles.add(bub);
                } else {

                    BubbleView bub = new BubbleView(Colour.WHITE, new Position(i, j));
                    boardContainer.add(bub, j, i);

                }
            }
        }
        gameController.gameOver();
    }

    public GridPane getBoardContainer() {
        return boardContainer;
    }

    public Controller getGameController() {
        return gameController;
    }

    public Model getModel() {
        return model;
    }

    public List<BubbleView> getListBublles() {
        return listBublles;
    }

    public Label getNbBubblesLeft() {
        return nbBubblesLeft;
    }

    public void update() {
        boardContainer.getChildren().clear();
        listBublles.clear();
        updateBoard(this.model.getBoard().getBubbles());
        this.nbBubblesLeft.setText("bubbles left : "
                + String.format("%3s", listBublles.size()));

    }

    public void desactivateButtons() {
        for (BubbleView btn : listBublles) {
            btn.getCircle().setDisable(true);

        }

    }

}
