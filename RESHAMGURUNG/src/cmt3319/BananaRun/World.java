package cmt3319.BananaRun;

import java.util.Random;



/**
 * The world class controls the playing Environment  
 * 
 *
 */
public class World {
    static final int  WORLD_WIDTH = 10;
    static final int  WORLD_HEIGHT = 15;
    static final int  SCORE_INCREMENT = 5;
    static final float TICK_INITIAL = 0.5f;
    static final float TICK_DECREMENT = 0.05f;

    public HeroMovement mover;
    public GameTimer time;
    public Thread thread;
    public Stain stain;
    public Maze maze;
    public Hero  hero;
    public Tiger tiger;

    public BigMonkey bigMonkey;
    public PlaceBanana placeBanana;
    public House house;
    public boolean gameOver = false;
    public boolean gameWin = false;
    public int score = 0;
    public int lives = 2;
    public int numOfCollecBanana = 0 ;
    public boolean activateHouse = false;
    public boolean resetScene = false;
    public boolean detect = false;
  

    boolean fields[][] = new boolean[WORLD_WIDTH][WORLD_HEIGHT];
    Random random = new Random();
    float tickTime = 0;
    static float tick = TICK_INITIAL;
    public int currentLevel = 1;
 
  /**
   *  Draws everything that will be used in the game and also the playing Environment  
   */
    public World() {
    	
    	
    		mover = new HeroMovement();
            maze = new Maze(1);
            
            hero = new Hero(5,5);
            time = new GameTimer();
            thread = new Thread(time);
            tiger = new Tiger(9,2, hero);
   
            bigMonkey = new BigMonkey(2,2);
            placeBanana = new PlaceBanana(1);
            house = new House(2,6);
            placeEnviroment();   
        
    }
   
 /**
  *  Initialises the world width and height and also the game Maze
  */
    private void placeEnviroment() {
        for (int x = 0; x < WORLD_WIDTH; x++) {
            for (int y = 0; y < WORLD_HEIGHT; y++) {
                fields[x][y] = false;
            }
        }

  
        
        int length = maze.parts.size();
        for (int i = 0; i < length; i++) {
            MazePart part = maze.parts.get(i);
            fields[part.getX()][part.getY()] = true;
        }

        int stainX = random.nextInt(WORLD_WIDTH);
        int stainY = random.nextInt(WORLD_HEIGHT);
        while (true) {
            if (fields[stainX][stainY] == false)
                break;
            stainX += 1;
            if (stainX >= WORLD_WIDTH) {
                stainX = 0;
                stainY += 1;
                if (stainY >= WORLD_HEIGHT) {
                    stainY = 0;
                }
            }
        }
        stain = new Stain(stainX, stainY, random.nextInt(3));
    }
    // resets the scene if the current level changes
    
