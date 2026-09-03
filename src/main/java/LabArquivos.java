import controlunity.ControlUnity;
import controlunity.InstructionSet;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class LabArquivos {
    public static void main(String[] args) {
        if (args.length != 1) {
            System.err.println("Usage: java LabArquivos <filepath>");
            return;
        }

        Path file = Paths.get(args[0]);

        try {
            InstructionSet instructionSet = InstructionSet.fromBinaryFileLines(Files.readAllLines(file, StandardCharsets.UTF_8));
            ControlUnity control = new ControlUnity(instructionSet);

            if (control.isInstructionSetLoaded()) {
                System.out.printf(
                        "[DEBUG] Instruction set loaded successfully into ControlUnity (id: %d, instructions: %d)%n",
                        control.hashCode(), instructionSet.size());
            }
        } catch (IOException e) {
            System.err.println("Could not read file '" + file + "': " + e.getMessage());
        } catch (IllegalArgumentException e) {
            System.err.println("Invalid instruction file: " + e.getMessage());
        }
    }
}
