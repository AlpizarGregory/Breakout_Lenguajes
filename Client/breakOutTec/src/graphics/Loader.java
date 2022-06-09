package graphics;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Loader {

    public static BufferedImage imageLoader(String path){
        try {
            return ImageIO.read(Loader.class.getResource(path));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
