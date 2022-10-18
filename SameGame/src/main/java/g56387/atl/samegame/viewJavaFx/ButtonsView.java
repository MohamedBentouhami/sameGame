package g56387.atl.samegame.viewJavaFx;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;

/**
 *
 * @author mohamed
 */
public final class ButtonsView extends HBox {

    private final Button btnUndo;
    private final Button btnRedo;
    private final Button btnRestart;

    /**
     * A simple constructor
     */
    public ButtonsView() {

        this.btnUndo = new Button("UNDO");
        this.btnRedo = new Button("REDO");
        this.btnRestart = new Button("RESTART");
        decorationBtnRestart();
        decorationBtnRedo();
        decorationBtnUndo();

        this.getChildren().add(btnRestart);
        this.getChildren().add(btnUndo);
        this.getChildren().add(btnRedo);
        this.setSpacing(30);
        this.setPadding(new Insets(60, 30, 0, 30));

    }

    /**
     * brings a style to the restart button
     */
    public void decorationBtnRestart() {
        this.btnRestart.setShape(new Ellipse(20, 50));
        this.btnRestart.setBorder(new Border(new BorderStroke(Color.BLACK,
                BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
        btnRestart.setStyle("-fx-background-color: #79BEA8");

    }

    /**
     * brings a style to the undo button
     */
    public void decorationBtnUndo() {
        this.btnUndo.setShape(new Ellipse(1, 1));
        this.btnUndo.setBorder(new Border(new BorderStroke(Color.BLACK,
                BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
        this.btnUndo.setStyle("-fx-background-color: #79BEA8");

    }

    /**
     * brings a style to the redo button
     */
    public void decorationBtnRedo() {
        this.btnRedo.setShape(new Ellipse(20, 50));
        this.btnRedo.setBorder(new Border(new BorderStroke(Color.BLACK,
                BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
        this.btnRedo.setStyle("-fx-background-color: #79BEA8");

    }

    /**
     *
     * Allows to disable the undo/redo buttons
     */
    public void disableButtons() {

        btnRedo.setDisable(true);
        btnUndo.setDisable(true);
    }

    public Button getBtnUndo() {
        return btnUndo;
    }

    public Button getBtnRedo() {
        return btnRedo;
    }

    public Button getBtnExit() {
        return btnRestart;
    }

}
