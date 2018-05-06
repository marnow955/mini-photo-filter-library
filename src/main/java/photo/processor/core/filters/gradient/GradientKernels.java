package photo.processor.core.filters.gradient;

import photo.processor.core.filters.utils.Kernel;
import photo.processor.core.filters.utils.KernelType;

public enum GradientKernels implements KernelType {
    EAST(new Kernel(new int[][]{
            {-1, 1, 1},
            {-1, -2, 1},
            {-1, 1, 1}
    })),
    SOUTHEAST(new Kernel(new int[][]{
            {-1, -1, 1},
            {-1, -2, 1},
            {1, 1, 1}
    })),
    SOUTH(new Kernel(new int[][]{
            {-1, -1, -1},
            {1, -2, 1},
            {1, 1, 1}
    })),
    SOUTHWEST(new Kernel(new int[][]{
            {1, -1, -1},
            {1, -2, -1},
            {1, 1, 1}
    })),
    WEST(new Kernel(new int[][]{
            {1, 1, -1},
            {1, -2, -1},
            {1, 1, -1}
    })),
    NORTHWEST(new Kernel(new int[][]{
            {1, 1, 1},
            {1, -2, -1},
            {1, -1, -1}
    })),
    NORTH(new Kernel(new int[][]{
            {1, 1, 1},
            {1, -2, 1},
            {-1, -1, -1}
    })),
    NORTHEAST(new Kernel(new int[][]{
            {1, 1, 1},
            {-1, -2, 1},
            {-1, -1, 1}
    }));

    private Kernel kernel;

    GradientKernels(Kernel kernel) {
        this.kernel = kernel;
    }

    @Override
    public Kernel getKernel() {
        return kernel;
    }
}
