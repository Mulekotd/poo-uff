package controlunity;

import java.util.Objects;

public class ControlUnity {
    private final InstructionSet instructionSet;
    private Processor processor;

    public ControlUnity(InstructionSet instructionSet) {
        this.instructionSet = Objects.requireNonNull(instructionSet, "instructionSet cannot be null");
        this.processor = new Processor();
    }

    public InstructionSet getInstructionSet() {
        return instructionSet;
    }

    public Boolean isInstructionSetLoaded() {
        return instructionSet != null;
    }

    public void exec() {
        Objects.requireNonNull(this.processor, "processor cannot be null");

        for (Instruction instruction : instructionSet) {
            this.processor.exec(instruction);
        }
    }
}
