package g56387.atl.samegame.util;

/**
 * Maintains a list of observer and notifies them whenever an internal stage
 * changed
 *
 * @author mohamed
 */
public interface Observable {

    /**
     * Adds an observer to the list.
     *
     * @param observer the observer to be added.
     */
    void addObserver(Observer observer);

    /**
     * Removes the observer to the list.
     *
     * @param observer The observer to be removed.
     */
    void removeObserver(Observer observer);

    /**
     * Notifies all observers by calling their 'update' method.
     *
     * @param args
     */
    void notifyObservers(Object args);

}
