package cmt3319.BananaRun;

import java.util.ArrayList;
import java.util.List;
/**
 * 
 * This class helps the player to move along the grid
 *
 */


public class HeroMovement {
	    public static final int UP = 0;
	    public static final int LEFT = 1;
	    public static final int DOWN = 2;
	    public static final int RIGHT = 3;
	    
	    public List<EatFood> parts = new ArrayList<EatFood>();
	    public int direction;    
	  /**
	   * constructor  
	   */
	    public HeroMovement(){        
	        direction = UP;
	        parts.add(new EatFood(5, 6));
	        parts.add(new EatFood(5, 7));
	        parts.add(new EatFood(5, 8));
	    }
	    /**
	     * turn left
	     */
	    public void turnLeft() {
	        direction += 1;
	        if(direction > RIGHT)
	            direction = UP;
	    }
	    /**
	     * turn right 
	     */
	    public void turnRight() {
	        direction -= 1;
	        if(direction < UP)
	            direction = RIGHT;
	    }
	    /**
	     *  This method Eats the banana
	     */
	    public void eat() {
	        EatFood end = parts.get(parts.size()-1); 
	        parts.add(new EatFood(end.x, end.y));
	    }
	    
	    public void advance() {
	        EatFood head = parts.get(0);               
	        
	        int len = parts.size() - 1;
	        for(int i = len; i > 0; i--) {
	        	EatFood before = parts.get(i-1);
	        	EatFood part = parts.get(i);
	            part.x = before.x;
	            part.y = before.y;
	        }
	        
	        if(direction == UP)
	            head.y -= 1;
	        if(direction == LEFT)
	            head.x -= 1;
	        if(direction == DOWN)
	            head.y += 1;
	        if(direction == RIGHT)
	            head.x += 1;
	        
	        if(head.x < 0)
	            head.x = 9;
	        if(head.x > 9)
	            head.x = 0;
	        if(head.y < 0)
	            head.y = 12;
	        if(head.y > 12)
	            head.y = 0;
	    }
	    
	    public boolean checkBitten() {
	        int len = parts.size();
	        EatFood head = parts.get(0);
	        for(int i = 1; i < len; i++) {
	            EatFood part = parts.get(i);
	            if(part.x == head.x && part.y == head.y)
	                return true;
	        }        
	        return false;
	    }      
}
