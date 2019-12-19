package eg.edu.alexu.csd.oop.game.object;

public class Plate extends Shape implements Observer {
    public Plate(int posX, int posY , String path) {
        super(posX, posY, path ,false);
        setWidth(34);
        setHeight(5);
    }

    @Override
    public void update(int x, int y) {
        this.setX(x-7);
    }
}
