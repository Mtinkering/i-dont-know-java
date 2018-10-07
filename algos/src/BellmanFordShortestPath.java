// BellmanFord Algorithm

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BellmanFordShortestPath {
    public static void main(String[] args) {
        int n = 5;
        int[] dist = new int[n];
        int[] path = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);

        int s = 0;
        List<Edge> graph = new ArrayList<>();

        boolean res = BellmanFord(s, dist, graph, n);
    }

    public static boolean BellmanFord(int s, int[] dist, List<Edge> graph, int n) {
        dist[s] = 0;
        int m = graph.size();
        int u, v, w;

        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < m; j++) {
                u = graph.get(j).source;
                v = graph.get(j).target;
                w = graph.get(j).weight;

                if (dist[u] != Integer.MAX_VALUE && (dist[u] + w < dist[v])) {
                    dist[v] = dist[u] + w;
                }
            }
        }

        for (int i = 0; i < m; i++) {
            u = graph.get(i).source;
            v = graph.get(i).target;
            w = graph.get(i).weight;

            if (dist[u] != Integer.MAX_VALUE && (dist[u] + w < dist[v])) {
                return false;
            }
        }

        return true;
    }

    protected class Edge {
        public int source;
        public int target;
        public int weight;

        public Edge(int source, int target, int weight) {
            this.source = source;
            this.target = target;
            this.weight = weight;
        }
    }
}
