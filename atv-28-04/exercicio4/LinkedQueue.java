import java.util.*;

public class LinkedQueue<T> implements Queue<T> {

    private class Node {
        T item; 
        Node next;
        Node(T item) { 
            this.item = item; 
            this.next = null; 
        }
    }

    private Node head, tail;

    public LinkedQueue() {
        head = null;
        tail = null;
    }

    @Override
    public boolean empty() {
        // TODO 1
        if(head == null) {
            return true;
        }
        return false;
    }

    @Override
    public void put(T item) {
        // TODO 2:
        //   - guarde o tail antigo
        //   - tail = novo Node(item)
        //   - se a fila estava vazia, head = tail
        //   - senao, antigoTail.next = tail
        Node oldTail = tail;
        tail = new Node(item);
        if(empty()){
            head = tail;
        } else {
            oldTail.next = tail;
        }

    }

    @Override
    public T get() {
        // TODO 3:
        //   - salvar head.item
        //   - head = head.next
        //   - retornar o item salvo
        //   (nao se preocupe com tail aqui)
        if(!(empty())) { 
            T obej = head.item;
            head = head.next;
            return obej;
        }
        return null;
    }
}