package Calc;

import Blocks.Shape;
import Object.Plate;

public interface CalcEssential {
    boolean isValidLocation(Plate before, int i, int j, Shape shape);
    boolean isDividingToOdd(Plate resulted);
}
