public class TestQuickFind {
    public static void main(String[] args) {
        // cenario do slide: 6 elementos
        QuickFindUF uf = new QuickFindUF(6);

        check(!uf.find(0, 1), "0 e 1 separados no inicio");
        uf.unite(0, 1);
        check(uf.find(0, 1), "0 e 1 unidos");

        uf.unite(2, 3);
        check(uf.find(2, 3), "2 e 3 unidos");
        check(!uf.find(0, 2), "{0,1} e {2,3} ainda separados");

        uf.unite(0, 3);
        check(uf.find(1, 2), "transitividade: 1-0-3-2");
        check(!uf.find(1, 5), "5 ainda isolado");

        uf.unite(4, 5);
        uf.unite(3, 5);
        for (int i = 0; i < 6; i++)
            for (int j = 0; j < 6; j++)
                check(uf.find(i, j), "tudo conectado: " + i + "-" + j);

        System.out.println("OK -- QuickFindUF passou em todos os testes");
    }
    static void check(boolean cond, String msg) {
        if (!cond) throw new AssertionError("FALHOU: " + msg);
    }
}