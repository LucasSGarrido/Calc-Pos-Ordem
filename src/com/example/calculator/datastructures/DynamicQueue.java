package src.com.example.calculator.datastructures;

import java.util.LinkedList;
import java.util.NoSuchElementException;

/**
 * Implementação de uma fila dinâmica usando java.util.LinkedList. 
 * Esta fila armazenará os tokens da expressão aritmética. 
 * @param <T> o tipo de elementos mantidos nesta fila
 */
public class DynamicQueue<T> {
    private LinkedList<T> queue;

    public DynamicQueue() {
        this.queue = new LinkedList<>();
    }

    /**
     * Adiciona um item ao final da fila.
     * @param item o item a ser adicionado
     */
    public void enqueue(T item) {
        queue.addLast(item);
    }

    /**
     * Remove e retorna o item do início da fila.
     * @return o item no início da fila
     * @throws NoSuchElementException se a fila estiver vazia
     */
    public T dequeue() {
        if (isEmpty()) {
            throw new NoSuchElementException("A fila está vazia. Não é possível remover.");
        }
        return queue.removeFirst();
    }

    /**
     * Recupera, mas não remove, o primeiro elemento desta fila.
     * @return o primeiro elemento desta fila
     * @throws NoSuchElementException se esta fila estiver vazia
     */
    public T peek() {
        if (isEmpty()) {
            throw new NoSuchElementException("A fila está vazia. Não é possível espiar.");
        }
        return queue.getFirst();
    }

    /**
     * Verifica se a fila está vazia.
     * @return true se a fila estiver vazia, false caso contrário
     */
    public boolean isEmpty() {
        return queue.isEmpty();
    }

    /**
     * Retorna o número de itens na fila.
     * @return o tamanho da fila
     */
    public int size() {
        return queue.size();
    }

    /**
     * Remove todos os elementos da fila.
     */
    public void clear() {
        queue.clear();
    }
}