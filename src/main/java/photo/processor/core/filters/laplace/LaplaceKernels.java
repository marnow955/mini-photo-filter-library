package photo.processor.core.filters.laplace;

import photo.processor.core.filters.utils.Kernel;
import photo.processor.core.filters.utils.KernelType;

public enum LaplaceKernels implements KernelType {
    LAPL1(new Kernel(new int[][]{
            {0, -1, 0},
            {-1, 4, -1},
            {0, -1, 0}
    })),
    LAPL2(new Kernel(new int[][]{
            {-1, -1, -1},
            {-1, 8, -1},
            {-1, -1, -1}
    })),
    LAPL3(new Kernel(new int[][]{
            {1, -2, 1},
            {-2, 4, -2},
            {1, -2, 1}
    })),
    DIAGONAL(new Kernel(new int[][]{
            {-1, 0, -1},
            {0, 4, 0},
            {-1, 0, -1}
    })),
    HORIZONTAL(new Kernel(new int[][]{
            {0, -1, 0},
            {0, 2, 0},
            {0, -1, 0}
    })),
    VERTICAL(new Kernel(new int[][]{
            {0, 0, 0},
            {-1, 2, -1},
            {0, 0, 0}
    }));

    private Kernel kernel;

    LaplaceKernels(Kernel kernel) {
        this.kernel = kernel;
    }

    @Override
    public Kernel getKernel() {
        return kernel;
    }
}
