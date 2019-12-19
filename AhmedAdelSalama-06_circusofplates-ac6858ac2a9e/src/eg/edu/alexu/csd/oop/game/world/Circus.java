package eg.edu.alexu.csd.oop.game.world;

import eg.edu.alexu.csd.oop.game.GameObject;
import eg.edu.alexu.csd.oop.game.World;
import eg.edu.alexu.csd.oop.game.object.*;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Circus implements World {
//    private static Circus circus;
    private static int MAX_TIME = 60 * 1000;	// 1 minute
     int score = 0;
    private long startTime = System.currentTimeMillis();
    private final int width;
    private final int height;
    private final List<GameObject> constant = new LinkedList<>();
    private List<GameObject> moving = new LinkedList<>();
    private final List<GameObject> control = new LinkedList<>();
    private ArrayList<GameObject> rightstickMoving = new ArrayList<>();
    private ArrayList<GameObject> leftstickMoving = new ArrayList<>();
    private Facade facade;
    private int level=1;
    public Circus(int screenWidth, int screenHeight , int level) {
        width = screenWidth;
        height = screenHeight;
        this.level = level;
        // control objects (clown)
        control.add(new Clown(screenWidth/2, (int)(screenHeight*0.65), "res\\clown3.png"));
        constant.add(new Surface(screenWidth/2+120, (int)(screenHeight*0.65+30), "res\\surface.png"));
        constant.add(new Surface(screenWidth/2-17/2,(int)(screenHeight*0.65+30), "res\\surface.png"));
        rightstickMoving.add(constant.get(0));
        leftstickMoving.add(constant.get(1));
        Clown clown = (Clown)control.get(0);
        clown.registerObserver((Observer) constant.get(0));
        clown.registerObserver((Observer) constant.get(1));
        // moving objects (plates)
        /*for(int i=0; i<100; i++)
            moving.add(new Plate((int)(Math.random() * screenWidth), -1 * (int)(Math.random() * screenHeight) ,"res\\Plate"+(i%5+1)+".png" ));*/
//        for(int i=0; i<10; i++)
//            moving.add(new Gift((int)(Math.random() * screenWidth), -1 * (int)(Math.random() * screenHeight), "C:\\Users\\MetrO\\Desktop\\Discussion\\CircusOfPlates\\res\\Gift"+(i%5+1)+".png" ));

        ReusablePool rp = ReusablePool.getInstance();
        //for level and strategy
       // mpl.setNum(maxNum);
        rp.setPool(width, height ,level);
        moving = rp.usePool();
        facade = new Facade(this);

    }
    private boolean intersect(GameObject o1, GameObject o2){
        return Math.abs((o1.getX()+o1.getWidth()/2) - (o2.getX()+o2.getWidth()/2)) <= o2.getWidth()-7 && (Math.abs(o1.getY()-(o2.getY()-o1.getHeight())) == 0);
    }
    @Override
    public boolean refresh() {
        /*boolean timeout = System.currentTimeMillis() - startTime > MAX_TIME; // time end and game over
        Surface rSurface = (Surface) constant.get(0);
        Surface lSurface = (Surface) constant.get(1);
        Clown clown = (Clown)control.get(0);
        CheckPool();
        clown.notifyObservers();
        ReusablePool pool1 = ReusablePool.getInstance();
        // moving plates
        for(int i = 0 ; i < moving.size() ; i++){
//            Changeable
            Shape m = (Shape) moving.get(i);
            m.setY((m.getY() + 1));
            if(m.getY()==getHeight()){
                // reuse the plate in another position
                m.setY(-1 * (int)(Math.random() * getHeight()));
                m.setX((int)(Math.random() * getWidth()));
            }
            if (!timeout & intersect(m,  rightstickMoving.get(rightstickMoving.size() - 1))) {
                m.setHorizontalOnly(true);
                rightstickMoving.add(m);
                rSurface.registerObserver((Observer) m);
                rSurface.notifyObservers();
                if (rightstickMoving.size() > 3) {
                    Shape temp1 = (Shape) rightstickMoving.get(rightstickMoving.size() - 1);
                    Shape temp2 = (Shape) rightstickMoving.get(rightstickMoving.size() - 2);
                    Shape temp3 = (Shape) rightstickMoving.get(rightstickMoving.size() - 3);
                    for (int k = 1; k <= 5; k++) {
                        if (temp1.getPath().contains(String.valueOf(k))
                                && temp2.getPath().contains(String.valueOf(k))
                                && temp3.getPath().contains(String.valueOf(k))) {
                            score += 10;
                            for (int q = 0; q < 3; q++) {
                                moving.remove(rightstickMoving.get(rightstickMoving.size() - 1));
                                rSurface.unregisterObserver((Observer) rightstickMoving.get(rightstickMoving.size() - 1));
                                pool1.remove(rightstickMoving.get(rightstickMoving.size()-1));
                                rightstickMoving.remove(rightstickMoving.size() - 1);


                            }
                        }
                    }
                }
            }if (!timeout & intersect(m,  leftstickMoving.get(leftstickMoving.size() - 1))) {
                m.setHorizontalOnly(true);
                leftstickMoving.add(m);
                lSurface.registerObserver((Observer) m);
                lSurface.notifyObservers();
                if (leftstickMoving.size() > 3) {
                    Shape temp1 = (Shape) leftstickMoving.get(leftstickMoving.size() - 1);
                    Shape temp2 = (Shape) leftstickMoving.get(leftstickMoving.size() - 2);
                    Shape temp3 = (Shape) leftstickMoving.get(leftstickMoving.size() - 3);
                    for (int k = 1; k <= 5; k++) {
                        if (temp1.getPath().contains(String.valueOf(k))
                                && temp2.getPath().contains(String.valueOf(k))
                                && temp3.getPath().contains(String.valueOf(k))) {
                            score += 10;
                            for (int q = 0; q < 3; q++) {
                                moving.remove(leftstickMoving.get(leftstickMoving.size() - 1));
                                lSurface.unregisterObserver((Observer) leftstickMoving.get(leftstickMoving.size() - 1));
                                pool1.remove(leftstickMoving.get(leftstickMoving.size()-1));
//                                ((Shape) leftstickMoving.get(leftstickMoving.size() - 1)).setHorizontalOnly(false);
                                leftstickMoving.remove(leftstickMoving.size() - 1);

                            }
                        }
                    }
                }
            }
        }
        rSurface.notifyObservers();
        lSurface.notifyObservers();
        return !timeout;*/
        facade.checkPool();
        return facade.refreshAll() ;
    }
//    Change speed according to difficulty
    @Override
    public int getSpeed() {
        return 15/level;
    }
    @Override
    public int getControlSpeed() {
        return 50;
    }
    @Override
    public List<GameObject> getConstantObjects() {
        return constant;
    }
    @Override
    public List<GameObject> getMovableObjects() {
        return moving;
    }
    @Override
    public List<GameObject> getControlableObjects() {
        return control;
    }
    @Override
    public int getWidth() {
        return width;
    }
    @Override
    public int getHeight() {
        return height;
    }
    @Override
    public String getStatus() {
        return "Score=" + score + "   |   Time=" + Math.max(0, (MAX_TIME - (System.currentTimeMillis()-startTime))/1000);	// update status
    }
//    public static Circus singleton(){
//        if(circus==null){
//            return circus = new Circus(1100, 600);
//        }
//        return circus;
//    }

    public List<GameObject> getlstick() {
        return leftstickMoving;
    }

    public List<GameObject> getrstick() {
        return rightstickMoving;
    }


   /* public void CheckPool() {
        ReusablePool a = ReusablePool.getInstance();
        if (a.hasElement()) {
            //State state = new MovableObject();
            GameObject shape = a.use();
            //((ImageObject) obj).setState(state);
            shape.setX((int) (Math.random() * width));
            ((Shape) shape).setHorizontalOnly(false);
            shape.setY(-1 * (int) (Math.random() * height));
            getMovableObjects().add(shape);
        }
    }*/
}


