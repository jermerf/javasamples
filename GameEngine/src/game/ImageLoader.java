package game;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ImageLoader {
    private String[] imageAssets = {
            "error",
            "asteroid",
            "dragon"
    };
    private BufferedImage[] loadedImages = new BufferedImage[imageAssets.length];

    public ImageLoader(){
        try {
            for(int i=0; i<imageAssets.length; i++) {
                String name = imageAssets[i];
                loadedImages[i] = ImageIO.read(new File(name + ".png"));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public BufferedImage getImage(String name){
        for(int i=0; i<imageAssets.length; i++){
            if(name.equals(imageAssets[i])){
                return loadedImages[i];
            }
        }
        return loadedImages[0];
    }

}
