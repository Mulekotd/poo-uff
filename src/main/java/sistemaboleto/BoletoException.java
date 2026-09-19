package sistemaboleto;

public class BoletoException extends Exception {
    // Parameterless Constructor
    public BoletoException() {}

    // Constructor that accepts a message
    public BoletoException(String message) {
        super(message);
    }
}
