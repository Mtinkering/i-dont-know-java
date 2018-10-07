/**
 * Created by steven.
 * Date: 7/10/18
 * Problem: https://uva.onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&page=show_problem&problem=1498
 * Tags: 
 * Algo: Look at python solution
 * TimeComplexity: 
 * SpaceComplexity: 
 */
 
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class UvaYCrate {
    private static final Scanner scanner = new Scanner(System.in);
    private static final int INFINITY = 10000000;

    public static void main(String[] args) {
        int n = scanner.nextInt();

        while (n != -1) {
            solve(n);

            n = scanner.nextInt();
        }
    }

    private static void solve(int n) {
        int[] energies = new int[n];
        List<Edge> graph = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int energy = scanner.nextInt();
            energies[i] = energy;

            int doors = scanner.nextInt();

            for (int j = 0; j < doors; j++) {
                int target = scanner.nextInt();
                graph.add(new Edge(i, target - 1, 0));
            }
        }

        for (Edge edge : graph) {
            // Energy spent to go into this room.
            // Positive: spend
            // Negative: gain, or spend a negative one
            edge.weight = -energies[edge.target];
        }

        int s = 0;
        int d = n - 1;
        int[] dist = new int[n];
        int[] path = new int[n];
        Arrays.fill(dist, INFINITY);
        Arrays.fill(path, -1);

        // Find out the minimum spending
        boolean res = BellmanFordShortestPath(s, graph, dist, path, n);

        System.out.println(Arrays.toString(dist));
        // res is false: there is a negative cycle, which means can't reason about this algo
        // or there is a path that costs less than 100
        if (res && dist[d] < 100 && !dieHalfWay(s, d, path, dist)) {
            System.out.println("winnable");
        } else {
            System.out.println("hopeless");
        }
    }

    static private boolean dieHalfWay(int s, int d, int[] path, int[] dist) {
        int b = d;
        while (path[b] != -1) {
            if (dist[b] >= 100) {
                return true;
            } else {
                b = path[b];
            }
        }
        if (b == s) {
            return false;
        } else {
            return true;
        }
    }

    static protected class Edge {
        public int source;
        public int target;
        public int weight;

        public Edge(int source, int target, int weight) {
            this.source = source;
            this.target = target;
            this.weight = weight;
        }
    }

    private static boolean BellmanFordShortestPath(int s, List<Edge> graph, int[] dist, int[] path, int n) {
        dist[s] = 0;
        int u, v, w;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < graph.size(); j++) {
                u = graph.get(j).source;
                v = graph.get(j).target;
                w = graph.get(j).weight;

                if (dist[u] != INFINITY && dist[u] + w < dist[v]) {
                    if (i == n - 1) {
                        return false;
                    } else {
                        dist[v] = dist[u] + w;
                        path[v] = u;
                    }
                }
            }
        }

        return true;
    }
}
