
package g56387.atl.samegame.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author mohamed
 */
public class GameTest {
    private Game game;
    private Board board;
    
    public void setUp() {
        board = new Board(3, 1);
        game = new Game(board, 3);

        Position pos = new Position(0, 0);
        board.put(new Bubble(Colour.BLUE, pos), pos);

        Position pos1 = new Position(0, 1);
        board.put(new Bubble(Colour.BLUE, pos1), pos1);

        Position pos2 = new Position(0, 2);
        board.put(new Bubble(Colour.RED, pos2), pos2);
        // B B R

    }
  
    @Test
    public void testIsGameOver() {
        setUp();
        game.play(new Position(0, 0));
        assertEquals(true, game.isGameOver());
    }
    
    
    @Test
    public void testIsGameOver_case2() {
        setUp();
        game.play(new Position(0, 2));
        assertEquals(false, game.isGameOver());
    }

  
    /**
     * Test of bubbleIsAlone method, of class Game.
     */
    @Test
    public void testBubbleIsAlone() {
        setUp();
        assertEquals(true, game.bubbleIsAlone(new Position(0, 2)));
    }
    /**
     * Test of bubbleIsAlone method, of class Game.
     */
    @Test
    public void testBubbleIsAlone_case2() {
        setUp();
        assertEquals(false, game.bubbleIsAlone(new Position(0, 0)));
    }

    /**
     * Test of isBubblePresent method, of class Game.
     */
    @Test
    public void testIsBubblePresent() {
         setUp();
        game.play(new Position(0, 0));
        assertEquals(false,game.isBubblePresent(new Position(0, 1)));
        
    }


 
}
