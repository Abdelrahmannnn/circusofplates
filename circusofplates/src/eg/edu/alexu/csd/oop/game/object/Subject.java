package eg.edu.alexu.csd.oop.game.object;

public interface Subject {
    void registerObserver(Observer o);
    void unregisterObserver(Observer o);
    void notifyObservers();
}
