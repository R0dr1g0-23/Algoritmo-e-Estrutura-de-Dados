public class QuickFindUF {
    private int[] id;

    public QuickFindUF(int N) {
        id = new int[N];
        for (int i = 0; i < N; i++) id[i] = i;
    }

    public boolean find(int p, int q) { 
        // TODO 1
        if(id[p] == id[q]) {
            return true;
        }
        return false;
    }

    public void unite(int p, int q) {
        // TODO 2:
        //   - se ja conectados, nao faz nada
        int idp = id[p];
        int idq = id[q];

        if (find(idp, idq)) {
            return;
        }
        //   - senao, percorre o array e troca todo id[i] == id[p] para id[q]
        for(int i = 0; i < id.length; i++ ) {
            if(id[i] == idp) {
                id[i] = idq;
            }
        }
    }
}