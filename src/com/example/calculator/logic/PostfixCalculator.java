package src.com.example.calculator.logic;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import src.com.example.calculator.datastructures.DynamicQueue;
import src.com.example.calculator.exception.DivisionByZeroException;
import src.com.example.calculator.exception.InvalidExpressionException;
import src.com.example.calculator.exception.InvalidOperatorException;

/**
 * Calcula expressões na notação pós-fixada (Notação Polonesa Reversa - RPN).
 * Utiliza uma fila dinâmica para armazenar a expressão inicial e uma pilha para os cálculos. 
 */
public class PostfixCalculator {

    // Define o conjunto de operadores válidos. 
    private static final Set<String> OPERATORS = new HashSet<>(Arrays.asList("+", "-", "*", "/", "%"));

    /**
     * Avalia uma expressão aritmética pós-fixada.
     * @param expression A string da expressão pós-fixada, com tokens separados por espaços.
     * @return O resultado do cálculo.
     * @throws InvalidExpressionException Se a expressão estiver malformada, tiver operandos insuficientes/em excesso. 
     * @throws DivisionByZeroException Se ocorrer uma divisão por zero. 
     * @throws InvalidOperatorException Se um operador ou token inválido for encontrado. 
     */
    public double evaluate(String expression) throws InvalidExpressionException, DivisionByZeroException, InvalidOperatorException {
        if (expression == null || expression.trim().isEmpty()) {
            throw new InvalidExpressionException("A expressão não pode ser nula ou vazia.");
        }

        // Tokeniza a expressão de entrada por espaços.
        String[] tokens = expression.trim().split("\\s+");
        
        // A expressão é inicialmente armazenada em uma fila dinâmica. 
        DynamicQueue<String> queue = new DynamicQueue<>();
        for (String token : tokens) {
            queue.enqueue(token);
        }

        // O cálculo é feito utilizando uma pilha (ArrayDeque é uma implementação de pilha dinâmica). 
        ArrayDeque<Double> stack = new ArrayDeque<>();

        // Processa os elementos esvaziando a fila. 
        while (!queue.isEmpty()) {
            String token = queue.dequeue();

            if (isNumeric(token)) {
                // Se o token for um operando (número), empilha. 
                try {
                    stack.push(Double.parseDouble(token));
                } catch (NumberFormatException e) {
                    // Trata casos onde um token parece numérico mas não pode ser parseado por Double.parseDouble
                    throw new InvalidExpressionException("Formato numérico inválido na expressão: " + token);
                }
            } else if (OPERATORS.contains(token)) {
                // Se o token for um operador, desempilha operandos, realiza a operação e empilha o resultado.
                if (stack.size() < 2) {
                    // Não há operandos suficientes na pilha para o operador. 
                    throw new InvalidExpressionException("Operandos insuficientes para o operador '" + token + "'. A expressão pode estar malformada.");
                }
                double operand2 = stack.pop();
                double operand1 = stack.pop();
                double result;

                switch (token) {
                    case "+":
                        result = operand1 + operand2;
                        break;
                    case "-":
                        result = operand1 - operand2;
                        break;
                    case "*":
                        result = operand1 * operand2;
                        break;
                    case "/":
                        if (operand2 == 0) {
                            // Trata divisão por zero. 
                            throw new DivisionByZeroException("Não é possível dividir por zero: " + operand1 + " / " + operand2);
                        }
                        result = operand1 / operand2;
                        break;
                    case "%": // Operador de módulo. 
                        if (operand2 == 0) {
                             // Trata módulo por zero. 
                            throw new DivisionByZeroException("Não é possível realizar módulo por zero: " + operand1 + " % " + operand2);
                        }
                        result = operand1 % operand2;
                        break;
                    default:
                        // Este caso idealmente não deve ser alcançado devido à verificação OPERATORS.contains.
                        throw new InvalidOperatorException("Operador desconhecido encontrado: " + token); // 
                }
                stack.push(result);
            } else {
                // Se o token não for um número nem um operador reconhecido. 
                throw new InvalidOperatorException("Token inválido na expressão: " + token);
            }
        }

        // Após o processamento, a fila deve estar vazia. 
        // A pilha deve conter exatamente um item: o resultado final. 
        if (stack.size() == 1) {
            // O resultado final está na pilha. Desempilha para retornar.
            // Após isso, tanto a fila quanto a pilha (para este cálculo) estão conceitualmente vazias. 
            return stack.pop();
        } else if (stack.isEmpty()) {
            throw new InvalidExpressionException("Expressão inválida: Nenhum resultado produzido. A expressão pode estar vazia ou formatada incorretamente."); // 
        } else {
            // Se a pilha tiver mais de um item, significa que houve operandos em excesso ou operadores faltando. 
            throw new InvalidExpressionException("Expressão inválida: Muitos operandos restantes na pilha ou operadores faltando. Tamanho da pilha: " + stack.size());
        }
    }

    /**
     * Método auxiliar para verificar se um token pode ser interpretado como um número (real ou inteiro). 
     * @param strNum O token string a ser verificado.
     * @return true se o token for numérico, false caso contrário.
     */
    private boolean isNumeric(String strNum) {
        if (strNum == null) {
            return false;
        }
        try {
            Double.parseDouble(strNum);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}