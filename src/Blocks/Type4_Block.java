package Blocks;

public class Type4_Block extends Block{
    static int[][][] shape = {
            {
                    {0, 1, 0}, // ☆★☆
                    {1, 1, 0}, // ★★☆
                    {1, 0, 0}, // ★☆☆
            },
            {
                    {1, 1, 0},
                    {0, 1, 1},
                    {0, 0, 0},
            }
    };

    public Type4_Block(){
        super(3,2,4);
        setBlock(shape);
    }
}