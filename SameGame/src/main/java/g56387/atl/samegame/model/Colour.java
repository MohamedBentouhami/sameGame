package g56387.atl.samegame.model;

/**
 * colour enumeration
 *
 * @author mohamed
 */
public enum Colour {
    RED("\033[31m" + "r"),
    GREEN("\033[32m" + "g"),
    BLUE("\033[34m" + "b"),
    YELLOW("\033[33m" + "y"),
    PURPLE("\u001B[35m" + "p"),
    WHITE("\033[37m" + "w");

    public final String code;

    Colour(String code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return code;
    }

}
