package Calc;

import Blocks.Shape;
import Calc.Interface.*;
import Object.Plate;

public class CalcChecker implements CalcOptimizer, CalcBasicChecker {
    public int[][] already;
    public int count;

    public boolean isValidLocation(Plate before, int i, int j, Shape shape) {
        try {
            int[][] indexes = shape.getIndexes();
            for (int p = 0; p < 4; p++) {
                if (before.getValue(i + indexes[p][0], j + indexes[p][1]) == 0)
                    return false;
            }
            return true;
        } catch (ArrayIndexOutOfBoundsException e) {
            return false;
        }
    }

    public boolean isDividingToNotOdd(Plate resulted) {
        already = new int[resulted.getSize()][resulted.getSize()];

        for(int i=0;i<resulted.getSize();i++){
            for(int j=0;j<resulted.getSize();j++){
                if(resulted.getValue(i,j) == 1 && already[i][j] == 0 && !bfs_sol(i,j,resulted)){
                    return false;
                }
            }
        }
        return true;
    }

    private boolean bfs_sol(int x,int y,Plate resulted){
        count = 0;
        bfs(x,y,resulted);
        return count >= 4 && count % 4 == 0;
    }

    private void bfs(int x,int y,Plate resulted){
        int[][] dxdy = {{1,0},{-1,0},{0,1},{0,-1}};

        for(int cas = 0;cas < 4;cas++) {
            if (x + dxdy[cas][0] < resulted.getSize() && y + dxdy[cas][1] < resulted.getSize()
                    && x + dxdy[cas][0] >= 0 && y + dxdy[cas][1] >= 0
                    && resulted.getValue(x + dxdy[cas][0], y + dxdy[cas][1]) == 1
                    && already[x + dxdy[cas][0]][y + dxdy[cas][1]] == 0) {
                already[x + dxdy[cas][0]][y + dxdy[cas][1]] = 1;
                count++;
                bfs(x + dxdy[cas][0], y + dxdy[cas][1], resulted);
            }
        }
    }
}
