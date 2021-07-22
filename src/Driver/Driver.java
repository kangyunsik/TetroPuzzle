package Driver;

import Calc.Calculator;
import Utility.Util;
import Object.Plate;

import java.util.HashMap;
import java.util.HashSet;

public class Driver {
    public final static String fileName = "./nei.txt";

    public final static int block_kind = 7;
    public final static int interval_time = 5000;
    public static int logicArraySize;
    public static Plate plate;

    public static void main(String[] args) {
        int logicInt, time = 0;
        HashMap<Integer,Plate> solution;
        HashSet<Integer> keys;

        long nowTime = System.currentTimeMillis();
        Util myUtil = new Util();
        myUtil.setFileName(fileName);
        Calculator calculator = new Calculator();

        plate = myUtil.getPlateFromFile();
        logicInt = (int)Math.pow(2,block_kind-1) - 1;
        logicArraySize = block_kind - 1 + plate.getAmount()/4;

        while (!myUtil.isOver(logicInt)) {
            if(System.currentTimeMillis() - nowTime > interval_time * time){
                System.out.print("진행도 : " + (int)(100*logicInt/Math.pow(2,logicArraySize)) + "%, \t찾은 솔루션 수: "+ calculator.getKeys().size()+"\n");
                time++;
            }
            calculator.findFunction(plate,logicInt,0);
            logicInt = myUtil.getNextLogicInt(logicInt);
        }

        solution = calculator.getSolution();
        keys = calculator.getKeys();

        printTestDriver(solution,keys);
    }

    private static void printTestDriver(HashMap<Integer,Plate> solution,HashSet<Integer> keys){
        int cnt = 0;
        System.out.println("Solution size : " + solution.size());
        for(Integer key : keys) {
            System.out.print((cnt++ + 1) + "번째 Solution==============\n");
            for (int num : solution.get(key).getRequired_array())
                System.out.print(num + " ");
            System.out.println();
            solution.get(key).testPrint();
            System.out.println("============================\n");
        }
    }
}