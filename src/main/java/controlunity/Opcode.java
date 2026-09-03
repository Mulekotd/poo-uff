package controlunity;

public enum Opcode {
    ADD("0000"),
    SUB("0001"),
    LOAD("0010"),
    STORE("0011");

    private final String bits;

    Opcode(String bits) {
        this.bits = bits;
    }

    public static Opcode fromBits(String bits) {
        for (Opcode opcode : values()) {
            if (opcode.bits.equals(bits)) {
                return opcode;
            }
        }

        throw new IllegalArgumentException("Invalid opcode: " + bits);
    }
}
