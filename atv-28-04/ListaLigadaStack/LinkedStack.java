import java.util.*;

public class LinkedStack<T> implements Stack<T> {

    private class Node {
        T    item;
        Node next;
        Node(T item, Node next) {
            this.item = item;
            this.next = next;
        }
    }

    private Node head;

    public LinkedStack() {
        head = null;
    }

    @Override
    public boolean empty() {
        // TODO 1
        if(head == null){
            return true;
        } 
        return false;
    }

    @Override
    public void push(T item) {
        // TODO 2: criar novo no apontando para head e atualizar head
        head = new Node(item, head); // observe que, o head sempre será o topo da lista, e ele sempre aponta para o objeto que era o head anterior, que antes era o topo.
    }

    @Override
    public T pop() {
        // TODO 3: salvar head.item, avancar head, retornar o salvo
        if(head != null) {
            T salvo = head.item;
            head = head.next; //head.next é um objeto, caso eu quisesse o item seria head.next.item
            return salvo;

        }
        return null;
    }
}