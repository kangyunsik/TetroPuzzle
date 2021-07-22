package Blocks;

public class Type3_Block extends Block{
    static int[][][] shape = {
            {
                    {1, 0, 0}, // ★☆☆
                    {1, 1, 0}, // ★★☆
                    {0, 1, 0}, // ☆★☆
            },
            {
                    {0, 1, 1},
                    {1, 1, 0},
                    {0, 0, 0},
            }
    };

    public Type3_Block(){
        super(3,2,3);
        setBlock(shape);
    }
}