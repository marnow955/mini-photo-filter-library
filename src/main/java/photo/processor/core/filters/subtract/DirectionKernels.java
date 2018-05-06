package photo.processor.core.filters.subtract;

import photo.processor.core.filters.utils.Kernel;
import photo.processor.core.filters.utils.KernelType;

public enum DirectionKernels implements KernelType {
    HORIZONTAL(new Kernel(new int[][]{
            {0, 0, 0},
            {-1, 1, 0},
            {0, 0, 0}
    })),
    VERTICAL(new Kernel(new int[][]{
            {0, -1, 0},
            {0, 1, 0},
            {0, 0, 0}
    })),
    RIGHT_DIAGONAL(new Kernel(new int[][]{
            {-1, 0, 0},
            {0, 1, 0},
            {0, 0, 0}
    })),
    LEFT_DIAGONAL(new Kernel(new int[][]{
            {0, 0, -1},
            {0, 1, 0},
            {0, 0, 0}
    }));

    private Kernel kernel;

    DirectionKernels(Kernel kernel) {
        this.kernel = kernel;
    }

    @Override
    public Kernel getKernel() {
        return kernel;
    }
}
