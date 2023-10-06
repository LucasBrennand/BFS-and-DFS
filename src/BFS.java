import java.util.LinkedList;
import java.util.Queue;

public class BFS {
    private static final int BRANCO = -1;
    private static final int CINZA = 0;
    private static final int PRETO = 1;
    public int[] cor;
    public int[] distancia;
    public Integer[] ante;
    public int atual;
    public Queue<Integer> fila;
    public int tamanho_grafo;
    public boolean[][] grafo;

    public BFS(boolean[][] grafo) {
        this.tamanho_grafo = grafo.length;
        this.grafo = grafo;
        cor = new int[tamanho_grafo];
        distancia = new int[tamanho_grafo];
        ante = new Integer[tamanho_grafo];
    }

    public void BFSStart(int s) {
        fila = new LinkedList<>();
        for (int u = 0; u < tamanho_grafo; u++) {
            cor[u] = BRANCO;
            distancia[u] = -1;
            ante[u] = -1;
        }
        cor[s] = CINZA;
        distancia[s] = 0;
        ante[s] = null;
        try {
            fila.add(s);
        }catch (NullPointerException nullPointerException){
            System.out.println("Add errado");
        }

        while (!fila.isEmpty()) {
            this.atual = fila.poll();

            for (int i = 0; i < tamanho_grafo; i++) {
                if (grafo[atual][i] && cor[i] == BRANCO) {
                    cor[i] = CINZA;
                    distancia[i] = distancia[atual] + 1;
                    ante[i] = atual;
                    fila.add(i);
                }
            }
            cor[atual] = PRETO;
        }
        System.out.println("Vértice: " + atual + "Cor: " + cor[atual] + ", Distância " + distancia[atual] + ", Anterior: " + ante[atual]);
    }
}