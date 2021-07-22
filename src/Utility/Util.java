package Utility;

import Driver.Driver;

public class Util {
    public int getNextLogicInt(int logic_num) {
        do {logic_num++;} while (!isValid(logic_num) && !isOver(logic_num));
        return logic_num;
    }

    public boolean isOver(int value) {
        return (int) Math.pow(2, Driver.fileInfo.getLogicArraySize()) <= value;
    }

    public boolean isValid(int logic_num) {
        int count = 0;

        while(logic_num > 0){
            count += logic_num%2;
            logic_num >>= 1;
        }

        if (count == Driver.fileInfo.getBlock_kind() - 1) return true;
        return false;
    }

    public String getLogic(int input){
        StringBuilder sb = new StringBuilder();
        String binaryString = intToBinaryString(input);

        for (int i = 0; i < Driver.fileInfo.getLogicArraySize() - binaryString.length(); i++)
            sb.append("0");
        sb.append(binaryString);
        return sb.toString();
    }

    public String intToBinaryString(int input){
        StringBuilder sb = new StringBuilder();
        while(input > 0){
            sb.insert(0,input%2);
            input >>=1;
        }
        return sb.toString();
    }

    public int getBlockNumber(int logic, int index) {
        int count = 0;
        int passing = 0;
        String logicString = getLogic(logic);
        for(int i=0;i<logicString.length();i++){
            if(logicString.charAt(i) == '0'){
                if(count == index)
                    return passing+1;
                count++;
            }else{
                passing++;
            }
        }

        return passing;
    }
}
