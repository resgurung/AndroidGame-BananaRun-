package cmt3319.BananaRun;


/**
 *  creates the Tiger and keeps track of the tiger position
 */
public class Tiger {
	
	private int x,y;
	public static final int UP = 0, DOWN = 1, RIGHT = 2, LEFT = 3;
	private Hero hero;
    int direction ;
	
	
	/**
	 * 
	 *Constructor passes the the position of hero  
	 */
  
	public Tiger(int x, int y, Hero hero)
	{
		this.x = x;
		this.y = y;
		this.hero = hero;
		this.direction = UP;
		
	}
	
	public int getX(){
		return this.x;
	}
	public int getY(){
		return this.y;
	}
	/**
	 * 	visiblile from world class 
	 */

	void setX(int x){
		this.x=x;
	}
	/**
	 * visiblile from world class
	 * @param y
	 */
	
	void setY(int y){
		this.y=y;
	}
	
	/**
	 *  Tiger AI which keeps track of the player position and moves along
	 */
    public void update()
    {
    
	if(hero.getX() > this.x){
		this.x++;
	}
	else 
		x--;
    
    if(hero.getY() > this.y){
		this.y++;
	}
	else 
		y--;
    
    
    }
    /**
     *  control the movement and collision of the tiger AI
     * @param direction
     */
   
    public void moveTiger(int direction)
	{
		if(direction == RIGHT)
		{
			
		  setX(getX() + 1);
		
		}
		if(direction == LEFT)
		{
			
		setX(getX() - 1);
							
		
		}
		if(direction == UP)
		{
			setY(getY() - 1);
		}
		if(direction == DOWN)
		{
			setY(getY() + 1);
		}
	}
    
    
   
}
