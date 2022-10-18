package g56387.atl.samegame.model;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;

/**
 *
 * @author mohamed
 */
public class BoardTest {

    private Board board;

    /**
     * Allows you to set up a board with selected bubbles
     */
    public void setUp() {
        board = new Board(3, 1);

        Position pos = new Position(0, 0);
        board.put(new Bubble(Colour.BLUE, pos), pos);

        Position pos1 = new Position(0, 1);
        board.put(new Bubble(Colour.BLUE, pos1), pos1);

        Position pos2 = new Position(0, 2);
        board.put(new Bubble(Colour.RED, pos2), pos2);

    }

    /**
     * Allows you to set up a board with selected bubbles
     */
    public void setUp2() {
        board = new Board(3, 2);

        Position pos = new Position(0, 0);
        board.put(new Bubble(Colour.BLUE, pos), pos);

        Position pos1 = new Position(0, 1);
        board.put(new Bubble(Colour.BLUE, pos1), pos1);

        Position pos2 = new Position(0, 2);
        board.put(new Bubble(Colour.RED, pos2), pos2);
        Position pos3 = new Position(1, 0);
        board.put(new Bubble(Colour.RED, pos3), pos3);

        Position pos4 = new Position(1, 1);
        board.put(new Bubble(Colour.BLUE, pos4), pos4);

        Position pos5 = new Position(1, 2);
        board.put(new Bubble(Colour.GREEN, pos5), pos5);

        //B B R
        //R B G
    }

    /**
     * Allows you to set up a board with selected bubbles
     */
    public void setUp3() {
        board = new Board(3, 3);
        Position pos = new Position(0, 0);
        board.put(new Bubble(Colour.BLUE, pos), pos);

        Position pos1 = new Position(0, 1);
        board.put(new Bubble(Colour.YELLOW, pos1), pos1);

        Position pos2 = new Position(0, 2);
        board.put(new Bubble(Colour.YELLOW, pos2), pos2);
        Position pos3 = new Position(1, 0);
        board.put(new Bubble(Colour.RED, pos3), pos3);

        Position pos4 = new Position(1, 1);
        board.put(new Bubble(Colour.RED, pos4), pos4);

        Position pos5 = new Position(1, 2);
        board.put(new Bubble(Colour.BLUE, pos5), pos5);

        Position pos6 = new Position(2, 0);
        board.put(new Bubble(Colour.RED, pos6), pos6);

        Position pos7 = new Position(2, 1);
        board.put(new Bubble(Colour.GREEN, pos7), pos7);

        Position pos8 = new Position(2, 2);
        board.put(new Bubble(Colour.GREEN, pos8), pos8);

    }

    /**
     * Allows you to set up a board with selected bubbles
     */
    public void setUp4() {
        board = new Board(3, 3);

        Position pos = new Position(0, 0);
        board.put(new Bubble(Colour.BLUE, pos), pos);

        Position pos1 = new Position(0, 1);
        board.put(new Bubble(Colour.YELLOW, pos1), pos1);

        Position pos2 = new Position(0, 2);
        board.put(new Bubble(Colour.YELLOW, pos2), pos2);
        Position pos3 = new Position(1, 0);
        board.put(new Bubble(Colour.BLUE, pos3), pos3);

        Position pos4 = new Position(1, 1);
        board.put(new Bubble(Colour.RED, pos4), pos4);

        Position pos5 = new Position(1, 2);
        board.put(new Bubble(Colour.BLUE, pos5), pos5);

        Position pos6 = new Position(2, 0);
        board.put(new Bubble(Colour.BLUE, pos6), pos6);

        Position pos7 = new Position(2, 1);
        board.put(new Bubble(Colour.GREEN, pos7), pos7);

        Position pos8 = new Position(2, 2);
        board.put(new Bubble(Colour.GREEN, pos8), pos8);

    }

    /**
     * Allows you to set up a board with selected bubbles
     */
    public void setUp5() {
        board = new Board(4, 3);
        Position pos = new Position(0, 0);
        board.put(new Bubble(Colour.RED, pos), pos);

        Position pos1 = new Position(0, 1);
        board.put(new Bubble(Colour.BLUE, pos1), pos1);

        Position pos2 = new Position(0, 2);
        board.put(new Bubble(Colour.BLUE, pos2), pos2);

        Position pos6 = new Position(0, 3);
        board.put(new Bubble(Colour.YELLOW, pos6), pos6);

        Position pos3 = new Position(1, 0);
        board.put(new Bubble(Colour.YELLOW, pos3), pos3);

        Position pos4 = new Position(1, 1);
        board.put(new Bubble(Colour.BLUE, pos4), pos4);

        Position pos5 = new Position(1, 2);
        board.put(new Bubble(Colour.BLUE, pos5), pos5);

        Position pos15 = new Position(1, 3);
        board.put(new Bubble(Colour.YELLOW, pos15), pos15);

        Position pos12 = new Position(2, 0);
        board.put(new Bubble(Colour.RED, pos12), pos12);

        Position pos7 = new Position(2, 1);
        board.put(new Bubble(Colour.BLUE, pos7), pos7);

        Position pos8 = new Position(2, 2);
        board.put(new Bubble(Colour.BLUE, pos8), pos8);
        Position pos13 = new Position(2, 3);
        board.put(new Bubble(Colour.GREEN, pos13), pos13);
    }

