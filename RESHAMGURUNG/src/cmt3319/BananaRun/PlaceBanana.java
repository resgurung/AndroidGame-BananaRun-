package cmt3319.BananaRun;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used to store banana in a arrayList 
 */
public class PlaceBanana {
	
	public List <Banana> banana = new ArrayList <Banana>();
	
	/**
	 * 
	 * With the help of ArrayList  this method helps to put banana using banana.add(new banana(2,3));
	 * creating new array of object on the grid
	 */
	public PlaceBanana(int level)
	{
		if(level ==1)
		{
			banana.add(new Banana(3,2));
			banana.add(new Banana(9,3));
			banana.add(new Banana(8,6));
			banana.add(new Banana(9,13));
		
			
		}
		if(level == 2)
		{
			banana.add(new Banana(2,4));
			banana.add(new Banana(7,11));
			banana.add(new Banana(9,7));
			banana.add(new Banana(4,12));
			banana.add(new Banana(4,5));
			banana.add(new Banana(9,3));
		
		}
	}
	

}
