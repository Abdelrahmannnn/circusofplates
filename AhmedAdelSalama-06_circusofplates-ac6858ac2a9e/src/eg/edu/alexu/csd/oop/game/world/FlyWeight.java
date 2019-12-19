package eg.edu.alexu.csd.oop.game.world;

import eg.edu.alexu.csd.oop.game.GameObject;
import eg.edu.alexu.csd.oop.game.object.Gift;
import eg.edu.alexu.csd.oop.game.object.Plate;
import eg.edu.alexu.csd.oop.game.object.Shape;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class FlyWeight {
    ArrayList<GameObject> shapes = new ArrayList<>();
    private static final HashMap classMap = new HashMap<>();
    private int max;

    public FlyWeight(int num) {

        max = 30*num;
    }

    public ArrayList<GameObject> createPlates(int width, int height) {
//        Class giftClass = Gift.class;

        for (int i = 0; i < max/2; ++i) {
//            try {
//                Gift gift = (Gift) giftClass.newInstance();
//                Class giftClass = Class.forName("eg.edu.alexu.csd.oop.game.object.Gift");
//                Gift gift = (Gift) giftClass.newInstance();
//                ClassLoader classLoader = ClassLoader.getSystemClassLoader();
//                Class giftClass = classLoader.loadClass("eg.edu.alexu.csd.oop.game.object.Gift");
//                Object object = giftClass.newInstance();
//                Gift gift = (Gift)object;
//                gift.setWidth(38);
//                gift.setHeight(30);
//                gift.setX((int) (Math.random() * width));
//                gift.setY( -1 * (int) (Math.random() * height));
//                gift.setPath("res\\gift" + (i % 5 + 1) + ".png");
//                gift.setSpriteImages();
//                shapes.add(gift);
//
//            } catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
//                e.printStackTrace();
//            }

            shapes.add(new Plate((int) (Math.random() * width), -1 * (int) (Math.random() * height), "res\\plate" + (i % 5 + 1) + ".png"));

        }
        return shapes;
    }


}

