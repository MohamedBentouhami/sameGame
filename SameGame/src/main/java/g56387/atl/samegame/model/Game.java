package g56387.atl.samegame.model;

import g56387.atl.samegame.util.Observable;
import g56387.atl.samegame.util.Observer;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Contains different methods related to the Same game, it allows you to play a
 * complete game and it allows to calculate the score and check if the game is
 * over.
 *
 * @author mohamed
 */
public class Game implements Model, Observable {

    private Board board;
    private int level;
    private List<Observer> observer;

    /**
     * A simple constructor of Game class
     *
     * @param board the board of the game
     * @param level the difficult of the game
     */
    public Game(Board board, int level) {

        if (level != 3 && level != 4 && level != 5) {
            throw new IllegalArgumentException("Level incorrect");

        }
        this.board = board;
        this.level = level;
        this.observer = new ArrayList<>();

    }

    @Override
    public void start() {

        for (int i = 0; i < this.board.getWidth(); i++) {
            for (int j = 0; j < this.board.getHeigth(); j++) {
                Position pos = new Position(i, j);
                Bubble bubble = new Bubble(generateRandomColor(), pos);
                board.put(bubble, pos);

            }

        }
    }

    @Override
    public Board getBoard() {
        return board;
    }

    @Override
    public boolean isGameOver() {
        boolean gameOver = board.isGameOver();

        if (gameOver) {
            notifyObservers("gameOver");
            return true;
        }

        return false;
    }

    @Override
    public void play(Position pos) {
        board.play(pos.getRow(), pos.getColumn());
        downBubbles();
        moveColownEmpty();
        notifyObservers(board);

    }

    /**
     * allows the bubbles to be lowered if those bubbles below are visited
     *
     */
    private void downBubbles() {

        board.downBubbles();

    }

    /**
     * allows you to move a column if one or more columns to its left are empty
     *
     */
    private void moveColownEmpty() {

        board.checkColownEmpty();

    }

    @Override
    public boolean bubbleIsAlone(Position pos) {
        return !board.checkHaveNeighboursSameColor(pos.getRow(), pos.getColumn());
    }

    @Override
    public boolean isBubblePresent(Position pos) {

        return board.isBubblePresent(pos);
    }

    @Override
    public int getScore() {

        notifyObservers("score");
        return board.getScore();
    }

    @Override
    public void addObserver(Observer obs) {

        this.observer.add(obs);

    }

    @Override
    public void removeObserver(Observer obs) {
        this.observer.remove(obs);

    }

    private Colour generateRandomColor() {
        int pick = new Random().nextInt(this.level);

        return Colour.values()[pick];
    }

    @Override
    public void setState(GameState oldState) {
        getBoard().setState(oldState);
        notifyObservers(board);

    }

    @Override
    public void notifyObservers(Object args) {
        for (Observer obs : observer) {
            obs.update(args);

        }
    }

}
