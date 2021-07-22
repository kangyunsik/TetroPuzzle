package Blocks;

public class Block {
    private Shape[] shapes;
    private int n;
    private int rotate_max;
    private int type_number;

    public Block(int n, int max,int type_number) {
        shapes = new Shape[max];
        this.n = n;
        this.rotate_max = max;
        this.type_number = type_number;
    }

    public Shape getCurrentShape(int rotate){
        return this.shapes[rotate];
    }

    public int getType_number(){
        return this.type_number;
    }

    public int getRotate_max(){
        return this.rotate_max;
    }

    public void setBlock(int[][][] input) {
        for (int type = 0; type < rotate_max; type++)
            shapes[type] = new Shape(input[type],n);
    }
}
