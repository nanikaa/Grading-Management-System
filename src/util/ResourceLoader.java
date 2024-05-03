package util;

import javax.swing.ImageIcon;

public class ResourceLoader {

    public static ImageIcon loadImage(String imagePath) {
        ClassLoader classLoader = ResourceLoader.class.getClassLoader();
        java.net.URL imageURL = classLoader.getResource(imagePath);
        if (imageURL == null) {
            System.err.println("Resource not found: " + imagePath);
            return null;
        } else {
            return new ImageIcon(imageURL);
        }
    }
}

