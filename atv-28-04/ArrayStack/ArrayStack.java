import java . util .*;

public class ArrayStack<T> implements Stack<T> {
    private T[] s; // T[] está generalizando um tipo generico para a criação da pilha na hora da criação obs: a classe é basicamente um array com metodos que simulam uma pilha.
    private int N; // cada operação de push ou pop ele aumenta, no primeiro caso, e diminui no ultimo caso.

    @SuppressWarnings("unchecked")
    public ArrayStack(int maxN) {
        // TODO 1: alocar o array s com capacidade maxN
        //         (use o idiom (T[]) new Object[maxN])
        s = (T[]) new Object[maxN];
        N = 0;
        // TODO 2: inicializar N (numero de elementos atuais)
    }

    @Override
    public boolean empty() {
        // TODO 3: retornar true sse a pilha esta vazia
        if(N == 0) {
            return true;
        }
        return false;
    }

    @Override
    public void push(T item) {
        // TODO 4: inserir item no topo
        s[N++] = item;
    }

    @Override
    public T pop() {
        // TODO 5: remover e retornar o item do topo
        if(N != 0){
            return s[--N];
        }
        return null;
    }
}
