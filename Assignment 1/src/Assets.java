import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Assets {

    private static final String IMAGE_DIR = "file:src/pics/";


    // A Map to store which image belongs to which object (or class)
    // Easy to lookup images (value) given object (key)
    private static final Map<Object, BufferedImage> objectImage = new HashMap<>();

    public Assets() throws IOException {
        bind(Volvo240.class, "pics/Volvo240.jpg");
        bind(Saab95.class, "pics/Saab95.jpg");
        bind(Scania.class, "pics/Scania.jpg");
    }

    //Methods
    public void bind(Object object, String imageFileName) throws IOException {
        BufferedImage i = getImage(imageFileName);
        if (i != null) {
            objectImage.put(object, i);
        } else {
            throw new IllegalArgumentException("Missing image: " + IMAGE_DIR + imageFileName);
        }
    }

    // Get image for object
    public BufferedImage get(Object object) {
        BufferedImage i = objectImage.get(object);  // Try to find bound object
        if (i == null) {
            return objectImage.get(object.getClass());  // .. if fail, check if class bound
        }
        return i;
    }

    //Helpers
    // ---------- Helpers ------------------------

    private BufferedImage getImage(String fileName) throws IOException {
        return ImageIO.read(Assets.class.getResourceAsStream(fileName));
    }

}
