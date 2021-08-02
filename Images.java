import java.awt.Image;
import java.io.File;
import java.io.IOException;

/**
 * Image
 *
 * A helper class that makes it easier to access images from
 * the source folder.
 *
 * @author Quinten Houck
 * @version 8/1/2021
 *
 */

import javax.imageio.ImageIO;

public class Images {
	
	public static Image getImage(String path) {
		Image image = null;
	    try {
            image = ImageIO.read(new File(path));
        } catch (IOException e) {
            e.printStackTrace();
        }
	    return image;
	}
}