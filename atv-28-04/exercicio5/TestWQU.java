public class TestWQU {
    public static void main(String[] args) {
        // Mesmos testes funcionais do QuickFind
        WeightedQuickUnionUF uf = new WeightedQuickUnionUF(6);
        check(!uf.find(0, 1), "");
        uf.unite(0, 1); check(uf.find(0, 1), "0-1");
        uf.unite(2, 3); check(uf.find(2, 3), "2-3");
        uf.unite(0, 3); check(uf.find(1, 2), "transitividade");
        check(!uf.find(1, 5), "5 isolado");
        uf.unite(4, 5); uf.unite(3, 5);
        for (int i = 0; i < 6; i++)
            for (int j = 0; j < 6; j++)
                check(uf.find(i, j), "tudo conectado: " + i + "-" + j);

        // Comparacao de desempenho com QuickFind
        long t1 = bench(true,  100_000);
        long t2 = bench(false, 100_000);
        System.out.printf("WeightedQuickUnion: %d ms%n", t1);
        System.out.printf("QuickFind         : %d ms%n", t2);
        System.out.printf("Speedup           : %.1fx%n", (double) t2 / Math.max(1, t1));

        System.out.println("OK -- WeightedQuickUnionUF passou em todos os testes");
    }

    static long bench(boolean weighted, int N) {
        java.util.Random r = new java.util.Random(42);
        long t0 = System.currentTimeMillis();
        if (weighted) {
            WeightedQuickUnionUF uf = new WeightedQuickUnionUF(N);
            for (int k = 0; k < N; k++) uf.unite(r.nextInt(N), r.nextInt(N));
        } else {
            QuickFindUF uf = new QuickFindUF(N);
            for (int k = 0; k < N; k++) uf.unite(r.nextInt(N), r.nextInt(N));
        }
        return System.currentTimeMillis() - t0;
    }

    static void check(boolean cond, String msg) {
        if (!cond) throw new AssertionError("FALHOU: " + msg);
    }
}