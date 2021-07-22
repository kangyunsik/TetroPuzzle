package Blocks;

public class Type5_Block extends Block{
    static int[][][] shape = {
            {
                    {1, 0, 0}, // ★☆☆
                    {1, 1, 0}, // ★★☆
                    {1, 0, 0}, // ★☆☆
            },
            {
                    {1, 1, 1},
                    {0, 1, 0},
                    {0, 0, 0},
            },
            {
                    {0, 1, 0},
                    {1, 1, 0},
                    {0, 1, 0},
            },
            {
                    {0, 1, 0},
                    {1, 1, 1},
                    {0, 0, 0},
            }
    };

    public Type5_Block(){
        super(3,4,5);
        setBlock(shape);
    }
}