
public class TestLinkedQueue {
    public static void main(String[] args) {
        Queue<String> q = new LinkedQueue<>();
        check(q.empty(), "fila nova deve estar vazia");

        q.put("F"); q.put("I"); q.put("R"); q.put("S"); q.put("T");
        check(!q.empty(), "depois de puts nao pode estar vazia");
        eq("F", q.get(), "FIFO: primeiro a entrar, primeiro a sair");
        eq("I", q.get(), "");
        eq("R", q.get(), "");
        eq("S", q.get(), "");
        eq("T", q.get(), "");
        check(q.empty(), "vazia ao final");

        // Intercalando put/get para verificar o caso de fila esvaziada
        q.put("A"); eq("A", q.get(), "put-get unico");
        check(q.empty(), "vazia depois");
        q.put("B"); q.put("C"); eq("B", q.get(), "");
        q.put("D"); eq("C", q.get(), ""); eq("D", q.get(), "");

        System.out.println("OK -- LinkedQueue passou em todos os testes");
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