    /**
     * Test of play method, of class Board.
     */
    @Test
    public void test_play_normalCase() {
        setUp();

        board.play(0, 0);
        boolean[][] tab = {{true, true, false}};

        assertArrayEquals(board.getVisited(), tab);

    }

    /**
     * Test of play method, of class Board.
     */
    @Test
    public void test_play_bubbleAlone() {
        setUp();
        board.play(0, 2);
        // no effect on the state of the bubbles
        boolean[][] tab = {{false, false, false}};

        assertArrayEquals(board.getVisited(), tab);

    }

    /**
     * Test of play method, of class Board.
     */
    @Test
    public void test_play_severalBubbleDelete() {
        setUp2();

        board.play(0, 0);
        boolean[][] tab = {{true, true, false},
        {false, true, false}};
        assertArrayEquals(board.getVisited(), tab);

    }

    /**
     * Test of play method, of class Board.
     */
    @Test
    public void testPlay_positionOutSide() {
        setUp2();
        board.play(0, 0);

        assertThrows(IllegalArgumentException.class,
                () -> {
                    board.play(10, 10);
                });
    }

    /**
     * Test of play method, of class Board.
     */
    @Test
    public void testPlay_noBubble() {
        setUp();
        board.play(0, 0);
        board.downBubbles();
        board.checkColownEmpty();
        board.play(0, 2);

        assertEquals(false, board.isBubblePresent(new Position(0, 2)));

    }

    /**
     * Test of downBubbles method, of class Board.
     */
    @Test
    public void testDownBubbles_noEffect() {
        setUp();
        board.play(0, 0);
        board.downBubbles();
        boolean[][] tab = {{true, true, false}};

        assertArrayEquals(tab, board.getVisited());

    }

    /**
     * Test of downBubbles method, of class Board.
     */
    @Test
    public void testDownBubbles_normalCase() {
        setUp3();
        board.play(1, 0);
        board.downBubbles();

        boolean[][] tab = {{true, true, false}, {true, false, false},
        {false, false, false}};

        assertArrayEquals(tab, board.getVisited());
    }

    /**
     * Test of downBubbleColown method, of class Board.
     */
    @Test
    public void testDownBubbleColown() {
        setUp3();
        board.play(2, 2);
        board.downBubbles();
        boolean[][] stateBubbles = {{false, true, true},
        {false, false, false}, {false, false, false}};
        assertArrayEquals(stateBubbles, board.getVisited());

    }

    /**
     * Test of calculateScore method, of class Board.
     */
    @Test
    public void testCalculateScore() {
        setUp3();
        board.play(2, 2);
        board.downBubbles();
        board.checkColownEmpty();
        int score = 2;

        assertEquals(score, board.getScore());
    }

    /**
     * Test of calculateScore method, of class Board.
     */
    @Test
    public void testCalculateScore_case2() {
        setUp3();
        board.play(1, 1);
        board.downBubbles();
        board.checkColownEmpty();
        int score = 6;

        assertEquals(score, board.getScore());
    }

    /**
     * Test of calculateScore method, of class Board.
     */
    @Test
    public void testCalculateScore_caseNoEffectScore() {
        setUp3();
        board.play(0, 0);
        board.downBubbles();
        board.checkColownEmpty();
        int score = 0;

        assertEquals(score, board.getScore());
    }
    /**
     * Test of calculateScore method, of class Board.
     */
    @Test
    public void testCalculateScore_twoShotsPlayed() {
        setUp5();
        board.play(0, 1);
        board.downBubbles();
        board.checkColownEmpty();
        board.play(1, 0);
        board.downBubbles();
        board.checkColownEmpty();
        int score = 36;

        assertEquals(score, board.getScore());
    }

    /**
     * Test of isInside method, of class Board.
     */
    @Test
    public void testIsInside() {
        setUp();

        boolean expResult = false;
        assertEquals(expResult, board.isInside(7, 0));
    }

    /**
     * Test of isInside method, of class Board.
     */
    @Test
    public void testIsInside_case2() {
        board = new Board(2, 2);

        assertEquals(true, board.isInside(1, 0));
    }

    /**
     * Test of isInside method, of class Board.
     */
    @Test
    public void testIsInside_limtCase() {
        board = new Board(3, 3);

        assertEquals(true, board.isInside(2, 2));
    }

