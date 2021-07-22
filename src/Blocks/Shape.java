package Blocks;

public class Shape {
    private int[][] matrix;
    private int size;
    private int[][] indexes;

    public Shape(int[][] init, int n){
        this.matrix = new int[n][n];
        this.size = matrix[0].length;
        this.indexes = new int[4][2];

        int ct = 0;

        for(int i=0;i<this.size;i++){
            for(int j=0;j<this.size;j++) {
                matrix[i][j] = init[i][j];
                if(init[i][j] == 1){
                    this.indexes[ct][0] = i;
                    this.indexes[ct][1] = j;
                    ct++;
                }
            }
        }
    }

    public int[][] getIndexes(){
        return this.indexes;
    }
    public int getSize(){
        return this.matrix[0].length;
    }
}
