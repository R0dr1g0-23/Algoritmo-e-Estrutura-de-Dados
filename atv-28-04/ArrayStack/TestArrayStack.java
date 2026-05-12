

public class TestArrayStack {
    public static void main(String[] args) {
        Stack<String> s = new ArrayStack<>(10);
        check(s.empty(), "pilha nova deve estar vazia");

        s.push("L"); s.push("A"); s.push("S");
        check(!s.empty(), "depois de 3 push nao pode estar vazia");
        eq("S", s.pop(), "pop deve retornar o ultimo (LIFO)");
        eq("A", s.pop(), "proximo pop");

        s.push("T"); s.push("I");
        eq("I", s.pop(), "");
        eq("T", s.pop(), "");
        eq("L", s.pop(), "");
        check(s.empty(), "todos retirados, deve estar vazia");

        // Genericidade: outra parametrizacao
        Stack<Integer> n = new ArrayStack<>(5);
        n.push(1); n.push(2); n.push(3);
        eq(3, n.pop(), "Integer");
        eq(2, n.pop(), "Integer");

        System.out.println("OK -- ArrayStack passou em todos os testes");
    }

    static void check(boolean cond, String msg) {
        if (!cond) throw new AssertionError("FALHOU: " + msg);
    }
    static <T> void eq(T esp, T obt, String msg) {
        boolean ok = esp == null ? obt == null : esp.equals(obt);
        if (!ok) throw new AssertionError(
            "FALHOU: esperado <" + esp + ">, obtido <" + obt + "> — " + msg);
    }
}