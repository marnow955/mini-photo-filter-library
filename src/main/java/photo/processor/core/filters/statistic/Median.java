package photo.processor.core.filters.statistic;

import photo.processor.core.PhotoProcessor;
import photo.processor.core.utils.color.RGB;
import photo.processor.core.utils.color.RgbImage;

import java.awt.image.BufferedImage;
import java.util.Arrays;

public class Median extends PhotoProcessor {

    private RgbImage rgbOriginal;
    private RgbImage rgbResult;
    private int maskWidth;
    private int maskHeight;

    public Median() {
        maskWidth = 3;
        maskHeight = 3;
    }

    public Median(int maskWidth, int maskHeight) {
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
                int count = 0;
                int[] reds = new int[maskHeight*maskWidth];
                int[] greens = new int[maskHeight*maskWidth];
                int[] blues = new int[maskHeight*maskWidth];
                int yCenter = maskHeight/2;
                int xCenter = maskWidth/2;
                for (int h = 0 - yCenter; h < maskHeight - yCenter; h++) {
                    if (y + h < 0 || y + h >= height)
                        continue;
                    for (int w = 0 - xCenter; w < maskWidth - xCenter; w++) {
                        if (x + w < 0 || x + w >= width)
                            continue;
                        reds[count] = rgbOriginal.getRGB(x + w, y + h).getRed();
                        greens[count] = rgbOriginal.getRGB(x + w, y + h).getGreen();
                        blues[count] = rgbOriginal.getRGB(x + w, y + h).getBlue();
                        count++;
                    }
                }
                int rmedian = getMedian(reds);
                int gmedian = getMedian(greens);
                int bmedian = getMedian(blues);
                rgbResult.setRGB(x, y, new RGB(rmedian, gmedian, bmedian));
            }
        }
        resultImg = rgbResult.toBufferedImage();
    }

    private int getMedian(int[] values) {
        Arrays.sort(values);
        double median;
        if (values.length%2 == 0)
            median = ((double) values[values.length/2] + (double) values[values.length/2 - 1])/2;
        else
            median = (double) values[values.length/2];
        return (int) median;
    }
}
