package g56387.atl.samegame.model;

/**
 * Represent the game Board
 *
 * @author mohamed
 */
public class Board {

    private Bubble[][] bubbles;
    private boolean[][] visited;
    private final int width;
    private final int height;
    private int score;
    private int currentScore;

    /**
     * Simple constructor of Board
     *
     * @param width the width of board
     * @param height the height of board
     */
    public Board(int width, int height) {
        this.width = width;
        this.height = height;
        this.bubbles = new Bubble[this.height][this.width];
        this.visited = new boolean[this.height][this.width];
        this.score = 0;
        this.currentScore = 0;
    }

    /**
     * Allows you to play a move by calling the recursive method to mark all
     * neighbouring bubbles with the same colour of the given position
     *
     * @param i the row of the position given
     * @param j the column of the position given
     */
    public void play(int i, int j) {

        if (!checkHaveNeighboursSameColor(i, j)) {
            System.out.println("The bubble doesn't have a neighbour of the same colour");

        } else {
            Colour currentColor = givenBulleColor(i, j);
            sameColorEffectRec(i, j, currentColor);
            calculateScore();

        }

    }

    /**
     * recursive method that will mark all bubbles belonging to the same region
     * and having the same colour as the given position
     *
     * @param i the row of the position given
     * @param j the column of the position given
     * @param currentColor the colour of the bubble in a given position
     * @return false if the position is out side or the bubble is null or
     * already visited or it is not the same colour as the current colour
     */
    private boolean sameColorEffectRec(int i, int j, Colour currentColor) {

        if (!isInside(i, j) || bubbles[i][j] == null
                || visited[i][j] || !bubbles[i][j].getColor().equals(currentColor)) {
            return false;

        }

        visited[i][j] = true;
        return sameColorEffectRec(i + 1, j, currentColor)
                || sameColorEffectRec(i - 1, j, currentColor)
                || sameColorEffectRec(i, j - 1, currentColor)
                || sameColorEffectRec(i, j + 1, currentColor);

    }

    /**
     * go through the table if a bubble is already visited and we will swap it to
     * the top of the column
     */
    protected void downBubbles() {
        for (int j = 0; j < bubbles[0].length; j++) {
            for (int i = 0; i < bubbles.length; i++) {
                if (visited[i][j]) {
                    downBubbleColown(i, j);
                }

            }
        }

    }

    /**
     * from a given position, swap the positions above it to the top of the
     * column
     *
     * @param x the row of board
     * @param y the column of board
     */
    protected void downBubbleColown(int x, int y) {

        for (int i = x; i > 0; i--) {

            visited[i][y] = visited[i - 1][y];
            bubbles[i][y] = bubbles[i - 1][y];

        }
        visited[0][y] = true;
        bubbles[0][y] = null;

    }

    /**
     * allows to calculate the score and the current score
     */
    protected void calculateScore() {
        currentScore = 0;
        int cpt = 0;
        for (int i = 0; i < visited.length; i++) {
            for (int j = 0; j < visited[0].length; j++) {
                if (bubbles[i][j] != null && visited[i][j]) {
                    cpt++;
                }

            }
        }
        currentScore = cpt * (cpt - 1);
        score += cpt * (cpt - 1);

    }

    /**
     * checks if the position given by x and y is on the board or not
     *
     * @param x The number of rows
     * @param y The number of column
     * @return true if the position is inside the board or false if not
     */
    protected boolean isInside(int x, int y) {

        return y >= 0 && y < width
                && x >= 0 && x < height;

    }

    public Colour givenBulleColor(int x, int y) {

        return bubbles[x][y].getColor();
    }

    public boolean givenStateBubble(int x, int y) {

        return visited[x][y];
    }

    public Bubble givenBubble(int x, int y) {

        return bubbles[x][y];
    }

    /**
     * used for test. Allows you to put a bubble in a position on the board
     *
     * @param bubble
     * @param pos
     */
    protected void put(Bubble bubble, Position pos) {
        this.bubbles[pos.getRow()][pos.getColumn()] = bubble;

    }

