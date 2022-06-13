package graphics;

import javax.sound.sampled.Clip;
import java.awt.image.BufferedImage;

public class Assets {

    public static BufferedImage player, gameOver, greyBtn, blueBtn;

    public static Clip playerSound, blockSound;


    public static void init(){
        player = Loader.imageLoader("resources/player2.png");
        gameOver = Loader.imageLoader("resources/gameover.jpg");
        greyBtn = Loader.imageLoader("resources/grey_button00.png");
        blueBtn = Loader.imageLoader("resources/blue_button00.png");

        playerSound = Loader.soundLoader("resources/player.wav");
        blockSound = Loader.soundLoader("resources/block.wav");
    }
}
