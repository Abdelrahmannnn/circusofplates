package eg.edu.alexu.csd.oop.game.object;


import java.util.ArrayList;

public class Clown extends Shape implements Subject {
    private ArrayList<Observer> observerList;
    public Clown(int posX, int posY, String path) {
        super(posX, posY, path ,true);
        observerList = new ArrayList<>();
    }
    @Override
    public void registerObserver(Observer o) {
        observerList.add(o);
    }

    @Override
    public void unregisterObserver(Observer o) {
        observerList.remove(observerList.indexOf(o));
    }

    @Override
    public void notifyObservers() {
        observerList.get(0).update(this.getX(),120);
        observerList.get(1).update(this.getX(),-17/2);
    }

}