    /**
     * Test of checkColownEmpty method, of class Board.
     */
    @Test
    public void testCheckColownEmpty() {
        setUp4();
        board.play(0, 0);
        board.downBubbles();
        board.checkColownEmpty();

        boolean[][] tab = {{false, false, true}, {
            false, false, true}, {false, false, true}};

        assertArrayEquals(board.getVisited(), tab);
    }

    /**
     * Test of moveColumnsToLeft method, of class Board.
     */
    @Test
    public void testMoveColumnsToLeft_case2() {
        setUp();
        board.play(0, 0);
        board.downBubbles();
        board.checkColownEmpty();

        boolean[][] tab = {{false, true, true}};

        assertArrayEquals(board.getVisited(), tab);

    }

    /**
     * Test of moveColumnsToLeft method, of class Board.
     */
    @Test
    public void testMoveColumnsToLeft_case3_twoColownEmpty() {
        setUp5();
        board.play(0, 1);
        board.downBubbles();
        board.checkColownEmpty();

        boolean[][] tab = {{false, false, true, true},
        {false, false, true, true}, {false, false, true, true}};

        assertArrayEquals(board.getVisited(), tab);

    }

    /**
     * Test of moveColumnsToLeft method, of class Board.
     */
    @Test
    public void testMoveColumnsToLeft_case4_noColumnEmpty() {
        setUp3();
        board.play(2, 0);
        board.downBubbles();
        board.checkColownEmpty();

        boolean[][] tab = {{true, true, false},
        {true, false, false}, {false, false, false}};

        assertArrayEquals(board.getVisited(), tab);

    }

    /**
     * Test of isGameOver method, of class Board.
     */
    @Test
    public void testGameOver() {
        setUp4();
        board.play(0, 0);
        board.downBubbles();
        board.checkColownEmpty();
        board.play(0, 1);
        board.downBubbles();
        board.checkColownEmpty();
        assertEquals(false, board.isGameOver());

    }

    /**
     * Test of isGameOver method, of class Board.
     */
    @Test
    public void testGameOver_trueCase() {
        setUp4();
        board.play(0, 0);
        board.downBubbles();
        board.checkColownEmpty();
        board.play(0, 1);
        board.downBubbles();
        board.checkColownEmpty();
        board.play(2, 1);
        board.downBubbles();
        board.checkColownEmpty();
        assertEquals(true, board.isGameOver());

    }

    /**
     * Test of isGameOver method, of class Board.
     */
    @Test
    public void testGameOver_trueCase2() {
        setUp();
        board.play(0, 0);
        board.downBubbles();
        board.checkColownEmpty();
        assertEquals(true, board.isGameOver());

    }

    /**
     * Test of checkHaveNeighboursSameColor method, of class Board.
     */
    @Test
    public void testCheckAllNeighbours() {
        setUp4();
        assertEquals(false, board.checkHaveNeighboursSameColor(1, 2));

    }

    /**
     * Test of checkNeighbour method, of class Board.
     */
    @Test
    public void testCheckNeighbour() {
        setUp4();
        assertEquals(true, board.checkHaveNeighboursSameColor(0, 0));

    }

    /**
     * implement a complete game
     */
    public void fullGame() {
        board = new Board(3, 3);

        Position pos = new Position(0, 0);
        board.put(new Bubble(Colour.GREEN, pos), pos);

        Position pos1 = new Position(1, 0);
        board.put(new Bubble(Colour.GREEN, pos1), pos1);

        Position pos2 = new Position(2, 0);
        board.put(new Bubble(Colour.BLUE, pos2), pos2);
        Position pos3 = new Position(0, 1);
        board.put(new Bubble(Colour.BLUE, pos3), pos3);

        Position pos5 = new Position(1, 1);
        board.put(new Bubble(Colour.RED, pos5), pos5);

        Position pos6 = new Position(2, 1);
        board.put(new Bubble(Colour.RED, pos6), pos6);

        Position pos8 = new Position(0, 2);
        board.put(new Bubble(Colour.GREEN, pos8), pos8);

        Position pos9 = new Position(1, 2);
        board.put(new Bubble(Colour.BLUE, pos9), pos9);
        Position pos10 = new Position(2, 2);
        board.put(new Bubble(Colour.BLUE, pos10), pos10);

        board.play(2, 2);
        board.downBubbles();
        board.checkColownEmpty();
        board.play(0, 0);
        board.downBubbles();
        board.checkColownEmpty();
        board.play(1, 1);
        board.downBubbles();
        board.checkColownEmpty();
        board.play(2, 0);
        board.downBubbles();
        board.checkColownEmpty();

    }

    @Test
    public void test_fullGame() {

        fullGame();
        assertEquals(board.isGameOver(), true);

    }

    @Test
    public void test_fullGame_stateBubblesTest() {

        fullGame();
        boolean[][] tab = {{true, true, true},
        {true, true, true},
        {false, true, true}};
        assertArrayEquals(board.getVisited(), tab);

    }
}
