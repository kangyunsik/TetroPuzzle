package Blocks;

public class Type7_Block extends Block{
    static int[][][] shape = {
            {
                    {1, 0, 0, 0}, // ★☆☆☆
                    {1, 0, 0, 0}, // ★☆☆☆
                    {1, 0, 0, 0}, // ★☆☆☆
                    {1, 0, 0, 0},  // ★☆☆☆
            },
            {
                    {1, 1, 1, 1}, // ★★★★
                    {0, 0, 0, 0}, // ☆☆☆☆
                    {0, 0, 0, 0}, // ☆☆☆☆
                    {0, 0, 0, 0},  // ☆☆☆☆
            },
    };

    public Type7_Block(){
        super(4,2,7);
        setBlock(shape);
    }
}