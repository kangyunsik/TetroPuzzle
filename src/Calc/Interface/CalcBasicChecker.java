package Calc.Interface;

import Blocks.Shape;
import Object.Plate;

public interface CalcBasicChecker {
    boolean isValidLocation(Plate before, int i, int j, Shape shape);
}
