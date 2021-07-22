package Calc;

import Blocks.*;
import Utility.Util;
import Object.*;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Stack;
import Driver.Driver;

public class Calculator {
    private Plate plate;
    private int interval_time = 5000;

    private static Stack<TraceObj> stepStack = new Stack<>();
    private CalcChecker calcChecker;
    private Util myUtil;
    private HashMap<Integer,Plate> solution;
    private HashSet<Integer> keys;

    public Calculator(Plate plate) {
        myUtil = new Util();
        calcChecker = new CalcChecker();
        solution = new HashMap<>();
        keys = new HashSet<>();
        this.plate = plate;
    }

    public void run(int interval_time){
        this.interval_time = interval_time;
        this.run();
    }

    public void run(){
        int logicInt;
        int time = 0;
        long nowTime;

        logicInt = (int)Math.pow(2,Driver.fileInfo.getBlock_kind()-1) - 1;
        nowTime = System.currentTimeMillis();

        while (!myUtil.isOver(logicInt)) {
            if(System.currentTimeMillis() - nowTime > (long) interval_time * time){
                System.out.print("진행도 : " + (int)(100*logicInt/Math.pow(2,Driver.fileInfo.getLogicArraySize())) +
                        "%, \t찾은 솔루션 수: "+ keys.size()+"\n");
                time++;
            }
            findFunction(plate,logicInt,0);
            logicInt = myUtil.getNextLogicInt(logicInt);
        }
    }

    public HashSet<Integer> getKeys(){
        return this.keys;
    }

    public HashMap<Integer,Plate> getSolution(){
        return this.solution;
    }

    public void findFunction(Plate plate, int logic, int index) {
        if (index == Driver.fileInfo.getPuzzleNum()) {
            Plate sol_plate = new Plate(plate.getSize());

            for(TraceObj obj : stepStack)
                sol_plate.addTraceObj(obj);

            solution.put(logic,sol_plate);
            keys.add(logic);
        }

        Block block = null;

        switch (myUtil.getBlockNumber(logic, index)) {
            case 1:block = new Type1_Block();break;
            case 2:block = new Type2_Block();break;
            case 3:block = new Type3_Block();break;
            case 4:block = new Type4_Block();break;
            case 5:block = new Type5_Block();break;
            case 6:block = new Type6_Block();break;
            case 7:block = new Type7_Block();break;
            default : System.out.println("error");
        }

        for(int rotate = 0; rotate < (block != null ? block.getRotate_max() : 0); rotate++) {
            for (int i = 0; i < plate.getSize(); i++) {
                for (int j = 0; j < plate.getSize(); j++) {
                    Plate afterPlate = calcAfter(plate, i, j, block.getCurrentShape(rotate));
                    if (afterPlate != null){
                        stepStack.push(new TraceObj(i, j, block.getType_number(), rotate));
                        findFunction(afterPlate, logic, index + 1);
                        stepStack.pop();
                    }
                }
            }
        }

    }

    private Plate calcAfter(Plate before, int i, int j, Shape shape){
        Plate resulted;

        if(calcChecker.isValidLocation(before,i,j,shape)
                && calcChecker.isDividingToNotOdd((resulted = calcResult(before,i,j,shape)))){
            return resulted;
        }else
            return null;
    }

    private Plate calcResult(Plate before, int i, int j, Shape shape) {
        Plate afterPlate = new Plate(before.getSize());
        afterPlate.copy(before);
        for(int a=0;a<4;a++){
            afterPlate.toZero(i,j,shape);
        }

        return afterPlate;
    }
}
