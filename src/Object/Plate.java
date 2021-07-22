package Object;

import Blocks.*;

public class Plate {
    private int[] required_array;
    private int[][] value;
    private int size;
    private int amount;

    public Plate(int size) {
        this.value = new int[size][size];
        this.size = size;
        this.amount = 0;
        this.required_array = new int[7];
    }

    public int[] getRequired_array(){
        return this.required_array;
    }

    public void addTraceObj(TraceObj obj){
        Block block = null;
        int type = obj.type_number;

        this.required_array[type-1]++;

        switch (type) {
            case 1:block = new Type1_Block();break;
            case 2:block = new Type2_Block();break;
            case 3:block = new Type3_Block();break;
            case 4:block = new Type4_Block();break;
            case 5:block = new Type5_Block();break;
            case 6:block = new Type6_Block();break;
            case 7:block = new Type7_Block();break;
            default : System.out.println("error");
        }

        Shape shape = block.getCurrentShape(obj.rotate);
        int[][] indexes = shape.getIndexes();

        for(int i=0;i<4;i++){
            value[obj.index_i + indexes[i][0]][obj.index_j + indexes[i][1]] = type;
        }
    }

    public void copy(Plate before){
        for(int i=0;i<size;i++){
            for(int j=0;j<size;j++){
                this.value[i][j] = before.getValue(i,j);
            }
        }
    }

    public void toZero(int i, int j, Shape shape){
        int[][] indexes = shape.getIndexes();
        for(int p=0;p<4;p++){
            this.value[i+indexes[p][0]][j+indexes[p][1]] = 0;
        }
    }

    public void addRow(int count, String string) {
        for (int i = 0; i < string.length(); i++) {
            int temp = string.charAt(i) - '0';
            value[count][i] = temp;
            amount += (temp == 1 ? 1 : 0);
        }
    }

    public int getValue(int i,int j){
        return this.value[i][j];
    }

    public int getSize(){
        return this.size;
    }

    public int getAmount() {
        return this.amount;
    }

    public void testPrint() {
        for (int i = 0; i < size; i++) {
            System.out.print("\t");
            for (int j = 0; j < size; j++)
                System.out.print(value[i][j]);
            System.out.println();
        }
    }
}