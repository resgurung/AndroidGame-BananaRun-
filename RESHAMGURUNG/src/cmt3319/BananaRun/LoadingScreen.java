package cmt3319.BananaRun;


import cmt3319.gameframework.*;
import cmt3319.gameframework.Graphics.PixmapFormat;
/**
 * 
 * This class loads the items on the screen
 *
 */
public class LoadingScreen extends Screen {
    public LoadingScreen(Game game) {
        super(game);
    }

    @Override
    public void update(float deltaTime) {
        Graphics g = game.getGraphics();
        Assets.background = g.newPixmap("GreenBackground.png", PixmapFormat.RGB565);      
        //brick 
        Assets.obstacle = g.newPixmap("brick1.png", PixmapFormat.RGB565);
        Assets.bluebar = g.newPixmap("bluebar.png", PixmapFormat.RGB565);
        Assets.hero = g.newPixmap("monkey.png", PixmapFormat.RGB565);
        Assets.tiger = g.newPixmap("tiger.png", PixmapFormat.RGB565);
        Assets.bigMonkey= g.newPixmap("bigmonkey.png", PixmapFormat.RGB565);
        Assets.heroIcon = g.newPixmap("bigmonkey.png", PixmapFormat.RGB565);
        Assets.banana = g.newPixmap("Banana.png", PixmapFormat.RGB565);
        Assets.house = g.newPixmap("House.png", PixmapFormat.RGB565);
        Assets.buttonUp = g.newPixmap("upbutton.png", PixmapFormat.RGB565);
        Assets.buttonDown = g.newPixmap("downbutton.png", PixmapFormat.RGB565);
        Assets.logo = g.newPixmap("Logo.png", PixmapFormat.ARGB4444);
        Assets.mainMenu = g.newPixmap("mainmenu.png", PixmapFormat.ARGB4444);
        Assets.buttons = g.newPixmap("button1.png", PixmapFormat.ARGB4444);
        Assets.help1 = g.newPixmap("help1.png", PixmapFormat.ARGB4444);
        Assets.help2 = g.newPixmap("help2.png", PixmapFormat.ARGB4444);
        Assets.help3 = g.newPixmap("help3.png", PixmapFormat.ARGB4444);
        Assets.numbers = g.newPixmap("numbers.png", PixmapFormat.ARGB4444);
        Assets.ready = g.newPixmap("ready.png", PixmapFormat.ARGB4444);
        Assets.pause = g.newPixmap("pausemenu.png", PixmapFormat.ARGB4444);
        Assets.GameWin = g.newPixmap("GameWin.png", PixmapFormat.ARGB4444);
        Assets.gameOver = g.newPixmap("gameover.png", PixmapFormat.ARGB4444);
        Assets.stain1 = g.newPixmap("stain1.png", PixmapFormat.ARGB4444);
        Assets.stain2 = g.newPixmap("stain2.png", PixmapFormat.ARGB4444);
        Assets.stain3 = g.newPixmap("stain3.png", PixmapFormat.ARGB4444);
        Assets.click = game.getAudio().newSound("click.ogg");
        Assets.eat = game.getAudio().newSound("eat.ogg");
        Assets.bitten = game.getAudio().newSound("bitten.ogg");
        Settings.load(game.getFileIO());
        game.setScreen(new MainMenuScreen(game));
    }

    @Override
    public void present(float deltaTime) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void dispose() {

    }
}