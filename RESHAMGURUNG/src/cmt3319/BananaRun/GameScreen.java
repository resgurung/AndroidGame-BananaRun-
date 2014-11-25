package cmt3319.BananaRun;

import java.util.List;

import android.graphics.Color;
import cmt3319.gameframework.*;
import cmt3319.gameframework.Input.TouchEvent;

/**
 *  The GameScreen class sets the GameScreen which inherits screen from Screen.framework
 *
 */
public class GameScreen extends Screen {
    enum GameState {
        Ready,
        Running,
        Paused,
        GameOver,
        GameWin
    }
    
    GameState state = GameState.Ready;
    World world;
    int lastScore = 0;
    String score = "0";
    /**
     * 
     * Constructor which passes Game object
     */
    public GameScreen(Game game) {
        super(game);
        world = new World();
    }
/**
 * update method which gets update all the time
 */
    @Override
    public void update(float deltaTime) {
        List<TouchEvent> touchEvents = game.getInput().getTouchEvents();
        game.getInput().getKeyEvents();
        
        if(state == GameState.Ready)
            updateReady(touchEvents);
        if(state == GameState.Running)
            updateRunning(touchEvents, deltaTime);
        if(state == GameState.Paused)
            updatePaused(touchEvents);
        if(state == GameState.GameOver)
            updateGameOver(touchEvents);
        if(state == GameState.GameWin)
            updateGameWin(touchEvents);   
    }
   /**
    *  
    * this method is only used in this class and updates Gamestate ready, when the state is ready
    * this method change the state into gamestate running
    */
    private void updateReady(List<TouchEvent> touchEvents) {
        if(touchEvents.size() > 0)
        {
        	world.thread.start();
            state = GameState.Running;
             
        }
    }
    /**
     *  
     * This method is only used in this class and updates Gamestate Running, when the state is ready
     * This method is important because of the touch event in the screen which moves the player along x and y axis.
     * 
     */
    private void updateRunning(List<TouchEvent> touchEvents, float deltaTime) {        
        int len = touchEvents.size();
        for(int i = 0; i < len; i++) {
            TouchEvent event = touchEvents.get(i);
            if(event.type == TouchEvent.TOUCH_UP) {
                if(event.x < 64 && event.y < 64) {
                    if(Settings.soundEnabled) 
                        Assets.click.play(1);
                    state = GameState.Paused;
                    
                    return;
                }
            }
            if(event.type == TouchEvent.TOUCH_DOWN) {
                if(event.x < 64 && event.y > 416) {
                    world.mover.turnLeft();
                    world.move(3);
                }
                if(event.x > 256 && event.y > 416) {
                    world.mover.turnRight();
                    world.move(2);
                    
                }
                if((event.x >200 && event.x < 250)  && (event.y >320 && event.y < 440))
                {
                	world.move(1);
                }
                if((event.x >80 && event.x < 150)  && (event.y >350 && event.y < 440))
                {
                	world.move(0);
                }
                
            }
        }
        
        world.update(deltaTime);
        if(world.gameOver) {
            if(Settings.soundEnabled)
                Assets.bitten.play(1);
            state = GameState.GameOver;
        }
        if(world.gameWin) {
            if(Settings.soundEnabled)
                Assets.bitten.play(1);
            state = GameState.GameWin;
        }
        if(lastScore != world.score) {
            lastScore = world.score;
            score = "" + lastScore;
            if(Settings.soundEnabled)
                Assets.eat.play(1);
        }
    }
    /**
     * 
     * Paused method helps to paused the game when pressed from the screen and keep the state
     * until user puts new input 
     */
    private void updatePaused(List<TouchEvent> touchEvents) {
        int len = touchEvents.size();
        for(int i = 0; i < len; i++) {
            TouchEvent event = touchEvents.get(i);
            if(event.type == TouchEvent.TOUCH_UP) {
                if(event.x > 80 && event.x <= 240) {
                    if(event.y > 100 && event.y <= 148) {
                        if(Settings.soundEnabled)
                            Assets.click.play(1);
                       
                        state = GameState.Running;
                        return;
                    }                    
                    if(event.y > 148 && event.y < 196) {
                        if(Settings.soundEnabled)
                            Assets.click.play(1);
                        game.setScreen(new MainMenuScreen(game));                        
                        return;
                    }
                }
            }
        }
    }
    /**
     * 
     * When the player dies then it method is invoked which helps to show game over on the screen
     * it also has a touch event which takes the screen to main screen
     */
    private void updateGameOver(List<TouchEvent> touchEvents) {
        int len = touchEvents.size();
        for(int i = 0; i < len; i++) {
            TouchEvent event = touchEvents.get(i);
            if(event.type == TouchEvent.TOUCH_UP) {
                if(event.x >= 128 && event.x <= 192 &&
                   event.y >= 200 && event.y <= 264) {
                    if(Settings.soundEnabled)
                   
                        Assets.click.play(1);
                    game.setScreen(new MainMenuScreen(game));
                    return;
                }
            }
        }
    }
    /**
     * 
     * When the class world passes gamewin == true then this method is invoked
     * 
     */
    private void updateGameWin(List<TouchEvent> touchEvents){
    	int len  = touchEvents.size();
    	for(int i = 0; i<len; i++){
    		TouchEvent event = touchEvents.get(i);
    		if(event.type == TouchEvent.TOUCH_UP)
    		{
    			if(event.x >= 128 && event.x <= 192 &&
    	                   event.y >= 200 && event.y <= 264) 
    			{
    	                    if(Settings.soundEnabled)
    	                   
    	                        Assets.click.play(1);
    	                    game.setScreen(new MainMenuScreen(game));
    	                    return;
    			}
    			}
    	}
    }

