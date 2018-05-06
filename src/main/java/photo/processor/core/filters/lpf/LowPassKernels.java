package photo.processor.core.filters.lpf;

import photo.processor.core.filters.utils.Kernel;
import photo.processor.core.filters.utils.KernelType;

public enum LowPassKernels implements KernelType {
    //Box blur
    AVERAGE(new Kernel(new int[][]{
            {1, 1, 1},
            {1, 1, 1},
            {1, 1, 1}
    })),
    SQUARE(new Kernel(new int[][]{
            {1, 1, 1, 1, 1},
            {1, 1, 1, 1, 1},
            {1, 1, 1, 1, 1},
            {1, 1, 1, 1, 1},
            {1, 1, 1, 1, 1}
    })),
    CIRCULAR(new Kernel(new int[][]{
            {0, 1, 1, 1, 0},
            {1, 1, 1, 1, 1},
            {1, 1, 1, 1, 1},
            {1, 1, 1, 1, 1},
            {0, 1, 1, 1, 0}
    })),
    LP1(new Kernel(new int[][]{
            {1, 1, 1},
            {1, 2, 1},
            {1, 1, 1}
    })),
    LP2(new Kernel(new int[][]{
            {1, 1, 1},
            {1, 4, 1},
            {1, 1, 1}
    })),
    LP3(new Kernel(new int[][]{
            {1, 1, 1},
            {1, 12, 1},
            {1, 1, 1}
    })),
    PYRAMIDAL(new Kernel(new int[][]{
            {1, 2, 3, 2, 1},
            {2, 4, 6, 4, 2},
            {3, 6, 9, 6, 3},
            {2, 4, 6, 4, 2},
            {1, 2, 3, 2, 1}
    })),
    CONICAL(new Kernel(new int[][]{
            {0, 0, 1, 0, 0},
            {0, 2, 2, 2, 0},
            {1, 2, 5, 2, 1},
            {0, 2, 2, 2, 0},
            {0, 0, 1, 0, 0}
    })),
    //Gaussian blur 3x3
    GAUSS1(new Kernel(new int[][]{
            {1, 2, 1},
            {2, 4, 2},
            {1, 2, 1}
    })),
    GAUSS2(new Kernel(new int[][]{
            {1, 1, 2, 1, 1},
            {1, 2, 4, 2, 1},
            {2, 4, 8, 4, 2},
            {1, 2, 4, 2, 1},
            {1, 1, 2, 1, 1}
    })),
    GAUSS3(new Kernel(new int[][]{
            {0, 1, 2, 1, 0},
            {1, 4, 8, 4, 1},
            {2, 8, 16, 8, 2},
            {1, 4, 8, 4, 1},
            {0, 1, 2, 1, 0}
    })),
    GAUSS4(new Kernel(new int[][]{
            {1, 4, 7, 4, 1},
            {4, 16, 26, 16, 4},
            {7, 26, 41, 26, 7},
            {4, 16, 26, 16, 4},
            {1, 4, 7, 4, 1}
    })),
    GAUSS5(new Kernel(new int[][]{
            {1, 1, 2, 2, 2, 1, 1},
            {1, 2, 2, 4, 2, 2, 1},
            {2, 2, 4, 8, 4, 2, 2},
            {2, 4, 8, 16, 8, 4, 2},
            {1, 2, 2, 4, 2, 2, 1},
            {1, 1, 2, 2, 2, 1, 1}
    }));


    private Kernel kernel;

    LowPassKernels(Kernel kernel) {
        this.kernel = kernel;
    }

    public Kernel getKernel() {
        return kernel;
    }
}