    /**
     * Do not check the last column because if it is empty nothing is shifted
     */
    protected void checkColownEmpty() {
        int cpt = 0;
        for (int j = 0; j < visited[0].length - 1; j++) {
            for (int i = 0; i < visited.length; i++) {
                if (visited[i][j]) {
                    cpt++;

                }
                if (cpt == visited.length) {
                    int nextColum = j + 1;
                    while (nextColum < visited[0].length
                            && recheckThenTheMove(i, nextColum)) {
                        nextColum++;
                    }
                    if (nextColum < visited[0].length) {
                        moveColumnsToLeft(j, nextColum);

                    }

                }

            }
            cpt = 0;

        }

    }

    /**
     * allows you to change the position between two columns
     *
     * @param nbColumn One of Column that goes to switch position
     * @param nbColown2 One of Column that goes to switch position
     */
    private void moveColumnsToLeft(int nbColumn, int nbColown2) {

        boolean tmp;
        Bubble tmpBulle;

        for (int i = 0; i < visited.length; i++) {
            tmp = visited[i][nbColumn];
            tmpBulle = bubbles[i][nbColumn];

            visited[i][nbColumn] = visited[i][nbColown2];
            bubbles[i][nbColumn] = bubbles[i][nbColown2];

            visited[i][nbColown2] = tmp;
            bubbles[i][nbColown2] = tmpBulle;

        }

    }

    /**
     * checks if the game is finished or not
     *
     * @return true if the game is over or false is not
     */
    public boolean isGameOver() {

        for (int i = 0; i < bubbles.length; i++) {
            for (int j = 0; j < bubbles[0].length; j++) {

                if (!visited[i][j]) {

                    if (checkHaveNeighboursSameColor(i, j)) {
                        return false;
                    }

                }

            }

        }
        System.out.println("GAME OVER");
        return true;

    }

    /**
     * checks if the bubble in the given position has neighbours of the same
     * colour
     *
     * @param i the number of row
     * @param j the number of column
     * @return
     */
    public boolean checkHaveNeighboursSameColor(int i, int j) {

        if (!isInside(i, j)) {

            throw new IllegalArgumentException("Position outside board");
        }

        return checkNeighbour(bubbles[i][j], i + 1, j)
                || checkNeighbour(bubbles[i][j], i - 1, j)
                || checkNeighbour(bubbles[i][j], i, j + 1)
                || checkNeighbour(bubbles[i][j], i, j - 1);
    }

    private boolean checkNeighbour(Bubble bubble, int x, int y) {

        if (isInside(x, y) && bubbles[x][y] != null) {

            if (bubble.getColor() == givenBulleColor(x, y)) {

                return true;
            }

        }

        return false;

    }

    public boolean isBubblePresent(Position pos) {

        return bubbles[pos.getRow()][pos.getColumn()] != null;

    }

    public boolean[][] getVisited() {

        boolean[][] oldStatBubbles = new boolean[height][width];

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                oldStatBubbles[i][j] = visited[i][j];

            }

        }
        return oldStatBubbles;
    }

    public Bubble[][] getBubbles() {
        Bubble[][] oldBubbles = new Bubble[bubbles.length][bubbles[0].length];

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                oldBubbles[i][j] = bubbles[i][j];

            }

        }
        return oldBubbles;
    }

    public int getHeigth() {

        return bubbles[0].length;
    }

    public int getWidth() {

        return bubbles.length;

    }

    public void setBubbles(Bubble[][] bubbles) {
        this.bubbles = bubbles;
    }

    public void setVisited(boolean[][] visited) {
        this.visited = visited;

    }

    public void setState(GameState oldState) {

        this.bubbles = oldState.getOldBubbles();
        this.visited = oldState.getOldStatBubbles();
        this.score = oldState.getScore();
        this.currentScore = oldState.getOldCurrentScore();

    }

    private boolean recheckThenTheMove(int i, int j) {

        int cpt = 0;
        for (i = 0; i < bubbles.length; i++) {
            if (visited[i][j]) {

                cpt++;
            }

        }
        return cpt == visited.length;
    }

    public int getScore() {
        return score;
    }

    public int getCurrentScore() {
        return currentScore;
    }
   

    public void setScore(int score) {
        this.score = score;

    }
    
    
}
