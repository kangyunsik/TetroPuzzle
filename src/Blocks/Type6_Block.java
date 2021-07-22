package Blocks;

public class Type6_Block extends Block{
    static int[][][] shape = {
            {
                    {1, 1}, // ★★
                    {1, 1},  // ★★
            }
    };

    public Type6_Block(){
        super(2,1,6);
        setBlock(shape);
    }
}