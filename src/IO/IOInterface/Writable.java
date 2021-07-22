package IO.IOInterface;

import java.util.HashMap;
import java.util.HashSet;
import Object.Plate;

public interface Writable {
    void write(HashMap<Integer, Plate> solution, HashSet<Integer> keys);
}
