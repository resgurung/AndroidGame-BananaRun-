package cmt3319.BananaRun;

//import android.app.Activity;
//import android.os.Bundle;
/**
 * 
 * 
 * Student number: M00351442
 * @author Resham Gurung
 * @Date   29/04/2014
 * This is the main class for this Android game
 * which setup the loading screen
 */
import cmt3319.gameframework.Screen;
import cmt3319.gameframework.impl.AndroidGame;
/**
 * 
 * @author Resham gurung
 * M00351442
 * 29/04/2014
 *
 *
 *Main class for mrNom game which starts the loading screen
 */
public class MrNomGame extends AndroidGame {

    public Screen getStartScreen() {
        return new LoadingScreen(this); 
    }
}