package photo.processor.core.filters.contour;

import photo.processor.core.filters.utils.Kernel;
import photo.processor.core.filters.utils.KernelType;

public enum SobelKernels implements KernelType {
    HORIZONTAL(new Kernel(new int[][]{
            {1, 2, 1},
            {0, 0, 0},
            {-1, -2, -1}
    })),
    VERTICAL(new Kernel(new int[][]{
            {1, 0, -1},
            {2, 0, -2},
            {1, 0, -1}
    }));

    private Kernel kernel;

    SobelKernels(Kernel kernel) {
        this.kernel = kernel;
    }

    @Override
    public Kernel getKernel() {
        return kernel;
    }
}
