package freeFlow.model;

public class FreeFlowException extends Exception {
    // Parameterless Constructor
    public FreeFlowException() {
    }

    // Constructor that accepts a message
    public FreeFlowException(String message) {
        super(message);
    }
}
