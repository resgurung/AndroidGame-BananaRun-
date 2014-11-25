package cmt3319.BananaRun;

/**
 * 
 * Main player class for the Game
 *
 */
public class Hero {

	private int x, y;
	public static final int UP = 0, DOWN = 1, RIGHT = 2, LEFT = 3;
	/**
	 * 
	 *Constructor which passes the position of the player
	 */
	public Hero(int x, int y){
		this.setX(x);
		this.setY(y);
	}
	
	/**
	 * 
	 * After the player dies this sets the position for respawn
	 */
		public void resetPosition(int level)
		{
			if(level == 1)
			{
				setX(2);
				setY(3);
			}
			if(level == 2)
			{
				setX(5);
				setY(5);
			}
			
	}
		/**
		 * 
		 * This method helps the player to move left, right , up and down
		 */
		public void move(int direction)
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
		/**
		 * get x
		 * @return
		 */
		public int getX() {
			return x;
		}
		public void setX(int x) {
			this.x = x;
		}
		/**
		 * get y
		 * @return
		 */
		public int getY() {
			return y;
		}
		public void setY(int y) {
			this.y = y;
		}
}
