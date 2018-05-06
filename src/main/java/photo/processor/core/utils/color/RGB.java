package photo.processor.core.utils.color;

import java.awt.*;

public class RGB {

    private int red;
    private int green;
    private int blue;

    public RGB(int red, int green, int blue) {
        setRed(red);
        setGreen(green);
        setBlue(blue);
    }

    public RGB(Color color) {
        this.red = color.getRed();
        this.green = color.getGreen();
        this.blue = color.getBlue();
    }

    public RGB(int rgb) {
        this(new Color(rgb));
    }

    public int getRGB() {
        return new Color(red, green, blue).getRGB();
    }

    public void setRGB(int rgb) {
        Color color = new Color(rgb);
        this.red = color.getRed();
        this.green = color.getGreen();
        this.blue = color.getBlue();
    }

    public int getRed() {
        return red;
    }

    public int getGreen() {
        return green;
    }

    public int getBlue() {
        return blue;
    }

    public void setRed(int red) {
        if (red < 0)
            this.red = 0;
        else if (red > 255)
            this.red = 255;
        else
            this.red = red;
    }

    public void setGreen(int green) {
        if (green < 0)
            this.green = 0;
        else if (green > 255)
            this.green = 255;
        else
            this.green = green;
    }

    public void setBlue(int blue) {
        if (blue < 0)
            this.blue = 0;
        else if (blue > 255)
            this.blue = 255;
        else
            this.blue = blue;
    }

}
