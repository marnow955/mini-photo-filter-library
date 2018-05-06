package photo.processor.core.filters.utils;

public class Kernel {

    private int width;
    private int height;
    private double[][] values;

    public Kernel(int width, int height) {
        this.width = width;
        this.height = height;
        values = new double[height][width];
    }

    public Kernel(double[][] values) {
        this.width = values[0].length;
        this.height = values.length;
        this.values = values;
    }

    public Kernel(int[][] values) {
        this(values[0].length, values.length);
        for (int y = 0; y < height; y++)
            for (int x = 0; x < width; x++)
                this.values[y][x] = values[y][x];
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public double get(int x, int y) {
        return values[y][x];
    }

    public double getSum() {
        double sum = 0.0;
        for (int y = 0; y < height; y++)
            for (int x = 0; x < width; x++)
                sum += values[y][x];
        return sum;
    }
}
