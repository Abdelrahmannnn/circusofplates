package eg.edu.alexu.csd.oop.game.object;

public class Gift extends Shape implements Observer {
    public Gift(int posX, int posY , String path) {
        super(posX, posY, path ,false);
        setWidth(38);
        setHeight(30);
    }

    @Override
    public void update(int x, int y) {
        this.setX(x);
    }
}
