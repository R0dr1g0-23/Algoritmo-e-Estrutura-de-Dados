public interface Queue<T> {
    boolean empty();
    void    put(T item);   // insere no final (tail)
    T       get();         // remove do inicio (head)
}