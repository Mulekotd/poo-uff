package controlunity;

public class Instruction {
    private final Opcode opcode;
    private final int op1;
    private final int op2;
    private final int op3;

    public Instruction(String opcode, String op1, String op2, String op3) {
        this.opcode = Opcode.fromBits(validateBits(opcode, "opcode"));
        this.op1 = parseOperand(op1, "op1");
        this.op2 = parseOperand(op2, "op2");
        this.op3 = parseOperand(op3, "op3");
    }

    public static Instruction fromBinaryLine(String line, int lineNumber) {
        if (line == null || line.trim().isEmpty()) {
            throw new IllegalArgumentException("Line " + lineNumber + " is empty");
        }

        String[] fields = line.trim().split("\\s+");

        if (fields.length != 4) {
            throw new IllegalArgumentException(
                    "Line " + lineNumber + " must contain opcode, op1, op2, and op3");
        }

        try {
            return new Instruction(fields[0], fields[1], fields[2], fields[3]);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Line " + lineNumber + ": " + e.getMessage(), e);
        }
    }

    public Opcode getOpcode() {
        return this.opcode;
    }

    public int getOp1() {
        return this.op1;
    }

    public int getOp2() {
        return this.op2;
    }

    public int getOp3() {
        return this.op3;
    }

    private static int parseOperand(String bits, String fieldName) {
        return Integer.parseInt(validateBits(bits, fieldName), 2);
    }

    private static String validateBits(String bits, String fieldName) {
        if (bits == null || !bits.matches("[01]{4}")) {
            throw new IllegalArgumentException(fieldName + " must contain exactly 4 bits (0 or 1)");
        }

        return bits;
    }
}