    @Override
    public void present(float deltaTime) {
        Graphics g = game.getGraphics();
        
        g.drawPixmap(Assets.background, 0, 0);
     
        drawWorld(world);
        if(state == GameState.Ready) 
            drawReadyUI();
        if(state == GameState.Running)
        	
            drawRunningUI();
        if(state == GameState.Paused)
            drawPausedUI();
        if(state == GameState.GameOver)
            drawGameOverUI();
        if(state == GameState.GameWin)
            drawGameWinUI();
        
        
        
        drawText(g, score, 280 , 0); 
    }
   

	/**
     * This method draw world is responsible of drawing the playing environment depending of the current game level
     *  world
     */
    private void drawWorld(World world) {
    	int a,b,k,l,x,y;
        Graphics g = game.getGraphics();
        
      
        Maze maze = world.maze;
        Hero hero = world.hero;
        Tiger tigr = world.tiger;
        BigMonkey bigMonkey = world.bigMonkey;
        PlaceBanana placeBanana = world.placeBanana;
        House house = world.house;
        
        int length = maze.parts.size();
        for(int z = 0; z< length; z++)
        {
        	MazePart part = maze.parts.get(z);
        	 x = part.getX() * 32;
        	 y = part.getY() * 32;
        	g.drawPixmap(Assets.obstacle,x,y);
        }
        
        length = placeBanana.banana.size();
        for(int d =0; d < length; d++)
        {
        	Banana banana = placeBanana.banana.get(d);
        	 x = banana.x * 32;
        	 y = banana.y * 32;
        	if(banana.collected == false)
        	{
        		g.drawPixmap(Assets.banana, x, y);
        	}
        	
        	
        }
       if(world.activateHouse == true)
        {
            x = house.x * 32;
            y = house.y * 32;
           g.drawPixmap(Assets.house, x, y);
        }
        
         k = tigr.getX() * 32;
         l = tigr.getY() * 32;
        g.drawPixmap(Assets.tiger, k, l);
        
       
        if(world.currentLevel == 2)
        {
        	k = bigMonkey.x * 32;
        	l = bigMonkey.y * 32;
        	g.drawPixmap(Assets.bigMonkey, k, l);
        	
        	
        
        }
                
        
         a = hero.getX() * 32;
         b = hero.getY() * 32;
        g.drawPixmap(Assets.hero, a, b);
        
        
        
        if(world.lives == 2)
        {
        	g.drawPixmap(Assets.heroIcon, 60, 5);
            g.drawPixmap(Assets.heroIcon, 80, 5);
        }
        if(world.lives == 1)
        {
        	g.drawPixmap(Assets.heroIcon, 60, 5);
            
        }
       
     
      g.drawPixmap(Assets.bluebar, 110, 5, 0, 0,(int) (world.time.second/59* 150 ), 20);
    }
    
    private void drawReadyUI() {
        Graphics g = game.getGraphics();
        
        g.drawPixmap(Assets.ready, 47, 100);
        g.drawLine(0, 416, 480, 416, Color.BLACK);
    }
    
    private void drawRunningUI() {
        Graphics g = game.getGraphics();

        g.drawPixmap(Assets.buttons, 0, 0, 64, 128, 64, 64);
        //g.drawLine(0, 416, 480, 416, Color.BLACK);
        g.drawPixmap(Assets.buttons, 0, 416, 64, 64, 64, 64);
        g.drawPixmap(Assets.buttons, 256, 416, 0, 64, 64, 64);
        g.drawPixmap(Assets.buttonUp, 80, 380);
        g.drawPixmap(Assets.buttonDown, 180, 380);
    }
    
    private void drawPausedUI() {
        Graphics g = game.getGraphics();
        
        g.drawPixmap(Assets.pause, 80, 100);
        g.drawLine(0, 416, 480, 416, Color.BLACK);
    }

    private void drawGameOverUI() {
        Graphics g = game.getGraphics();
        
        g.drawPixmap(Assets.gameOver, 62, 100);
        g.drawPixmap(Assets.buttons, 128, 200, 0, 128, 64, 64);
        g.drawLine(0, 416, 480, 416, Color.BLACK);
    }
    private void drawGameWinUI() {
        Graphics g = game.getGraphics();
       
       g.drawPixmap(Assets.GameWin, 62, 100);
       g.drawPixmap(Assets.buttons, 128, 200, 0, 128, 64, 64);
       g.drawLine(0, 416, 480, 416, Color.BLACK);
		
	}
    
    public void drawText(Graphics g, String line, int x, int y) {
        int len = line.length();
        for (int i = 0; i < len; i++) {
            char character = line.charAt(i);

            if (character == ' ') {
                x += 20;
                continue;
            }

            int srcX = 0;
            int srcWidth = 0;
            if (character == '.') {
                srcX = 200;
                srcWidth = 10;
            } else {
                srcX = (character - '0') * 20;
                srcWidth = 20;
            }

            g.drawPixmap(Assets.numbers, x, y, srcX, 0, srcWidth, 32);
            x += srcWidth;
        }
    }
    
    @Override
    public void pause() {
        if(state == GameState.Running)
            state = GameState.Paused;
        
        if(world.gameOver) {
            Settings.addScore(world.score);
            Settings.save(game.getFileIO());
        }
    }

    @Override
    public void resume() {
        
    }

    @Override
    public void dispose() {
        
    }
}