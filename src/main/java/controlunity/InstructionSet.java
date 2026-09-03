package controlunity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

public final class InstructionSet implements Iterable<Instruction> {
    private final List<Instruction> instructions;

    public InstructionSet(List<Instruction> instructions) {
        Objects.requireNonNull(instructions, "instructions cannot be null");
        this.instructions = Collections.unmodifiableList(new ArrayList<>(instructions));
    }

    public static InstructionSet fromBinaryFileLines(List<String> fileLines) {
        Objects.requireNonNull(fileLines, "fileLines cannot be null");

        if (fileLines.isEmpty()) {
            throw new IllegalArgumentException("The file must contain a header line");
        }

        List<Instruction> instructions = new ArrayList<>();

        for (int index = 1; index < fileLines.size(); index++) {
            String line = fileLines.get(index);

            if (line.trim().isEmpty()) {
                continue;
            }

            instructions.add(Instruction.fromBinaryLine(line, index + 1));
        }

        return new InstructionSet(instructions);
    }

    public Instruction get(int index) {
        return instructions.get(index);
    }

    public int size() {
        return instructions.size();
    }

    @Override
    public Iterator<Instruction> iterator() {
        return instructions.iterator();
    }
}
