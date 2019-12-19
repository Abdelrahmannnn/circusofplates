package eg.edu.alexu.csd.oop.game;


public class Main {
	public Level level;
    public static void main(String[] args){
    	 View view=View.singleton();
    	    view.beginning();
    	
    }

      public int get_level() {
  		return level.get_level();
      }
}
