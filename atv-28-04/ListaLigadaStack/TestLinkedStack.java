
public class TestLinkedStack {
    public static void main(String[] args) {
        Stack<String> s = new LinkedStack<>();
        check(s.empty(), "pilha nova vazia");

        for (String c : new String[]{"L","A","S","T","I"}) s.push(c);
        eq("I", s.pop(), "");
        eq("T", s.pop(), "");
        eq("S", s.pop(), "");
        eq("A", s.pop(), "");
        eq("L", s.pop(), "");
        check(s.empty(), "vazia ao final");

        // Stress: capacidade ilimitada
        Stack<Integer> big = new LinkedStack<>();
        int N = 100_000;
        for (int i = 0; i < N; i++) big.push(i);
        for (int i = N - 1; i >= 0; i--) eq(i, big.pop(), "stress i=" + i);
        check(big.empty(), "stress: vazia ao final");

        System.out.println("OK -- LinkedStack passou em todos os testes");
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