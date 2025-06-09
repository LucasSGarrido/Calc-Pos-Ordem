package src.com.example.calculator.exception;

/**
 * Exceção personalizada para erros de divisão por zero.
 */
public class DivisionByZeroException extends RuntimeException {
    public DivisionByZeroException(String message) {
        super(message);
    }
}