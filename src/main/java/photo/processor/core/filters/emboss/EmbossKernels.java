package photo.processor.core.filters.emboss;

import photo.processor.core.filters.utils.Kernel;
import photo.processor.core.filters.utils.KernelType;

public enum EmbossKernels implements KernelType {
    EAST(new Kernel(new int[][]{
            {-1, 0, 1},
            {-1, 1, 1},
            {-1, 0, 1}
    })),
    SOUTHEAST(new Kernel(new int[][]{
            {-1, -1, 0},
            {-1, 1, 1},
            {0, 1, 1}
    })),
    SOUTH(new Kernel(new int[][]{
            {-1, -1, -1},
            {0, 1, 0},
            {1, 1, 1}
    })),
    SOUTHWEST(new Kernel(new int[][]{
            {0, -1, -1},
            {1, 1, -1},
            {1, 1, 0}
    })),
    WEST(new Kernel(new int[][]{
            {1, 0, -1},
            {1, 1, -1},
            {1, 0, -1}
    })),
    NORTHWEST(new Kernel(new int[][]{
            {1, 1, 0},
            {1, 1, -1},
            {0, -1, -1}
    })),
    NORTH(new Kernel(new int[][]{
            {1, 1, 1},
            {0, 1, 0},
            {-1, -1, -1}
    })),
    NORTHEAST(new Kernel(new int[][]{
            {0, 1, 1},
            {-1, 1, 1},
            {-1, -1, 0}
    }));

    private Kernel kernel;

    EmbossKernels(Kernel kernel) {
        this.kernel = kernel;
    }

    @Override
    public Kernel getKernel() {
        return kernel;
    }
}
