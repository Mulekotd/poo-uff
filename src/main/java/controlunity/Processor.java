package controlunity;

public class Processor {
    private int pc; // Program Counter
    private final int[] registers = new int[16];

    public void exec(Instruction instruction) {
        switch (instruction.getOpcode()) {
            case ADD: 
                registers[instruction.getOp1()] = registers[instruction.getOp2()] + registers[instruction.getOp3()];
                break;

            case SUB:
                registers[instruction.getOp1()] = registers[instruction.getOp2()] - registers[instruction.getOp3()];
                break;

            default:
                throw new UnsupportedOperationException();
        }

        pc++;
    }
}
