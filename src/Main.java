public class Main {
    public static void main(String[] args) {
        boolean[][] graph = {
                {true, false, true, true},
                {true, true, true, false},
                {false, true, false, true},
                {true, true, true, true}
        };

        BFS bfs = new BFS(graph);
        bfs.BFSStart(3);
    }
}