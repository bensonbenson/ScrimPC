package scrimpc;

import java.util.ArrayList;
import java.util.TreeMap;

public class ScrimPC {

    enum OP {
        ADD,
        SUB,
        LW,
        SW,
        BEQ,
        BNE,
        J,
        JAL
    }
    
    // Instruction memory.
    static ArrayList iMem = new ArrayList();
    // Data memory.
    static ArrayList dMem = new ArrayList();
    // Holds labels and their corresponding addresses in memory.
    static TreeMap labels = new TreeMap<String, Integer>();
    // ScrimPC's "accumulator" register.
    static double accumulator = 0;
    // Program counter.
    static int PC = 0;
    // Jump address register.
    int JR = 0;

    public double getAccumulator() {
        return accumulator;
    }

    public int getPC() {
        return PC;
    }

    public int getJR() {
        return JR;
    }
    
    public static void main(String[] args) {
        String filename = "Assembly Files/add_sub_sw.scrim";
        
        Decoder decoder = new Decoder();
        boolean fileRead = decoder.LoadInstructions(filename, iMem, labels);
       
        DumpInstructionMemory();
        
    }
    
    public static void DumpInstructionMemory() {
        for(int i = 0; i < iMem.size(); i++) {
            System.out.println(iMem.get(i));
        }
    }
    
    public static void DumpDataMemory() {
        for(int i = 0; i < dMem.size(); i++) {
            System.out.println(dMem.get(i));
        }
    }
    
}
