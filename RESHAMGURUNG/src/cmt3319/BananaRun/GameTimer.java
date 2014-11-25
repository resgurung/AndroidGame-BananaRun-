package cmt3319.BananaRun;
/**
 *  GameTimer sets the time for each level
 * This class implements runnaable
 *
 */

public class GameTimer implements Runnable {
	public  double second =59.0;
	public boolean running = true;

	@Override
	public void run() {
		while(running)
		{
			try{
				second--;
				Thread.sleep(1000);
				
			}
			catch(Exception e)
			{
				
			}
		}

				
	}
	public void pauseTimer ()
	{
		running = false;
	}
	public void resumeTimer()
	{
		running = true;
	}
	

}
