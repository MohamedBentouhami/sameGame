package g56387.atl.samegame.main;

import g56387.atl.samegame.controller.Controller;
import g56387.atl.samegame.model.Board;
import g56387.atl.samegame.model.Game;
import g56387.atl.samegame.viewconsole.MyView;

/**
 * Main class which allows you to launch the game in console
 * @author mohamed
 */
public class Main {

    public static void main(String[] args) {
        Board board = new Board(5, 3);
        Game game = new Game(board, 3);
        MyView vue = new MyView(game);
        Controller controller = new Controller(game, vue);
        controller.SameGame();
    }

}
