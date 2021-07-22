package Driver;

import Calc.Calculator;
import IO.FileInfo;
import IO.TettroConsoleWriter;
import IO.TettroTextFileReader;

public class Driver {
    public static FileInfo fileInfo = new FileInfo();

    public static void main(String[] args) {
        TettroTextFileReader tr = new TettroTextFileReader();
        tr.setFileName(fileInfo.getFileName());

        Calculator calculator = new Calculator(tr.getPlate());
        calculator.run();

        TettroConsoleWriter tw = new TettroConsoleWriter();
        tw.write(calculator.getSolution(),calculator.getKeys());
    }
}