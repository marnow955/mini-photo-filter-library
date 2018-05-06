package photo.processor.core.filters;

import photo.processor.core.PhotoProcessor;
import photo.processor.core.filters.utils.Kernel;
import photo.processor.core.filters.utils.KernelType;
import photo.processor.core.utils.color.RGB;
import photo.processor.core.utils.color.RgbImage;

import java.awt.image.BufferedImage;

public class Convolution extends PhotoProcessor {

    private RgbImage rgbOriginal;
    private RgbImage rgbResult;
    protected Kernel kernel;
    private boolean normalization;

    public Convolution(KernelType kernelType) {
        this.kernel = kernelType.getKernel();
        normalization = true;
    }

    public Convolution(KernelType kernelType, boolean useNormalization) {
        this.kernel = kernelType.getKernel();
        normalization = useNormalization;
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
        int kernelSum = (int) kernel.getSum();
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                int rsum = 0;
                int gsum = 0;
                int bsum = 0;
                int yCenter = kernel.getHeight()/2;
                int xCenter = kernel.getWidth()/2;
                for (int h = 0 - yCenter; h < kernel.getHeight() - yCenter; h++) {
                    if (y + h < 0 || y + h >= height)
                        continue;
                    for (int w = 0 - xCenter; w < kernel.getWidth() - xCenter; w++) {
                        if (x + w < 0 || x + w >= width)
                            continue;
                        int multiplier = (int) kernel.get(xCenter + w, yCenter + h);
                        rsum += rgbOriginal.getRGB(x + w, y + h).getRed()*multiplier;
                        gsum += rgbOriginal.getRGB(x + w, y + h).getGreen()*multiplier;
                        bsum += rgbOriginal.getRGB(x + w, y + h).getBlue()*multiplier;
                    }
                }
                if (kernelSum != 0 && normalization) {
                    rsum = rsum/kernelSum;
                    gsum = gsum/kernelSum;
                    bsum = bsum/kernelSum;
                }
                rgbResult.setRGB(x, y, new RGB(rsum, gsum, bsum));
            }
        }
        resultImg = rgbResult.toBufferedImage();
    }
}
