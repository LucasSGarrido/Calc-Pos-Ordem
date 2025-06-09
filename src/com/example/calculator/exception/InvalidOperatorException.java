package src.com.example.calculator.exception;

/**
 * Exceção personalizada para operadores inválidos ou não suportados.
 */
public class InvalidOperatorException extends RuntimeException {
    public InvalidOperatorException(String message) {
        super(message);
    }
}