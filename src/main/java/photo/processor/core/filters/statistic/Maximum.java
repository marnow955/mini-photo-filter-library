package photo.processor.core.filters.statistic;

import photo.processor.core.PhotoProcessor;
import photo.processor.core.utils.color.RGB;
import photo.processor.core.utils.color.RgbImage;

import java.awt.image.BufferedImage;

public class Maximum extends PhotoProcessor {

    private RgbImage rgbOriginal;
    private RgbImage rgbResult;
    private int maskWidth;
    private int maskHeight;

    public Maximum() {
        maskWidth = 3;
        maskHeight = 3;
    }

    public Maximum(int maskWidth, int maskHeight) {
        this.maskWidth = maskWidth;
        this.maskHeight = maskHeight;
    }

    @Override
    protected void init(BufferedImage image) {
        this.image = image;
        width = image.getWidth();
        height = image.getHeight();
        rgbOriginal = new RgbImage(this.image);
        rgbResult = new RgbImage(this.image);
    }

    @Override
    protected void transform() {
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                int rmax = 0;
                int gmax = 0;
                int bmax = 0;
                int yCenter = maskHeight/2;
                int xCenter = maskWidth/2;
                for (int h = 0 - yCenter; h < maskHeight - yCenter; h++) {
                    if (y + h < 0 || y + h >= height)
                        continue;
                    for (int w = 0 - xCenter; w < maskWidth - xCenter; w++) {
                        if (x + w < 0 || x + w >= width)
                            continue;
                        int r = rgbOriginal.getRGB(x + w, y + h).getRed();
                        if (r > rmax)
                            rmax = r;
                        int g = rgbOriginal.getRGB(x + w, y + h).getGreen();
                        if (g > gmax)
                            gmax = g;
                        int b = rgbOriginal.getRGB(x + w, y + h).getBlue();
                        if (b > bmax)
                            bmax = b;
                    }
                }
                rgbResult.setRGB(x, y, new RGB(rmax, gmax, bmax));
            }
        }
        resultImg = rgbResult.toBufferedImage();
    }
}
