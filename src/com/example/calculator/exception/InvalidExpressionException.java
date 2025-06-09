package src.com.example.calculator.exception;

/**
 * Exceção personalizada para expressões inválidas.
 * Pode ser devido a operandos insuficientes ou em excesso, ou expressões malformadas.
 */
public class InvalidExpressionException extends RuntimeException {
    public InvalidExpressionException(String message) {
        super(message);
    }
}