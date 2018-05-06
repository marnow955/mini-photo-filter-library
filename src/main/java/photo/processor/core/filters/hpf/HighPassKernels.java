package photo.processor.core.filters.hpf;

import photo.processor.core.filters.utils.Kernel;
import photo.processor.core.filters.utils.KernelType;

public enum HighPassKernels implements KernelType {
    MEAN_REMOVAL(new Kernel(new int[][]{
            {-1, -1, -1},
            {-1, 9, -1},
            {-1, -1, -1}
    })),
    //Sharpen
    HP1(new Kernel(new int[][]{
            {0, -1, 0},
            {-1, 5, -1},
            {0, -1, 0}
    })),
    HP2(new Kernel(new int[][]{
            {1, -2, 1},
            {-2, 5, -2},
            {1, -2, 1}
    })),
    HP3(new Kernel(new int[][]{
            {0, -1, 0},
            {-1, 20, -1},
            {0, -1, 0}
    }));
    private Kernel kernel;

    HighPassKernels(Kernel kernel) {
        this.kernel = kernel;
    }

    @Override
    public Kernel getKernel() {
        return kernel;
    }
}
