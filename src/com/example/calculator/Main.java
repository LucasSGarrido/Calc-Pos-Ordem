package src.com.example.calculator;

import java.util.Scanner;

import src.com.example.calculator.exception.DivisionByZeroException;
import src.com.example.calculator.exception.InvalidExpressionException;
import src.com.example.calculator.exception.InvalidOperatorException;
import src.com.example.calculator.logic.PostfixCalculator;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PostfixCalculator calculator = new PostfixCalculator();

        System.out.println("=== Calculadora Pós-Ordem (Notação Pós-Fixada) ==="); // 
        System.out.println("Desenvolvida como projeto de Estrutura de Dados.");
        System.out.println("----------------------------------------------------");
        System.out.println("Operadores válidos: +, -, *, /, %"); // 
        System.out.println("Operandos: números reais ou inteiros (ex: 5, -2.5, 100)"); // 
        System.out.println("----------------------------------------------------");
        System.out.println("Digite uma expressão pós-fixada (ex: '3 4 +') ou 'sair' para terminar.");

        while (true) {
            System.out.print("\nExpressão: ");
            String input = scanner.nextLine();

            if (input.equalsIgnoreCase("sair")) {
                System.out.println("Encerrando a calculadora. Até logo!");
                break;
            }

            if (input.trim().isEmpty()) {
                System.err.println("Erro: A expressão não pode ser vazia.");
                continue;
            }

            try {
                double result = calculator.evaluate(input);
                // Formatando a saída para corresponder ao exemplo "7.0" mas mostrando inteiro se não tiver casas decimais.
                if (result == (long) result) {
                    System.out.printf("Resultado: %d\n", (long) result);
                } else {
                    // Arredondando para um número razoável de casas decimais se necessário, ou usando printf com precisão.
                    // Para este exemplo, vamos usar uma casa decimal como no exemplo "7.0" ou "-4.0".
                    System.out.printf("Resultado: %.1f\n", result); 
                }
            } catch (InvalidExpressionException | DivisionByZeroException | InvalidOperatorException e) {
                // Tratando erros de cálculo esperados. 
                System.err.println("Erro na Expressão: " + e.getMessage());
            } catch (Exception e) {
                // Captura para quaisquer outros erros de tempo de execução inesperados.
                System.err.println("Erro Inesperado no Sistema: " + e.getMessage());
                // Para depuração, você pode querer imprimir o stack trace:
                // e.printStackTrace();
            }
        }
        scanner.close();
    }
}