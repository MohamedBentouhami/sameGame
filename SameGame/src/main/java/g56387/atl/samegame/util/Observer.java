package g56387.atl.samegame.util;

/**
 * Allows to update the Observable to notify it of any changes.
 *
 * @author mohamed
 */
public interface Observer {

    /**
     * This method is called whenever the observed object has changed
     *
     * @param args
     */
    void update(Object args);

}
