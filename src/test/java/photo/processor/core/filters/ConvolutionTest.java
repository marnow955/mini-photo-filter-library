package photo.processor.core.filters;

import org.junit.Before;
import org.junit.Test;
import photo.processor.core.PhotoProcessor;
import photo.processor.core.filters.lpf.LowPassKernels;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;

public class ConvolutionTest {

    private BufferedImage originalImage;

    @Before
    public void setUp() throws Exception {
        originalImage = ImageIO.read(new File("src/test/resources/original.png"));
    }

    @Test
    public void getTransformedImage() throws Exception {
        PhotoProcessor tester = new Convolution(LowPassKernels.AVERAGE);
        BufferedImage result = tester.getTransformedImage(originalImage);

        ImageIO.write(result, "png", new File("out/test/results/result.png"));
    }

}