    public void resetScene()
    {

        maze = new Maze(2);
        hero = new Hero(9,2);
        time = new GameTimer();
        thread = new Thread(time);
        tiger = new Tiger(9,14,hero);

        bigMonkey = new BigMonkey(2,10);
        placeBanana = new PlaceBanana(2);
        activateHouse = false;
        house = new House(9,2);
        placeEnviroment();  
        time = new GameTimer();
        thread = new Thread(time);
        thread.start();
        
    }
    /**
     *  Controls player movement and collision
     * @param direction
     */
    public void move(int direction)
	{
    	
    	
		if(direction == Hero.RIGHT)
		{
		  if(hero.getX() < 9 &&(fields[hero.getX()+1][hero.getY()] == false))	
		  {
			  hero.setX(hero.getX() + 1);
		  }
		}
		if(direction == Hero.LEFT)
		{
			if(hero.getX() > 0 &&(fields[hero.getX()-1][hero.getY()] == false))
			{
				hero.setX(hero.getX() - 1);
			}
				
			
		}
		if(direction == Hero.UP)
		{
			if (fields[hero.getX()][ hero.getY()-1] == false)
			  {
				  hero.setY( hero.getY() - 1);
			  }
		}
		if(direction == Hero.DOWN)
		{
		  if (fields[ hero.getX()][ hero.getY()+1] == false)
		  {
			  hero.setY( hero.getY() + 1);
		  }
		}
	}
    /**
     *  Controls Tiger movement and collision
     * @param direction
     */
    public void moveTiger( int direction){
    	if(direction ==Tiger.RIGHT)	
    	{
    		 if(tiger.getX() < 3 &&(fields[tiger.getX()+1][tiger.getY()] == false))	
    		  {
    			  tiger.setX(tiger.getX() +1 );
    		  }
    		 
    	}
    	if(direction == Tiger.LEFT)
    	{
    		if(tiger.getX() > 0 &&(fields[tiger.getX()-1][tiger.getY()] == false))
    		{
    			tiger.setX(tiger.getX() - 1);
    		}
    		
    	}
    	if(direction ==Tiger.UP){
    		if (fields[tiger.getX()][ tiger.getY()-1] == false)
    		  {
    			  tiger.setY( tiger.getY() - 1);
    		  }
    		 
    	}
    	
    	if(direction ==Tiger.DOWN){
    		if (fields[ tiger.getX()][ tiger.getY()+1] == false)
    		  {
    			  tiger.setY( tiger.getY() + 1);
    		  }
    		 
    	}
    	}
   
    
 /**
  *  This method updates the states of the game and keeps track of the game level   
  * @param deltaTime
  */
    public void update(float deltaTime) {
       
    	
    	if(currentLevel == 1)
       {
    	   if (gameOver)
               return;

          
    	   tickTime += deltaTime;
           
           while (tickTime > tick) {
               tickTime -= tick;
               tiger.update();
               
               moveTiger(currentLevel);

               
               if( hero.getX() == tiger.getX() && hero.getY() == tiger.getY())
               {
               	hero.resetPosition(1);
               	lives -= 1;
               }
              
              
               
               int len = placeBanana.banana.size();
            
               
               for(int i = 0; i< len; i++)
               {
               	Banana banana = placeBanana.banana.get(i);
               	//if eaten banana then they get extra time by 6 sec
               	if(( hero.getX() == banana.x && hero.getY() == banana.y) && (banana.collected == false))
               	{
               		time.second +=6;
               		score += SCORE_INCREMENT;
               		banana.collected = true;
               		numOfCollecBanana ++;
               	}
               }
               if (numOfCollecBanana == 4)
               {
               	activateHouse = true;
               	
               }
               //give life when its 7 banana to carry on to next level
               if(numOfCollecBanana == 3){
            	   lives +=1;
            	   if(lives >=2 ){
            		   lives = 2;
            	   }
               }
               if(( hero.getX() == house.x && hero.getY() == house.y)&&(activateHouse == true))
               {
            	    currentLevel = 2;
                  	resetScene = true; 
                     
               }
               if(time.second <= 0.00)
               {
               	gameOver = true;
               }
               if(lives <= 0)
               {
               	gameOver = true;
               }
               
               if (gameOver == true)
               {
               	time.second = 0.00;
               	
               }

           }
       }
       
       else if(currentLevel == 2)
       {
    	   
  
    	  	 
    	   
  
    	   if (gameOver)
               return;
    	   
    
           
           tickTime += deltaTime;
           
           while (tickTime > tick) {
               tickTime -= tick;
               tiger.update();
                moveTiger(currentLevel);
 
               bigMonkey.moveAround();

    		
            
            if( hero.getX() == bigMonkey.x && hero.getY() == bigMonkey.y)
            {
            	hero.resetPosition(2);
            	lives -= 1;
            }
            
           
               
               if(hero.getX() == tiger.getX() && hero.getY() == tiger.getY())
               {
               	hero.resetPosition(2);
               	lives -= 1;
               }
            
               
               int len = placeBanana.banana.size();
              
               
              
               for(int i = 0; i< len; i++)
               {
               	Banana banana = placeBanana.banana.get(i);
               	//if eaten banana then they get extra time by 6 sec
               	if(( hero.getX() == banana.x && hero.getY() == banana.y) && (banana.collected == false))
               	{
               		time.second +=4;
               		score += SCORE_INCREMENT;
               		banana.collected = true;
               		numOfCollecBanana ++;
               	}
               }
               //1 life for 9 banana 
               if(numOfCollecBanana == 4){
            	   lives +=1;
            	   if(lives >=2 ){
            		   lives = 2;
            	   }
            	   //life wont exceed after 2
               }
               if (numOfCollecBanana == 6)
               {
               
            	   gameWin = true;
            	  
               }
               if(gameWin ==true){
            	 	time.second = 0.00; 
               }
               
               if(time.second <= 0.00)
               {
               	gameOver = true;
               }
               if(lives <= 0)
               {
               	gameOver = true;
               }
               
               if (gameOver == true)
               {
               	time.second = 0.00;
               	
               }
               if(resetScene == true)
               {
            	   resetScene();
            	   resetScene = false;
               }

        
           }
       }
    }
}
