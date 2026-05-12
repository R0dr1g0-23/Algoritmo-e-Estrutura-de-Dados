public class WeightedQuickUnionUF {
    private int[] id, sz;

    public WeightedQuickUnionUF(int N) {
        id = new int[N];
        sz = new int[N];
        for (int i = 0; i < N; i++) {
            id[i] = i;
            sz[i] = 1;
        }
    }

    private int find(int x) {
        // TODO 1: subir enquanto x != id[x]
        while(x != id[x]){
            x = id[x];
        }
        return x;
    }

    public boolean find(int p, int q) {
        // TODO 2: as raizes coincidem?
        if(find(q) == find(p)){ // condição para saber se eles estão apontando para mesmo "pai"
            return true;
        }
        return false;
    }

    public void unite(int p, int q) {
        // TODO 3:
        //   - i = raiz de p, j = raiz de q
        int i = find(p);
        int j = find(q);
        //   - se i == j, nada a fazer
        //   - se sz[i] < sz[j]: id[i] = j; sz[j] += sz[i]
        //   - senao:            id[j] = i; sz[i] += sz[j]
        if (i == j) {
            return;
        }
        if (sz[i] < sz[j]) {
            id[i] = j;
            sz[j] += sz[i];
        } else {
            id[j] = i;
            sz[i] += sz[j];
        }
    }
}