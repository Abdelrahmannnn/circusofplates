package eg.edu.alexu.csd.oop.game.object;


import java.util.ArrayList;

public class Surface extends Shape implements Subject , Observer{
    private ArrayList<Observer> observerList;
    public Surface(int posX, int posY, String path) {
        super(posX, posY, path, true);
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
//        int height = ;
        for(int i = 0 ; i < observerList.size() ; i++){
//            Shape shape = (Shape)observerList.get(i-1);
            observerList.get(i).update(this.getX(),this.getY());
        }
    }

    @Override
    public void update(int x, int difference) {
//        Circus circus = Circus.singleton();
        this.setX(x+difference);
//        this.setY(y);
    }
}
