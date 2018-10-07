/**
 * Created by steven.
 * Date: 7/10/18
 * Problem: https://open.kattis.com/submissions/3239916
 * Tags: 
 * Algo: Bellman-Ford Single Source shortest Path, negative weights
 * TimeComplexity: O(E*V)
 * SpaceComplexity: 
 */
 
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class KattisShortestPathNegativeWeight {
    private static final Scanner scanner = new Scanner(System.in);
    private static final int INFINITY = 100000000;

    public static void main(String[] args) {
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int q = scanner.nextInt();
        int s = scanner.nextInt();

        while (n != 0) {
            solve(n, m, q, s);

            n = scanner.nextInt();
            m = scanner.nextInt();
            q = scanner.nextInt();
            s = scanner.nextInt();
        }

        scanner.close();
    }

    private static void solve(int n, int m, int q, int s) {
        List<int[]> graph = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            int source = scanner.nextInt();
            int target = scanner.nextInt();
            int weight = scanner.nextInt();

            graph.add(new int[]{source, target, weight});
        }


        int[] dist = new int[n];
        Arrays.fill(dist, INFINITY);

        // Find out the minimum spending
        BellmanFordShortestPath(s, n, graph, dist);

        for (int i = 0; i < q; i++) {
            int d = scanner.nextInt();

            if (dist[d] == -INFINITY) {
                System.out.println("-Infinity");
            } else if (dist[d] == INFINITY) {
                System.out.println("Impossible");
            } else {
                System.out.println(dist[d]);
            }
        }
        System.out.println();
    }

    private static void BellmanFordShortestPath(int s, int n, List<int[]> graph, int[] dist) {
        dist[s] = 0;
        int u, v, w;

        for (int i = 0; i < n-1; i++) {
            for (int j = 0 ; j < graph.size(); j ++) {
                u = graph.get(j)[0];
                v = graph.get(j)[1];
                w = graph.get(j)[2];

                if (dist[u] != INFINITY && dist[u] + w < dist[v]) {
                    dist[v] = dist[u] + w;
                }
            }
        }


        // Relax n more times to detect the cycle. The length of the cycle is at most n
        for (int i = 0; i < n; i++) {
            for (int j = 0 ; j < graph.size(); j ++) {
                u = graph.get(j)[0];
                v = graph.get(j)[1];
                w = graph.get(j)[2];

                if (dist[u] != INFINITY && dist[u] + w < dist[v]) {
                    dist[v] = -INFINITY;
                }
            }
        }
    }

}
