package g56387.atl.samegame.viewJavaFx;

import java.util.Optional;
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;
import javafx.scene.control.TextInputDialog;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

/**
 * Represent the configuration of the Same Game
 *
 * @author mohamed
 */
public final class Configuration extends TextInputDialog {

    private static Optional<String> result;
    static final int AJUSTEMENT_LEVEL = 2;
    private final int level;
    private final int width;
    private final int heigth;
    private Spinner<Integer> spinnerLevel;
    private Spinner<Integer> spinnerWidth;
    private Spinner<Integer> spinnerHeight;

    /**
     * Create a instance of configuration
     */
    public Configuration() {
        this.setHeaderText("Same Game");
        setUp();
        result = this.showAndWait();
        level = spinnerLevel.getValue();
        width = spinnerWidth.getValue();
        heigth = spinnerHeight.getValue();

    }
    
    /**
     * Sets up the three spinner
     */
    public void setUp() {
        this.setTitle("config");
        this.setResizable(true);

        Label label = new Label("Level :  ");
        this.spinnerLevel = new Spinner(1, 3, 2);

        HBox contentLevel = new HBox();
        VBox content = new VBox(8);

        contentLevel.getChildren().add(label);
        contentLevel.getChildren().add(spinnerLevel);

        Label labelWidth = new Label("Width : ");
        this.spinnerWidth = new Spinner(3, 20, 19);

        HBox contentWidth = new HBox(labelWidth, spinnerWidth);

        Label labelHeight = new Label("Height: ");
        this.spinnerHeight = new Spinner(3, 12, 10);

        HBox contentHeight = new HBox(labelHeight, spinnerHeight);
        
        content.getChildren().addAll(contentLevel,contentWidth,contentHeight);
        this.getDialogPane().setContent(content);

    }

    public int returnLevel() {

        return level + AJUSTEMENT_LEVEL;
    }

    public int widthValue() {

        return width;
    }

    public int heightValue() {

        return heigth;
    }

    public boolean cancelOrNot() {
        return result.isPresent();
    }
}
