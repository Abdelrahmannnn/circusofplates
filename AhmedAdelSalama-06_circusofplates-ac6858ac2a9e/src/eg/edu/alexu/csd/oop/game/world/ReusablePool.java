package eg.edu.alexu.csd.oop.game.world;

import eg.edu.alexu.csd.oop.game.GameObject;
import eg.edu.alexu.csd.oop.game.object.Shape;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class ReusablePool {

    private int num =0;
    private static ReusablePool objectPool = null;
    private ArrayList<GameObject> reuse = new ArrayList<GameObject>();

    private ReusablePool() {

    }

    public static ReusablePool getInstance() {
        if (objectPool == null) {
            objectPool = new ReusablePool();
        }
        return objectPool;

    }

    public void setPool(int width,int height , int num) {
        FlyWeight generate = new FlyWeight(num);
        reuse=generate.createPlates(width, height);
    }

    public GameObject use() {

        if(!hasElement()) {
            return null;
        }
        return (reuse.remove(0));
    }

    public List<GameObject> usePool(){
        Iterator<GameObject> iterator=reuse.iterator();
        List<GameObject> theusedpool= new LinkedList<>();
        while (iterator.hasNext()) {
            Shape o = (Shape) iterator.next();
            theusedpool.add(o);
        }
        reuse.clear();
        return theusedpool;

    }

    public void readd(GameObject obj) {
        reuse.add(obj);
    }

    public boolean hasElement() {
        return(reuse.size()>0);
    }


    public void setNum(int num)
    {
        this.num=num;
    }

}
