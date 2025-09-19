package week11;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BFS {
    private int V; // Số đỉnh
    private List<Integer>[] adj; // Danh sách kề

    public BFS(int V) {
        this.V = V;
        adj = new ArrayList[V];
        for (int i = 0; i < V; i++) {
            adj[i] = new ArrayList<>();
        }
    }

    // Thêm cạnh
    public void addEdge(int u, int v) {
        adj[u].add(v);
        adj[v].add(u);
    }

    // Thuật toán BFS
    public void bfs(int start) {
        boolean[] visited = new boolean[V];
        Queue<Integer> queue = new LinkedList<>();

        visited[start] = true;
        queue.offer(start);

        while (!queue.isEmpty()) {
            int u = queue.poll();
            System.out.print(u + " ");

            for (int neighbor : adj[u]) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    queue.offer(neighbor);
                }
            }
        }
    }

    public static void main(String[] args) {
        BFS g = new BFS(6);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 3);
        g.addEdge(2, 4);
        g.addEdge(3, 5);

        System.out.print("BFS từ đỉnh 0: ");
        g.bfs(0); // Kết quả ví dụ: 0 1 2 3 4 5
    }
}
