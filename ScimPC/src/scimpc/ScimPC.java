package scimpc;

import java.util.ArrayList;

public class ScimPC {

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
    ArrayList iMem;
    // Data memory.
    ArrayList dMem;
    // ScrimPC's "accumulator" register.
    double accumulator;
    // Program counter.
    int PC = 0;
    // Jump address register.
    int JR = 0;
    
    
    public static void main(String[] args) {
        // TODO code application logic here
    }
    
}
