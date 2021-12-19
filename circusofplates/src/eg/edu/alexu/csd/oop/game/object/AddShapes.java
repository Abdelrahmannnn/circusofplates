package eg.edu.alexu.csd.oop.game.object;

import eg.edu.alexu.csd.oop.game.GameObject;

import java.util.List;

public class AddShapes {
    public AddShapes() {

    }
    public void addGifts(List<GameObject> moving , int level ,int width ,int height){
        for(int i= moving.size() ; i < 30*level ;i++){
            moving.add(new Gift((int) (Math.random() * width), -1 * (int) (Math.random() * height), "res\\gift" + (i % 5 + 1) + ".png"));
        }
    }
}
