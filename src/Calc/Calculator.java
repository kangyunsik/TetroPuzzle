package Calc;

import Blocks.*;
import Utility.Util;
import Object.*;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Stack;
import Driver.Driver;

public class Calculator {

    private static Stack<TraceObj> stepStack = new Stack<>();
    private Util myUtil;
    private CalcHelpher calcHelpher;
    private HashMap<Integer,Plate> solution;
    private HashSet<Integer> keys;

    public Calculator() {
        myUtil = new Util();
        calcHelpher = new CalcHelpher();
        solution = new HashMap<>();
        keys = new HashSet<>();
    }

    public HashSet<Integer> getKeys(){
        return this.keys;
    }

    public HashMap<Integer,Plate> getSolution(){
        return this.solution;
    }

    public void findFunction(Plate plate, int logic, int index) {
        if (index == Driver.plate.getAmount()/4) {
            //System.out.println("Find one. : " + myUtil.getLogic(logic));
            //System.out.println(logic);
//            for(TraceObj obj : stepStack)
//                obj.printObj();

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

        for(int rotate = 0; rotate < block.getRotate_max();rotate++) {
            for (int i = 0; i < plate.getSize(); i++) {
                for (int j = 0; j < plate.getSize(); j++) {
                    Plate afterPlate = calcAfter(plate, i, j, block.getCurrentShape(rotate));
                    if (afterPlate == null) {
                        continue;
                    }
                    else {
                        //System.out.println("push!" + i + " " + j + " rotate : " + rotate + " type : " + block.getType_number());
                        stepStack.push(new TraceObj(i, j, block.getType_number(), rotate));
                        findFunction(afterPlate, logic, index + 1);
                        stepStack.pop();
                    }
                }
            }
        }
    }

    private Plate calcAfter(Plate before, int i, int j, Shape shape){
        if(calcHelpher.isValidLocation(before,i,j,shape)) {
            Plate resulted = calcHelpher.calcResult(before, i, j, shape);
            if(calcHelpher.isDividingToOdd(resulted))
                return null;
            return resulted;
        }
            return null;
    }
}
