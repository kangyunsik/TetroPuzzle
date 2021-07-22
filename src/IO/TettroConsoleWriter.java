package IO;

import java.util.HashMap;
import java.util.HashSet;

import IO.IOInterface.Writable;
import Object.Plate;

public class TettroConsoleWriter implements Writable {

    public void write(HashMap<Integer, Plate> solution, HashSet<Integer> keys){
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
