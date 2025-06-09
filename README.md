Calculadora Pós-Ordem (Notação Pós-Fixada)

O que é Notação Pós-Fixada?

A notação pós-fixada, também conhecida como notação polonesa reversa (RPN), é uma forma de escrever expressões matemáticas onde os operadores vêm depois dos operandos. Isso elimina a necessidade de parênteses e facilita a execução usando uma estrutura de pilha (stack).

Exemplo:

Infixado: 3 + 4

Pós-fixado: 3 4 +

Objetivo

O objetivo é interpretar e calcular expressões fornecidas em notação pós-fixada, realizando as quatro operações básicas:

Adição: +

Subtração: -

Multiplicação: *

Divisão: /

A aplicação deve ainda ser capaz de:

Informar erros de sintaxe;

Lidar com operadores inválidos;

Detectar divisão por zero;

Validar se a expressão está corretamente estruturada.

Como Funciona

A calculadora utiliza uma lógica de pilha, seguindo este fluxo:

Lê cada elemento da expressão da esquerda para a direita.

Se for um número, empilha.

Se for um operador, desempilha os dois últimos números, aplica a operação e empilha o resultado.

No final, deve restar apenas um valor na pilha, que é o resultado.

Exemplos de Expressões Válidas

Exemplo 1:

Entrada: 3 4 +Interpretação: Soma de 3 e 4Resultado: 7

Exemplo 2:

Entrada: 10 5 /Interpretação: Divisão de 10 por 5Resultado: 2

Exemplo 3:

Entrada: 2 3 + 4 *Interpretação: Soma de 2 e 3, resultado multiplicado por 4 → (2 + 3) * 4Resultado: 20

Exemplo 4:

Entrada: 5 1 2 + 4 * + 3 -Interpretação:1 + 2 = 33 * 4 = 125 + 12 = 1717 - 3 = 14Resultado: 14

Exemplos de Falhas e Erros

Divisão por zero

Entrada: 5 0 /Erro: Divisão por zero. A operação é inválida.

Operador inválido

Entrada: 2 3 ^Erro: O operador "^" não é suportado. Apenas +, -, * e / são permitidos.

Expressão malformada (operandos a mais)

Entrada: 2 3 4 +Erro: A expressão possui operandos sobrando, ou seja, falta operador para concluir a operação.

Expressão malformada (faltam operandos)

Entrada: 3 +Erro: Faltam operandos para aplicar o operador "+".

Conclusão

A calculadora pós-ordem é uma aplicação baseada em lógica de pilha, útil para interpretar expressões matemáticas sem necessidade de parênteses. É comum em linguagens de programação, compiladores, calculadoras científicas e sistemas embarcados.

Para seu uso correto:

Garanta que os operandos precedam os operadores.

Use apenas operadores válidos.

Certifique-se de que a estrutura da expressão está balanceada (sem sobras ou faltas).

