package graphics;

import javax.imageio.ImageIO;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * Clase encargada de importar desde el ordenador los recursos del juego
 */
public class Loader {
    /**
     * Cargador de imagenes
     * @param path : path de la imagen
     * @return la imagen cargada
     */
    public static BufferedImage imageLoader(String path){
        try {
            return ImageIO.read(Loader.class.getResource(path));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Cargador de sonidos
     * @param path : path del sonido
     * @return el sonido cargado
     */
    public static Clip soundLoader(String path){
        try {
            Clip clip = AudioSystem.getClip();
            clip.open(AudioSystem.getAudioInputStream(Loader.class.getResource(path)));
            return clip;
        } catch (LineUnavailableException | IOException | UnsupportedAudioFileException e){
            e.printStackTrace();
        }
        return null;
    }
}
