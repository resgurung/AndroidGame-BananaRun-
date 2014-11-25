package cmt3319.BananaRun;

/**
 * 
 * Big monkey class is used in level 2 only
 * the x and y position are set to public for visiblity purpose
 * 
 *
 */
public class BigMonkey {
	public int x,y;
	public static final int UP = 0, DOWN = 1, RIGHT = 2, LEFT = 3;
	public int direction = DOWN;
	public BigMonkey(int x, int y)
	{
		this.x = x;
		this.y = y;
		
	}
	/**
	 * This method hold the artificial intelligence for the Big monkey to move up and down the grid or
	 * the screen
	 */
	public void moveAround()
	{
		
		if(direction == DOWN)
		{
			moveDown();
		}
		
		if(direction == UP)
		{
			moveUp();
		}
	}
	/**
	 * This method moves the big monkey in y direction which is verticle going down
	 */
	public void moveDown(){
		
		y++;
		if(y > 10)
		{
			direction = UP;
		}
		
	 
	}
	/**
	 * This method moves the big monkey upward direction in y axis 
	 */
	public void moveUp()
	{
		y--;
		if(y < 3)
		{
			direction = DOWN;
		}
		
		
	}
	
	
	

}
