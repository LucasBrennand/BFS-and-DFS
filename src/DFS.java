import java.util.LinkedList;

public class DFS {
    private static final int BRANCO = -1;
    private static final int CINZA = 0;
    private static final int PRETO = 1;

    public int[] ante;
    public int[] i;
    public int[] f;
    public int[] cor;
    public int tempo;
    private boolean[][] grafo;
    private int numVertices;
    private int atual;
    private LinkedList<LinkedList<Integer>> lista;

    public DFS(boolean[][] grafo){
        this.grafo = grafo;
        numVertices = grafo.length;
        cor = new int[numVertices];
        ante = new int[numVertices];
        i = new int[numVertices];
        f = new int[numVertices];
        tempo = 0;
    }

    public void dfs_start(int s){
        for (int v = 0; v < numVertices; v++){
            cor[atual] = BRANCO;
            i[atual] = -2;
            f[atual] = -2;
        }
        tempo = 1;
        dfs_visit(s);
    }
    public void dfs_visit(int u){
        cor[u] = CINZA;
        i[u] = tempo++;
        lista = new LinkedList<>();
        for (int v = 0; v < numVertices; v++){
            if (grafo[u][v] && cor[v] == BRANCO){
                ante[v] = v;
                dfs_visit(v);
            }
        }
        cor[u] = PRETO;
        f[u] =  tempo++;
    }
}
