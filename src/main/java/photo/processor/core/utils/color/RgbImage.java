package photo.processor.core.utils.color;

import java.awt.*;
import java.awt.image.BufferedImage;

public class RgbImage {

    private RGB[][] colors;
    private int type;

    public RgbImage(BufferedImage image) {
        type = image.getType();
        colors = new RGB[image.getHeight()][image.getWidth()];
        for (int y = 0; y < image.getHeight(); y++)
            for (int x = 0; x < image.getWidth(); x++)
                colors[y][x] = new RGB(new Color(image.getRGB(x, y)));
    }

    public RGB getRGB(int x, int y) {
        return colors[y][x];
    }

    public void setRGB(int x, int y, RGB color) {
        colors[y][x] = color;
    }

    public BufferedImage toBufferedImage() {
        BufferedImage image = new BufferedImage(colors[0].length, colors.length, type);
        for (int y = 0; y < image.getHeight(); y++)
            for (int x = 0; x < image.getWidth(); x++)
                image.setRGB(x, y, colors[y][x].getRGB());
        return image;
    }
}
