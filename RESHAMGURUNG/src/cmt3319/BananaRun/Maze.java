package cmt3319.BananaRun;
/**
 * 
 */
import java.util.ArrayList;
import java.util.List;


/**
 * creates the game maze on grid using ArrayList and list 
 
 */
public class Maze {
	public List <MazePart> parts = new ArrayList<MazePart>();
/**
 * initialises the maze positions according to the game level	
 * @param level
 */
	public Maze(int level)
	{
		if(level == 1)
		{
			//top brick
			parts.add(new MazePart(0,1));
			parts.add(new MazePart(1,1));
			parts.add(new MazePart(2,1));
			parts.add(new MazePart(3,1));
			parts.add(new MazePart(4,1));
			parts.add(new MazePart(5,1));
			parts.add(new MazePart(6,1));
			parts.add(new MazePart(7,1));
			parts.add(new MazePart(8,1));
			parts.add(new MazePart(9,1));			
			
			//bottom brick
			
			
			//left brick
			parts.add(new MazePart(0,1));
			parts.add(new MazePart(0,2));
			parts.add(new MazePart(0,3));
			parts.add(new MazePart(0,4));
			parts.add(new MazePart(0,5));
			parts.add(new MazePart(0,6));
			parts.add(new MazePart(0,7));
			parts.add(new MazePart(0,8));
			parts.add(new MazePart(0,9));
			parts.add(new MazePart(0,10));
			parts.add(new MazePart(0,11));
			parts.add(new MazePart(0,12));
			parts.add(new MazePart(0,13));
			parts.add(new MazePart(0,14));
			
		
			parts.add(new MazePart(8,3));
			parts.add(new MazePart(6,4));
			parts.add(new MazePart(1,4));
			parts.add(new MazePart(2,5));
			parts.add(new MazePart(7,6));
			parts.add(new MazePart(6,7));
			parts.add(new MazePart(4,8));
			parts.add(new MazePart(5,9));
			parts.add(new MazePart(6,10));
			parts.add(new MazePart(1,10));
			parts.add(new MazePart(2,11));
			
			//bottom
			parts.add(new MazePart(1,14));
			parts.add(new MazePart(2,14));
			parts.add(new MazePart(3,14));
			parts.add(new MazePart(4,14));
			parts.add(new MazePart(5,14));
			parts.add(new MazePart(6,14));
			parts.add(new MazePart(7,14));
			parts.add(new MazePart(8,14));
			parts.add(new MazePart(9,14));
			
						
		
			
			
		}
		if(level == 2)
			
		{
			
		
			//top brick
			parts.add(new MazePart(0,1));
			parts.add(new MazePart(1,1));
			parts.add(new MazePart(2,1));
			parts.add(new MazePart(3,1));
			parts.add(new MazePart(4,1));
			parts.add(new MazePart(5,1));
			parts.add(new MazePart(6,1));
			parts.add(new MazePart(7,1));
			parts.add(new MazePart(8,1));
			parts.add(new MazePart(9,1));			
			
			//bottom brick
			
			
			//left brick
			parts.add(new MazePart(0,1));
			parts.add(new MazePart(0,2));
			parts.add(new MazePart(0,3));
			parts.add(new MazePart(0,4));
			parts.add(new MazePart(0,5));
			parts.add(new MazePart(0,6));
			parts.add(new MazePart(0,7));
			parts.add(new MazePart(0,8));
			parts.add(new MazePart(0,9));
			parts.add(new MazePart(0,10));
			parts.add(new MazePart(0,11));
			parts.add(new MazePart(0,12));
			parts.add(new MazePart(0,13));
			parts.add(new MazePart(0,14));
			
			
			parts.add(new MazePart(1,14));
			parts.add(new MazePart(2,14));
			parts.add(new MazePart(3,14));
			parts.add(new MazePart(4,14));
			parts.add(new MazePart(5,14));
			parts.add(new MazePart(6,14));
			parts.add(new MazePart(7,14));
			parts.add(new MazePart(8,14));
			parts.add(new MazePart(9,14));
			
			parts.add(new MazePart(1,7));
			parts.add(new MazePart(1,11));
			parts.add(new MazePart(6,11));
			parts.add(new MazePart(7,12));
			parts.add(new MazePart(5,10));
			parts.add(new MazePart(5,7));
			parts.add(new MazePart(6,7));
			parts.add(new MazePart(6,8));
			parts.add(new MazePart(4,9));
			parts.add(new MazePart(4,6));
			parts.add(new MazePart(8,4));
			parts.add(new MazePart(9,4));
			
			
			
			
			
			
		}
	}

}
