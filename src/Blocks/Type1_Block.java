package Blocks;

public class Type1_Block extends Block {
    static int[][][] shape = {
            {
                    {1, 1, 0}, // ★★☆
                    {0, 1, 0}, // ☆★☆
                    {0, 1, 0}, // ☆★☆
            },
            {
                    {0, 0, 1},
                    {1, 1, 1},
                    {0, 0, 0},
            },
            {
                    {1, 0, 0},
                    {1, 0, 0},
                    {1, 1, 0},
            },
            {
                    {1, 1, 1},
                    {1, 0, 0},
                    {0, 0, 0},
            }
    };

    public Type1_Block() {
        super(3,4,1);
        setBlock(shape);
    }
}
