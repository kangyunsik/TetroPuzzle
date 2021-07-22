package Blocks;

public class Type2_Block extends Block{
    static int[][][] shape = {
            {
                    {1, 1, 0}, // ★★☆
                    {1, 0, 0}, // ★☆☆
                    {1, 0, 0}, // ★☆☆
            },
            {
                    {1, 1, 1},
                    {0, 0, 1},
                    {0, 0, 0},
            },
            {
                    {0, 1, 0},
                    {0, 1, 0},
                    {1, 1, 0},
            },
            {
                    {1, 0, 0},
                    {1, 1, 1},
                    {0, 0, 0},
            }
    };

    public Type2_Block(){
        super(3,4,2);
        setBlock(shape);
    }
}