package Utility;

import Driver.Driver;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import Object.Plate;

public class Util {
    private String fileName = "./puzzle.txt";

    public int getNextLogicInt(int logic_num) {
        do {logic_num++;} while (!isValid(logic_num) && !isOver(logic_num));
        return logic_num;
    }

    public boolean isOver(int value) {
        return (int) Math.pow(2, Driver.logicArraySize) <= value;
    }

    public void setFileName(String fileName){
        this.fileName = fileName;
    }

    public String getLogic(int input){
        StringBuilder sb = new StringBuilder();
        String binaryString = intToBinaryString(input);

        for (int i = 0; i < Driver.logicArraySize - binaryString.length(); i++)
            sb.append("0");
        sb.append(binaryString);
        return sb.toString();
    }

    public boolean isValid(int logic_num) {
        int count = 0;

        while(logic_num > 0){
            count += logic_num%2;
            logic_num >>= 1;
        }

        if (count == Driver.block_kind - 1) return true;
        return false;
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
//        System.out.println("count : " + count +" passing = " + (passing+1));
//        System.out.println("logic : " + new Util().getLogic(logic));
//        System.out.println("index : " + index);
        return passing;
    }

    public Plate getPlateFromFile(){
        Plate plate = null;
        int count = 0;

        try {
            BufferedReader br = new BufferedReader(new FileReader(fileName));
            while (true) {
                String line = br.readLine();
                if (plate == null) plate = new Plate(line.length());
                if (line == null) break;
                plate.addRow(count, line);
                count++;
            }
            br.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        if(plate.getAmount()%4 != 0){
            System.out.println("input txt파일 에러. 4의 배수가 아님.");
        }

        return plate;
    }
}
