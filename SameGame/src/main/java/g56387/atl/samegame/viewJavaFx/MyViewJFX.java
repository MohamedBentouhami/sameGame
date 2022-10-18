package g56387.atl.samegame.viewJavaFx;

import g56387.atl.samegame.util.Observer;
import g56387.atl.samegame.controller.Controller;
import g56387.atl.samegame.model.Board;
import g56387.atl.samegame.model.Game;
import g56387.atl.samegame.model.Model;
import java.util.List;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import javafx.stage.Stage;

/**
 * Represent the view of the game
 *
 * @author mohamed
 */
public class MyViewJFX extends Application implements Observer {

    private Controller controller;
    private Model model;
    private BoardView boardView;
    private ScoreView score;
    private List<BubbleView> listButtons;
    private StatusView statusGame;
    private ButtonsView buttonView;
    private Label nbBubblesLeft;
    private Label currentScore;
    public static final int STAGE_MAX_WIDTH = 1000;
    public static final int STAGE_MAX_HEIGHT = 750;
    public static final int SPACING = 250;
    public static final int SPACING_HEADER = 150;

    /**
     * create a instance of MyViewJFX
     */
    public MyViewJFX() {

        Configuration config = new Configuration();
        cancelOrNot(config);
        this.model = new Game(new Board(config.widthValue(), config.heightValue()),
                config.returnLevel());
        this.controller = new Controller(model);

    }

    @Override
    public void start(Stage primaryStage) {
        intialisationGame();
        primaryStage.setTitle("Same Game");
        primaryStage.setMaxWidth(STAGE_MAX_WIDTH);
        primaryStage.setMaxHeight(STAGE_MAX_HEIGHT);
        GridPane boardContainer = boardView.getBoardContainer();

        HBox header = new HBox(nbBubblesLeft, score, currentScore);
        header.setSpacing(SPACING_HEADER);
        HBox hbox = new HBox(boardContainer, statusGame);
        hbox.setSpacing(SPACING);

        score.setAlignment(Pos.TOP_CENTER);
        hbox.setAlignment(Pos.CENTER_LEFT);

        readingBubbles();
        eventReadingBtnUndo();
        eventReadingBtnRedo();

        buttonView.getBtnExit().setOnAction((actionEvent) -> {
            MyViewJFX vue = new MyViewJFX();
            vue.start(primaryStage);
        });

        buttonView.setAlignment(Pos.BOTTOM_CENTER);
        statusGame.setAlignment(Pos.CENTER_RIGHT);
        nbBubblesLeft.setAlignment(Pos.TOP_LEFT);

        VBox root = new VBox();
        root.setSpacing(25);
        root.getChildren().addAll(header, hbox, buttonView);

        Scene scene = new Scene(root, 700, 600);
        root.setStyle("-fx-background-color: #DBE5FF");
        primaryStage.setScene(scene);
        primaryStage.show();
        primaryStage.setResizable(false);

    }

    /**
     * Allows to initialise the components of the view
     */
    private void intialisationGame() {
        Game game = (Game) model;
        game.addObserver(this);
        this.boardView = new BoardView(controller, model);
        score = new ScoreView(controller);
        statusGame = new StatusView(controller);
        buttonView = new ButtonsView();
        listButtons = boardView.getListBublles();
        nbBubblesLeft = boardView.getNbBubblesLeft();
        currentScore = score.getCurrentScore();

    }

    /**
     * Allows you to listen to events on the undo button and execute the undo if
     * pressed and calls the method to change the scores
     */
    private void eventReadingBtnUndo() {
        buttonView.getBtnUndo().setOnAction((actionEvent) -> {
            statusGame.setText("flush");
            controller.undo();
            controller.setScore();

        });
    }

    /**
     * Allows you to listen to events on the redo button and execute the undo if
     * pressed and calls the method to change the scores
     */
    private void eventReadingBtnRedo() {
        buttonView.getBtnRedo().setOnAction((actionEvent) -> {
            controller.redo();
            controller.setScore();

        });
    }

    /**
     * allows you to read events on the bubbles and then play the move and
     * update the scores
     */
    private void readingBubbles() {

        for (BubbleView bulle : listButtons) {
            bulle.getCircle().setOnMouseClicked(actionEvent -> {
                statusGame.setText("flush");
                if (controller.bubbleIsAlone(bulle.getPos())) {
                    statusGame.setText("alone");
                } else {

                    this.controller.play(bulle.getPos());
                    controller.setScore();
                }

            });

        }
        listButtons.clear();
    }

    /**
     * allows you to manage the end of the game
     */
    public void endOfGame() {

        controller.setScore();
        if (listButtons.isEmpty()) {
            statusGame.setText("win");

        } else {
            statusGame.setText("game over");
        }

    }

    /**
     * allows you not to start a game after the configuration
     *
     * @param configuration The configuration of the game
     */
    private void cancelOrNot(Configuration configuration) {
        if (!configuration.cancelOrNot()) {
            System.exit(0);
        }
    }

    @Override
    public void update(Object args) {

        if (args.getClass().equals(Board.class)) {
            boardView.update();
            readingBubbles();

        }
        if (args.equals("gameOver")) {
            buttonView.disableButtons();
            endOfGame();
            boardView.desactivateButtons();

        }
        if (args.equals("score")) {
            score.update();

        }

    }

}
